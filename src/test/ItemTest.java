package test;



import java.util.List;
import java.util.Random;

import model.Items;
import model.Pager;

import org.junit.Test;

import dao.ItemsDaoImpl;
import dao.SortDao;
import dao.SortDaoImpl;

public class ItemTest {
	@Test
	public void addItemHot(){
		ItemsDaoImpl item = new ItemsDaoImpl();
		//item.addItemHot(35);
		item.addItemHot(34);
	}
	
	@Test
	public void TypeSubmit(){
		ItemsDaoImpl item = new ItemsDaoImpl();
		Items searchModel = new Items();
		searchModel.setType("数码产品");
		Pager<Items> result = item.typeItems(searchModel, 1, 4);
		List<Items> items = result.getDataList();
		System.out.println();
		for (Items items2 : items) {
			System.out.println(items2.toString());
		}		
		System.out.println(result.getPageSize());
		System.out.println(result.getTotalPage());
		System.out.println(result.getTotalRecord());
	}
	
	@Test
	public void random(){

		for(int n = 0 ; n < 50 ; n++){
			Random ran = new Random();
			int[] num = new int[11];
			num[0]=1;
			num[1]=ran.nextInt(5)+5;
			for(int i = 2 ; i < 11 ; i++){
				int j = ran.nextInt(10);
				num[i] = j;
			}
			StringBuffer str = new StringBuffer();
			for (int i = 0; i < num.length; i++) {
				str.append(Integer.toString(num[i]));
			}
			System.out.println(str.toString());
		}
	}
	
	@Test
	public void SortByPrice(){
		SortDao sortDao = new SortDaoImpl();
		Items item = new Items();
		item.setType("美妆服饰");
		sortDao.SortByPrice(item, 1, 16);
	}
	@Test
	public void SortByHot(){
		SortDao sortDao = new SortDaoImpl();
		Items item = new Items();
		item.setType("美妆服饰");
		sortDao.SortByHot(item, 1, 16);
	}
}
