package test.sprint.support;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import test.sprint.model.Stanje;
import test.sprint.service.StanjeService;
import test.sprint.web.dto.StanjeDTO;

@Component
public class StanjeDtoToStanje implements Converter<StanjeDTO, Stanje> {
	
	@Autowired
	StanjeService sSer;

	@Override
	public Stanje convert(StanjeDTO source) {
		Stanje stanje = null;
		
		if(sSer.findOne(source.getId()) == null) {
			stanje = new Stanje();
			stanje.setIme(source.getIme());
		} else {
			stanje = sSer.findOne(source.getId());
		}
		
		return stanje;
	}
	
	public List<Stanje> convert(List<StanjeDTO> source){
		List<Stanje> stanja = new ArrayList<>();
		
		for (StanjeDTO dto : source) {
			stanja.add(convert(dto));
		}
		
		return stanja;
	}

}
