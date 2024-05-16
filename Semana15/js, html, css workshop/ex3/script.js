document.getElementById('dataForm').addEventListener('submit', async function(event) {
    event.preventDefault();
    const inputData = document.getElementById('dataInput').value;

    const response = await fetch('http://localhost:8000/api/data', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json',
        },
        body: JSON.stringify(inputData),
    });

    if (response.status === 201) {
        document.getElementById('dataInput').value = '';
        fetchData();
    } else {
        alert('Failed to submit data');
    }
});

async function fetchData() {
    const response = await fetch('http://localhost:8000/api/data');
    const data = await response.text();
    const dataList = document.getElementById('dataList');
    dataList.innerHTML = '';
    data.split(', ').forEach(item => {
        const p = document.createElement('p');
        p.textContent = item;
        dataList.appendChild(p);
    });
}

fetchData();
