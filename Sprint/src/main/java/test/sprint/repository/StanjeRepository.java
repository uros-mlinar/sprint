package test.sprint.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import test.sprint.model.Stanje;

public interface StanjeRepository extends JpaRepository<Stanje, Long> {

}
