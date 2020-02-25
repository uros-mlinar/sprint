package test.sprint.service;

import java.util.List;

import test.sprint.model.Sprint;

public interface SprintService {
	List<Sprint> getAll();
	Sprint save(Sprint sprint);
	Sprint findOne(Long sprintID);
}
