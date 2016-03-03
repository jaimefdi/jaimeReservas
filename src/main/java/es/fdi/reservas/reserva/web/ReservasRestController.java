package es.fdi.reservas.reserva.web;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import es.fdi.reservas.reserva.business.boundary.ReservaService;
import es.fdi.reservas.reserva.business.entity.Espacio;
import es.fdi.reservas.reserva.business.entity.Reserva;
import es.fdi.reservas.reserva.business.entity.TipoEspacio;
import es.fdi.reservas.users.business.boundary.UserService;

@RestController
public class ReservasRestController {
	
	private ReservaService reserva_service;
	
	private UserService user_service;
	
	@Autowired
	public ReservasRestController(ReservaService rs, UserService us){
		reserva_service = rs;
		user_service = us;
	}
	
	@RequestMapping(value="{id_espacio}/eventos", method=RequestMethod.GET)
	public List<ReservaFullCalendarDTO> allReserv(@PathVariable("id_espacio") long id_espacio){
		//List<Reserva> allReservas = reserva_service.getAllReservations();
		List<Reserva> allReservas = reserva_service.getReservations(id_espacio);//espacio 1
		List<ReservaFullCalendarDTO> result = new ArrayList<>();
		for(Reserva r : allReservas) {
			result.add(ReservaFullCalendarDTO.fromReserva(r));
		}
		 
		return result;
	}
	
	@RequestMapping(value="{id_edif}/tipoEspacio/{tipoEspacio}", method=RequestMethod.GET)
	public List<EspacioTipoDTO> todosLosEspacios(@PathVariable("id_edif") long id_edif, @PathVariable("tipoEspacio") String tipoEspacio){
		List<EspacioTipoDTO> result = new ArrayList<>();
		List<Espacio> allSpaces = new ArrayList<>();
		
		if(tipoEspacio.equals("Todos"))
			 allSpaces = reserva_service.getAllSpaces(id_edif);
		else
		     allSpaces = reserva_service.getTypeSpaces(id_edif, TipoEspacio.fromTipoEspacio(tipoEspacio));
		
		
		for(Espacio e : allSpaces) {
			result.add(EspacioTipoDTO.fromEspacioTipoDTO(e));
		}
		 
		return result;
			
	}

	
	
}
