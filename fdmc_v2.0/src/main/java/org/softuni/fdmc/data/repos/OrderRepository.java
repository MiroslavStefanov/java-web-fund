package org.softuni.fdmc.data.repos;

import org.softuni.fdmc.data.models.Order;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class OrderRepository {
    private Set<Order> orders;

    public OrderRepository() {
        this.orders = new HashSet<>();
    }

    public Set<Order> getAllOrders() {
        return Collections.unmodifiableSet(this.orders);
    }

    public void addOrder(Order order) {
        this.orders.add(order);
    }
}
