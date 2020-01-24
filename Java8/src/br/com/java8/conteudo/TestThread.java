package br.com.java8.conteudo;

public class TestThread {

	public static void main(String[] args) {
		MyThread t1 = new MyThread("teste 1",600);
		MyThread t2 = new MyThread("teste 2",900);
		MyThread t3 = new MyThread("teste 3",500);
		
		MyThreadRunnuble t4 = new MyThreadRunnuble("# 1",600);
		MyThreadRunnuble t5 = new MyThreadRunnuble("# 2",900);
		MyThreadRunnuble t6 = new MyThreadRunnuble("# 3",500);
		
		Thread t7 = new Thread(t4);
		Thread t8 = new Thread(t5);
		Thread t9 = new Thread(t6);
		t7.start();
		t8.start();
		t9.start();
		
	}

}
