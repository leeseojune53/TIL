# Redis

레디스 명령의 인덱스 표현에서 '-1'은 조금 특별하다, -1은 인덱스의 마지막 자리를 의미한다. 음수가 입력되면 인덱스를 맨 마지막 부터 센다. 그러므로 '-2'는 맨 마지막에서 두 번째의 인덱스를 나타낸다.

Java환경에서는 Jedis로 할 수 있다.

Expire설정 : setex(key, exp, value)

## 영속성

### SnapShot(RDB)

정기적으로 데이터베이스의 내용을 디스크에 쓰게됨

redis.conf파일의 파라미터는 save이다.

ex) save 900 1 : 900초 동안 1번 이상 key변경이 발생하면 저장

### Append Only File(AOF)

스냅샷과 겸용하여 사용가능

입력/수정/삭제명령이 실행될 때 마다 기록

Rewrite하면 파일 크기가 작아짐 ex) INCR key 1000(Rewirte하기 전에는 1000번 기록돼있음)을 Rewrite하면 Set key 1000 하나로 기록됨.

AOF파일은 text파일이므로 edit가 가능함

## RDB vs AOF

RDB는 AOF보다 사이즈가 작음 = 로딩속도가 더 빠름