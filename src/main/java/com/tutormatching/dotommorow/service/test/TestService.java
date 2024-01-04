package com.tutormatching.dotommorow.service.test;

import com.tutormatching.dotommorow.repository.test.TestRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 *
 */
@Service
@RequiredArgsConstructor
public class TestService {

    private final TestRepository testRepository;

    public void save(String name) {
        testRepository.save(name);
    }

    public void update(Long id, String name) {
        testRepository.update(id, name);
    }

    public String findById(Long id) {
        return testRepository.findById(id);
    }

    public List<String> findAll() {
        return testRepository.findAll();
    }
}
