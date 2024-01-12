package com.tutormatching.dotommorow;

import com.tutormatching.dotommorow.dto.user.UserDto;
import com.tutormatching.dotommorow.dto.user.UserJoinDto;
import com.tutormatching.dotommorow.repository.region.RegionRepository;
import com.tutormatching.dotommorow.service.user.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;

@SpringBootApplication
@RequiredArgsConstructor
public class DotommorowApplication {

	private final UserService userService;

	public static void main(String[] args) {
		SpringApplication.run(DotommorowApplication.class, args);
	}

	// 서버 실행 시 테스트용 유저 생성
	@EventListener(ApplicationReadyEvent.class)
	public void doSomethingAfterStartup() {
		UserJoinDto userDto = new UserJoinDto();
		userDto.setUserId("test");
		userDto.setPassword("test");
		userDto.setSi("서울특별시");
		userDto.setGun("강남구");
		userDto.setGu("삼성동");
		userDto.setGender("M");
		userDto.setAge(20);
		userDto.setUserName("test");
		userDto.setProfileImage("testprofileImage");
		userDto.setPhoneNumber("010-1234-5678");

		userService.save(userDto);
	}

}
