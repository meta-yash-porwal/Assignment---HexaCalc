import java.util.*;

public class FCFS {
	static Scanner sc = new Scanner(System.in);
	static int maxWaitingTime = 0;
	
	static int noOfProcess;
	FCFS(){
		System.out.print("Enter the no. of Process: ");
		noOfProcess = sc.nextInt();
		processArr = new int[noOfProcess][2]; 
		completionTime = new int[noOfProcess];
		tat = new int[noOfProcess];
		wt = new int[noOfProcess];
	}
	
	
	static int[][] processArr; //= new int[noOfProcess][2];
	static int [] completionTime ;//= new int[noOfProcess];
	static int [] tat ; //= new int[noOfProcess];
	static int [] wt; //[] = new int[noOfProcess];
	static int averageWaitingTime;

	
	public static void FCFSTime() {
		int WaitingTime = 0;
		for (int i = 0; i < noOfProcess; i++) {
			if (i == 0) {
				completionTime[i] = processArr[i][0] + processArr[i][1];
			} else if (processArr[i][0] > completionTime[i - 1]) {
				completionTime[i] = processArr[i][0] + processArr[i][1];
			} else {
				completionTime[i] = completionTime[i - 1] + processArr[i][1];
			}
			tat[i] = completionTime[i] - processArr[i][0];
			
			wt[i] = tat[i] - processArr[i][1];
			WaitingTime += wt[i];
			
			if(maxWaitingTime < wt[i]) {
                maxWaitingTime = wt[i];
            }
		}
		averageWaitingTime = WaitingTime/noOfProcess;
	}
	
	public static void Inputs() {
		for(int i=0;i<noOfProcess;i++){
			System.out.println("Enter Arrival Time & Burst Time of Processes " + (i+1));
			int at = sc.nextInt();
			int bt = sc.nextInt();
			processArr[i][0] = at;
			processArr[i][1] = bt;
		}
	}
	
	
	public static void main(String[] args){
		new FCFS();
		Inputs();
		FCFSTime();
		System.out.println("\n\nArrivalTime\tBurstTime\tCompletionTime\tTurnAroundTime\tWaitingTime");
		for(int i=0; i<noOfProcess; i++) {
			System.out.print(processArr[i][0] + "\t\t" + processArr[i][1] + "\t\t" + completionTime[i] 
					+ "\t\t" + tat[i] + "\t\t" + wt[i] + "\n");
		}
		System.out.println("\n\nAverage Waiting Time = " + averageWaitingTime);
		System.out.println("Maximum Waiting Time = " + maxWaitingTime);
		
		
	}
}

