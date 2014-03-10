package com.supinfo.supcrowdfunding.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.supinfo.supcrowdfunding.entity.User;
import com.supinfo.supcrowdfunding.entity.UserDao;

/**
 * Servlet implementation class AddUserServlet
 */
@WebServlet(urlPatterns = {"/subscribe","/auth/admin/userManagement/addUser"} )
public class AddUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddUserServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		// TODO Auto-generated method stub
		RequestDispatcher rd = null;
		rd = request.getRequestDispatcher("/subscribe.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		req.setCharacterEncoding("UTF-8");
		boolean errors = false;
		
			
		String url = req.getRequestURL().toString();
		
		String pseudo = req.getParameter("pseudo");
		String password = req.getParameter("password");
		String pass2 = req.getParameter("pass2");
		String nom = req.getParameter("nom");
		String prenom = req.getParameter("prenom");
		String mail = req.getParameter("mail");
		
		User usr = UserDao.findUserByPseudo(pseudo);
		
		int type= 1 ;
		RequestDispatcher rd ;
		if (usr != null || pseudo == null || pass2 == null || password.trim().isEmpty() || mail == null || nom.trim().isEmpty() || prenom.trim().isEmpty() || ( !(password.equals(pass2))) ) {
			errors = true;
		}
		
		if (errors) {
			req.setAttribute("errors", true);
			if(url.contains("addUser")){
				rd = req.getRequestDispatcher("/auth/admin/usersManagement");
			}else{
			rd = req.getRequestDispatcher("/subscribe.jsp");
			}
		} else {

			User user = new User();
			user.setPseudo(pseudo);
			user.setPassword(password);
			user.setName(nom);
			user.setFirstname(prenom);
			user.setMail(mail);
			user.setRole(type);

			UserDao.addUser(user);
			
			if(url.contains("addUser")){
				rd = req.getRequestDispatcher("/auth/admin/usersManagement");
			}else{
				
				req.setAttribute("username", pseudo);
				req.setAttribute("password", password);
				
				rd = req.getRequestDispatcher("/login");
				
			}
				
				
		}

		rd.forward(req, resp);
		
	}

}
