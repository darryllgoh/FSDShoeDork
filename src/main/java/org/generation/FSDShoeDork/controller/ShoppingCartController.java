package org.generation.FSDShoeDork.controller;

import org.generation.FSDShoeDork.repository.entity.Cart;
import org.generation.FSDShoeDork.service.ShoppingCartService;
import org.generation.FSDShoeDork.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashSet;

@RestController
@RequestMapping("/cart")
public class ShoppingCartController {

    @Value("${image.folder}")
    private String imageFolder;

    private final ShoppingCartService shoppingCartService;
    private final UserService userService;


    public ShoppingCartController(@Autowired ShoppingCartService shoppingCartService, UserService userService) {
        this.shoppingCartService = shoppingCartService;
        this.userService = userService;
    }


    @CrossOrigin
    @GetMapping("/cartbyuser")
    public Iterable<Cart> getShoppingCartByUserId() {
        try {
            Authentication auth = SecurityContextHolder.getContext().getAuthentication();
            String currentPrincipalName = auth.getName();
            Integer userId = userService.findUserIdByUserName(currentPrincipalName);
            System.out.println(currentPrincipalName);
            System.out.println(userId);
            ArrayList<Cart> userCartItems = this.shoppingCartService.findCartByUserId(userId);
            System.out.println(userCartItems);

            //If productId is unique in HashSet, Prepend image folder directory to imageURL and add productId to HashSet
            //If not unique, do not modify imageURL
            HashSet<Integer> uniqueProductIds = new HashSet<>();
            for (Cart cartItem: userCartItems) {
                Integer productId = cartItem.getProductId();
                if (!uniqueProductIds.contains(productId)) {

                    //Prepend image folder directory to imageURL
                    String setURLMain = imageFolder + "/" + cartItem.getProductImgMain();
                    cartItem.setProductImgMain(setURLMain);
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
    @GetMapping("/cartbyuserlegacy")
    public Iterable<Cart> getShoppingCartLegacy() {
        return this.shoppingCartService.findCartByUserId(1);
    }

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
