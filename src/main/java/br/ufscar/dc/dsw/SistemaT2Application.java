package br.ufscar.dc.dsw;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import br.ufscar.dc.dsw.dao.ICidadeDAO;
import br.ufscar.dc.dsw.dao.IHotelDAO;
import br.ufscar.dc.dsw.dao.IPromoHotelDAO;
import br.ufscar.dc.dsw.dao.ISiteReservaDAO;
import br.ufscar.dc.dsw.domain.*;

@SpringBootApplication
public class SistemaT2Application {

	public static void main(String[] args) {
		SpringApplication.run(SistemaT2Application.class, args);
	}
	
	@Bean
	public CommandLineRunner demo(ICidadeDAO cidadeDAO, IHotelDAO hotelDAO, IPromoHotelDAO promoHotelDAO, ISiteReservaDAO siteReservaDAO) {
		return (args) -> {
			
			Cidade cidade = new Cidade("São Carlos");
			Cidade c2 = new Cidade("Ibaté");
			cidadeDAO.save(cidade);			
			cidadeDAO.save(c2);			
			
			Set<Cidade> setcidade = new HashSet<Cidade>();
			Set<Cidade> set2cidade = new HashSet<Cidade>();
			
			setcidade.add(cidade);
			setcidade.add(c2);
			
			set2cidade.add(cidade);
			
			Hotel hotel = new Hotel("CNPJCNPJCNPJ", "nOMEHotel1", setcidade, "email@email.com", "senha");
			Hotel hotel2 = new Hotel("CNPJ2CNPJ2", "nOMEHotel2", set2cidade, "email2@email.com", "senha2");
			
			hotelDAO.save(hotel);
			hotelDAO.save(hotel2);
			
			Set<Hotel> sethotel = new HashSet<Hotel>();
			sethotel.add(hotel);

			for (Cidade c : setcidade) {
			    c.setHotelDaCidade(sethotel);
			    cidadeDAO.save(c);
			}

			for (Cidade c : set2cidade) {
			    c.addHotelDaCidade(hotel2);
			    cidadeDAO.save(c);
			}
			
			hotel.setCidades(setcidade);
			hotelDAO.save(hotel);
			
			hotel2.setCidades(set2cidade);
			hotelDAO.save(hotel2);
		};
	}
}