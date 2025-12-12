document.addEventListener("DOMContentLoaded", function () {
    const orderBtn = document.getElementById("orderBtn");
    const overlay = document.getElementById("overlayForm");
    const closeBtn = document.getElementById("closeBtn");
    const form = document.getElementById("orderForm");

    if (!orderBtn || !overlay || !closeBtn || !form) return;

    // Show overlay
    orderBtn.onclick = () => {
        overlay.style.display = "flex";
    };

    // Hide overlay
    closeBtn.onclick = () => {
        overlay.style.display = "none";
        form.reset();
    };


    // Form
    form.addEventListener("submit", async function (event) {
        event.preventDefault();

        const billCheckbox = form.billBySomeoneElse;
        const email = form.email.value.trim();

        if (!billCheckbox.checked && email === "") {
            alert("Email is mandatory if bill not made by someone else");
            return;
        }

        const orderData = {
            name: form.name.value,
            phone: form.phone.value,
            email: email || "N/A",
            billBySomeoneElse: billCheckbox.checked
        };

        try {
            await saveOrder(orderData);
            alert("Submit Success!");

            overlay.style.display = "none";
            form.reset();
        } catch (err) {
            console.error(err);
            alert("Failed to save order");
        }
    });
});
