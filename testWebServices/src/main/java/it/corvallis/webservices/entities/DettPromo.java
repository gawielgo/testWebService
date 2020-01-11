package it.corvallis.webservices.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedStoredProcedureQuery;
import javax.persistence.StoredProcedureParameter;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonBackReference;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Table(name = "dettpromo")
@Data
public class DettPromo implements Serializable
{
	private static final long serialVersionUID = 7444232363326102441L;
	
	@Id
	@Column(name = "ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Basic(optional = false)
	private int riga;
	
	@Basic(optional = false)
	private String codart;
	
	@Basic
	private String codfid;
		
	@Column(name = "INIZIO")
	@Temporal(TemporalType.DATE)
	private Date inizio;
	
	@Column(name = "FINE")
	@Temporal(TemporalType.DATE)
	private Date fine;
	
	@Basic(optional = false)
	private String oggetto;
	
	@Basic
	private String isfid;
	
	@ManyToOne
	@EqualsAndHashCode.Exclude
	@JoinColumn(name = "IDPROMO", referencedColumnName = "idPromo")
	@JsonBackReference 
	private Promo promo;
	
	@ManyToOne
	@EqualsAndHashCode.Exclude
	@JoinColumn(name = "IDTIPOPROMO", referencedColumnName = "idTipoPromo")
	private TipoPromo tipoPromo;

}
