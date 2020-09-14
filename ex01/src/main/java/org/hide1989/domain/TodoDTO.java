package org.hide1989.domain;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;

@Data

public class TodoDTO {
	
	private String title;
	
	@DateTimeFormat(pattern ="yyyy/MM/dd")
	private Date dueDate;

}
//TodoDTO 에는 특별하게 dueDate 변수의 타입이 java.util.Date 타입이다. 만일 사용자가'2018-01-01' 과 같이 들어오는 데이터를 변환하고자 할때
//문제가발생하게 된다. 이러한 문제를 간단한 해결책은 @InitBinder를 이용하는 것이다.

//@DateTimePormat
//InitBinder 를 이용해서 날짜를 변환할 수도 있지만, 파라미터로 사용되는  인스턴스 변수에 @DateTimeFormat 을 적용해도 가능하다(@DateTimeFormat
//을 이용하는 경우에는 @InitBinder 는 필요하지 않다.)
//ModelAttribute는 강제로 전달받은 파라미터를 Model에 담아서 전달하도록 할 때 필요한 어노테이션이다. @ModelAttribute가 걸린 파라미터는 타입에 관계없이
//무조건 Model에 담아서 전달되므로, 파라미터로 전달된 데이터를 다시 화면에 사용해ㅑ야할 경우에 유용하게 사용된다.

//기존의 코드에서 int 타입의 데이터가 화면까지 전달되지 않았으므로 @ModelAttribute를 추가하면 다음과가튼 형태가 된다.