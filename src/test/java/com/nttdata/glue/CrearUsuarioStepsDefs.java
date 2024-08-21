package com.nttdata.glue;

import com.nttdata.steps.CrearUsuario;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;
import org.junit.Assert;

public class CrearUsuarioStepsDefs {

    @Steps
    CrearUsuario crearUsuario;

    @When("creo el usuario con username {string}, firstname {string}, lastname {string}")
    public void crearUsuario(String username, String firstName, String lastName){
        crearUsuario.crearUsuario(username, firstName, lastName);
    }

    @Then("el código de respuesta es {int}")
    public void elCódigoDeRespuestaEs(int statusCode) {
       crearUsuario.validarCodigoRespuesta(statusCode);
    }

    @And("el type es {string}")
    public void elTypeEs(String type) {
      crearUsuario.validarType(type);
    }

    @Given("consulto el usuario con nombre {string}")
    public void consultoElUsuarioConNombre(String usernameOld) {
      //crearUsuario.consultoUsuario(usernameOld); ya implementado en línea inferior
        Assert.assertTrue("No existe usuario",crearUsuario.consultoUsuario(usernameOld));
    }

    @When("actualizo el usuario {string} con username {string}")
    public void actualizoElUsuarioConUsername(String usernameOld, String usernameNew) {
        crearUsuario.actualizoUserName(usernameOld,usernameNew);
    }
}
