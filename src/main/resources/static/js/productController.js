// To get category link clicked on index page from localStorage (if any)
let getClickedLink = null;
getClickedLink = localStorage.getItem("categoryClicked");
getCategoryAPI = 'http://localhost:8080/product/cat/' + getClickedLink;

//Initialize productController
let productController = [];

//GET API to get all products in product database table and display on website
const displayProducts = (API) => {
    fetch(API)
        .then(response => response.json())
        .then(data => {

            console.log("Received data");
            console.log(data);

            data.forEach(product => {
                let usSizeArray = JSON.parse("[" + product.usSize + "]");
                const productObject = {
                    id: product.id,
                    name: product.name,
                    description: product.description,
                    brand: product.brand,
                    category: product.category,
                    usSize: usSizeArray,
                    color: product.color,
                    price: product.price,
                    SKU: product.sku,
                    imgMain: product.imgMain,
                    imgHover: product.imgHover
                };

                productController.push(productObject);
            })
        renderProductPage(productController);
        localStorage.removeItem("categoryClicked");
        })
        .catch(error => {
            console.log(error);
        });
}

// Display (filter) products onto shop page
const renderProductPage = (array) => {
    let details = "";
    for (let i = 0; i < array.length; i++) {
        details +=
        `
        <div class="col">
            <div class="product-card">
                <a href="product" onClick="displayProductDetails(${i})">
                    <img class="Sirv image-main" src="${array[i].imgHover}" data-src="${array[i].imgMain}">
                    <img class="Sirv image-hover" data-src="${array[i].imgHover}">
                    <div class="card-body">
                        <div>
                        <h6 class="card-title pt-3 pb-2">${array[i].name}</h6>
                        </div>
                        <div>
                        <h6 class="card-text">$${array[i].price}</h6>
                        </div>
                    </div>
                </a>
            </div>
        </div>
        `
    }
    document.querySelector("#productList").innerHTML = details;
}

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
    productController = [];
    displayProducts(displayAllAPI);
    document.querySelector('.load-more-btn').innerHTML = `<button type="button" class="btn btn-dark btn-lg rounded-pill py-3 px-5">LOAD MORE PRODUCTS</button>`;
}