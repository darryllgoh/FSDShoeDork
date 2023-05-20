//package org.generation.FSDShoeDork.controller;
//
//import org.generation.FSDShoeDork.repository.entity.CartEntry;
//import org.generation.FSDShoeDork.service.ProductService;
//import org.generation.FSDShoeDork.service.ShoppingCartService;
//import org.generation.FSDShoeDork.service.UserService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.web.bind.annotation.*;
//
//@RestController
//@RequestMapping("/cart")
//public class ShoppingCartController {
//
//    @Value("$image.folder}")
//    private String imageFolder;
//
//    private final ShoppingCartService shoppingCartService;
//    private final ProductService productService;
//    private final UserService userService;
//
//    public ShoppingCartController(@Autowired ShoppingCartService shoppingCartService, ProductService productService, UserService userService) {
//        this.shoppingCartService = shoppingCartService;
//        this.productService = productService;
//        this.userService = userService;
//    }
//
//    @Autowired
//    private ProductController productController;
//
//    @CrossOrigin
//    @GetMapping("/all")
//    public Iterable<CartEntry> getShoppingCart() {
//
////        for (CartEntry cartEntry: shoppingCartService.all())
////        {
////            Product product = productController.findProductById(cartEntry.getProduct().getId());
////            cartEntry.getProduct().setImgMain(imageFolder + "/" + product.getImgMain());
////            cartEntry.getProduct().setImgHover(imageFolder + "/" + product.getImgHover());
////        }
//
//        return this.shoppingCartService.all();
//
//    }
//
//    @CrossOrigin
//    @GetMapping("my")
//    public Iterable<CartEntry> findAllByUserId() {
////        for (CartEntry cartEntry: shoppingCartService.findAllByUserId(userId))
////        {
////            Product product = productController.findProductById(cartEntry.getProduct().getId());
////            cartEntry.getProduct().setImgMain(imageFolder + "/" + product.getImgMain());
////            cartEntry.getProduct().setImgHover(imageFolder + "/" + product.getImgHover());
////        }
//
//        return this.shoppingCartService.findAllByUserId();
//    }
//
//
////    @CrossOrigin
////    @GetMapping("/cart")
////    public Iterable<ShoppingCart> getShoppingCart() {
////
////        for (ShoppingCart shoppingCart: ShoppingCartService.all())
////        {
////            // productImages/commonProjects-LugSoleLoafer1.jpg
////            String setURLMain = imageFolder + "/" + shoppingCart.getProduct().getImgMain();
////            shoppingCart.getProduct().setImgMain(setURLMain);
////            // productImages/Image/commonProjects-LugSoleLoafer2.jpg
////            String setURLHover = imageFolder + "/" + shoppingCart.getProduct().getImgHover();
////            shoppingCart.getProduct().setImgHover(setURLHover);
////        }
////
////        return this.shoppingCartService.all();
////
////    }
//
////    @GetMapping("/cart")
////    public String viewShoppingCart(Model model) {
////        // Get the logged-in user's shopping cart
////        User user = getCurrentUser();
////        List<ShoppingCart> shoppingCartList = shoppingCartService.getShoppingCartByUser(user);
////
////        // Iterate through each shopping cart item and set the image URL paths
////        for (ShoppingCart shoppingCart : shoppingCartList) {
////            Product product = shoppingCart.getProduct();
////            String setURLMain = imageFolder + "/" + product.getImgMain();
////            product.setImgMain(setURLMain);
////            String setURLHover = imageFolder + "/" + product.getImgHover();
////            product.setImgHover(setURLHover);
////        }
////
////        // Add the shopping cart items to the model
////        model.addAttribute("shoppingCartList", shoppingCartList);
////
////        return "shoppingCart";
////    }
//
////    @CrossOrigin
////    @GetMapping("/{id}")
////    public CartEntry findCartEntryById(@PathVariable Integer id) {
////        return shoppingCartService.findById(id);
////    }
////
////    @CrossOrigin
////    @DeleteMapping("/{id}")
////    public void delete(@PathVariable Integer id) {
////        shoppingCartService.delete(id);
////    }
////
////    @CrossOrigin
////    @PostMapping("/add")
////    public void save(@RequestParam(name="Product_id", required = true) Integer Product_id,
////                     @RequestParam(name="User_id", required = true) Integer User_id,
////                     @RequestParam(name="sizeSelected", required = true) String sizeSelected,
////                     @RequestParam(name="qty", required = true) Integer qty) throws IOException {
////        // Returns Product object / null
////        Product productOptional = productService.findById(Product_id);
////
////        // Returns User object / null
////        User userOptional = userService.findById(User_id);
////
////        // Validate whether productOptional is an object
////        if (productOptional != null && userOptional != null) {
////            CartEntryDTO cartEntryDTO = new CartEntryDTO(productOptional, userOptional, sizeSelected, qty);
////            shoppingCartService.save(new CartEntry(cartEntryDTO));
////        }
////    }
////
//
//}
