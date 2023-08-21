package br.stapassoli.springRedis.repository;

import br.stapassoli.springRedis.entity.Student;
import br.stapassoli.springRedis.entity.StudentJPA;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentJpaRepository extends JpaRepository<StudentJPA, Long> {

}
