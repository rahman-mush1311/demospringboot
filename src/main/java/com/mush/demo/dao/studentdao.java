package com.mush.demo.dao;

import com.mush.demo.model.Student;

import java.util.List;
import java.util.UUID;

public interface studentdao {

    int insertNewStudent (UUID studentId, Student student);

    Student selectStudentById(UUID studentId);

    List<Student> selectAllStudent();

    int updateStudentById (UUID studentId, Student studentUpdate);

    int deleteStudentById (UUID studentId);
}
