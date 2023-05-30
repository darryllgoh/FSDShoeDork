package org.generation.FSDShoeDork.controller;

import com.azure.storage.blob.BlobClient;
import com.azure.storage.blob.BlobContainerClient;
import com.azure.storage.blob.BlobServiceClient;
import com.azure.storage.blob.BlobServiceClientBuilder;

import org.generation.FSDShoeDork.controller.dto.CartDTO;
import org.generation.FSDShoeDork.repository.entity.Cart;
import org.generation.FSDShoeDork.repository.entity.Product;
import org.generation.FSDShoeDork.service.ProductService;
import org.generation.FSDShoeDork.service.ShoppingCartService;
import org.generation.FSDShoeDork.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

@RestController
@RequestMapping("/cart")
public class ShoppingCartController {

    @Value("${image.folder}")
    private String imageFolder;

    private final ShoppingCartService shoppingCartService;
    private final UserService userService;

    private final ProductService productService;

    public ShoppingCartController(@Autowired ShoppingCartService shoppingCartService, UserService userService,
                                  ProductService productService) {
        this.shoppingCartService = shoppingCartService;
        this.userService = userService;
        this.productService = productService;
    }


    @CrossOrigin
    @GetMapping("/cartbyuser")
    public Iterable<Cart> getShoppingCartByUserId() {
        try {
            Authentication auth = SecurityContextHolder.getContext().getAuthentication();
            //get username from authentication object
            String currentPrincipalName = auth.getName();
            //get userId from userService method
            Integer userId = userService.findUserIdByUserName(currentPrincipalName);
            //return ArrayList of CartItems by logged-in user
            ArrayList<Cart> userCartItems = this.shoppingCartService.findCartByUserId(userId);

            //If productId is unique in HashSet, Prepend image folder directory to imageURL and add productId to HashSet
            //If not unique, do not modify imageURL
            HashSet<Integer> uniqueProductIds = new HashSet<>();

            String connectStr2 = "DefaultEndpointsProtocol=https;AccountName=shoedorkproductimages;AccountKey=I9q0aZO7p1FX18lSVaQ7gEZWzJKkBx4EyyDeD0d1f9JEcuWP+ygTQXCFxDUs279AD9yPae8LC/+f+AStUnDKFg==;EndpointSuffix=core.windows.net";
            //System.out.println("Connect String: " + connectStr2);
            BlobServiceClient blobServiceClient = new BlobServiceClientBuilder().connectionString(connectStr2).buildClient();
            String containerName = "productimage";
            BlobContainerClient containerClient = blobServiceClient.getBlobContainerClient(containerName);
            BlobClient blobClientMain = containerClient.getBlobClient(productService.all().get(0).getImgMain());

            for (Cart cartItem: userCartItems) {
                Integer productId = cartItem.getProductId();
                if (!uniqueProductIds.contains(productId)) {

                    String newURLMain = blobClientMain.getAccountUrl() + "/" + containerName + "/" + cartItem.getProductImgMain();
                    cartItem.setProductImgMain(newURLMain);
                    uniqueProductIds.add(productId);
                }
            }
            return userCartItems;
        } catch (Exception e) {
            System.out.println("Error message: " + e);
            return null;
        }
    }

    @CrossOrigin
    @GetMapping("/costbyuser")
    public HashMap<String, Double> calculateCartCosts(){
        try {
            Authentication auth = SecurityContextHolder.getContext().getAuthentication();
            //get username from authentication object
            String currentPrincipalName = auth.getName();
            //get userId from userService method
            Integer userId = userService.findUserIdByUserName(currentPrincipalName);

            //Getting calculations stored in variables
            double subtotal = shoppingCartService.calculateSubtotalByUserId(userId);
            int cartQty = shoppingCartService.calculateCartQtyByUserId(userId);
            double taxAmount = shoppingCartService.calculateCartTax(subtotal);
            double shippingCost = shoppingCartService.calculateShoppingCost(subtotal, taxAmount, cartQty);
            double totalCost = shoppingCartService.calculateTotalCost(subtotal, taxAmount, shippingCost);

            //Create a HashMap of information to send when API Get method is called
            HashMap<String, Double> CartCosts = new HashMap<>();
            CartCosts.put("subtotal", subtotal);
            CartCosts.put("cartQty", (double) cartQty);
            CartCosts.put("taxAmount", taxAmount);
            CartCosts.put("shippingCost", shippingCost);
            CartCosts.put("totalCost", totalCost);

            return CartCosts;

        } catch( Exception e) {
            System.out.println("Error message: " + e);
            return null;
        }
    }

