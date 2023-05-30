const carouselReviews = document.querySelector(".carousel-reviews"),
firstImg = carouselReviews.querySelectorAll("img")[0],
arrowIcons = document.querySelectorAll(".wrapper i");
let isDragStart = false, isDragging = false, prevPageX, prevScrollLeft, positionDiff;
const showHideIcons = () => {
    // showing and hiding prev/next icon according to carousel scroll left value
    let scrollWidth = carouselReviews.scrollWidth - carouselReviews.clientWidth; // getting max scrollable width
    arrowIcons[0].style.display = carouselReviews.scrollLeft == 0 ? "none" : "block";
    arrowIcons[1].style.display = carouselReviews.scrollLeft == scrollWidth ? "none" : "block";
}
arrowIcons.forEach(icon => {
    icon.addEventListener("click", () => {
        let firstImgWidth = firstImg.clientWidth + 14; // getting first img width & adding 14 margin value
        // if clicked icon is left, reduce width value from the carousel scroll left else add to it
        carouselReviews.scrollLeft += icon.id == "left" ? -firstImgWidth : firstImgWidth;
        setTimeout(() => showHideIcons(), 60); // calling showHideIcons after 60ms
    });
});
const autoSlide = () => {
    // if there is no image left to scroll then return from here
    if(carouselReviews.scrollLeft - (carouselReviews.scrollWidth - carouselReviews.clientWidth) > -1 || carouselReviews.scrollLeft <= 0) return;
    positionDiff = Math.abs(positionDiff); // making positionDiff value to positive
    let firstImgWidth = firstImg.clientWidth + 14;
    // getting difference value that needs to add or reduce from carousel left to take middle img center
    let valDifference = firstImgWidth - positionDiff;
    if(carouselReviews.scrollLeft > prevScrollLeft) { // if user is scrolling to the right
        return carouselReviews.scrollLeft += positionDiff > firstImgWidth / 3 ? valDifference : -positionDiff;
    }
    // if user is scrolling to the left
    carouselReviews.scrollLeft -= positionDiff > firstImgWidth / 3 ? valDifference : -positionDiff;
}
const dragStart = (e) => {
    // updatating global variables value on mouse down event
    isDragStart = true;
    prevPageX = e.pageX || e.touches[0].pageX;
    prevScrollLeft = carouselReviews.scrollLeft;
}
const dragging = (e) => {
    // scrolling images/carousel to left according to mouse pointer
    if(!isDragStart) return;
    e.preventDefault();
    isDragging = true;
    carouselReviews.classList.add("dragging");
    positionDiff = (e.pageX || e.touches[0].pageX) - prevPageX;
    carouselReviews.scrollLeft = prevScrollLeft - positionDiff;
    showHideIcons();
}
const dragStop = () => {
    isDragStart = false;
    carouselReviews.classList.remove("dragging");
    if(!isDragging) return;
    isDragging = false;
    autoSlide();
}
carouselReviews.addEventListener("mousedown", dragStart);
carouselReviews.addEventListener("touchstart", dragStart);
document.addEventListener("mousemove", dragging);
carouselReviews.addEventListener("touchmove", dragging);
document.addEventListener("mouseup", dragStop);
carouselReviews.addEventListener("touchend", dragStop);