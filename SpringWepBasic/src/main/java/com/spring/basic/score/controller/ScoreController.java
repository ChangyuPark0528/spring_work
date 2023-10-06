package com.spring.basic.score.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.spring.basic.score.dto.ScoreListResponseDTO;
import com.spring.basic.score.dto.ScoreRequestDTO;
import com.spring.basic.score.entity.Score;
import com.spring.basic.score.service.ScoreService;

import lombok.RequiredArgsConstructor;

@Controller
@RequestMapping("/score")
@RequiredArgsConstructor //: final 필드가 존재한다면 그것만을 초기화 해 주는 생성자.
public class ScoreController {
	
	
	private final ScoreService service; //ScoreService 객체에 null을 방지하기위해 final 선언.
	
	//만약 클래스의 생성자가 단 1개라면
	//자동으로 @Autowired를 작성해 줌.
	
//	@Autowired
//	public ScoreController(ScoreService ss) {
//		service = ss;
//	}
	
	//1. 성적 등록화면 띄우기 + 정보 목록 조회
	@GetMapping("/list")
	public String list(Model model) {
		List<ScoreListResponseDTO> dtoList = service.getList();
		model.addAttribute("sList", dtoList);
		return "score/score-list";
	}
	
	//2. 성적 정보 등록 처리 요청.
	@PostMapping("/register")
	public String register(ScoreRequestDTO dto) {
		//단순 데이터 읽기
		System.out.println("/score/register: POST! - " + dto);
		
		//서비스한테 일 시키기  (컨트롤러는 서비스에게 의존적)
		service.insertScore(dto); //scoreService로 이동하여 처리
		
		/*
		 등록 요청이 완료되었다면, 목록을 불러오는 로직을 여기 작성하는게 아니라
		 갱신된 목록을 불러오는 요청이 다시금 들어올 수 있도록 유도를 하자 -> sendRedirect()
		 
		 "redirect:[URL]"을 작성하면 내가 지정한URL로 자동 재요청이 일어나면서
		 점수 등록완료 -> 목록을 달라는 요청으로 유도 -> 목록응답.
		*/
		
		return "redirect:/score/list";
	}
	
	//3. 성적 정보 상세 조회 요청
	@GetMapping("/detail")
	public String detail(int stuNum, Model model) {
		System.out.println("/socre/detail: GET!");
		retrieve(stuNum, model);
		return "score/score-detail";
	}
	
	//4. 성적 정보 삭제 요청
	@GetMapping("/remove")
	public String remove(int stuNum) {
		System.out.println("/score/remove: GET!");
		
		service.delete(stuNum);
		return "redirect:/score/list";
	}
	
	//5. 수정 화면 열어주기.
	@GetMapping("/modify")
	public String modify(int stuNum, Model model) {
		retrieve(stuNum, model);
		return "score/score-modify";
	}
	
	//상세보기, 수정화면 공통 로직을 메서드화
	private void retrieve(int stuNum, Model model) {
		Score score = service.retrieve(stuNum);
		model.addAttribute("s",score);
	}
	
	//6. 수정처리 완료
	@PostMapping("/modify")
	public String modify(int stuNum, ScoreRequestDTO dto) {
		System.out.println("/score/modify: POST!");
		
		service.modify(stuNum, dto);
		
		return "redirect:/score/detail?stuNum=" + stuNum;
	}
	
	
}







