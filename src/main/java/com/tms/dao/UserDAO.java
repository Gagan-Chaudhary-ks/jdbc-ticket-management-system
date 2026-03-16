package com.tms.dao;

import com.tms.model.User;
import com.tms.util.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.util.List;
import java.util.ArrayList;

public class UserDAO {
    public void createUser(User user){
        Connection conn = null;
        PreparedStatement ps = null;

        String query = "INSERT INTO users (name, email, role) VALUES (?, ?, ?)" ;

        try{

            conn = DBConnection.getConnection();
            ps = conn.prepareStatement(query);

            ps.setString(1, user.getName());
            ps.setString(2, user.getEmail());
            ps.setString(3, user.getRole());

            ps.executeUpdate();
        }
        catch(SQLException e){
            e.printStackTrace();
        }

        finally{
            try{
                if(ps != null){
                    ps.close();
                }

                if(conn != null){
                    conn.close();
                }
            }
            catch(SQLException e){
                e.printStackTrace();
            }
        }
    }

}
