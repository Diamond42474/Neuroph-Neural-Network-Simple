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
	public static void main(String[] args) {
		NeuralNetwork neuralNetwork = new MultiLayerPerceptron(TransferFunctionType.SIGMOID,1, 50, 1);
        DataSet trainingSet = new DataSet(1, 1);
        
        trainingSet.addRow(new double[]{0}, new double[]{0});
        trainingSet.addRow(new double[]{0.1}, new double[]{0});
        trainingSet.addRow(new double[]{0.2}, new double[]{0});
        trainingSet.addRow(new double[]{0.3}, new double[]{0});
        trainingSet.addRow(new double[]{0.4}, new double[]{0});
        trainingSet.addRow(new double[]{0.5}, new double[]{1});
        trainingSet.addRow(new double[]{0.6}, new double[]{1});
        trainingSet.addRow(new double[]{0.7}, new double[]{1});
        trainingSet.addRow(new double[]{0.8}, new double[]{1});
        trainingSet.addRow(new double[]{0.9}, new double[]{1});
        trainingSet.addRow(new double[]{1}, new double[]{1});
            

        BackPropagation backPropagation = new BackPropagation();
        //backPropagation.setMaxIterations(1000000000);
        backPropagation.setMaxError(0.01);
        neuralNetwork.learn(trainingSet, backPropagation);
        
            neuralNetwork.setInput(0.726);
            neuralNetwork.calculate();
            double output = neuralNetwork.getOutput()[0];
            System.out.println(output);
            if(output>0.5) {
            	System.out.println(1);
            }
            if(output<0.5) {
            	System.out.println(0);
            }

           
        }
}

