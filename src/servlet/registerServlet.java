package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.UserService;
import service.UserServiceImpl;


import model.Users;

public class registerServlet extends HttpServlet {

	private static final long serialVersionUID = 2217052105667659254L;
	private UserService registerservice = new UserServiceImpl();
	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//未过滤的请求要统一字符集
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		// 获取验证码
		String piccode = (String) request.getSession().getAttribute("piccode");
		String checkcode = request.getParameter("checkcode");
		checkcode = checkcode.toUpperCase();
		if (!checkcode.equals(piccode)) {
			response.getWriter().write("<script type='text/javascript'>alert('验证码错误！');this.location.href='Login.jsp';</script>");
			response.getWriter().flush();
			response.getWriter().close();
		}else{
			Users registerUser = new Users();
			String username = request.getParameter("username");
			String password = request.getParameter("password");
			String contact = request.getParameter("contact");
			String address = request.getParameter("address");
			System.out.println(username);
			registerUser.setUsername(username);
			registerUser.setPassword(password);
			registerUser.setContact(contact);
			registerUser.setAddress(address);
			boolean flag = registerservice.registerUser(registerUser);
			if(flag==true){
				request.setAttribute("username", username);
				request.setAttribute("password", password);
				request.getRequestDispatcher("/servlet/LoginServlet").forward(request, response);
			}else{
				request.getRequestDispatcher("/fail.jsp").forward(request,
						response);
			}
		}
	}

}
