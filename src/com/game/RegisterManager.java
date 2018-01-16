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
import com.google.gson.JsonParser;

/**
 * Servlet implementation class RegisterManager
 */
@WebServlet("/registerManager")
public class RegisterManager extends HttpServlet {
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
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String data = RequestBodyReader.read(request.getReader());
		System.out.println(data);
		JsonObject obj = (JsonObject) new JsonParser().parse(data);

		String username = obj.get("username").getAsString();
		String password = obj.get("password").getAsString();
		String address = obj.get("address").getAsString();
		String email = obj.get("email").getAsString();
		int age = obj.get("age").getAsInt();

		if (users.contains(username)) {
			JsonObject respMessage = new JsonObject();
			respMessage.addProperty("error",
					"There is already a user with this username");
			response.setStatus(409);
			response.getWriter().append(respMessage.toString());
		} else {
			User user = new User(username, password, email, age, address);
			users.addUser(user);
			// return user's id
			JsonObject resp = new JsonObject();
			resp.addProperty("id", user.getId());
			response.getWriter().write(resp.toString());
		}
	}

}
