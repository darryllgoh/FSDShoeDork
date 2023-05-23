let productList = [];

//Global variable - to store the image object
let storeImageMain = "";
let storeImageHover = "";

//When user clicks on 'Save Item':
//1) store all the inputs into variables
//2) do validation
//3) calls a function from the productController.js to access the API to add items to the database

const forms = document.querySelectorAll('.needs-validation')

Array.from(forms).forEach(form => {
//Add an 'onsubmit' event listener for productform to add a product
productForm.addEventListener('submit', (event) => {

    if (!form.checkValidity()) {
       event.preventDefault()
       event.stopPropagation()
    };

    //prevent default action of form submission
    event.preventDefault();

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

        if (usSize.length === 0) {
            // Array length is 0, show error message
            alert("Error: Please check/fill-in in the US size checkboxes or the required fields before submitting the form.");
            return ; // Prevents form submission
          };


        usSizes = usSizes.map(String);
        usSizes.toString();
        console.log(usSizes);

        //end of US size conversion

        const color = document.querySelector('input[name="color"]:checked').value;

        const price = document.querySelector("#price").valueAsNumber;

        const SKU = document.querySelector("#SKU").value;

        const imgMain = document.querySelector('#imgMain').value.replace("C:\\fakepath\\", "");

        const imgHover = document.querySelector('#imgHover').value.replace("C:\\fakepath\\", "");

        // 3)  calls a function from the productController.js to access the API to add items to the database
        addProduct(name, description, brand, category, usSizes, color, price, SKU, imgMain, imgHover, storeImageMain, storeImageHover);

        //Example starter JavaScript for disabling form submissions if there are invalid fields

        //const forms = document.querySelectorAll('.needs-validation')


//        (() => {
//            'use strict'
//
//            // Fetch all the forms we want to apply custom Bootstrap validation styles to
//            const forms = document.querySelectorAll('.needs-validation')
//
//            // Loop over them and prevent submission
//            Array.from(forms).forEach(form => {
//              form.addEventListener('submit', event => {
//                if (!form.checkValidity()) {
//                  event.preventDefault()
//                  event.stopPropagation()
//                };
//
//                form.classList.add('was-validated')
//              }, false);
//            })
//          })
        form.classList.add('was-validated')
    }, false);
})

        // select file input
        const inputMain = document.querySelector('#imgMain');
        // add event listener
        inputMain.addEventListener('change', () => {
          storeImageMain = inputMain.files[0]; //array of files for us to access
        })

        const inputHover = document.querySelector('#imgHover');
        // add event listener
        inputHover.addEventListener('change', () => {
          storeImageHover = inputHover.files[0]; //array of files for us to access
        })


