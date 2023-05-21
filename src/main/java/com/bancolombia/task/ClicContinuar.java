package com.bancolombia.task;

import com.bancolombia.userInterfaces.BancolombiaSimulacionPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;

public class ClicContinuar implements Task {

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(Click.on(BancolombiaSimulacionPage.BUTTON_CONTINUAR));
    }

    public static ClicContinuar enBancolombia(){
        return Tasks.instrumented(ClicContinuar.class);
    }
}