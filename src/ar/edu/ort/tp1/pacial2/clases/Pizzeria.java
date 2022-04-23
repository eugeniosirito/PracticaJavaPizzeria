package ar.edu.ort.tp1.pacial2.clases;

import ar.edu.ort.tp1.tdas.implementaciones.ColaNodos;
import ar.edu.ort.tp1.tdas.interfaces.Cola;
import ar.edu.ort.tp1.tdas.interfaces.ListaOrdenada;

public class Pizzeria implements Mostrable {

	private static final String MSG_PIZZA_TOPPINGS_NULO = "No se pudo fabricar Pizza o Topping nulo.";
	private static final String MSG_TOPPINGS = "Error de parámetros incorporando toppings";
	private static final String MSG_TOTALES = "La venta total fue: $%8.2f\n";
	private static final String MSG_CANTIDADES = "Se han fabricado: %d Tradicionales, %d Especiales y %d Rectangulares\n";
	private String nombre;
	private int[][] stockTopping;
	private ListaOrdenada<Float, Pizza> pizzasPorPrecio;
	private float ventaTotal;
	private Cola<String> errores;
	private int[] cantidadPizzasPorTipo;

	public Pizzeria(String nombre) {
		this.nombre = nombre;
		stockTopping = new int[TipoPizza.values().length][Topping.values().length];
		pizzasPorPrecio = new PizzasPorPrecios();
		cantidadPizzasPorTipo = new int[TipoPizza.values().length];
		errores = new ColaNodos<>();
	}

	public void incorporarTopping(TipoPizza tipoPizza, Topping topping, int cantidad) {
		if (cantidad > 0) {

			stockTopping[tipoPizza.ordinal()][topping.ordinal()] += cantidad;
		} else {
			errores.add(MSG_TOPPINGS);
		}

	}

	public void ingresarPedido(Pizza p, Topping topping) {
		validarpedido(p, topping);
		consumirTopping(p, topping);
		pizzasPorPrecio.add(p);
		cantidadPizzasPorTipo[p.tipo().ordinal()]++;
		ventaTotal += p.precioVenta();

	}

	private void validarpedido(Pizza p, Topping topping) {
		if (p == null || topping == null) {
			errores.add(MSG_PIZZA_TOPPINGS_NULO);
			throw new RuntimeException(MSG_PIZZA_TOPPINGS_NULO);
		}

	}

	private void consumirTopping(Pizza p, Topping topping) {

		if (stockTopping[p.tipo().ordinal()][topping.ordinal()] < 0) {
			errores.add("No hay toppings");
			throw new RuntimeException("No hay toppings");

		} else {
			stockTopping[p.tipo().ordinal()][topping.ordinal()]--;
		}

	}

	@Override
	public void mostrar() {
		System.out.println("------------------- Pizzeria: " + this.nombre);
		System.out.println("La venta total fue: $" + this.ventaTotal);
		System.out.printf(MSG_CANTIDADES, cantidadPizzasPorTipo[TipoPizza.TRADICIONAL.ordinal()],
				cantidadPizzasPorTipo[TipoPizza.ESPECIAL.ordinal()],
				cantidadPizzasPorTipo[TipoPizza.RECTANGULAR.ordinal()]);
		System.out.println("Pizzas fabricadas por precio");
		for (Pizza p : pizzasPorPrecio) {
			p.mostrar();

		}
		System.out.println("Pedidos con error:");
		mostrarErrores();

	}

	public void mostrarErrores() {
		String c = null;
		errores.add(c);
		String s = errores.remove();
		while (s != c) {
			System.out.println(s);
			errores.add(s);
			s = errores.remove();
		}
	}

	public float vendidasConPrecioEntre(float precioMin, float precioMax) {
		int i = 0;
		int cont = 0;

		while (i < pizzasPorPrecio.size() && pizzasPorPrecio.get(i).precioVenta() <= precioMax) {
			if (pizzasPorPrecio.get(i).precioVenta() >= precioMin) {
				cont++;
			}
			i++;

		}

		return cont;
	}

}
