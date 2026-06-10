function goBack() {
  window.history.back();
}

// Show Success Message (e.g., Add to Cart, Contact)
function showMessage(message) {
  const msgBox = document.createElement('div');
  msgBox.className = 'popup-message';
  msgBox.innerText = message;

  document.body.appendChild(msgBox);

  setTimeout(() => {
    msgBox.classList.add('show');
  }, 100);

  setTimeout(() => {
    msgBox.classList.remove('show');
    setTimeout(() => document.body.removeChild(msgBox), 300);
  }, 2500);
}

// Add to Cart Handler
function addToCart(productName) {
  showMessage(`🛒 "${productName}" added to cart!`);
  
}

// Report Listing Handler
function reportListing() {
  showMessage("🚩 Report submitted. Thank you!");
}

// Contact Seller Handler
function contactSeller() {
  showMessage("📩 Seller contacted successfully.");
}

// Toggle Password Visibility (used in Register/Login pages)
function togglePassword(id) {
  const field = document.getElementById(id);
  if (field.type === "password") {
    field.type = "text";
  } else {
    field.type = "password";
  }
}

// Animate Cards on Scroll
function animateOnScroll() {
  const items = document.querySelectorAll(".fade-in");
  const trigger = window.innerHeight * 0.85;

  items.forEach(item => {
    const itemTop = item.getBoundingClientRect().top;
    if (itemTop < trigger) {
      item.classList.add("visible");
    }
  });
}

window.addEventListener("scroll", animateOnScroll);
window.addEventListener("load", animateOnScroll);