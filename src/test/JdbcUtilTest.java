package test;

import java.sql.SQLException;
import java.text.SimpleDateFormat;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.junit.Test;

import util.JdbcUtil;

public class JdbcUtilTest {
	 	@Test
	    public void c3p0DataSourceTest() {
	 		JdbcUtil jdbcUtil = new JdbcUtil();
			jdbcUtil.getConnection();
			try {
				List<Map<String, Object>> result = jdbcUtil.findResult(
						"select * from items", null);
				for (Map<String, Object> m : result) {
					System.out.println(m);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				jdbcUtil.releaseConn();
			}
	    }

	@Test
	public void DateTest() {
	 	SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");//设置日期格式
	 	System.out.println(df.format(new Date()));// new Date()为获取当前系统时间
	}
}
