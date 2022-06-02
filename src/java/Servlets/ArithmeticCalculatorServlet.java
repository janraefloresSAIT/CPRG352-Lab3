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
public class ArithmeticCalculatorServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String result = "---";
        request.setAttribute("result", result);
        
        // LOAD JSP FROM SERVLET
        getServletContext().getRequestDispatcher("/WEB-INF/arithmeticcalculator.jsp").forward(request, response);
        return;
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // CAPTURE INPUTS
        String firstint = request.getParameter("first_int");
        String secondint = request.getParameter("second_int");
        String buttontype = request.getParameter("button_type");
        int output = 0;
        String result;
        
        // DEFAULT OUTPUT
        request.setAttribute("firstInt", firstint);
        request.setAttribute("secondInt", secondint);
        
        // VALIDATION
        if (firstint == null || firstint.equals("") || secondint == null || secondint.equals("")) {
            result = "invalid";
            request.setAttribute("result", result);
        }
        else if (!firstint.matches(".*[0-9999999].*") || !secondint.matches(".*[0-9999999].*")) {
            result = "invalid";
            request.setAttribute("result", result);
        }
        else {
            int first_input = Integer.parseInt(firstint);
            int second_input = Integer.parseInt(secondint);
            
            switch(buttontype) {
                case "+":
                    output = first_input + second_input;
                    request.setAttribute("result", output);
                    break;
                case "-":
                    output = first_input - second_input;
                    request.setAttribute("result", output);
                    break;
                case "*":
                    output = first_input * second_input;
                    request.setAttribute("result", output);
                    break;
                case "%":
                    output = first_input % second_input;
                    request.setAttribute("result", output);
                    break;
            }
        }
        getServletContext().getRequestDispatcher("/WEB-INF/arithmeticcalculator.jsp").forward(request, response);
        return;
    }
}
