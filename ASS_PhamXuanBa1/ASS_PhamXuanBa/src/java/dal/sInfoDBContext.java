/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dal;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Lecturer;
import model.User;
import model.sInfo;

/**
 *
 * @author baophan
 */
public class sInfoDBContext extends DBContext{

    public ArrayList<sInfo>getListBySid(int sid){
        ArrayList <sInfo> list = new ArrayList<>();
        
        PreparedStatement stm =null;
        
        try {
            String sql = "select  sc.sid, c.cname ,c.subid,s.season,s.year from students_courses sc \n" +
"join courses c on c.cid = sc.cid\n" +
"join semester s on s.semid = c.semid\n" +
"where    sc.sid =?";
            stm = connection.prepareStatement(sql);
            stm.setInt(1, sid);
            ResultSet rs = stm.executeQuery();
            while(rs.next())
            {
               sInfo s = new sInfo();
               s.setSid(rs.getInt("sid"));
               s.setCname(rs.getString("cname"));
               int subid = rs.getInt("subid");
               s.setSuid(subid);
               s.setSeason(rs.getString("season"));
               s.setYear(rs.getInt("year"));
               GradeDBContext gdb = new GradeDBContext();
               
               double everage = gdb.getEverageBySidAndSuid(sid, subid);
               s.setEverage(everage);
               list.add(s);
            }
            return list;
        } catch (SQLException ex) {
            Logger.getLogger(UserDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally
        {
            try {
                stm.close();
                connection.close();
            } catch (SQLException ex) {
                Logger.getLogger(UserDBContext.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return null;
    
        
    }
    
    
    
    
    @Override
    public void insert(Object model) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void update(Object model) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void delete(Object model) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Object get(int id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public static void main(String[] args) {
        sInfoDBContext s = new sInfoDBContext();
        System.out.println(s.getListBySid(1).get(1).getEverage());
    }

    @Override
    public ArrayList all() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
