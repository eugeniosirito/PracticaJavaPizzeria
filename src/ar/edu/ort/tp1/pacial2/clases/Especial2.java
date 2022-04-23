package ar.edu.ort.tp1.pacial2.clases;

public class Especial2 extends Pizza {

	private static final int PRECIO_FAINA = 70;
	private TamanioDePizza tamanio;
	private int cantFaina;

	public Especial2(String nombre, float costoDeProduccion, float porcentajeGanancia, int cantFaina,
			TamanioDePizza tamanio) {
		super(nombre, costoDeProduccion, porcentajeGanancia);
		this.tamanio = tamanio;
		this.cantFaina = cantFaina;
	}

	@Override
	protected TipoPizza tipo() {

		return TipoPizza.ESPECIAL;
	}

	@Override
	protected float getPrecioDeCosto() {

		return (this.getCostoDeProduccion() * this.tamanio.getPorcentaje()) + this.cantFaina * this.PRECIO_FAINA;
	}

	@Override
	public void mostrar() {

		System.out.println(this.getClass().getSimpleName() + " - " + this.getNombre() + " - Precio de venta: $"
				+ this.getPrecioDeCosto() + " - " + this.cantFaina + " - " + this.tamanio.getDescripcion());

	}

}
