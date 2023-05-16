//package org.generation.FSDShoeDork.repository.entity;
//
//import jakarta.persistence.*;
//import org.generation.FSDShoeDork.controller.dto.CartEntryDTO;
//
//@Entity
//@Table(name = "shoppingcart")
//public class CartEntry {
//
//    @Id
//    @GeneratedValue (strategy = GenerationType.IDENTITY)
//    private Integer id;
//
//    //@ManyToOne(fetch = FetchType.EAGER)
//    @JoinColumn(name = "product_id", referencedColumnName = "id")
//    private Product product;
//
//    //@ManyToOne(fetch = FetchType.EAGER)
//    @JoinColumn(name = "user_id", referencedColumnName = "id")
//    private User user;
//
//    @Column(name = "sizeSelected")
//    private String sizeSelected;
//
//    @Column(name = "qty")
//    private  Integer qty;
//
//    public CartEntry() {}
//
//    public CartEntry(CartEntryDTO cartEntryDTO) {
//        this.product = cartEntryDTO.getProduct();
//        this.user = cartEntryDTO.getUser();
//        this.sizeSelected = cartEntryDTO.getSizeSelected();
//        this.qty = cartEntryDTO.getQty();
//    };
//
//    public Integer getId() {
//        return id;
//    }
//
//    public void setId(Integer id) {
//        this.id = id;
//    }
//
//    public Product getProduct() {
//        return product;
//    }
//
//    public void setProduct(Product product) {
//        this.product = product;
//    }
//
//    public User getUser() {
//        return user;
//    }
//
//    public void setUser(User user) {
//        this.user = user;
//    }
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
