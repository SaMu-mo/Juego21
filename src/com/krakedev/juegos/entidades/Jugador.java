package com.krakedev.juegos.entidades;

import java.util.ArrayList;

public class Jugador {

    private String nickname;
    private ArrayList<Carta> cartas = new ArrayList<>();
    private int puntajeCartas;

    public String getNickname() { return nickname; }
    public void setNickname(String nickname) { this.nickname = nickname; }

    public ArrayList<Carta> getCartas() { return cartas; }

    public int getPuntajeCartas() { return puntajeCartas; }
    public void setPuntajeCartas(int puntajeCartas) { this.puntajeCartas = puntajeCartas; }

    public void recibirCarta(Carta carta) {
        cartas.add(carta);
    }

    public void imprimir() {
        System.out.println("Jugador: " + nickname);
        for (Carta c : cartas) {
            c.imprimir();
        }
        System.out.println("Total: " + puntajeCartas);
    }

    public void limpiarCartas() {
        cartas.clear();
        puntajeCartas = 0;
    }
}