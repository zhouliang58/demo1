package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Items;
import service.ItemsService;
import service.ItemsServiceImpl;


public class ShowItemServlet extends HttpServlet {

	private static final long serialVersionUID = -5965679192471631050L;
	private ItemsService getOneItem = new ItemsServiceImpl();
	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 接收request里的参数
		int id = Integer.parseInt(request.getParameter("id"));
		List<Items> itemList =null;
		Items item = new Items();
		//查询结果
		itemList = getOneItem.getOneItem(id);
		item = itemList.get(0);
		
		//更新商品热度
		boolean flag = getOneItem.addItemHot(id);
		if(flag==true){
			// 返回结果到页面
			request.setAttribute("item", item);
			request.getRequestDispatcher("/WEB-INF/jsp/front/buy.jsp").forward(request, response);
		}else{
			response.sendRedirect(request.getContextPath()+"/fail.jsp");
		}

	}

}
