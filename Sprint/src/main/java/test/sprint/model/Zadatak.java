package test.sprint.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "tbl_zadatak")
public class Zadatak {
	@Id
	@GeneratedValue
	@Column
	private Long id;
	@Column(nullable = false, unique = true)
	private String ime;
	@Column(nullable = false)
	private String zaduzeni;
	@Column
	private int bodovi;
	@ManyToOne(fetch = FetchType.EAGER)
	private Sprint sprint;
	@ManyToOne(fetch = FetchType.EAGER)
	private Stanje stanje;	

	
	public Zadatak() {
		super();
	}
	public Zadatak(String ime, String zaduzeni, int bodovi, Sprint sprint, Stanje stanje) {
		super();
		this.ime = ime;
		this.zaduzeni = zaduzeni;
		this.bodovi = bodovi;
		this.sprint = sprint;
		this.stanje = stanje;
	}
	
	public void updateBrojBodovaSprinta(int razlika) {
		Sprint sprint = getSprint();
		int ukupnoBodovaSprinta = Integer.parseInt(sprint.getUkupnoBodova());
		ukupnoBodovaSprinta += razlika;
		sprint.setUkupnoBodova(String.valueOf(ukupnoBodovaSprinta));		
		
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
	public String getZaduzeni() {
		return zaduzeni;
	}
	public void setZaduzeni(String zaduzeni) {
		this.zaduzeni = zaduzeni;
	}
	public int getBodovi() {
		return bodovi;
	}
	public void setBodovi(int bodovi) {
		this.bodovi = bodovi;
	}
	public Sprint getSprint() {
		return sprint;
	}
	public void setSprint(Sprint sprint) {
		this.sprint = sprint;
	}
	public Stanje getStanje() {
		return stanje;
	}
	public void setStanje(Stanje stanje) {
		this.stanje = stanje;
	}
}
