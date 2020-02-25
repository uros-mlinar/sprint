package test.sprint.support;

import java.util.ArrayList;
import java.util.List;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import test.sprint.model.Zadatak;
import test.sprint.web.dto.ZadatakDTO;

@Component
public class ZadatakToZadatakDTO implements Converter<Zadatak, ZadatakDTO> {

	@Override
	public ZadatakDTO convert(Zadatak source) {
		ZadatakDTO dto = new ZadatakDTO();
		
		dto.setId(source.getId());
		dto.setIme(source.getIme());
		dto.setZaduzeni(source.getZaduzeni());
		dto.setSprintID(source.getSprint().getId());
		dto.setStanjeID(source.getStanje().getId());
		dto.setBodovi(source.getBodovi());
		dto.setSprintNaziv(source.getSprint().getIme());
		dto.setStanjeNaziv(source.getStanje().getIme());
		
		return dto;
	}

	public List<ZadatakDTO> convert(List<Zadatak> source) {
		List<ZadatakDTO> dto = new ArrayList<>();
		
		for (Zadatak zadatak : source) {
			dto.add(convert(zadatak));
		}
		
		return dto;
	}

}
