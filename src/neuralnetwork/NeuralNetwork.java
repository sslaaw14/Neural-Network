/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package neuralnetwork;

import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author ASUS
 */
public class NeuralNetwork {

    static int[][] input = {{1,0,0},{1,0,1},{1,1,0},{1,1,1}};
    static int[] targetAnd = {0,0,0,1};
    static int[] targetOr = {0,1,1,1};
    static double input1,input2;
    static double threshold = 0;
    static double bias =1;
    static double[] weightTest = {-3,0.5,-0.4};
    static double epoch = 0;
    static double error = 0;
    static double sum;
    static double output;
    static double miu=1;
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        System.out.println("1.And");
        System.out.println("2. Or");
        System.out.println("Pilihan anda\t:");
        Scanner inputan = new Scanner(System.in);
        int pilihan = inputan.nextInt();
        
        switch(pilihan){
            case 1 : {
                        System.out.println("Weight Awal\t:");
                        print(weightTest);
                        
                        while(epoch < 10){
                            System.out.println("\nEpoch\t:"+epoch);
                            hitung(input, targetAnd);
                            epoch++;
                        }
                        
                        System.out.println("\nWeightAkhir\t:");
                        print(weightTest);
            }break;
            case 2 : {
                        System.out.println("Weight Awal\t:");
                        print(weightTest);
                        
                        while(epoch < 10){
                            System.out.println("\nEpoch\t:"+epoch);
                            hitung(input, targetOr);
                            epoch++;
                        }
                        
                        System.out.println("\nWeightAkhir\t:");
                        print(weightTest);
            }
        }
    }
    
    public static double[] getWeight(int[] input){
        for(int i=0;i<weightTest.length;i++){
            weightTest[i] = weightTest[i] + miu * input[i] * error;
        }
        
        return weightTest;
    } 
    
    public static void print(double[] data){
        for(int i=0;i<data.length;i++){
            System.out.println(data[i]);
        }
    }
    
    public static void hitung(int[][] data, int[] target){
        System.out.println("\nSum" + "\t\tOutput");
        for(int i=0;i<4;i++){
            sum = (data[i][0] * weightTest[0]) + (data[i][1] * weightTest[1]) + (data[i][2] * weightTest[2]);
            if(sum>=threshold){
                output=1;
            }else if(sum < threshold){
                output=0;
            }
            
            error = target[i] - output;
            
            if(error != 0){
                getWeight(data[i]);
            }
            System.out.println(sum + "\t\t\t" + output);
        }
        System.out.println("Error = " + error);
    }
}
