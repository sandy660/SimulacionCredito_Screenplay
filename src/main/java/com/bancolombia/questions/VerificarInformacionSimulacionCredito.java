package com.bancolombia.questions;

import com.bancolombia.userInterfaces.BancolombiaSimulacionPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

public class VerificarInformacionSimulacionCredito implements Question<Boolean> {

    @Override
    public Boolean answeredBy(Actor actor) {
        return BancolombiaSimulacionPage.INFORMACION_SIMULACION.resolveFor(actor).isVisible();
    }

    public static VerificarInformacionSimulacionCredito visible() {
        return new VerificarInformacionSimulacionCredito();
    }
}