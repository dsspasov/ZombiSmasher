package com.game;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.game.model.user.UserContainer;
import com.game.model.user.UserScore;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import com.google.gson.JsonParser;

/**
 * Servlet implementation class LevelManager
 */
@WebServlet("/levelManager")
public class LevelManager extends HttpServlet {
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
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String data = RequestBodyReader.read(request.getReader());
		
		JsonObject obj = (JsonObject) new JsonParser().parse(data);
		int id = obj.get("id").getAsInt();
		int levelN = obj.get("levelNo").getAsInt();
		int points = obj.get("points").getAsInt();
		
		users.addScore(new UserScore(id, levelN, points));
		response.setStatus(200);
	}
}
