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
@Table(name="tbl_sprint")
public class Sprint {
	@Id
	@GeneratedValue
	@Column
	private Long id;
	@Column
	private String ime;
	@Column
	private String ukupnoBodova;
	@Column
	@OneToMany(mappedBy = "sprint", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private List<Zadatak> zadaci = new ArrayList<>();
	
	public Sprint() {
		super();
	}
	public Sprint(String ime, String ukupnoBodova, List<Zadatak> zadaci) {
		super();
		this.ime = ime;
		this.ukupnoBodova = ukupnoBodova;
		this.zadaci = zadaci;
	}
	
	public Sprint(String ime, String ukupnoBodova) {
		super();
		this.ime = ime;
		this.ukupnoBodova = ukupnoBodova;
	}
	
	public List<Zadatak> getZadaci() {
		return zadaci;
	}
	public void setZadaci(List<Zadatak> zadaci) {
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
	public String getUkupnoBodova() {
		return ukupnoBodova;
	}
	public void setUkupnoBodova(String ukupnoBodova) {
		this.ukupnoBodova = ukupnoBodova;
	}
}
