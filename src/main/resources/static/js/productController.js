// To get category link clicked on index page from localStorage (if any)
let getClickedLink = null;
getClickedLink = localStorage.getItem("categoryClicked");


//Initialize productController
let productController = [];

//development APIs
const addAPI= 'http://localhost:8080/product/add';
const displayAllAPI = 'http://localhost:8080/product/all';
const addCartAPI = 'http://localhost:8080/cart/add';
let getCategoryAPI = 'http://localhost:8080/product/cat/' + getClickedLink;
let getProductAPI = `http://localhost:8080/product/{id}`;

//production APIs
//const addAPI = 'https://TBC.azurewebsites.net/product/add';
//const displayAllAPI = 'https://TBC.azurewebsites.net/product/all';
//const addToCartAPI = 'https://TBC.azurewebsites.net/cart/add';
// let getCategoryAPI = 'http://TBC.azurewebsites.net/product/cat/' + getClickedLink;
//let getProductAPI = `http://TBC.azurewebsites.net/product/{id}`;


function addProduct(name, description, brand, category, usSize, color, price, SKU, imgMain, imgHover) {
    const productItem = {
        name: name,
        description: description,
        brand: brand,
        category: category,
        usSize: usSize,
        color: color,
        price: price,
        SKU: SKU,
        imgMain: imgMain,
        imgHover: imgHover
    }
}


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