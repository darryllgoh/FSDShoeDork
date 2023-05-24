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

    public String getProductBrand()
    {
        return product.getBrand();
    }

    public String getProductCategory()
    {
        return product.getCategory();
    }

    public String getProductColor() {
        return product.getColor();
    }

    public Float getProductPrice() {
        return product.getPrice();
    }

    public String getProductImgMain() {
        return product.getImgMain();
    }

    public String getSizeSelected() {
        return sizeSelected;
    }

    public void setProductImgMain(String imgMain) {
        this.product.setImgMain(imgMain);
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
