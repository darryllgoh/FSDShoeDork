let cartController = [];

const getCartByUserId = () => {
    // Fetch getCartByUserId API
    fetch(getCartAPI)
        .then(response => response.json())
        .then(data => {
            console.log("Fetching: getCartAPI");
            console.log("Received data");
            console.log(data);

            //Iterates through array of cart objects and adds them to cartController array
            data.forEach(cart => {
                cartController.push(cart);
            });

            //render cartController
            renderCart(cartController);
        })
        .catch(error => {
            console.log(error);
        });

    // Fetch calculateCartCosts API
    fetch(getCartCostAPI)
        .then(response => response.json())
        .then(data => {
            console.log("Fetching: getCartCostAPI");
            console.log("Received data");
            console.log(data);

            renderCartSummary(data);
        })
        .catch(error => {
            console.log(error);
        });
}

const renderCart = (array) => {

    let details = "";
    // Do a for loop to iterate through the rest of cart items
    for (let i = 0; i < array.length; i++) {
        details +=
        `
        <div class="container my-4 pb-4 pt-3 border-bottom">
            <div class="row">
                <div class="col-3">
                    <img class="img-fluid" src="${array[i].productImgMain}" alt="">
                </div>
                <div class="col-6">
                        <h5>${array[i].productName}</h5>
                        <p class="mb-2 word-break">${array[i].productBrand} / ${array[i].productCategory
} / ${array[i].productColor}</p>
                        <p>US Size: ${array[i].sizeSelected}</p>
                    <div>
                        <label for="qty_${array[i].id}" class="mt-4 mb-1">Quantity:</label>
                        <br>
                        <input type="number" class="qtyInput" name="quantity" value="${array[i].qty}" id="qty_${array[i].id}"
                        min="1" max="10" class="px-1
                        input-short" onChange="updateCartById(this.id, this.value)">
                    </div>
                </div>
                <div class="col-3">
                    <p class="fw-bold mb-2">Price</p>
                    <p>$${array[i].productPrice}</p>
                    <button class="delete-btn" id=${array[i].id} onClick="deleteCartById(this.id)">
                        <svg xmlns="http://www.w3.org/2000/svg" width="20" height="20" fill="currentColor" class="bi bi-trash3" viewBox="0 0 16 16">
                            <path d="M6.5 1h3a.5.5 0 0 1 .5.5v1H6v-1a.5.5 0 0 1 .5-.5ZM11 2.5v-1A1.5 1.5 0 0 0 9.5 0h-3A1.5 1.5 0 0 0 5 1.5v1H2.506a.58.58 0 0 0-.01 0H1.5a.5.5 0 0 0 0 1h.538l.853 10.66A2 2 0 0 0 4.885 16h6.23a2 2 0 0 0 1.994-1.84l.853-10.66h.538a.5.5 0 0 0 0-1h-.995a.59.59 0 0 0-.01 0H11Zm1.958 1-.846 10.58a1 1 0 0 1-.997.92h-6.23a1 1 0 0 1-.997-.92L3.042 3.5h9.916Zm-7.487 1a.5.5 0 0 1 .528.47l.5 8.5a.5.5 0 0 1-.998.06L5 5.03a.5.5 0 0 1 .47-.53Zm5.058 0a.5.5 0 0 1 .47.53l-.5 8.5a.5.5 0 1 1-.998-.06l.5-8.5a.5.5 0 0 1 .528-.47ZM8 4.5a.5.5 0 0 1 .5.5v8.5a.5.5 0 0 1-1 0V5a.5.5 0 0 1 .5-.5Z"/>
                        </svg>
                    </button>
                </div>
            </div>
        </div>
        `;
    };
    details += `</div>`;
    document.querySelector("#cartList").innerHTML = details;
}

const renderCartSummary = (data) => {
    let shippingCost = "$" + data.shippingCost.toLocaleString('en');
    if (shippingCost == 0) { shippingCost = "FREE"; };
    let subtotal = data.subtotal.toLocaleString('en');
    let taxAmount = data.taxAmount.toLocaleString('en');
    let totalCost = data.totalCost.toLocaleString('en');

    // Do a for loop to sum up qty for each cart item and determine plurality of "item"
    let plurality = "";
    let totalQty = data.cartQty;

    (totalQty < 2) ? plurality = "item" : plurality = "items";

    document.querySelector("#mybag").innerHTML = `<h2 class="bag-header">My Bag <span><p>(${totalQty} ${plurality})</p></span></h2>`;

    orderSummary = `
        <h3>Order Summary</h3>
        <div class="my-4">
            <div class="d-flex justify-content-between border-bottom">
                <p>Subtotal</p>
                <p id="subtotal">$${subtotal}</p>
            </div>
            <div class="d-flex justify-content-between mt-3">
                <p>Taxes</p>
                <p id="taxAmount">$${taxAmount}</p>
            </div>
            <div class="d-flex justify-content-between mt-3">
                <p>Shipping</p>
                <p id="shippingCost">${shippingCost}</p>
            </div>
            <div class="d-flex justify-content-between border-top pt-3">
                <h5>Total</h5>
                <h5 id="totalCost">$${totalCost}</h5>
            </div>
        </div>
    `;

    document.querySelector('#orderSummary').innerHTML = orderSummary;
}

// get Cart By UserId and render on cart page load
getCartByUserId();


// Deletes cart item on user click on delete button
const deleteCartById = clickedId => {
    // reassigns delete cart API to unique
    deleteCartAPI += clickedId;
    fetch(deleteCartAPI, { method: 'DELETE' })
        .then(response => {
        console.log(response.status);   // Will show you the status

        // Re-render cart items if user successfully deleted cart item
        if (response.ok) {
            cartController = [];
            getCartByUserId();
        } else {
            alert("Something went wrong. Please try again");
        }
        })
        .catch((error) => {
            console.error('Error:', error);
            alert("Error deleting cart item!");
        });
    // reset deleteCartAPI to base string
    deleteCartAPI = deleteCartAPI.replace("/cart/" + clickedId, "/cart/");
}

// Update Cart Function that POSTS to database new qty based on cart id and re-renders cart page if successful
const updateCartById = (id, value) => {
    let cartId = id.replace("qty_", "");
    console.log(cartId);
    let cartUpdatedQty = value;
    console.log(cartUpdatedQty);
    const formData = new FormData();
    formData.append('id', cartId);
    formData.append('qty', cartUpdatedQty);

    fetch(updateCartAPI, {
        method: 'POST',
        body: formData
        })
        .then(response => response.json())
        .then(HttpStatusCode => {
            console.log(HttpStatusCode);
            if (HttpStatusCode == 201) {
                // Fetch calculateCartCosts API again and re-renders cart summary if update cart is successful
                fetch(getCartCostAPI)
                    .then(response => response.json())
                    .then(data => {
                        console.log("Fetching: getCartCostAPI");
                        console.log("Received data");
                        console.log(data);

                        renderCartSummary(data);
                    })
                    .catch(error => {
                        console.log(error);
                    });
            } else if (HttpStatusCode == 403){
                alert("Please login to add to cart.");
            } else if (HttpStatusCode == 404) {
                alert("Cart not found.");
            } else {
                alert("Something went wrong. Please try again.");
            }
        })
        .catch((error) => {
          console.error('Error:', error);
          alert("Something went wrong. Please try again.");
        });
}

