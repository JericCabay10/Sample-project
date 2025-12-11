document.addEventListener("DOMContentLoaded", function() {
    const container = document.querySelector(".orders-grid");
    const orders = JSON.parse(localStorage.getItem("orders")) || [];

    orders.forEach(order => {
        const div = document.createElement("div");
        div.classList.add("order-card");
        div.innerHTML = `
            <p><strong>Name:</strong> ${order.name}</p>
            <p><strong>Phone:</strong> ${order.phone}</p>
            <p><strong>Email:</strong> ${order.email}</p>
        `;
        container.appendChild(div);
    });

    // Clear all orders button
    const clearBtn = document.getElementById("clearOrdersBtn");
    clearBtn.addEventListener("click", () => {
        if (confirm("Are you sure you want to delete all submitted orders?")) {
            localStorage.removeItem("orders");       // Delete from localStorage
            container.innerHTML = "";                // Clear the grid display
            alert("All orders have been deleted!");
        }
    });
});


//                    // Clear all submitted orders
//                    localStorage.removeItem("orders");
//
//                    // Optional: reload page to reflect changes
//                    location.reload();