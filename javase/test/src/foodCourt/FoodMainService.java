package foodCourt;

import java.util.List;

import javax.swing.JButton;

public class FoodMainService {
	FoodMainController foodMainController = null;
	FoodMain foodMain = null;
	List<FoodDto> foodList = null;
	FoodDao foodDao = new FoodDao();
	public FoodMainService(FoodMainController foodMainController) {
		this.foodMainController = foodMainController;
		this.foodMain = foodMainController.foodMain;
	}
	public void searchMenu(JButton button) {
		// ī�巹�̾ƿ� -> �޴� ��� �������� (�ѽ�, �߽�, �Ͻ�, ���)
		System.out.println("menuList");
		foodList = foodDao.getMenubyCategory(Integer.parseInt(button.getName()));
		foodMain.userMenuList.setMenu(27, foodList);
		foodMain.card.show(foodMain.changePanel, "menuList");
	}
	public void clickMain() {
		// ī�巹�̾ƿ� -> ���� �޴� ��� �������� (���θ޴�)
		System.out.println("mainMenu");
		foodMain.card.show(foodMain.changePanel, "mainMenu");
	}
	public void userInfo() {
		// ī�巹�̾ƿ� -> ���� �������� (���� ���� ��ư)
		
	}
	public void orderList() {
		// ī�巹�̾ƿ� -> �ֹ���� �������� (�ֹ���� ��ư)
		
	}
	public void searchAllMenu() {
		// ī�巹�̾ƿ� -> �ֹ���� �������� (�˻� ��ư)
		System.out.println("menuAllList");
		foodList = foodDao.getMenuAll();
		foodMain.userMenuList.setMenu(27, foodList);
		foodMain.card.show(foodMain.changePanel, "menuList");
	}
	
}
