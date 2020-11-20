package ru.vsu.cs;

import java.util.Locale;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Locale.setDefault(Locale.ROOT);

        double x = readValue('x');
        int n = readNumberOfElements('n');
        double eps = readValue('e');
        checkValue(eps);

        printResult(calcSumOfSequence(x, n));
        printResultEps(calcSumAccuracyEps(x, eps), eps);
        printResultEps(calcSumAccuracyEps(x, eps / 10), eps / 10);
    }

    private static double readValue(char name) {
        Scanner scan = new Scanner(System.in);
        System.out.printf("Enter the value %s : ", name);
        return scan.nextDouble();
    }

    private static double checkValue(double eps) {
        while (eps <= 0) {
            System.out.println("Error, the eps value must be greater than zero!");
            eps = readValue('e');
        }
        return eps;
    }

    private static int readNumberOfElements(char name) {
        Scanner scan = new Scanner(System.in);
        System.out.printf("Enter the value of %s : ", name);
        return scan.nextInt();
    }

    private static double calcSumOfSequence(double x, int n) {
        double element = 1;
        double sum = 1;
        for (int i = 1; i <= n; i++) {
            element = element * (x / i);
            sum = sum + element;
        }
        return sum;
    }

    private static Result calcSumAccuracyEps(double x, double eps) {
        double element = 1;
        double sum = 1;
        int iteration = 1;
        while (Math.abs(element * x / iteration) >= eps) {
            element = element * (x / iteration);
            sum = sum + element;
            iteration++;
        }
        return new Result(sum, iteration);
    }

    private static void printResult(double result) {
        System.out.printf("Sum of sequence = %.2f  \n", result);
    }

    private static void printResultEps(Result sumMembersMoreEps, double eps) {
        System.out.printf("Accuracy eps = %.2f\n", eps);
        System.out.printf("Sum with accuracy eps: %.4f\n ", sumMembersMoreEps.getSum());
        System.out.printf("The step at which the required accuracy is achieved: %s\n",
                sumMembersMoreEps.getIteration());
    }
}
