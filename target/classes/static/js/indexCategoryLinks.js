const categoryCards = document.querySelectorAll('.category-card');

categoryCards.forEach((card) => {
  card.addEventListener('click', function() {
    // Get the URL from the card's data attribute or any other method
    const categoryClicked = card.id;

    // Store the URL in localStorage
    localStorage.setItem('categoryClicked', categoryClicked);
  });
});