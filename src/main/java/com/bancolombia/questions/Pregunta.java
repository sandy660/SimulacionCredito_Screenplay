package com.bancolombia.questions;

import com.bancolombia.userInterfaces.BancolombiaSimulacionPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.targets.Target;

public class Pregunta implements Question<String> {

    private final Target target;

    public static Pregunta enPantalla() {
        return new Pregunta();
    }

    public Pregunta() {
        this.target = BancolombiaSimulacionPage.PREGUNTA_ELEMENT;
    }

    @Override
    public String answeredBy(Actor actor) {
        return target.resolveFor(actor).getText();
    }
}
