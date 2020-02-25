package test.sprint.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import test.sprint.model.Zadatak;
import test.sprint.service.ZadatakService;
import test.sprint.support.ZadatakDtoToZadatak;
import test.sprint.support.ZadatakToZadatakDTO;
import test.sprint.web.dto.ZadatakDTO;

@RestController
@RequestMapping(value = "api/zadaci")
public class ApiZadatakController {
	
	@Autowired
	ZadatakService zadatakService;
	
	@Autowired
	ZadatakToZadatakDTO toDto;
	@Autowired
	ZadatakDtoToZadatak toZad;
	
	@RequestMapping(method = RequestMethod.GET)
	ResponseEntity<List<ZadatakDTO>> getZadatak(
			@RequestParam(required = false) String imeZadatka,
			@RequestParam(required = false) Long sprintID,
			@RequestParam(defaultValue = "0") int pageNum){
		Page<Zadatak> zadaciPage = null;
		
		if(imeZadatka != null || sprintID != null) {
			zadaciPage = zadatakService.search(imeZadatka, sprintID, pageNum);
		} else {
			zadaciPage = zadatakService.findAll(pageNum);			
		}				
		
		List<Zadatak> zadaci = zadaciPage.getContent();
		
		HttpHeaders headers = new HttpHeaders();
		headers.add("totalPages", Integer.toString(zadaciPage.getTotalPages()) );
		
		return new ResponseEntity<>(toDto.convert(zadaci), headers, HttpStatus.OK);
	}
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	ResponseEntity<ZadatakDTO> getZadatak(@PathVariable Long id){
		Zadatak zadatak = zadatakService.findOne(id);
		
		if(zadatak == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}		
		
		return new ResponseEntity<>(toDto.convert(zadatak), HttpStatus.OK);
	}
	
	@RequestMapping(method = RequestMethod.POST, consumes="application/json")
	ResponseEntity<ZadatakDTO> add(@Validated @RequestBody ZadatakDTO newZadatak){	
		
		Zadatak persisted = zadatakService.save(toZad.convert(newZadatak));
		
		return new ResponseEntity<>(toDto.convert(persisted), HttpStatus.CREATED);
		
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.PUT, consumes = "application/json")
	ResponseEntity<ZadatakDTO> edit(@Validated @RequestBody ZadatakDTO zadatakDTO, @PathVariable Long id) {
		
		if(!id.equals(zadatakDTO.getId())){
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		
		Zadatak persisted = zadatakService.save(toZad.convert(zadatakDTO));
		
		return new ResponseEntity<>(toDto.convert(persisted), HttpStatus.OK);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	ResponseEntity<ZadatakDTO> delete(@PathVariable Long id){
		
		Zadatak deleted = zadatakService.delete(id);
		
		if(deleted == null) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		
		return new ResponseEntity<>(toDto.convert(deleted), HttpStatus.OK);
	}
	
	@ExceptionHandler(value=DataIntegrityViolationException.class)
	public ResponseEntity<Void> handle() {
		return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
	}
}
