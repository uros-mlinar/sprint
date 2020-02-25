package test.sprint.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import test.sprint.model.Sprint;
import test.sprint.service.SprintService;
import test.sprint.support.SprintDtoToSprint;
import test.sprint.support.SprintToSprintDTO;
import test.sprint.web.dto.SprintDTO;

@RestController
@RequestMapping(value = "api/sprintovi")
public class ApiSprintController {
	
	@Autowired
	SprintService sprintService;
	
	@Autowired
	SprintToSprintDTO toDto;
	@Autowired
	SprintDtoToSprint toSprint;
	
	@RequestMapping(method = RequestMethod.GET)
	ResponseEntity<List<SprintDTO>> getSprints(){
		List<Sprint> sprints = sprintService.getAll();
		
		return new ResponseEntity<>(toDto.convert(sprints), HttpStatus.OK);
	};
	
}
