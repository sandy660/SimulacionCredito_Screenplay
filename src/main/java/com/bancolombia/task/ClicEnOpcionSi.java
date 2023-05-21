package com.bancolombia.task;

import com.bancolombia.userInterfaces.BancolombiaSimulacionPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;

public class ClicEnOpcionSi implements Task {

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Click.on(BancolombiaSimulacionPage.OPCION_SI_INPUT)
        );
    }

    public static ClicEnOpcionSi enBancolombia () {
        return Tasks.instrumented(ClicEnOpcionSi.class);
    }
}