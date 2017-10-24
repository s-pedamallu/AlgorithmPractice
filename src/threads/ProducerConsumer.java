package threads;

import java.util.Queue;

public class ProducerConsumer {
	private enum Lock {
		PRODUCER, CONSUMER;
	}

	static class Producer implements Runnable {
		Queue<Integer> sharedQueue;
		int size;
		int val;

		Producer(Queue q, int s) {
			this.sharedQueue = q;
			this.size = s;
			this.val = 0;
		}

		@Override
		public void run() {		
			while(true) {
				
			}
		}
		
	}
}
