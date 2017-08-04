package pl.woukop.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import pl.woukop.model.Discovery;
import pl.woukop.model.User;
import pl.woukop.service.CommentService;
/**
 * Servlet implementation class CommentAddController
 */
@WebServlet("/addcomment")
public class CommentAddController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CommentAddController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
        //pobranie tresci komentarza
		String content = request.getParameter("content");
		//pobranie ID znaleziska pod ktorym bedzie komentarz
        Long IDParam=(Long) request.getSession().getAttribute("url");
        //pobranie obiektu znaleziska 
        Discovery resDiscovery=(Discovery) request.getSession().getAttribute("discovery");
        //czy uzytkownik jest zalogowany
        User authenticatedUser = (User) request.getSession().getAttribute("user");
        if(request.getUserPrincipal() != null) {
        	
        	//tworzenie komentarza do bazy danych
        	CommentService commentService = new CommentService();
            commentService.addComment(content, resDiscovery, authenticatedUser);
            response.sendRedirect(request.getContextPath() + "/znalezisko?url="+IDParam);
        
        }
	}

}
