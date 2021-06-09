package com.example.projects.web.rest;

import com.example.projects.config.ShoppingConfiguration;
import com.example.projects.domain.BillDetails;
import com.example.projects.payload.Response.ApiResponse;
import com.example.projects.repository.BillDetailRepository;
import com.example.projects.service.impl.CartServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/api/v1")
public class CartResource {
    @Autowired
    private CartServiceImpl cartService;
    @Autowired
    BillDetailRepository billDetailRepository;

    @RequestMapping("/addToCart")
    public ResponseEntity<?> addCart(@RequestBody HashMap<String, String> addCartRequest) {
        try {
            String keys[] = {"product_id", "user_id", "quantity", "price"};
            if (ShoppingConfiguration.validationWithHashMap(keys, addCartRequest)) {

            }
            Integer product_id = Integer.parseInt(addCartRequest.get("product_id"));
            Integer user_id = Integer.parseInt(addCartRequest.get("user_id"));
            int quantity = Integer.parseInt(addCartRequest.get("quantity"));
            double price = Double.parseDouble(addCartRequest.get("price"));
            List<BillDetails> obj = cartService.addCartByUserIdAndProductId(product_id, user_id, quantity, price);
            System.out.println(obj);
            return ResponseEntity.ok(obj);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.badRequest().body(new ApiResponse(e.getMessage(), ""));
        }
    }

    @RequestMapping("/updateQuantity")
    public ResponseEntity<?> updateQtyForCart(@RequestBody HashMap<String, String> addCartRequest) {
        try {
            String keys[] = {"cart_id", "user_id", "quantity", "price"};
            if (ShoppingConfiguration.validationWithHashMap(keys, addCartRequest)) {

            }
            int cartId = Integer.parseInt(addCartRequest.get("cart_id"));
            int userId = Integer.parseInt(addCartRequest.get("user_id"));
            int qty = Integer.parseInt(addCartRequest.get("quantity"));
            double price = Double.parseDouble(addCartRequest.get("price"));
            cartService.updateQtyByCartId(cartId, qty, price);
            List<BillDetails> obj = cartService.getCartByUserId(userId);
            return ResponseEntity.ok(obj);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.badRequest().body(new ApiResponse(e.getMessage(), ""));
        }

    }


    @RequestMapping("/removeProduct")
    public ResponseEntity<?> removeCartwithProductId(@RequestBody HashMap<String, String> removeCartRequest) {
        try {
            String keys[] = {"user_id", "cart_id"};
            if (ShoppingConfiguration.validationWithHashMap(keys, removeCartRequest)) {

            }
            List<BillDetails> obj = cartService.removeCartByUserId(Integer.parseInt(removeCartRequest.get("cart_id")), Integer.parseInt(removeCartRequest.get("user_id")));
            return ResponseEntity.ok(obj);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(new ApiResponse(e.getMessage(), ""));
        }
    }

    @RequestMapping("/getCart")
    public ResponseEntity<?> getCartsByUserId(@RequestBody HashMap<String, String> getCartRequest) {
        try {
            String keys[] = {"user_id"};
            if (ShoppingConfiguration.validationWithHashMap(keys, getCartRequest)) {
            }
            List<BillDetails> obj = cartService.getCartByUserId(Integer.parseInt(getCartRequest.get("user_id")));
            return ResponseEntity.ok(obj);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(new ApiResponse(e.getMessage(), ""));
        }
    }
}