package pl.edu.pjwstk.shopMan.domain;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;

@Entity
@NamedQuery(name = "article.all", query = "Select a from Article a")
public class Article {
	
	private Long id;
	private String nazwa;
	private float cena;
	private Date dataWaznosci;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	public String getNazwa() {
		return nazwa;
	}

	public void setNazwa(String nazwa) {
		this.nazwa = nazwa;
	}
	
	public float getCena() {
		return cena;
	}

	public void setCena(float cena) {
		this.cena = cena;
	}
	public Date getDataWaznosci() {
		return dataWaznosci;
	}
	public void setDataWaznosci(Date dataWaznosci) {
		this.dataWaznosci = dataWaznosci;
	}
	

}
