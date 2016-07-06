package dao;


import java.util.List;

import model.Items;
import model.Pager;

public interface ItemsDao {
	/**
	 * 根据查询条件，查询商品分页信息
	 * @param searchModel 封装查询条件
	 * @param pageNum     查询第几页数据
	 * @param pageSize    每页显示多少条记录
	 * @return 查询结果
	 */
	public Pager<Items> findItems(Items searchModel, int pageNum,
			int pageSize);
	/**
	 * 根据商品类型分页
	 */
	public Pager<Items> typeItems(Items searchModel, int pageNum,
			int pageSize);
	
	//获取一个商品信息
	public List<Items> getOneItem(int id);
	
	//更新商品热度
	public boolean addItemHot(int id);
	
	//购买商品
	public boolean buyItem(int userID , Items buyItem , String buy_Time);
	
	//添加商品信息,发布商品
	public boolean addItem(Items additem);
}
