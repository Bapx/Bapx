/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author baophan
 */
public class sInfo {
    private int sid;
    private int suid;
    private String cname;
    private String season;
    private int year;
    private Double everage;

    public sInfo() {
    }

    public sInfo(int sid, int suid, String cname, String season, int year, Double everage) {
        this.sid = sid;
        this.suid = suid;
        this.cname = cname;
        this.season = season;
        this.year = year;
        this.everage = everage;
    }

    public int getSid() {
        return sid;
    }

    public void setSid(int sid) {
        this.sid = sid;
    }

    public int getSuid() {
        return suid;
    }

    public void setSuid(int suid) {
        this.suid = suid;
    }

    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }

    public String getSeason() {
        return season;
    }

    public void setSeason(String season) {
        this.season = season;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public Double getEverage() {
        return everage;
    }

    public void setEverage(Double everage) {
        this.everage = everage;
    }
    
    
    
    
}
