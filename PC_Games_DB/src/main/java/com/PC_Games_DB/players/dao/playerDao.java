package com.PC_Games_DB.players.dao;
import com.PC_Games_DB.players.player;
import java.sql.*;
import java.util.ArrayList;

public class playerDao {
    public player getPlayer(String gamerID){
        player p = new player();

        try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/pc_games_db","root","loay1999");
            PreparedStatement ps = con.prepareStatement("select * from players where players.gamerID=?");
            ps.setString(1,gamerID);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                p.setGamerID(rs.getString("gamerID"));
                p.setGamerName(rs.getString("gamerName"));
                p.setDOB((rs.getString("DOB")));
                p.setEmail(rs.getString("email"));
                p.setDate_joined(rs.getString("date_joined"));
            }
        }catch(Exception e){
            System.out.println(e);
        }
        return p;
    }
    public player playerSignin(String gamerID, String password){
        player p = new player();
        try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/pc_games_db","root","loay1999");
            PreparedStatement ps = con.prepareStatement("select * from players where players.gamerID=?");
            ps.setString(1,gamerID);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                p.setGamerID(rs.getString("gamerID"));
                p.setGamerName(rs.getString("gamerName"));
                p.setDOB((rs.getString("DOB")));
                p.setEmail(rs.getString("email"));
                p.setDate_joined(rs.getString("date_joined"));
            }

            PreparedStatement ps2 = con.prepareStatement("select * from login_g where login_g.gamerID=?");
            ps2.setString(1,gamerID);
            ResultSet rs2 = ps2.executeQuery();
            if(rs2.next()) {
                if(rs2.getString("password").equals(password)){
                    return p;
                }
            }
        }catch(Exception e){
            System.out.println(e);
        }

        return null;
    }

    public void addGame(String gamerID, String gameID){
        try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/pc_games_db","root","loay1999");
            PreparedStatement ps = con.prepareStatement("insert into players_games (gamerID, gameID) VALUES (?, ?)");
            ps.setString(1,gamerID);
            ps.setInt(2,Integer.parseInt(gameID));
            ps.executeUpdate();
            con.close();
            System.out.println("Added game " + gameID + " for player " + gamerID);
        }catch(Exception e){
            System.out.println(e);
        }
    }

    public void removeGame(String gamerID, String gameID) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/pc_games_db","root","loay1999");
            PreparedStatement ps = con.prepareStatement("DELETE FROM players_games WHERE gamerID = ? AND gameID = ?");
            ps.setString(1,gamerID);
            ps.setInt(2,Integer.parseInt(gameID));
            ps.executeUpdate();
            con.close();
            System.out.println("Removed game " + gameID + " from player " + gamerID);
        } catch(Exception e){
            e.printStackTrace();
        }

    }

    public boolean addPlayer(String gamerID, String gamerName, String DOB, String email, String date_joined, String password){
        try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/pc_games_db","root","loay1999");
            PreparedStatement ps0 = con.prepareStatement("select COUNT(*) from players where gamerID=?");
            ps0.setString(1,gamerID);
            ResultSet rs = ps0.executeQuery();
            int n = 0;
            if(rs.next()){
                n = rs.getInt(1);
            }
            if(n<1){
                PreparedStatement ps = con.prepareStatement("insert into login_g (gamerID, password) VALUES (?, ?)");
                ps.setString(1,gamerID);
                ps.setString(2,password);
                ps.executeUpdate();
                PreparedStatement ps2 = con.prepareStatement("INSERT into players (gamerID, gamerName, DOB, email, date_joined) VALUES (?, ?, ?, ?, ?)");
                ps2.setString(1,gamerID);
                ps2.setString(2,gamerName);
                ps2.setString(3,DOB);
                ps2.setString(4,email);
                ps2.setString(5,date_joined);
                ps2.executeUpdate();
                con.close();
                System.out.println("player added");
                return true;
            }else{
                return false;
            }

        }catch (Exception e){
            System.out.println(e);
            return false;
        }
    }

    public boolean checkPassword(String gamerID, String password){
        player p = new player();
        try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/pc_games_db","root","loay1999");
            PreparedStatement ps2 = con.prepareStatement("select * from login_g where login_g.gamerID=?");
            ps2.setString(1,gamerID);
            ResultSet rs2 = ps2.executeQuery();
            if(rs2.next()) {
                if(rs2.getString("password").equals(password)){
                    return true;
                }
            }
        }catch(Exception e){
            System.out.println(e);
        }
        return false;
    }

    public boolean changePassword(String gamerID, String password){
        player p = new player();
        try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/pc_games_db","root","loay1999");
            PreparedStatement ps = con.prepareStatement("Update login_g SET password=? where gamerID=?");
            ps.setString(1,password);
            ps.setString(2,gamerID);
            ps.executeUpdate();
            return true;
        }catch(Exception e){
            System.out.println(e);
        }
        return false;
    }

    public boolean changeName(String gamerID, String gamerName){
        player p = new player();
        try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/pc_games_db","root","loay1999");
            PreparedStatement ps = con.prepareStatement("Update players SET gamerName=? where gamerID=?");
            ps.setString(1,gamerName);
            ps.setString(2,gamerID);
            ps.executeUpdate();
            return true;
        }catch(Exception e){
            System.out.println(e);
        }
        return false;
    }
    public boolean changeEmail(String gamerID, String email){
        player p = new player();
        try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/pc_games_db","root","loay1999");
            PreparedStatement ps = con.prepareStatement("Update players SET email=? where gamerID=?");
            ps.setString(1,email);
            ps.setString(2,gamerID);
            ps.executeUpdate();
            return true;
        }catch(Exception e){
            System.out.println(e);
        }
        return false;
    }

    public ArrayList<player> getPlayersByGameID(int gameID){
        ArrayList<player> players = new ArrayList<>();
        try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/pc_games_db","root","loay1999");
            PreparedStatement ps = con.prepareStatement("select * from players as p, players_games as pg where p.gamerID=pg.gamerID and pg.gameID=?");
            ps.setInt(1,gameID);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                player p = new player();
                p.setGamerID(rs.getString("gamerID"));
                p.setEmail(rs.getString("email"));
                p.setDOB(rs.getString("DOB"));
                p.setDate_joined(rs.getString("date_joined"));
                p.setGamerName(rs.getString("gamerName"));
                players.add(p);
            }
        }catch(Exception e){
            System.out.println(e);
        }
        return players;
    }

}
