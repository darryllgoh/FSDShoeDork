if (getClickedLink == null) {
    // if user did not arrive at shop page via clicking category link on home page,
    // reset all filters and display all products
    resetFilter();
} else {
    // else if user arrived at shop page via clicking category link on home page, display list from customAPI,
    displayProducts(getCategoryAPI);

    // iterate through the category filter checkbox to check the
    const categoryFilters = document.querySelectorAll('.category-checkbox');
    Array.from(categoryFilters).forEach(categoryCheckbox => {
        if (categoryCheckbox.value == getClickedLink) {
            categoryCheckbox.checked = true;
        }
    })

    document.querySelector('.load-more-btn').innerHTML = `<button type="button" class="btn btn-dark btn-lg rounded-pill py-3 px-5" onClick=resetFilter()>LOAD ALL PRODUCTS</button>`

}

