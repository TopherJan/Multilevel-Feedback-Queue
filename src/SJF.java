
public class SJF {

	int[] processID;
	int[] arrivalTime;
	int[] burstTime;
	int numOfProcesses;

	public SJF(int[] processID, int[] arrivalTime, int[] burstTime){
		this.processID = processID;
		this.arrivalTime = arrivalTime;
		this.burstTime = burstTime;
		numOfProcesses = processID.length;

		getAllInfo();
	}

	public void getAllInfo(){
		int[] waitingTime = new int[numOfProcesses];
		int[] turnaroundTime = new int[numOfProcesses];
		int[] completionTime = new int[numOfProcesses];
		int[] serviceTime = new int[numOfProcesses];
		int[] flag = new int[numOfProcesses];

		for(int i = 0; i < numOfProcesses; i++){
			flag[i] = 0;
		}

		int st=0, tot=0;

		while(true){
			int c = numOfProcesses, min = 50;
			if (tot == numOfProcesses)
				break;

			for (int i=0; i<numOfProcesses; i++){
				if ((arrivalTime[i] <= st) && (flag[i] == 0) && (burstTime[i]<=min)){
					min=burstTime[i];
					c=i;
				}
			}

			if (c == numOfProcesses)
				st++;
			else{
				completionTime[c] = st+burstTime[c];
				st += burstTime[c];
				turnaroundTime[c] = completionTime[c] - arrivalTime[c];
				waitingTime[c] = turnaroundTime[c] - burstTime[c];
				flag[c] = 1;
				tot++;
			}
		}

		for(int i=0;i<numOfProcesses;i++){
			serviceTime[i] = waitingTime[i] + arrivalTime[i];
		}

		for(int i = 0; i < numOfProcesses; i++){
			for(int j = 0; j < numOfProcesses-(i+1) ; j++){
				if(serviceTime[j] > serviceTime[j+1]){
					sortArray(serviceTime, j);
					sortArray(arrivalTime, j);
					sortArray(burstTime, j);
					sortArray(waitingTime, j);
					sortArray(completionTime, j);
					sortArray(turnaroundTime, j);
					sortArray(processID, j);
				}
			}
		}

		printInfo(completionTime, serviceTime);
	}

	public void printInfo(int[] completionTime, int[] serviceTime){
		System.out.println("\npid  arrival burst");
		for(int i=0;i<numOfProcesses;i++){
			System.out.println(processID[i]+"\t"+arrivalTime[i]+"\t"+burstTime[i]);
		}

		createGantt(completionTime, serviceTime, processID);
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
			if(num[i] > highest){
				highest = num[i];
			}
		}
		return highest;
	}
}
