import java.util.Random;

public class ExA2{
	public static void main(String[] args){
		Random random = new Random();
		int numbers[] = new int[10];
		int even = 0;
			
		//Filling array with integers	
		for(int i = 0; i < 10; i++){
			numbers[i] = random.nextInt(99);
			System.out.printf("%d ", numbers[i]);
		}
		
		//Finding even numbers
		for(int i = 0; i < 10; i++){
			if(numbers[i] % 2 == 0){
				even++;
			}	
		}
		
		System.out.printf("\nIt was found %d even numbers!", even);
	}
}
