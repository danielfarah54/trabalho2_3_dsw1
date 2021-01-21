package br.ufscar.dc.dsw.domain;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@SuppressWarnings("serial")
@Entity
@Table(name = "Cidade")
public class Cidade extends AbstractEntity<Long>{

	@NotBlank(message="NotNull.cidade.nomeCidade")
	@Size(min = 3, max = 200, message = "{Size.cidade.nomeCidade}")
	@Column(nullable = false, unique = false, length = 200)
    private String nomeCidade;
	
	@ManyToMany	(targetEntity=Hotel.class)
	private Set<Hotel> hotelDaCidade;

	public Cidade() {
	}
		
	public Cidade(String nomeCidade) {
		this.nomeCidade = nomeCidade;
		this.hotelDaCidade = new HashSet<Hotel>();
	}
	
	public Cidade(String nomeCidade, Set<Hotel> hotelDaCidade) {
		this.nomeCidade = nomeCidade;
		this.hotelDaCidade = hotelDaCidade;
	}
	
	@Override
	public Long getId() {
		return super.getId();
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
	
	public void addHotelDaCidade(Hotel addhotelNaCidade) {
		this.hotelDaCidade.add(addhotelNaCidade);
	}
}