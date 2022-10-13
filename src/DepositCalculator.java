import java.util.Scanner;

public class DepositCalculator {
    double calculateComplexPercent(double depositSum, double yearRate, int depositPeriod ) {
        double finalDepositSum = depositSum * Math.pow((1 + yearRate / 12), 12 * depositPeriod);
        return round(finalDepositSum, 2);
    }

    double calculateSimplePercent(double depositSum, double yearRate, int depositPeriod) {
        return round(depositSum + depositSum * yearRate * depositPeriod, 2);
    }
//возможно стоило бы назвать getRound или как-то похоже, в остальном все отлично!
    double round(double value, int precision) {
        double scale = Math.pow(10, precision);
        return Math.round(value * scale) / scale;
    }

    void calculateDeposit() {
        int depositPeriod;
        int action;
        double finalDepositSum = 0;

        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите сумму вклада в рублях:");
        int depositSum = scanner.nextInt();
        System.out.println("Введите срок вклада в годах:");
        depositPeriod = scanner.nextInt( );
        System.out.println("Выберите тип вклада, 1 - вклад с обычным процентом, 2 - вклад с капитализацией:");
        action = scanner.nextInt();
        if (action == 1) {
            finalDepositSum = calculateSimplePercent(depositSum, 0.06, depositPeriod);
        } else if (action == 2) {
            finalDepositSum = calculateComplexPercent(depositSum, 0.06, depositPeriod);
        }
        System.out.println("Результат вклада: " + depositSum + " за " + depositPeriod + " лет превратятся в "
                + finalDepositSum);
    }

    public static void main(String[] args) {
        new DepositCalculator().calculateDeposit();
    }
}
