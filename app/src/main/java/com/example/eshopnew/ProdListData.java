package com.example.eshopnew;

public class ProdListData {
    private String prodcategoryname;
    private String prodcategorydescription;
    private int imgId;

    public String getProdcategoryname() {
        return prodcategoryname;
    }

    public void setProdcategoryname(String prodcategoryname) {
        this.prodcategoryname = prodcategoryname;
    }

    public String getProdcategorydescription() {
        return prodcategorydescription;
    }

    public void setProdcategorydescription(String prodcategorydescription) {
        this.prodcategorydescription = prodcategorydescription;
    }

    public int getImgId() {
        return imgId;
    }

    public void setImgId(int imgId) {
        this.imgId = imgId;
    }

    public ProdListData(String prodcategorydescription, String prodcategoryname, int imgId){

        this.prodcategorydescription= prodcategorydescription;
        this.prodcategoryname=prodcategoryname;
        this.imgId=imgId;
    }
}

