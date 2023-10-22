import java.util.InputMismatchException; 
import java.io.FileReader;  
import java.io.IOException;  
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.io.File;
import java.util.Scanner;
public class GradientProject  
{  

public static double MSE(double y, double p){ //mean squared error getting y and predicted y   
    double cost = ((y - p)*(y -p)) /y;
    return cost;
}


public static void main(String[] args){

    System.out.println("Enter a value for time: ");
    System.out.println("Enter a vlaue for age: ");
    System.out.println("Enter a value for weather: ");
    System.out.println("\n");


    double[] x1 = {20.0,20.0,8.0,8.0,17.0,17.0,17.0,17.0,15.0,15.0,14.0,14.0,1.0,1.0,11.0,11.0,11.0,11.0,
                    11.0,11.0,13.0,13.0,19.0,19.0,19.0};
    double[] x2 = {19,20,46,15,28,21,21,33,61,56,34,34,22,28,31,68,30,8,45,17,41,33,82,61,39};
    double[] x3 = {1,1,5,5,1,1,1,1,1,1,3,3,1,1,1,1,1,1,1,1,3,3,3,3,3};
 
    double[] y1 = {1.0,2.0,1.0,2.0,1.0,1.0,2.0,2.0,1.0,2.0,1.0,2.0,2.0,
                    2.0,2.0,2.0,2.0,2.0,2.0,2.0,2.0,2.0,2.0,2.0,2.0};
    
for(int i = 0; i < x1.length; i++){
    double w = 0.1;
    //double m = 0.0; //slope
    double bias = 0.01;
    int n = x1.length;
    double L = 0.0001;
    double cost = 0.0;
    
    double y = y1[i]; //setting the y value to the values in the  y1 array
    double x = (x1[i] * w) + (x2[i] * w) + (x3[i] * w); //setting the x value to the values in the x1 array
    double pred = w * x + bias; //predicting the y value
    double new_cost;
    new_cost = MSE(y,pred); //feed the y and predicted why into the mse method

    for(int j = 0; j < x1.length; j++){ //updating the cost
        if(new_cost <= cost){
        cost = new_cost;
        }
    double new_w; 
    double new_b; 
    double der_w = (-2/n) * (x* (y - pred));//weight derivative
    double der_b = (-2/n) * (y - pred); //weight derivative
    new_w = w - (L * der_w);
    new_b = bias - (L * der_b);
    x = (x1[i] * new_w) + (x2[i] * new_w) + (x3[i] * new_w);

    int size = x1.length;; //split the data 80:20
    int trainingSize = (int)(size * 0.8);
    int testingSize = size - trainingSize;
    double ts [] = new double[testingSize];

    for(int s = 0; s < ts.length; s++){
        Scanner reader = new Scanner(System.in);  // Reading from System.in
    try {
        //System.out.println("Enter a learning rate: ");
        
        if(reader.hasNextDouble()){
            //double lr = reader.nextDouble(); // Scans the next token of the input as an int.
            double a = reader.nextDouble();
            double b = reader.nextDouble();
            double c = reader.nextDouble();
            a = x1[i];
            b = x2[i];
            c = x3[i];
        //once finished
        reader.close();
        //linearRegression(t,a,w);
     } 
        }
        
     catch (InputMismatchException ex) {
        System.out.println("input mismatch: " + ex);
     }
   
    }
    System.out.print(new_cost);
    System.out.print(", updated weight : " + new_w);
    System.out.print(", updated bias : " + new_b);
    System.out.print(", predicted y : " + pred);
    System.out.print(",  actual y : " + y);
    System.out.println("\n");
}
    
}

}
   

}
