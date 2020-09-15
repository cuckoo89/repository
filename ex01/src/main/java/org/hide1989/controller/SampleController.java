package org.hide1989.controller;

import java.util.ArrayList;

import org.hide1989.domain.SampleDTO;
import org.hide1989.domain.SampleDTOList;
import org.hide1989.domain.TodoDTO;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import lombok.extern.log4j.Log4j;
@Controller
@RequestMapping("/sample/*")
@Log4j
public class SampleController {
	
	@RequestMapping("")
	public void basic() {
		
		log.info("basic..........");
	}
	
	@RequestMapping(value ="/basic",method = {RequestMethod.GET,RequestMethod.POST})
	public void basicGet() {
		log.info("basic get...........");
	}
	
	@GetMapping("/basicOnlyGet")
	public void basicGet2() {
		log.info("basic get only get..........");
	}
	
	@GetMapping("/ex01")
	public String ex01(SampleDTO dto) {
		log.info(""+dto);
		return "ex01";
	}
	
	@GetMapping("/ex02")
	public String ex02(@RequestParam("name") String name,@RequestParam("age") int age) {
		
		log.info("name:" + name);
		log.info("age:"+ age);
		return "ex02";
	}
	
	@GetMapping("/ex02List")
	public String ex02List(@RequestParam("ids1")ArrayList<String>ids) {
		log.info ("ids:" +ids);
		return "ex02List";
	}
	 
	@GetMapping("/ex02Bean")
	public String ex02Bean(SampleDTOList list) {
		
		log.info("list dtos:" + list);
		
		return "ex02Bean";
	}
	
	/*
	 * @InitBinder public void initBinder(WebDataBinder binder) { SimpleDateFormat
	 * dateFormat = new SimpleDateFormat("yyyy-mm-dd");
	 * binder.registerCustomEditor(java.util.Date.class,new
	 * CustomDateEditor(dateFormat,false)); }
	 */
	
	@GetMapping("/ex03")
	public String ex03 (TodoDTO todo) {
		log.info("todo:" + todo);
		return "ex03";
	}
	
	@GetMapping("/ex04")
	public String ex04(SampleDTO dto,@ModelAttribute("page") int page) {
		log.info("dto: " + dto);
		log.info("page " +page);
		return "/sample/ex04";
	}
	
	@GetMapping("/ex05")
	public void ex05() {
		log.info("/ex05.....");
	}
	
	@GetMapping("/ex06")
	public @ResponseBody SampleDTO ex06() {
		log.info("/ex06........");
		
		SampleDTO dto = new SampleDTO();
		dto.setAge(10);
		dto.setName("홍길동");
		
		return dto;
	}
	
	@GetMapping("/ex07")
	public ResponseEntity<String> ex07(){
		log.info("/ex07.......");
		
		//{"name": "홍길동"}
	String msg= "{\"name\":\"홍길동\"}";
			HttpHeaders header = new HttpHeaders();
			header.add("content-Type", "application/json;charset=UTF-8");
			return new ResponseEntity<>(msg, header, HttpStatus.OK);
			
	}
	
	@GetMapping("/exUpload")
	 public void exUpload() {
		log.info("/exUpload.....");
	}
	
	@PostMapping ("/exUploadPost")
	public void exUploadPost(ArrayList<MultipartFile> files) {
		files.forEach(file ->{
			log.info("--------------------------------");
			log.info("name:" + file.getOriginalFilename());
			log.info("size:" + file.getSize());
		});
	}
}

//개발자 도구를 통해서 살펴보면 서버에서 전송하는 MIME 타입이 application/json 으로 처리되어있는것을 볼 수 있다. 만일 jackson-ddatabind 라이브러리

//가 포함되지 않았다면 다음과 같은 에러화면을 보게 된다. 스프링 MVC 는 리턴타입에 맞게 데이터를 변환해 주는 역할을 지정할 수 있는데 기본적으로 JSON 은 처리가 되므로/

//별도의 설정이 필요로 하지 않다. 스프링3버전까지는 별도의 Convert 를 작성해야만 했다.

//메서드의 리턴타입을 void로 지정하는 경우 일반적인 경우에는 해당 URL의 경로를 그대로 jsp 파일의 이름으로 사용하게 된다.

//에러메시지를 자세히 모변 에러 메시지의 원인이 /WEB-INF/ view/sample/ex05.jsp 가 존제하지 않아서 생기는 문제라는것을 볼 수 있다. 이것은 servlet-

//context.xml 아래의 설정과 같이 맞물려 URL 경로를 View로 처리하기 때문에 생기는 결과이다.

//브라우저에서 Samplecontroller 의 경로에 ex05() 의 경로를 합처 /sample/ ex05를 호출하면 다음과같은 결과를 보게 된다.

