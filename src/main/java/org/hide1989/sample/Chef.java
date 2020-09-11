package org.hide1989.sample;

import org.springframework.stereotype.Component;

import lombok.Data;

@Component
@Data

//일반적으로 스프링에서 의존성 주입은 Chef를 클래스가 아닌 인터페이스로 설계하는 것이 좋지만, 지금은 최소한의 코드
//로 의존성 주입을 테스트 해보기 위한 것이므로 클래스를 설계한다.
public class Chef {

}
//Restaurant 클래스는  Chef를 주입받도록 설계한다. 이때 Lombok의 setter를 생성하는 기능과 생성자, toString()
//등을 자동으로 생성하도록 @Data 어노테이션을 이용한다.
// 작성한 2개의 클래스와 'root-context.xml'이 어떻게 동작하는지 이해하기 위해서는 스프링과 함께 사간의 순서대로 고민해보아야한다
// 스프링이 동작한다는 가정하에 스플이에서 어떤일들이 벌어지는 지 그림으로 정리해보면다음과 같다
//스프링 프레임워크가 시작되면 먼저 스프링이 사용하는 메모리 영역을 만들게 되는데 이를 컨텍스트라고 한다. 스프링에서는 ApplicationContext라는
//이름의 객체가 만들어진다.

//스프링은 자신이 객체를 생성하고 관리해야하는 객체들에대한 설정이 필요하다. 이에대한 설정이 Root-context.xml이다.
//root-context.xml에 설정되어있는 <context:component-scan> 테그의 내용을 통해서'org.hide1989.sample'패이지를 스캔하기 시작한다.
//해당 패키지에 있는 클래스들 중에서 스프링이 사용하는 @Component 라는 어노테이션이 존재하는 클래스의 인스턴스를생성한다.
//Restaurant 객체는 Chef객체가 필요하다는 어노테이션 @Autowired설정이 있으므로 스프링은 Chef 객체의 레퍼런스를 Restaurant 객체에 주입한다.
// 그럼 그림대로 동작하는지를 테스트하기 위해서는 직접 main 메서드를 만드는 방식도 있지만 좀더 간편하게 테스트 코드를 작성하는 방법을 사용하는 것이 좋다.
