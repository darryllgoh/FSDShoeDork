// To load data from localStorage into product.html
const getProduct = localStorage.getItem("productDetails");
const convertProduct = JSON.parse(getProduct);

// Insert name
document.querySelector('#name').innerHTML = `${convertProduct.name}`;

// Insert brand, category and color
document.querySelector('#brandcategorycolor').innerHTML = `${convertProduct.brand}/${convertProduct.category}/${convertProduct.color}`;

// Insert price
document.querySelector('.product-price').innerHTML = `$${convertProduct.price}`;

// Insert description
document.querySelector('#description').innerHTML = `${convertProduct.description}`;

// Insert images
document.querySelector('#imgMain').src = `${convertProduct.imgMain}`;
document.querySelector('#imgHover').src = `${convertProduct.imgHover}`;

// Insert sizes
const displaySize = (convertProduct) => {
  let details = "";
  for ( let i = 0; i < convertProduct.usSize.length ; i++ ) {
    details +=`
    <button type="button" class="Button hideSize" aria-label="Size: ${convertProduct.usSize[i]}" name="${convertProduct.usSize[i]}" id="usSize${convertProduct.usSize[i]}">
    <label for="${convertProduct.usSize[i]}"> ${convertProduct.usSize[i]}</label>
    `;
  }
  document.querySelector('.product-size-btn').innerHTML = details;
}
displaySize(convertProduct);

// Insert color
  // insert background color
document.querySelector('.product-color button').style.backgroundColor = `${convertProduct.color}`;
  // insert assistive reading text
document.querySelector('.product-color button').setAttribute('aria-label', `${convertProduct.color}`);
  // insert color text
document.querySelector('.product-color button').innerHTML = `${convertProduct.color}`;


const sizeButtons = Array.from(document.querySelectorAll('.Button'));
let usSizeSelected = "";

//Adds and event listener to each size button where, if one size button is selected, add "active class"
//to it reassigns usSizeSelected variable, and remove "active class from all other size sizeButtons"
sizeButtons.forEach(button => {
  button.addEventListener('click', () => {
    sizeButtons.forEach(btn => {
      btn.classList.remove('active');
    });
    button.classList.add('active');
    usSizeSelected = button.id.slice(6);
  });
});


function addToBag(inputObject) {
  const addToBagProduct = {
    name: inputObject.name,
    description: inputObject.description,
    brand: inputObject.brand,
    category: inputObject.category,
    usSize: usSizeSelected,
    color: inputObject.color,
    price: inputObject.price,
    SKU: inputObject.SKU,
    imgMain: inputObject.imgMain,
    imgHover: inputObject.imgHover
  }
  return addToBagProduct;
}

const addToBagButton = document.querySelector('#addtoBag');

//Added an event listener to ADD TO BAG button to validate that size button is selected prior to creating addToBagProduct object (for ProductDTO)
addToBagButton.addEventListener('click', () => {

  if (usSizeSelected == "") {
    let errorMsg = "Please select a size before adding to bag";
    document.querySelector('#addToBagError').innerHTML = errorMsg;;
    return;
  }
  const addToBagProduct = addToBag(convertProduct);
  document.querySelector('#addToBagError').innerHTML = "";

  addToBagProduct.usSize = parseInt(usSizeSelected);
  console.log("addToBagProduct object:");
  console.log(addToBagProduct);
  return addToBagProduct;

  /* //POST API to be added later
  const formData = new FormData();
  formData.append('name', addToBagProduct.name);
  formData.append('description', addToBagProduct.description);
  formData.append('brand', addToBagProduct.brand);
  formData.append('category', addToBagProduct.category);
  formData.append('usSize', addToBagProduct.usSize);
  formData.append('color', addToBagProduct.color);
  formData.append('price', addToBagProduct.price);
  formData.append('SKU', addToBagProduct.SKU);
  formData.append('imgMain', addToBagProduct.imgMain);
  formData.append('imgHover', addToBagProduct.imgHover);

  fetch(addAPI, {
      method: 'POST',
      body: formData
      })
      .then(function(response) {
          console.log(response.status); // Will show you the status eg. 200 ok, 500, 404
          if (response.ok) {
              alert("Successfully Added Product!");
          }
          else {
             alert("Something went wrong. Please try again");
          }
      })
      .catch((error) => {
          console.error('Error:', error);
          alert("Error adding item to Product");
      });
  */
});