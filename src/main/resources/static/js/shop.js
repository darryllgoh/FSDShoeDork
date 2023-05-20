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

