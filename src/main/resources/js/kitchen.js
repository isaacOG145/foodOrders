document.getElementById("viewOrder").addEventListener("click", () => {
    fetch('http://localhost:8080/orders/checkOrder')  // Ajusta la URL según sea necesario
        .then(response => response.json())
        .then(data => {
            if (data.type === "SUCCESS") {
                const order = data.result; // Accede a los datos dentro de 'result'
                // Llenar la tabla con la siguiente orden
                const tableBody = document.querySelector("#orders-table tbody");
                tableBody.innerHTML = ''; // Limpiar tabla antes de llenarla

                // Crear la fila para la nueva orden
                const row = document.createElement("tr");
                row.innerHTML = `
                    <td>${order.id}</td>
                    <td>${order.waiter}</td>
                    <td>${order.foods.join(", ")}</td> <!-- Unir los nombres de los platillos -->
                    <td>${order.totalPrice}</td>
                `;
                tableBody.appendChild(row);

                // Mostrar mensaje de éxito
                showMessage("Siguiente orden cargada correctamente", "SUCCESS");
            } else {
                showMessage("No hay órdenes para atender", "WARNING");
            }
        })
        .catch(error => {
            showMessage("Error al cargar la orden", "ERROR");
        });
});

// Función para mostrar los mensajes
function showMessage(message, type) {
    const messageBox = document.getElementById("message");
    const messageText = document.getElementById("message-text");
    messageBox.style.display = "block";
    messageText.textContent = message;

    // Cambiar el color del mensaje dependiendo del tipo
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

// Manejo de la acción para terminar la orden
document.getElementById("finishOrder").addEventListener("click", () => {
    fetch('http://localhost:8080/orders/completeOrder')  // Ajusta la URL según sea necesario
        .then(response => response.json())
        .then(data => {
            if (data.type === "SUCCESS") {
                showMessage("Orden completada correctamente", "SUCCESS");
            } else {
                showMessage("No hay órdenes para completar", "WARNING");
            }
        })
        .catch(error => {
            showMessage("Error al completar la orden", "ERROR");
        });
});

// Manejo de la acción para ver las órdenes terminadas
document.getElementById("ViewFinished").addEventListener("click", () => {
    fetch('http://localhost:8080/orders/checkFinished')  // Ajusta la URL según sea necesario
        .then(response => response.json())
        .then(data => {
            if (data.type === "SUCCESS") {
                const finishedOrder = data.result; // Accede a la última orden completada
                // Llenar la tabla con la orden completada
                const tableBody = document.querySelector("#orders-table tbody");
                tableBody.innerHTML = ''; // Limpiar tabla antes de llenarla

                // Crear la fila para la orden completada
                const row = document.createElement("tr");
                row.innerHTML = `
                    <td>${finishedOrder.id}</td>
                    <td>${finishedOrder.waiter}</td>
                    <td>${finishedOrder.foods.join(", ")}</td> <!-- Unir los nombres de los platillos -->
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
