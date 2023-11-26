package com.example.cafeapp;

public class Product {
    private String id, name, unit;
    private int price, count, total;

    public Product(String id, String name, String unit, int price, int count) {
        this.id = id;
        this.name = name;
        this.unit = unit;
        this.price = price;
        this.count = count;
        this.total = price * count;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getUnit() {
        return unit;
    }

    public int getPrice() {
        return price;
    }

    public int getCount() {
        return count;
    }

    public int getTotal() {
        return total;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", unit='" + unit + '\'' +
                ", price=" + price +
                ", count=" + count +
                ", total=" + total +
                '}';
    }
}
