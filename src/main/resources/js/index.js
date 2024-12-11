function showMessage(type, message) {
    const messageElement = document.getElementById("message");
    const messageText = document.getElementById("message-text");

    messageElement.className = `alert alert-${type}`;
    messageText.textContent = message;

    messageElement.style.display = 'block';

    setTimeout(() => {
        messageElement.style.display = 'none';
    }, 5000);
}

document.getElementById('goToKitchen').addEventListener('click', function() {

    window.location.href = './kitchen.html';
});


document.getElementById('generateOrders').addEventListener('click', function() {

    fetch('http://localhost:8080/orders/generateOrders', {
        method: 'POST'

    })
        .then(response => response.json())
        .then(data => {

            if (data.status === 'SUCCESS') {
                showMessage('success', data.text);
            } else {
                showMessage('warning', data.text);
            }
        })
        .catch(error => {

            showMessage('error', 'Hubo un problema al generar las órdenes. Intenta nuevamente.');
        });
});
