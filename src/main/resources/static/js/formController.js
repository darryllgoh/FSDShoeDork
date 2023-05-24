//Create object from form & call fetch method to POST to backend
function addProduct(name, description, brand, category, usSizes, color, price, SKU, imgMain, imgHover, imageObjectMain, imageObjectHover)
{
   const formData = new FormData();
   formData.append('name', name);
   formData.append('description', description);
   formData.append('brand', brand);
   formData.append('category', category);
   formData.append('usSize', usSizes);
   formData.append('color', color);
   formData.append('price', price);
   formData.append('SKU', SKU);
   formData.append('imgMain', imgMain);
   formData.append('imgHover', imgHover);
   formData.append('imageMainfile',imageObjectMain);
   formData.append('imageHoverfile',imageObjectHover);

  fetch(addAPI, {
        method: 'POST',
        body: formData
        })
        .then(function(response) {
            console.log(response.status); // Will show you the status
            if (response.ok) {
                alert("Successfully Added Product!")
                document.getElementById("productForm").reset();
            }
            else {
               alert("Please complete all fields before submission")
            }
        })
        .catch((error) => {
            console.error('Error:', error);
            alert("Error adding item to Product")
        });
}
