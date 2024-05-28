package edu.fiuba.algo3.modelo.HitPoints;

public interface HitPoints {

    void recibirDaño(int daño);
    void regenerar();
    int vida();
    int escudo();
    boolean vidaDestruida();

}