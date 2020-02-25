package test.sprint.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import test.sprint.model.Stanje;
import test.sprint.service.StanjeService;
import test.sprint.support.StanjeToStanjeDTO;
import test.sprint.web.dto.StanjeDTO;

@RestController
@RequestMapping(value = "/api/stanja")
public class ApiStanjeController {
	
	@Autowired
	StanjeService stanjeService;
	@Autowired
	StanjeToStanjeDTO toDto;
	
	@RequestMapping(method = RequestMethod.GET)
	ResponseEntity<List<StanjeDTO>> getStanje(){	
		List<Stanje> stanja = stanjeService.getAll();
		
		return new ResponseEntity<>(toDto.convert(stanja), HttpStatus.OK);		
	}
}
