//development APIs
const addAPI= 'http://localhost:8080/user/add';
const displayAPI = 'http://localhost:8080/product/all';


function addUser(username, password)
{
   const formData = new FormData();
   formData.append('username', username);
   formData.append('password', password);

  fetch(addAPI, {
        method: 'POST',
        body: formData
        })
        .then(function(response) {
            console.log(response.status); // Will show you the status
            if (response.ok) {
                alert("Account successfully created!")
                document.getElementById("registerForm").reset();
            }
            else {
               alert("Something went wrong. Please try again")
            }
        })
        .catch((error) => {
            console.error('Error:', error);
            alert("Error creating account")
        });
}
