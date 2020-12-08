# Spring boot 정리

## Bean이란?

싱글톤 패턴, POJO(Plain Old Java Object)

Spring IoC컨테이너에 의해 생성 및 관리된다.

싱글톤 패턴이란?

Spring 컨테이너에서 한 번 생성되는것.

## IoC(Inversion of Control)란?

객체의 외부에서 사용할 객체를 주입받아 객체간의 의존도를 낮춰주는것.

## Spring IoC컨테이너란?

Inversion of Control(제어권 역전)방법으로

# 어노테이션

@Bean

@Bean(name  = "이름")형식으로 이름지정가능.

@SpringBootApplication

내부에 @SpringBootConfiguration어노테이션 존재.

@SpringBootConfiguration

내부에 @Configuration어노테이션 존재.

결국 @SpringBootApplication을 사용시 사용한 클래스는 Bean으로 등록.

@Entity

## @Component

@Component("이름")으로 이름지정가능.

개발자가 직접 개발한 클래스를 Bean으로 등록하고자 할때 사용.

@Configuration

설정파일 어노테이션, @Component어노테이션을 가지고있음.

1개 이상 Bean을 "등록"하고 있음을 명시하는 어노테이션.

@ComponentScan

main class가 위치한 패키지 이하에서 @Component어노테이션이 붙어있는 클래스를 Bean으로 등록하는 어노테이션. 또는 @ComponentScan(basepackages = "이름")으로 패키지 지정가능.

@EnableAutoConfiguration

어플리케이션에 추가된 설정들을 자동으로 추가해주는 어노테이션.

### @Component의 종류(3가지)

1. @Controller, @RestController

   @Controller

   화면을 리턴

   내부에 @Component어노테이션을 가지고있음.

   @RestController

   데이터를 리턴

   간단히 말하자면 @Controller와 @ResponseBody를 합친것.

2. @Repository

   DAO에 특화된 어노테이션

3. @Service

   내부 자바 로직 처리

@ResponseBody ( @Controller와 사용, 각 메소드마다 있어야함.)

메소드에서 리턴되는값을 View를 통해서 출력하지않고, HTTP Response Body에 직접씀.

동기 Vs 비동기

동기 : 요청과 결과가 한 자리에서 동시에일어남

비동기 : 요청한 그 자리에서 결과가 주어지지않음

# DI(Dpendency injection, 의존성 주입)

## 어노테이션

@Autowired

생성자나 세터 등을 사용하여 의존성 주입을 하려할때, 해당 Bean을 찾아서 주입해주는 어노테이션.

@Primary

동일한 타입의 Bean에 @Primary어노테이션을 붙여주면 우선권을 가지게됨.

@Qualifier

두 개 이상의 Bean이 존재할때(같은 타입) ,@Qualifier("이름")으로 그 Bean을 찾아서 연결

### @Primary보다  @Qualifier가 더 강력함!

## 방법

1. 생성자 주입 방식(추천)

   생성자에 @Autowired 어노테이션을 붙임. 요즘은 안붙여도 됌.

2. Setter 주입 방식

   Setter메소드에 @Autowired 어노테이션을 붙임.

3. 필드 주입 방식

   변수 선언부에 @Autowirde 어노테이션을 붙임.

# 서블릿 컨테이너 | 스프링 컨테이너

## Application Context | BeanFactory (스프링 컨테이너)

### Application Context(BeanFactory보다 향상된버전)

ApplicationContext를 구현하고 있는 클래스들이 객체 관리 및 의존성 주입 가능하게 해준다.

BeanFactory를 상속받고 있다.

### BeanFactory

# 클래스 Bean, 메소드 Bean

웹에서의 스레드와 공유객체

웹에서 싱글톤 객체를 사용하게 되면 망가질 수 있다.

- 객체의 필드가 변할 수 있기 때문이다.
- synchronized 키워드를 붙이면 thread에서 발생하는 문제를 예방할 수 있다.

# VO, DAO, DTO, CRUD란?

1. VO(Value Object) : 읽기 전용(read only)
2. DAO(Data Access Object) : DB에 대한 Insert, Update, Delete, Selete를 처리함.
3. DTO(Data Transfer Object) : 데이터가 포함된 객체를 한 시스템에서 다른시스템으로 전달하는 작업을 처리하는 객체.
4. CRUD : Create(insert), Read(Select), Update, Delete

# TEST

jUnit란?

Java에서 독립된 단위 테스트를 지원해주는 "프레임워크"이다.

단위 테스트란?

소스코드의 특정 모듈이 의도된 대로 정확히 작동하는지 검증하는 절차.

모든 함수와 메서드에 대해 테스트 케이스를 작성하는 절차를 말함.

### 어노테이션

@Test

@Test가 선언된 메서드는 테스트를 수행하는 메서드가 된다.

jUnit는 각각의 테스트가 서로 영향을 주지 않고 독립적으로 실행됨을 원칙으로 함.(Test마다 객체가 생성됨)

@Ignore

@Ignore가 선언된 메서드는 테스트를 실행하지 않게 한다.

@Before

@Before가 선언된 메서드는 @Test메서드가 실행되기 전에 반드시 실행된다.

@Test메서드에서 공통으로 사용하는 코드를 @Before 메서드에 선언하여 사용하면 된다.

@After

@After가 선언된 메서드는 @Test메서드가 실행된 후 실행된다.

@BeforeClass

@BeforeClass가 선언된 메서드는 @Test메서드보다 먼저 한번만 수행되어야 할 경우에 사용하면 된다.

@AfterClass

@AfterClass가 선언된 메서드는 @Test메서드보다 나중에 한번만 수행되어야 할 경우에 사용하면 된다.

@RunWith

MockMvc란?

웹 애플리케이션을 애플리케이션 서버에 배포하지 않고도 스프링 MVC의 동작을 재현할 수 있는 클래스