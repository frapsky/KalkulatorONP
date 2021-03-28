package js.company;
import java.util.Scanner;
import java.util.Stack;



public class Main {

    static Stack stack = new Stack();


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String wynik = scanner.nextLine();

        Stack<Double> values = new Stack<>(); //stos

        String[] tokens = wynik.split(" +");
        double answer = 0.0;

        for (String token : tokens)//for each loop, dla kazdego tokena w tablicy tokenow...
        {
            if(!isOperator(token))//kiedy zmienna -> dodaj na stos
            {
                values.add(Double.parseDouble(token));
                //System.out.println(token);
            }
            else// sciagnij  ze stosu by wykonac operacje
            {
                double a = values.pop();
                double b = values.pop();
                switch(token)
                {
                    case "+":
                        answer = a + b;
                        break;
                    case "-":
                        answer = b - a;
                        break;
                    case "*":
                        answer = a * b;
                        break;
                    case "/":
                        answer = a / b;
                        break;
                    case "^":
                        answer = Math.pow(a,b);
                        break;
                    case "|": //sqrt a^b
                        answer = Math.pow(a,1/b);
                        break;

                }
                values.add(answer);// dodaj na stos wynik
                //System.out.println(answer);
            }
        }
        while(true){
            if(values.empty())
                break;
            else
                System.out.println(values.pop()); //tutaj taka proba wypisania na koncu
        }

    }

    private static boolean isOperator(String s)
    {
        return s.equals("+") || s.equals("-") || s.equals("*") || s.equals("/") || s.equals("^") || s.equals("|");
    }
}