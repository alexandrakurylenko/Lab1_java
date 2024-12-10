import acm.program.ConsoleProgram;

public class Lab1Task7 extends ConsoleProgram {
    /**
     * Запрограмувати обчислення ex при x [0;1) із точністю ep
     */
        // Let`s announce variables
        double x, ep;
        public void run(){
            while (true) {
                setSize();
                enterV();
                answer();
            }
        }
        // Method that sets the size of the window
        private void setSize() {
            setSize(500, 600);
            setFont("Times New Roman-30");
        }

        //User enters numbers
        private void enterV() {
            println("Введіть х та Eps");
            x = readDouble("x = ");
            while (x < 0 || x >= 1) {
                println("х належить проміжку [0,1)!!");
                x = readDouble("x = ");
            }
            ep = readDouble("ep = ");
        }

        // Prints the result three ways
        private void answer() {
            println("");
            println("Рекурентні = " + lastRecurrent());
            println("Рекурсією = " + lastRecursive());
            println("Математично обраховані = " + Math.pow(Math.E, x));
        }

        // A recurrent way to evaluate the sum
        private double recurrentWay(int n) {
            double sum = 1;
            for (int i = 1; i <= n; i++) {
                sum += Math.pow(x, i) / recurrentFa(i);
            }
            return sum;
        }
        //Recurrent way to evaluate factorial
        private int recurrentFa(int n) {
            int res = 1;
            for (int i = 1; i <= n; i++) {
                res *= i;
            }
            return res;
        }

        // A recursive way to evaluate the sum
        private double recursiveWay(int n) {
            if (n == 0) {
                return 1;
            }
            return recursiveWay(n - 1) + Math.pow(x, n) / recursiveFa(n);
        }
        // A recursive way to evaluate the factorial
        private int recursiveFa(int i) {
            if (i <= 0) {
                return 1;
            }
            return i * recursiveFa(i - 1);
        }


        // Recursive way to find answer considering epsilon
        private double lastRecursive() {
            int m = 1;
            double finish;
            while(true) {
                finish = recursiveWay(m) - recursiveWay(m - 1);
                if (finish <= ep) {
                    return recursiveWay(m);
                }
                m++;
            }
        }

        // Recurrent way to find answer considering epsilon
        private double lastRecurrent() {
            int m = 1;
            double finish2;
            while(true) {
                finish2 = recurrentWay(m) - recurrentWay(m -1);
                if (finish2 <= ep) {
                    return recurrentWay(m);
                }
                m++;
            }
        }
}
