package com.tanim.demo.controller;

import com.tanim.demo.Entity.Student;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/student")
public class StudentRestController {

    @GetMapping("/getOne")
    public ResponseEntity<Student> getStudent()
    {
        Student s1=new Student(1,"Marry","Grace");
        return ResponseEntity.ok().header("customer-header","Marry").body(s1);
    }

    @GetMapping("/all")
    public List<Student> getStudents()
    {
        List<Student> students=new ArrayList<>();
        students.add(new Student(1,"Ibrahim","Adnan"));
        students.add(new Student(2,"Mariya","halse"));
        return students;
    }
    @GetMapping("/{id}/{firstname}")
    public Student findStudent(@PathVariable int id,@PathVariable String firstname)
    {
        return  new Student(id,firstname,"Grace");
    }
    //http://localhost:8080/student/query?id=1&firstName="Marry"
    @GetMapping("/query")
    public Student findQuery(@RequestParam int id,@RequestParam String firstName)
    {
        return  new Student(id,firstName,"Grace");
    }

    //Creating Student object from postman
    //@ResponseStatus will give you the proper response in postman after creating an entity
    //@RequestBody will bind post data into entity object
    @PostMapping("/create")
    @ResponseStatus(HttpStatus.CREATED)
    public Student createStudent(@RequestBody Student student)
    {
        System.out.println(student.getFirstName());
        System.out.println(student.getLastName());
        return student;
    }

}
