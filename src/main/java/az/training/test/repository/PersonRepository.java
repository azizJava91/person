package az.training.test.repository;

import az.training.test.entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PersonRepository extends JpaRepository<Person, Integer> {
    Person findByIdAndActive(Long id, Integer active);

   List<Person> findAllByActive(Integer active);
}
