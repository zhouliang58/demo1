package filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * 登陆过滤器
 * @author zhouliang
 *
 */
public class LoginFilter implements Filter {
	
	private FilterConfig config;
	@Override
	public void destroy() {

	}

	@Override
	public void doFilter(ServletRequest arg0, ServletResponse arg1,FilterChain arg2) throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest) arg0;
		HttpServletResponse response = (HttpServletResponse) arg1;
		HttpSession session = request.getSession();
		String noLoginPaths = config.getInitParameter("noLoginPaths");
		
		String charset = config.getInitParameter("charset");
		if(charset==null){
			charset = "UTF-8";
		}
		response.setContentType("text/html;charset=utf-8"); 
		//加载过滤参数
		if(noLoginPaths!=null){
			String[] strArray = noLoginPaths.split(";");
			for (int i = 0; i < strArray.length; i++) {
				
				if(strArray[i]==null || "".equals(strArray[i]))continue;
				
				if(request.getRequestURI().indexOf(strArray[i])!=-1 ){
					arg2.doFilter(arg0, arg1);
					return;
				}
			}
			
		}
		//为servlet设置统一的字符集
		request.setCharacterEncoding(charset);
		response.setCharacterEncoding(charset);
		
		//过滤
		if(session.getAttribute("loginUser")!=null){
			arg2.doFilter(arg0, arg1);
		}else{
			response.sendRedirect(request.getContextPath()+"/Login.jsp");
		}
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		config = arg0;
	}

}
