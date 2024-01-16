package com.tutormatching.dotommorow;

import com.tutormatching.dotommorow.dto.user.student.StudentSaveDto;
import com.tutormatching.dotommorow.dto.user.teacher.TeacherSaveDto;
import com.tutormatching.dotommorow.dto.user.user.UserJoinDto;
import com.tutormatching.dotommorow.service.user.StudentService;
import com.tutormatching.dotommorow.service.user.TeacherService;
import com.tutormatching.dotommorow.service.user.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
@RequiredArgsConstructor
public class DotommorowApplication {

	private final UserService userService;
	private final TeacherService teacherService;
	private final StudentService studentService;

	public static void main(String[] args) {
		SpringApplication.run(DotommorowApplication.class, args);
	}

	// 서버 실행 시 테스트용 유저 생성
	@EventListener(ApplicationReadyEvent.class)
	public void doSomethingAfterStartup() {
		// 유저 등록
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

		// 선생님 등록
		TeacherSaveDto teacherSaveDto = new TeacherSaveDto();
		teacherSaveDto.setUserId("test");
		teacherSaveDto.setRegionId(1);
		teacherSaveDto.setYail("월요일");
		LocalTime localTime = LocalTime.of(10, 0, 0, 0);
		teacherSaveDto.setTime(localTime);
		teacherSaveDto.setComment("test");
		teacherSaveDto.setClassLevel("고등학교");
		List<String> category = new ArrayList<>();
		category.add("수학");
		category.add("여어");
		teacherSaveDto.setCategory(category);
		teacherSaveDto.setAcademic("대학교");

		teacherService.save(teacherSaveDto);

		//학생 등록
		StudentSaveDto studentSaveDto = new StudentSaveDto();
		studentSaveDto.setUserId("test");
		studentSaveDto.setRegionId(1);
		studentSaveDto.setYail("월요일");
		studentSaveDto.setTime(localTime);
		studentSaveDto.setRange("2km");
		studentSaveDto.setClassLevel("고등학교");
		studentSaveDto.setCategory(category);
		studentSaveDto.setAcademic("대학교");

		studentService.save(studentSaveDto);
	}

}
