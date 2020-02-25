package test.sprint.support;

import java.util.ArrayList;
import java.util.List;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import test.sprint.model.Sprint;
import test.sprint.web.dto.SprintDTO;

@Component
public class SprintToSprintDTO implements Converter<Sprint, SprintDTO>{

	@Override
	public SprintDTO convert(Sprint source) {
		SprintDTO dto = new SprintDTO();
		
		dto.setId(source.getId());
		dto.setIme(source.getIme());
		dto.setUkupnoBodova(source.getUkupnoBodova());
		
		
		return dto;
	}
	
	public List<SprintDTO> convert(List<Sprint> source){
		List<SprintDTO> dto = new ArrayList<>();
		
		for (Sprint sprint : source) {
			dto.add(convert(sprint));
		}
		
		return dto;
	}
	
		

}
