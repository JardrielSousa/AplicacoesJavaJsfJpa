package br.com.java8.conteudo;

public class MyThreadRunnuble implements Runnable{
	private String nome;
	private int tempo;
	public MyThreadRunnuble(String nome,int tempo) {
		this.nome = nome;
		this.tempo = tempo;
		Thread t = new Thread(this);
		t.start();
	}
	public void run() {
			try {
				for(int i = 0 ; i<6;i++) {
					System.out.println(nome +" Runnible #"+i );
					Thread.sleep(tempo);
				}
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println(nome +" Runnible terminou a execução");
		}
	}



