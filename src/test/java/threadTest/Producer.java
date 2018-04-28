package threadTest;

public class Producer extends Thread {
       private  Warehouse warehouse;
       private static int produceName=0;//产品的名称
       private boolean running=false;
	public Producer(Warehouse warehouse, String name) {
		// TODO Auto-generated constructor stub
		super(name);
		this.warehouse = warehouse;
	}
	@Override
	public synchronized void start() {
		// TODO Auto-generated method stub
		running=true;
		super.start();
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		Product  product;
		try {
			while(running){
				product=new Product((++produceName)+"");
				this.warehouse.storageProduct(product);
				sleep(300);
			}
		} catch (InterruptedException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
	}
       
       //
	public void stopProducer(){
		synchronized (warehouse) {
			this.running=false;
			warehouse.notifyAll();
		}
	}
	
	public boolean isRunning(){
		return running;
	}
}
