package test.sprint;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import test.sprint.model.Sprint;
import test.sprint.model.Stanje;
import test.sprint.model.Zadatak;
import test.sprint.service.SprintService;
import test.sprint.service.StanjeService;
import test.sprint.service.ZadatakService;

@Component
public class TestData {

	@Autowired
	private SprintService sprintService;
	@Autowired
	private ZadatakService zadatakService;
	@Autowired
	private StanjeService stanjeService;
	
	@PostConstruct
	public void init() {
		
		List<Sprint> sprintovi = new ArrayList<>();
		List<Zadatak> zadaci = new ArrayList<>();	
//		List<Stanje> stanja = new ArrayList<>();	
		
		Stanje nov = new Stanje("nov", null);
		Stanje uToku = new Stanje("u-toku", null);
		Stanje zavrsen = new Stanje("zavrsen", null);
		
		stanjeService.save(nov);
		stanjeService.save(uToku);
		stanjeService.save(zavrsen);
		
		sprintovi.add(new Sprint("Stanica", "0", zadaci));
		sprintovi.add(new Sprint("Sprintovi", "0", zadaci));
		
		int i = 1;
		for (Sprint sprint : sprintovi) {
			Zadatak z1 = new Zadatak("angular" + i, "Pera", 5, sprint, nov);
			z1.updateBrojBodovaSprinta(5);
			Zadatak z2 = new Zadatak("java" + i, "Mika", 20, sprint, uToku);
			z2.updateBrojBodovaSprinta(20);
			Zadatak z3 = new Zadatak("mysql" + i, "Laza", 10, sprint, zavrsen);
			z2.updateBrojBodovaSprinta(10);
			
			sprintService.save(sprint);
			
			zadatakService.save(z1);
			zadatakService.save(z2);
			zadatakService.save(z3);
			
			i++;
			
		}
		
	}
}
