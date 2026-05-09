package com.krakedev.test.JUnit;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import com.krakedev.juegos.entidades.Carta;
import com.krakedev.juegos.entidades.Jugador;
import com.krakedev.juegos.servicios.Juego21;

public class TestJuego21JUnit {

    @Test
    public void testCalcularTotal() {

        Jugador j = new Jugador();
        j.setNickname("Alex");

        Carta c1 = new Carta("A", "T");
        c1.setValorJuego(11);

        Carta c2 = new Carta("K", "D");
        c2.setValorJuego(10);

        j.recibirCarta(c1);
        j.recibirCarta(c2);

        Juego21 juego = new Juego21();
        juego.agregarJugador(j);

        juego.calcularTotal();

        assertEquals(21, j.getPuntajeCartas());    }
    
    @Test
    public void testBlackjackExacto() {
        Jugador j = new Jugador();
        j.setNickname("Alex");

        Carta c1 = new Carta("A", "T");
        c1.setValorJuego(11);

        Carta c2 = new Carta("K", "D");
        c2.setValorJuego(10);

        j.recibirCarta(c1);
        j.recibirCarta(c2);

        Juego21 juego = new Juego21();
        juego.agregarJugador(j);
        juego.calcularTotal();

        assertEquals(21, j.getPuntajeCartas());
    }

    @Test
    public void testMenorA21() {
        Jugador j = new Jugador();
        j.setNickname("Maria");

        Carta c1 = new Carta("5", "T");
        c1.setValorJuego(5);

        Carta c2 = new Carta("7", "D");
        c2.setValorJuego(7);

        j.recibirCarta(c1);
        j.recibirCarta(c2);

        Juego21 juego = new Juego21();
        juego.agregarJugador(j);
        juego.calcularTotal();

        assertTrue(j.getPuntajeCartas() < 21);
    }

    @Test
    public void testMayorA21() {
        Jugador j = new Jugador();
        j.setNickname("Luis");

        Carta c1 = new Carta("K", "T");
        c1.setValorJuego(10);

        Carta c2 = new Carta("Q", "D");
        c2.setValorJuego(10);

        Carta c3 = new Carta("5", "C");
        c3.setValorJuego(5);

        j.recibirCarta(c1);
        j.recibirCarta(c2);
        j.recibirCarta(c3);

        Juego21 juego = new Juego21();
        juego.agregarJugador(j);
        juego.calcularTotal();

        assertTrue(j.getPuntajeCartas() > 21);
    }

    @Test
    public void testValidarGanador() {
        Juego21 juego = new Juego21();
        juego.inicializar();

        Jugador j1 = new Jugador();
        j1.setNickname("Alex");

        Carta c1 = new Carta("A", "T");
        c1.setValorJuego(11);
        Carta c2 = new Carta("K", "D");
        c2.setValorJuego(10);

        j1.recibirCarta(c1);
        j1.recibirCarta(c2);

        juego.agregarJugador(j1);
        juego.calcularTotal();

        ArrayList<Jugador> ganadores = juego.validarGanador();

        assertFalse(ganadores.isEmpty());
        assertEquals("Alex", ganadores.get(0).getNickname());
    }

    @Test
    public void testSinGanador() {
        Juego21 juego = new Juego21();
        juego.inicializar();

        Jugador j1 = new Jugador();
        j1.setNickname("Alex");

        Carta c1 = new Carta("10", "T");
        c1.setValorJuego(10);
        Carta c2 = new Carta("9", "D");
        c2.setValorJuego(9);

        j1.recibirCarta(c1);
        j1.recibirCarta(c2);

        juego.agregarJugador(j1);
        juego.calcularTotal();

        ArrayList<Jugador> ganadores = juego.validarGanador();

        assertTrue(ganadores.isEmpty());
    }

}