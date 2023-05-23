package org.generation.FSDShoeDork.repository.entity;

import jakarta.persistence.*;
//import org.generation.FSDShoeDork.controller.dto.CartDTO;

@Entity
public class Cart {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "Product_id", insertable = false, updatable = false)
    private Product product;

    private String sizeSelected;

    private Integer qty;

    private Integer Product_id;

    private Integer User_id;

    public Cart() {}

//    public Cart(CartDTO cartDTO) {
//        this.product = cartDTO.getProduct();
//        this.user = cartDTO.getUser();
//        this.sizeSelected = cartDTO.getSizeSelected();
//        this.qty = cartDTO.getQty();
//    };

    public Integer getId() {
        return id;
    }

    public Integer getProductId() {
        return Product_id;
    }

    public Integer getUserId() {
        return User_id;
    }

    public String getProductName() {
        return product.getName();
    }

    public String getProductDescription() {
        return product.getDescription();
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
