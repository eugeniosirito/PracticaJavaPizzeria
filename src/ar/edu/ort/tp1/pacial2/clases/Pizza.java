package ar.edu.ort.tp1.pacial2.clases;

public abstract class Pizza implements Mostrable {



	private static final String MSG_GANANCIA_INVALIDA = "Ganancia inválida";
	private static final String MSG_COSTO_INVALIDO = "Costo inválido";
	private static final String MSG_NOMBRE_INVALIDO = "Nombre inválido";
	private String nombre;
	private float costoDeProduccion;
	private float porcentajeGanancia;

	public Pizza(String nombre, float costoDeProduccion, float porcentajeGanancia) {
		super();
		setNombre(nombre);
		setPorcentajeGanancia(porcentajeGanancia);
		setCostoDeProduccion(costoDeProduccion);
	}

	private void setNombre(String nombre) {
		if (nombre == null || nombre.isEmpty()) {
			throw new RuntimeException(MSG_NOMBRE_INVALIDO);
		}

		this.nombre = nombre;
	}

	private void setCostoDeProduccion(float costoDeProduccion) {
		if (costoDeProduccion <= 0) {
			throw new RuntimeException(MSG_COSTO_INVALIDO);
		}

		this.costoDeProduccion = costoDeProduccion;
	}

	private void setPorcentajeGanancia(float porcentajeGanancia) {
		if (porcentajeGanancia < 0) {
			throw new RuntimeException(MSG_GANANCIA_INVALIDA);
		}

		this.porcentajeGanancia = porcentajeGanancia;
	}
	
	protected float getCostoDeProduccion() {
		return costoDeProduccion;
	}
	
	

	protected String getNombre() {
		return nombre;
	}

	protected abstract TipoPizza tipo();
	
	protected abstract float getPrecioDeCosto();
	
	public float precioVenta() {
		
		return this.getPrecioDeCosto() * (1+this.porcentajeGanancia/100);
	}
	
	
	


}
