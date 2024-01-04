package com.tutormatching.dotommorow.repository.test;

import com.tutormatching.dotommorow.repository.mapper.test.TestMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class TestRepository {

    private final TestMapper testMapper;

    public void save(String name) {
        testMapper.save(name);
    }

    public void update(Long id, String name) {
        testMapper.update(id, name);
    }

    public String findById(Long id) {
        return testMapper.findById(id);
    }

    public List<String> findAll() {
        return testMapper.findAll();
    }
}
