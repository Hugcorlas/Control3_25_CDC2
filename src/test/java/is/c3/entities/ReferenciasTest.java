package is.c3.entities;


import is.c3.model.Dispositivo;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

public class ReferenciasTest {

	private Referencias referencias;

	@BeforeEach
	public void setUp() {
		// Antes de cada test, creamos una nueva instancia de referencias
		referencias = new Referencias();
	}

	@Test
	public void testFindById() {
		Dispositivo PC1 = new PC("93ADA6-7909-99ACB907865", "Intel® Celeron® N4500", 16.0);
		//Debemos permitir almacenar nuevos Dispositivos (CU-00)
		referencias.save(PC1);

		// Buscamos el Dispositivo por su ID (un Dispositivo tiene que tener un identificador unívoco según la RN-02)
		// Como sólo hay uno el id debe ser 1 
		// (valor de inicio de los identificadores según las RN-01)
		//Debemos permitir localizar un Dispositivo a partir de su ID unívoco (CU-01)
		Dispositivo DispositivoEncontrado = referencias.findById(1);

		// Verificamos que la Dispositivo encontrada es la correcta
		assertNotNull(DispositivoEncontrado, "La Dispositivo debe existir en la referencias");
		assertEquals("93ADA6-7909-99ACB907865", DispositivoEncontrado.getRef(), "La referencia del dispositivo no coincide");
	}

	@Test
	public void testDeleteDispositivo() {
		Dispositivo PC1 = new PC("93ADA6-7909-99ACB907865", "Intel® Celeron® N4500", 16.0);
		//Debemos permitir almacenar nuevas Dispositivos, de una en una o en grupo (CU-00)
		referencias.save(PC1);

		//Debemos permitir borrar una Dispositivo a partir de su ID unívoco (CU-02)
		// Borramos la Dispositivo
		// Como sólo hay una el id debe ser 1 
		//(valor de inicio de los identificadores según las RN-01)

		referencias.delete(1);

		// Verificamos que la Dispositivo ha sido eliminada
		Dispositivo DispositivoEliminado = referencias.findById(1);
		assertNull(DispositivoEliminado, "El Dispositivo debería haber sido eliminado");
	}

	@Test
	public void testUpdateDispositivo() {
		PC PC1 = new PC("63AFDE-6A99-6CD8922B6C5", "Intel(R) Core(TM) i5-1035G1 CPU @ 1.00GHz   1.19 GHz", 60.0);
		referencias.save(PC1);

		// Creamos un nuevo Dispositivo para actualizar
		PC1.setRam(128.0);

		//Debemos permitir actualizar un Dispositivo a partir de su ID unívoco (CU-03)
		// Actualizamos el Dispositivo
		// Como sólo hay uno el id debe ser 1 
		//(valor de inicio de los identificadores según las RN-01)
	
		referencias.update(PC1, 1);

		// Verificamos que la Dispositivo ha sido actualizada
		Dispositivo DispositivoActualizado = referencias.findById(1);
		assertNotNull(DispositivoActualizado, "No se localiza la Dispositivo");
		assertEquals(128.0, DispositivoActualizado.getRam(),
				"La memoria del Dispositivo no ha sido actualizada");
	}

	@Test
	public void testSaveAllDispositivos() {
		
		//Debemos permitir almacenar nuevos Dispositivos, de uno en uno o en grupo (CU-00)
		// Creamos un array de Dispositivos
		PC p1 = new PC("63AFDE-6A99-6CD8922B6C5", "Intel(R) Core(TM) i5-1035G1 CPU @ 1.00GHz   1.19 GHz", 60.0);
		PC p2 = new PC("93ADA6-7909-99ACB907865", "Intel® Celeron® N4500", 16.0);
		// Guardamos todas las Dispositivos
		referencias.save(p1);
		referencias.save(p2);

		// Verificamos que las Dispositivos han sido añadidas
		List<Dispositivo> Dispositivos = referencias.findAll();
		assertEquals(2, Dispositivos.size(), "Debería haber 2 Dispositivos");
	}

}
