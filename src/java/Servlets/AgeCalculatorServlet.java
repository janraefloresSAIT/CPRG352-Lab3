package Servlets;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author janraeSAIT
 */
public class AgeCalculatorServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // LOAD JSP FROM SERVLET
        getServletContext().getRequestDispatcher("/WEB-INF/agecalculator.jsp").forward(request, response);
        return;
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // CAPTURE CURRENT AGE INPUT
        String currentage = request.getParameter("current_age");
        String errormessage;
        String message;

        // VALIDATION
        if (currentage == null || currentage.equals("")) {
            errormessage = "You must give your current age.";
            request.setAttribute("errorMessage", errormessage);
        }
        else if(!currentage.matches(".*[0-99999].*")){
             errormessage = "You must enter a number.";
             request.setAttribute("errorMessage", errormessage);
        }
        else {
            int age = Integer.parseInt(currentage);
            age++;
            
            message = "Your age next birthday will be " + age;
            request.setAttribute("message", message);
        }
        
        getServletContext().getRequestDispatcher("/WEB-INF/agecalculator.jsp").forward(request, response);
        return;

//        // SETUP ATTRIBUTE
//        request.setAttribute("currentAge", currentage);
//        
//        // LOAD JSP AGAIN
//        getServletContext().getRequestDispatcher("/WEB-INF/agecalculator.jsp").forward(request, response);
//        return;
    }

}
