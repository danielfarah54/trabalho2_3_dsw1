package br.ufscar.dc.dsw.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import br.ufscar.dc.dsw.domain.Cidade;
import br.ufscar.dc.dsw.domain.Hotel;

@SuppressWarnings("unchecked")
public interface IHotelDAO extends CrudRepository<Hotel, Long>{
	
	Hotel findById(long id);
	List<Hotel> findAll();
	List<Hotel> findByCidades(Cidade cidade);
	Hotel save(Hotel hotel);
	void deleteById(Long id);
	Hotel findByLogin(String login);
}