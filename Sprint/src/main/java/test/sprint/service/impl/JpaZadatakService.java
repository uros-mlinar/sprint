package test.sprint.service.impl;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import test.sprint.model.Zadatak;
import test.sprint.repository.ZadatakRepository;
import test.sprint.service.ZadatakService;

@Service
@Transactional
public class JpaZadatakService implements ZadatakService {
	
	@Autowired
	ZadatakRepository zadatakRepository;

	@Override
	public Page<Zadatak> findAll(int pageNum) {
		return zadatakRepository.findAll(new PageRequest(pageNum, 5));
	}

	@Override
	public Zadatak findOne(Long id) {
		return zadatakRepository.findOne(id);
	}

	@Override
	public Zadatak save(Zadatak zadatak) {
		return zadatakRepository.save(zadatak);
	}

	@Override
	public Zadatak delete(Long id) {
		Zadatak zadatak = findOne(id);
		
		if(zadatak == null) {
			throw new IllegalArgumentException("Tried to delete non-existant zadatak.");
		}
		zadatakRepository.delete(id);
		return zadatak;
	}

	@Override
	public Page<Zadatak> search(String imeZadatka, Long sprintID, int pageNum) {
		
		if(imeZadatka != null) {
			imeZadatka = "%" + imeZadatka + "%";
		}
		
		return zadatakRepository.search(imeZadatka, sprintID, new PageRequest(pageNum, 5));
	}

}
