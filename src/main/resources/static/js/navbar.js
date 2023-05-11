// EXPAND SEARCH BAR (DESKTOP)
const searchInput = document.getElementById("search-input");

searchInput.addEventListener("focus", function() {
  searchInput.classList.add("expand");
});

document.addEventListener("click", function(event) {
  if (event.target != searchInput) {
    searchInput.classList.remove("expand");
  }
});

var offcanvas = document.getElementById('offcanvasExample');
  offcanvas.addEventListener('shown.bs.offcanvas', function () {
    document.getElementById("search-input").focus();
  })