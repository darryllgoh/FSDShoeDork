console.log("cart.js is working!");
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
            })

            //render cartController
            renderCart(cartController);
        })
        .catch(error => {
            console.log(error);
        });
}

const renderCart = (array) => {
    let plurality = "";
    (array.length < 2) ? plurality = "item" : plurality = "items";
    let details = `
    <h2 class="bag-header">My Bag <span><p>(${array.length} ${plurality})</p></span></h2>
    `;
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
                        <label for="${array[i].id}_${array[i].qty}" class="mt-4 mb-1">Quantity:</label>
                        <br>
                        <input type="number" name="quantity" value="${array[i].qty}" id="${array[i].id}_${array[i].qty}" min="1" max="10" class="px-1
                        input-short">
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
    }
    details += `</div>`;
    document.querySelector("#cartList").innerHTML = details;
}

//get Cart By UserId and render on cart page load
getCartByUserId();


//Deletes cart item on user click on delete button
deleteCartById = clickedId => {
    //reassigns delete cart API to unique
    deleteCartAPI += clickedId;
    console.log(`after += ${deleteCartAPI}`);
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
    deleteCartAPI = deleteCartAPI.replace("/cart/" + clickedId, "/cart/");
    console.log(`after -= ${deleteCartAPI}`);
}