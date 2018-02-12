package com.hxkj.websocket.runable;

public class TicketRunable implements Runnable {

	private static Integer number = 100;
	
	@Override
	public void run() {
		for(int i=0;i<33;i++){
			System.out.println(Thread.currentThread().getName()+"当前卖票的号数为："+number--);
		}
	}

	public static void doThread(String name){
		Thread thread = new Thread(new Runnable() {
			
			@Override
			public void run() {
				for(int i=0;i<33;i++){
					System.out.println(Thread.currentThread().getName()+"当前卖票的号数为："+number--);
				}
			}
		});
		
		thread.start();
		try {
			thread.join();//该方法是让线程执行结束了才结束主方法线程
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/*public static void main(String[] args) {
		TicketRunable ticketRunable = new TicketRunable();
		new Thread(ticketRunable, "张三").start();
		new Thread(ticketRunable, "李四").start();
		new Thread(ticketRunable, "王五").start();
		doThread("aa");
		System.out.println("开始执行了aa");
		doThread("bb");
		System.out.println("主线程结束了");
	}*/
}
