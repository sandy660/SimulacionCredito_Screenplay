package runners;

import io.cucumber.junit.CucumberOptions;
import io.cucumber.junit.CucumberSerenityRunner;
import org.junit.runner.RunWith;

@RunWith(CucumberSerenityRunner.class)
@CucumberOptions(
        features = "src/test/resources/features/Simulacion_Bancolombia.feature",
        snippets = CucumberOptions.SnippetType.CAMELCASE,
        glue = "definitions"
)
public class SimulacionBancolombiaTest {
}
