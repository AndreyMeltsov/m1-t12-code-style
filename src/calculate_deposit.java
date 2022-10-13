import java.util.Scanner;

public class calculate_deposit { // имя класса не соответствует CamelUpperCase, должно быть существительным.
    double calculateComplexPercent(double amount, double yearRate, int depositPeriod) { 
        double pay = amount * Math.pow((1 + yearRate / 12), 12 * depositPeriod); //
        return getRound(pay, 2);
    }

    double calculateSimplePersent(double amount, double yearRate, int depositPeriod) {
        return getRound(amount + amount * yearRate * depositPeriod, 2);
    }
// достаточно одной пустой строки между методами

    double getRound(double value, int places) { //перменная places указывает на точность округления, я бы назвал ее precision
        double scale = Math.pow(10, places);
        return Math.round(value * scale) / scale;
    }
// достаточно одной пустой строки между методами

    void getMenu() { // в данном методе происходит не только вызов меню, но выполнение всей логики программы. Имя calculate подошло бы больше.
        int period;
        int action;
        
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите сумму вклада в рублях:");
        // здесь пустая строка не нужна
        int amount = scanner.nextInt(); // amount - не конкретное на мой взгляд имя переменной. Лучше назвать deposit или depositSum
        
        System.out.println("Введите срок вклада в годах:");
        period = scanner.nextInt();
        System.out.println("Выберите тип вклада, 1 - вклад с обычным процентом, 2 - вклад с капитализацией:");
        action = scanner.nextInt();
        // зачем здесь пробел? Пробел ставится для отделения методов и после объявления переменной.
        double out = 0; // out - неинформативное название переменной. Лучше finalDepositSum.
        
        if (action == 1) out = calculateSimplePersent(amount, 0.06, period); // тело условия, даже если оно состоит из одной строки, должно быть в {}. После { должен быть перенос на другую строку.
        else if (action == 2) {
            out = calculateComplexPercent(amount, 0.06, period);
        }
        System.out.println("Результат вклада: " + amount + " за " + period + " лет превратятся в " + out);
    }

    public static void main(String[] args) {
        new calculate_deposit().getMenu();
    }
// здесь пустые строки не нужны.

}
