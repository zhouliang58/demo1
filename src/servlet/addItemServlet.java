package servlet;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Items;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import service.ItemsService;
import service.ItemsServiceImpl;


public class addItemServlet extends HttpServlet {

	private static final long serialVersionUID = 2571998268987032737L;
	private ItemsService itemsService = new ItemsServiceImpl();

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//统一字符集
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		// 得到上传文件的保存目录，将上传的文件存放于WEB-INF目录下，不允许外界直接访问，保证上传文件的安全
		String savePath = this.getServletContext().getRealPath("/upload");
		
		File file = new File(savePath);
		
		//用于添加商品信息的items
		Items additem = new Items();
		
		//上传的图片保存在服务器 upload的文件夹下 图片路径为：upload/imagefilename
		StringBuffer imageStr = new StringBuffer();
		
		// 判断上传文件的保存目录是否存在
		if (!file.exists() && !file.isDirectory()) {
			// 创建目录
			file.mkdir();
		}
		try {
			// 使用Apache文件上传组件处理文件上传步骤：
			// 1、创建一个DiskFileItemFactory工厂
			DiskFileItemFactory factory = new DiskFileItemFactory();
			// 2、创建一个文件上传解析器
			ServletFileUpload upload = new ServletFileUpload(factory);
			// 解决上传文件名的中文乱码
			upload.setHeaderEncoding("UTF-8");
			// 3、判断提交上来的数据是否是上传表单的数据
			if (!ServletFileUpload.isMultipartContent(request)) {
				// 按照传统方式获取数据
				return;
			}
			// 4、使用ServletFileUpload解析器解析上传数据，解析结果返回的是一个List<FileItem>集合，每一个FileItem对应一个Form表单的输入项
			List<FileItem> list = upload.parseRequest(request);
			// 表单中对应的属性为 name , image , discription , price , contact
			
			//添加name
			FileItem item0 = list.get(1);
			String value0 = item0.getString("UTF-8");
			additem.setName(value0);

			//添加discription
			FileItem item2 = list.get(3);
			String value2 = item2.getString("UTF-8");
			additem.setDiscription(value2);

			//添加price
			FileItem item3 = list.get(2);
			String value3 = item3.getString("UTF-8");
			additem.setPrice(Integer.parseInt(value3));

			//添加contact
			FileItem item4 = list.get(4);
			String value4 = item4.getString("UTF-8");
			additem.setContact(value4);
			
			//添加type
			FileItem item5 = list.get(5);
			String value5 = item5.getString("UTF-8");
			String type;
			switch (Integer.parseInt(value5)) {
			case 1: type = "数码产品";break;
			case 2: type = "图书教材";break;
			case 3: type = "美妆服饰";break;
			case 4: type = "生活其他";break;
			default:
				type = "数码产品";
				break;
			}
			additem.setType(type);
			// 如果fileitem中封装的是上传文件
			// 得到上传的文件名称，这里是图片名称
			FileItem item = list.get(0);
			String filename = item.getName();
			
			
			// 注意：不同的浏览器提交的文件名是不一样的，有些浏览器提交上来的文件名是带有路径的，如：
			// c:\a\b\1.txt，而有些只是单纯的文件名，如：1.txt
			// 处理获取到的上传文件的文件名的路径部分，只保留文件名部分
			filename = filename.substring(filename.lastIndexOf("\\") + 1);
			imageStr.append(filename);
			// 获取item中的上传文件的输入流
			InputStream in = item.getInputStream();
			// 创建一个文件输出流
			FileOutputStream out = new FileOutputStream(savePath + "\\"
					+ filename);
			// 创建一个缓冲区
			byte buffer[] = new byte[1024];
			// 判断输入流中的数据是否已经读完的标识
			int len = 0;
			// 循环将输入流读入到缓冲区当中，(len=in.read(buffer))>0就表示in里面还有数据
			while ((len = in.read(buffer)) > 0) {
				// 使用FileOutputStream输出流将缓冲区的数据写入到指定的目录(savePath + "\\" +
				// filename)当中
				out.write(buffer, 0, len);
			}
			// 关闭输入流
			in.close();
			// 关闭输出流
			out.close();
			// 删除处理文件上传时生成的临时文件
			item.delete();

		} catch (Exception e) {
			e.printStackTrace();
		}
		
		//添加image(图片路径）
		additem.setImage(imageStr.toString());
		System.out.println(additem.toString());
		//调用/service 获取添加结果
		itemsService.addItem(additem);
		System.out.println("添加商品："+additem.toString());
		
		//将结果返回页面，跳转~
		response.sendRedirect(request.getContextPath()+"/HomePage.jsp");
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doGet(request, response);
	}
}