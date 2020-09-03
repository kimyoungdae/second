package com.mythree.myapp.first;

import org.springframework.stereotype.Controller;

@Controller
public class firstController {

	@RequestMapping("/animal")
	public String fortune(HttpServletRequest request) {
		//1. 오늘의 운세를 얻어오는 비즈니스 로직을 처리한다.
		String animal="동쪽으로 가면 귀인을 만나요";
		//2. 로직 처리결과 데이터(model) 을 request  영역에 담는다.
		request.setAttribute("animal", animal);
		//3. view 페이지(jsp) 페이지로 forward 이동해서 응답한다.
		return "animal"; // "/WEB-INF/views/fortune.jsp" 
	}
}
