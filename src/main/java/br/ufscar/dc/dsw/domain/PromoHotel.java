package br.ufscar.dc.dsw.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.JoinColumn;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
//import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
//import javax.persistence.Id;

@SuppressWarnings("serial")
@Entity
@Table(name = "PromoHotel")
public class PromoHotel extends AbstractEntity<Long>{
    
    @NotBlank(message = "{NotBlank.promoHotel.preco}")
    @Column(nullable=false, unique=false)
    private float preco;
    
    @NotBlank(message = "{NotBlank.promoHotel.iniciopromo}")
    @Size(min = 10, max = 10, message = "{Size.promoHotel.iniciopromo}")
    @Column(nullable=false, unique=false, length=10)
    private String iniciopromo;

    @NotBlank(message = "{NotBlank.promoHotel.fimpromo}")
    @Size(min = 10, max = 10, message = "{Size.promoHotel.fimpromo}")
    @Column(nullable=false, unique=false, length=10)
    private String fimpromo;
    
    @ManyToOne
    @JoinColumn(name = "hotel_id")
    private Hotel hotel;
    
    
    @ManyToOne
    @JoinColumn(name = "sitereserva_id")
    private SiteReserva sitereserva;

    public PromoHotel() {
    }
    
    public PromoHotel(float preco, String iniciopromo, String fimpromo, Hotel hotel, SiteReserva sitereserva) {
        this.preco = preco;
        this.iniciopromo = iniciopromo;
        this.fimpromo = fimpromo;
        this.hotel = hotel;
        this.sitereserva = sitereserva;
    }
    
    public PromoHotel(Long id, float preco, String iniciopromo, String fimpromo, Hotel hotel, SiteReserva sitereserva) {
        this(preco, iniciopromo, fimpromo, hotel, sitereserva);
    }
 
    public float getPreco() {
        return preco;
    }

    public void setPreco(float preco) {
        this.preco = preco;
    }

    public String getIniciopromo() {
        return iniciopromo;
    }

    public void setIniciopromo(String iniciopromo) {
        this.iniciopromo = iniciopromo;
    }
    
    public String getFimpromo() {
        return fimpromo;
    }

    public void setFimpromo(String fimpromo) {
        this.fimpromo = fimpromo;
    }
    
    public Hotel getHotel() {
        return hotel;
    }

    public void setHotel(Hotel hotel) {
        this.hotel = hotel;
    }
    
    public SiteReserva getSitereserva() {
        return sitereserva;
    }

    public void setSitereserva(SiteReserva sitereserva) {
        this.sitereserva = sitereserva;
    }
}