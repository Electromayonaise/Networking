// CONDITIONAL STATEMENTS

// If statement

var isRaining = true;

if (isRaining) {
    console.log('You will need an umbrella.');
}

// If-else statement

var isRaining = false;

if (isRaining) {
    console.log('You will need an umbrella.');
}
else {
    console.log('You will not need an umbrella.');
}

// If-else if-else statement

var isRaining = false;

var isSunny = true;

if (isRaining) {
    console.log('You will need an umbrella.');
}
else if (isSunny) {
    console.log('You will need sunglasses.');
}
else {
    console.log('You will need a jacket.');
}

// ternary operator

var isRaining = true;

isRaining ? console.log('You will need an umbrella.') : console.log('You will not need an umbrella.');


// SWITCH STATEMENT

var color = 'red';

switch (color) {
    case 'red':
        console.log('Red is the color of blood.');
        break;
    case 'blue':
        console.log('Blue is the color of the sky.');
        break;
    case 'green':
        console.log('Green is the color of grass.');
        break;
    default:
        console.log('No color matched.');
}

switch (athleteFinalPosition) {
    case 'first place':
      console.log("You get the gold medal!")
        break;
    case 'second place':
        console.log("You get the silver medal!")
        break;
    case 'third place':
        console.log("You get the bronze medal!")
        break;
    default:
        console.log("No medal awarded.")
        break;
  }

// LOOPS

// For loop

for (var i = 0; i < 5; i++) {
    console.log(i);
}

// While loop

var i = 0;

while (i < 5) {
    console.log(i);

    i++;
}

// Do-while loop

var i = 0;

do {
    console.log(i);

    i++;
}

while (i < 5);