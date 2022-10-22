/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PreFix;

import java.util.Scanner;
import java.util.Stack;

/**
 *
 * @author ADMIN
 */
public class PreFixExpression {

    static double evaluatePreFixExp(String exp) {
        double result = 0;
        Stack<Double> stack = new Stack<>();
        String arr[] = exp.trim().split(" ");
        for (int i = arr.length - 1; i >= 0; i--) {
            if (!arr[i].equals("+") && !arr[i].equals("-") && !arr[i].equals("*") && !arr[i].equals("/")) {
                stack.push(Double.parseDouble(arr[i]));
            } else {
                double o1 = stack.pop();
                double o2 = stack.pop();
                if (arr[i].equals("+")) {
                    result = o1 + o2;
                } else if (arr[i].equals("-")) {
                    result = o1 - o2;
                } else if (arr[i].equals("*")) {
                    result = o1 * o2;
                } else if (arr[i].equals("/")) {
                    if (o2 == 0) {
                        throw new RuntimeException("Divide by 0!!");
                    } else {
                        result = o1 / o2;
                    }
                } else {
                    throw new RuntimeException("This operator is not supported!!");
                }
                stack.push(result);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean flag = true;
        String exp;
        do {
            System.out.print("Enter Prefix Expression: ");
            exp = sc.nextLine();
            if (exp.isEmpty()) {
                System.out.println("Empty text! Try again!");
            } else {
                flag = false;
            }
        } while (flag);
        System.out.println(evaluatePreFixExp(exp));

    }
}

