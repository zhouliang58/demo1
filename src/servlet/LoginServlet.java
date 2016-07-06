package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import service.UserService;
import service.UserServiceImpl;

import model.Users;
/**
 * 用户登陆
 * @author zhouliang
 *
 */
public class LoginServlet extends HttpServlet {

	private static final long serialVersionUID = 6264381047408967619L;
	private UserService loginService = new UserServiceImpl();

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doPost(request, response);
	}


	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//未过滤的请求要统一字符集
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");	
		
		//第一次登陆
		if(request.getSession().getAttribute("loginUser")==null){
			//获取用户名和密码
			String username = (String) request.getParameter("username");
			String password = (String) request.getParameter("password");
			
			Users user = new Users();
			user.setUsername(username);
			user.setPassword(password);
			
			Users loginUser = new Users();
			//验证通过跳转至首页，不通过跳转至登陆页面
			loginUser = loginService.findAllUsers(user);
			if(loginUser!=null){
				HttpSession session = request.getSession();
				session.setAttribute("loginUser",loginUser);
				response.sendRedirect(request.getContextPath()+"/HomePage.jsp");
			}else{
				response.sendRedirect(request.getContextPath()+"/fail.jsp");
			}
		}else{
			response.sendRedirect(request.getContextPath()+"/HomePage.jsp");
		}
		
	}

}
