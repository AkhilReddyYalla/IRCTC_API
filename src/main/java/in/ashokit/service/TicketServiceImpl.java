package in.ashokit.service;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.ashokit.entity.Passenger;
import in.ashokit.entity.Ticket;
import in.ashokit.repo.TicketRepository;
@Service
public class TicketServiceImpl implements TicketService{
	@Autowired
	private TicketRepository ticketRepo;

	@Override
	public Ticket bookTicket(Passenger passenger) {
		
		//creating instance 
		//setting properties from an passenger instance
		/*Ticket ticket = new Ticket();
		
		ticket.setName(passenger.getName());
		ticket.setDob(passenger.getDob());
		ticket.setGender(passenger.getGender());
		ticket.setDoj(passenger.getDoj());
		ticket.setSource(passenger.getSource());
		ticket.setDestination(passenger.getDestination());
		ticket.setTrainNum(passenger.getTrainNum());
		
		ticket.setTicketStatus("ticket booked");*/
		
		
		//creating an instance
		//Copy properties from Passenger to Ticket using BeanUtils
		Ticket ticket = new Ticket();
		BeanUtils.copyProperties(passenger, ticket);
		
		ticket.setTicketStatus("Your Ticket Booked SSuccessfully");
		
		
		return ticketRepo.save(ticket);
	}

	@Override
	public Ticket getTicket(Integer ticketId) {
		return ticketRepo.findById(ticketId).orElseThrow();
		
	}

	@Override
	public List<Ticket> getAllTickeets() {
		
		return ticketRepo.findAll();
	}

}
