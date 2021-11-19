Feature: Inicio de sesión

#  Scenario: Inicio de sesión incorrecto
#    Given Digito el usuario ABC123
#    And Digito la contraseña abrakadabra
#    When Haga clic en el botón INGRESAR
#    Then El usuario no accede al sistema

  Scenario Outline: Inicio de sesión incorrecto
    Given Digito el usuario "<usuario>"
    And Digito la contraseña "<password>"
    When Haga clic en el botón INGRESAR
    Then Se visualiza el mensaje "<mensaje>"
    Examples:
      | usuario   | password  | mensaje                                         |
      | sinacceso | passwordx | Usuario o Contraseña ingresados son incorrectos |