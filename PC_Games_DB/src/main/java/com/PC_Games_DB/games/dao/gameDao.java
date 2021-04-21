package com.PC_Games_DB.games.dao;

import com.PC_Games_DB.games.Game;
import java.sql.*;
import java.util.ArrayList;

public class gameDao {
    public Game getGame(int gameID){
        Game g = new Game();
        try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/pc_games_db","root","loay1999");
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("select * from games where gameID="+gameID);
            if(rs.next()){
                g.setGameID(rs.getInt("gameID"));
                g.setGname(rs.getString("gname"));
                g.setGenre(rs.getString("genre"));
                g.setYear(rs.getInt("year"));
                g.setDownloads(rs.getInt("downloads"));
            }
        }catch(Exception e){
            System.out.println(e);
        }
        return g;
    }
    public ArrayList<Game> getGamesByGamerID(String gamerID){
        ArrayList<Game> games = new ArrayList<>();
        try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/pc_games_db","root","loay1999");
            PreparedStatement ps = con.prepareStatement("select * from players_games as pg, games as g where pg.gamerID=? and g.gameID=pg.gameID");
            ps.setString(1,gamerID);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                Game g = new Game();
                g.setGameID(rs.getInt("gameID"));
                g.setGname(rs.getString("gname"));
                g.setGenre(rs.getString("genre"));
                g.setYear(rs.getInt("year"));
                g.setDownloads(rs.getInt("downloads"));
                PreparedStatement ps2 = con.prepareStatement("select * from distribution_services where gamesID=?");
                ps2.setInt(1,g.getGameID());
                ResultSet rs2 = ps2.executeQuery();
                ArrayList<String> ds = new ArrayList<>();
                while(rs2.next()){
                    ds.add(rs2.getString("disName"));
                }
                g.setPlatform(ds);
                games.add(g);
            }
        }catch(Exception e){
            System.out.println(e);
        }
        return games;
    }
    public ArrayList<Game> getGamesByPublisherID(String publisherID){
        ArrayList<Game> games = new ArrayList<>();
        try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/pc_games_db","root","loay1999");
            PreparedStatement ps = con.prepareStatement("select * from publishers_games as pg, games as g where pg.publisherID=? and g.gameID=pg.gameID");
            ps.setString(1,publisherID);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                Game g = new Game();
                g.setGameID(rs.getInt("gameID"));
                g.setGname(rs.getString("gname"));
                g.setGenre(rs.getString("genre"));
                g.setYear(rs.getInt("year"));
                g.setDownloads(rs.getInt("downloads"));
                PreparedStatement ps2 = con.prepareStatement("select * from distribution_services where gamesID=?");
                ps2.setInt(1,g.getGameID());
                ResultSet rs2 = ps2.executeQuery();
                ArrayList<String> ds = new ArrayList<>();
                while(rs2.next()){
                    ds.add(rs2.getString("disName"));
                }
                g.setPlatform(ds);
                PreparedStatement ps3 = con.prepareStatement("select * from gamedev_games as g, gamedev as gd where g.devID=gd.devID and g.gameID=?");
                ps3.setInt(1,g.getGameID());
                ResultSet rs3 = ps3.executeQuery();

                if(rs3.next()){
                    g.setDeveloper(rs3.getString("dname"));
                }

                games.add(g);
            }
        }catch(Exception e){
            System.out.println(e);
        }
        return games;
    }
    public ArrayList<Game> getGamesByGameDevID(String devID){
        ArrayList<Game> games = new ArrayList<>();
        try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/pc_games_db","root","loay1999");
            PreparedStatement ps = con.prepareStatement("select * from gamedev_games as pg, games as g where pg.devID=? and g.gameID=pg.gameID");
            ps.setString(1,devID);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                Game g = new Game();
                g.setGameID(rs.getInt("gameID"));
                g.setGname(rs.getString("gname"));
                g.setGenre(rs.getString("genre"));
                g.setYear(rs.getInt("year"));
                g.setDownloads(rs.getInt("downloads"));
                PreparedStatement ps2 = con.prepareStatement("select * from distribution_services where gamesID=?");
                ps2.setInt(1,g.getGameID());
                ResultSet rs2 = ps2.executeQuery();
                ArrayList<String> ds = new ArrayList<>();
                while(rs2.next()){
                    ds.add(rs2.getString("disName"));
                }
                g.setPlatform(ds);
                games.add(g);
            }
        }catch(Exception e){
            System.out.println(e);
        }
        return games;
    }
    public ArrayList<Game> getAllGamesForPlayer(){
        ArrayList<Game> games = new ArrayList<>();
        try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/pc_games_db","root","loay1999");
            PreparedStatement ps = con.prepareStatement("select * from games");
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                Game g = new Game();
                g.setGameID(rs.getInt("gameID"));
                g.setGname(rs.getString("gname"));
                g.setGenre(rs.getString("genre"));
                g.setYear(rs.getInt("year"));
                g.setDownloads(rs.getInt("downloads"));
                PreparedStatement ps2 = con.prepareStatement("select * from distribution_services where gamesID=?");
                ps2.setInt(1,g.getGameID());
                ResultSet rs2 = ps2.executeQuery();
                ArrayList<String> ds = new ArrayList<>();
                while(rs2.next()){
                    ds.add(rs2.getString("disName"));
                }
                g.setPlatform(ds);
                games.add(g);
            }
        }catch (Exception e){
            System.out.println(e);
        }

        return games;
    }
    public ArrayList<Game> getAllGamesForPlayerNamesAsc(){
        ArrayList<Game> games = new ArrayList<>();
        try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/pc_games_db","root","loay1999");
            PreparedStatement ps = con.prepareStatement("select * from games ORDER BY gname ASC");
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                Game g = new Game();
                g.setGameID(rs.getInt("gameID"));
                g.setGname(rs.getString("gname"));
                g.setGenre(rs.getString("genre"));
                g.setYear(rs.getInt("year"));
                g.setDownloads(rs.getInt("downloads"));
                PreparedStatement ps2 = con.prepareStatement("select * from distribution_services where gamesID=?");
                ps2.setInt(1,g.getGameID());
                ResultSet rs2 = ps2.executeQuery();
                ArrayList<String> ds = new ArrayList<>();
                while(rs2.next()){
                    ds.add(rs2.getString("disName"));
                }
                g.setPlatform(ds);
                games.add(g);
            }
        }catch (Exception e){
            System.out.println(e);
        }

        return games;
    }
    public ArrayList<Game> getAllGamesForPlayerNamesDesc(){
        ArrayList<Game> games = new ArrayList<>();
        try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/pc_games_db","root","loay1999");
            PreparedStatement ps = con.prepareStatement("select * from games ORDER BY gname DESC");
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                Game g = new Game();
                g.setGameID(rs.getInt("gameID"));
                g.setGname(rs.getString("gname"));
                g.setGenre(rs.getString("genre"));
                g.setYear(rs.getInt("year"));
                g.setDownloads(rs.getInt("downloads"));
                PreparedStatement ps2 = con.prepareStatement("select * from distribution_services where gamesID=?");
                ps2.setInt(1,g.getGameID());
                ResultSet rs2 = ps2.executeQuery();
                ArrayList<String> ds = new ArrayList<>();
                while(rs2.next()){
                    ds.add(rs2.getString("disName"));
                }
                g.setPlatform(ds);
                games.add(g);
            }
        }catch (Exception e){
            System.out.println(e);
        }

        return games;
    }
    public ArrayList<Game> getAllGamesForPlayerYearsAsc(){
        ArrayList<Game> games = new ArrayList<>();
        try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/pc_games_db","root","loay1999");
            PreparedStatement ps = con.prepareStatement("select * from games ORDER BY year ASC");
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                Game g = new Game();
                g.setGameID(rs.getInt("gameID"));
                g.setGname(rs.getString("gname"));
                g.setGenre(rs.getString("genre"));
                g.setYear(rs.getInt("year"));
                g.setDownloads(rs.getInt("downloads"));
                PreparedStatement ps2 = con.prepareStatement("select * from distribution_services where gamesID=?");
                ps2.setInt(1,g.getGameID());
                ResultSet rs2 = ps2.executeQuery();
                ArrayList<String> ds = new ArrayList<>();
                while(rs2.next()){
                    ds.add(rs2.getString("disName"));
                }
                g.setPlatform(ds);
                games.add(g);
            }
        }catch (Exception e){
            System.out.println(e);
        }

        return games;
    }
    public ArrayList<Game> getAllGamesForPlayerYearsDesc(){
        ArrayList<Game> games = new ArrayList<>();
        try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/pc_games_db","root","loay1999");
            PreparedStatement ps = con.prepareStatement("select * from games ORDER BY year DESC");
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                Game g = new Game();
                g.setGameID(rs.getInt("gameID"));
                g.setGname(rs.getString("gname"));
                g.setGenre(rs.getString("genre"));
                g.setYear(rs.getInt("year"));
                g.setDownloads(rs.getInt("downloads"));
                PreparedStatement ps2 = con.prepareStatement("select * from distribution_services where gamesID=?");
                ps2.setInt(1,g.getGameID());
                ResultSet rs2 = ps2.executeQuery();
                ArrayList<String> ds = new ArrayList<>();
                while(rs2.next()){
                    ds.add(rs2.getString("disName"));
                }
                g.setPlatform(ds);
                games.add(g);
            }
        }catch (Exception e){
            System.out.println(e);
        }

        return games;
    }
    public ArrayList<Game> getAllGamesForPlayerSearchYear(int year){
        ArrayList<Game> games = new ArrayList<>();
        try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/pc_games_db","root","loay1999");
            PreparedStatement ps = con.prepareStatement("select * from games where year=?");
            ps.setInt(1,year);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                Game g = new Game();
                g.setGameID(rs.getInt("gameID"));
                g.setGname(rs.getString("gname"));
                g.setGenre(rs.getString("genre"));
                g.setYear(rs.getInt("year"));
                g.setDownloads(rs.getInt("downloads"));
                PreparedStatement ps2 = con.prepareStatement("select * from distribution_services where gamesID=?");
                ps2.setInt(1,g.getGameID());
                ResultSet rs2 = ps2.executeQuery();
                ArrayList<String> ds = new ArrayList<>();
                while(rs2.next()){
                    ds.add(rs2.getString("disName"));
                }
                g.setPlatform(ds);
                games.add(g);
            }
        }catch (Exception e){
            System.out.println(e);
        }

        return games;
    }
    public ArrayList<Game> getAllGamesForPlayerSearchGenre(String genre){
        ArrayList<Game> games = new ArrayList<>();
        try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/pc_games_db","root","loay1999");
            PreparedStatement ps = con.prepareStatement("select * from games where genre like ?");
            ps.setString(1,"%"+ genre + "%");
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                Game g = new Game();
                g.setGameID(rs.getInt("gameID"));
                g.setGname(rs.getString("gname"));
                g.setGenre(rs.getString("genre"));
                g.setYear(rs.getInt("year"));
                g.setDownloads(rs.getInt("downloads"));
                PreparedStatement ps2 = con.prepareStatement("select * from distribution_services where gamesID=?");
                ps2.setInt(1,g.getGameID());
                ResultSet rs2 = ps2.executeQuery();
                ArrayList<String> ds = new ArrayList<>();
                while(rs2.next()){
                    ds.add(rs2.getString("disName"));
                }
                g.setPlatform(ds);
                games.add(g);
            }
        }catch (Exception e){
            System.out.println(e);
        }

        return games;
    }
    public ArrayList<Game> getAllGamesForPlayerSearchName(String name){
        ArrayList<Game> games = new ArrayList<>();
        try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/pc_games_db","root","loay1999");
            PreparedStatement ps = con.prepareStatement("select * from games where gname LIKE ?");
            ps.setString(1,"%" + name + "%");
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                Game g = new Game();
                g.setGameID(rs.getInt("gameID"));
                g.setGname(rs.getString("gname"));
                g.setGenre(rs.getString("genre"));
                g.setYear(rs.getInt("year"));
                g.setDownloads(rs.getInt("downloads"));
                PreparedStatement ps2 = con.prepareStatement("select * from distribution_services where gamesID=?");
                ps2.setInt(1,g.getGameID());
                ResultSet rs2 = ps2.executeQuery();
                ArrayList<String> ds = new ArrayList<>();
                while(rs2.next()){
                    ds.add(rs2.getString("disName"));
                }
                g.setPlatform(ds);
                games.add(g);
            }
        }catch (Exception e){
            System.out.println(e);
        }

        return games;
    }
    public ArrayList<Game> getAllGamesForPlayerSearchPlatform(String platform){
        ArrayList<Game> games = new ArrayList<>();
        try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/pc_games_db","root","loay1999");
            PreparedStatement ps = con.prepareStatement("select * from games as g, (select gamesID from distribution_services where disName Like ? ) as A where g.gameID=A.gamesID");
            ps.setString(1,"%" + platform + "%");
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                Game g = new Game();
                g.setGameID(rs.getInt("gameID"));
                g.setGname(rs.getString("gname"));
                g.setGenre(rs.getString("genre"));
                g.setYear(rs.getInt("year"));
                g.setDownloads(rs.getInt("downloads"));
                PreparedStatement ps2 = con.prepareStatement("select * from distribution_services where gamesID=?");
                ps2.setInt(1,g.getGameID());
                ResultSet rs2 = ps2.executeQuery();
                ArrayList<String> ds = new ArrayList<>();
                while(rs2.next()){
                    ds.add(rs2.getString("disName"));
                }
                g.setPlatform(ds);
                games.add(g);
            }
        }catch (Exception e){
            System.out.println(e);
        }

        return games;
    }
}
