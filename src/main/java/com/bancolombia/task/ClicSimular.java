package com.bancolombia.task;

import com.bancolombia.userInterfaces.BancolombiaSimulacionPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;

public class ClicSimular implements Task {


    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(Click.on(BancolombiaSimulacionPage.BUTTON_SIMULAR));
    }

    public static ClicSimular enBancolombia(){

        return Tasks.instrumented(ClicSimular.class);
    }
}