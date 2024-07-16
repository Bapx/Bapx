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
import model.Assessment;
import model.Exam;
import model.Grade;
import model.Student;
import model.Subject;

/**
 *
 * @author bapxh
 */
public class GradeDBContext extends DBContext{
    
    public ArrayList<Grade> listByStudentAndCourse(int sid,int cid){
        
        ArrayList<Grade> listGrade = new ArrayList<>();
        
        String sql ="select st.sid,st.sname , e.eid ,a.aname,a.weight, g.score from courses c join subjects s on c.subid = s.subid\n" +
"join assesments a on a.subid = s.subid\n" +
"join exams e on e.aid =a.aid\n" +
"join grades g on g.eid = e.eid\n" +
"join students st on st.sid = g.sid\n" +
"where cid=? and st.sid = ?";
        
        
        PreparedStatement stm = null;
        try {

            stm = connection.prepareStatement(sql);
            stm.setInt(1, cid);
            stm.setInt(2, sid);
            
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                
                Grade grade = new Grade();
            
                Exam exam = new Exam();
                
                Student student = new Student();
                student.setId(rs.getInt("sid"));
                student.setName(rs.getString("sname"));
                exam.setAssessment(new Assessment(rs.getString("aname")));
                grade.setExam(exam);
                grade.setStudent(student);
                grade.setScore(rs.getInt("score"));
                listGrade.add(grade);
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
        return listGrade;
    }
    
    public boolean checkScoreExist(int eid , int sid){
        String sql = "SELECT count(*)\n" +
        "  FROM grades\n" +
        " where eid = ? and sid = ?";
        boolean result = true;
        PreparedStatement stm = null;
        int count = 0;
        try {
            
            
            
            stm = connection.prepareStatement(sql);
            stm.setInt(1, eid);
            stm.setInt(2, sid);
            
            ResultSet rs = stm.executeQuery();
            if (rs.next()) {
                
               count = rs.getInt(1);
                
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
        
        if(count == 0)result = false;
        
        return result;
    }
    public double getScoreBySidAndEid(int eid, int  sid){
        String sql = "SELECT *\n" +
            "  FROM grades\n" +
            "  where eid=? and sid=?";
        double score = 0;
        PreparedStatement stm = null;
        try {
            
            
            
            stm = connection.prepareStatement(sql);
            stm.setInt(1, eid);
            stm.setInt(2, sid);
            
            ResultSet rs = stm.executeQuery();
            if (rs.next()) {
                
                score =rs.getDouble("score");
                
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
        return score;
        
    }
    
    public void insertScore(int eid,int sid,float score){
        String sql = "INSERT INTO grades (eid,sid,score)\n" +
        "     VALUES\n" +
        "    (?,?,?)";
        
        PreparedStatement stm = null;
        try {
            stm = connection.prepareStatement(sql);
            stm.setInt(1, eid);
            stm.setInt(2, sid);
            stm.setDouble(3, score);
            stm.executeUpdate();
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
    }
    
    public void updateScore(int eid,int sid,float score){
        String sql = "UPDATE grades\n" +
    "   SET \n" +
    "      score= ?\n" +
    " WHERE eid = ? and sid=?";
        
        PreparedStatement stm = null;
        try {
            stm = connection.prepareStatement(sql);
            stm.setInt(2, eid);
            stm.setInt(3, sid);
            stm.setDouble(1, score);
            stm.executeUpdate();
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
         GradeDBContext gradeDBContext = new GradeDBContext();
         gradeDBContext.insertScore(11, 4, (float) 199);
        
    }
}
