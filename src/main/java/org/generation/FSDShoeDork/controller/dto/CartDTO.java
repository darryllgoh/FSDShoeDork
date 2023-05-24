//package org.generation.FSDShoeDork.controller.dto;
//
//import jakarta.persistence.*;
//import org.generation.FSDShoeDork.repository.entity.Product;
//import org.generation.FSDShoeDork.repository.entity.User;
//
//public class CartDTO {
//
//    private Product product;
//
//    private Integer Product_id;
//
//    private Integer User_id;
//
//    private String sizeSelected;
//
//    private  Integer qty;
//
//    public CartEntryDTO(Integer Product_id, Integer User_id, String sizeSelected, Integer qty) {
//        this.product = Product_id;
//        this.User_id = User_id;
//        this.sizeSelected = sizeSelected;
//        this.qty = qty;
//    }
//
//
//    public String getSizeSelected() {
//        return sizeSelected;
//    }
//
//    public void setSizeSelected(String sizeSelected) {
//        this.sizeSelected = sizeSelected;
//    }
//
//    public Integer getQty() {
//        return qty;
//    }
//
//    public void setQty(Integer qty) {
//        this.qty = qty;
//    }
//}
