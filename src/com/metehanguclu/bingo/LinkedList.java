package com.metehanguclu.bingo;

public class LinkedList {
	Oyuncular oyuncu;
	LinkedList next;
	private boolean kontrol = false;
	private String kazananlar = "";

	public LinkedList() {
		this.oyuncu = null;
		this.next = null;
	}

	public LinkedList(Oyuncular oyuncu) {
		this.oyuncu = oyuncu;
		this.next = null;
	}

	public LinkedList(Oyuncular oyuncu, LinkedList next) {
		this.oyuncu = oyuncu;
		this.next = next;
	}

	public void add(Oyuncular oyuncu) {
		if (next == null) {
			next = new LinkedList(oyuncu);
		} else {
			LinkedList current = next;
			while (current.next != null) {
				current = current.next;
			}
			current.next = new LinkedList(oyuncu);
		}
	}

	public void kartaSahipOyuncuyaKartıEkle(String kart) {
		LinkedList current = next;
		while (current != null) {
			int spaceIndex = kart.indexOf(" ");
			String kartName = kart.substring(0, spaceIndex);
			if (current.oyuncu.kart.kartName.equals(kartName)) {
				current.oyuncu.kartEkle(kart);
			}
			current = current.next;
		}
	}

	public void oyun(int sayi) {
		String str = String.valueOf(sayi);

		LinkedList current = next;
		while (current != null) {
			current.oyuncu.kart.diziGuncelle(str);
			if (current.oyuncu.kart.sayi == current.oyuncu.kart.dizi.length) {
				this.kazananlar = this.kazananlar + " " + current.oyuncu.name;
				this.kontrol = true;
			}
			current = current.next;
		}
	}

	public boolean kontrol() {
		if (this.kontrol == true) {
			return false;
		}
		return true;
	}

	public void kazananlar() {
		if (this.kontrol) {
			System.out.println("Oyun bitti kazanan: " + this.kazananlar);
		}
	}

	public void String() {
		LinkedList current = next;
		while (current != null) {
			System.out.println(current.oyuncu);
			current = current.next;
		}
	}

}
