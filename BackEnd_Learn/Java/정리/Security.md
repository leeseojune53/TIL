# Security

HMAC 인증이란?

![image-20201208201316339](C:\Users\sung0\AppData\Roaming\Typora\typora-user-images\image-20201208201316339.png)

## FilterChain(필터체인)이란?

### Filter

Filter는 요청(Request)와 응답(Response)에 대한 정보들을 변경할 수 있게 개발자들에게 제공하는 서블릿 컨테이너임.

FilterChain은 이런 Filter들이 모여서 만들어짐.

## Wrapper Class

## Spring Security

## CSRF(Cross-site request forgery)

![image-20201208201338366](C:\Users\sung0\AppData\Roaming\Typora\typora-user-images\image-20201208201338366.png)

## Authentication(인증)

## 인터페이스

UserDetailsService

DB에서 유저정보를 가지고 오는 역할.

## JWT

Access Token : 유효기간이 짧고, 짧은 유효기간안에만 사용이 가능, 서버단에서 통제 불가능.

Refresh Token : Access Token의 유효기간이 끝나면 DB에 저장되어있는 Refresh Token과 확인하고, 같을 떄 새로운 Access Token을 발급해줌, 서버단에서 통제가능, 클라이언트단에서는 안전한 스토리지에 저장.

탈취당한 Refresh Token

Q. 왜 굳이 2개를 사용해야 하는가..? Access Token이 탈취당하는거랑 뭐가 다른건지

A. Access Token만 사용할 시 서버단에서 통제할 수 없음. 만약 Refresh Token이 탈취당했다면, 그 Refresh Token을 무효화 시킬 로직이 필요함. 따라서 DB와 같은 스토리지에 Refresh Token을 저장하고, Access Token을 발급해야할 때 DB에 있는 Refresh Token과 비교를 해서 같으면 Access Token을 발급해준다. 탈취당했을 때 DB에 있는 Refresh Token만 삭제해주면 됌.

슬라이딩 세션  : 세션을 지속적으로 이용하는 유저에게 자동으로 만료기간을 늘려주는 것.