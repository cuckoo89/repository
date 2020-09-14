package org.hide1989.domain;

import lombok.Data;

@Data

public class SampleDTO {
	
	private String name;
	private int age;
	

}

//Sample DTO 클래스는 Lombok 의 @Data 어노테이션을 이용해서 처리한다. @Data를 이용하게 되면 getter/setter, dquals(), toString() 등의
//메서드를 자동으로 생성하기때문에 편리하다

//SampleController 의 메서드가 SampleDTO를 파라미터로 사용하게되면 자동으로 Setter 메서드가 동작하게 되면서 파라미터를 수집하게 됨 (이를 확인해보고)
//싶으면 set 메서드를 제작하고 set 메서드 내 간단한 로그 등을 출력해 보면 확인할 수 있다.

//파라미터의 수집과 변환
// Controller 가 파라미터를 수집하는 방식은 파라미터 타입에 따라 자동으로 변환하는 방식을 이용한다. 예를들어 SampleDTO에는int 타입으로age가 자동으로
// 숫자로 변환되는것을 볼 수 있다.
// 만일 자료형이나 문자열 등을 이용한다면 파라미터의 타입만을 맞게 선언해주는 방식을 사용할 수 있다.
//ex04() 는 SampleDTO 타입과 int 타입의 데이터를 파라미터로 사용한다. 결과를 확인하기 위해서 WEB-INF/views 폴더아래 sample 폴더를 생성하고 리턴
//값에서 사용한 ex04에 해당하는 ex04.jsp 를 작성한다.