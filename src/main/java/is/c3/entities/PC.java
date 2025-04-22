/**
 * 
 */
package is.c3.entities;

import is.c3.model.Dispositivo;

/**
 * Datos de un ordenador personal
 */
public class PC implements Dispositivo {
	public PC(String ref, String procesador, Double ram) {
		super();
		this.ref = ref;
		this.procesador = procesador;
		/**Memoria Expresada en GB**/
		this.ram = ram;
	}

	private String ref;
	private String procesador;
	private Double ram;
	@Override
	public String getRef() {
		return ref;
	}
	@Override
	public void setRef(String ref) {
		this.ref = ref;
	}
	@Override
	public String getProcesador() {
		return procesador;
	}
	@Override
	public void setProcesador(String procesador) {
		this.procesador = procesador;
	}
	@Override
	public Double getRam() {
		return ram;
	}
	@Override
	public void setRam(Double ram) {
		this.ram = ram;
	}	
	
	@Override
	public String toString() {
		String me = "\nDatos del PC:\nreferencia: "+ref+"\nprocesador: "+procesador+"\nmemoria: "+ram+" GB \n***************************************\n";
		return me;
	}
}
