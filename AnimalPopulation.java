
/**
 * This is a demonstration of the Monte Carlo Method using 
 * animal populations.
 * 
 * @Ruthie Dignan
 * @11/26/2020
 */

import java.util.Scanner;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
public class AnimalPopulation 
{
    public static void main(String [] args) throws IOException
    {
        Scanner input = new Scanner(System.in);
        
        //opening a file
        PrintWriter outFile = new PrintWriter(new File("animalPopulation.txt"));
        
        //introduction
        System.out.println("Welcome to the Fox Squirrel Simulator");
        System.out.println("");
        
        int trial = 0;
        double sum = 0;
        System.out.println("How many trials should be simulated?");
        trial = input.nextInt();
        
        //collecting user input
        while (trial <= 1000)
        {
            System.out.println("Please try again. Enter a number greater than 1000"); 
            System.out.println("How many trials should be simulated?");
            trial = input.nextInt();
        }
        
        
        //assigning animals their numbers
        int animal = 8;
        for(int counter = 0; counter < trial; counter++)
        {
            int randAnimal = (int)(Math.random() * 9) +1;
            int count = 1;
            while (randAnimal != animal)
            {
                randAnimal = (int)(Math.random() * 9) +1;
                count++;
            }
            outFile.println(count);
        }
        outFile.close();
        
        
        //processing the file
        System.out.println("");
        System.out.println("simulating trials now... one moment please...");
        File fileName = new File("animalPopulation.txt");
        Scanner inFile = new Scanner(fileName);
        int token = 0;
        String tokenString;
        
        
        //calculations
        while(inFile.hasNextLine())
        {
            tokenString = inFile.nextLine();
            token = Integer.parseInt(tokenString);
            sum = sum + token;
        }
        
        double average = sum/trial;
        
        System.out.println("");
        System.out.println("The results!");
        System.out.println("The average number of squirrels observed until");
        System.out.println("spotting a Fox Squirrel at the city park is: " + average);
        
        inFile.close();
        
        
        
        
        
        
        
    }
}
