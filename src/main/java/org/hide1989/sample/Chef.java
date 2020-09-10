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