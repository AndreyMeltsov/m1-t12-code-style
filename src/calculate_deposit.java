import java.util.Scanner;

public class calculate_deposit {
    double calculateComplexPercent(double a, double y, int d) {
        double pay = a * Math.pow((1 + y / 12), 12 * d);
        return getRound(pay, 2);
    }

    double calculateSimplePersent(double doubleAmount, double yearRate, int depositPeriod) {
        return getRound(doubleAmount + doubleAmount * yearRate * depositPeriod, 2);
    }

    double getRound(double value, int places) {
        double scale = Math.pow(10, places);
        return Math.round(value * scale) / scale;
    }

    void getMenu() {
        int period;
        int action;
        
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите сумму вклада в рублях:");
        
        int amount = scanner.nextInt();
        
        System.out.println("Введите срок вклада в годах:");
        period = scanner.nextInt();
        System.out.println("Выберите тип вклада, 1 - вклад с обычным процентом, 2 - вклад с капитализацией:");
        action = scanner.nextInt();
        
        double out = 0;
        
        if (action == 1) out = calculateSimplePersent(amount, 0.06, period);
        else if (action == 2) {
            out = calculateComplexPercent(amount, 0.06, period);
        }
        System.out.println("Результат вклада: " + amount + " за " + period + " лет превратятся в " + out);
    }

    public static void main(String[] args) {
        new calculate_deposit().getMenu();
    }


}
