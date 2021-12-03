Feature: Compras de productos

  @current
  Scenario Outline: Productos de mujer
    Given Ingreso al menu principal "<menuPrincipal>"
    When Agrego los productos
      | nombreProducto        | precioProducto | msgAgregado                                      |
      | Blouse                | $27.00         | Product successfully added to your shopping cart |
      | Printed Dress         | $26.00         | Product successfully added to your shopping cart |
      | Printed Chiffon Dress | $16.40         | Product successfully added to your shopping cart |
    Then El monto del carrito debería ser "<montoTotal>"
    Examples:
      | menuPrincipal | montoTotal |
      | Women         | $71.401    |

  Scenario: Productos de mujer
    Given Ingreso al menu principal "<menuPrincipal>"
    When Agrego los productos
      | nombreProducto |
      | Blouse         |
    Then El monto del carrito debería ser "<montoTotal>"