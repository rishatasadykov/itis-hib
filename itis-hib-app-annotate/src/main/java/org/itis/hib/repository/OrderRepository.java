package org.itis.hib.repository;

import java.util.List;
import org.itis.hib.entity.Order;

public interface OrderRepository {
	public List<Order> getAllOrders();
	public void saveOrder(Order order);
	public void updateOrder(Order order);
	public void deleteOrder(Order order);
}
