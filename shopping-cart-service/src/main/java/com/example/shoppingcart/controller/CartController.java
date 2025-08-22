package com.example.shoppingcart.controller;

import com.example.shoppingcart.model.Cart;
import com.example.shoppingcart.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/carts")
public class CartController {

    @Autowired
    private CartService cartService;

    @GetMapping("/{userId}")
    public ResponseEntity<Optional<Cart>> getCartByUserId(@PathVariable String userId) {
        return new ResponseEntity<>(cartService.getCartByUserId(userId), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Cart> createCart(@RequestBody Cart cart) {
        return new ResponseEntity<>(cartService.createCart(cart), HttpStatus.CREATED);
    }

    @PutMapping("/{userId}")
    public ResponseEntity<Cart> updateCart(@PathVariable String userId, @RequestBody Cart cart) {
        return new ResponseEntity<>(cartService.updateCart(userId, cart), HttpStatus.OK);
    }

    @DeleteMapping("/{userId}")
    public ResponseEntity<Void> deleteCart(@PathVariable String userId) {
        cartService.deleteCart(userId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}