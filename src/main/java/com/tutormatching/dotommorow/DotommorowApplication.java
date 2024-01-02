package com.tutormatching.dotommorow;

import com.tutormatching.dotommorow.config.MybatisConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

@Import(MybatisConfig.class)
@SpringBootApplication
public class DotommorowApplication {

	public static void main(String[] args) {
		SpringApplication.run(DotommorowApplication.class, args);
	}

}
