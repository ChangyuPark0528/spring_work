package com.spring.myweb.freeboard.dto;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import com.spring.myweb.freeboard.entity.FreeBoard;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter @ToString
@EqualsAndHashCode
public class FreeContentResponseDTO {
	
	
	//bno, title, writer, content, updateDate == null ? regDate(수정됨)
	private int bno;
	private String title;
	private String writer;
	private String content;
	private String updateDate;
	
	public FreeContentResponseDTO(FreeBoard board) {
		super();
		this.bno = board.getBno();
		this.title = board.getTitle();
		this.writer = board.getWriter();
		this.content = board.getContent();
		this.updateDate = makeUpdateString(board.getUpdateDate());
		
	}
	
	
	private String makeUpdateString(LocalDateTime regDate) {
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
		return dtf.format(regDate);
	}
	



	
	
}
