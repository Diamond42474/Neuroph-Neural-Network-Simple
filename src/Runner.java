
public class Runner {

	
	public static void main(String[] args) {
		
	ANN n = new ANN();
	Error_Display.main(null);
	n.make();
	int i = 0;
	
	while(i<1000) {
	n.learn();
	i++;
	}
	
	double[] input = {500,500,500};
	n.run(input);

	}

}
