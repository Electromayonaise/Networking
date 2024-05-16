const apiKey = 'API KEY'; // Reemplazar con su llave
const city = 'Cali'; // reemplazar con la ciudad

async function getWeatherForecast() {
    const response = await fetch(`https://api.openweathermap.org/data/2.5/forecast?q=${city}&units=metric&appid=${apiKey}`);
    if (!response.ok) {
        throw new Error('Network response was not ok');
    }
    const data = await response.json();
    return data;
}

function plotForecast(data) {
    const ctx = document.getElementById('forecastChart').getContext('2d');
    const labels = [];
    const temperatures = [];
    
    // Extract the temperature data for the next 24 hours (8 time points as the forecast is in 3-hour intervals)
    for (let i = 0; i < 8; i++) {
        const forecast = data.list[i];
        const date = new Date(forecast.dt * 1000);
        labels.push(`${date.getHours()}:00`);
        temperatures.push(forecast.main.temp);
    }

    const chart = new Chart(ctx, {
        type: 'line',
        data: {
            labels: labels,
            datasets: [{
                label: 'Temperatura (°C)',
                data: temperatures,
                borderColor: 'rgba(75, 192, 192, 1)',
                backgroundColor: 'rgba(75, 192, 192, 0.2)',
                fill: true,
            }]
        },
        options: {
            scales: {
                x: {
                    title: {
                        display: true,
                        text: 'Tiempo'
                    }
                },
                y: {
                    title: {
                        display: true,
                        text: 'Temperatura (°C)'
                    }
                }
            }
        }
    });
}

async function main() {
    try {
        const forecastData = await getWeatherForecast();
        plotForecast(forecastData);
    } catch (error) {
        console.error('Se presento un problema con la operación fetch:', error);
    }
}

main();
