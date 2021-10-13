import javax.swing.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Stack;

public class BraceMatching {

    public static void main(String[] args) throws FileNotFoundException {
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.showOpenDialog(null);
        File file = fileChooser.getSelectedFile();

        Scanner scan = new Scanner(file);

        String line = scan.nextLine();
        System.out.println("Performing brace matching on the following line: " + line);

        Stack<Character> stack = new Stack<Character>();
        for (int i = 0; i < line.length(); i++) {
            char c = line.charAt(i);
            if (c == '{' || c == '(' || c == '[') {
                stack.push(c);
            }

            System.out.println(stack);
            if (c == '}' || c == ')' || c == ']') {
                if (stack.empty()) {
                    System.out.println("Error: Found a closing '" + c + "' without an opening.");
                    System.exit(1);
                }
                char top = stack.peek();
                if ((c == '}' && top == '{') || (c == ')' && top == '(') || (c == ']' && top == '[')) {
                    stack.pop();
                } else {
                    System.out.println("Error: Found a closing '" + c + "' without an opening.");
                    System.exit(1);
                }
            }
        }
        System.out.println("No errors found.");
    }
    
}