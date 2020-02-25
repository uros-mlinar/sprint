package test.sprint.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import test.sprint.model.Stanje;
import test.sprint.repository.StanjeRepository;
import test.sprint.service.StanjeService;

@Service
@Transactional
public class JpaStanjeService implements StanjeService {

	@Autowired
	StanjeRepository stanjeRepository;
	
	@Override
	public List<Stanje> getAll() {
		return stanjeRepository.findAll();
	}

	@Override
	public Stanje save(Stanje stanje) {
		return stanjeRepository.save(stanje);
	}

	@Override
	public Stanje findOne(Long stanjeID) {
		return stanjeRepository.findOne(stanjeID);
	}

}
