import mpi.*;

public class DistributedSum {

    public static void main(String args[]) throws MPIException{
        MPI.Init(args);

        int rank = MPI.COMM_WORLD.Rank();
        int size = MPI.COMM_WORLD.Size();

        int []arr = {1,2,3,4,5,6,7,8,9,10};

        int localSum = 0;
        int []recvBuffer = new int[1];

        int start = rank * (arr.length / size);
        int end = (rank + 1)*(arr.length / size);

        for(int i=start; i<end;i++){
            localSum +=arr[i];
        }

        System.out.println("Process" + rank + "Intermediate Sum" + localSum);

        MPI.COMM_WORLD.Reduce(new int[]{localSum},0,recvBuffer, 0, 1, MPI.INT, MPI.SUM,0);

        if(rank == 0){
            System.out.println("Final Sum :" + recvBuffer[0]);
        }

        MPI.Finalize();
    }

}
// Downloads (After extracting mpj.tar)
//export MPJ_HOME=/home/user/Downloads/mpj-v0_44
//export PATH=$MPJ_HOME/bin:$PATH
//javac -cp $MPJ_HOME/lib/mpj.jar DistributedSum.java
// Go into the Exp3
//javac -cp $MPJ_HOME/lib/mpj.jar DistributedSum.java
//mpjrun.sh -np 4 DistributedSum
