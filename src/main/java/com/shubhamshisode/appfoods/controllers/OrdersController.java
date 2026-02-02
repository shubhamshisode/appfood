package com.shubhamshisode.appfoods.controllers;

import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.*;

import com.shubhamshisode.appfoods.entity.Orders;
import com.shubhamshisode.appfoods.service.OrdersService;

@RestController
@RequestMapping("/api/orders")
@CrossOrigin(origins = "http://localhost:3001")
public class OrdersController {

    private final OrdersService service;

    public OrdersController(OrdersService service) {
        this.service = service;
    }

    // 🔹 Get all or search
    @GetMapping
    public List<Orders> getAllOrders(
            @RequestParam(required = false) Long id,
            @RequestParam(required = false) String customerName,
            @RequestParam(required = false) String foodName,
            @RequestParam(required = false) Integer quantity,
            @RequestParam(required = false) Double price
    ) {
        if (id == null && customerName == null && foodName == null
                && quantity == null && price == null) {
            return service.getAll();
        }
        return service.searchOrders(id, customerName, foodName, quantity, price);
    }

    @GetMapping("/{id}")
    public Orders getOrder(@PathVariable Long id) {
        return service.getById(id);
    }

    @PostMapping
    public Orders createOrder(@RequestBody Orders order) {
        return service.save(order);
    }

    @PutMapping("/{id}")
    public Orders updateOrder(@PathVariable Long id, @RequestBody Orders order) {
        return service.update(id, order);
    }

    // ✅ ONLY ONE status endpoint (PUT)
    @PutMapping("/status/{id}")
    public Orders updateStatus(@PathVariable Long id, @RequestBody Map<String, String> body) {
        return service.updateStatus(id, body.get("status"));
    }

    @DeleteMapping("/{id}")
    public void deleteOrder(@PathVariable Long id) {
        service.delete(id);
    }
}
