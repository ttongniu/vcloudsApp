package threadTest;

public class Warehouse {
     private static int CAPACITY=11;//仓库容量
     
     private  Product[] products;//仓库产品
     
     //[front, rear)区间的产品是未被消费的
 	 //当前仓库中第一个未被消费的产品的下标
     private int front=0;
     //仓库中最后一个未被消费的产品的下标加1
     private int rear=0;
     
     public Warehouse(){
    	 this.products=new Product[CAPACITY];
     }
     
     public Warehouse(int capacity){
    	 this();
    	 if(capacity>0){
    		 CAPACITY=capacity+1;
    		 this.products=new Product[CAPACITY];
    		 
    	 }
     }
     
     public Product getProduct() throws InterruptedException{
    	 synchronized (this) {
			boolean consumerRunning=true;
			
		    Thread currentThread= Thread.currentThread();
		    if(currentThread instanceof Consumer){
		    	consumerRunning=((Consumer) currentThread).isRunning();
		    }else{
		    	return null;
		    }
		    while((front==rear)&& consumerRunning){
		    	wait();
		    	consumerRunning=((Consumer) currentThread).isRunning();
		    }
		    
		    if(!consumerRunning){
		    	return null;
		    }
		    Product product=products[front];
		    System.out.println("Consumer[" + currentThread.getName()
			+ "] getProduct: " + product);
	//将当前未被消费产品的下标后移一位，如果到了数组末尾，则移动到首部。
		    front = (front+1+CAPACITY)%CAPACITY;
		    System.out.println("仓库中还没有被消费的产品数量："
					+ (rear + CAPACITY - front) % CAPACITY);
			//通知其他等待线程
		    notify();
		    return product;
		}
     }

	public void storageProduct(Product product) throws InterruptedException {
		// TODO Auto-generated method stub
		synchronized (this) {
			boolean producerRunning=true;
			Thread currentThread=Thread.currentThread();
			if(currentThread instanceof Producer){
				producerRunning=((Producer) currentThread).isRunning();
			}else{
				return ;
			}
			//如果最后一个未被消费产品与第一个未被消费的产品的下标紧挨着，
			//则说明没有存储空间，如果没有存储空间而且生产者线程还在运行，则等待仓库释放产品。
			while((rear+1)%CAPACITY==front&&producerRunning){
				wait();
				producerRunning=((Producer) currentThread).isRunning();
			}
			
			if(!producerRunning){
				return;
			}
			products[rear]=product;
			System.out.println("Producer[" + Thread.currentThread().getName()
					+ "] storageProduct: " + product);
			//将rear下标循环后移一位
			rear=(rear+1)%CAPACITY;
			System.out.println("仓库中还没有被消费的产品数量："
					+ (rear + CAPACITY - front) % CAPACITY);
			notify();
		}
	}
     
     
}   



