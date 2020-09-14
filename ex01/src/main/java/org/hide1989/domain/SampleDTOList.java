package org.hide1989.domain;

import java.util.ArrayList;
import java.util.List;

import lombok.Data;

@Data

public class SampleDTOList {
	
	private List<SampleDTO> list;
	
	public SampleDTOList() {
		list= new ArrayList<>();
	}

}
//JavaScript 를 이용하는 경우에는 encodeURIComponent()와 같은 방법으로 해결할 수 있으나 현재 예제의 경웅는 %5B %5D 로 변경한다.
//위의 URL을 호출하면 다음과같이 여러개의 Sample DTO 객체를 생성하는것을 볼 수 있다.
//출력된 결과를 보면 3개의 SampleDTO 객체가 생성된 것ㅇ르 볼 수있고, [] 안에 인덱스번호에 맞게 객체의 속성값이 세팅된 것을 확인할 수 있다.

//@initBinder
//파라미터 수집ㅇ르 다른 용어로는 binding 이라고 한다. 변환이 가능한 데이터는 자동으로 변환되지만 경우에따라서는 파라미터를 변환해서 처리해야하는 경우도 존재한다.
//예를들어 화면ㅇ레서 2018-01-01 과 같이 문자열로전달된 데이터를 java.util.Date 타입으로 변환하는 작업이 그러하다. 스프링 Controller 에서는 파라미터를
//바인딩 할  때 자동으로 호출되는 @InitBinder 를 이용해서 이러한 변환을 처리할 수 있다.
//org.hide1989.domain 패키지에 TodoDTO라는 클래스를 작성한다.