    @CrossOrigin
    @GetMapping("/cartbyuserlegacy")
    public Iterable<Cart> getShoppingCartLegacy() {
        return this.shoppingCartService.findCartByUserId(1);
    }

    @CrossOrigin
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
        shoppingCartService.delete(id);
    }

    @CrossOrigin
    @PostMapping("/add")
    public int save(@RequestParam(name="Product_id", required = true) Integer Product_id,
                                       @RequestParam(name="sizeSelected", required = true) String sizeSelected,
                                       @RequestParam(name="qty", required = true) Integer qty) throws IOException {
        // Returns Product object / null
        Product productOptional = productService.findById(Product_id);

        // Returns Not Found HTTP status if product is not found based on Product_id
        if (productOptional == null) {
            //return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Something went wrong. Product not found.");
            return 404;
        }

        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        // Returns Unauthorized HTTP status if User is not logged in
        if ( auth == null || auth instanceof AnonymousAuthenticationToken) {
            //return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("You need to login to add items to cart.");
            return 403;
        }

        //get username from authentication object
        String currentPrincipalName = auth.getName();

        //get User_id from userService method
        Integer User_id = userService.findUserIdByUserName(currentPrincipalName);

        // Create new Cart object, save it and return HTTP status OK
        CartDTO cartDTO = new CartDTO(Product_id, User_id, sizeSelected, qty);

        shoppingCartService.save(new Cart(cartDTO));

        // return ResponseEntity.status(HttpStatus.CREATED).body("Product added to cart successfully.");
        return 201;
    }

    @CrossOrigin
    @PostMapping("/addlegacy")
    public ResponseEntity<String> save(@RequestParam(name="Product_id", required = true) Integer Product_id,
                                       @RequestParam(name="User_id", required = true) Integer User_id,
                                       @RequestParam(name="sizeSelected", required = true) String sizeSelected,
                                       @RequestParam(name="qty", required = true) Integer qty) throws IOException {
        // Returns Product object / null
        Product productOptional = productService.findById(Product_id);
        // Returns Not Found HTTP status if product is not found based on Product_id
        if (productOptional == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Something went wrong. Product not found.");
        }

        // Create new Cart object, save it and return HTTP status OK
        CartDTO cartDTO = new CartDTO(Product_id, User_id, sizeSelected, qty);
        shoppingCartService.save(new Cart(cartDTO));
        return ResponseEntity.status(HttpStatus.CREATED).body("Product added to cart successfully.");
    }

    @CrossOrigin
    @PostMapping("/update")
    public int save(@RequestParam(name="id", required = true) Integer id,
//                    @RequestParam(name="Product_id", required = true) Integer Product_id,
//                    @RequestParam(name="sizeSelected", required = true) String sizeSelected,
                    @RequestParam(name="qty", required = true) Integer qty)
            throws IOException {
        // Returns cart object / null
        Cart cartToUpdate = shoppingCartService.findCartById(id);

        if (cartToUpdate == null) {
            // Returns Not Found HTTP status if cart is not found based on cart_id
            return 404;
        }

        cartToUpdate.setQty(qty);
        shoppingCartService.save(cartToUpdate);
        // Update cart object and return HTTP status OK
        return 201;
    }

    @CrossOrigin
    @GetMapping("/{id}")
    public Cart findCartById(@PathVariable Integer id) {
        return shoppingCartService.findCartById(id);
    }
}
