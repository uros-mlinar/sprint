package test.sprint.web.dto;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

public class ZadatakDTO {
	
	private Long id;
	@NotEmpty
	@Length(max = 40)
	private String ime;
	private String zaduzeni;
	@Min(0)
	@Max(20)
	private int bodovi;
	private Long sprintID;
	private Long stanjeID;
	private String sprintNaziv;
	private String stanjeNaziv;
	
	public String getSprintNaziv() {
		return sprintNaziv;
	}
	public void setSprintNaziv(String sprintNaziv) {
		this.sprintNaziv = sprintNaziv;
	}
	public String getStanjeNaziv() {
		return stanjeNaziv;
	}
	public void setStanjeNaziv(String stanjeNaziv) {
		this.stanjeNaziv = stanjeNaziv;
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
	public Long getSprintID() {
		return sprintID;
	}
	public void setSprintID(Long sprintID) {
		this.sprintID = sprintID;
	}
	public Long getStanjeID() {
		return stanjeID;
	}
	public void setStanjeID(Long stanjeID) {
		this.stanjeID = stanjeID;
	}
	

}
