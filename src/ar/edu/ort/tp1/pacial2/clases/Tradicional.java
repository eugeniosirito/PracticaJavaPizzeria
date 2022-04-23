package ar.edu.ort.tp1.pacial2.clases;

public class Tradicional extends Pizza {

	private TipoDeMasa tipo;

	public Tradicional(String nombre, float costoDeProduccion, float porcentajeGanancia, TipoDeMasa tipo) {
		super(nombre, costoDeProduccion, porcentajeGanancia);
		this.tipo = tipo;
	}

	@Override
	protected TipoPizza tipo() {

		return TipoPizza.TRADICIONAL;
	}

	@Override
	protected float getPrecioDeCosto() {

		return this.getCostoDeProduccion() * this.tipo.getPorcentaje();
	}

	@Override
	public void mostrar() {

		System.out.println(this.getClass().getSimpleName() + " - " + this.getNombre() + " - Precio de venta: $"
				+ this.getPrecioDeCosto());

	}

}
