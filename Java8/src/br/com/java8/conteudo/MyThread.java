package br.com.java8.conteudo;

public class MyThread extends Thread{
	private String nome;
	private int tempo;
	public MyThread(String nome,int tempo) {
		this.nome = nome;
		this.tempo = tempo;
		start();
	}
	public void run() {
			try {
				for(int i = 0 ; i<6;i++) {
					System.out.println(nome +" executando #"+i );
					Thread.sleep(tempo);
				}
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println(nome +" terminou a execução");
		}
	}



