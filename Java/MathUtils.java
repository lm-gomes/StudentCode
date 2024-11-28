public class MathUtils{
	public static int sumCounter = 0;
	public static int multiplyCounter = 0;
	
	public static int sum(int a, int b){
		sumCounter++;
		return a + b;
		
	}

	public static int multiply(int a, int b){
		multiplyCounter++;
		return a * b;
	}	
	
	public void printSumCounter(){
		System.out.printf("Sum Counter: %d\n", sumCounter);
	}

	public void printMultiplyCounter(){
		System.out.printf("Multiply Counter: %d\n", multiplyCounter);
	}


}
