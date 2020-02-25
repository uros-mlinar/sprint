package test.sprint.support;

import java.util.ArrayList;
import java.util.List;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import test.sprint.model.Stanje;
import test.sprint.web.dto.StanjeDTO;

@Component
public class StanjeToStanjeDTO implements Converter<Stanje, StanjeDTO> {

	@Override
	public StanjeDTO convert(Stanje source) {
		StanjeDTO dto = new StanjeDTO();
		dto.setId(source.getId());
		dto.setIme(source.getIme());
		
		return dto;
	}
	
	public List<StanjeDTO> convert(List<Stanje> source){
		List<StanjeDTO> dto = new ArrayList<>();
		
		for (Stanje s : source) {
			dto.add(convert(s));
		}
		
		return dto;
	}

}
