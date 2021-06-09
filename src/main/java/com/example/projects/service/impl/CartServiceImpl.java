package com.example.projects.service.impl;

import com.example.projects.domain.BillDetails;
import com.example.projects.domain.Bills;
import com.example.projects.domain.Order;
import com.example.projects.domain.Product;
import com.example.projects.repository.BillDetailRepository;
import com.example.projects.repository.OrderRepository;
import com.example.projects.repository.custom.CartRepositoryCustom;
import com.example.projects.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CartServiceImpl implements CartRepositoryCustom {
    @Autowired
    private BillDetailRepository billDetailsRepository;
    @Autowired
    private ProductService productService;
    @Autowired
    private OrderRepository orderRepository;

    @Override
    public List<BillDetails> addCartByUserIdAndProductId
            (Integer product_id, Integer user_id, int quantity, double price) {
        try {
            if (billDetailsRepository.getCartByProductIdAnduserId(product_id, user_id).isPresent()) {
                throw new Exception("Product is already exist");
            }
            Bills bills = new Bills();
            BillDetails obj = new BillDetails();
            obj.setQuantity(quantity);
            obj.setUserID(user_id);
            Product product = productService.getByID(product_id);
            obj.setProduct(product);
            // obj.setBills_id(bills.getId(bills_id));
            obj.setPrice(price);
            billDetailsRepository.save(obj);
            return null;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void updateQtyByCartId(int cartId, int qty, double price) throws Exception {
        billDetailsRepository.updateQtyByCartId(cartId, qty, price);
    }

    @Override
    public List<BillDetails> getCartByUserId(int userId) {
        return billDetailsRepository.getCartByUserId(userId);
    }

    @Override
    public List<BillDetails> removeCartByUserId(int cartId, int userId) {
        billDetailsRepository.deleteCartByIdAndUserId(userId, cartId);
        return this.getCartByUserId(userId);
    }

    @Override
    public List<Order> getAllCheckoutByUserId(int userId) {
        return orderRepository.getByuserId(userId);
    }

    @Override
    public List<Order> saveProductsForCheckout(List<Order> tmp) throws Exception {
        try {
            int user_id = tmp.get(0).getUserID();
            if (tmp.size() > 0) {
                orderRepository.saveAll(tmp);
                this.removeAllCartByUserId(user_id);
                return this.getAllCheckoutByUserId(user_id);
            } else {
                throw new Exception("Should not be empty");
            }
        } catch (Exception e) {
            throw new Exception("Error while checkout " + e.getMessage());
        }

    }

    @Override
    public Boolean checkTotalAmountAgainstCart(double totalAmount, int userId) {
        double total_amount = billDetailsRepository.getTotalAmountByUserId(userId);
        if (total_amount == totalAmount) {
            return true;
        }
        System.out.print("Error from request " + total_amount + " --db-- " + totalAmount);
        return false;
    }

    @Override
    public List<BillDetails> removeAllCartByUserId(int userId) {
        billDetailsRepository.deleteAllCartByUserId(userId);
        return null;
    }

}