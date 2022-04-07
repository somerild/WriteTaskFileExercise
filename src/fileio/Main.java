package fileio;

import java.io.*;
import java.util.Scanner;

/**
 * Problem 1. Practice using PrintWriter with a Text file.  Ran through once
 * with PrintWriter and then PrintWriter wrapping BufferedWriter and FileWriter.
 */
public class Main {

    static class Date
    {
        //vars
        int month;
        int day;
        int year;
        //constructor
        Date(int m, int d, int y)
        {
            setDate(m, d, y);
        }
        //methods
        private void setDate(int m, int d, int y)
        {
            month = m;
            day = d;
            year = y;
        }
        public String toString()
        {
            return (month + "/" + day + "/" + year);
        }
    }
    public static void main(String[] args) throws IOException{
        Scanner stringInput = new Scanner(System.in);
        Scanner intInput = new Scanner(System.in);
        String destinationPath = "C:\\Users\\leram\\Java\\WriteTaskFileExercise\\src\\fileio\\taskPrintWriter.txt";
        File fOut = new File( destinationPath );

        String taskNum;
        String taskDescription;
        int m;
        int d;
        int y;
        Date dueDate;

        if ( fOut.exists( ) )
        {
            System.out.println( "File already exists. Will append." );
        }
        else
        {
            System.out.println( "File does not exist, creating.");
        }
        PrintWriter output = new PrintWriter(new BufferedWriter( new FileWriter( fOut, true ) ));
        output.printf( "%-5s  %-30s  %-15s%n", "Task#", "Task Description", "Due Date" );
        output.printf( "%-5s  %-30s  %-15s%n", "-----", "----------------", "--------"  );
        for(int i = 0; i < 3; i++)
        {
            System.out.println("Enter task number: " );
            taskNum = stringInput.nextLine();

            System.out.println("Enter task description: " );
            taskDescription = stringInput.nextLine();

            System.out.println("Enter due date. Month (numerical): " );
            m = intInput.nextInt();

            System.out.println("Day (numerical): " );
            d = intInput.nextInt();

            System.out.println("Year (numerical): " );
            y = intInput.nextInt();

            dueDate = new Date(m, d, y);

            output.printf( "%-5s  %-30s  %-15s%n", taskNum, taskDescription, dueDate );
        }
        output.close();
    }
}
