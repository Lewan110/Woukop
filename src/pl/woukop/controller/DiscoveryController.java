package pl.woukop.controller;

import pl.woukop.model.Discovery;
import pl.woukop.service.DiscoveryService;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import pl.woukop.service.UserService;
 
@WebServlet("/znalezisko")
public class DiscoveryController extends HttpServlet {
    private static final long serialVersionUID = 1L;
 
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    	Long IDParam=Long.valueOf(request.getParameter("url"));
    	Discovery resultDiscovery=new Discovery();
    	DiscoveryService discoveryService = new DiscoveryService();
    	resultDiscovery=discoveryService.getDiscoveryById(IDParam);
    	request.setAttribute("discovery", resultDiscovery);
    
        
        
    	request.getRequestDispatcher("WEB-INF/discovery.jsp").forward(request, response);
         
        
    }
}