package SERVLET;

import DAO.SemesterDAO;
import MODEL.Semester;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@WebServlet("/semester")
public class SemesterServlet extends HttpServlet {

    private final SemesterDAO semesterDAO = new SemesterDAO();

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        String action = request.getParameter("action");
//        
//        if (action == null) {
//            action = "list"; // Default action: list all semesters
//        }
//
//        switch (action) {
//            case "new":
//                showNewForm(request, response);
//                break;
//            case "create":
//                createSemester(request, response);
//                break;
//            case "edit":
//                showEditForm(request, response);
//                break;
//            case "update":
//                updateSemester(request, response);
//                break;
//            case "delete":
//                deleteSemester(request, response);
//                break;
//            default:
//                listSemesters(request, response);
//                break;
//        }
        
        listSemesters(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("I am at the start");
        //doGet(request, response);
        String semesterName = request.getParameter("semesterName");
        // Parse startingDate and endDate from request parameters
        LocalDate startingDate = LocalDate.parse(request.getParameter("startingDate"));
        LocalDate endDate = LocalDate.parse(request.getParameter("endDate"));
        System.out.println("I am in the middle");
        // Create a new Semester object
        Semester semester = new Semester(UUID.randomUUID(), semesterName, startingDate, endDate);
        semesterDAO.saveOrUpdateSemester(semester);
        System.out.println("I have saved");
        listSemesters(request, response);
        //response.sendRedirect("semester?action=list");
    }

    private void listSemesters(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Semester> semesters = semesterDAO.getAllSemesters();
        request.setAttribute("semesters", semesters);
        RequestDispatcher dispatcher = request.getRequestDispatcher("semester.jsp");
        dispatcher.forward(request, response);
    }

    private void showNewForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("semester-form.jsp");
        dispatcher.forward(request, response);
    }

    private void createSemester(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String semesterName = request.getParameter("semesterName");
        // Parse startingDate and endDate from request parameters
        LocalDate startingDate = LocalDate.parse(request.getParameter("startingDate"));
        LocalDate endDate = LocalDate.parse(request.getParameter("endDate"));

        // Create a new Semester object
        Semester semester = new Semester(UUID.randomUUID(), semesterName, startingDate, endDate);
        semesterDAO.saveOrUpdateSemester(semester);
        response.sendRedirect("semester?action=list");
    }

    private void showEditForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        UUID semesterId = UUID.fromString(request.getParameter("semesterId"));
        Semester existingSemester = semesterDAO.getSemesterById(semesterId);
        RequestDispatcher dispatcher = request.getRequestDispatcher("semester-form.jsp");
        request.setAttribute("semester", existingSemester);
        dispatcher.forward(request, response);
    }

    private void updateSemester(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        UUID semesterId = UUID.fromString(request.getParameter("semesterId"));
        String semesterName = request.getParameter("semesterName");
        // Parse startingDate and endDate from request parameters
       LocalDate startingDate = LocalDate.parse(request.getParameter("startingDate"));
       LocalDate endDate = LocalDate.parse(request.getParameter("endDate"));

        Semester semester = new Semester(semesterId, semesterName, startingDate, endDate);
        semesterDAO.saveOrUpdateSemester(semester);
        response.sendRedirect("semester?action=list");
    }

    private void deleteSemester(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        UUID semesterId = UUID.fromString(request.getParameter("semesterId"));
        semesterDAO.deleteSemester(semesterId);
        response.sendRedirect("semester?action=list");
    }
}
