package com.yotam.simple_cookie;

import java.io.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/servlet2")
public class SecondServlet extends HttpServlet {

	public void doPost(HttpServletRequest request, HttpServletResponse response) {

		try {
			response.setContentType("text/html");
			PrintWriter out = response.getWriter();

			Cookie ck[] = request.getCookies();
			String name = "Not Found";
			for (Cookie c: ck) {
				if (c.getName().equals("uname")) {
					name = c.getValue();
					break;
				}
			}
			out.print("Hello " + name);

			out.close();

		} catch (Exception e) {
			System.out.println(e);
		}
	}

}
