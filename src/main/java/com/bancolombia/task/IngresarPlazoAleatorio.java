package com.bancolombia.task;


import com.bancolombia.userInterfaces.BancolombiaSimulacionPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Enter;

import java.security.SecureRandom;

public class IngresarPlazoAleatorio implements Task {

    private final int plazoMinimo;
    private final int plazoMaximo;

    public IngresarPlazoAleatorio(int plazoMinimo, int plazoMaximo) {
        this.plazoMinimo = plazoMinimo;
        this.plazoMaximo = plazoMaximo;
    }

    public static IngresarPlazoAleatorio entre(int plazoMinimo, int plazoMaximo) {
        return new IngresarPlazoAleatorio(plazoMinimo, plazoMaximo);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        int plazoAleatorio = generarPlazoAleatorio(plazoMinimo, plazoMaximo);
        actor.attemptsTo(
                Enter.theValue(String.valueOf(plazoAleatorio))
                        .into(BancolombiaSimulacionPage.PLAZO_INPUT)
        );
    }

    private int generarPlazoAleatorio(int plazoMinimo, int plazoMaximo) {
        SecureRandom random = new SecureRandom();
        if (plazoMinimo < 48)
            plazoMinimo = 48;
        if (plazoMaximo > 84)
            plazoMaximo = 84;

        return random.nextInt(plazoMaximo - plazoMinimo + 1) + plazoMinimo;
    }
}
