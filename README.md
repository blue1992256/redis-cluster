# Redis Cluster를 활용한 간단한 CRUD 구현

### 구성 환경
* Springboot 3.0.2
* JAVA 17
* Redis 7.0.8

### Redis
3개의 서버로 클러스터링을 한다는 상황 가정 후 각각의 서버에 master, slave 으로 redis 2개씩 설치
```
Master  : 127.0.0.1:16001 | 127.0.0.1:17001 | 127.0.0.1:18001
Slave   : 127.0.0.1:18002 | 127.0.0.1:16002 | 126.0.0.1:17002
```

### RedisTemplate
가장 기본적인 Strings 타입으로 key-value CRUD 구현

### RedisRepository
JPA 처럼 entity 를 사용하여 CRUD 구현


