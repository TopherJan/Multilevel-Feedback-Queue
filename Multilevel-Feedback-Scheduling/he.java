class he {
    public static void roundRobin(String p[], int a[],
                                  int b[], int n)
    {
        // result of average times
        int res = 0;
        int resc = 0;

        // for sequence storage
        String seq = new String();
        String sequence = "";
        // copy the burst array and arrival array
        // for not effecting the actual array
        int res_b[] = new int[b.length];
        int res_a[] = new int[a.length];

        for (int i = 0; i < res_b.length; i++) {
            res_b[i] = b[i];
            res_a[i] = a[i];
        }

        // critical time of system
        int t = 0;

        // for store the waiting time
        int w[] = new int[p.length];

        // for store the Completion time
        int comp[] = new int[p.length];

        while (true) {
            boolean flag = true;
            for (int i = 0; i < p.length; i++) {

                // these condition for if
                // arrival is not on zero

                // check that if there come before qtime
                if (res_a[i] <= t) {
                    if (res_a[i] <= n) {
                        if (res_b[i] > 0) {
                            flag = false;
                            if (res_b[i] > n) {

                                // make decrease the b time
                                t = t + n;
                                res_b[i] = res_b[i] - n;
                                res_a[i] = res_a[i] + n;
                                seq += "->" + p[i];
                                for(int k = 0; k < n; k++)
                                sequence += p[i];
                            }
                            else {

                                // for last time
                                t = t + res_b[i];

                                // store comp time
                                comp[i] = t - a[i];

                                // store wait time
                                w[i] = t - b[i] - a[i];
                                res_b[i] = 0;

                                // add sequence
                                seq += "->" + p[i];
                                for(int k = 0; k < res_b[i]; k++)
                                sequence += p[i];
                            }
                        }
                    }
                    else if (res_a[i] > n) {

                        // is any have less arrival time
                        // the coming process then execute them
                        for (int j = 0; j < p.length; j++) {

                            // compare
                            if (res_a[j] < res_a[i]) {
                                if (res_b[j] > 0) {
                                    flag = false;
                                    if (res_b[j] > n) {
                                        t = t + n;
                                        res_b[j] = res_b[j] - n;
                                        res_a[j] = res_a[j] + n;
                                        seq += "->" + p[j];
                                        for(int k = 0; k < n; k++)
                                        sequence += p[j];
                                    }
                                    else {
                                        t = t + res_b[j];
                                        comp[j] = t - a[j];
                                        w[j] = t - b[j] - a[j];
                                        seq += "->" + p[j];
                                        for(int k = 0; k < res_b[j]; k++)
                                        sequence += p[j];
                                        res_b[j] = 0;
                                    }
                                }
                            }
                        }

                        // now the previous porcess according to
                        // ith is process
                        if (res_b[i] > 0) {
                            flag = false;

                            // Check for greaters
                            if (res_b[i] > n) {
                                t = t + n;
                                res_b[i] = res_b[i] - n;
                                res_a[i] = res_a[i] + n;
                                seq += "->" + p[i];
                                for(int k = 0; k < n; k++)
                                sequence += p[i];
                            }
                            else {
                                t = t + res_b[i];
                                comp[i] = t - a[i];
                                w[i] = t - b[i] - a[i];
                                seq += "->" + p[i];
                                for(int k = 0; k < res_b[i]; k++)
                                sequence += p[i];
                                res_b[i] = 0;
                            }
                        }
                    }
                }

                // if no process is come on thse critical
                else if (res_a[i] > t) {
                    t++;
                    i--;
                }
            }
            // for exit the while loop
            if (flag) {
                break;
            }
        }

        System.out.println("name  ctime  wtime");
        for (int i = 0; i < p.length; i++) {
            System.out.println(" " + p[i] + "    " + comp[i]
                               + "    " + w[i]);

            res = res + w[i];
            resc = resc + comp[i];
        }

        System.out.println("Average waiting time is "
                           + (float)res / p.length);
        System.out.println("Average compilation  time is "
                           + (float)resc / p.length);
        System.out.println("Sequence is like that " + seq);
        System.out.println("Sequence: " + sequence);

    }

    // Driver Code
    public static void main(String args[])
    {
        // name of the process
        String name[] = { "p1", "p2", "p3", "p4" };

        // arrival for every process
        int arrivaltime[] = { 10, 15, 20, 25 };

        // burst time for every process
        int bursttime[] = { 13, 6, 8, 5 };

        // quantum time of each process
        int q = 4;

        // cal the function for output
        roundRobin(name, arrivaltime, bursttime, q);
    }
}
