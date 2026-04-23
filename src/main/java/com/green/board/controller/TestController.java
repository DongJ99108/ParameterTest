package com.green.board.controller;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Controller
public class TestController {


	
	// http://localhost:8080
	@RequestMapping("/")
	public String home() {
		
		return "home"; // /WEB-INF/views/home.jsp 라는 뜻
		
	} // home end
	
	
	// /temp?a=hello&b=123
	@RequestMapping("/temp")
	public String temp(String a, int b) {
		System.out.println("a=" + a + " b=" + (b+3) ); 
		// " b=" + b+3 으로 바꾸면 1233이라는 값이 나온다 이유는 앞의 " b=" 가 글자이기 때문에 뒤의 b 도 글자로 바꿔서 출력하기 때문( 126을 출력하려면 " b=" + (b+3) ) 라고 적어야함
		return "none";  // none.jsp 없음 -> 404 error
		// none 빼고 공백처리하면 404에러( jsp 파일이 없거나 RequestMapping이 틀렸거나 )가 아닌 500에러가 뜸(500에러 : runtime 에러)
	} // temp end
	
	// /temp1?a=hello&b=123
	@RequestMapping("/temp1")
	public String temp1(HttpServletRequest request,
			HttpServletResponse response) {
		
		String in_a = request.getParameter("a");
		String in_b = request.getParameter("b"); // request.getParameter 는 애초에 String 을 리턴하도록 만들어졌기 때문에 int 가 아닌 String 을 쓰는것
		
		String a = in_a;
		int    b = Integer.parseInt( in_b );
		
		System.out.println( "a=" + a );
		System.out.println( "b=" + ( b + 7 ) );
		
		
		return "none";
	} // temp1
	
	// /temp2?a=hello&b=123
	@RequestMapping("/temp2")
	public String temp2( @RequestParam Map<String, String> map ) {
		
		System.out.println( "map=" + map );
		String a = map.get("a");
		int    b = Integer.parseInt( map.get("b") );
		
		System.out.println( "a=" + a ); 
		System.out.println( "b=" + ( b + 3 ));
		return "none";
	} // temp2 end
	
	// /temp3?a=hello&b=123
	@RequestMapping("/temp3")
	public String temp3(
			@RequestParam("a") String x, @RequestParam("b") int y ) {
		System.out.println( "a=" + x ); 
		System.out.println( "b=" + ( y + 3 ));
		return "none";
	} // temp3 end
	
	// /temp4?a=hello&b=123

} // class end

