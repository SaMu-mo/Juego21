package com.krakedev.juegos.servicios;

import java.util.ArrayList;
import com.krakedev.juegos.entidades.*;

public class Juego21 {

    private ArrayList<Jugador> jugadores = new ArrayList<>();
    private Dealer dealer;

    public void inicializar() {
        dealer = new Dealer();
        cargarValores();
    }

    public void cargarValores() {
        for (Carta c : dealer.getNaipe()) {

            String v = c.getValor();

            switch (v) {
                case "A":
                    c.setValorJuego(11);
                    break;
                case "J":
                case "Q":
                case "K":
                    c.setValorJuego(10);
                    break;
                default:
                    c.setValorJuego(Integer.parseInt(v));
            }
        }
    }

    public void agregarJugador(Jugador j) {
        jugadores.add(j);
    }

    public void repartirCarta(Jugador j) {
        Carta c = dealer.entregarCarta();
        j.recibirCarta(c);
    }

    public void repartirRonda() {
        for (Jugador j : jugadores) {
            repartirCarta(j);
        }
        calcularTotal();
    }

    public void calcularTotal() {
        for (Jugador j : jugadores) {
            int total = 0;
            for (Carta c : j.getCartas()) {
                total += c.getValorJuego();
            }
            j.setPuntajeCartas(total);
        }
    }

    public ArrayList<Jugador> validarGanador() {
        ArrayList<Jugador> ganadores = new ArrayList<>();

        for (Jugador j : jugadores) {
            if (j.getPuntajeCartas() == 21) {
                ganadores.add(j);
            }
        }
        return ganadores;
    }

    public ArrayList<Jugador> jugar() {

        ArrayList<Jugador> ganadores = new ArrayList<>();

        for (int i = 0; i < 3; i++) {

            repartirRonda();
            ganadores = validarGanador();

            if (!ganadores.isEmpty()) {
                break;
            }
        }

        return ganadores;
    }
}