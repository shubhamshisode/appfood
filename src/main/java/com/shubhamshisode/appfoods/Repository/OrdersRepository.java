package com.shubhamshisode.appfoods.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.*;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.shubhamshisode.appfoods.entity.Orders;

@Repository
public interface OrdersRepository extends JpaRepository<Orders, Long> {

    @Query("""
        SELECT o FROM Orders o WHERE
        (:id IS NULL OR o.id = :id) AND
        (:customerName IS NULL OR LOWER(o.customerName) LIKE LOWER(CONCAT('%', :customerName, '%'))) AND
        (:foodName IS NULL OR LOWER(o.foodName) LIKE LOWER(CONCAT('%', :foodName, '%'))) AND
        (:quantity IS NULL OR o.quantity = :quantity) AND
        (:price IS NULL OR o.price = :price)
    """)
    List<Orders> searchOrders(
        @Param("id") Long id,
        @Param("customerName") String customerName,
        @Param("foodName") String foodName,
        @Param("quantity") Integer quantity,
        @Param("price") Double price
    );
}
