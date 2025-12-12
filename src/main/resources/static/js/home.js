async function loadOrders() {
    const res = await fetch("/api/orders");
    const orders = await res.json();

    const container = document.querySelector(".orders-grid");
    container.innerHTML = "";

    orders.forEach(o => {
        const box = document.createElement("div");
        box.classList.add("order-box");

        box.innerHTML = `
            <h3>${o.name}</h3>
            <p>Phone: ${o.phone}</p>
            <p>Email: ${o.email}</p>
            <p>Bill by someone else: ${o.billBySomeoneElse ? "Yes" : "No"}</p>
        `;

        container.appendChild(box);
    });
}

loadOrders();

document.getElementById("clearOrdersBtn").onclick = async () => {
    await fetch("/api/orders", { method: "DELETE" });
    loadOrders();
};
