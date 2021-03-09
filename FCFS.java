import java.util.*;

/**
 * FCFS is used for first come and serve algorithm of Operating System(OS).
 * In this we have to calculate the maximum waiting time of the processes,
 * and their completion time, turn around time(tat), waiting time, average waiting time
 * 
 * @author yash.porwal_metacube
 *
 */
public class FCFS {
	static Scanner sc = new Scanner(System.in);
	static int maxWaitingTime = 0;// this is for maximum waiting time
	
	static int noOfProcess;//this is for total number of process in integer
	/**
	 * constructor for taking input from user regarding total number of processes.
	 * Then calculate completion time, turn around time(tat), waiting time(wt)
	 * From their burst time and arrival time.
	 */
	FCFS(){
		System.out.print("Enter the no. of Process: ");
		noOfProcess = sc.nextInt();
		processArr = new int[noOfProcess][2]; 
		completionTime = new int[noOfProcess];
		tat = new int[noOfProcess];
		wt = new int[noOfProcess];
	}
	
	/**
	 * This is 2-dimensional array.
	 * In this array, processArr[][0] = Arrival TIme of the Process.
	 * And porcessArr[][1] = Burst Time of the Process.
	 * processArr[this is used to represent the total no. of processes][0/1]
	 */
	static int[][] processArr;
	static int [] completionTime ;
	static int [] tat ;
	static int [] wt;
	static int averageWaitingTime;

	/**
	 * This is used to calculate waiting time(wt), completion time, turn around time(tat),
	 * Then maximum waiting time and average waiting time
	 */
	public static void FCFSTime() {
		int WaitingTime = 0;
		for (int i = 0; i < noOfProcess; i++) {
			if (i == 0) {
				/*
				 * completion time = arrival time + burst time
				 */
				completionTime[i] = processArr[i][0] + processArr[i][1];
			} else if (processArr[i][0] > completionTime[i - 1]) {
				completionTime[i] = processArr[i][0] + processArr[i][1];
			} else {
				completionTime[i] = completionTime[i - 1] + processArr[i][1];
			}
			/*
			 * turn around time(tat) = completion time - arrival time
			 */
			tat[i] = completionTime[i] - processArr[i][0];
			
			/*
			 * waiting time = tat - burst time
			 */
			wt[i] = tat[i] - processArr[i][1];
			WaitingTime += wt[i];
			
			if(maxWaitingTime < wt[i]) {
                maxWaitingTime = wt[i];
            }
		}
		averageWaitingTime = WaitingTime/noOfProcess;
	}
	
	/**
	 * These are used for taking inputs of FCFS(First Come First Serve)
	 * In this we take inputs of arrival time & burst time of the process
	 */
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

