package is.c3.model;

import java.util.List;

/**
 * Interfaz genérica para la gestión del strock de productos del tipo T
 * 
 * @param <T> tipo de producto gestionado
 */
public interface GestionStock<T> {
	/**
	 * Operación de lectura Devuelve la entidad de tipo T correspondiente al
	 * identificador pasado como parámetro
	 * 
	 * @param primaryKey identificador unívoco de la entidad buscada
	 * @return el objeto correspondiente al id, encapsulado en un objeto Optional
	 *         (facilita la gestión de la respuesta cuando no se ha encontrado la
	 *         entidad en el repositorio de persistencia)
	 */

	T findById(int key);

	/**
	 * Operación de lectura Encuentra todas las entidades de tipo T del repositorio
	 * 
	 * @return todas las entidades del tipo T encontradas en el repositorio de
	 *         persistencia
	 */
	List<T> findAll();

	/**
	 * Operación de escritura Almacena en el listado la entidad, de tipo T, pasada
	 * como parámetro
	 * 
	 * @param t entidad a persistir
	 */
	void save(T t);

	/**
	 * Operación de escritura, actualiza la entidad pasada como parámetro
	 * 
	 * @param t entidad a modificar
	 * 
	 */
	void update(T t, int key);

	/**
	 * Operación de borrado Elimina del listado la entidad pasada como parámetro
	 * 
	 * @param t entidad a eliminar
	 */
	void delete(T t);

	/**
	 * Operación de borrado Elimina del listado la entidad cuyo identificador
	 * unívoco corresponde con el parámetro
	 * 
	 * @param id identificador unívoco de la entidad a borrar
	 */
	void delete(int key);

	/**
	 * Operación de guardado Añade varios T a la vez, a través de un array
	 * 
	 * @param t array de objetos T
	 */
	void saveAll(T[] t);

	/**
	 * Operación de borrado Elimina todos los objetos del listado
	 */
	void deleteAll();

}
