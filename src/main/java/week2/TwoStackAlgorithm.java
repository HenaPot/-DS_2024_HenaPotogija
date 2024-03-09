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

        char[] charArray = expression.toCharArray();

        for (int i = 0; i < charArray.length; i++) {
            if (Character.isDigit(charArray[i])) {
                valueStack.push((double) charArray[i]);
            }
            else if (charArray[i] == '(') continue;
            else if (charArray[i] == '+' ||
                    charArray[i] == '-' ||
                    charArray[i] == '*' ||
                    charArray[i] == '/' ||
                    charArray[i] == '%' ||
                    charArray[i] == '^' ||
                    charArray[i] == '√' ) {
                operandStack.push(charArray[i]);
            }
            else if (charArray[i] == ')') {
                char operand = operandStack.pop();
                double number1 = (double) valueStack.pop();
                double number2 = (double) valueStack.pop();

                double result;

                if (operand == '+') {
                    result = number1 + number2;
                }
                else if (operand == '-') {
                    result = number1 - number2;
                }
                else if (operand == '*'){
                    result = number1 * number2;
                }
                else  if (operand == '/'){
                    result = number1 / number2;
                }
                else if (operand == '%') {
                        result = number1 % number2;
                }
                else if (operand == '^') {
                    result = Math.pow(number1, number2);
                }
                else if (operand == '√'){
                    //ovo se mora popraviti,
                    result = sqrt(number1);
                }
                else {
                    continue;
                }

                System.out.println("Result is: " + result);
                valueStack.push(result);
            }

            try {
                return valueStack.peek();
            } catch (NoSuchElementException exception) {
            }
        }



        // your code here (remove next line)
        return 0.0;
    }

    public static void main(String[] args) {
        System.out.println(calculate(" ( ( 5 + ( 3 * 8 ) ) - ( 2 * 7 ) )"));
    }
}
