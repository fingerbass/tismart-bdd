Feature: Compras de productos

  Scenario Outline: Productos de mujer
    Given Ingreso al menu principal "<menuPrincipal>"
    When Agrego los productos
      | nombreProducto        |
      | Blouse                |
      | Printed Dress         |
      | Printed Chiffon Dress |
    Then El monto del carrito debería ser "<montoTotal>"
    Examples:
      | menuPrincipal | montoTotal |
      | Women         | 69.40      |