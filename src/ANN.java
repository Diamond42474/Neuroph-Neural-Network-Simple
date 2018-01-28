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
	
	public static void learn() {
		Sere s = new Sere();
		s.desere();
		NeuralNetwork nn = s.desere();
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
            

        BackPropagation backPropagation = new BackPropagation();
        backPropagation.setMaxError(0.001);
       nn.learn(trainingSet, backPropagation);
       s.sere(nn);
           
        }
	public void run(double input) {
		
		Sere s = new Sere();
		s.desere();
		NeuralNetwork nn = s.desere();
		
		nn.setInput(input);
        nn.calculate();
        double output = nn.getOutput()[0];
        System.out.println(output);
        if(output>0.5) {
        	System.out.println(1);
        }
        if(output<0.5) {
        	System.out.println(0);
        }
	}
	public void make() {
		NeuralNetwork e = new MultiLayerPerceptron(TransferFunctionType.SIGMOID,1, 20,20, 1);
		Sere s = new Sere();
		s.sere(e);
	}
}

