//Initialize productController
let productController = [];

//development APIs
const addAPI= 'http://localhost:8080/product/add';
const displayAPI = 'http://localhost:8080/product/all';

//production APIs
//const addAPI = 'https://TBC.azurewebsites.net/product/add';
//const displayAPI = 'https://TBC.azurewebsites.net/product/all';

// Add product function to quickly hardcode some sample products out, may be moved to upload.js if more suitable
//function addProduct(name, description, brand, category, usSize, color, price, SKU, imgMain, imgHover) {
//    const productItem = {
//        name: name,
//        description: description,
//        brand: brand,
//        category: category,
//        usSize: usSize,
//        color: color,
//        price: price,
//        SKU: SKU,
//        imgMain: imgMain,
//        imgHover: imgHover
//    }
//    productController.push(productItem);
//}

// Adding products by calling functions
//addProduct("Air Force 1 '07", "The radiance lives on in the Nike Air Force 1 '07, the b-ball icon that puts a fresh spin on what you know best: crisp leather, bold accents and the perfect amount of flash to make you shine.", "Nike", "Sneaker", [9, 10, 11, 12], "White", 165, "CW2288-111", "https://static.nike.com/a/images/t_PDP_1728_v1/f_auto,q_auto:eco/38fc1232-33b6-4070-923c-89ab0fa0916a/air-force-1-07-shoes-VWCc04.png", "https://static.nike.com/a/images/t_PDP_1728_v1/f_auto,q_auto:eco/698f576e-2583-45c6-9f63-a3e572353104/air-force-1-07-shoes-VWCc04.png");
//addProduct("Air Force 1 '07", "The radiance lives on in the Nike Air Force 1 '07, the b-ball icon that puts a fresh spin on what you know best: crisp leather, bold accents and the perfect amount of flash to make you shine.", "Nike", "Sneaker", [9, 10, 11, 12], "White", 165, "CW2288-111", "https://static.nike.com/a/images/t_PDP_1728_v1/f_auto,q_auto:eco/38fc1232-33b6-4070-923c-89ab0fa0916a/air-force-1-07-shoes-VWCc04.png", "https://static.nike.com/a/images/t_PDP_1728_v1/f_auto,q_auto:eco/698f576e-2583-45c6-9f63-a3e572353104/air-force-1-07-shoes-VWCc04.png");
//addProduct("Air Force 1 '07", "The radiance lives on in the Nike Air Force 1 '07, the b-ball icon that puts a fresh spin on what you know best: crisp leather, bold accents and the perfect amount of flash to make you shine.", "Nike", "Sneaker", [9, 10, 11, 12], "White", 165, "CW2288-111", "https://static.nike.com/a/images/t_PDP_1728_v1/f_auto,q_auto:eco/38fc1232-33b6-4070-923c-89ab0fa0916a/air-force-1-07-shoes-VWCc04.png", "https://static.nike.com/a/images/t_PDP_1728_v1/f_auto,q_auto:eco/698f576e-2583-45c6-9f63-a3e572353104/air-force-1-07-shoes-VWCc04.png");
//addProduct("Air Force 1 '07", "The radiance lives on in the Nike Air Force 1 '07, the b-ball icon that puts a fresh spin on what you know best: crisp leather, bold accents and the perfect amount of flash to make you shine.", "Nike", "Sneaker", [9, 10, 11, 12], "White", 165, "CW2288-111", "https://static.nike.com/a/images/t_PDP_1728_v1/f_auto,q_auto:eco/38fc1232-33b6-4070-923c-89ab0fa0916a/air-force-1-07-shoes-VWCc04.png", "https://static.nike.com/a/images/t_PDP_1728_v1/f_auto,q_auto:eco/698f576e-2583-45c6-9f63-a3e572353104/air-force-1-07-shoes-VWCc04.png");
//addProduct("Air Force 1 '07", "The radiance lives on in the Nike Air Force 1 '07, the b-ball icon that puts a fresh spin on what you know best: crisp leather, bold accents and the perfect amount of flash to make you shine.", "Nike", "Sneaker", [9, 10, 11, 12], "White", 165, "CW2288-111", "Image/nikeAirForce1071.jpg", "Image/nikeAirForce1072.jpg");
//addProduct("Lug Sole Loafer", "Step out in style with these chunky loafers from Common Projects. Crafted from sleek leather uppers, the gold-tone branded pair is elevated by a lugged outsole for a grungier aesthetic than we've come to expect from the New York brand - but one we can't <em>wait</em> to sport all season long.", "Common Projects", "Dress", [7, 8, 9, 10, 11], "Black", 735, "CP-LSL", "Image/commonProjects-LugSoleLoafer1.jpg", "Image/commonProjects-LugSoleLoafer2.jpg");
//addProduct("Air Jordan 1 Retro High OG", "For Spring 2023, Air Jordan reinvigorates Tinker Hatfield's Air Jordan 3 silhouette and allows the ever iconic “cement print” pattern to take centre stage across the leather overlays. DNA from the OG style remains steadfast, with white leather uppers providing the foundation for both intricate overlays and signature Swoosh - but its neutrally toned colourway adds a versatile, contemporary touch. Just look at the grey rubber outsole underfoot, that seamlessly compliments the “cement print” and “Sail” logo at the midsole, and rounds the effortlessly cool look together.", "Nike", "Sneaker", [7, 8, 9, 10, 11], "Grey", 259, "DZ5485-052", "Image/AirJordan1RetroHighOG1.jpg", "Image/AirJordan1RetroHighOG2.jpg");
//addProduct("Loafer", "Common Projects extends its focus beyond the perfect pair of sneakers to craft these luxurious loafers. This timeless style is made from sleek leather uppers - designed to the traditional Penny style - and punctuated by gold-tone numerical branding to the side for that effortlessly cool if you know, you know look.", "Common Projects", "Dress", [7, 8, 9, 10], "Black", 715, "CP-LF01", "Image/commonProjects-Loafer1.jpg", "Image/commonProjects-Loafer2.jpg");
//addProduct("Original Achilles Low", "A cult sneaker built with clean lines and minimalist luxury, the Achilles design from Common Projects now comes with a low ankle. The luxurious Italian leather uppers are stitched to tough rubber soles for premium traction and they're individually stamped with a gold foil code to mark the colour, style and size.", "Common Projects", "Sneaker", [7, 8, 9, 10, 11, 12], "White", 515, "CP-SK-01", "Image/commonProjects-ArchillesLow1.jpg", "Image/commonProjects-ArchillesLow2.jpg");
//addProduct("Air Force 1 '07", "The year is 1982 - Michael Jordan leads the University of North Carolina to victory against Georgetown University in the NCAA Finals, by scoring the famous shot that launched him into stardom. Since then, the b-ball icon has been releasing sneakers, in collaboration with Nike, inspired by Washington D.C.'s Georgetown University as a show of gratitude. In this latest drop, Nike's classic Air Force 1s are reimagined in Georgetown University's signature colours, through smoky grey suede overlays and deep navy swooshes against a white tumbled leather base. On the tongue and heel, Nike's logo features in a varsity font as a nod to those heady NCAA days.", "Nike", "Sneaker", [11], "White", 180, "", "Image/nikeAirForce107grey1.jpg", "Image/nikeAirForce107grey2.jpg");
//addProduct("Air Zoom Alphafly NEXT% Flyknit 2", "Take any journey in your stride with the Nike Alphafly 2 trainers. The perfect running companion, the trainers use additional foam for Zoom Air Cushioning to help the transition from heel to foot - technique is everything. Made from ultra light weight technology, its carbon fibre plate offers a propulsive sensation for smooth training sessions.", "Nike", "Athletic", [7, 8, 9, 10, 12], "Pink", 425, "NKAZANF2", "Image/nikeAirZoomPink1.jpg", "Image/nikeAirZoomPink2.jpg");
//addProduct("SPZL Denim Italia", "Adidas is back for a summer collection inspired by the past with influences from the future. Bringing a 70s vibe to your summer look, the Denim Italia SPZL is just that - denim! Layers of light and deep blue denim form overlays as well as the iconic 3-Stripe branding. This low-top sneaker takes inspiration from the brand's archived styles, which follows the vibe of the collection. The sidewall of the sneaker features the brand's logo as well as 'ITALIA' in a bold gold which contrasts against the denim.", "Adidas", "Sneaker", [7, 9, 10, 11, 12, 13], "Blue", 220, "HP8843", "Image/adidasSPZL1.jpg", "Image/adidasSPZL2.jpg");
//addProduct("Forum 84 Lo 'Trap Kitchen'", "adidas shines the spotlight on London institution Trap Kitchen as part of its Adilicious City Series. Teaming up with some of the most beloved food spots around the world to celebrate their cuisine and culture through signature silhouettes, here the Forum 84 is remade with bright red accents throughout as a nod the restaurant's bold colour scheme. With a playful phone motif embroidered at the heel, it commemorates the fact Prince Cofi Owusu started the project as a takeaway from his mum's kitchen. You'll have a decadent slice of history with this statement pair.", "Adidas", "Sneaker", [10], "Red", 115, "FZ6565", "Image/adidasForum841.jpg", "Image/adidasForum842.jpg");
//addProduct("Zoom Vomero 5", "Following on from its recent return from hiatus, the Nike Zoom Vomero 5 is reimagined, following a new path as a lifestyle model in a Wheat Grass ensemble. Silhouette-wise, it's straight from the archives, with the same unrivaled Zoom Air cushioning promising technical running sensibilities. Up top? A medley of textures meet complex tech, with layered breathable mesh, synthetic overlays and caged and honeycomb like plastic accents. Finishing off this retro resurgence model is striking reflective accents, a nod to Zoom Vomero 5's functional roots.", "Nike", "Athletic", [7, 8, 9, 10, 11, 12, 13], "Beige", 229, "NKZV5", "Image/zoomVomero1.jpg", "Image/zoomVomero2.jpg");
//addProduct("Y-3 Shiku Run", "Showcase Y-3's futsuristic style with these white, black and grey Shiku Run's. The open mesh and woven uppers provide the utmost comfort while prominent three-stripe detailing creates an x-ray effect that is sure to turn heads on the city streets. Lightweight and durable, they feature enhanced cushioning and sit upon a chunky rubber outsole. The sneakers are secured with a detailed cord system and leather accents to elevate the look.", "Adidas", "Athletic", [8, 9, 10, 11, 12], "Grey", 340, "ADY3SR", "Image/Y3SkikuRun1.jpg", "Image/Y3SkikuRun2.jpg");
//addProduct("Premium 6-Inch Waterproof Boots", "Inspired by our original waterproof boot, this all-season style gives you tireless waterproof performance and instantly recognizable work-boot styling. Other essential features include 400 grams of warm, down-free PrimaLoft® insulation, a padded collar for a comfortable fit around the ankle, and a rubber lug outsole for traction. They're responsibly made, too, with eco-conscious leather uppers and ReBOTL™ fabric lining. Timberland supports responsible manufacturing of leather through the Leather Working Group.", "Timberland", "Boots", [7, 8, 9, 10, 11, 12], "Brown", 269, "10061713", "Image/timberland6Inch1.jpg", "Image/timberland6Inch2.jpg");
//addProduct("Premium 6-Inch Waterproof Boots", "Inspired by our original waterproof boot, this all-season style gives you tireless waterproof performance and instantly recognizable work-boot styling. Other essential features include 400 grams of warm, down-free PrimaLoft® insulation, a padded collar for a comfortable fit around the ankle, and a rubber lug outsole for traction. They're responsibly made, too, with eco-conscious leather uppers and ReBOTL™ fabric lining. Timberland supports responsible manufacturing of leather through the Leather Working Group.", "Timberland", "Boots", [7, 8, 9, 10, 11, 12], "Black", 269, "10061714", "Image/timberland6InchBlack1.jpg", "Image/timberland6InchBlack2.jpg");
//addProduct("Vegan 1460 Boot", "Dr. Martens' 1460 is an icon. From workwear to a near-endless list of subcultures, the boot is a favourite. This pair deviates in construction slightly, though, with red vegan leather across its uppers. All the usual details remain ever-present, however, like the pull tab at the heels, the yellow welt stitching and that famous AirWair™ rubber sole.", "Dr Martens'", "Boots", [7, 8, 9, 10, 11, 12, 13], "Red", 239, "DM1460R", "Image/drMartens1460Red1.jpg", "Image/drMartens1460Red2.jpg");
//addProduct("Derby", "Less is more when it comes to Common Projects, the titan of minimalist footwear. Its own take on a classic Derby shoe, this is handcrafted in Italy from buttery soft leather and is set upon a treaded two-tone rubber outsole. The famed gold foil branding looks right at home at the heel, a signifier of model, colour and size as well as being a symbol of refined simplicity luxury.", "Common Projects", "Dress", [7, 8, 9, 10, 11], "Red", 745, "CP-DB01", "Image/commonProjects-Derby1.jpg", "Image/commonProjects-Derby2.jpg");
//addProduct("Winter Chelsea Boot", "The finest calfskin leather is used to craft these winter-ready Chelsea boots from Common Projects' latest drop. Fitted with ergonomic elasticated panels, they're completed with a treaded rubber sole unit.", "Common Projects", "Boots", [7, 8], "Brown", 595, "CP-WCB01", "Image/commonProjects-Chelsea1.jpg", "Image/commonProjects-Chelsea2.jpg");

