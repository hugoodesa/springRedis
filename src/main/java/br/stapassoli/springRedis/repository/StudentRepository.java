package br.stapassoli.springRedis.repository;

import br.stapassoli.springRedis.entity.Student;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends CrudRepository<Student, String> {

}
