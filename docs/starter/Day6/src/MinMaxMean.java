import acm.program.ConsoleProgram;
/*
 * Exercise for simple array operations
 * The aim is to implement a program that reads a number of integers from the user
 * and then print max, min and mean of all values entered by the user
 */
public class MinMaxMean extends ConsoleProgram{
	public void run() {
		int numValues=readInt("Number of values to be entered: ");
		/*Creating the array*/
		int[] values=new int[numValues];
		for(int i=0;i<values.length;i++) {
			values[i]=readInt("Specify input for index "+i+" :");
		}
		println("Max: "+findMax(values));
		println("Min: "+findMin(values));
		println("Mean: "+findMean(values));
	}
	/*Implement the methods below*/
	
	private int findMax(int[] inputArray) {
		int max=0;
		/*Implement the method for finding the maximum of all values in the array*/
		return max;
	}
	private int findMin(int[] inputArray) {
		int min=0;
		/*Implement the method for finding the minimum of all values in the array*/
		return min;
	}
	private int findMean(int[] inputArray) {
		int mean=0;
		/*Implement the method for finding the mean of all values in the array*/
		return mean;
	}
	

}
