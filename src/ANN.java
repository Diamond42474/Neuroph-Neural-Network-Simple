import java.util.ArrayList;
import java.util.Arrays;

import org.neuroph.core.NeuralNetwork;
import org.neuroph.core.data.DataSet;
import org.neuroph.core.data.DataSetRow;
import org.neuroph.core.learning.SupervisedLearning;
import org.neuroph.nnet.MultiLayerPerceptron;
import org.neuroph.nnet.Perceptron;
import org.neuroph.nnet.learning.BackPropagation;
import org.neuroph.util.TransferFunctionType;

public class ANN {
	public static ArrayList<Double> level = new ArrayList<Double>();
	public static double output;
	
	public static void learn() {
		Sere s = new Sere();
		s.desere();
       
        
        String inputFileName = "/Users/logan42474/Desktop/Workbook1.csv";
        DataSet dataSet = DataSet.createFromFile(inputFileName, 3, 3,",", true);
        
        //System.out.println("Input Size: "+dataSet.getInputSize());
        //System.out.println("Output Size: "+dataSet.getOutputSize());
       
        BackPropagation backPropagation = new BackPropagation();
        backPropagation.setMaxIterations(500);
        
        //backPropagation.setMaxError(0.14);
        Brain.nn.learn(dataSet, backPropagation);
        //System.out.println("Error: "+backPropagation.getTotalNetworkError());
        Error_Display.text.setText(Double.toString(backPropagation.getTotalNetworkError()));
       s.sere(Brain.nn);
           
        }
	public void run(double[] input) {
		
		Sere s = new Sere();
		s.desere();
		
		Brain.nn.setInput(input);
		Brain.nn.calculate();
        output = Brain.nn.getOutput()[0];
        System.out.println(output);
        level.add(output);
        if(output>0.5) {
        System.out.println(1);
        }
        if(output<0.5) {
        	System.out.println(0);
        }
        System.out.println("Full Outputs: "+ Arrays.toString(Brain.nn.getOutput()));
	}
	public void make() {
		
		Brain.nn = new MultiLayerPerceptron(TransferFunctionType.SIGMOID,3,10,10,3);
		Sere s = new Sere();
		s.sere(Brain.nn);
	}
}

