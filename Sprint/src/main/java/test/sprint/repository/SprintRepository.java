package test.sprint.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import test.sprint.model.Sprint;

@Repository
public interface SprintRepository extends JpaRepository<Sprint, Long> {

}
