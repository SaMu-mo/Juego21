package com.krakedev.juegos.servicios;

import java.util.ArrayList;
import com.krakedev.juegos.entidades.Carta;

public class Dealer {
	
	private ArrayList<Carta> naipe;

    public Dealer() {
        naipe = new ArrayList<>();
        generarNaipe();
    }

    public ArrayList<Carta> getNaipe() {
        return naipe;
    }

    public void generarNaipe() {

        String[] valores = {"A","2","3","4","5","6","7","8","9","10","J","Q","K"};
        String[] palos = {"T","CN","CR","D"};

        for (String palo : palos) {
            for (String valor : valores) {
                naipe.add(new Carta(valor, palo));
            }
        }
    }
    
    public void imprimirNaipe() {
        for (Carta c : naipe) {
            c.imprimir();
        }
    }

    public int generarAleatorio(int maximo) {
        return (int)(Math.random() * (maximo + 1));
    }

    public Carta entregarCarta() {
        int pos = generarAleatorio(naipe.size() - 1);
        Carta c = naipe.get(pos);
        naipe.remove(pos);
        return c;
    }
}