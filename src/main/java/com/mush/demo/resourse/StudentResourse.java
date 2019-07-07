package com.mush.demo.resourse;

import com.mush.demo.model.Student;
import com.mush.demo.service.StudentService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("api/v1/students")
public class StudentResourse {

    private final StudentService studentService;

    public StudentResourse(StudentService studentService) {

        this.studentService = studentService;
    }
    //get all students
    @RequestMapping(
       method = RequestMethod.GET,
       produces = MediaType.APPLICATION_JSON_VALUE
    )
    public List<Student> getAllStudents(){

        return studentService.getAllStudent();
    }
    //get a single student
    @RequestMapping(
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE,
            path = "{studentId}"
    )
    public Student getStudentById(@PathVariable("studentId") UUID studentId){

        return studentService.getStudentById(studentId);
    }
    //insert a new student
    @RequestMapping(
            method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_VALUE
    )
    public void insertNewStudent(@RequestBody Student student){
        studentService.persistNewStudent(UUID.randomUUID(),student);
    }
    //update a student
    @RequestMapping(
            method = RequestMethod.PUT,
            consumes = MediaType.APPLICATION_JSON_VALUE,
            path = "{studentId}"
    )
    public void updateStudentById(@PathVariable("studentId") UUID studentId,@RequestBody Student student){
        studentService.updateStudentById(studentId,student);
    }
    //delete a student
    @RequestMapping(
            method = RequestMethod.DELETE,
            produces = MediaType.APPLICATION_JSON_VALUE,
            path = "{studentId}"
    )
    public void deleteStudentById(@PathVariable("studentId") UUID studentId){

         studentService.deleteStudentById(studentId);
    }
}
