package org.generation.FSDShoeDork.controller;

//import com.azure.storage.blob.BlobClient;
//import com.azure.storage.blob.BlobContainerClient;
//import com.azure.storage.blob.BlobServiceClient;
//import com.azure.storage.blob.BlobServiceClientBuilder;

import org.generation.FSDShoeDork.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.generation.FSDShoeDork.repository.entity.Product;
import org.springframework.beans.factory.annotation.Value;
import org.generation.FSDShoeDork.component.FileUploadUtil;
import org.generation.FSDShoeDork.controller.dto.ProductDTO;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;
import java.io.IOException;


//request mapping is to provide a url route for frontend to cal the API endpoints
@RestController
@RequestMapping("/product")
public class ProductController {

    @Value("${image.folder}")
    private String imageFolder;

    private final ProductService productService;

    //dependency injection of itemService object so controller can call many methods in the ItemServiceMySQL class
    public ProductController( @Autowired ProductService productService )
    {
        this.productService = productService;
    }

    //API endpoint - to be able to return all products to frontend. frontend will issue a GET http request
    //not in a valid domain, local host is not a valid domain.
    //You can add a @CrossOrigin annotation in order to enable CORS on it (by default @CrossOrigin allows all origins and the HTTP methods specified in the @RequestMapping annotation
    //https://spring.io/blog/2015/06/08/cors-support-in-spring-framework browser will prohibit any fetch calls unless
    // you have @CrossOrigin enabled.
    @CrossOrigin
    @GetMapping( "/all" )
    public Iterable<Product> getProduct()
    {
        //To display images from local folder
        for (Product image: productService.all())
        {
            // productImages/commonProjects-LugSoleLoafer1.jpg
            String setURLMain = imageFolder + "/" + image.getImgMain();
            image.setImgMain(setURLMain);
            // productImages/Image/commonProjects-LugSoleLoafer2.jpg
            String setURLHover = imageFolder + "/" + image.getImgHover();
            image.setImgHover(setURLHover);
        }


        /* To display images from the Server Container */
//        String connectStr2 = "DefaultEndpointsProtocol=https;AccountName=productimagedarryllgoh;AccountKey=NbtYS7PnjSzjZzyh3MqxA+yhJG54DEC76458ym0lxao/cH0Ib/C1fQreSdmRPR99uaYV0t0lqiwZ+AStxyIybA==;EndpointSuffix=core.windows.net";
//        //System.out.println("Connect String: " + connectStr2);
//        BlobServiceClient blobServiceClient = new BlobServiceClientBuilder().connectionString(connectStr2).buildClient();
//        String containerName = "prodimage";
//        BlobContainerClient containerClient = blobServiceClient.getBlobContainerClient(containerName);
//        BlobClient blobClient = containerClient.getBlobClient(itemService.all().get(0).getImageUrl());
//
//
//        //Loop through the ArrayList of itemService.all() and append the Blob url to the imageUrl
//        for (Item image: itemService.all())
//        {
//            //path: productimagespring/prodimage/t-shirt.jpg
//            String setURL = blobClient.getAccountUrl() + "/" + containerName + "/" + image.getImageUrl();
//            image.setImageUrl(setURL);
//        }

        //return in controller represents a response to the client
        return this.productService.all();
    }

    //view record by ID
    //the id value will be sent from the front-end through the API URL parameter
    @CrossOrigin
    @GetMapping( "/{id}" )
    public Product findProductById( @PathVariable Integer id )
    {
        return productService.findById( id );
    }

    //delete record
    @CrossOrigin
    @DeleteMapping( "/{id}" )
    public void delete( @PathVariable Integer id )
    {
        productService.delete( id );
    }

    //set up post mapping and request

    @CrossOrigin
    @PostMapping("/add")
    public void save(  @RequestParam(name="name", required = true) String name,
                       @RequestParam(name="description", required = true) String description,
                       @RequestParam(name="brand", required = true) String brand,
                       @RequestParam(name="category", required = true) String category,
                       @RequestParam(name="usSize", required = true) String usSize,
                       @RequestParam(name="color", required = true) String color,
                       @RequestParam(name="price", required = true) Float price,
                       @RequestParam(name="SKU", required = true) String SKU,
                       @RequestParam(name="imgMain", required = true) String imgMain,
                       @RequestParam(name="imgHover", required = true) String imgHover,
                       @RequestParam("imagefile") MultipartFile multipartFile) throws IOException

    {
        //t-shirt_new.jpg
        String fileName = StringUtils.cleanPath(multipartFile.getOriginalFilename());

        //productimages, t-shirt_new.jpg, object
        FileUploadUtil.saveFile(imageFolder, fileName, multipartFile);

        //String fullPath = imageFolder + "/" + imageUrl;

        ProductDTO productDTO = new ProductDTO(name, description, brand, category, usSize, color, price, SKU, imgMain
                , imgHover);
        productService.save(new Product(productDTO));
    }


}
