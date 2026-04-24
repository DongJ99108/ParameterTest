package com.green.board.controller;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.green.board.vo.DataVo;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Controller
public class TestController {


	
	// http://localhost:8080  ==  "/"
	@RequestMapping("/")
	public String home() {
		
		return "home"; // /WEB-INF/views/home.jsp 라는 뜻
		
	} // home end
	
	
	// /temp?a=hello&b=123
	@RequestMapping("/temp")
	public String temp(String a, int b) {
		System.out.println("a=" + a + " b=" + ( b + 3 ) ); 
		return "none";  // none.jsp 없음 -> 404 error
		// none 빼고 공백처리하면 404에러( jsp 파일이 없거나 RequestMapping이 틀렸거나 )가 아닌 500에러가 뜸(500에러 : runtime 에러)
	} // temp end
	
	// 여기서 a와 b는 home.jsp에 입력된 값을 기준으로 정해진다. ( <a href="/temp?a=hello&b=123">temp</a> ) < 여기에 들어있는 값을 말하는 것
	
	
	/*
	@RequestMapping("/temp")
	public String temp(String b, int a) {
		System.out.println("a=" + a + " b=" +  b ); 
		// " b=" + b+3 으로 바꾸면 1233이라는 값이 나온다 이유는 앞의 " b=" 가 글자이기 때문에 뒤의 b 도 글자로 바꿔서 출력하기 때문( 126을 출력하려면 " b=" + (b+3) ) 라고 적어야함
		return "none";  // none.jsp 없음 -> 404 error
		// none 빼고 공백처리하면 404에러( jsp 파일이 없거나 RequestMapping이 틀렸거나 )가 아닌 500에러가 뜸(500에러 : runtime 에러)
	} // temp end
	*/
	
	// /temp1?a=hello&b=123
	@RequestMapping("/temp1")
	public String temp1(
			HttpServletRequest request,
			HttpServletResponse response
			) {
		
		String in_a = request.getParameter("a");
		String in_b = request.getParameter("b"); // request.getParameter 는 애초에 String 을 리턴하도록 만들어졌기 때문에 int 가 아닌 String 을 쓰는것
		
		String a = in_a;
		int    b = Integer.parseInt( in_b );
		// request.getParameter()는 무조건 String 으로 리턴하기 때문에 받는 값이 int 라면 Integer.parseInt 처리를 해줘야한다. 
		
		System.out.println( "a=" + a );
		System.out.println( "b=" + ( b + 7 ) );
		
		
		return "none";
	} // temp1
	
	// /temp2?a=hello&b=123
	@RequestMapping("/temp2") 
	public String temp2( @RequestParam Map<String, String> map ) { // @RequestParam 리퀘스트한것을 맵에 넣겠다.
		
		System.out.println( "map=" + map ); // map = {a=hello, b=123}
		String a = map.get("a");
		int    b = Integer.parseInt( map.get("b") );
		
		System.out.println( "a=" + a ); 
		System.out.println( "b=" + ( b + 3 ));
		return "none";
	} // temp2 end
	
	// 요즘 Springboot 가 인자를 처리하는 방식
	// /temp3?a=hello&b=123
	@RequestMapping("/temp3")
	public String temp3(
			@RequestParam("a") String x, @RequestParam("b") int y ) {
		System.out.println( "a=" + x );
		System.out.println( "b=" + ( y + 2 ));
		return "none";
	} // temp3 end
	
	// /temp4?a=hello&b=123
	@RequestMapping("/temp4")
	public String temp4(DataVo vo) {
		String  a  =  vo.getA();
		int     b  =  vo.getB();
		System.out.println( "a=" + a );
		System.out.println( "b=" + ( b + 4 ) );
		return "none";
	}
	
	// ---------------------------------------------------------------------
	// 넘겨받은 값을 처리해서 jsp 에 넘기는 방법
	// Model 을 사용한다.
	// jsp 에 넘겨줄 데이터를 Model class 에 담아서 전달 -> jsp ${}
	// temp5?a=hello&b=123
	@RequestMapping("/temp5")
	public   String   temp5( String a, int b, Model model ) {
		System.out.println( "a=" + a );
		System.out.println( "b=" + ( b * 3 ) );
		
		model.addAttribute("a", a);
		model.addAttribute("b", b);
		model.addAttribute("c", "이것도 넘어가나요 담장을 넘깁니다"); // 이건 됨
		model.addAttribute("d", "쓰리런"); // 이건 안됨
		
		return "reqdata";
		
	} // 여기서 reqdata.jsp를 쓴다.
	
	// temp6?a=hello&b=123
	@RequestMapping("/temp6")
	public String temp6(DataVo vo, Model model) {
		String  a  =  vo.getA();
		int     b  =  vo.getB();
		System.out.println("a=" + a);
		System.out.println("b=" + b);
		
		model.addAttribute("a", a);
		model.addAttribute("b", b-7);
		model.addAttribute("c", 565);
		
		return "reqdata";
	}
	
	// temp7?a=hello&b=123
	@RequestMapping("/temp7")
	public String temp7(
			@ModelAttribute("attrName") DataVo vo, 
			Model model
			) {
		
		System.out.println( "a=" + vo.getA() );
		System.out.println( "b=" + vo.getB() );
		
		model.addAttribute("a", vo.getA() );
		model.addAttribute("b", vo.getB() );
		
		return "noneModel";
	}
	
	// ---------------------------------------------------------------------
	// Path Variable : 경로에 data 를 포함시키는 방법
	// 주의 @PathVariable 생략하면 error
	// /temp8/hello/123
	// /temp8/123/list
	@RequestMapping("/temp8/{a}/{b}") // {} = 주소가 아니라 데이터라는 뜻
	public  String  temp8(
		@PathVariable("a")  String a,
		@PathVariable("b")  int    b
			) {
		
		System.out.println("a=" + a);
		System.out.println("b=" + ( b - 23 ) );
		
		
		return "none";
	}
	
	// /temp9/123/list
	// @PathVariable 생략이 가능하다
	@RequestMapping("/temp9/{a}/{b}")
	public  String  temp9( DataVo vo ) {
			
		System.out.println("a=" + vo.getA() );
		System.out.println("b=" + vo.getB() );
			
		return "none";
		}
	

	///temp10/123/list
	// @PathVariable 생략이 가능하다
	@RequestMapping("/temp10/{a}/{b}")
	public  String  temp10( 
			@ModelAttribute("vo") DataVo vo, 
			Model model
			) {
			
		System.out.println("a=" + vo.getA() );
		System.out.println("b=" + vo.getB() );
			
		return "noneModel";
		}
	
	
	

} // class end



















