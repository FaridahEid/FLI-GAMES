package com.PC_Games_DB.games;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class Game {
    private int gameID;
    private String gname;
    private int year;
    private String genre;
    private int downloads;
    private ArrayList<String> platform;
    private String publisher;
    private String developer;

    public int getGameID() {
        return gameID;
    }

    public String getGname() {
        return gname;
    }

    public int getYear() {
        return year;
    }

    public String getGenre() {
        return genre;
    }

    public int getDownloads() {
        return downloads;
    }

    public void setGameID(int gameID) {
        this.gameID = gameID;
    }

    public void setGname(String gname) {
        this.gname = gname;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public void setDownloads(int downloads) {
        this.downloads = downloads;
    }

    public ArrayList<String> getPlatform() {
        return platform;
    }

    public void setPlatform(ArrayList<String> platform) {
        this.platform = platform;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public String getDeveloper() {
        return developer;
    }

    public void setDeveloper(String developer) {
        this.developer = developer;
    }
}
