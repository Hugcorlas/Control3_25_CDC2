package is.c3.controller;

import is.c3.entities.PC;
import is.c3.entities.Referencias;

public class GestorTaller {
	public GestorTaller(Referencias ref) {
		super();
		this.ref = ref;
	}

	private Referencias ref;
	
	public static void main(String[] args) {
		
		// Crear una nueva instancia del gestor de referencias de dispositivos
		Referencias ref = new Referencias();
		GestorTaller gestor=new GestorTaller(ref);
		gestor.setInitialData();
		gestor.printData();	
		
	}
	private void setInitialData() {
		// Crear algunas viviendas (PCs)
				PC PC1 = new PC("63AFDE-6A99-6CD8922B6C5", "Intel(R) Core(TM) i5-1035G1 CPU @ 1.00GHz   1.19 GHz", 60.0);
				PC PC2 = new PC("93ADA6-7909-99ACB907865", "Intel® Celeron® N4500", 16.0);
				PC PC3 = new PC("99ACB9-0786-93ADA663AFD", "Intel® Core™ i5-1334U", 32.0);

				// Añadir viviendas a la inmobiliaria
				ref.save(PC1);
				ref.save(PC2);
				ref.save(PC3);
		
	}
    private void printData() {
    	System.out.println("Dispositivos registrados en el taller de TYC7650:");
		// Mostrar todas los dispositivos registrados
		System.out.println(ref.findAll());
    	
    }
}
