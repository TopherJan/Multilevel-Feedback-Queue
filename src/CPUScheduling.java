// import java.util.Scaner;

public class CPUScheduling {
	public static void main(String[] args){
		System.out.println("\nFIRST COME FIRST SERVE");

		int[] FCFSprocessID1 = {1,2,3,4,5,6,7,8,9,10};
		int[] FCFSarrivalTime1 = {50,34,10,49,29,5,7,48,0,24};
		int[] FCFSburstTime1 = {31,38,7,46,22,36,17,18,27,35};

		int[] FCFSprocessID2 = {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15};
		int[] FCFSarrivalTime2 = {38,48,36,4,35,45,6,42,30,9,20,39,28,37,3};
		int[] FCFSburstTime2 = {28,25,44,10,14,37,32,28,15,33,25,46,11,30,16};

		int[] FCFSprocessID3 = {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20};
		int[] FCFSarrivalTime3 = {20,34,6,9,18,22,35,50,21,37,30,10,13,36,38,8,11,2,13,35};
		int[] FCFSburstTime3 = {32,15,27,23,36,11,32,40,32,20,11,49,38,20,8,42,1,7,6,44};

		System.out.println("\nTEST CASE 1");
		new FCFS(FCFSprocessID1, FCFSarrivalTime1, FCFSburstTime1);
		System.out.println("\nTEST CASE 2");
		new FCFS(FCFSprocessID2, FCFSarrivalTime2, FCFSburstTime2);
		System.out.println("\nTEST CASE 3");
		new FCFS(FCFSprocessID3, FCFSarrivalTime3, FCFSburstTime3);

		System.out.println("\nSHORTEST JOB FIRST");

		int[] SJFprocessID1 = {1,2,3,4,5,6,7,8,9,10};
		int[] SJFarrivalTime1 = {30,5,27,13,0,23,1,14,42,6};
		int[] SJFburstTime1 = {35,20,3,31,41,11,49,10,43,45};

		int[] SJFprocessID2 = {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15};
		int[] SJFarrivalTime2 = {36,2,7,9,16,34,26,50,40,8,44,18,19,28,17};
		int[] SJFburstTime2 = {48,38,12,33,47,32,37,29,46,39,25,24,4,21,15};

		int[] SJFprocessID3 = {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20};
		int[] SJFarrivalTime3 = {20,28,30,42,23,41,48,33,4,9,44,17,8,14,29,1,46,47,16,32};
		int[] SJFburstTime3 = {12,25,45,34,24,26,2,18,3,43,39,36,15,5,29,49,40,38,31,19};

		System.out.println("\nTEST CASE 1");
		new SJF(SJFprocessID1, SJFarrivalTime1, SJFburstTime1);
		System.out.println("\nTEST CASE 2");
		new SJF(SJFprocessID2, SJFarrivalTime2, SJFburstTime2);
		System.out.println("\nTEST CASE 3");
		new SJF(SJFprocessID3, SJFarrivalTime3, SJFburstTime3);

		System.out.println("\nSHORTEST REMAINING TIME FIRST");

		int[] SRTFprocessID1 = {1,2,3,4,5,6,7,8,9,10};
		int[] SRTFarrivalTime1 = {11,50,7,27,35,37,13,21,22,6};
		int[] SRTFburstTime1 = {31,11,28,41,22,43,15,24,4,9};

		int[] SRTFprocessID2 = {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15};
		int[] SRTFarrivalTime2 = {45,1,33,25,3,26,44,12,20,32,6,2,37,14,35};
		int[] SRTFburstTime2 = {39,46,40,5,7,18,34,49,50,4,42,17,30,8,47};

		int[] SRTFprocessID3 = {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20};
		int[] SRTFarrivalTime3 = {16,19,29,23,13,27,10,38,48,21,36,30,23,7,24,50,5,9,32,0};
		int[] SRTFburstTime3 = {4,39,2,44,1,3,37,36,10,22,41,6,13,45,28,49,38,29,16,11};

		System.out.println("\nTEST CASE 1");
		new SRTF(SRTFprocessID1, SRTFarrivalTime1, SRTFburstTime1);
		System.out.println("\nTEST CASE 2");
		new SRTF(SRTFprocessID2, SRTFarrivalTime2, SRTFburstTime2);
		System.out.println("\nTEST CASE 3");
		new SRTF(SRTFprocessID3, SRTFarrivalTime3, SRTFburstTime3);

		System.out.println("\nNON-PREEMPTIVE PRIORITY");

		int[] NPPprocessID1 = {1,2,3,4,5,6,7,8,9,10};
		int[] NPParrivalTime1 = {41,29,3,42,0,28,26,49,25,24};
		int[] NPPburstTime1 = {4,43,5,6,38,43,14,4,26,3};
		int[] NPPpriority1 = {7,10,9,5,5,8,5,6,8,10};

		int[] NPPprocessID2 = {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15};
		int[] NPParrivalTime2 = {4,1,4,0,38,33,43,20,15,32,40,2,32,3,40};
		int[] NPPburstTime2 = {8,45,17,8,30,21,50,45,21,8,2,31,10,41,15};
		int[] NPPpriority2 = {15,1,13,6,7,11,12,15,11,1,11,14,9,1,6};

		int[] NPPprocessID3 = {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20};
		int[] NPParrivalTime3 = {13,35,47,20,45,31,8,0,35,7,6,48,39,21,43,44,19,15,38,11};
		int[] NPPburstTime3 = {37,44,30,20,37,42,17,10,30,11,30,7,31,26,36,2,23,49,41,18};
		int[] NPPpriority3 = {4,18,19,3,6,5,17,20,12,7,2,4,7,11,4,7,5,18,20,14};

		System.out.println("\nTEST CASE 1");
		new NP(NPPprocessID1, NPParrivalTime1, NPPburstTime1, NPPpriority1);
		System.out.println("\nTEST CASE 2");
		new NP(NPPprocessID2, NPParrivalTime2, NPPburstTime2, NPPpriority2);
		System.out.println("\nTEST CASE 3");
		new NP(NPPprocessID3, NPParrivalTime3, NPPburstTime3, NPPpriority3);

		System.out.println("\nPREEMPTIVE PRIORITY");

		int[] PPprocessID1 = {1,2,3,4,5,6,7,8,9,10};
		int[] PParrivalTime1 = {2,36,20,47,21,0,26,32,23,12};
		int[] PPburstTime1 = {45,7,28,5,17,46,45,7,28,35};
		int[] PPpriority1 = {1,1,5,3,4,7,6,7,5,7};

		int[] PPprocessID2 = {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15};
		int[] PParrivalTime2 = {0,37,15,15,26,20,12,18,26,19,12,1,19,31,27};
		int[] PPburstTime2 = {37,2,6,20,22,36,28,14,21,10,30,1,20,36,23};
		int[] PPpriority2 = {2,2,4,11,4,3,2,7,7,7,6,13,2,9,7};

		int[] PPprocessID3 = {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20};
		int[] PParrivalTime3 = {6,16,48,0,23,37,3,42,45,38,47,30,25,19,26,45,6,29,44,48};
		int[] PPburstTime3 = {5,32,48,5,43,24,32,25,29,17,9,1,35,18,22,38,15,39,35,50};
		int[] PPpriority3 = {3,19,4,14,9,19,1,4,19,5,4,10,7,5,1,6,16,19,11,16};

		System.out.println("\nTEST CASE 1");
		new PP(PPprocessID1, PParrivalTime1, PPburstTime1, PPpriority1);
		System.out.println("\nTEST CASE 2");
		new PP(PPprocessID2, PParrivalTime2, PPburstTime2, PPpriority2);
		System.out.println("\nTEST CASE 3");
		new PP(PPprocessID3, PParrivalTime3, PPburstTime3, PPpriority3);

		System.out.println("\nROUND ROBIN");
		System.out.print("Enter quantum time: ");
		int q = 20;

		int[] RRprocessID1 = {1,2,3,4,5,6,7,8,9,10};
		int[] RRarrivalTime1 = {33,0,40,38,8,17,6,3,27,43};
		int[] RRburstTime1 = {17,36,23,16,3,35,16,21,46,43};

		int[] RRprocessID2 = {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15};
		int[] RRarrivalTime2 = {14,17,2,0,36,6,4,37,13,4,48,41,13,14,11};
		int[] RRburstTime2 = {21,27,44,14,14,2,24,47,45,38,45,3,44,26,11};

		int[] RRprocessID3 = {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20};
		int[] RRarrivalTime3 = {33,36,29,27,23,45,43,14,49,13,10,0,41,43,27,22,26,1,47,33};
		int[] RRburstTime3 = {16,34,29,38,23,4,38,40,38,7,36,10,18,7,23,1,6,36,48,8};

		System.out.println("\nTEST CASE 1");
		new RR(RRprocessID1, RRarrivalTime1, RRburstTime1, q);
		System.out.println("\nTEST CASE 2");
		new RR(RRprocessID2, RRarrivalTime2, RRburstTime2, q);
		System.out.println("\nTEST CASE 3");
		new RR(RRprocessID3, RRarrivalTime3, RRburstTime3, q);

	}
}
