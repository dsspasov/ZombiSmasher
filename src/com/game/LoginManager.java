package com.game;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.game.model.user.User;
import com.game.model.user.UserContainer;
import com.google.gson.JsonObject;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/loginManager")
public class LoginManager extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private UserContainer users;

	
	@Override
	public void init() throws ServletException {
		super.init();
		users = (UserContainer) getServletContext().getAttribute("users");
		if (users == null) {
			users = UserContainer.getInstance();
			getServletContext().setAttribute("users", users);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		boolean error = false;
		if(users.contains(username)) {
			User user = users.getUserByName(username);
			if(user.getPassword().equals(password)) {
				resp.setStatus(200);
			} else {
				error = true;
			}
		} else {
			error = true;
		}
		
		if(error){
			JsonObject respMessage = new JsonObject();
			respMessage.addProperty("error", "Invalid username or password for this user");
			resp.setStatus(401);
			resp.getWriter().append(respMessage.toString());
		}
	}

}
