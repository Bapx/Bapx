/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

package controller;

import dal.GradeDBContext;
import dal.StudentDBContext;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import model.Grade;
import model.Student;

/**
 *
 * @author baophan
 */
@WebServlet(name="Take", urlPatterns={"/take"})
public class Take extends HttpServlet {
    
    /** 
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Take</title>");  
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet Take at " + request.getContextPath () + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    } 

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /** 
     * Handles the HTTP <code>GET</code> method.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        String eid = request.getParameter("eid");
        String cid = request.getParameter("cid");
        
        
        if(eid == null){
            request.setAttribute("cid", cid);
            request.getRequestDispatcher("/class").forward(request, response);
        }else{
            StudentDBContext sdbc = new StudentDBContext();
            ArrayList<Student> list = sdbc.getStudentsByCourse(Integer.parseInt(cid));
            
            
            for(int i =0;i< list.size();i++){
                GradeDBContext gdb = new GradeDBContext();
                int sid = list.get(i).getId();
                int eids = Integer.parseInt(eid);
                ArrayList<Grade> grades = new ArrayList<>();
                Grade grade = new Grade();
                double mark =  gdb.getScoreBySidAndEid(eids, sid);
                grade.setScore((float) mark);
                grades.add(grade);
                list.get(i).setGrades(grades);
                
            }
            
            
            
            
            request.setAttribute("cid", cid);
            request.setAttribute("eid", eid);
            request.setAttribute("studentList", list);
            request.getRequestDispatcher("add-mark.jsp").forward(request, response);
        }
    } 

    /** 
     * Handles the HTTP <code>POST</code> method.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        
        
        String eid = request.getParameter("eid");
        String cid = request.getParameter("cid");
        String[] studentList = request.getParameterValues("sid");
        String[] score = request.getParameterValues("score");
        PrintWriter out = response.getWriter();
        boolean check = true;
        for(String a: score) {
            if(a.isEmpty())check = false;
            else{
                double mark = Double.parseDouble(a);
                if(mark>10||mark<0) check = false;
            }
        }if(check){
            for(int i=0;i<studentList.length;i++){
                GradeDBContext gdb = new GradeDBContext();
                int eid1 = Integer.parseInt(eid);
                int sid = Integer.parseInt(studentList[i]);
                float score1 = (float) Double.parseDouble(score[i]);
                
                boolean check1 = gdb.checkScoreExist(eid1,sid );
                GradeDBContext aa = new GradeDBContext();
                if(check1)
                   
                    aa.updateScore(eid1, sid,score1 );
                else 
                   
                    aa.insertScore(eid1, sid, score1);
                 
            }   
           
            response.sendRedirect(request.getContextPath()+"/take?eid="+eid+"&cid="+cid);

        }
        else{
            StudentDBContext sdbc = new StudentDBContext();
            ArrayList<Student> list = sdbc.getStudentsByCourse(Integer.parseInt(cid));
            
            
            for(int i =0;i< list.size();i++){
                GradeDBContext gdb = new GradeDBContext();
                int sid = list.get(i).getId();
                int eids = Integer.parseInt(eid);
                ArrayList<Grade> grades = new ArrayList<>();
                Grade grade = new Grade();
                double mark =  gdb.getScoreBySidAndEid(eids, sid);
                grade.setScore((float) mark);
                grades.add(grade);
                list.get(i).setGrades(grades);
                
            }
            
            for(Student s: list){
               out.println(s.getGrades().get(0).getScore());
            }
            
            request.setAttribute("mess", "điểm không hợp lệ");
            request.setAttribute("cid", cid);
            request.setAttribute("eid", eid);
            request.setAttribute("studentList", list);
            request.getRequestDispatcher("add-mark.jsp").forward(request, response);
        }
        
    }

    /** 
     * Returns a short description of the servlet.
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}