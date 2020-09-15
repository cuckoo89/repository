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
		dto.setName("ȫ�浿");
		
		return dto;
	}
	
	@GetMapping("/ex07")
	public ResponseEntity<String> ex07(){
		log.info("/ex07.......");
		
		//{"name": "ȫ�浿"}
	String msg= "{\"name\":\"ȫ�浿\"}";
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

//������ ������ ���ؼ� ���캸�� �������� �����ϴ� MIME Ÿ���� application/json ���� ó���Ǿ��ִ°��� �� �� �ִ�. ���� jackson-ddatabind ���̺귯��

//�� ���Ե��� �ʾҴٸ� ������ ���� ����ȭ���� ���� �ȴ�. ������ MVC �� ����Ÿ�Կ� �°� �����͸� ��ȯ�� �ִ� ������ ������ �� �ִµ� �⺻������ JSON �� ó���� �ǹǷ�/

//������ ������ �ʿ�� ���� �ʴ�. ������3���������� ������ Convert �� �ۼ��ؾ߸� �ߴ�.

//�޼����� ����Ÿ���� void�� �����ϴ� ��� �Ϲ����� ��쿡�� �ش� URL�� ��θ� �״�� jsp ������ �̸����� ����ϰ� �ȴ�.

//�����޽����� �ڼ��� �� ���� �޽����� ������ /WEB-INF/ view/sample/ex05.jsp �� �������� �ʾƼ� ����� ������°��� �� �� �ִ�. �̰��� servlet-

//context.xml �Ʒ��� ������ ���� �¹��� URL ��θ� View�� ó���ϱ� ������ ����� ����̴�.

//���������� Samplecontroller �� ��ο� ex05() �� ��θ� ��ó /sample/ ex05�� ȣ���ϸ� ���������� ����� ���� �ȴ�.

//SampleController �� Ŭ���� ����ο��� @Controller��� ������MVC ���� ����ϴ� ������̼��� �����ϰ� �ִ�. �ۼ��� SampleController
//Ŭ�������� �׸��� ���� �ڵ����� �������� ��ü(Bean)�� ��ϵǴµ� servlet-context.xml�� �� ������ �ִ�.

//servlet-context.xml ���� <context:componenet-scan>�̶�� �±׸� �̿��ؼ� ������ ��Ű���� ���� (��ĵ) �ϵ��� �Ǿ��ִ�. �ش� ��Ű���� �����
//Ŭ�������� �����ϸ鼭 ���������� ��ü(Bean) ������ ���Ǵ� ������̼ǵ��� ���� Ŭ���� ���� �ľ��ϰ� �ʿ����� �̸� ��ü�� �����ؼ� �����ϰ� �ȴ�.
//SampleController Ŭ������ ���������� �����Ǹ� ȭ��󿡴� Ŭ���� ���� �۰� s ����� �������� �߰��ȴ� Ŭ���� ����ο��� @Controller �� �Բ�
//@RequestMapping�� ���� ����Ѵ�. @RequestMapping �� ���� Ŭ������ �Ӹ�� �޼��� ���� �⺻���� URL ��ΰ� �ȴ�. �������, SampleController
//Ŭ������ ���������� /sample/* �̶�� ��η� �����ߴٸ� ���������� URL�� ���  SampleConroller ���� ó���ȴ�. -/sample/aaa - /sample/bbb
//@RequestMapping ������̼��� Ŭ������ ����� �޼��� ���� ����� �� �ִ�.

//SampleController�� Lombok �� @Log4j�� ����Ѵ�. @Log4j�� @Log�� java.util.Logging �� �̿��ϴµ� ���� Log4j ���̺귯���� Ȱ���Ѵ�.
//spring Legacy project �λ����� ������Ʈ�� �⺻������ Log4j�� �߰��Ǿ������Ƿ� ������ ������ �ʿ����� �ʴ�.

//������Ʈ�� WAS ���� ������ ���� �������� �ν��� �� ���ִ� ������ ��µǴ� ���� ���� �ִµ�, ���Ͱ��� ��쿡�� �Ʒ��Ͱ��� �αװ� ���δ�. src/resources ��������
//log4j.xml �� ���'info'�� 'debug'�� �����ϸ� �Ʒ��Ͱ��� �αװ� ���δ�. ���� ������Ʈ�� ��� / sample �� ȣ���� ������ ��ζ�°��� Ȯ���� �� �ִ�.


//@RequestMapping �� ��ȭ 
//Controller ������̼��� �߰����� �Ӽ��� ������ �� ������, @RequestMapping�� ��� ����� �Ӽ��� �߰��� �� �ֽ��ϴ�. �� �߿����� ���� ���� ����ϴ� 
//�Ӽ��� method �Ӽ��̴�. Method �Ӽ��� ���� GET���, Post����� �����ؼ� ����� �� �̿��Ѵ�. 
//������ 4.3�������ʹ� �̷��� @RequestMapping �� �ٿ��� ����� �� ���ִ� @GetMapping, @PostMapping �� �����ϴµ� ������� ǥ���̹Ƿ�, �Ʒ�
//�Ͱ��� ���ؼ� �н��ϴ°��� ����.

//RequestMapping �� GET,POST ��� ��θ� �����ؾ��ϴ� ��쿡 �迭�� ó���ؼ� ������ �� �ִ�. �Ϲ����� ��쿡 GET, POST ��ĸ��� ��������� �ֱٿ���
//put,delete ��ĵ ���� ���� ����ϰ� �ִ�. @GETMApping �� ��� ���� gET ��Ŀ��� ����� �� �����Ƿ�, �����ϱ�� ������ ��ɿ� ���� ������ ����
//���̴�. Controller �� �ۼ��� �� ���� ���� ����� �Ķ���Ͱ� �ڵ����� �����Ǵ� ����̴�. �� ����� �̿��ϸ� �Ź� Request.getParameter() �� �̿��ϴ�
//�������� ���� �� ���ִ�. ������ ���ؼ� org.hide1989.domain �̶�� ��Ű���� �ۼ��ϰ�, SampleDTO Ŭ������ �ۼ��Ѵ�.

//SampleController �� ��ΰ� /sample/* �̹Ƿ� ex01() �޼��带 ȣ���ϴ� ��δ� '/sample/ex01'�� �ȴ�, �޼��忡�� @GetMapping �� ���Ǿ�����
//�� ,�ʿ��� �Ķ���͸� URL �ڿ�"?name=AAA&age=10" �� ���� ���·� �߰��ؼ� ȣ���� �� �ִ�. ����� ����� ���� SampleDTO ��ü�ȿ� name ��ü�ȿ�
//name �� age �Ӽ��� ����� ������ ���� �� �� �ִ�.Ư�� �ָ��� ���� �ڵ����� Ÿ���� ��ȯ�ؼ� ó���Ѵٴ� ���̴�. ������Ʈ�� ������ ���� �⺻��δ�/controller
//�̹Ƿ� ���� ������ ���� / �� �����ϵ��� �����ؼ� �����ؾ��Ѵ�.
//����Ʈ, �迭 ó�� ������ �̸��� �Ķ���Ͱ� ������ ���޵Ǵ� ��쿡�� ArrayList<> ���� �̿��ؼ� ó�� �����ϴ�.
//���� �����ϴ� �����Ͱ� SampleDTO�� ���� ��ü Ÿ���̰� �������� ó���ؾ��Ѵٸ� �ణ�� �۾��� ���ؼ� �ѹ��� ó���� �� �� �ִ�.������� SampleDTO �� ������ ���޹�
//�Ƽ� ó���ϰ� �ʹٸ� ���������� SampleDTO�� ����Ʈ�� �����ϴ� SampleDTOList Ŭ������ �����Ѵ�
