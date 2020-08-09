package com.example.eshopnew;

public class ProdListData {
    private String prodcategoryname;

    private int imgId;

    public String getProdcategoryname() {
        return prodcategoryname;
    }

    public void setProdcategoryname(String prodcategoryname) {
        this.prodcategoryname = prodcategoryname;
    }



    public int getImgId() {
        return imgId;
    }

    public void setImgId(int imgId) {
        this.imgId = imgId;
    }

    public ProdListData(String prodcategoryname, int imgId){


        this.prodcategoryname=prodcategoryname;
        this.imgId=imgId;
    }
}

