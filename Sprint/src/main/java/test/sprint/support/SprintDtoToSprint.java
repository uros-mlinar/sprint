package test.sprint.support;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import test.sprint.model.Sprint;
import test.sprint.service.SprintService;
import test.sprint.web.dto.SprintDTO;

@Component
public class SprintDtoToSprint implements Converter<SprintDTO, Sprint>{
	
	@Autowired
	SprintService sprintSer;

	@Override
	public Sprint convert(SprintDTO source) {
		Sprint sprint = null;
		
		if(source.getId() == null) {
			sprint = new Sprint();
			sprint.setIme(source.getIme());
			sprint.setUkupnoBodova(source.getUkupnoBodova());
		} else {
			sprint = sprintSer.findOne(source.getId());
		}
		
		return sprint;
	}
	
	public List<Sprint> convert(List<SprintDTO> source){
		List<Sprint> sprintovi = new ArrayList<>();
		
		for (SprintDTO dto : source) {
			sprintovi.add(convert(dto));
		}
		
		return sprintovi;
	}
	

}
