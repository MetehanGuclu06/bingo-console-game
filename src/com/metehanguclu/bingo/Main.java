package com.metehanguclu.bingo;

import java.util.Random;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class Main {

	public static void main(String[] args) throws FileNotFoundException, InterruptedException {

		LinkedList oyuncuListesi = new LinkedList();

		Random random = new Random();

		Scanner girdi = new Scanner(new File("src/com/metehanguclu/bingo/Bilgiler.txt"));

		String tempKart = "";
		while (girdi.hasNextLine()) {
			String temp = girdi.nextLine();
			if (temp.equals("Kişiler ve Seçtikleri Kart:") || temp.equals("Oyun Kartları:")) {
			} else if (!temp.startsWith("kart")) {
				int spaceIndex = temp.indexOf(" ");
				String name = temp.substring(0, spaceIndex);
				String kartName = temp.substring(spaceIndex + 1);
				tempKart = tempKart + kartName;
				oyuncuListesi.add(new Oyuncular(name, new Kartlar(kartName)));
			} else {
				int spaceIndex = temp.indexOf(" ");
				String kartName = temp.substring(0, spaceIndex);
				if (tempKart.contains(kartName)) {
					oyuncuListesi.kartaSahipOyuncuyaKartıEkle(temp);
				}
			}
		}
		girdi.close();
		System.out.println("Bilgiler.txt dosyası okundu.");

		while (oyuncuListesi.kontrol()) {
			int sayi = random.nextInt(1, 21);
			System.out.println("Çekilen sayı: " + sayi);
			oyuncuListesi.oyun(sayi);
			oyuncuListesi.String();
			oyuncuListesi.kazananlar();
			Thread.sleep(500);
		}

	}

}
