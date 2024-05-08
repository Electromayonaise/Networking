# Ways to Represent Color in CSS

In CSS, there are four main ways to represent color:

1. **Named Colors**: There are more than 140 named colors, which you can review [here on MDN](https://developer.mozilla.org/en-US/docs/Web/CSS/named-color).
2. **Hexadecimal or Hex Colors**:
   - Hexadecimal is a number system that has sixteen digits, 0 to 9 followed by “A” to “F”.
   - Hex values always begin with `#` and specify values of red, blue, and green using hexadecimal numbers such as `#23F41A`.
   - Six-digit hex values with duplicate values for each RGB value can be shorted to three digits.
3. **RGB**:
   - RGB colors use the `rgb()` syntax with one value for red, one value for blue, and one value for green.
   - RGB values range from 0 to 255 and look like this: `rgb(7, 210, 50)`.
4. **HSL**:
   - HSL stands for hue (the color itself), saturation (the intensity of the color), and lightness (how light or dark a color is).
   - Hue ranges from 0 to 360 and saturation and lightness are both represented as percentages like this: `hsl(200, 20%, 50%)`.
   - Opacity can be added to color in RGB and HSL by adding a fourth value, `a`, which is represented as a percentage.
