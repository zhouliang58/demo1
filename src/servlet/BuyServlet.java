package servlet;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Items;
import model.Users;

import service.ItemsService;
import service.ItemsServiceImpl;

public class BuyServlet extends HttpServlet {


	private static final long serialVersionUID = 6066135226388011068L;
	private ItemsService itemsService = new ItemsServiceImpl();
	
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

				//组装购买信息				
				Items buyItem = new Items();
				buyItem.setId(itemID);
				buyItem.setPrice(itemPrice);
				buyItem.setName(Name);
				buyItem.setNumber(number);
				
				SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");//设置日期格式
			 	String buy_Time = df.format(new Date());// new Date()为获取当前系统时间
				boolean flag = itemsService.buyItem(user.getUserID(), buyItem, buy_Time);
				if(flag==true){
					response.getWriter().write("<script type='text/javascript'>alert('购买成功！到线下去和小伙伴交易吧！');this.location.href='../HomePage.jsp';</script>");
					response.getWriter().flush();
					response.getWriter().close();
				}else{
					response.sendRedirect(request.getContextPath()+"/fail.jsp");
				}
				
	}

}
