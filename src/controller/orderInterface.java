package controller;

import java.util.ArrayList;

import model.orderModel;

public interface orderInterface {
		// C
		public boolean create(orderModel om);

		// R member
		public ArrayList<orderModel> memberRead(Integer memberNum);

		// R supplier
		public ArrayList<orderModel> supplierRead(Integer tourNum);

		// U
		public boolean update(orderModel om);

		// D order
		public boolean deleteOrder(Integer orderNum);
		
		// D orderDetail
		public boolean deleteOrderDetail(Integer orderDetailNum);
}
