package com.bancolombia.task;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.targets.Target;

public class SeleccionarFechaNacimiento implements Task {
    private final String fechaNacimiento;
    private final Target datePicker;
    private final Target yearPicker;
    private final Target monthPicker;
    private final Target dayPicker;

    public SeleccionarFechaNacimiento(Target datePicker, Target yearPicker, Target monthPicker, Target dayPicker, String fechaNacimiento) {
        this.datePicker = datePicker;
        this.yearPicker = yearPicker;
        this.monthPicker = monthPicker;
        this.dayPicker = dayPicker;
        this.fechaNacimiento = fechaNacimiento;
    }

    public static SeleccionarFechaNacimiento enBancolombia(Target datePicker, Target yearPicker, Target monthPicker, Target dayPicker, String fechaNacimiento) {
        return new SeleccionarFechaNacimiento(datePicker, yearPicker, monthPicker, dayPicker, fechaNacimiento);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        String[] fechaParts = fechaNacimiento.split("/");
        String day = fechaParts[0];
        String month = fechaParts[1];
        String year = fechaParts[2];

        actor.attemptsTo(
                Click.on(datePicker),
                Click.on(yearPicker.of(year)),
                Click.on(monthPicker.of(month)),
                Click.on(dayPicker.of(day))
        );
    }
}