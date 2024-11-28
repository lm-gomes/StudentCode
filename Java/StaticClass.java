public class StaticClass{
	public static void main(String[] args){
		MathUtils math = new MathUtils();
		int x = 10;
		int y = 20;
		MathUtils.sum(x, y);
		MathUtils.multiply(x, y);
		
		math.printSumCounter();
		math.printMultiplyCounter();
	}
}
