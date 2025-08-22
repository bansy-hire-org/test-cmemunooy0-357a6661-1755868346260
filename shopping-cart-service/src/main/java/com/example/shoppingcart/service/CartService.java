package com.example.shoppingcart.service;

import com.example.shoppingcart.model.Cart;
import com.example.shoppingcart.repository.CartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CartService {

    @Autowired
    private CartRepository cartRepository;

    public Optional<Cart> getCartByUserId(String userId) {
        return cartRepository.findByUserId(userId);
    }

    public Cart createCart(Cart cart) {
        return cartRepository.save(cart);
    }

    public Cart updateCart(String userId, Cart cart) {
        Optional<Cart> existingCart = cartRepository.findByUserId(userId);
        if (existingCart.isPresent()) {
            Cart cartToUpdate = existingCart.get();
            cartToUpdate.setItems(cart.getItems());
            return cartRepository.save(cartToUpdate);
        } else {
            return cartRepository.save(cart);
        }
    }

    public void deleteCart(String userId) {
        cartRepository.deleteByUserId(userId);
    }
}