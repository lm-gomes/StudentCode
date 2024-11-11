import java.util.Scanner;

public class ExA1{
	public static void main(String[] args){
		Scanner scanner = new Scanner(System.in);		

		int array[] = new int[5];
		int sum = 0;

		for(int i = 0; i < 5; i++){
			System.out.printf("Digite o %d numero: ", i + 1);
			array[i] = scanner.nextInt();
		}
		
		for(int i = 0; i < 5; i++){
			sum += array[i];			
		}

		System.out.printf("A soma e: %d", sum);		
		
	}
}
