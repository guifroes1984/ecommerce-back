package br.com.guifroes1984.jwt.controller;

import br.com.guifroes1984.jwt.entity.Cart;
import br.com.guifroes1984.jwt.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CartController {

    @Autowired
    private CartService cartService;

    @PreAuthorize("hasRole('User')")
    @GetMapping({"/addToCard/{productId}"})
    public Cart addToCart(@PathVariable(name = "productId") Integer productId) {
        return cartService.addToCart(productId);
    }
}
