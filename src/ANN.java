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
        DataSet dataSet = DataSet.createFromFile(inputFileName, 3, 3,",", false);
        System.out.println("Input Size: "+dataSet.getInputSize());
        System.out.println("Output Size: "+dataSet.getOutputSize());
        /*
        DataSet trainingSet = new DataSet(1, 1);
        trainingSet.addRow(new double[]{0}, new double[]{0});
        trainingSet.addRow(new double[]{0.1}, new double[]{0});
        trainingSet.addRow(new double[]{0.2}, new double[]{0});
        trainingSet.addRow(new double[]{0.3}, new double[]{0});
        trainingSet.addRow(new double[]{0.4}, new double[]{0});
        trainingSet.addRow(new double[]{0.49}, new double[]{0});
        trainingSet.addRow(new double[]{0.4}, new double[]{0});
        trainingSet.addRow(new double[]{0.4}, new double[]{0});
        trainingSet.addRow(new double[]{0.5}, new double[]{1});
        trainingSet.addRow(new double[]{0.6}, new double[]{1});
        trainingSet.addRow(new double[]{0.7}, new double[]{1});
        trainingSet.addRow(new double[]{0.8}, new double[]{1});
        trainingSet.addRow(new double[]{0.9}, new double[]{1});
        trainingSet.addRow(new double[]{1}, new double[]{1});
        */
        BackPropagation backPropagation = new BackPropagation();
        backPropagation.setMaxIterations(5000000);
        //backPropagation.setMaxError(0.1);
        Brain.nn.learn(dataSet, backPropagation);
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
		
		Brain.nn = new MultiLayerPerceptron(TransferFunctionType.SIGMOID,3,3,3,3);
		Sere s = new Sere();
		s.sere(Brain.nn);
	}
}

