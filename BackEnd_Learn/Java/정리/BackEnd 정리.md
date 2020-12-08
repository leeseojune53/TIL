# BackEnd 정리

# EJB(Enterprise Java Bean)

## 기본 구성

1. Enterprise Bean
2. Container
3. EJB Server
4. Client Application

## 종류

1. 세션 빈(Session Bean) : DB연동이 필요없음
2. 엔티티 빈(Entity Bean) : 데이터베이스의 데이터를 관리하는 객체
3. 메시지 구동 빈(Message-driven-Bean) : JMS로 빈을 날려줌

# ORM(Object Relational Mapping)이란?

## 개념

ORM에서 Relational은 개발자가 사용하는 관계형데이터베이스를 의미함.

## 장점

1. 객체지향적인 코드로 인해 더 직관적이고 비즈니스 로직에 더 집중할 수 있게 도와준다.
2. 재사용 및 유지보수의 편리성이 증가
3. DBMS에 대한 종속성이 줄어든다.

## 단점

1. ORM으로만 서비스를 구현하기 어렵다.

추가설명 : http://www.incodom.kr/ORM

# JPA(Java Persistence API)

![image-20201208201629503](.\image\image-20201208201629503.png)

자바 ORM기술에 대한 표준 명세로, JAVA에서 제공하는 API이다.(스프링 X)

자바 어플리케이션에서 관계형 데이터베이스를 사용하는 방식을 정의한 인터페이스이다.

(JPA는 인터페이스이다!!)

기존 EJB에서 제공되던 엔티티 빈을 대체하는 기술이다.

ORM이기때문에 자바 클래스와 DB테이블을 매핑함.

# REST API

# JSP(JavaServer Page)

서블릿과 똑같은기능.

JSP는 HTML페이지 안에서 스크립트 형태로 구현.

뷰 페이지 구현.

## JSP컨테이너?

JSP를 서블릿으로 변환하는 프로그램.

# Servlet(서블릿)

클라이언트가 웹 브라우저를 통해 요청하면 서버에서 실행한 후 결괏값만 클라이언트로 전송.

컨트롤러 페이지 구현

## Servlet컨테이너

클라이언트의 요청에 따라 서블릿을 수행하는 프로그램.

# 어노테이션

@Entity

@Entity를 클래스에 선언하면 그 클래스는 JPA가 관리함.

@Entity(name = "이름")으로 이름 지정가능

@Table

@Table은 맵핑할 테이블을 지정함.

