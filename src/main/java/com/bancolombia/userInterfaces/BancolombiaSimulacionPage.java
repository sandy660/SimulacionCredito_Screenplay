package com.bancolombia.userInterfaces;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class BancolombiaSimulacionPage {

    public static final Target BUTTON_CONTINUAR = Target.the("Boton Continuar")
            .locatedBy("//*[@id=\"boton-seleccion-tarjeta\"]");
    public static final Target PREGUNTA_ELEMENT = Target.the("Pregunta Element")
            .locatedBy("//span[contains(text(), '¿Sabes cuánto dinero necesitas?')]");
    public static final Target OPCION_SI_INPUT = Target.the("Opción Sí")
            .located(By.cssSelector("mat-radio-button#opcion-si.mat-radio-button.valida-monto-opciones.mat-accent"));
    public static final Target MONTO_INPUT = Target.the("Monto Input")
            .located(By.cssSelector("input#valor-simulacion.mat-input-element"));
    public static final Target PLAZO_INPUT = Target.the("Plazo Input")
            .located(By.cssSelector("input#valor-plazo"));
    public static final Target FECHA_NACIMIENTO_INPUT = Target.the("campo de fecha de nacimiento")
            .locatedBy("//*[@id=\"campo-fecha\"]");

    public static final Target YEAR_PICKER = Target.the("selector de año")
            .locatedBy("//*[@id=\"mat-datepicker-0\"]/div/mat-multi-year-view/table/tbody/tr[2]/td[3]/div[1]");

    public static final Target MONTH_PICKER = Target.the("selector de mes")
            .locatedBy("//*[@id=\"mat-datepicker-0\"]/div/mat-year-view/table/tbody/tr[4]/td[4]/div[1]");

    public static final Target DAY_PICKER = Target.the("selector de día")
            .locatedBy("//*[@id=\"mat-datepicker-0\"]/div/mat-month-view/table/tbody/tr[4]/td[4]/div[1]");

    public static final Target BUTTON_SIMULAR = Target.the("Boton Simular")
            .locatedBy("//*[@id='boton-simular']");
    public static final Target INFORMACION_SIMULACION = Target
            .the("Información de la simulación del crédito")
            .locatedBy("//*[@id=\"layoutContainers\"]/div/div[2]/div/div[2]/section/div[3]/div[2]/app-root/div/app-resultado-simulacion/section[1]");

}