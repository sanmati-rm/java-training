package com.target.training.programs;

import com.target.training.entity.Customer;
import com.target.training.entity.Order;
import com.target.training.entity.OrderDetails;
import com.target.training.utils.DateUtil;
import com.target.training.utils.JpaUtil;
import com.target.training.utils.KeyboardUtil;
import lombok.extern.slf4j.Slf4j;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;

@Slf4j
public class GetOrderDetails {
    public static void main(String[] args) {
        Integer orderId = KeyboardUtil.getInt("Enter order id to get details for: ");
        EntityManager em = JpaUtil.createEntityManager();
        Order order = em.find(Order.class, orderId);


        printOrderDetails(order.getOrderDetailsList());
        em.close();


    }

    static void printOrderDetails(List<OrderDetails> orderDetails) {
        System.out.println("Products in this order are:");
        line();
        System.out.printf("%-45s %10s %10s %10s %10s%n",
                "Product name", "Unit price", "Quantity", "Discount", "Amount");
        line();
        double total = 0;
        for(OrderDetails li: orderDetails){
            System.out.printf("%-45s %10s %10s %10s %10.2f%n",
                    li.getProduct().getProductName() + " (" + li.getProduct().getCategory().getCategoryName() + ")",
                    li.getUnitPrice(),
                    li.getQuantity(),
                    li.getDiscount()*100 + "%",
                    (1-li.getDiscount())*(li.getUnitPrice() * li.getQuantity()));
            total += (1-li.getDiscount())*(li.getUnitPrice() * li.getQuantity());
        }
        line();
        System.out.printf("%78s %10.2f%n", "Total", total);
        line();
    }


    static void line() {
        for (int i = 0; i < 95; i++) {
            System.out.print('-');
        }
        System.out.println();
    }

}

