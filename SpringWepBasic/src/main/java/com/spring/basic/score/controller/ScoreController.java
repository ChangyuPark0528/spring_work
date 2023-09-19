package com.spring.basic.score.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import com.spring.basic.score.dto.ScoreRequestDTO;
import com.spring.basic.score.service.ScoreService;

import lombok.RequiredArgsConstructor;

@Controller
@RequestMapping("/score")
@RequiredArgsConstructor //: final 필드가 존재한다면 그것만을 초기화 해 주는 생성자.
public class ScoreController {
	
	
	private final ScoreService service;
	
	//만약 클래스의 생성자가 단 1개라면
	//자동으로 @Autowired를 작성해 줌.
	
//	@Autowired
//	public ScoreController(ScoreService ss) {
//		service = ss;
//	}
	
	//1. 성적 등록화면 띄우기 + 정보 목록 조회
	@GetMapping("/list")
	public String list() {
		
		return "score/score-list";
	}
	
	//2. 성적 정보 등록 처리 요청.
	@PostMapping("/register")
	public String register(ScoreRequestDTO dto) {
		//단순 데이터 읽기
		System.out.println("/score/register: POST! - " + dto);
		
		//서비스한테 일 시키기  (컨트롤러는 서비스에게 의존적)
		service.insertScore(dto);
		
		return null;
	}
	
}
