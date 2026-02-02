package com.shubhamshisode.appfoods.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.shubhamshisode.appfoods.Repository.OrdersRepository;
import com.shubhamshisode.appfoods.entity.Orders;

@Service
public class OrdersService {

    private final OrdersRepository repo;

    public OrdersService(OrdersRepository repo) {
        this.repo = repo;
    }

    public List<Orders> getAll() {
        return repo.findAll();
    }

    public Orders getById(Long id) {
        return repo.findById(id)
                .orElseThrow(() -> new RuntimeException("Order not found: " + id));
    }

    public Orders save(Orders order) {
        return repo.save(order);
    }

    public Orders update(Long id, Orders order) {
        Orders existing = getById(id);
        existing.setCustomerName(order.getCustomerName());
        existing.setFoodName(order.getFoodName());
        existing.setQuantity(order.getQuantity());
        existing.setPrice(order.getPrice());
        existing.setImageUrl(order.getImageUrl());
        existing.setStatus(order.getStatus());
        return repo.save(existing);
    }

    public Orders updateStatus(Long id, String status) {
        Orders order = getById(id);
        order.setStatus(status);
        return repo.save(order);
    }

    public void delete(Long id) {
        repo.deleteById(id);
    }

    public List<Orders> searchOrders(
            Long id,
            String customerName,
            String foodName,
            Integer quantity,
            Double price) {

        return repo.searchOrders(id, customerName, foodName, quantity, price);
    }
}
