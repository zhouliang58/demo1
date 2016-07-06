package servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.CarsService;
import service.CarsServiceImpl;

import model.Items;
import model.Users;



public class ShowCarServlet extends HttpServlet {


	private static final long serialVersionUID = -9079247542889575590L;
	private CarsService carService = new CarsServiceImpl();
	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Users loginUser = (Users)request.getSession().getAttribute("loginUser");
		List<Items> carItems = new ArrayList<Items>();
		carItems = carService.ShowItemInCar(loginUser.getUserID());
		System.out.println(carItems.size());
		request.setAttribute("carItems", carItems);
		request.getRequestDispatcher("/WEB-INF/jsp/front/ShowCar.jsp").forward(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doPost(request, response);
	}

}
