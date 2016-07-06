package test;

import model.Items;

import org.junit.Test;

import dao.CarsDaoImpl;

public class CarsTest {
	@Test
	public void addToCar(){
		CarsDaoImpl cars = new CarsDaoImpl();
		Items item = new Items();
		item.setContact("15243616117");
		item.setDiscription("新的");
		item.setId(33);
		item.setImage("3.jpg");
		item.setName("电脑");
		item.setPrice(500);
		cars.addItemToCar(33, item, 10);
	}
	@Test
	public void listCar(){
		CarsDaoImpl cars = new CarsDaoImpl();
		cars.ShowItemInCar(1);
	}
	
	@Test
	public void deleteCar(){
		CarsDaoImpl cars = new CarsDaoImpl();
		int[] id = {114};
		int userID = 26;
		System.out.println(cars.deleteItems(userID, id));
	}
}
