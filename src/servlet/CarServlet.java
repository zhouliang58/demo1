package servlet;

import java.io.IOException;
import java.util.List;


import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.CarsService;
import service.CarsServiceImpl;



import model.Items;
import model.Users;

public class CarServlet extends HttpServlet {

	private static final long serialVersionUID = -3414634011792102743L;
	private CarsService carService = new CarsServiceImpl();
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 统一字符集
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		
		//接收参数，已经登录的用户才能购买
		Users user = (Users) request.getSession().getAttribute("loginUser");
		int itemID = Integer.parseInt(request.getParameter("itemID"));
		System.out.println(itemID);
		int itemPrice = Integer.parseInt(request.getParameter("itemPrice"));
		int number = 1;
		
		//处理get字符串乱码
		String itemName = request.getParameter("itemName");
		String Name = new String(itemName.getBytes("iso8859-1"),"UTF-8");	
		String itemImage = request.getParameter("itemImage");
		String image = new String(itemImage.getBytes("iso8859-1"),"UTF-8");	
		
		
		Items item = new Items();
		item.setId(itemID);
		item.setPrice(itemPrice);
		item.setName(Name);
		item.setImage(image);
		//判断购物车中是否有同ID的商品
		List<Items> ItemsCar = carService.ShowItemInCar(user.getUserID());
		boolean buyOrUpdate = false;
		for (Items itemCar : ItemsCar) {
			if(itemCar.getId()==itemID){
				buyOrUpdate = true;
			}
		}
		if(buyOrUpdate==true){
			//增加购物车中此商品的数量
			boolean flag = carService.updateItemInCar(itemID, user.getUserID(), number);
			if(flag==true){
				response.sendRedirect(request.getContextPath()+"/HomePage.jsp");
			}else{
				response.sendRedirect(request.getContextPath()+"/fail.jsp");
			}
		}else{
			//在购物车中增加一件新的商品
			boolean flag = carService.addItemToCar(user.getUserID(), item,number);		
			if(flag==true){
				response.sendRedirect(request.getContextPath()+"/HomePage.jsp");
			}else{
				response.sendRedirect(request.getContextPath()+"/fail.jsp");
			}
		}
	}

}
