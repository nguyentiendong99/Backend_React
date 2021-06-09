package com.example.projects.repository.custom;

import com.example.projects.domain.BillDetails;
import com.example.projects.domain.Order;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CartRepositoryCustom {
    List<BillDetails> addCartByUserIdAndProductId(Integer productId, Integer userId, int qty, double price);

    void updateQtyByCartId(int cartId, int qty, double price) throws Exception;

    List<BillDetails> getCartByUserId(int userId);

    List<BillDetails> removeCartByUserId(int cartId, int userId);

    List<BillDetails> removeAllCartByUserId(int userId);

    List<Order> getAllCheckoutByUserId(int userId);

    List<Order> saveProductsForCheckout(List<Order> tmp) throws Exception;

    Boolean checkTotalAmountAgainstCart(double totalAmount, int userId);
}
