package it.enaip.cinema;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;




/**
 * Servlet implementation class Controller
 */
@WebServlet("/Controller")
public class Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
 
    public Controller() {
        super();
        // TODO Auto-generated constructor stub
    }

    private Sala sala = Sala.getInstance();
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		doPost(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
	    String op = request.getParameter("op");
		   
	    
		try {
			switch(op) {
		
			
			case "new":
				insertSpec(request, response);
				break;
			case "delete":
				deleteTable(request, response);
				break;
			case "allSpect":
				allSpectS(request, response);
				break;
			default:
				allSpectS(request, response);
				break;
			}

		}catch(Exception e){		
			System.out.println("exception in switch....");
		}
		
		
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	private void allSpectS(HttpServletRequest request, HttpServletResponse response) {
	
		List<Spettatore> list = new ArrayList();
		
		list = sala.getAll();
		RequestDispatcher dispatcher = request.getRequestDispatcher("/SpectList.jsp");

		
		request.setAttribute("spectList", list);
		
		try {
			
			dispatcher.forward(request, response);
			
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

	private void deleteTable(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		
	}

	private void insertSpec(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		
	}

}
