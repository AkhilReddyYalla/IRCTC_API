package in.ashokit.restcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import in.ashokit.entity.Passenger;
import in.ashokit.entity.Ticket;
import in.ashokit.service.TicketService;

@RestController
public class TicketRestController {
	@Autowired
	private TicketService ticketService;
	
	@PostMapping(  value="/ticket",
			       consumes="application/json",
			       produces="application/json"
			
			    )
	public ResponseEntity<Ticket> bookTicket(@RequestBody Passenger passenger){
		Ticket bookTicket = ticketService.bookTicket(passenger);
		return new ResponseEntity<>(bookTicket , HttpStatus.CREATED);
	}
	
	@GetMapping(
			   value="/getTicket/{tid}",
			   produces="application/json"
			   )
	public ResponseEntity<Ticket> getTicket(@PathVariable("tid") Integer tid){
		Ticket ticket = ticketService.getTicket(tid);
		return new ResponseEntity<Ticket>(ticket , HttpStatus.OK);
	}
	@GetMapping(
			   value="/getAllTickets",
			   produces="application/json"
			   )
	public ResponseEntity<List<Ticket>> getAllTicket(){
		 List<Ticket> allTickets = ticketService.getAllTickeets();
		return new ResponseEntity<List<Ticket>>(allTickets , HttpStatus.OK);
	}

}
