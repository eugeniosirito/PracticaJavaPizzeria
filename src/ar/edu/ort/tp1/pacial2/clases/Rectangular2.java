package ar.edu.ort.tp1.pacial2.clases;

public class Rectangular2 extends Pizza {

	private static final int PRECIO_UNITARIO = 45;
	private long largo;
	private long ancho;
	private AdicionalQueso adicional;

	public Rectangular2(String nombre, float costoDeProduccion, float porcentajeGanancia, long largo, long ancho,
			AdicionalQueso adicional) {
		super(nombre, costoDeProduccion, porcentajeGanancia);
		this.largo = largo;
		this.ancho = ancho;
		this.adicional = adicional;
	}

	@Override
	protected TipoPizza tipo() {

		return TipoPizza.RECTANGULAR;
	}

	@Override
	protected float getPrecioDeCosto() {

		return (this.getCostoDeProduccion() + (largo * ancho * this.PRECIO_UNITARIO))
				* this.adicional.getMultiplicadorQueso();
	}

	@Override
	public void mostrar() {

		System.out.println(this.getClass().getSimpleName() + " - " + this.getNombre() + " - Precio de venta: $"
				+ this.getPrecioDeCosto() + " - " + (largo * ancho) + " - " + this.adicional.getDescripcion());

	}

}
