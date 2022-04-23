package ar.edu.ort.tp1.pacial2.clases;

import ar.edu.ort.tp1.tdas.implementaciones.ListaOrdenadaNodos;
import ar.edu.ort.tp1.tdas.interfaces.ListaOrdenada;

public class PizzasPorPrecios extends ListaOrdenadaNodos<Float, Pizza> {

	@Override
	public int compare(Pizza dato1, Pizza dato2) {
		Float precio1 = dato1.precioVenta();
		Float precio2 = dato2.precioVenta();

		return precio1.compareTo(precio2);
	}

	@Override
	public int compareByKey(Float clave, Pizza elemento) {

		return clave.compareTo(elemento.precioVenta());
	}

}
