function addUser(username, password)
{
   const formData = new FormData();
   formData.append('username', username);
   formData.append('password', password);

  fetch(addUserAPI, {
        method: 'POST',
        body: formData
        })
        .then(function(response) {
            console.log(response.status); // Will show you the status
            if (response.ok) {
                alert("Account successfully created!")
                document.getElementById("registerForm").reset();
                window.location.href = "/login";
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
