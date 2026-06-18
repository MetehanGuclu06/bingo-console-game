package com.metehanguclu.bingo;

import java.util.Arrays;

public class Oyuncular {
	String name;
	Kartlar kart;

	public Oyuncular(String name, Kartlar kart) {
		this.name = name;
		this.kart = kart;
	}

	public void kartEkle(String kart) {
		String[] parts = kart.split(" ");
		String[] result = Arrays.copyOfRange(parts, 1, parts.length);
		this.kart.dizi = result;
	}

	public String toString() {
		return name + Arrays.toString(kart.dizi);
	}

}
