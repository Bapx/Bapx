/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

package controller;

import dal.CourseDBContext;
import dal.LectureDBContext;
import dal.SemesterDBContext;
import dal.UserDBContext;
import dal.sInfoDBContext;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import model.Course;
import model.Exam;
import model.Semester;
import model.User;
import model.sInfo;

/**
 *
 * @author baophan
 */
@WebServlet(name="Login", urlPatterns={"/login"})
public class Login extends HttpServlet {
   
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
            out.println("<title>Servlet Login</title>");  
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet Login at " + request.getContextPath () + "</h1>");
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
        response.sendRedirect("login.jsp");
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
        String username= request.getParameter("username");
        String password = request.getParameter("pass");
        UserDBContext userContext = new UserDBContext();
        
        User user = userContext.getUser(username, password);
        if(user!=null){
            UserDBContext uContext = new UserDBContext();
            if(uContext.isLecture(username)){
                CourseDBContext db = new CourseDBContext();
                LectureDBContext lectureDBContext = new LectureDBContext();
                SemesterDBContext semesterDBContext = new SemesterDBContext();
                int lid = lectureDBContext.getLectureIdByUserName(username);
                ArrayList<Course> listcourse= db.filterByLecturerID(lid);
                ArrayList<Semester> listSemester =semesterDBContext.getSemesterByLectureId(lid); 
                request.setAttribute("displayName", user.getDisplayName());
                request.setAttribute("listcourse", listcourse);
                request.setAttribute("semesterList",listSemester );
                request.getRequestDispatcher("home-lecture.jsp").forward(request, response);
            }
            else{
                
                UserDBContext userDBContext = new UserDBContext();
                int id = userDBContext.getSid(username);
                sInfoDBContext sdb = new sInfoDBContext();
                ArrayList<sInfo> list = sdb.getListBySid(id);
                request.setAttribute("user",user);
                request.setAttribute("list", list);
                
                PrintWriter out = response.getWriter();
                out.println(id);
                
                request.getRequestDispatcher("student-home.jsp").forward(request, response);
            }
            
        }else {
            request.setAttribute("mess", "account invalid");  
            request.getRequestDispatcher("login.jsp").forward(request, response);
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