//GET API to get all products in product database table and display on website
const displayProducts = () => {
    fetch(displayAPI)
        .then(response => response.json())
        .then(data => {

            console.log("Received data");
            console.log(data);

            data.forEach(product => {
                const productObject = {
                    name: product.name,
                    description: product.description,
                    brand: product.brand,
                    category: product.category,
                    usSize: product.usSize,
                    color: product.color,
                    price: product.price,
                    SKU: product.SKU,
                    imgMain: product.imgMain,
                    imgHover: product.imgHover
                };

                productController.push(productObject);
            })
        renderProductPage();
        })
        .catch(error => {
            console.log(error);
        });
}

// Display (filter) products onto shop page
const renderProductPage = () => {
    let details = "";
    for (let i = 0; i < productController.length; i++) {
        details +=
        `
        <div class="col">
            <div class="product-card">
                <a href="product.html" onclick="displayProductDetails(${i})">
                    <img class="Sirv image-main" src="${productController[i].imgHover}" data-src="${productController[i].imgMain}">
                    <img class="Sirv image-hover" data-src="${productController[i].imgHover}">
                    <div class="card-body">
                        <div>
                        <h6 class="card-title pt-3 pb-2">${productController[i].name}</h6>
                        </div>
                        <div>
                        <h6 class="card-text">$${productController[i].price}</h6>
                        </div>
                    </div>
                </a>
            </div>
        </div>       
        `
    }
    document.querySelector("#productList").innerHTML = details;
}

