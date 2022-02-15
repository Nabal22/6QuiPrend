package util;
import java.util.Arrays;
import java.util.Scanner;

import static util.Console.clearScreen;
import static util.Console.pause;

public class Demo {
	// D?monstration
	public static void main(String[] args) {
		pause();
		clearScreen(); // ou util.Cleaner.clearScreen(); voir le 'import static' ci-dessus
		compteur();
		ventilateur();
		pause();
		baffe();
		System.out.println("c'est fini");
	}

	private static void ventilateur() {
		for (int i = 1; i <= 20; ++i)
			for (char c : Arrays.asList('-', '\\', '|', '/')) {
				System.out.println(c);
				patience(50);
				clearScreen();
			}
	}

	private static void compteur() {
		for (int i = 1; i <= 100; ++i) {
			System.out.println(String.format("%03d", i));
			patience(50);
			clearScreen();
		}
	}

	private static void baffe() {
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		System.out.print("Voulez vous une baffe (O/N) : ");
		String rep = sc.next();
		clearScreen();
		if ("O".equalsIgnoreCase(rep))
			System.out.println("vous vous la prenez");
		else
			System.out.println("tout va bien");
		patience(1000);
		clearScreen();
	}

	// Utilitaire
	private static void patience(long ms) {
		try {
			Thread.sleep(ms);
		} catch (InterruptedException e) {
			Thread.currentThread().interrupt();
		}
	}
}
