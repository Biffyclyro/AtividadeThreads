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
            ThreadPi t = new ThreadPi();
            new Thread(t).start();
            threads.add(t);
        }

            while (true) {
                long total =0;
                long pIn = 0;
                for (ThreadPi t : threads) {
                    total += t.total;
                    pIn += t.pIn;
                    System.out.println("PI = "+(4 * double pIn/total));


                }
            }



    }



   /* private void calculoPi(){
        Random rnd = new Random();

        for(int i=0; i< TAM; I++){
            numeros.add(Math.abs(rnd.nextInt(20)));
        }
    } */

    static class ThreadPi implements Runnable{

        public long total = 1;
        public long pIn = 0;





        public void run(){

            Random rnd = new Random();



            for(int j = 0; j< total; j++, total++){
                double x = rnd.nextDouble();
                double y = rnd.nextDouble();
                if(x * y + y * x <= 1){
                    pIn++;
                }
            }




        }

    }



}
