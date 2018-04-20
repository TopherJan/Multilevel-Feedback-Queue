
public class FCFS {
	int[] processID;
	int[] arrivalTime;
	int[] burstTime;
	int numOfProcesses;

	public FCFS(int[] processID, int[] arrivalTime, int[] burstTime){
//		int[] processID = {1,2,3,4,5};
//		int[] arrivalTime = {20,11,21,13,4};
//		int[] burstTime = {25,22,19,31,17};
		this.processID = processID;
		this.arrivalTime = arrivalTime;
		this.burstTime = burstTime;
		numOfProcesses = processID.length;

		getInfo();
	}

	public void printInfo(int[] completionTime, int[] serviceTime){
		System.out.println("\npid  arrival  burst");
		for(int  i = 0 ; i< numOfProcesses;  i++){
			System.out.println(processID[i] +"\t " +arrivalTime[i] +"\t" +burstTime[i]) ;
		}

		createGantt(completionTime, serviceTime, processID);
	}

	public void getInfo(){
		int[] waitingTime = new int[numOfProcesses];
		int[] turnaroundTime = new int[numOfProcesses];
		int[] completionTime = new int[numOfProcesses];
		int[] serviceTime = new int[numOfProcesses];


		for(int i = 0; i < numOfProcesses; i++){
			for(int j = 0; j < numOfProcesses-(i+1) ; j++){
				if(arrivalTime[j] > arrivalTime[j+1]){
					sortArray(arrivalTime, j);
					sortArray(burstTime, j);
					sortArray(processID, j);
				}
			}
		}

		for(int  i = 0 ; i < numOfProcesses; i++){
			if(i == 0){
				completionTime[i] = arrivalTime[i] + burstTime[i];
			}
			else{
				if( arrivalTime[i] > completionTime[i-1]){
					completionTime[i] = arrivalTime[i] + burstTime[i];
				}
				else
					completionTime[i] = completionTime[i-1] + burstTime[i];
			}
			turnaroundTime[i] = completionTime[i] - arrivalTime[i];
			waitingTime[i] = turnaroundTime[i] - burstTime[i];
			serviceTime[i] = waitingTime[i] + arrivalTime[i];
		}
		printInfo(completionTime, serviceTime);
	}

	public void createGantt(int[] completionTime, int[] serviceTime, int[] processID){
		int ctr =0;
		System.out.println("\nGANTT CHART\n");
		for(int i = 0; i <= getHighest(completionTime); i++){
			if(i == 0){
				System.out.print("|" +i +"|");
			}else if(serviceTime[ctr] <= i){
				if(serviceTime[ctr] == i){
					System.out.print("|" +i +"|");
				}
				if(i == completionTime[ctr]){
					System.out.print(" -P" +processID[ctr]);
					ctr++;
					System.out.print("- |" +i +"|");
				}
			}
		}
		System.out.println();
	}

	public void sortArray(int[] array, int j){
		int temp;
		temp = array[j];
		array[j] = array[j+1];
		array[j+1] = temp;
	}

	public int getHighest(int[] num){
		int highest = num[0];

		for(int i = 1; i < num.length; i++){
			if(num[i] > highest)
				highest = num[i];
		}
		return highest;
	}
}
