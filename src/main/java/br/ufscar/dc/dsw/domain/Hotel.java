package br.ufscar.dc.dsw.domain;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@SuppressWarnings("serial")
@JsonIgnoreProperties(value = { "cidades", "promocoesDoHotel" }) 
@Entity
@Table(name = "Hotel")
public class Hotel extends Usuario{

	@NotBlank(message = "{NotBlank.hotel.cnpj}") 
	@Size(min = 10, max = 18, message = "{Size.hotel.cnpj}")	
	@Column(nullable = false, unique = true, length = 18)
    private String cnpj;

	@ManyToMany(targetEntity=Cidade.class, mappedBy = "hotelDaCidade")
	private Set<Cidade> cidades = new HashSet<Cidade>();

	@OneToMany(mappedBy = "hotel")
	private List<PromoHotel> promocoesDoHotel;

	public Hotel() {
    }
	
	public Hotel(String cnpj, String nome, Set<Cidade> cidades, String email, String senha) {
		super(nome,email,senha);
		this.cnpj = cnpj;
	    this.cidades = cidades;
	}
	
	public Hotel(Long id, String cnpj, String nome, Set<Cidade> cidades, String email, String senha) {
	    this(cnpj, nome, cidades, email, senha);
	}
	
	@Override
	public Long getId() {
		return super.getId();
	}

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }
    
    @Override
    public String getNome() {
        return super.getNome();
    }
    
    @Override
    public void setNome(String nome) {
        super.setNome(nome);
    }
    
    public Set<Cidade> getCidades() {
        return cidades;
    }

    public void setCidades(Set<Cidade> cidades) {
        this.cidades = cidades;
    }
    
    public void addCidade(Cidade hotelEstaNaCidade) {
        this.cidades.add(hotelEstaNaCidade);
    }
    
    public String getEmail() {
        return super.getLogin();
    }

    public void setEmail(String email) {
        super.setLogin(email);
    }
    
    @Override
    public String getSenha() {
        return super.getSenha();
    }
    
    @Override
    public void setSenha(String senha) {
        super.setSenha(senha);
    }

    public List<PromoHotel> getPromocoesDoHotel() {
        return promocoesDoHotel;
    }

    public void setPromocoesDoHotel(List<PromoHotel> promocoesDoHotel) {
        this.promocoesDoHotel = promocoesDoHotel;
    }
}