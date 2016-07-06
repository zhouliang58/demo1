package service;

import model.Items;
import model.Pager;

public interface SortService {
	//根据价格对商品排序
	public Pager<Items> SortByPrice(Items searchModel, int pageNum,
			int pageSize);
	//根据人气对商品排序
	public Pager<Items> SortByHot(Items searchModel, int pageNum,
			int pageSize);
}
