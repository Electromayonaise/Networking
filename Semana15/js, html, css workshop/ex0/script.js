function sayHello() {
    const nameInput = document.getElementById('nameInput');
    const name = nameInput.value.trim();

    if (name === '') {
        alert('Ingrese su nombre!');
    } else {
        const outputDiv = document.getElementById('output');
        outputDiv.textContent = `Hola, ${name}!`;
    }
}

function doubleNumber() {
    const numberInput = document.getElementById('numberInput');
    const number = parseFloat(numberInput.value);

    if (isNaN(number)) {
        alert('Ingresar un valor numerico!');
    } else {
        const outputDiv = document.getElementById('output');
        const doubledNumber = number * 2;
        outputDiv.textContent = `Doble de ${number} es ${doubledNumber}`;
    }
}
