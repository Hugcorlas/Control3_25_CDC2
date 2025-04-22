package is.c3.entities;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;
import java.util.stream.Collectors;

import is.c3.model.GestionStock;
import is.c3.model.Dispositivo;

/**
 * Clase para gestionar las referencias de dispositivos en un taller de reparaciones
 */
public class Referencias implements GestionStock<Dispositivo> {
	private static Logger log = Logger.getLogger(Referencias.class.getName());

	private Map<Integer, Dispositivo> Dispositivos;
	private int currentId;

	public Referencias() {
		Dispositivos = new HashMap<>();
		currentId = 1;
	}

	public Map<Integer, Dispositivo> getDispositivos() {
		return Dispositivos;
	}

	@Override
	public void save(Dispositivo Dispositivo) {
		currentId++; // Incrementamos el ID para el siguiente Dispositivo
		Dispositivos.put(currentId, Dispositivo);
		log.fine("Dispositivo añadido con ID: " + currentId);		
	
	}

	@Override
	public void delete(Dispositivo Dispositivo) {
		// Buscamos el Dispositivo por su referencia
		Integer keyToRemove = null;
		for (Map.Entry<Integer, Dispositivo> entry : Dispositivos.entrySet()) {
			if (entry.getValue().equals(Dispositivo)) {
				keyToRemove = entry.getKey();
				break;
			}
		}

		if (keyToRemove != null) {
			Dispositivos.remove(keyToRemove);
			log.fine("Dispositivo eliminada con ID: " + keyToRemove);
		} else {
			log.fine("Dispositivo no encontrada.");
		}
	}

	@Override
	public Dispositivo findById(int key) {
		return Dispositivos.get(key); // Buscamos los Dispositivos por su clave (ID)
	}

	@Override
	public void update(Dispositivo Dispositivo, int key) {
		if (Dispositivos.containsKey(key)) {
			Dispositivos.put(key, Dispositivo);
			log.fine("Dispositivo actualizada con ID: " + key);
		} else {
			log.fine("Dispositivo no encontrada con ID: " + key);
		}
	}

	@Override
	public void delete(int key) {
		if (Dispositivos.remove(key) != null) {
			log.fine("Dispositivo eliminada con ID: " + key);
		} else {
			log.fine("Dispositivo no encontrada con ID: " + key);
		}
	}

	@Override
	public List<Dispositivo> findAll() {
		log.fine("Dispositivos en el taller:");
		for (Map.Entry<Integer, Dispositivo> entry : Dispositivos.entrySet()) {
			log.fine("ID: " + entry.getKey());
			log.fine(entry.getValue().toString());
			log.fine("------------");
		}
		return Dispositivos.values().stream().collect(Collectors.toList());
	}

	@Override
	public void saveAll(Dispositivo[] t) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteAll() {
		// TODO Auto-generated method stub

	}
}
