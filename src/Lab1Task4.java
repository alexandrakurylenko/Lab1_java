import acm.program.ConsoleProgram;

public class Lab1Task4 extends ConsoleProgram {
    public void run(){
        startConditions();
        println("Ця програма бере два введені користувачем числа і обраховує корень квадратний з суми їх квадратів ");
        int a = readInt("Введіть перше число: ");
        while (a < 1) {
            println("Неправильне число");
            a = readInt("Введіть правильне число: ");}
        int b = readInt("Введіть друге число: ");
            while (b < 1) {
                println("Неправильне число");
                a = readInt("Введіть правильне число: ");
            }
        double c= Math.sqrt(a*a+b*b);
        println("Відповідь: "+ c );
        }
    private void startConditions() {
        setSize(900, 700);
        setFont("Times New Roman-30");
    }
}
