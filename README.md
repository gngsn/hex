# Hex

### Skill Set

- JDK 17, Kotlin
- Spring Boot 3, MySQL, JPA
- Gradle 8

<br/>

### Set PostgreSQL Auth up

```bash
$ export POSTGRES_USER=<<postgres_user>>
$ export POSTGRES_PASSWORD=<<postgres_password>>
```

<br/>

### Create secret.yml in your project

`resources/` 하위에 secret.yml을 생성하고 하기 내용을 추가하세요.

github secret token 은 `Account Icon > Settings > Developer Settings > Personal Access Token` 에서 발급할 수 있습니다.

```bash
github.api.token: <<your_github_secret_token>>
```

<br/>

### Run Docker for PostgreSQL

```bash
$ docker-compose up --detach
```

<br/>

**Create DB Schema**

```bash
$ docker exec -it <<container_id>> bash
# psql -U <<user_id>>
postgres=# CREATE DATABASE hex;
```

