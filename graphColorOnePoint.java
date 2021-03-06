import java.util.Random;

public class graphColorOnePoint {
	
	public static void main(String[] args) {
		
		int brw = 3; //black red white
		int numNodes = 10; //number of nodes
		int[] row1 = new int[numNodes]; //declares first row with number of nodes
		int[] row2 = new int[numNodes];
		int[] row1Child = new int[numNodes];
		int[] row2Child = new int[numNodes];
		
		row1 = assignColor(row1, brw); //assigns random value to row, "brw" is number of colors
		row2 = assignColor(row2, brw);
		
		rowPrint(row1); //translates and prints row
		System.out.println("Fitness: " + checkSatisfied(row1) + " satisfied, " + checkUnsatisfied(row1) + " unsatisfied.");//check fitness
		
		System.out.println();
		
		rowPrint(row2); //translates and prints row
		System.out.println("Fitness: " + checkSatisfied(row2) + " satisfied, " + checkUnsatisfied(row2) + " unsatisfied.");
		
		
		cloneParent(row1, row1Child); //create two new child arrays that are identical to parents
		cloneParent(row2, row2Child);
		
		onePointCrossover(row1Child, row2Child, numNodes);
		
		System.out.println("");
		
		int crossoverIterations = 0;
		
		while(crossoverIterations<=10) { //performs single cross over 10 times
			int fitness1 = 0;
			int fitness2 = 0;
			int fitness3 = 0;
			int fitness4 = 0;
			
			fitness1 = checkSatisfied(row1);
			fitness2 = checkSatisfied(row2);
			fitness3 = checkSatisfied(row1Child);
			fitness4 = checkSatisfied(row2Child);
			
			if(fitness1 >= fitness2 && fitness1 >= fitness3 && fitness1 >= fitness4) { //checks if fitness of row1 is greater than all
				System.out.println("Parent 1 kept");
				if(fitness2 >= fitness3 && fitness2 >= fitness4){
					mutationOdds(row1, numNodes, brw); //random mutation
					mutationOdds(row2, numNodes, brw);
					
					System.out.println("Parent 2 kept\n");
					
					rowPrint(row1);
					rowPrint(row2);
					
					onePointCrossover(row1, row2, numNodes);
				}
				else if(fitness3 >= fitness2 && fitness3 >= fitness4) {
					mutationOdds(row1, numNodes, brw);
					mutationOdds(row1Child, numNodes, brw);
					
					System.out.println("Child 1 kept\n");

					rowPrint(row1);
					rowPrint(row1Child);					
					
					onePointCrossover(row1, row1Child, numNodes);
				}
				else if(fitness4 >= fitness2 && fitness4 >= fitness3) {
					mutationOdds(row1, numNodes, brw);
					mutationOdds(row2Child, numNodes, brw);
					
					System.out.println("Child 2 kept\n");

					rowPrint(row1);
					rowPrint(row2Child);					
					
					onePointCrossover(row1, row2Child, numNodes);
				}
			}
			else if(fitness2 >= fitness1 && fitness2 >= fitness3 && fitness2 >= fitness4) { //checks if fitness of row2 is greater than all
				System.out.println("Parent 2 kept");
				if(fitness1 >= fitness3 && fitness1 >= fitness4){
					mutationOdds(row2, numNodes, brw);
					mutationOdds(row1, numNodes, brw);
					
					System.out.println("Parent 1 kept\n");
					
					rowPrint(row2);
					rowPrint(row1);					
					
					onePointCrossover(row2, row1, numNodes);
				}
				else if(fitness3 >= fitness1 && fitness3 >= fitness4) {
					mutationOdds(row2, numNodes, brw);
					mutationOdds(row1Child, numNodes, brw);
					
					System.out.println("Child 1 kept\n");
					
					rowPrint(row2);
					rowPrint(row1Child);					
					
					onePointCrossover(row2, row1Child, numNodes);
				}
				else if(fitness4 >= fitness1 && fitness4 >= fitness3) {
					mutationOdds(row2, numNodes, brw);
					mutationOdds(row2Child, numNodes, brw);
					
					System.out.println("Child 2 kept\n");
					
					rowPrint(row2);
					rowPrint(row2Child);					
					
					onePointCrossover(row2, row2Child, numNodes);
				}				
			}
			else if(fitness3 >= fitness1 && fitness3 >= fitness2 && fitness3 >= fitness4) { //checks if fitness of row1Child is greater than all
				System.out.println("Child 1 kept");
				if(fitness1 >= fitness2 && fitness1 >= fitness4){
					mutationOdds(row1Child, numNodes, brw);
					mutationOdds(row1, numNodes, brw);
					
					System.out.println("Parent 1 kept\n");
					
					rowPrint(row1Child);
					rowPrint(row1);					
					
					onePointCrossover(row1Child, row1, numNodes);
				}
				else if(fitness2 >= fitness1 && fitness2 >= fitness4) {
					mutationOdds(row1Child, numNodes, brw);
					mutationOdds(row2, numNodes, brw);
					
					System.out.println("Parent 2 kept\n");
					
					rowPrint(row1Child);
					rowPrint(row2);						
					
					onePointCrossover(row1Child, row2, numNodes);
				}
				else if(fitness4 >= fitness1 && fitness4 >= fitness2) {
					mutationOdds(row1Child, numNodes, brw);
					mutationOdds(row2Child, numNodes, brw);
					
					System.out.println("Child 2 kept\n");
					
					rowPrint(row1Child);
					rowPrint(row2Child);						
					
					onePointCrossover(row1Child, row2Child, numNodes);
				}
			}
			else if(fitness4 >= fitness1 && fitness4 >= fitness2 && fitness4 >= fitness3) {//checks if fitness of row1Child is greater than all
				System.out.println("Child 2 kept");
				if(fitness1 >= fitness2 && fitness1 >= fitness3){
					mutationOdds(row2Child, numNodes, brw);
					mutationOdds(row1, numNodes, brw);
					
					System.out.println("Parent 1 kept\n");
					
					rowPrint(row2Child);
					rowPrint(row1);						
					
					onePointCrossover(row2Child, row1, numNodes);
				}
				else if(fitness2 >= fitness1 && fitness2 >= fitness3) {
					mutationOdds(row2Child, numNodes, brw);
					mutationOdds(row2, numNodes, brw);
					
					System.out.println("Parent 2 kept\n");
					
					rowPrint(row2Child);
					rowPrint(row2);						
					
					onePointCrossover(row2Child, row2, numNodes);
				}
				else if(fitness3 >= fitness1 && fitness3 >= fitness2) {
					mutationOdds(row2Child, numNodes, brw);
					mutationOdds(row1Child, numNodes, brw);
					
					System.out.println("Child 1 kept\n");
					
					rowPrint(row2Child);
					rowPrint(row1Child);	
					
					onePointCrossover(row2Child, row1Child, numNodes);
				}
			}
			
			crossoverIterations++;
			
			System.out.println("");				
			System.out.println("NEW ITERATION");
			System.out.println("");	
			System.out.println("");	
			System.out.println("");	
			System.out.println("");	
			System.out.println("");	
			
		}
		
		
			
	}
		
	
	public static void rowPrint(int []a){
		for(int i = 0; i<a.length; i++)
		{
			if(a[i] == 0)
			{
				System.out.print("[B] ");
			}
			else if(a[i] == 1)
			{
				System.out.print("[R] ");
			}
			else if(a[i] == 2)
			{
				System.out.print("[W] ");
			}
		}
		System.out.println("");
	}
	