// Display all products by default (on webpage load)
//renderProductPage(productController); comment off

// Display product through local storage

//const getProduct = localStorage.getItem("productController");
//const storedData = JSON.parse(getProduct);
//renderProductPage(storedData);

displayProducts();

// Prepare data to display individual product in product.html
const displayProductDetails = (index) => {
    // Remove previous stored product details
    localStorage.removeItem("productDetails");

    // Add product details (reference will change after fetch API is implemented)
    //localStorage.setItem("productDetails",JSON.stringify(storedData[index]));
    // used storedData to stringify through to product page
    localStorage.setItem("productDetails",JSON.stringify(productController[index]));
}

// FILTERS

// Targets all form controls in .filter-list and adds event listener which calls filterProduct() on change
const filter = document.querySelector(".filter-list");
filter.addEventListener('change', filterProduct);

// This function is called onclick for every filter checkbox
function filterProduct() {

    // Assign variable for an array of category checkboxes that are checked
    const categoryFilters = Array.from(document.querySelectorAll('input[name="category"]:checked'));

    // Assign variable for an array of color checkboxes that are checked
    const colorFilters = Array.from(document.querySelectorAll('input[name="color"]:checked'));

    // Assign variable for an array of brand checkboxes that are checked
    const brandFilters = Array.from(document.querySelectorAll('input[name="brand"]:checked'));

    const filteredProducts = [];

    /*
    For each product in the productController, isMatched = false by default, unless we find a match in ANY of each if
    statement, then isMatch = true and product is pushed to filteredProducts array.
     */
    productController.forEach((product) => {
        let isMatched = false;

        if (
        // Check match versus list of selected categories (If no category filter selected, keep all product categories in selection)
        (categoryFilters.length == 0 || categoryFilters.some(filter => filter.value.toLowerCase() === product.category.toLowerCase())) &&


        // Check match versus list of selected colors (If no color filter selected, keep all product colors in selection)
        (colorFilters.length == 0 || colorFilters.some(filter => filter.value.toLowerCase() === product.color.toLowerCase())) &&

        // Check match versus list of selected brands (If no brand filter selected, keep all product brands in selection)
        (brandFilters.length == 0 || brandFilters.some(filter => filter.value.toLowerCase() === product.brand.toLowerCase()))) {
            isMatched = true;
        }

        if (isMatched) {
            filteredProducts.push(product);
        }
    });

    // Update the product list with the filtered products
    renderProductPage(filteredProducts);


    // changes between "Load more products" button to No Result output depending on filter result
    if (filteredProducts.length == 0) {
        document.querySelector('.load-more-btn').innerHTML = `<p class="pt-3 pb-5 mb-5">No product matched your filter(s)</p>`;
    } else {
        document.querySelector('.load-more-btn').innerHTML = `<button type="button" class="btn btn-dark btn-lg rounded-pill py-3 px-5">LOAD MORE PRODUCTS</button>`;
    }


}

// Reset filter and display all products
function resetFilter() {
    let checkboxes = document.querySelectorAll('input[type=checkbox]');
    for (let i = 0; i < checkboxes.length; i++) {
        checkboxes[i].checked = false;
    }

    renderProductPage(productController);
    document.querySelector('.load-more-btn').innerHTML = `<button type="button" class="btn btn-dark btn-lg rounded-pill py-3 px-5">LOAD MORE PRODUCTS</button>`;
}

