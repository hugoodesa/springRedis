package br.stapassoli.springRedis.service;

import br.stapassoli.springRedis.entity.Student;
import br.stapassoli.springRedis.entity.StudentJPA;
import br.stapassoli.springRedis.repository.StudentJpaRepository;
import br.stapassoli.springRedis.repository.StudentRepository;
import java.util.List;
import java.util.Objects;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@EnableScheduling
@Slf4j
public class StudentService {

    private static final long MINUTOS = 1000 * 60;
    private static final long DELAY = MINUTOS;

    private final StudentJpaRepository studentJPARepository;

    private final StudentRepository repository;

    public Student saveStudent(Student student) {
        return this.repository.save(student);
    }

    public Student findById(String idStudent) {
        return this.repository.findById(idStudent).orElseThrow(() -> {
            throw new RuntimeException("Erro on find student with the given id");
        });
    }

    @Scheduled(fixedDelay = DELAY)
    public void salvarNoH2() {
        List<Student> students = (List<Student>) this.repository.findAll();

        if (students.isEmpty()) {
            log.info("No Students");
            //throw new RuntimeException("no students");
        }

        List<StudentJPA> listToSaveh2 = students.stream().map(student ->
            StudentJPA
                .builder()
                .age(student.getAge())
                .name(student.getName())
                .build()
        ).toList();

        this.studentJPARepository.saveAll(listToSaveh2);
    }

}
