package org.generation.FSDShoeDork.controller;

import org.generation.FSDShoeDork.repository.entity.Cart;
import org.generation.FSDShoeDork.service.ShoppingCartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/cart")
public class ShoppingCartController {

    @Value("$image.folder}")
    private String imageFolder;

    private final ShoppingCartService shoppingCartService;


    public ShoppingCartController(@Autowired ShoppingCartService shoppingCartService) {
        this.shoppingCartService = shoppingCartService;

    }

    @Autowired
    private ProductController productController;

//    @CrossOrigin
//    @GetMapping("/all")
//    public Iterable<Cart> getShoppingCart() {
//
////        for (Cart cart: shoppingCartService.all())
////        {
////            Product product = productController.findProductById(cartEntry.getProduct().getId());
////            cartEntry.getProduct().setImgMain(imageFolder + "/" + product.getImgMain());
////            cartEntry.getProduct().setImgHover(imageFolder + "/" + product.getImgHover());
////        }
//
//        return this.shoppingCartService.all();
//
//    }

    @CrossOrigin
    @GetMapping("/cartbyuser")
    public Iterable<Cart> getShoppingCart() {
        //Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        //String currentPrincipalName = authentication.getName();
        //Call getUserByName query to get the Id of the User

        return this.shoppingCartService.findCartByUserId(1);

    }

//    @CrossOrigin
//    @GetMapping("/cart")
//    public Iterable<ShoppingCart> getShoppingCart() {
//
//        for (ShoppingCart shoppingCart: ShoppingCartService.all())
//        {
//            // productImages/commonProjects-LugSoleLoafer1.jpg
//            String setURLMain = imageFolder + "/" + shoppingCart.getProduct().getImgMain();
//            shoppingCart.getProduct().setImgMain(setURLMain);
//            // productImages/Image/commonProjects-LugSoleLoafer2.jpg
//            String setURLHover = imageFolder + "/" + shoppingCart.getProduct().getImgHover();
//            shoppingCart.getProduct().setImgHover(setURLHover);
//        }
//
//        return this.shoppingCartService.all();
//
//    }
//
//    @CrossOrigin
//    @GetMapping("/{id}")
//    public CartEntry findCartEntryById(@PathVariable Integer id) {
//        return shoppingCartService.findById(id);
//    }
//
    @CrossOrigin
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
        shoppingCartService.delete(id);
    }
//
//    @CrossOrigin
//    @PostMapping("/add")
//    public void save(@RequestParam(name="Product_id", required = true) Integer Product_id,
//                     @RequestParam(name="User_id", required = true) Integer User_id,
//                     @RequestParam(name="sizeSelected", required = true) String sizeSelected,
//                     @RequestParam(name="qty", required = true) Integer qty) throws IOException {
//        // Returns Product object / null
//        Product productOptional = productService.findById(Product_id);
//
//        // Returns User object / null
//        User userOptional = userService.findById(User_id);
//
//        // Validate whether productOptional is an object
//        if (productOptional != null && userOptional != null) {
//            CartEntryDTO cartEntryDTO = new CartEntryDTO(productOptional, userOptional, sizeSelected, qty);
//            shoppingCartService.save(new CartEntry(cartEntryDTO));
//        }
//    }
//

}
