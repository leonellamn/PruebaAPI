Feature: Gestion de usuarios

  @crearUsuario
  Scenario: Crear usuario

    When creo el usuario con username "jperez", firstname "Juan", lastname "Perez"
    Then el código de respuesta es 200
    And el type es "unknown"

  @actualizarUsuario
  Scenario: Actualizo nombre de usuario
    Given consulto el usuario con nombre "jperez"
    When actualizo el usuario "jperez" con username "nuevoUsername"
    Then el código de respuesta es 200

  @actualizarUsuarioMasivo
  Scenario Outline: Actualizo nombre de usuario
    Given consulto el usuario con nombre "<usernameOld>"
    When actualizo el usuario "<usernameOld>" con username "<usernameNew>"
    Then el código de respuesta es 200
    Examples:
    |usernameOld|usernameNew|
    |prueba001  |usernameNew2 |
    |prueba002  |usernameNew3 |