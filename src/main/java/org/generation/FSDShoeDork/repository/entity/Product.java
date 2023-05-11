package org.generation.FSDShoeDork.repository.entity;


//Repository package is part of the Model Component (MVC)
//Item is the entity class to use to map against the table from the database

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.*;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import org.generation.FSDShoeDork.controller.dto.ProductDTO;

@Entity
public class Product {

    //Properties/attributes - will be mapped to the columns of the database table
    //Need to use the Wrapper class on primitive data types - need to pass the datatype
    // as an object to CRUDRepository Class (provided by SpringBoot framework)

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //@GeneratedValue because our primary key is auto generated
    private Integer id; //wrapper not primitive
    //retrieve product item by ID - has to be an object - primary key
    //all keys should map the same name to the db columns

    private String name;
    private String description;
    private String brand;
    private String category;
    private String usSize;
    private String color;
    private Float price;
    private String SKU;
    private String imgMain;
    private String imgHover;

    public Product() {}
    //Item class used to map with DB table
    //Any CRUD operation, JPA will make use of this item class to map.
    //For read or delete operation, the JPA requires an empty constructor to populate all records from the db as item
    // instances

    //Constructor overloading

    // DTO - data transfer object is set up in the controller layer
    // DTO is for create and update, sent via controller.
    public Product(ProductDTO productDTO)
    {
        //Transfer the object (with the data) to Entity Class for mapping with the
        // database table columns and to be able to save the data in the columns
        this.name = productDTO.getName();
        this.description = productDTO.getDescription();
        this.brand = productDTO.getBrand();
        this.category = productDTO.getCategory();
        this.usSize = productDTO.getUsSize();
        this.color = productDTO.getColor();
        this.price = productDTO.getPrice();
        this.SKU = productDTO.getSKU();
        this.imgMain = productDTO.getImgMain();
        this.imgHover = productDTO.getImgHover();


    }

    public Integer getId()
    {
        return id;
    }

    public void setId( Integer id )
    {
        this.id = id;
    }

    public String getName()
    {
        return name;
    }

    public void setName( String name )
    {
        this.name = name;
    }

    public String getDescription()
    {
        return description;
    }

    public void setDescription( String description )
    {
        this.description = description;
    }

    public String getBrand()
    {
        return brand;
    }

    public void setBrand( String brand )
    {
        this.brand = brand;
    }

    public String getCategory()
    {
        return category;
    }

    public void setCategory( String category )
    {
        this.category = category;
    }

    public String getUsSize()
    {
        return usSize;
    }

    public void setUsSize( String category )
    {
        this.usSize = usSize;
    }

    public String getColor()
    {
        return color;
    }

    public void setColor( String category )
    {
        this.color = color;
    }

    public Float getPrice()
    {
        return price;
    }

    public void setPrice( Float price )
    {
        this.price = price;
    }

    public String getSKU()
    {
        return SKU;
    }

    public void setSKU( String SKU )
    {
        this.SKU = SKU;
    }

    public String getImgMain()
    {
        return imgMain;
    }

    public void setImgMain( String imgMain )
    {
        this.imgMain = imgMain;
    }

    public String getImgHover()
    {
        return imgHover;
    }

    public void setImgHover( String style )
    {
        this.imgHover = imgHover;
    }


    @Override
    public String toString()
    {
        return "Item{" + "id=" + id + ", name='" + name + '\'' + ", description='" +
                description + '\'' + ", brand='" + brand + '\'' + ", category='" + category + '\'' + ", usSize='" + usSize + '\''
                + ", color='" + color + '\'' + ", price='" + price + '\'' + ", SKU='" + SKU + '\'' + ", imgMain='" + imgMain + '\''
                + ", imgHover='" + imgHover + '}';
    }

}
