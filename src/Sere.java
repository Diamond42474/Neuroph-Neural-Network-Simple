import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import org.neuroph.core.NeuralNetwork;
import org.neuroph.nnet.MultiLayerPerceptron;
import org.neuroph.util.TransferFunctionType;

public class Sere {
	private  String directory="";
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
	public NeuralNetwork desere() {
		NeuralNetwork e = new MultiLayerPerceptron(TransferFunctionType.SIGMOID,1, 20,20, 1);
		 try {
		       FileInputStream fileIn = new FileInputStream(directory);
		       ObjectInputStream in = new ObjectInputStream(fileIn);
		       e = (NeuralNetwork) in.readObject();
		       System.out.println(e.toString());
		       in.close();
		       fileIn.close();
		       return e;
		    }catch(IOException ie) {
		       ie.printStackTrace();
		       
		    }catch(ClassNotFoundException c) {
		       System.out.println("Employee class not found");
		       c.printStackTrace();
		       
		    }
		return e;
	}

}
