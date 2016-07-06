package service;

import dao.SortDao;
import dao.SortDaoImpl;
import model.Items;
import model.Pager;

public class SortServiceImpl implements SortService {
	private SortDao sortDao ;
	public SortServiceImpl(){
		sortDao = new SortDaoImpl();
	}
	@Override
	public Pager<Items> SortByPrice(Items searchModel, int pageNum, int pageSize) {
		Pager<Items> result = sortDao.SortByPrice(searchModel, pageNum, pageSize);
		return result;
	}

	@Override
	public Pager<Items> SortByHot(Items searchModel, int pageNum, int pageSize) {
		Pager<Items> result = sortDao.SortByHot(searchModel, pageNum, pageSize);
		return result;
	}

}
