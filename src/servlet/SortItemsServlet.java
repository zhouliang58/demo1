package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Items;
import model.Pager;

import service.SortService;
import service.SortServiceImpl;
import util.Constant;
import util.StringUtil;

public class SortItemsServlet extends HttpServlet {

	private static final long serialVersionUID = 819325336131795250L;
	private SortService sortService = new SortServiceImpl();

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 未过滤的请求要统一字符集
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		// 接收request里的参数
		String itemtype = request.getParameter("itemType"); // 商品名称
		// 处理get字符串乱码
		String type = new String(itemtype.getBytes("iso8859-1"), "UTF-8");
		// 校验pageNum参数输入合法性
		String pageNumStr = request.getParameter("pageNum");
		if (pageNumStr != null && !StringUtil.isNum(pageNumStr)) {
			request.setAttribute("errorMsg", "参数传输错误");
			request.getRequestDispatcher("fail.jsp").forward(request, response);
			return;
		}

		int pageNum = Constant.DEFAULT_PAGE_NUM; // 显示第几页数据
		if (pageNumStr != null && !"".equals(pageNumStr.trim())) {
			pageNum = Integer.parseInt(pageNumStr);
		}
		System.out.println(pageNum);
		int pageSize = Constant.DEFAULT_PAGE_SIZE; // 每页显示多少条记录
		String pageSizeStr = request.getParameter("pageSize");
		if (pageSizeStr != null && !"".equals(pageSizeStr.trim())) {
			pageSize = Integer.parseInt(pageSizeStr);
		}

		// 组装查询条件
		Items searchModel = new Items();
		if (type != null && !"".equals(type.trim())) {
			searchModel.setType(type);
		}
		searchModel.setHot(0);
		Pager<Items> result =null;
		if (request.getParameter("sort") != null) {
			String str = request.getParameter("sort");
			String sort = new String(str.getBytes("iso8859-1"), "UTF-8");
			request.setAttribute("lastsort", sort);
			// 调用service 获取查询结果
			if (sort.equals("按价格排序")) {
				result = sortService.SortByPrice(searchModel, pageNum, pageSize);
				System.out.println("按价格排序");
			}else{
				result = sortService.SortByHot(searchModel, pageNum, pageSize);
				System.out.println("按人气排序");
			}
		}
		
		// 返回结果到页面
		request.setAttribute("result", result);
		request.setAttribute("itemType", type);
		request.getRequestDispatcher("/ShowSort.jsp").forward(request, response);
		
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doPost(request, response);
	}

}
