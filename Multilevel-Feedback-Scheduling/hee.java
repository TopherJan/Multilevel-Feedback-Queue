public class hee {

  public hee(int[] process, int[] arrivalTime, int[] burstTime,  int[] priority, int quantum, int queue){
    int size = process.length;
    int lastArrival, nextQueue = queue;
    float awt = 0, att = 0, art = 0;
    int temp = 0;
    int[] wt = new int[size];
    int[] te = new int[size];
    int[] rt = new int[size];
    int[] turnaroundTime = new int[size];
    int[] responseTime = new int[size];
    int[] serviceTime = new int[size];
    int[] completionTime = new int[size];

    if(queue != MLFQFrame.numOfQueues - 1){
      nextQueue++;
    }else{
      nextQueue = 0;
    }

    for (int i = 0; i < size; i++){
      for (int j = i + 1; j < size; j++){
        if(arrivalTime[i] > arrivalTime[j]){
          temp = process[i];
          process[i] = process[j];
          process[j] = temp;
          temp = arrivalTime[i];
          arrivalTime[i] = arrivalTime[j];
          arrivalTime[j] = temp;
          temp = burstTime[i];
          burstTime[i] = burstTime[j];
          burstTime[j] = temp;
          temp = priority[i];
          priority[i] = priority[j];
          priority[j] = temp;
        }
      }
    }

    for(int i = 0; i < size; i++){
      rt[i] = burstTime[i];
      wt[i] = 0;
      te[i] = 0;
    }

    int t = 0, q = arrivalTime[0], loopCounter = 0;;
    int res_b[] = new int[burstTime.length];
    int res_a[] = new int[arrivalTime.length];

    for (int i = 0; i < res_b.length; i++) {
        res_b[i] = burstTime[i];
        res_a[i] = arrivalTime[i];
    }
    String seq = "", sequence = "";

    loop:
    while (true) {
      boolean flag = true;
      for (int i = 0; i < process.length; i++) {

        // these condition for if
        // arrival is not on zero

        // check that if there come before qtime
        if (res_a[i] <= t) {
          serviceTime[i] = q;
          if (res_a[i] <= quantum) {
            if (res_b[i] > 0) {
              flag = false;
              if (res_b[i] > quantum) {

                // make decrease the burstTime time
                t = t + quantum;
                MLFQFrame.arrival_time.add(q);
                q = q + quantum;
                for(int k = 0; k < quantum; k++){
                  MLFQFrame.process_ID.add(process[i]);
                }
                res_b[i] = res_b[i] - quantum;
                res_a[i] = res_a[i] + quantum;
                seq += "->" + process[i];
              }
              else {

                // for last time
                t = t + res_b[i];

                MLFQFrame.arrival_time.add(q);
                q = q + rt[i];
                for(int k = 0; k < res_b[i]; k++){
                  MLFQFrame.process_ID.add(process[i]);
                }
                // store completionTime time
                completionTime[i] = t - arrivalTime[i];

                // store wait time
                wt[i] = t - burstTime[i] - arrivalTime[i];

                // add sequence
                seq += "->" + process[i];
                res_b[i] = 0;
              }
            }
          }
          else if (res_a[i] > quantum) {

            // is any have less arrival time
            // the coming process then execute them
            for (int j = 0; j < process.length; j++) {

              // compare
              if (res_a[j] < res_a[i]) {
                if (res_b[j] > 0) {
                  flag = false;
                  if (res_b[j] > quantum) {
                    t = t + quantum;
                    MLFQFrame.arrival_time.add(q);
                    q = q + quantum;
                    for(int k = 0; k < quantum; k++){
                      MLFQFrame.process_ID.add(process[j]);
                    }
                    res_b[j] = res_b[j] - quantum;
                    res_a[j] = res_a[j] + quantum;
                    seq += "->" + process[j];
                  }
                  else {
                    t = t + res_b[j];
                    MLFQFrame.arrival_time.add(q);
                    q = q + res_b[j];
                    for(int k = 0; k < res_b[j]; k++){
                      MLFQFrame.process_ID.add(process[j]);
                    }
                    completionTime[j] = t - arrivalTime[j];
                    wt[j] = t - burstTime[j] - arrivalTime[j];
                    seq += "->" + process[j];
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
              if (res_b[i] > quantum) {
                t = t + quantum;
                MLFQFrame.arrival_time.add(q);
                q = q + quantum;
                for(int k = 0; k < quantum; k++){
                  MLFQFrame.process_ID.add(process[i]);
                }
                res_b[i] = res_b[i] - quantum;
                res_a[i] = res_a[i] + quantum;
                seq += "->" + process[i];
              }
              else {
                t = t + res_b[i];
                MLFQFrame.arrival_time.add(q);
                q = q + res_b[i];
                for(int k = 0; k < res_b[i]; k++){
                  MLFQFrame.process_ID.add(process[i]);
                }
                completionTime[i] = t - arrivalTime[i];
                wt[i] = t - burstTime[i] - arrivalTime[i];
                seq += "->" + process[i];
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
        break loop;
      }
    }

    MLFQFrame.arrival_time.add(q);
    lastArrival = q;

    for(int i = 0; i < size; i++){
      turnaroundTime[i] = wt[i] + arrivalTime[i];
      // wt[i] = Math.abs(turnaroundTime[i] - burstTime[i]);
      if(queue == 0)
      responseTime[i] = serviceTime[i] - arrivalTime[i];
      awt = awt + wt[i];
      att = att + turnaroundTime[i];
      art = art + responseTime[i];
    }

    MLFQFrame.avgwt += awt;
    MLFQFrame.avgta += att;
    MLFQFrame.avgrt += art;

    if(MLFQFrame.numOfQueues == 1){
      MLFQFrame.isTrue = false;
      return;
    }else{
      try{
        int count = 0, temporary = 0;
        for(int i = 0; i < process.length; i++){
          if(rt[i] != 0){
            count++;
          }
        }

        if(count == 0){
          MLFQFrame.isTrue = false;
          return;
        }

        MLFQFrame.processID[nextQueue] = new int[count];
        MLFQFrame.burstTime[nextQueue] = new int[count];
        MLFQFrame.arrivalTime[nextQueue] = new int[count];
        MLFQFrame.priority[nextQueue] = new int[count];

        for(int k = 0; k < process.length; k++){
          if(rt[k] != 0){
            MLFQFrame.processID[nextQueue][temporary] = process[k];
            MLFQFrame.arrivalTime[nextQueue][temporary] = lastArrival;
            MLFQFrame.burstTime[nextQueue][temporary] = rt[k];
            MLFQFrame.priority[nextQueue][temporary] = priority[k];
            temporary++;
          }
        }
      }catch(ArrayIndexOutOfBoundsException e){
        return;
      }
    }
  }
}
