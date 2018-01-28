
public class Tester {

	public static void main(String[] args) {
		NeurophXOR n = new NeurophXOR();
		
		n.assembleNeuralNetwork();
		n.trainNeuralNetwork();
		for(double x : n.out)
		{
			System.out.println(x);
		}
		
		

	}

}
