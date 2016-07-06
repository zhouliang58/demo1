package service;

import java.util.List;

import model.Items;
import model.Pager;
import dao.ItemsDao;
import dao.ItemsDaoImpl;




public class ItemsServiceImpl implements ItemsService {
	private ItemsDao itemsDao;
	
	public ItemsServiceImpl(){		
		itemsDao = new ItemsDaoImpl();
	}
	
	//分页
	@Override
	public Pager<Items> findItems(Items searchModel, int pageNum,
			int pageSize) {
		Pager<Items> result = itemsDao.findItems(searchModel, pageNum,
				pageSize);
		return result;
	}
	
	//获取单个商品
	@Override
	public List<Items> getOneItem(int id) {
		List<Items> itemList = itemsDao.getOneItem(id);
		return itemList;
	}

	//更新商品热度
	@Override
	public boolean addItemHot(int id) {		
		return itemsDao.addItemHot(id);
	}

	//购买商品
	@Override
	public boolean buyItem(int userID, Items buyItem, String buy_Time) {		
		return itemsDao.buyItem(userID, buyItem, buy_Time);
	}

	//根据商品类型分页
	@Override
	public Pager<Items> typeItems(Items searchModel, int pageNum, int pageSize) {
		Pager<Items> result = itemsDao.typeItems(searchModel, pageNum, pageSize);
		return result;
	}
	
	//添加商品信息
	@Override
	public boolean addItem(Items additem) {
		boolean flag = itemsDao.addItem(additem);
		return flag;
	}

}
