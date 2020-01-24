package br.com.date;

import java.util.Calendar;
import java.util.Date;

public class Data {
    static final Date data = new Date();
    public static void main(String[] args) {
	data.setDate(01);
	data.setYear(2000);
	data.setMonth(10);
	processar(data);
    }
    
    public static void processar(Date data) {
	if(data.equals(new Date())) {
	    System.out.println("data não muda!!");
	}else {
	    System.out.println("data muda!!");
	}
    }

}
