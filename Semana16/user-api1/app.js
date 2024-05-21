const express = require('express');
const bodyParser = require('body-parser');
const app = express();
const port = 3000;
// Middleware 
app.use(bodyParser.json());
// In-memory user list 
let users = [];
// Start the server 
app.listen(port, () => {
    console.log(`Server is running on 
http://localhost:${port}`);
});

// Endpoint to get the list of users (GET)
app.get('/users', (req, res) => {
    res.json(users);
});

// Endpoint to add a new user (POST)
app.post('/users', (req, res) => {
    const user = req.body;
    if (user && user.name && user.email) {
        users.push(user);
        res.status(201).json({ message: 'User added successfully', user });
    } else {
        res.status(400).json({ message: 'Invalid user data' });
    }
});

// Endpoint to update an existing user (PUT)
app.put('/users/:email', (req, res) => {
    const email = req.params.email;
    const updatedUser = req.body;
    let userIndex = users.findIndex(user => user.email === email);
    if (userIndex !== -1) {
        users[userIndex] = { ...users[userIndex], ...updatedUser };
        res.json({
            message: 'User updated successfully', user:
                users[userIndex]
        });
    } else {
        res.status(404).json({ message: 'User not found' });
    }
}); 