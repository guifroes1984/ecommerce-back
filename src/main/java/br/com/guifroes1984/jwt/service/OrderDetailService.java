package br.com.guifroes1984.jwt.service;

import br.com.guifroes1984.jwt.configuration.JwtRequestFilter;
import br.com.guifroes1984.jwt.dao.CartDao;
import br.com.guifroes1984.jwt.dao.OrderDetailDao;
import br.com.guifroes1984.jwt.dao.ProductDao;
import br.com.guifroes1984.jwt.dao.UserDao;
import br.com.guifroes1984.jwt.entity.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderDetailService {

    private static final String ORDER_PLACED = "Placed";

    @Autowired
    private OrderDetailDao orderDetailDao;

    @Autowired
    private ProductDao productDao;

    @Autowired
    private UserDao userDao;

    @Autowired
    private CartDao cartDao;

    public void placeOrder(OrderInput orderInput, boolean isSingleProductCheckout) {
        List<OrderProductQuantity> productQuantityList = orderInput.getOrderProductQuantityList();

        for (OrderProductQuantity o: productQuantityList) {
            Product product = productDao.findById(o.getProductId()).get();

            String currentUser = JwtRequestFilter.CURRENT_USER;
            User user = userDao.findById(currentUser).get();

            OrderDetail orderDetail = new OrderDetail(
                    orderInput.getFullName(),
                    orderInput.getFullAddress(),
                    orderInput.getContactNumber(),
                    orderInput.getAlternateContactNumber(),
                        ORDER_PLACED,
                        product.getProductDiscountedPrice() * o.getQuantity(),
                        product,
                        user
            );
            // esvaziar o carrinho
            if(!isSingleProductCheckout) {
                List<Cart> carts = cartDao.findByUser(user);
                carts.stream().forEach(x -> cartDao.deleteById(x.getCartId()));
            }

            orderDetailDao.save(orderDetail);
        }
    }
}
