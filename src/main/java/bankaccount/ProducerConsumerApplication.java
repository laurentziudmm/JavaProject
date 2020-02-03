package bankaccount;

import bankaccount.threads.TransactionConsumer;
import bankaccount.threads.TransactionProducer;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Main transactions bank application
 **/

public class ProducerConsumerApplication {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(200);

        /*
          In cadrul blocului cu exectuie infinita while(true) se vor adauga in executorService
          cateva instante de TransactionProducer respectiv TransactionConsumer.
         */
        while (true) {

            executorService.submit(new TransactionProducer());
            executorService.submit(new TransactionProducer());
            executorService.submit(new TransactionProducer());
            executorService.submit(new TransactionProducer());
            executorService.submit(new TransactionProducer());
            executorService.submit(new TransactionProducer());
            executorService.submit(new TransactionProducer());
            executorService.submit(new TransactionProducer());


            executorService.submit(new TransactionConsumer());
            executorService.submit(new TransactionConsumer());
            executorService.submit(new TransactionConsumer());
            executorService.submit(new TransactionConsumer());
            executorService.submit(new TransactionConsumer());
            executorService.submit(new TransactionConsumer());
            executorService.submit(new TransactionConsumer());
            executorService.submit(new TransactionConsumer());
            executorService.submit(new TransactionConsumer());
            executorService.submit(new TransactionConsumer());
            executorService.submit(new TransactionConsumer());
            executorService.submit(new TransactionConsumer());
            executorService.submit(new TransactionConsumer());
            executorService.submit(new TransactionConsumer());
            executorService.submit(new TransactionConsumer());


            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }
}
