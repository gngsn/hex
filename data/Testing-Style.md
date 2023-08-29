# CHAPTER 6. 단위 테스트 스타일

**TL;DR**

<br/><br/>

---

<br/>

## 1. 단위 테스트의 세 가지 스타일

목표: 함수형 프로그래밍이 출력 기반 테스트와 어떻게 관련돼 있는지 이해할 수 있는 것

<table>
<tr>
<th> 출력 기반 테스트 <br/><small>Output-based testing</small></th>
<th> 상태 기반 테스트 <br/><small>State-based testing</small></th>
<th> 통신 기반 테스트 <br/><small>Communication-based testing</small></th>
</tr>
<tr>
<td>
&#x3A; 테스트 입력 후 <b>반환하는 출력을 검증</b>

<br/><img src="image/image02.png" width="80%" /><br/>

- 전역 상태나 내부 상태를 변경하지 않는 코드에만 적용되므로 반환 값만 검증하면 됨
- 사이드 이펙트가 없고 SUT 작업 결과는 호출자에게 반환하는 값뿐
- 함수형 프로그래밍 functional programming 기반

</td>
<td>
&#x3A; 작업 완료 후 <b>시스템 상태 확인</b>

<br/><img src="image/image03.png" width="80%" /><br/>

빗금이 그려진 원이 최종 상태

- 상태: SUT 협력자 중 하나, 또는 데이터베이스나 파일 시스템 등과 같은 프로세스 외부 의존성의 상태 등

</td>
<td>

&#x3A; Mock을 사용해 <b>테스트 대상 시스템과 협력자 간의 통신 검증</b>

<br/><img src="image/image04.png" width="80%" /><br/>

- SUT 협력자를 목으로 대체하고 SUT가 협력자를 올바르게 호출하는지 검증

</td>
</tr>

<tr>
<td>

```csharp
//  상품 수에 1%를 곱하고 결과를 20%로 제한
public class PriceEngine {
    public decimal CalculateDiscount(params Product[] products) {
        decimal discount = products.Length * 0.01m;
        return Math.Min(discount, 0.2m);
    }
}

[Fact]
public void Discount_of_two_products() {
    var product1 = new Product("Hand wash");
    var product2 = new Product("Shampoo");
    var sut = new PriceEngine();

    decimal discount = sut.CalculateDiscount(product1, product2);

    Assert.Equal(0.02m, discount);
}
```

</td>
<td>

```csharp
public class Order {
    private readonly List<Product> _products = new List<Product>();
    public IReadOnlyList<Product> Products => _products.ToList();

    // AddProduct()의 결과는 주문 상태의 변경
    public void AddProduct(Product product) {
        _products.Add(product);
    }
}

[Fact]
public void Adding_a_product_to_an_order() {
    var product = new Product("Hand wash");
    var sut = new Order();

    sut.AddProduct(product);

    Assert.Equal(1, sut.Products.Count);
    Assert.Equal(product, sut.Products[0]);
}
```

</td>
<td>

```csharp
[Fact]
public void Sending_a_greetings_email() {
    var emailGatewayMock = new Mock<IEmailGateway>();
    var sut = new Controller(emailGatewayMock.Object);

    sut.GreetUser("user@email.com");

    emailGatewayMock.Verify(
        x => x.SendGreetingsEmail("user@email.com"),
        Times.Once);
}
```

Controller 와 IEmailGateway 사이의 (SendGreetingsEmail) 를 통한 협력 검증

</td>
</tr>
</table>

<br/>

## 2. 단위 테스트 스타일 비교

> <b>좋은 단위 테스트의 4대 요소</b> <br/>
> : 회귀 방지 / 리팩터링 내성 / 빠른 피드백 / 유지 보수성

<br/>

### ✔️ ≪회귀 방지 지표≫ 로 스타일 비교

- **회귀 방지 지표**를 결정하는 세 가지 특성
    - **테스트 중 실행되는 코드의 양** _amount of code executed during the test_
    - **코드 복잡도** _code’s complexity_
    - **도메인 유의성** _domain significance_
- 보통 위 세 특성에 대해, 어떤 스타일도 딱히 이점은 없음
- 예외: Communication-based style
    - 작은 부분의 코드 조각만을 검증하고, 모두 목을 사용하는 등 의미없는 *shallow* 테스트가 될 수 있음
    - 다만, 모든 Communication-based style 를 단정짓는 특징이 아니라, 극단적인 케이스를 말하는 것
    - (not definitive feature, but rather is extreme case)

참고: 번역에서 말하는 '피상적인 테스트'는 shallowness를 의역. 얕은 의미의 테스트로, 역자는 이를 피상적, 즉 형식적인 테스트라고 번역

<br/>

### ✔️ ≪피드백 속도 지표≫ 로 스타일 비교

- 테스트 스타일과 테스트 피드백 속도 사이에는 상관관계가 거의 없음
    - 거의 모든 스타일이 테스트 실행 속도가 거의 동일

<br/>

### ✔️ ≪리팩터링 내성 지표≫ 로 스타일 비교하기

> 리패터링 내성: 리팩터링 중에 발생하는 거짓 양성(허위 경보) 수에 대한 척도

- 거짓 양성은 코드의 구현 세부 사항에 결합된 테스트의 결과

| <b>출력 기반 테스트 <br/><small>Output-based testing</small></b> | <b>상태 기반 테스트 <br/><small>State-based testing</small></b>                         | <b> 통신 기반 테스트 <br/><small>Communication-based testing</small></b>                                                                              |
|-----------------------------------------------------------|----------------------------------------------------------------------------------|--------------------------------------------------------------------------------------------------------------|
| 대상 메서드에만 결합<br/>👉🏻 거짓 양성에 우수                            | 일반적으로 거짓 양성이 되기 쉬움<br/>상태 기반 테스트는 큰 API 노출 영역에 의존<br/>👉🏻 구현 세부 사항과 결합할 가능성도 높음 | 허위 경보에 가장 취약<br/>- 스텁과 상호 작용하는 경우를 나타냄 👉🏻상호작용 테스트 X<br/>- 애플리케이션 외부와의 상호 작용에 부작용이 보이는 경우에만 Mock을 사용할만 함    |


<br/>

### ✔️ ≪유지 보수성 지표≫ 로 스타일 비교하기

단위 테스트 유지비를 측정

- 테스트를 이해하기 얼마나 어려운가 👉🏻 테스트 사이즈
    - 테스트가 크면, 코드를 파악하기도 변경하기도 어려움 -> 유지 보수 어려움
- 테스트를 실행하기 얼마나 어려운가 👉🏻 테스트가 얼마나 많은 외부 의존성과 직접적으로 의존되는지
    - 외부 의존성은 외부 리소스 운영에 시간이 필요하기 때문에 유지보수 어려움


| <b>출력 기반 테스트 <br/><small>Output-based testing</small></b> | <b>상태 기반 테스트 <br/><small>State-based testing</small></b> | <b> 통신 기반 테스트 <br/><small>Communication-based testing</small></b> |
|-----------------------------------------------------------|----------------------------------------------------------|------------------------------------------------------------------|
|                             |                                                          |                                                                  |



<br/>



<br/><br/>



