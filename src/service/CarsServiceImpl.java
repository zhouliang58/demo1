package service;

import java.util.List;

import dao.CarsDao;
import dao.CarsDaoImpl;

import model.Items;

public class CarsServiceImpl implements CarsService {
	private CarsDao carsDao;
	public CarsServiceImpl(){
		carsDao = new CarsDaoImpl();
	}
	@Override
	public boolean addItemToCar(int userID, Items item, int number) {		
		return carsDao.addItemToCar(userID, item, number);
	}

	@Override
	public List<Items> ShowItemInCar(int userID) {
		return carsDao.ShowItemInCar(userID);
	}
	@Override
	public boolean updateItemInCar(int itemID, int userID, int number) {		
		return carsDao.updateItemInCar(itemID, userID, number);
	}
	@Override
	public boolean addItem(Items additem) {
		boolean flag = carsDao.addItem(additem);
		return flag;
	}
	@Override
	public boolean deleteItems(int userID, int[] id) {
		boolean flag = carsDao.deleteItems(userID, id);
 		return flag;
	}
}
