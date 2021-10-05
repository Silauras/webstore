package edu.sytoss.service;

import edu.sytoss.model.order.Order;
import edu.sytoss.model.product.Product;
import edu.sytoss.model.product.ProductCard;
import edu.sytoss.model.user.Communication;
import edu.sytoss.model.user.UserAccount;
import edu.sytoss.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Map;
import java.util.Set;

public interface OrderAPI {
    /*---------------------------------Order-------------------------------*/

    Order findOrderById(Long id);

    List<Order> findAllOrder();

    List<Product> findAllProductInOrderById(Long id);

    List<ProductCard> findAllProductCartsInOrderById(Long id);

    ProductCard findProductCardById(Long id);

    void updateOrder(Long orderId, Long productCardId, int quantity, String actionType);

    void updateOrder(Long orderId);

     boolean createOrder(Order order,List<Product> products);
     /*--------------------------ShoppingCart-----------------------------*/
     Map<ProductCard, Integer> createShoppingCart(UserAccount userAccount);

    Map<ProductCard, Integer> updateShoppingCart(Map<ProductCard, Integer> shoppingCart, long productCardId, int quantity, String actionType);
}
