# language: es
Característica: Compra de productos en Sauce Demo
  Como cliente de la tienda
  Quiero comprar dos productos
  Para completar mi pedido

  @compra_exitosa
  Escenario: Compra exitosa de dos productos
    Dado que Samuel inicia sesion en Sauce Demo
    Cuando agrega dos productos al carrito
    Y visualiza el carrito
    Entonces el carrito contiene los productos "Sauce Labs Backpack" y "Sauce Labs Bike Light"
    Cuando completa el formulario de compra con nombre "Samuel", apellido "Comprador" y codigo postal "110111"
    Y finaliza la compra
    Entonces el sistema confirma la compra con el mensaje "THANK YOU FOR YOUR ORDER"
