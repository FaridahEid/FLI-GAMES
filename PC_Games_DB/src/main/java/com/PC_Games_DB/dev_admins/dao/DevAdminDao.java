package com.PC_Games_DB.dev_admins.dao;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.PC_Games_DB.dev_admins.DevAdmin;
import com.PC_Games_DB.players.player;
import com.PC_Games_DB.publishers.publisher;


public class DevAdminDao {
    public DevAdmin getDevAdmin(String adminID){
        DevAdmin a = new DevAdmin();
        try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/pc_games_db","root","loay1999");
            PreparedStatement ps = con.prepareStatement("select * from dev_admin where adminID=?");
            ps.setString(1,adminID);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                a.setDevID(rs.getString("devID"));
                a.setAdminId(rs.getString("adminID"));
                a.setEmail(rs.getString("email"));
                a.setAdminName(rs.getString("adminName"));
            }
        }catch(Exception e){
            System.out.println(e);
        }
        return a;
    }
    public DevAdmin devAdminSignin(String adminID, String password){
        DevAdmin a = new DevAdmin();

        try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/pc_games_db","root","loay1999");
            PreparedStatement ps = con.prepareStatement("select * from dev_admin where adminID=?");
            ps.setString(1,adminID);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                a.setDevID(rs.getString("devID"));
                a.setAdminId(rs.getString("adminID"));
                a.setEmail(rs.getString("email"));
                a.setAdminName(rs.getString("adminName"));
            }
            PreparedStatement ps2 = con.prepareStatement("select * from login_d where adminID=?");
            ps2.setString(1,adminID);
            ResultSet rs2 = ps2.executeQuery();
            if(rs2.next()){
                if(rs2.getString("password").equals(password)){
                    return a;
                }
            }
        }catch(Exception e){
            System.out.println(e);
        }
        return null;
    }
    public ArrayList<player> getAllPlayers(){
        ArrayList<player> players = new ArrayList<>();
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/pc_games_db", "root", "loay1999");
            PreparedStatement ps = con.prepareStatement("select * from players");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                player p = new player();
                p.setGamerID(rs.getString("gamerID"));
                p.setGamerName(rs.getString("gamerName"));
                p.setDate_joined(rs.getString("date_joined"));
                p.setDOB(rs.getString("DOB"));
                p.setEmail(rs.getString("email"));
                players.add(p);
            }
        }catch (Exception e){
            System.out.println(e);
        }

        return players;
    }
    public ArrayList<player> getPlayersByGamerID(String gamerID){
        ArrayList<player> players = new ArrayList<>();
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/pc_games_db", "root", "loay1999");
            PreparedStatement ps = con.prepareStatement("select * from players where gamerID like ?");
            ps.setString(1,gamerID);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                player p = new player();
                p.setGamerID(rs.getString("gamerID"));
                p.setGamerName(rs.getString("gamerName"));
                p.setDate_joined(rs.getString("date_joined"));
                p.setDOB(rs.getString("DOB"));
                p.setEmail(rs.getString("email"));
                players.add(p);
            }
        }catch(Exception e){
            System.out.println(e);
        }
        return players;
    }

    public boolean deletePlayer(String gamerID){
        try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/pc_games_db","root","loay1999");
            PreparedStatement ps = con.prepareStatement("delete from players where gamerID=?");
            ps.setString(1,gamerID);
            ps.execute();
            PreparedStatement ps2 = con.prepareStatement("delete from login_g where gamerID=?");
            ps2.setString(1,gamerID);
            ps2.execute();
            return true;
        }catch (Exception e){
            System.out.println(e);
            return false;
        }

    }

    public ArrayList<publisher> getAllPublishers(){
        ArrayList<publisher> publishers = new ArrayList<>();
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/pc_games_db", "root", "loay1999");
            PreparedStatement ps = con.prepareStatement("select * from publishers");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                publisher p = new publisher();
                p.setPublisherID(rs.getString("publisherID"));
                p.setPname(rs.getString("pname"));
                publishers.add(p);
            }
        }catch (Exception e){
            System.out.println(e);
        }
        return publishers;
    }

    public ArrayList<publisher> getPublisherByID(String publisherID){
        ArrayList<publisher> publishers = new ArrayList<>();
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/pc_games_db", "root", "loay1999");
            PreparedStatement ps = con.prepareStatement("select * from publishers where publisherID like ?");
            ps.setString(1,publisherID);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                publisher p = new publisher();
                p.setPublisherID(rs.getString("publisherID"));
                p.setPname(rs.getString("pname"));
                publishers.add(p);
            }
        }catch (Exception e){
            System.out.println(e);
        }
        return publishers;
    }

    public boolean changeEmail(String adminID, String email) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/pc_games_db","root","loay1999");
            PreparedStatement ps = con.prepareStatement("UPDATE dev_admin SET email = ? WHERE adminID = ?");
            ps.setString(1, email);
            ps.setString(2, adminID);
            ps.executeUpdate();
            return true;
        }catch(Exception e){
            e.printStackTrace();
        }
        return false;

    }

    public boolean changePassword(String adminID, String password) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/pc_games_db","root","loay1999");
            PreparedStatement ps = con.prepareStatement("UPDATE login_d SET password = ? WHERE adminID = ?");
            ps.setString(1, password);
            ps.setString(2, adminID);
            ps.executeUpdate();
            return true;
        }catch(Exception e){
            e.printStackTrace();
        }
        return false;

    }

    public boolean checkPassword(String adminID, String password) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/pc_games_db","root","loay1999");
            PreparedStatement ps2 = con.prepareStatement("select * from login_d where adminID=?");
            ps2.setString(1,adminID);
            ResultSet rs2 = ps2.executeQuery();
            if (rs2.next()) {
                if (rs2.getString("password").equals(password)){
                    return true;
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
}
