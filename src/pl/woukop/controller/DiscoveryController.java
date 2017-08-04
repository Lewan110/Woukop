package pl.woukop.controller;

import pl.woukop.model.Comment;
import pl.woukop.model.Discovery;
import pl.woukop.model.User;
import pl.woukop.service.CommentService;
import pl.woukop.service.DiscoveryService;

import java.io.IOException;
import java.util.List;

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
    	request.getSession().setAttribute("url", IDParam);
    	request.setAttribute("url", IDParam);
    	Discovery resultDiscovery=new Discovery();
    	DiscoveryService discoveryService = new DiscoveryService();
    	resultDiscovery=discoveryService.getDiscoveryById(IDParam);
    	request.getSession().setAttribute("discovery", resultDiscovery);
    	request.setAttribute("discovery", resultDiscovery);
    	
    	saveCommentsInRequest(request);
        	
        	
        
    	
    	
    	
    	
    	
    	
    	request.getRequestDispatcher("WEB-INF/discovery.jsp").forward(request, response);
    }
    	@Override
    	    protected void doPost(HttpServletRequest request, HttpServletResponse response) 
    	            throws ServletException, IOException {
    			}
    	private void saveCommentsInRequest(HttpServletRequest request) {
    		CommentService commentService=new CommentService();
    		List<Comment> allComments=commentService.getAllComments();
    		request.setAttribute("comments", allComments);
    	}
}