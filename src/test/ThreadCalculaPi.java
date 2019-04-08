package test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class ThreadCalculaPi {
    private List<Integer> pi = new ArrayList<Integer>(TAM);
    public static final int TAM = 10000;
    public static final int NUM_THREADS = 5;
    public static int numeroQualquer = 1;


    public static void main(String[] args) {

        Collection<ThreadPi> threads = new ArrayList<>();

        for(int i = 0; i < NUM_THREADS; i++){
            ThreadPi t = new ThreadPi(i);
            new Thread(t).start();
            threads.add(t);
        }


        for(ThreadPi t: threads){

        }

    }

   /* private void calculoPi(){
        Random rnd = new Random();

        for(int i=0; i< TAM; I++){
            numeros.add(Math.abs(rnd.nextInt(20)));
        }
    } */

    static class ThreadPi implements Runnable{

        private int numThread;
        private int algumaSoma;

        public ThreadPi(int numThread){
            this.numThread = numThread;
            algumaSoma = numThread*2;
        }

        public void run(){

            System.out.println("Thread "+ numThread +": " + numeroQualquer*algumaSoma );
            numeroQualquer++;
        }

    }



}
