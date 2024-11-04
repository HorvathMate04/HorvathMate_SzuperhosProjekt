package hu.petrik.szuperhosprojekt;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Kepregeny {
    public static List<Szuperhos> szuperhosLista = new ArrayList<>();

    public static void szereplok(String fajlElérésiÚt) {
        try (BufferedReader br = new BufferedReader(new FileReader(fajlElérésiÚt))) {
            String sor;
            while ((sor = br.readLine()) != null) {
                String[] elemek = sor.split(" ");
                String nev = elemek[0];
                int kutyuSzam = Integer.parseInt(elemek[1]);

                Szuperhos hos;
                if (nev.equalsIgnoreCase("Vasember")) {
                    hos = new Vasember();
                } else if (nev.equalsIgnoreCase("Batman")) {
                    hos = new Batman();
                } else {
                    System.out.println("Ismeretlen szuperhős: " + nev);
                    continue;
                }

                for (int i = 0; i < kutyuSzam; i++) {
                    if (hos instanceof Milliardos) {
                        ((Milliardos) hos).kutyutKeszit();
                    }
                }

                szuperhosLista.add(hos);
            }
        } catch (IOException e) {
            System.out.println("Hiba történt a fájl beolvasása során: " + e.getMessage());
        }
    }

    public static void szuperhosok() {
        for (Szuperhos hos : szuperhosLista) {
            System.out.println(hos);
        }
    }

    public static void main(String[] args) {
        szereplok("szuperhosok.txt");

        szuperhosok();
    }
}
