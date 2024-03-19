package week2;

import javax.xml.crypto.Data;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.NoSuchElementException;

import static java.lang.Math.sqrt;

public class TwoStackAlgorithm {
    public static Double calculate(String expression) {
        Stack<Double> valueStack = new Stack<>();
        Stack<Character> operandStack = new Stack<>();

        String[] stringArray = expression.split(" ");
        for (String s : stringArray) {
            // if number, regardless int or double
            if (s.length() > 1) {
                valueStack.push(Double.parseDouble(s));
            }
            else {
                char character = s.toCharArray()[0];

                if (Character.isDigit(character)) {
                    valueStack.push(Double.parseDouble(String.valueOf(character)));
                }
                else if (character == '(') continue;
                else if (character == '+' ||
                        character == '-' ||
                        character == '*' ||
                        character == '/' ||
                        character == '%' ||
                        character == '^' ||
                        character == '√' ) {
                    operandStack.push(character);
                }
                else if (character == ')') {
                    char operand = operandStack.pop();
                    double number2 = valueStack.pop();
                    //double number1 = valueStack.pop();

                    double result;

                    if (operand == '+') {
                        result = valueStack.pop() + number2;
                    } else if (operand == '-') {
                        result = valueStack.pop() - number2;
                    } else if (operand == '*') {
                        result = valueStack.pop() * number2;
                    } else if (operand == '/') {
                        result = valueStack.pop() / number2;
                    } else if (operand == '%') {
                        result = valueStack.pop() % number2;
                    } else if (operand == '^') {
                        result = Math.pow(valueStack.pop(), number2);
                    } else if (operand == '√') {
                        result = sqrt(number2);
                    } else {
                        throw new IllegalArgumentException("That is not used in arithmetic!");
                    }

                    // System.out.println("Result is: " + result);
                    valueStack.push(result);
                }
            }
        }
        if (valueStack.isEmpty()) {
            throw new NoSuchElementException();
        }
        return valueStack.pop();
    }

    public static void main(String[] args) {
        // System.out.println(calculate(" ( ( 5 + ( 3 * 8 ) ) - ( 2 * 7 ) )"));
        //System.out.println(calculate("( 2.7 + 5 )"));
        //System.out.println(calculate("( 1 + ( ( 2 + 3 ) * ( 4 * 5 ) ) )"));
        System.out.println(calculate("( √ 16 )"));
    }
}
