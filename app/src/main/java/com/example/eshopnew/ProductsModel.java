package com.example.eshopnew;

public class ProductsModel
{

    String description;
    String name;
    String price;


    public ProductsModel() {
    }

    public ProductsModel(String description, String name, String price) {
        this.description = description;
        this.name = name;
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }
}
