package org.generation.FSDShoeDork.controller.dto;

public class ProductDTO {

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


    public ProductDTO(String name, String description, String brand, String category, String usSize, String color,
                      Float price, String SKU, String imgMain, String imgHover) {
        this.name = name;
        this.description = description;
        this.brand = brand;
        this.category = category;
        this.usSize = usSize;
        this.color = color;
        this.price = price;
        this.SKU = SKU;
        this.imgMain = imgMain;
        this.imgHover = imgHover;
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

    public void setUsSize( String usSize )
    {
        this.usSize = usSize;
    }

    public String getColor()
    {
        return color;
    }

    public void setColor( String color )
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

    public void setImgHover( String imgHover )
    {
        this.imgHover = imgHover;
    }


}