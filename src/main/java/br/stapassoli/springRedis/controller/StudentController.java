package br.stapassoli.springRedis.controller;

import br.stapassoli.springRedis.entity.Student;
import br.stapassoli.springRedis.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/student")
@RequiredArgsConstructor
public class StudentController {

    private final StudentService studentService;

    @PostMapping
    public ResponseEntity<Student> save(@RequestBody Student student) {
        return ResponseEntity.ok().body(studentService.saveStudent(student));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Student> find(@PathVariable String id) {
        return ResponseEntity.ok().body(studentService.findById(id));
    }

}