	public static int randomNumber(int s) { //returns a random value with s as max
		Random rand = new Random();
		int randomNum = rand.nextInt(s);
		return randomNum;
	}
	
	public static int[] assignColor(int []a, int b) { //assigns color to each node
		for(int i = 0; i<a.length; i++) {
			a[i] = randomNumber(b);
		}
		return a;
	}
	
	public static int checkSatisfied(int []a) {
		int satisfied = 0;
		
		for(int i = 0; i<a.length; i++) {
			if(i < (a.length-1)) {
				if(a[i] != a[i+1])
					satisfied++;
			}
		}
		
		return satisfied;
	}
	
	public static int checkUnsatisfied(int []a) {
		int unsatisfied = 0;
		
		for(int i = 0; i<a.length; i++) {
			if(i < (a.length-1)) {
				if(a[i] == a[i+1])
					unsatisfied++;
			}
		}
		
		return unsatisfied;
	}
	
	public static void mutationOdds(int []a, int b, int c) {
		int odds = 0;
		int newValue = 0;
		
		odds = randomNumber(10);
		
		if(odds <= 1){
			odds = randomNumber(b); //b = numNodes
			newValue = randomNumber(c);//c = num of colors
			
			a[odds] = newValue;
			
			System.out.println("MUTATION OCCURED!");
		}
	}
	
	public static int[] cloneParent(int []a, int []b) {
		//a = parent
		
		for(int i = 0; i<a.length; i++) {
			b[i] = a[i];
		}
		
		return b;
	}
	
	public static void onePointCrossover(int []a, int []b, int c) {
		int exchange = 0;
		int numHolder1 = 0;
		int numHolder2 = 0;
		int exchangePrint = 0;
		exchange = randomNumber(c);
		
		exchangePrint = (exchange + 1);
		
		System.out.println("---------------------------------");
		System.out.println("Crossover point: " + exchangePrint);
		System.out.println("---------------------------------\n");
		
		
		numHolder1 = a[exchange]; //holds value of row a in exchange place in a temporary integer
		numHolder2 = b[exchange];	
		
		a[exchange] = numHolder2;
		b[exchange] = numHolder1;
		
		
		rowPrint(a);
		System.out.println("Fitness: " + checkSatisfied(a) + " satisfied, " + checkUnsatisfied(a) + " unsatisfied.");
		
		System.out.println("");
		
		rowPrint(b);
		System.out.println("Fitness: " + checkSatisfied(b) + " satisfied, " + checkUnsatisfied(b) + " unsatisfied.");
		
	}
}