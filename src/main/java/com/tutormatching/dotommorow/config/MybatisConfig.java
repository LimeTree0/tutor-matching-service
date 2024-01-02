package com.tutormatching.dotommorow.config;

import com.tutormatching.dotommorow.repository.TestRepository;
import com.tutormatching.dotommorow.repository.mapper.TestMapper;
import com.tutormatching.dotommorow.service.TestService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
@RequiredArgsConstructor
public class MybatisConfig {

    private final TestMapper testMapper;

    @Bean
    public TestService testService() {
        return new TestService(testRepository());
    }

    @Bean
    public TestRepository testRepository() {
        return new TestRepository(testMapper);
    }
}
