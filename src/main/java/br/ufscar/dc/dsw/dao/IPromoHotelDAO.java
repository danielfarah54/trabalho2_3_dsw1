package br.ufscar.dc.dsw.dao;

import java.util.List;
import org.springframework.data.repository.CrudRepository;
import br.ufscar.dc.dsw.domain.Hotel;
import br.ufscar.dc.dsw.domain.PromoHotel;
import br.ufscar.dc.dsw.domain.SiteReserva;

@SuppressWarnings("unchecked")
public interface IPromoHotelDAO extends CrudRepository<PromoHotel, Long>{
	
	PromoHotel findById(long id);
	
	List<PromoHotel> findAll();
	
	PromoHotel save(PromoHotel promohotel);
	
	void deleteById(Long id);

}