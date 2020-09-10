package org.hide1989.sample;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import lombok.Data;
import lombok.Setter;

@Component
@Data

public class Restaurant {
	
	
	@Setter(onMethod_=@Autowired)
	private Chef chef;

}

//작성된 코드가 의미하는 것은 Restaurant 객체는 Chef 타입의 객체를 필요로한다는 상황이다.
//@Component 는 스프링에게 해당 클래스가 스ㅎ프링에서 관리해야하는 대상임을 표시하는 어노테이션이고
//@Satter 는 자동으로 setChef()를 컴파일 시 생성한다.

//Setter 에서 사용된 onMathod 속성은 setChef()에 @Autowired 어노테이션을 추가하도록 한다.Lombok으로 생성된 클래스에
//대한 정보는 이클립스를 통해 확인할 수 있다.