@Table(name = "이름)으로 이름 지정가능

@Column

@Column은 객체 필드와 DB테이블 컬럼을 맵핑함.

@Column(name = "이름")으로 이름 지정가능

@Id

JPA가 객체를 관리할 때 식별할 기본키를 설정.

추가설명 : https://deveric.tistory.com/54

@GeneratedValue

기본키의 값설정.

## Spring AOP

### AOP란?

Aspect-Oriented Programming

흩어진 Aspect들을 모아서 모듈화 하는 기법임.

![image-20201208201643172](.\image\image-20201208201643172.png)

색칠 되어있는 부분을 Concern이라 한다.

만약 노란색 부분을 수정한다고 하면 Class A, B, C를 모두 고쳐야 함.

이것을 간단하게 해결할 수 있는 방법이 AOP.

흩어진 기능들을 모을 때 사용하는것이 Aspect이다. 각각 Concern 별로 Aspect를 만들어 주고, 어느 클래스에서 사용되는지 적어주는 방식.

![image-20201208201654668](.\image\image-20201208201654668.png)

용어 정리

Advice : 해야할 일, 기능을 나타내는 것이다.

Pointcut : 어디(어느 클래스)에 적용되야 하는지를 나타는 것.

Target : 각각 클래스를 나타내는것(적용이 되는 대상).

Join Point : 끼어들 지점.

### 스프링 AOP 특징

프록시 패턴 기반의 AOP 구현체

스프링 빈에만 AOP를 적용할 수 있음.

모든 AOP기능을 제공하는것이 아닌, 스프링 IoC와 연동하여 중복코드, 프록시 클래스 작성의 번거로움, 객체들 간 관계 복잡도 증가에 대한 해결책을 제공하는 것이 목적.

### 스프링 AOP

## Filter란?

## Filter, Interceptor, AOP 차이

![image-20201208201707870](.\image\image-20201208201707870.png)

Interceptor하고 Filter은 Servlet단에서 실행됨.

AOP는 메소드앞에 프록시 형태로 실행됨.

Request가 들어오면 Filter → Interceptor → AOP → Interceptor → Filter순으로 이동함.

## 동기 vs 비동기

동기 : 요청과 그 결과가 동시에 일어남. (순차적)

비동기 : 요청과 그 결과가 동시에 일어나지 않음

블록 vs 논블록

블록 : 비동기를 예로 들면 요청을 보낸 후 결과가 올 때까지 가만히 기다리는것.

논블록 : 비동기를 예로 들면 요청을 보낸 후 결과가 올 때까지 다른것을 하는것.

## N + 1 문제

원인 : 컬렉션에 대한 Lazy로딩때문에 발생.

쿼리가 N+1번 수행되는 문제

JPA에서 해결법

Join Fetch, eager

## 객체지향 5대원칙 SOLID

https://velog.io/@kyle/객체지향-SOLID-원칙-이란

1. S - SRP(Single responsibility principle) 단일 책임 원칙

모든 클래스는 단 하나의 책임을 가진다.(하나의 역할?)

1. O - OCP(Open Closed Principle) 개방 - 폐쇄 원칙

확장에 대해서는 개방되어 있어야 하지만, 수정에 대해서는 폐쇠 되어야한다.

코드에서 변경되어야 하는 부분과 변경되지 않아야 하는 부분을 명확하게 구분하여, 변경되어야 하는 부분을 유연하게 작성하는것을 의미함. 또 확장에는 유연하게 반응하며 변경은 최소화 하는것.

1. L - LSP(Liskov Substitusion Principle) 리스코프 치환 법칙

자식 클래스는 최소한 자신의 부모 클래스에서 가능한 행위를 수행할 수 있어야 한다는 의미.

1. I - ISP(Interface Segregation Principle) 인터페이스 분리 원칙

클라이언트가 자신이 이용하지 않는 메서드에 의존하지 않아야 한다는 원칙

클라이언트 자신이 이용하지 않는 기능에는 영향을 받지 않아야 한다는 내용.

인터페이스를 클라이언트에 특화되도록 분리시키는 원칙

다양한 기능을 인터페이스화함으로써 클라이언트에서 인터페이스를 사용할 때 타 인터페이스의 영향을 받지 않고 본인이 구현하고자 하는 기능만을 선택할 수 있게한다.

1. D - DIP(Dependency Inversion Principle) 의존성 역전 법칙 잘 안바뀌는 인터페이스상속(구현체X)

상위 클래스는 하위 클래스에 의존해서는 안된다는 법칙

변화하기 쉬운 것 또는 자주 변화하는 것보다는 변화하기 어려운 것, 거의 변화가 없는 것에 의존하라는 것.

ISP와 SRP는 동일한 문제를 해결하는 다른 해결책을 제시하고 있는것과 비슷.

OCP DIP, ISP SRP

## 명령형, 함수형 프로그래밍

### 명령형 프로그래밍

how to에 초점

### 함수형 프로그래밍

C, 자바 등 등

무엇에 초점

### Pure function

함수는 입력을 받고 출력을 반환함에 있어 외부의 값에 접근하지 않아야함.

### Higher Order Functions(HOC, HOF)

HOC는 다른 함수를 인자로 사용하거나 함수를 반환하는 함수, 또는 두 가지 특성을 다 가진 함수.

### Currying

Currying은 여러 인자를 받는 함수를 인자 하나씩 사용하여 함수 순서를 실행할 수 있도록 변환하는 것. 람다로 쉽게 구현 가능

```jsx
//non-FP
account.deposit()
user.login()

//FP
deposit(account)
user(User)
```

## No Side Effect

### OOP

Object들로 프로젝트가 구성이되고, 오브젝트들의 연관관계로 만들어짐.

OOP에서 기능의 최소 단위는 모듈로 연관된 오브젝트로 구성되어있고, 오브젝트는 멤버변수와 메소드로 이루어져있다.

즉, 메소드의 수행결과는 멤버변수가 어떤 상태를 가지고 있느가에 따라 결과가 달라짐.

### FP

함수는 input, output이 있고, 각각의 input과 output이 연결 되어 하나의 커다란 output를 만들게 되며 연결하게됨.

순수함수는 항상 동일한 input에 대해 동일한 output을 낸다. 즉, 상태를 가지지 않는다.

모듈화의 최소단위는 함수임.

### OOP Vs FP

OOP와 FP의 차이는 State의 유무

Imperative Vs Declarative

명령형 Vs 선언형

명령형 : 어떤 과정을 통하는가

선언형 : 어떤 결과를 얻는가