package com.spring.myweb.reply.entity;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/*
    reply_no NUMBER PRIMARY KEY,
    reply_text VARCHAR2(1000) NOT NULL,
    reply_writer VARCHAR2(100) NOT NULL,
    reply_pw VARCHAR2(100) NOT NULL,
    reply_date DATE DEFAULT sysdate,
    bno NUMBER,
    update_date DATE DEFAULT NULL, 
    
CREATE SEQUENCE reply_seq
    START WITH 1
    INCREMENT BY 1
    MAXVALUE 10000
    NOCYCLE
    NOCACHE;
*/

@Getter @Setter @ToString
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Reply {
	
	private int replyNo;
	private int bno;
	
	private String replyText;
	private String replyWriter;
	private String replyPw;
	private LocalDateTime replyDate;
	private LocalDateTime replyUpdateDate;
	
	
}



















