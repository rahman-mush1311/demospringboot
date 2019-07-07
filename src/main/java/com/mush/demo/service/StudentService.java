package com.mush.demo.service;

import com.mush.demo.dao.studentdao;
import com.mush.demo.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class StudentService {
    private final studentdao StudentDao;

    @Autowired
    public StudentService(studentdao studentDao) {
        StudentDao = studentDao;
    }
    public int persistNewStudent (UUID studentId, Student student){
        UUID studentUid = studentId == null ? UUID.randomUUID() : studentId ;
        student.setId(studentUid);
        return StudentDao.insertNewStudent(studentUid, student);
    }

    public Student getStudentById(UUID studentId){
        return StudentDao.selectStudentById(studentId);
    }

    public List<Student> getAllStudent(){
        return StudentDao.selectAllStudent();
    }

    public int updateStudentById (UUID studentId, Student studentUpdate){
        return StudentDao.updateStudentById(studentId,studentUpdate);
    }

    public int deleteStudentById (UUID studentId){
        return StudentDao.deleteStudentById(studentId);
    }
}