//SampleController 의 클래스 선언부에는 @Controller라는 스프링MVC 에서 사용하는 어노테이션을 적용하고 있다. 작성된 SampleController
//클래스위의 그림과 같이 자동으로 스프링의 객체(Bean)로 등록되는데 servlet-context.xml에 그 이유가 있다.

//servlet-context.xml 에는 <context:componenet-scan>이라는 태그를 이용해서 지정된 패키지를 조사 (스캔) 하도록 되어있다. 해당 패키지에 선언된
//클래스들을 조사하면서 서프링에서 객체(Bean) 설정에 사용되는 어노테이션들을 가진 클래스 들을 파악하고 필요핟면 이를 객체로 생성해서 관리하게 된다.
//SampleController 클래스가 스프링에서 관리되면 화면상에는 클래스 옆에 작게 s 모양의 아이콘이 추가된다 클래스 선언부에는 @Controller 와 함께
//@RequestMapping을 많이 사용한다. @RequestMapping 은 현재 클래스으 ㅣ모든 메서드 들의 기본적인 URL 경로가 된다. 예를들어, SampleController
//클래스를 다음과같이 /sample/* 이라는 경로로 지정했다면 다음과같은 URL은 모두  SampleConroller 에서 처리된다. -/sample/aaa - /sample/bbb
//@RequestMapping 어노테이션은 클래스의 선언과 메서드 선언에 사용할 수 있다.

//SampleController는 Lombok 의 @Log4j를 사용한다. @Log4j는 @Log가 java.util.Logging 을 이용하는데 반해 Log4j 라이브러리를 활용한다.
//spring Legacy project 로생성한 프로젝트는 기본적으로 Log4j가 추가되어있으므로 별도의 설정이 필요하지 않다.

//프로젝트를 WAS 에서 실행해 보면 스프링이 인식할 ㅅ ㅜ있는 정보가 출력되는 것을 볼수 있는데, 위와같은 경우에는 아래와같이 로그가 보인다. src/resources 폴더내에
//log4j.xml 의 모든'info'를 'debug'로 수정하면 아래와같은 로그가 보인다. 현재 프로젝트의 경우 / sample 는 호출이 가능한 경로라는것을 확인할 수 있다.


//@RequestMapping 의 변화 
//Controller 어노테이션은 추가적인 속성을 지정할 수 없지만, @RequestMapping의 경우 몇가지의 속성을 추가할 수 있습니다. 이 중에서도 가장 많이 사용하는 
//속성이 method 속성이다. Method 속성은 흔히 GET방식, Post방식을 구분해서 사용할 때 이용한다. 
//스프링 4.3버전부터는 이러한 @RequestMapping 을 줄여서 사용할 수 ㅇ있는 @GetMapping, @PostMapping 이 등장하는데 축약형의 표현이므로, 아래
//와같이 비교해서 학습하는것이 좋다.

//RequestMapping 은 GET,POST 방식 모두를 지원해야하는 경우에 배열로 처리해서 지정할 수 있다. 일반적인 경우에 GET, POST 방식만을 사용하지만 최근에는
//put,delete 방식등도 점점 많이 사용하고 있다. @GETMApping 의 경우 오직 gET 방식에만 사용할 수 있으므로, 간편하기는 하지만 기능에 대한 제한은 많은
//편이다. Controller 를 작성할 때 가장 편리한 기능은 파라미터가 자동으로 수집되는 기능이다. 이 기능을 이용하면 매번 Request.getParameter() 를 이용하느
//불편함을 업샐 ㅅ ㅜ있다. 예제를 위해서 org.hide1989.domain 이라는 패키지를 작성하고, SampleDTO 클래스를 작성한다.

//SampleController 의 경로가 /sample/* 이므로 ex01() 메서드를 호출하는 경로는 '/sample/ex01'이 된다, 메서드에는 @GetMapping 이 사용되었으므
//로 ,필요한 파라미터를 URL 뒤에"?name=AAA&age=10" 과 같은 형태로 추가해서 호출할 수 있다. 실행된 결과를 보면 SampleDTO 객체안에 name 객체안에
//name 과 age 속성이 제대로 수집된 것을 볼 수 있다.특히 주목할 점은 자동으로 타입을 변환해서 처리한다는 점이다. 프로젝트를 실행할 때는 기본경로는/controller
//이므로 앞의 예제와 같이 / 로 동작하도록 변경해서 실행해야한다.
//리스트, 배열 처리 동일한 이름의 파라미터가 여러개 전달되는 경우에는 ArrayList<> 등을 이용해서 처리 가능하다.
//만일 전달하는 데이터가 SampleDTO와 같이 객체 타입이고 여러개를 처리해야한다면 약간의 작업을 통해서 한번에 처리를 할 수 있다.예를들어 SampleDTO 를 여러개 전달받
//아서 처리하고 싶다면 다음과같이 SampleDTO의 리스트를 포함하는 SampleDTOList 클래스를 설계한다
