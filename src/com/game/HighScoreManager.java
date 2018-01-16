package com.game;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.game.model.user.UserContainer;
import com.game.model.user.UserHighScoreStat;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

/**
 * Servlet implementation class HighScoreManager
 */
@WebServlet("/highScoreManager")
public class HighScoreManager extends HttpServlet {
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
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String limitParam = request.getParameter("limit");
		int limit = Integer.valueOf(limitParam);
		
		List<UserHighScoreStat> topUsers = users.getTopUsers(limit);
		Gson gson = new GsonBuilder().create();
		String jsonResult = gson.toJson(topUsers);
		
		response.setStatus(200);
		response.getWriter().append(jsonResult);
		
	}
}
