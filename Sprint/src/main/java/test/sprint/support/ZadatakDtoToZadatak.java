package test.sprint.support;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import test.sprint.model.Zadatak;
import test.sprint.service.SprintService;
import test.sprint.service.StanjeService;
import test.sprint.service.ZadatakService;
import test.sprint.web.dto.ZadatakDTO;

@Component
public class ZadatakDtoToZadatak implements Converter<ZadatakDTO, Zadatak>{
	
	@Autowired
	ZadatakService zSer;
	@Autowired
	SprintService sprintSer;
	@Autowired
	StanjeService stanjeSer;

	@Override
	public Zadatak convert(ZadatakDTO source) {
		
		Zadatak z = null;
		if(source.getId() != null) {
			z = zSer.findOne(source.getId());
			z.setStanje(stanjeSer.findOne(source.getStanjeID()));
		} else {
			z = new Zadatak();
//da uvek bude nov
			z.setStanje(stanjeSer.findOne(1l));
		}
		z.setIme(source.getIme());
		z.setZaduzeni(source.getZaduzeni());
		z.setSprint(sprintSer.findOne(source.getSprintID()));
		
		
		if(source.getBodovi() != z.getBodovi()) {
			z.updateBrojBodovaSprinta(source.getBodovi() - z.getBodovi());			
		}
		z.setBodovi(source.getBodovi());
		
		return z;
	}
	
	public List<Zadatak> convert(List<ZadatakDTO> source) {
		List<Zadatak> zadaci = new ArrayList<Zadatak>();
		for (ZadatakDTO dto : source) {
			zadaci.add(convert(dto));
		}
		
		return zadaci;
	}

}
