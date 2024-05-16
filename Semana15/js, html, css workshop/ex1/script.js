function getWeather() {
    const apiKey = 'API KEY'; // Reemplazar con su llave
    const city = 'Cali,CO'; // Reemplazar con la ciudad deseada
	const language='es';    //Reemplazar con el lenguaje deseado
    const apiUrl = `http://api.weatherapi.com/v1/current.json?q=${city}&key=${apiKey}&lang=${language}`;

    fetch(apiUrl)
        .then(response => {
            if (!response.ok) {
                throw new Error('Error de red!!');
            }
            return response.json();
        })
        .then(data => {
            const weatherDiv = document.getElementById('weather');
            weatherDiv.innerHTML = `
                <h2>Tiempo en ${city}</h2>
                <p>Temperatura: ${data.current.temp_c}°C</p>
                <p>Condiciones: ${data.current.condition.text}</p>
            `;
        })
        .catch(error => {
            console.error('Problema con fetch!!:', error);
        });
}
