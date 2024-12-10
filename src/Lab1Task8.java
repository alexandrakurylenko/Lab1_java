import acm.program.ConsoleProgram;

public class Lab1Task8 extends ConsoleProgram {
    /**
     Запрограмувати обчислення cos(x) при x [-p /4; p/4] з точністю ep
     */
    //Let`s announce variables
        double x, ep;
        public void run(){
            while (true) {
                setSize();
                enterV();
                resultsR();
            }
        }
        // Method that sets the size of the window
        private void setSize() {
            setSize(500, 600);
            setFont("Times New Roman-30");
        }
        // User enters numbers
        private void enterV() {
            println("Введіть значення х та ер");
            x = readDouble("х = ");
            while (x <= (-Math.PI / 4) || x >= (Math.PI / 4)) {
                println("х має належати проміжку[-pi/4;pi/4]!!!");
                x = readDouble("х = ");
            }
            ep = readDouble("ер = ");
        }
        // A recurrent way to evaluate the sum
        private double reccurentWay(int n) {
            double sum = 1;
            for (int i = 1; i <= n; i++) {
                sum += (Math.pow(-1, i) * Math.pow(x, i*2)) / recurrentFa(i*2);
            }
            return sum;
        }
        // A recurrent way to evaluate the factorial
        private int recurrentFa(int n) {
            int res = 1;
            for (int i = 1; i <= n; i++) {
                res *= i;
            }
            return res;
        }
        // Recurrent way to find answer considering epsilon
        private double recurrentFinal() {
            int m = 1;
            double recTotal;
            while(true) {
                recTotal = reccurentWay(m) - reccurentWay(m -1);
                if (recTotal <= ep) {
                    return reccurentWay(m);
                }
                m++;
            }
        }
        //  Recursive way to find the sum
        private double recursiveWay(int n) {
            if (n == 0) {
                return 1;
            }
            return recursiveWay(n - 1) + (Math.pow(-1, n) * Math.pow(x, n*2)) / recursiveFa(n*2);
        }
        // Recursive way to find answer considering epsilon
        private double recursiveFinal() {
            int m = 1;
            double recursiveTot;
            while(true) {
                recursiveTot = recursiveWay(m) - recursiveWay(m - 1);
                if (recursiveTot <= ep) {
                    return recursiveWay(m);
                }
                m++;
            }
        }

        //  Recursive way to evaluate factorial
        private int recursiveFa(int i) {
            if (i <= 0) {
                return 1;
            }
            return i * recursiveFa(i - 1);
        }
        // Method that prints results
        private void resultsR() {
            println("");
            println("Рекурентні співвідношення= " + recurrentFinal());
            println("Рекурсія = " + recursiveFinal());
            println("Обраховано математично: = " + Math.cos(x));
        }
    }

