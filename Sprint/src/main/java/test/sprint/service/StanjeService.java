package test.sprint.service;

import java.util.List;

import test.sprint.model.Stanje;

public interface StanjeService {
	List<Stanje> getAll();
	Stanje save(Stanje stanje);
	Stanje findOne(Long stanjeID);
}
