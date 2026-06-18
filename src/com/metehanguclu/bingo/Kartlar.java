package com.metehanguclu.bingo;

public class Kartlar {
	String kartName;
	String[] dizi;
	int sayi = 0;

	public Kartlar(String kartName) {
		this.kartName = kartName;
		this.dizi = null;
	}

	public Kartlar(String kartName, String[] dizi) {
		this.kartName = kartName;
		this.dizi = dizi;
	}

	public void diziGuncelle(String str) {
		for (int i = 0; i < dizi.length; i++) {
			if (dizi[i].equals(str)) {
				dizi[i] = dizi[i] + "#";
				this.sayi = this.sayi + 1;
			}
		}
	}

	public String toString() {
		String str = kartName + " ";
		for (String temp : dizi) {
			str = str + " " + temp;
		}
		return str;
	}

}
