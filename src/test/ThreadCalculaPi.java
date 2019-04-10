package test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Random;

public class ThreadCalculaPi {
    private List<Integer> pi = new ArrayList<Integer>(TAM);
    public static final int TAM = 10000;
    public static final int NUM_THREADS = 6;





    public static void main(String[] args) {

        Collection<ThreadPi> threads = new ArrayList<>();


        for(int i = 0; i < NUM_THREADS; i++){
            ThreadPi t = new ThreadPi(i);
            new Thread(t).start();
            threads.add(t);
        }


            for(ThreadPi t: threads){
                while (t.pronto==true){
                    t.run();
                }


            }



    }

    public static void calculaPi(){
        final int total = 100000;cd D
        Random rnd = new Random();
        int Pin = 0;


        for(int j = 0; j< total; j++){
            double x = rnd.nextDouble();
            double y = rnd.nextDouble();
            if(x * y + y * x <= 1){
                Pin++;
            }
        }

        System.out.println("PI = "+(4 * ((double)Pin)/total));

    }


   /* private void calculoPi(){
        Random rnd = new Random();

        for(int i=0; i< TAM; I++){
            numeros.add(Math.abs(rnd.nextInt(20)));
        }
    } */

    static class ThreadPi implements Runnable{

        private int numThread;
        private boolean pronto = false;



        public ThreadPi(int numThread){
            this.numThread = numThread;

        }

        public void run(){
            pronto = true;

            calculaPi();

        }

    }



}
