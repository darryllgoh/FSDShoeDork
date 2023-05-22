let userList = [];

//When user clicks on 'Save Item':
//1) store all the inputs into variables
//2) do validation
//3) calls a function from the productController.js to access the API to add items to the database

const forms = document.querySelectorAll('.needs-validation')

Array.from(forms).forEach(form => {
//Add an 'onsubmit' event listener for productform to add a product
registerForm.addEventListener('submit', (event) => {

    if (!form.checkValidity()) {
       event.preventDefault()
       event.stopPropagation()
    };

    //prevent default action of form submission
    event.preventDefault();

        const username = document.querySelector("#username").value;

        const password = document.querySelector("#password").value;

        // 3)  calls a function from the productController.js to access the API to add items to the database
        addUser(username, password);

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

function validateForm() {
    let x = document.forms["registerForm"]["username"].value;
    let y = document.forms["registerForm"]["password"].value;
    if (x == "" || y == "") {
        alert("Please complete all fields");
        return false;
    }
}


