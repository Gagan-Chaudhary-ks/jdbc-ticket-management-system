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

    public List<User> getAllUsers(){
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        List<User> users = new ArrayList<>();

        String query = "Select * FROM USERS";

        try{
            conn = DBConnection.getConnection();
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();

            while(rs.next()){
                User user = new User();

                user.setId(rs.getInt("id"));
                user.setName(rs.getString("name"));
                user.setEmail(rs.getString("email"));
                user.setRole(rs.getString("role"));

                users.add(user);
            }
        }
        catch(SQLException e){
            e.printStackTrace();
        }
        finally {
            try {
                if(rs != null){
                    rs.close();
                }

                if (ps != null) {
                    ps.close();
                }
                if (conn != null) {
                    conn.close();
                }
            }
            catch(SQLException e){
                e.printStackTrace();
            }
        }
        return users;
    }

    public User getUserById(int id){
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        User user = null;


        String query = "SELECT * FROM user WHERE user_id = ?";
        try{
            conn = DBConnection.getConnection();
            ps = conn.prepareStatement(query);

            ps.setInt(1,id);

            rs = ps.executeQuery();

            if(rs.next()){
                user = new User();

                user.setId(rs.getInt("id"));
                user.setName(rs.getString("name"));
                user.setEmail(rs.getString("email"));
                user.setRole(rs.getString("role"));
            }

        }
        catch(SQLException e){
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
        return user;
    }
}
