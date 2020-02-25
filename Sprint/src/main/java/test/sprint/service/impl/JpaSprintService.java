package test.sprint.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import test.sprint.model.Sprint;
import test.sprint.repository.SprintRepository;
import test.sprint.service.SprintService;

@Service
@Transactional
public class JpaSprintService implements SprintService {

	@Autowired
	SprintRepository sprintRepository;
	
	@Override
	public List<Sprint> getAll() {
		return sprintRepository.findAll();
	}

	@Override
	public Sprint save(Sprint sprint) {
		return sprintRepository.save(sprint);
	}

	@Override
	public Sprint findOne(Long sprintID) {
		return sprintRepository.findOne(sprintID);
	}

}
