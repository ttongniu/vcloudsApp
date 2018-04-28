package threadTest;

public class Consumer extends Thread {
    private Warehouse warehouse;
    private boolean running=false;
    
	public Consumer(Warehouse warehouse, String name) {
		// TODO Auto-generated constructor stub
		super(name);
		this.warehouse=warehouse;
	}

	@Override
	public synchronized void start() {
		// TODO Auto-generated method stub
		this.running=true;
		super.start();
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		Product product;
		try {
		    while(running){
		    	product=warehouse.getProduct();
		    	sleep(500);
		    }	
		} catch (InterruptedException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		super.run();
	}
	
	/**
	 * 停止消费者线程
	 */
    public void stopConsumer(){
    	synchronized (warehouse) {
			this.running=false;
			warehouse.notifyAll();
		}
    }
    
    public boolean isRunning(){
    	return running;
    }
}
