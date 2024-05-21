const express = require('express');
const bodyParser = require('body-parser');
const app = express();
app.use(bodyParser.json());
const port = process.env.PORT || 3000;
app.listen(port, () => {
    console.log(`Server is running on port ${port}`);
});

app.get('/api/hello', (req, res) => {
    res.json({ message: 'Hola, somos Universidad ICESI!' });
}); 