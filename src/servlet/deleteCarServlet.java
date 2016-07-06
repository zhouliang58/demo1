package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Users;

import service.CarsService;
import service.CarsServiceImpl;

public class deleteCarServlet extends HttpServlet {

	private static final long serialVersionUID = -4054024674469520579L;
	private CarsService carsService = new CarsServiceImpl();
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
			String ids = request.getParameter("id");
			String[] idsList = ids.split(",");
			int[] itemID = new int[idsList.length];
			for(int i = 0 ; i < idsList.length ; i++){
				itemID[i] = Integer.parseInt(idsList[i]);
			}
			Users loginUser = (Users)request.getSession().getAttribute("loginUser");
			boolean flag = carsService.deleteItems(loginUser.getUserID(), itemID);
			if(flag==true){
				response.sendRedirect(request.getContextPath()+"/servlet/ShowCarServlet");
			}else{
				response.sendRedirect("fail.jsp");
			}
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
			this.doGet(request, response);
	}

}
