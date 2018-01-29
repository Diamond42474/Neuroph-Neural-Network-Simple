import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import org.neuroph.core.NeuralNetwork;
import org.neuroph.nnet.MultiLayerPerceptron;
import org.neuroph.util.TransferFunctionType;

public class Sere {
	private  String directory="/Users/logan42474/Desktop/ANN.txt";
	public void sere(NeuralNetwork nn) {
		try {
	        
			FileOutputStream fileOut =
	         new FileOutputStream(directory);
	         ObjectOutputStream out = new ObjectOutputStream(fileOut);
	         out.writeObject(nn);
	         out.close();
	         fileOut.close();
	      }catch(IOException i) {
	         i.printStackTrace();
	      }
	}
	public void desere() {
		 try {
		       FileInputStream fileIn = new FileInputStream(directory);
		       ObjectInputStream in = new ObjectInputStream(fileIn);
		       Brain.nn = (NeuralNetwork) in.readObject();
		       
		       in.close();
		       fileIn.close();
		    }catch(IOException ie) {
		       ie.printStackTrace();
		       
		    }catch(ClassNotFoundException c) {
		       System.out.println("Employee class not found");
		       c.printStackTrace();
		       
		    }
	}
	
}
