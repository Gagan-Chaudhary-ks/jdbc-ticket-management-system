package com.tms.dao;

import com.tms.model.Ticket;
import com.tms.util.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

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
}