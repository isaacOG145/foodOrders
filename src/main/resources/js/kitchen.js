document.getElementById("viewOrder").addEventListener("click", () => {
    fetch('http://localhost:8080/orders/checkOrder')
        .then(response => response.json())
        .then(data => {
            if (data.type === "SUCCESS") {
                const order = data.result;

                const tableBody = document.querySelector("#orders-table tbody");
                tableBody.innerHTML = '';

                const row = document.createElement("tr");

                const foods = order.foods.map(food => `${food.name} (Precio: ${food.price})`).join("<br>");

                row.innerHTML = `
                    <td>${order.id}</td>
                    <td>${order.waiter}</td>
                    <td>${foods}</td>
                    <td>${order.totalPrice}</td>
                `;
                tableBody.appendChild(row);

                showMessage("Siguiente orden cargada correctamente", "SUCCESS");
            } else {
                showMessage("No hay órdenes para atender", "WARNING");
            }
        })
        .catch(error => {
            showMessage("Error al cargar la orden", "ERROR");
        });
});

function showMessage(message, type) {
    const messageBox = document.getElementById("message");
    const messageText = document.getElementById("message-text");
    messageBox.style.display = "block";
    messageText.textContent = message;

    if (type === "SUCCESS") {
        messageBox.classList.add("alert-success");
        messageBox.classList.remove("alert-warning", "alert-danger");
    } else if (type === "WARNING") {
        messageBox.classList.add("alert-warning");
        messageBox.classList.remove("alert-success", "alert-danger");
    } else if (type === "ERROR") {
        messageBox.classList.add("alert-danger");
        messageBox.classList.remove("alert-success", "alert-warning");
    }
}

document.getElementById("finishOrder").addEventListener("click", () => {
    fetch('http://localhost:8080/orders/completeOrder', {
        method: 'POST'

    })
        .then(response => response.json())
        .then(data => {
            if (data.type === "SUCCESS") {
                showMessage("Orden completada correctamente", "SUCCESS");
            } else if(data.type === "WARNING") {
                showMessage("No hay  órdenes para completar", "WARNING");
            }
        })
        .catch(error => {
            showMessage("Error al completar la orden", "ERROR");
        });
});

document.getElementById("ViewFinished").addEventListener("click", () => {
    fetch('http://localhost:8080/orders/checkFinished')
        .then(response => response.json())
        .then(data => {
            if (data.type === "SUCCESS") {
                const finishedOrder = data.result;
                const tableBody = document.querySelector("#orders-table tbody");
                tableBody.innerHTML = '';


                const row = document.createElement("tr");

                const foods = finishedOrder.foods.map(food => `${food.name} (Precio: ${food.price})`).join("<br>");

                row.innerHTML = `
                    <td>${finishedOrder.id}</td>
                    <td>${finishedOrder.waiter}</td>
                    <td>${foods}</td> 
                    <td>${finishedOrder.totalPrice}</td>
                `;
                tableBody.appendChild(row);

                // Mostrar mensaje de éxito
                showMessage("Última orden completada cargada correctamente", "SUCCESS");
            } else {
                showMessage("No hay órdenes completadas", "WARNING");
            }
        })
        .catch(error => {
            showMessage("Error al cargar las órdenes completadas", "ERROR");
        });
});
