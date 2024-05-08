// VARIABLES

// Declaring a variable

var name;

// Assigning a value to a variable

name = 'Yossarian';

// Declaring and assigning a value to a variable

var name = 'Yossarian';

// Printing the value of a variable

console.log(name); // prints Yossarian

// Reassigning a value to a variable

name = 'Orr';

console.log(name); // prints Orr

// let keyword

// Let signals that the variable may be reassigned a different value.

let meal = 'Enchiladas';
console.log(meal); // Output: Enchiladas
meal = 'Burrito';
console.log(meal); // Output: Burrito

// When using let, and even var, we can declare a variable without assigning a value to it, it will be undefined.

let price;
console.log(price); // Output: undefined
price = 350;
console.log(price); // Output: 350

// Constants

const pi = 3.14;

console.log(pi); // prints 3.14

// pi = 3.14159; // TypeError: Assignment to constant variable.


// Mathematical Assignment Operators

let x = 20;
x -= 5; // Can be written as x = x - 5
console.log(x); // Output: 15

let y = 50;
y *= 2; // Can be written as y = y * 2
console.log(y); // Output: 100

let z = 8;
z /= 2; // Can be written as z = z / 2
console.log(z); // Output: 4

let levelUp = 10;
let powerLevel = 9001;
let multiplyMe = 32;
let quarterMe = 1152;

// Use the mathematical assignments in the space below:
levelUp += 5
powerLevel -=100
multiplyMe *=11
quarterMe /=4

// These console.log() statements below will help you check the values of the variables.
// You do not need to edit these statements. 
console.log('The value of levelUp:', levelUp); 
console.log('The value of powerLevel:', powerLevel); 
console.log('The value of multiplyMe:', multiplyMe); 
console.log('The value of quarterMe:', quarterMe);

// String concatenation with variables

let myPet = 'armadillo';
console.log('I own a pet ' + myPet + '.'); 
// Output: 'I own a pet armadillo.'


// String interpolation

var name = 'Yossarian';

console.log(`Hello, ${name}!`); // prints Hello, Yossarian!

var myName = "Martin"
var myCity = "a"
console.log(`My name is ${myName}. My favorite city is ${myCity}.`) // prints My name is Martin. My favorite city is a.


// typeof operator

// The typeof operator returns the data type of a value. It checks the value to its right and returns a string of the data type.

const unknown1 = 'foo';
console.log(typeof unknown1); // Output: string

const unknown2 = 10;
console.log(typeof unknown2); // Output: number

const unknown3 = true; 
console.log(typeof unknown3); // Output: boolean


