package br.ufscar.dc.dsw.domain;

import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "Cidade")
public class Cidade {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;

	@Column(nullable = false, unique = false, length = 200)
    private String nomeCidade;
	
	@ManyToMany	(targetEntity=Hotel.class)//Uma cidade pode conter vários hotéis, e um hotel pode estar em várias cidades.
	private Set<Hotel> hotelDaCidade;
	
	public Cidade(String nomeCidade, Set<Hotel> hotelDaCidade) {
		this.nomeCidade = nomeCidade;
		this.hotelDaCidade = hotelDaCidade;
	}
	
	public String getCidade() {
		return this.nomeCidade;
	}
	
	public void setCidade(String nomeCidade) {
		this.nomeCidade = nomeCidade;
	}
		
	public Set<Hotel> getHotelDaCidade() {
		return this.hotelDaCidade;
	}
	
	public void setHotelDaCidade(Set<Hotel> hotelDaCidade) {
		this.hotelDaCidade = hotelDaCidade;
	}
}