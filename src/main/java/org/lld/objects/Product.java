package org.lld.objects;

public class Product
{
    private int id;
    private int price;
    private String name;

    public Product(int price, int id, String name) {
        this.price = price;
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

}
