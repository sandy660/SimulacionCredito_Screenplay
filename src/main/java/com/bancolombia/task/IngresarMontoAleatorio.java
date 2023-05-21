package com.bancolombia.task;

import com.bancolombia.userInterfaces.BancolombiaSimulacionPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Enter;

import java.security.SecureRandom;


public class IngresarMontoAleatorio implements Task {

    private final int min;
    private final int max;

    public IngresarMontoAleatorio(int min, int max) {
        this.min = min;
        this.max = max;
    }

    public static IngresarMontoAleatorio entre(int min, int max) {
        return Tasks.instrumented(IngresarMontoAleatorio.class, min, max);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        int montoAleatorio = generarMontoAleatorio(min, max);
        actor.attemptsTo(
                Enter.theValue(String.valueOf(montoAleatorio))
                        .into(BancolombiaSimulacionPage.MONTO_INPUT)
        );
    }

    private int generarMontoAleatorio(int min, int max) {
        SecureRandom random = new SecureRandom();
        return random.nextInt((max - min) + 1) + min;
    }
}
