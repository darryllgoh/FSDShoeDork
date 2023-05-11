let product = [];

//pull form inputs via API
function getInput() {
    const name = document.querySelector("#name").value;

    const description = document.querySelector("#description").value;

    const brand = document.querySelector("#brand").value;

    const category = document.querySelector("#category").value;

    //convert us size to array
    const usSize = document.querySelectorAll("input[type='checkbox']:checked");
    let usSizes = [];

    for (let i = 0; i < usSize.length; i++) {
        usSizes.push(usSize[i].value)
    }

    usSizes = usSizes.map(Number);
    console.log(usSizes);

    //end of US size conversion

    const color = document.querySelector('input[name="color"]:checked').value; 

    const price = document.querySelector("#price").valueAsNumber;

    const SKU = document.querySelector("#SKU").value;

    const imgMain = document.querySelector("#imgMain").value;

    const imgHover = document.querySelector("#imgHover").value;
 
    // update product list by combining hard coded product data with form data
    addProduct(name, description, brand, category, usSizes, color, price, SKU, imgMain, imgHover);
    
    //replaced product.push below

    console.log(productList);

    //pull updated product list to local storage in json
    localStorage.setItem("productList", JSON.stringify(productList)); 
    //- remove above

    document.getElementById("productForm").reset();

    alert("Thank you for submitting a product listing!")
    
}

//3 local storage (set to Json) (review fetch API)
//4 test
// add on a code to display all the products from local storage 

//call addProduct function on line 28 to 42 - e.g. name is name
//review fetch api exercise

/*

test data

ADIDAS SAMBA OG

The Adidas Samba sneaker was first designed in 1949 to enable football players to train on icy ground, this history is expanded with the new Samba OG. A timeless icon that merges street and sporty style. Made with the same leather uppers as the original, the brand's iconic 3-Stripe branding still takes place with a matching contrasting heel to match.

Adidas

Sneakers

Size

White

219

ADIDAS SAMBA OG

https://media.endclothing.com/media/f_auto,q_auto:eco,w_768/prodmedia/media/catalog/product/2/9/29-12-2022_AW_B75806_m1_1.jpg


https://media.endclothing.com/media/f_auto,q_auto:eco,w_768/prodmedia/media/catalog/product/2/9/29-12-2022_AW_B75806_2_1.jpg

*/