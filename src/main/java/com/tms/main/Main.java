package com.tms.main;

import com.tms.dao.TicketDAO;
import com.tms.dao.UserDAO;
import com.tms.model.Ticket;
import com.tms.model.User;

import java.util.List;

public class Main {
    public static void main(String[] args) {

        TicketDAO ticketDAO = new TicketDAO();
        UserDAO userDAO = new UserDAO();

        // Create User
        User user = new User(0, "Anmol", "anmol93@gmail.com", "CREATOR");
        userDAO.createUser(user);

        // Create Ticket
        Ticket ticket = new Ticket();
        ticket.setTitle("Server Down");
        ticket.setDescription("API not working");
        ticket.setCreatedBy(3);
        ticket.setAssignedTo(1);
        ticket.setStatus("OPEN");
        ticket.setPriority("HIGH");

        ticketDAO.createTicket(ticket);

        // Fetch Tickets
        List<Ticket> tickets = ticketDAO.getAllTickets();

        for(Ticket t : tickets){
            System.out.println(t);
        }
    }

}
