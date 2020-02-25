package test.sprint.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import test.sprint.model.Zadatak;

public interface ZadatakRepository extends JpaRepository<Zadatak, Long> {

	@Query("SELECT z from Zadatak z WHERE "
			+ "(:imeZadatka IS NULL or z.ime LIKE :imeZadatka) AND "
			+ "(:sprintID IS NULL OR z.sprint.id = :sprintID)")
	Page<Zadatak> search(
			@Param("imeZadatka") String imeZadatka,
			@Param("sprintID") Long sprintID,
			Pageable pageRequest);
}
