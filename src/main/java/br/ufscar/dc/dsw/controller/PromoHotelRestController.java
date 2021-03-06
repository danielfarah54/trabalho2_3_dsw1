package br.ufscar.dc.dsw.controller;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;

import br.ufscar.dc.dsw.domain.PromoHotel;
import br.ufscar.dc.dsw.domain.Cidade;
import br.ufscar.dc.dsw.domain.Hotel;
import br.ufscar.dc.dsw.domain.SiteReserva;
import br.ufscar.dc.dsw.domain.Usuario;
import br.ufscar.dc.dsw.security.UsuarioDetails;
import br.ufscar.dc.dsw.service.spec.IHotelService;
import br.ufscar.dc.dsw.service.spec.IPromoHotelService;
import br.ufscar.dc.dsw.service.spec.ISiteReservaService;

@CrossOrigin
@RestController
public class PromoHotelRestController {
	@Autowired
	private IHotelService serviceH;
	
	@Autowired
	private IPromoHotelService serviceP;
	
	@Autowired
	private ISiteReservaService serviceS;
		
	@GetMapping(path = "/promocoes") 
	public ResponseEntity<List<PromoHotel>> lista() {
		List<PromoHotel> lista = serviceP.buscarTodos();
		if (lista.isEmpty()) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(lista);
	}
	
	@GetMapping(path = "/promocoes/{id}")
	public ResponseEntity<PromoHotel> lista(@PathVariable("id") long id){
		PromoHotel promohotel = serviceP.buscarPorId(id);
		if (promohotel == null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(promohotel);
	}
	
	@GetMapping(path = "/promocoes/hotel/{id}")
	public ResponseEntity<List<PromoHotel>> listahotel(@PathVariable("id") long id) {
		Hotel hotel = serviceH.buscarPorId(id);
		List<PromoHotel> lista = serviceP.findByHotel(hotel);

		if (lista.isEmpty()) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(lista);
	}
	
	@GetMapping(path = "/promocoes/sites/{id}")
	public ResponseEntity<List<PromoHotel>> listasites(@PathVariable("id") long id) {
		SiteReserva sitereserva = serviceS.buscarPorId(id);
		List<PromoHotel> lista = serviceP.findBySitereserva(sitereserva);

		if (lista.isEmpty()) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(lista);
	}
}