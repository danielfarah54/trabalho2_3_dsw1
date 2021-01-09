package br.ufscar.dc.dsw.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@SuppressWarnings("serial")
@Entity
@Table(name = "SiteReserva")
public class SiteReserva extends Usuario{

	@NotBlank(message = "{NotBlank.siteReserva.url}")
	@Size(min = 3, max = 250, message = "{Size.siteReserva.url}")
	@Column(nullable= false, unique = false, length = 250)
    private String url;

	@Column(nullable= true, unique = false, length = 14)
    private String telefone;

	@OneToMany(mappedBy = "sitereserva") // a string é mapeada para o atributo sitereserva da classe PromoHotel.
	private List<PromoHotel> promocoesDoSiteReserva;

	public SiteReserva() {
    }
	
    public SiteReserva(String url) {
        this.url = url;
    }
    
    public SiteReserva(String url, String nome, String telefone, String email, String senha) { 
    	super(nome, email, senha);
    	
    	this.url = url;
	    
	    this.telefone = telefone;
	    
	    this.promocoesDoSiteReserva = new ArrayList<PromoHotel>();
	}
    
    public SiteReserva(String url, String nome, String telefone, String email, String senha, List<PromoHotel> promocoesDoSiteReserva) { 
    	super(nome, email, senha);
    	
    	this.url = url;
	    
	    this.telefone = telefone;
	    
	    this.promocoesDoSiteReserva = promocoesDoSiteReserva;
	}
    
	public SiteReserva(Long id, String url, String nome, String telefone, String email, String senha, List<PromoHotel> promocoesDoSiteReserva) {
	    this(url, nome, telefone, email, senha, promocoesDoSiteReserva);
	}
	
	@Override
	public Long getId() {
		return super.getId();
	}
	
	public String getUrl() {
	    return url;
	}
	
	public void setUrl(String url) {
	    this.url = url;
	}
	
	public String getNomeHotel() {
	    return getNome();
	}
	
	public void setNome(String nome) {
	    setNome(nome);
	}
	
	public String getTelefone() {
	    return telefone;
	}
	
	public void setTelefone(String telefone) {
	    this.telefone = telefone;
	}	
	
	public String getEmail() {
	    return getLogin();
	}
	
	public void setEmail(String email) {
	    super.setLogin(email);
	}
	
	@Override
	public String getSenha(){
	    return super.getSenha();
	}
	
	@Override
	public void setSenha(String senha) {
	    super.setSenha(senha);
	}
	
    public List<PromoHotel> getPromocoesDoHotel() {
        return promocoesDoSiteReserva;
    }

    public void setPromocoesDoHotel(List<PromoHotel> promocoesDoSiteReserva) {
        this.promocoesDoSiteReserva = promocoesDoSiteReserva;
    }
    
    public void addPromocoesDoHotel(PromoHotel promocaoDoSiteReserva) {
        this.promocoesDoSiteReserva.add(promocaoDoSiteReserva);
    }
}