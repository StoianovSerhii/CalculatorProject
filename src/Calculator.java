import java.util.Scanner;

public class Calculator {
    static Scanner scanner = new Scanner(System.in);

    // Вывод данный в консоль
    public static void main(String[] args) {
        double num1 = getDouble();
        char operation1 = getOperation();
        double num2 = getDouble();
        char operation2 = getOperation();
        double num3 = getDouble();
        double result = calc(num1,operation1,num2,operation2,num3);
        System.out.println("Результат операции: "+result);
    }

    // Считывание чисел
    public static double getDouble(){
        System.out.println("Введите число:");
        double num;
        if(scanner.hasNextDouble()){
            num = scanner.nextDouble();
        } else {
            System.out.println("Вы допустили ошибку при вводе числа. Попробуйте еще раз.");
            scanner.next();
            num = getDouble();
        }
        return num;
    }

    // Считывание знаков операций
    public static char getOperation(){
        System.out.println("Введите операцию:");
        char operation;
        if(scanner.hasNext()){
            operation = scanner.next().charAt(0);
        } else {
            System.out.println("Вы допустили ошибку при вводе операции. Попробуйте еще раз.");
            scanner.next();
            operation = getOperation();
        }
        return operation;
    }

    // Калькулирование
    public static double calc(double num1, char operation1, double num2, char operation2, double num3){
        double result;
        double resultOperation1 = 0;
        switch (operation1){
            case '+':
                resultOperation1 = num1 + num2;
                break;
            case '-':
                resultOperation1 = num1-num2;
                break;
            case '*':
                resultOperation1 = num1*num2;
                break;
            case '/':
                resultOperation1 = num1/num2;
                if (num2 == 0 ) {
                    System.out.println("Учи матчасть: на ноль делить нельзя!");
                }
                break;
            default:
                System.out.println("Операция не распознана. Повторите ввод.");
                return resultOperation1;
        }
        switch (operation2){
            case '+':
                result = resultOperation1+num3;
                break;
            case '-':
                result = resultOperation1-num3;
                break;
            case '*':
                result = resultOperation1*num3;
                if (resultOperation1 == num1 + num2) {
                    result = num2*num3+num1;
                }
                else if (resultOperation1 == num1 - num2) {
                    result = num1-num2*num3;
                }
                break;
            case '/':
                result = resultOperation1/num3;
                if (num3 == 0 ) {
                    System.out.println("Учи матчасть: на ноль делить нельзя!");
                }
                else if (resultOperation1 == num1 + num2) {
                    result = num2/num3+num1;
                }
                else if (resultOperation1 == num1 - num2) {
                    result = num1-num2/num3;
                }
                break;
            default:
                System.out.println("Операция не распознана. Повторите ввод.");
                result = calc(num1, operation1, num2, operation2, num3);//рекурсия
        }
        return result;
    }
}