package com.example.eshopnew;
public class Profilewatches {
    String name;
    String description;
    String price;
    String imageAdress;

    public Profilewatches() {
    }

    public Profilewatches(String name, String description, String price, String imageAdress) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.imageAdress = imageAdress;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getImageAdress() {
        return imageAdress;
    }

    public void setImageAdress(String imageAdress) {
        this.imageAdress = imageAdress;
    }
}