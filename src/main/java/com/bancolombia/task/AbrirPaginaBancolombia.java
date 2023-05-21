package com.bancolombia.task;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Open;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class AbrirPaginaBancolombia implements Task {
    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Open.url("https://www.bancolombia.com/personas/creditos/consumo/credito-libre-inversion/simulador-libre-inversion")
        );
    }

    public static AbrirPaginaBancolombia enLaPagina() {
        return instrumented(AbrirPaginaBancolombia.class);
    }
}