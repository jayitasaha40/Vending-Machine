package org.lld.objects;


import java.util.HashMap;
import java.util.Map;

public class Inventory
{
    private Map<Product,Integer> inventory;

    public Inventory() {
        this.inventory = new HashMap<>();
    }

    public  void addProduct(Product product,int quantiity){
        inventory.put(product,inventory.getOrDefault(product,0)+quantiity);
    }

    public void removeProduct(Product product){
        inventory.remove(product);
    }

    public void updateQuantity(Product product,int quantity){
        inventory.put(product,quantity);
    }

    public int getQuantity(Product product){
        return inventory.getOrDefault(product,0);
    }

    public boolean available(Product product){
        return inventory.getOrDefault(product,0)>0;
    }
}
