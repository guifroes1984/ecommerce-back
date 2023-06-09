package br.com.guifroes1984.jwt.service;

import br.com.guifroes1984.jwt.configuration.JwtRequestFilter;
import br.com.guifroes1984.jwt.dao.CartDao;
import br.com.guifroes1984.jwt.dao.ProductDao;
import br.com.guifroes1984.jwt.dao.UserDao;
import br.com.guifroes1984.jwt.entity.Cart;
import br.com.guifroes1984.jwt.entity.Product;
import br.com.guifroes1984.jwt.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CartService {

    @Autowired
    private CartDao cartDao;

    @Autowired
    private UserDao userDao;

    @Autowired
    private ProductDao productDao;

    public Cart addToCart(Integer productId) {
        Product product = productDao.findById(productId).get();

        String username = JwtRequestFilter.CURRENT_USER;

        User user = null;
        if(username != null){
            user = userDao.findById(username).get();
        }


        if(product != null && user != null) {
            Cart cart = new Cart(product, user);
            return cartDao.save(cart);
        }

        return null;
    }

    public List<Cart> getCartDetails() {
        String username = JwtRequestFilter.CURRENT_USER;
        User user = userDao.findById(username).get();
        return cartDao.findByUser(user);
    }
}
