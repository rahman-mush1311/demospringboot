package com.mush.demo.dao;

import com.mush.demo.model.Student;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class FakeDaoImpl implements studentdao {
    private final Map<UUID,Student>database;

    public FakeDaoImpl() {
        database = new HashMap<>();
        UUID studentId = UUID.randomUUID();
        database.put(studentId,
                new Student(studentId,
                        14,
                        "john",
                        "snow",
                        "CSE"));
    }

    @Override
    public int insertNewStudent(UUID studentId, Student student) {
        database.put(studentId,student);
        return 1;
    }

    @Override
    public Student selectStudentById(UUID studentId) {
        return database.get(studentId);
    }

    @Override
    public List<Student> selectAllStudent() {
        return new ArrayList<>(database.values());
    }

    @Override
    public int updateStudentById(UUID studentId, Student studentUpdate) {
        database.put(studentId,studentUpdate);
        return 1;
    }

    @Override
    public int deleteStudentById(UUID studentId) {
        database.remove(studentId);
        return 1;
    }
}
