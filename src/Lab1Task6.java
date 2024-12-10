import acm.program.ConsoleProgram;

public class Lab1Task6 extends ConsoleProgram {
    // define variables
    int n, k;
    int whatAction;
    public void run() {
        startConditions();
        println("Ця програма реалізує вказаний алгоритм і наочно ілюструє його виконання ");
        whatAction = readInt("Щоб почати гру введіть будь-яке число. Щоб закінчити гру введіть 0. ");
        while (whatAction != 0) {
            setNum();
            if ( n  > 0) {
                algorithm();
            }
            else {
                println("Неправильне число");
            }
            k=0;
            whatAction = readInt("Щоб продовжити гру введіть будь-яке число. Щоб закінчити гру введіть 0. ");

        }

    }

    // set numbers
    private void setNum() {
        n = readInt("Введіть число(n > 0):");
    }

    // general algorithm, nothing hard
    private void algorithm() {
        while (n != 1) {
            if (n % 2 ==0) {
                n = n/2;
                println(n);
            } else {
                n = (n * 3) + 1;
                println(n);
            }
            k++;
        }
        println("Кількість кроків: " + k);
    }
    private void startConditions() {
        setSize(900, 700);
        setFont("Times New Roman-30");
    }
}
