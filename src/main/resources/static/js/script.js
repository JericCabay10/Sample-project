document.addEventListener("DOMContentLoaded", function() {
    const orderBtn = document.getElementById("orderBtn");
    const overlay = document.getElementById("overlayForm");
    const closeBtn = document.getElementById("closeBtn");
    const form = document.getElementById("orderForm");

    if (orderBtn && overlay && closeBtn && form) {
        orderBtn.onclick = () => overlay.style.display = "flex";
        closeBtn.onclick = () => overlay.style.display = "none";

        form.onsubmit = function(event) {
            const billCheckbox = document.querySelector('input[name="billBySomeoneElse"]');
            const emailInput = document.querySelector('input[name="email"]');

            if (!billCheckbox.checked && emailInput.value.trim() === "") {
                alert("Email is mandatory if bill not made by someone else");
                event.preventDefault();
                return false;
            }

            const name = document.querySelector('input[name="name"]').value;
            const phone = document.querySelector('input[name="phone"]').value;
            const email = emailInput.value || "N/A";

            let orders = JSON.parse(localStorage.getItem("orders")) || [];
            orders.push({ name, phone, email });
            localStorage.setItem("orders", JSON.stringify(orders));

            alert("Submit Success!");
            overlay.style.display = "none";
            form.reset();
            event.preventDefault(); // prevent page reload for demo
        };
    }
});
