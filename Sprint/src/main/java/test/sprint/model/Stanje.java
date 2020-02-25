package test.sprint.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "tbl_stanje")
public class Stanje {
	
	@Id
	@GeneratedValue
	@Column
	private Long id;
	@Column
	private String ime;
	@Column
	@OneToMany(mappedBy = "stanje", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private List<Zadatak> zadaci = new ArrayList<>();
	

	public Stanje() {
		super();
	}
	public Stanje(String ime, List<Zadatak> zadaci) {
		super();
		this.ime = ime;
		this.zadaci = zadaci;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getIme() {
		return ime;
	}
	public void setIme(String ime) {
		this.ime = ime;
	}
	public List<Zadatak> getZadaci() {
		return zadaci;
	}
	public void setZadaci(List<Zadatak> zadaci) {
		this.zadaci = zadaci;
	}
	
	public void addZadatak(Zadatak zadatak) {
		if(zadatak.getStanje() != null && !zadatak.getStanje().equals(this)) {
			zadatak.setStanje(this);
		}
		zadaci.add(zadatak);
	}
}
