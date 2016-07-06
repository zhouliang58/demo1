package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Items;
import model.Pager;
import service.ItemsService;
import service.ItemsServiceImpl;
import util.Constant;
import util.StringUtil;


public class LimitItemsServlet extends HttpServlet {
	
	private static final long serialVersionUID = 2659038734485387542L;
	private ItemsService itemsService = new ItemsServiceImpl();
	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//未过滤的请求要统一字符集
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		// 接收request里的参数
		String name;
		if(request.getParameter("itemName")!=null){
			String name1 = request.getParameter("itemName"); //商品名称
			name = new String(name1.getBytes("iso8859-1"),"UTF-8");		
			System.out.println(name);
		}else{
			name = null;
		}
		// 校验pageNum参数输入合法性
		String pageNumStr = request.getParameter("pageNum"); 
		if(pageNumStr !=null && !StringUtil.isNum(pageNumStr)){
			request.setAttribute("errorMsg", "参数传输错误");
			request.getRequestDispatcher("fail.jsp").forward(request, response);
			return;
		}

		int pageNum = Constant.DEFAULT_PAGE_NUM; //显示第几页数据
		if(pageNumStr!=null && !"".equals(pageNumStr.trim())){
			pageNum = Integer.parseInt(pageNumStr);
		}
		
		int pageSize = Constant.DEFAULT_PAGE_SIZE;  // 每页显示多少条记录
		String pageSizeStr = request.getParameter("pageSize");
		if(pageSizeStr!=null && !"".equals(pageSizeStr.trim())){
			pageSize = Integer.parseInt(pageSizeStr);
		}
		
		// 组装查询条件
		Items searchModel = new Items(); 
		if(name!=null&&!"".equals(name.trim())){			
			searchModel.setName(name);
		}
		searchModel.setHot(0);
		//调用service 获取查询结果
		Pager<Items> result = itemsService.findItems(searchModel, 
												pageNum, pageSize);
		// 返回结果到页面
		request.setAttribute("result", result);
		request.getRequestDispatcher("/Show.jsp").forward(request, response);
		
	}

}



