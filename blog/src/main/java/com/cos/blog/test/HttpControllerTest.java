package com.cos.blog.test;

import static org.hamcrest.CoreMatchers.nullValue;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


// 사용자가 요청 -> 응답(HTML 파일)
// @Controller

// 사용자가 요청 -> 응답(Data)
@RestController
public class HttpControllerTest {
	
	// 인터넷 브라우저 요청은 무조건 get 요청만 할 수 있다
	// http://localhost:8080/http/get		/ (select)
	@GetMapping("/http/get")
	public String getTest(Member m) {// 스프링이 알아서 Member의 필드에 매핑해줌
		return "get 요청 : " + m.getId() + ", " + m.getUserName() + ", " + m.getPassword() + ", " + m.getEmail();
	}
	
	// http://localhost:8080/http/post		/ (insert)
	
	// x-www-form-urlencoded 방식
//	@PostMapping("/http/post")
//	public String postTest(Member m) {
//		return "post 요청 : " + m.getId() + ", " + m.getUserName() + ", " + m.getPassword() + ", " + m.getEmail();
//	}
	
	//Raw 방식
	@PostMapping("/http/post")//text/plain -> Raw		/	application/json
	public String postTest(@RequestBody Member m) { //MessageConverter(스프링부트)가 자동으로 일을 해준다
		return "post 요청 : " + m.getId() + ", " + m.getUserName() + ", " + m.getPassword() + ", " + m.getEmail();
	}
	
	// http://localhost:8080/http/put		/ (update)
	@PutMapping("/http/put")
	public String putTest(@RequestBody Member m) {
		return "put 요청 : " + m.getId() + ", " + m.getUserName() + ", " + m.getPassword() + ", " + m.getEmail();
	}
	
	// http://localhost:8080/http/delete		/ (delete)
	@DeleteMapping("/http/delete")
	public String deleteTest() {
		return "delete 요청";
	}
	
}
