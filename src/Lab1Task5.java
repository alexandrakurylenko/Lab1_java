import acm.program.ConsoleProgram;

public class Lab1Task5 extends ConsoleProgram {

    private static final int stopNum =   0;
    int a,b,maxNum, minNum, whatAction;

    public void run() {
        startConditions();
        println("Ця гра відшукує максимальне та мінімальне числа");
                whatAction = readInt("Введіть будь-яке число щоб розпочати гру. Щоб закінчити гру введіть 0.  ");
        while (whatAction != 0) {
            findMinMax();
            whatAction = readInt("Введіть будь-яке число щоб розпочати гру. Щоб закінчити гру введіть 0.  ");
        }
        System.exit(0);

    }

    // checking the couple of conditions
    private void findMinMax() {
        println("Введіть числа:");
        a = readInt("-->");
        if (a != stopNum) {
            enterNumbers();
            if (b == stopNum) {
                println("Максимальне та мінімальне числа рівні:" + maxNum);
            } else {
                searchingAlgorithm();
            }

        } else {
            println("any numbers entered");
        }
    }
    // set numbers
    private void enterNumbers() {
        b = readInt("-->");
        if (a > b) {
            maxNum = a;
            minNum = b;
        }
        else {
            maxNum = b;
            minNum = a;
        }
    }

    // main searching algorithm
    private void searchingAlgorithm() {
        while (a != stopNum && b != stopNum) {
            if (maxNum > b && minNum > b) {
                minNum = b;
            } else if (b > maxNum) {
                maxNum = b;
            }
            b = readInt("-->");
        }

        println("Максимальне число: " + maxNum);
        println("Мінімальне число: " + minNum);
    }
    private void startConditions() {
        setSize(900, 700);
        setFont("Times New Roman-30");
    }
}
