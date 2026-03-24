package com.tms.dao;

import com.tms.model.Ticket;
import com.tms.util.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TicketDAO {
    public void createTicket(Ticket ticket){
        Connection conn = null;
        PreparedStatement ps = null;

        String query = "INSERT INTO tickets (title, description, created_by, assigned_to, status, priority) VALUES (?, ?, ?, ?, ?, ?)";

        try{
            conn = DBConnection.getConnection();
            ps = conn.prepareStatement(query);

            ps.setString(1, ticket.getTitle());
            ps.setString(2, ticket.getDescription());
            ps.setInt(3, ticket.getCreatedBy());
            ps.setInt(4,ticket.getAssignedTo());
            ps.setString(5,ticket.getStatus());
            ps.setString(6,ticket.getPriority());

            ps.executeUpdate();

        }catch(SQLException e){
            e.printStackTrace();
        }
        finally {
            try{
                if(ps != null){
                    ps.close();
                }
                if(conn != null){
                    conn.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public List <Ticket> getAllTickets(){

        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        String query = "SELECT * FROM tickets";

        List<Ticket> tickets = new ArrayList<>();
        try{

            conn = DBConnection.getConnection();
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();

            while(rs.next()) {
                Ticket ticket = new Ticket();

                ticket.setTicketId(rs.getInt("ticket_id"));
                ticket.setTitle(rs.getString("title"));
                ticket.setDescription(rs.getString("description"));
                ticket.setCreatedBy(rs.getInt("created_by"));
                ticket.setAssignedTo(rs.getInt("assigned_to"));
                ticket.setStatus(rs.getString("status"));
                ticket.setPriority(rs.getString("priority"));

                tickets.add(ticket);
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
        finally{
            try{
                if(rs != null){
                    rs.close();
                }
                if(ps != null){
                    ps.close();
                }
                if(conn != null){
                    conn.close();
                }
            }catch(SQLException e){
                e.printStackTrace();
            }
        }
        return tickets;
    }

    public Ticket getTicketById(int id){
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        Ticket ticket = null;

        String query = "SELECT * FROM tickets WHERE ticket_id = ?";

        try{
            conn = DBConnection.getConnection();
            ps = conn.prepareStatement(query);

            ps.setInt(1,id);

            rs = ps.executeQuery();

            if(rs.next()){
                ticket = new Ticket();

                ticket.setTicketId(rs.getInt("ticket_id"));
                ticket.setTitle(rs.getString("title"));
                ticket.setDescription(rs.getString("description"));
                ticket.setCreatedBy(rs.getInt("created_by"));
                ticket.setAssignedTo(rs.getInt("assigned_to"));
                ticket.setStatus(rs.getString("status"));
                ticket.setPriority(rs.getString("priority"));

            }

        }catch(SQLException e){
            e.printStackTrace();
        }
        finally{
            try{
                if(rs != null){
                    rs.close();
                }
                if(ps != null){
                    ps.close();
                }
                if(conn != null){
                    conn.close();
                }
            }catch(SQLException e){
                e.printStackTrace();
            }
        }
        return ticket;
    }
}