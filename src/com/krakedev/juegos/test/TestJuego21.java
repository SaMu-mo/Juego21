package com.krakedev.juegos.test;

import com.krakedev.juegos.servicios.*;
import com.krakedev.juegos.entidades.*;
import java.util.ArrayList;

public class TestJuego21 {

    public static void main(String[] args) {

        Juego21 juego = new Juego21();

        juego.inicializar();

        Jugador j1 = new Jugador();
        j1.setNickname("Alex");

        Jugador j2 = new Jugador();
        j2.setNickname("Maria");

        Jugador j3 = new Jugador();
        j3.setNickname("Luis");

        juego.agregarJugador(j1);
        juego.agregarJugador(j2);
        juego.agregarJugador(j3);

        ArrayList<Jugador> ganadores = juego.jugar();

        System.out.println("RESULTADO:");

        if (ganadores.isEmpty()) {
            System.out.println("No hubo ganador");
        } else {
            for (Jugador j : ganadores) {
                System.out.println("Ganador: " + j.getNickname());
            }
        }
        System.out.println("\n====== JUGADOR 1 ======\n");

        j1.imprimir();
        
        System.out.println("\n====== JUGADOR 2 ======\n");
        
        j2.imprimir();
        
        System.out.println("\n====== JUGADOR 3 ======\n");
        
        j3.imprimir();
        
    }
}