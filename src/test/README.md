



### every { ... }

Starts a block of stubbing. Part of DSL.
Used to define what behaviour is going to be mocked.


Creates new capturing slot.
Slots allow you to capture what arguments a mocked method is called with. 
When mocking a method using `every`, pass the slot wrapped with the `MockKMatcherScope.capture` function in place of a method argument or `MockKMatcherScope.any`.





### 검증 순서 (Verification order)

verifyAll순서를 확인하지 않고 모든 호출이 이루어 졌는지를 확인한다.
verifySequence는 지정된 순서로 호출이 이루어 졌는지를 확인한다.
verifyOrder호출이 특정 순서로 발생했는지 여부를 확인한다.
wasNot Called은 모의 또는 모의 목록이 전혀 호출되지 않았음을 확인한다.