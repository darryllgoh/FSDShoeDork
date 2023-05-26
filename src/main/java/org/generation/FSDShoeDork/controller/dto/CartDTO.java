package org.generation.FSDShoeDork.controller.dto;

public class CartDTO {

    private Integer Product_id;

    private Integer User_id;

    private String sizeSelected;

    private  Integer qty;

    public CartDTO(Integer Product_id, Integer User_id, String sizeSelected, Integer qty) {
        this.Product_id = Product_id;
        this.User_id = User_id;
        this.sizeSelected = sizeSelected;
        this.qty = qty;
    }

    public Integer getProduct_id() {
        return Product_id;
    }

    public void setProduct_id(Integer product_id) {
        Product_id = product_id;
    }

    public Integer getUser_id() {
        return User_id;
    }

    public void setUser_id(Integer user_id) {
        User_id = user_id;
    }

    public String getSizeSelected() {
        return sizeSelected;
    }

    public void setSizeSelected(String sizeSelected) {
        this.sizeSelected = sizeSelected;
    }

    public Integer getQty() {
        return qty;
    }

    public void setQty(Integer qty) {
        this.qty = qty;
    }
}
