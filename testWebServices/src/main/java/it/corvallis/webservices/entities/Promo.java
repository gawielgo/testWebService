package it.corvallis.webservices.entities;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.Data;

@Entity
@Table(name = "promo")
@Data
public class Promo  implements Serializable
{
	private static final long serialVersionUID = -2077445225617424877L;

	@Id
	@Column(name = "IDPROMO")
	private String idPromo;
	
	@Basic(optional = false)
	private int anno;
	
	@Basic(optional = false)
	private String codice;
	
	@Basic
	private String descrizione;
	
	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL,  mappedBy = "promo",  orphanRemoval = true)
	@OrderBy("riga asc") 
	@JsonManagedReference
	private Set<DettPromo> dettPromo = new HashSet<>();
	
	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL,  mappedBy = "promo", orphanRemoval = true)
	@JsonManagedReference
	private Set<DepRifPromo> depRifPromo = new HashSet<>();
	
	public Promo(String IdPromo, int Anno, String Codice, String Descrizione)
	{
		this.idPromo = IdPromo;
		this.anno = Anno;
		this.codice = Codice;
		this.descrizione = Descrizione;
	}
}
