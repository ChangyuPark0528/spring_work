package com.spring.myweb.user.mapper;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

import java.time.LocalDateTime;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.spring.myweb.user.entity.User;

@ExtendWith(SpringExtension.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
public class UserMapperTest {
	
	@Autowired
	private IUserMapper mapper;
	
	/*
	private String userId;
	private String userPw;
	private String userName;
	private String userPhone1;
	private String userPhone2;
	private String userEmail1;
	private String userEmail2;
	private String addrBasic;
	private String addrDetail;
	private String addrZipNum;
	private LocalDateTime regDate;
	*/
//	@Test
//    @DisplayName("회원 가입을 진행했을 때 회원가입이 성공해야 한다.")
//    void registTest() {
//		mapper.join(User.builder()
//						.userId("test")
//						.userPw("aa1234")
//						.userName("kim")
//						.userPhone1("010-1234-5678")
//						.userPhone2("02-111-2222")
//						.userEmail1("kim1234")
//						.userEmail2("kim5678")
//						.addrBasic("si")
//						.addrDetail("dong")
//						.addrZipNum("1234567")
//						.build());
//    }
	
	@Test
    @DisplayName("회원 가입을 진행했을 때 회원가입이 성공해야 한다.")
    void registTest() {
		User user = User.builder() //객체먼저 생성후 빌더로 값 입력.
				.userId("abc1234")
				.userPw("kkk1111!")
				.userName("김철수")
				.userPhone1("010")
				.userPhone2("12345678")
				.userEmail1("abc1234")
				.userEmail2("naver.com")
				.addrBasic("서울특별시 마포구")
				.addrDetail("백범로 22 지하1층")
				.addrZipNum("04091")
				.build();
		mapper.join(user); // 맵퍼에게 해당값 입력
    }
    
    @Test
    @DisplayName("존재하는 회원 아이디를 조회했을 시 1이 리턴되어야 한다.")
    void checkIdTest() {
    	String id = "abc1234";
    	
    	assertEquals(1, mapper.idCheck(id));
    }
    
    @Test
    @DisplayName("존재하는 회원 아이디를 입력 했을 시 그 회원의 비밀번호가 리턴되어야 한다.")
    void loginTest() {
        String id = "abc1234";
        
        assertNotNull(mapper.login(id));
        assertEquals("aaa1111!", mapper.login(id));
    }
    
    @Test
    @DisplayName("존재하지 않는 회원의 아이디를 전달하면 null이 올 것이다.")
    void getInfoTest() {
        assertNull(mapper.getInfo("merong"));
    }
    
    @Test
	@DisplayName("id를 제외한 회원의 정보를 수정할 수 있어야 한다.")
	void updateTest() {
		User user = User.builder()
				.userId("abc1234")
				.userPw("aaa1111!")
				.userName("홍수정")
				.userEmail1("abc4321")
				.userEmail2("gmail.com")
				.addrBasic("서울특별시 강동구")
				.addrDetail("풍성로41길 64-19")
				.addrZipNum("05383")
				.build();
		mapper.updateUser(user);
		
		assertEquals(user.getUserEmail1(), mapper.getInfo("abc1234").getUserEmail1());
	}
}
