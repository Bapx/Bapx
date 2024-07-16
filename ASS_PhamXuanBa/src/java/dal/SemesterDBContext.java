/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

package dal;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Semester;
import model.User;

/**
 *
 * @author bapxh
 */
public class SemesterDBContext extends DBContext{
    
    
    public ArrayList<Semester> getSemesterByLectureId(int lid){
        ArrayList<Semester>listsemester = new ArrayList();
        
        PreparedStatement stm = null;
        try {
            String sql = "select s.semid , s.[year] , s.season,s.active from courses c join lecturers l on c.lid = l.lid join semester s on c.semid = s.semid\n" +
"where l.lid = ? and s.active = 0\n" +
"GROUP BY s.semid, s.[year], s.season, s.active;";
            
            stm = connection.prepareStatement(sql);
            stm.setInt(1, lid);
           
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                Semester se = new Semester();
                se.setId(rs.getInt("semid"));
                se.setYear(rs.getInt("year"));
                se.setSeasons(rs.getString("season"));
                se.setActive(rs.getInt("active"));
                listsemester.add(se);
            }

        } catch (SQLException ex) {
            Logger.getLogger(CourseDBContext.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                stm.close();
                connection.close();
            } catch (SQLException ex) {
                Logger.getLogger(CourseDBContext.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        
        
        
        
        return listsemester;
        
    }
    
    
    @Override
    public ArrayList all() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Object get(int id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
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
    public static void main(String[] args) {
        SemesterDBContext se= new SemesterDBContext();
        System.out.println(se.getSemesterByLectureId(1).get(0).getSeasons());
    }
}
