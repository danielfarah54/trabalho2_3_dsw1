package br.ufscar.dc.dsw.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import br.ufscar.dc.dsw.domain.SiteReserva;

@SuppressWarnings("unchecked")
public interface ISiteReservaDAO extends CrudRepository<SiteReserva, Long>{
	
	SiteReserva findById(long id);
	
	List<SiteReserva> findAll();
	
	SiteReserva save(SiteReserva siteReserva); // faz as operações de save e update.
	
	SiteReserva findByLogin(String login);
	
	void deleteById(Long id);

}

