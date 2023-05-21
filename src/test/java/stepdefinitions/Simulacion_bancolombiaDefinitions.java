package stepdefinitions;

import com.bancolombia.questions.Pregunta;
import com.bancolombia.questions.VerificarInformacionSimulacionCredito;
import com.bancolombia.task.*;
import com.bancolombia.userInterfaces.BancolombiaSimulacionPage;
import com.bancolombia.utils.ChromeWebDriver;
import io.cucumber.java.Before;
import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Dado;
import io.cucumber.java.es.Entonces;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import net.serenitybdd.screenplay.waits.WaitUntil;
import org.openqa.selenium.WebDriver;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isPresent;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.is;

public class Simulacion_bancolombiaDefinitions {
    private Actor actor;

    @Before
    public void setUp() {
        OnStage.setTheStage(new OnlineCast());
        actor = Actor.named("Sandra");
    }

    @Dado("que el cliente quiere hacer una simulacion en la pagina de Bancolombia")
    public void queElClienteQuiereHacerUnaSimulacionEnLaPaginaDeBancolombia() {
        WebDriver driver = ChromeWebDriver.getDriver();
        actor.can(BrowseTheWeb.with(driver));
        actor.attemptsTo(AbrirPaginaBancolombia.enLaPagina());
    }

    @Cuando("hace clic en continuar")
    public void haceClicEnContinuar() {
        actor.attemptsTo(ClicContinuar.enBancolombia());
    }

    @Entonces("deberia ver la pregunta {string}")
    public void deberiaVerLaPregunta(String pregunta) {
        actor.should(seeThat(Pregunta.enPantalla(), containsString(pregunta)));
    }

    @Dado("selecciona la opcion Si")
    public void seleccionaLaOpcionSi() {
        actor.attemptsTo(ClicEnOpcionSi.enBancolombia());
    }

    @Dado("ingresa un monto aleatorio entre {double} y {double}")
    public void ingresaUnMontoAleatorioEntreY(Double montoMinimo, Double montoMaximo) {
        actor.attemptsTo(IngresarMontoAleatorio.entre(montoMinimo.intValue(), montoMaximo.intValue()));
    }

    @Dado("ingresa un plazo en meses aleatorio entre {int} y {int}")
    public void ingresaUnPlazoEnMesesAleatorioEntreY(int plazoMinimo, int plazoMaximo) {
        actor.attemptsTo(IngresarPlazoAleatorio.entre(plazoMinimo, plazoMaximo));
    }

    @Dado("selecciona su fecha de nacimiento {string}")
    public void seleccionaSuFechaDeNacimiento(String fechaNacimiento) {
        actor.attemptsTo(
                WaitUntil.the(BancolombiaSimulacionPage.FECHA_NACIMIENTO_INPUT, isPresent()).forNoMoreThan(10).seconds(),
                SeleccionarFechaNacimiento.enBancolombia(
                        BancolombiaSimulacionPage.FECHA_NACIMIENTO_INPUT,
                        BancolombiaSimulacionPage.YEAR_PICKER,
                        BancolombiaSimulacionPage.MONTH_PICKER,
                        BancolombiaSimulacionPage.DAY_PICKER,
                        fechaNacimiento
                )
        );
    }

    @Cuando("hace clic en simular")
    public void haceClicEnSimular() {
        actor.attemptsTo(ClicSimular.enBancolombia());
    }

    @Entonces("deberia ver la información de la simulacion del credito")
    public void deberiaVerLaInformaciónDeLaSimulacionDelCredito() throws InterruptedException {
        // Agregar un retraso de 2 segundos antes de verificar la información
        Thread.sleep(2000);

        actor.should(
                seeThat(VerificarInformacionSimulacionCredito.visible(), is(true))
        );
    }
}