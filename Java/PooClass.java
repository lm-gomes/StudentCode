import java.util.Scanner;

public class PooClass{
	public double Calculator(double a, double b, int op){
		switch(op){
			//Addition
			case 1:
				return a + b;
				
			//Subtraction
			case 2:
				return a - b;
				
			//Multiplication
			case 3:
				return a * b;
			
			//Division
			case 4:
				return a / b;
			
			default:
				System.out.println("Invalid operation!");
		}
		return 0;
	}

	public static void main(String[] args){
		PooClass obj = new PooClass();
		Scanner scanner = new Scanner(System.in);
		
		System.out.printf("- - - -CALCULATOR- - - -\n[1]Addition\n[2]Subtraction		\n[3]Multiplication\n[4]Division\n>>");
		
		int op = scanner.nextInt();
		double num = scanner.nextDouble();
		double num1 = scanner.nextDouble();
		double result = obj.Calculator(num, num1, op);
		System.out.println("Result: " + result);
		
	}

	

}
