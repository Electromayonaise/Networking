function getWeather() {
    const apiKey = 'c38912460721bfb0454dad6b7f65e90d'; 
    const city = document.getElementById('city').value;
	const language= document.getElementById('language').value;
    const unit = document.getElementById('unit').value;
    const apiUrl = `https://api.openweathermap.org/data/2.5/weather?q=${city}&appid=${apiKey}&lang=${language}`;

    fetch(apiUrl)
        .then(response => {
            if (!response.ok) {
                throw new Error('Error de red!!');
            }
            return response.json();
        })
        .then(data => {
            var temp;
            const weatherDiv = document.getElementById('weather');
            if(unit === `metric`){
                data.main.temp = data.main.temp - 273.15;
                temp = data.main.temp + `°C`;
            }
            else if(unit === `imperial`){
                data.main.temp = (data.main.temp - 273.15) * 9/5 + 32;
                temp = data.main.temp + `°F`;
            }
            else{
                temp = data.main.temp + `°K`;
            }
            weatherDiv.innerHTML = `
                <h2>Tiempo en ${city}</h2>
                <p>Temperatura: ${temp}</p>
                <p>Condiciones: ${data.weather[0].description}</p>
            `;
        })
        .catch(error => {
            console.error('Problema con fetch!!:', error);
        });
}
