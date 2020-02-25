package test.sprint.service;

import org.springframework.data.domain.Page;
import org.springframework.data.repository.query.Param;

import test.sprint.model.Zadatak;

public interface ZadatakService {
	Page<Zadatak> findAll(int pageNum);
	Zadatak findOne(Long id);
	Zadatak save(Zadatak zadatak);
	Zadatak delete(Long id);
	Page<Zadatak> search(
			@Param("imeZadatka") String imeZadatka,
			@Param("sprintID") Long sprintID,
			int pageNum);
	
	
}
