package com.food.models;

import java.util.*;

public class Cart {
    private Map<Integer, CartItem> items = new HashMap<>();

    // Add item to the cart
    public void addCartItem(CartItem item) {
        int id = item.getId();
        if (items.containsKey(id)) {
            CartItem existing = items.get(id);
            existing.setQuantity(existing.getQuantity() + item.getQuantity());
        } else {
            items.put(id, item);
        }
    }

    // Update item quantity (overwrite quantity)
    public void updateCartItem(CartItem item, int newQuantity) {
    	 int id = item.getId();
         if (items.containsKey(id)) {
             CartItem existing = items.get(id);
//             existing.getQuantity() +
             existing.setQuantity( newQuantity);
             System.out.println( newQuantity);
         } else {
             items.put(id, item);
         }
    }

    // Remove item
    public void deleteCartItem(CartItem item) {
        items.remove(item.getId());
    }

    // Get all cart items
    public Collection<CartItem> getAllItems() {
        return items.values();
    }

    // Get specific item
    public CartItem getItemById(int itemId) {
        return items.get(itemId);
    }

    // Get total cart value
    public double getTotal() {
        return items.values().stream()
                .mapToDouble(i -> i.getPrice() * i.getQuantity())
                .sum();
    }
}
