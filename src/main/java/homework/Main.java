package homework;

public class Main {

    public static void main(String[] args) {
        int num1 = 5;
        int num2 = 13;
        double num3 = 14.5;

        // Операции над типом int
        int sumResult = num1 + num2; // 18
        int subtractResult = num1 - num2; // -8
        int multiplicationResult = num1 * num2; // 65
        int divisionResult = num2 / num1; // 2

        // Операции над int и double
        double result = num3 * num2 + num3 / num1; // 191.4

        // Логические операции
        if (num1 >= 1 && num2 < 100 || num1 >= 101) {
            System.out.println("Верно!");
        } else if (!(num1 == 5)) {
            System.out.println("Неверно!");
        }

        // Переполнение при арифметической операции
        int intOverflow1 = Integer.MAX_VALUE + 3;
        int intOverflow2 = Integer.MIN_VALUE - 100;

        float floatOverflow1 = Float.MAX_VALUE * 5.0f;
        float floatOverflow2 = -Float.MAX_VALUE * 5.0f;
        float floatUnderflow = Float.MIN_VALUE / 1e20f; // Денормализованное число (стремится к 0)

        double doubleOverflow1 = Double.MAX_VALUE * 3.0;
        double doubleOverflow2 = -Double.MAX_VALUE * 3.0;
        double doubleUnderflow = Double.MIN_VALUE / 1e100; // Денормализованное число (стремится к 0)

    }
}
