package persistence;

import static java.util.concurrent.CompletableFuture.supplyAsync;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletionStage;
import java.util.function.Function;
import java.util.stream.Stream;

import javax.inject.Inject;
import javax.persistence.EntityManager;

import model.Construccion;
import model.Predio;
import model.Propietario;
import model.Terreno;
import model.Tipo_construccion;
import model.Tipo_documento;
import model.Tipo_persona;
import model.Tipo_terreno;
import play.db.jpa.JPAApi;

/**
 * Provide JPA operations running inside of a thread pool sized to the
 * connection pool
 */
public class JPACatastroRepository implements CatastroRepository {

	private final JPAApi jpaApi;
	private final DatabaseExecutionContext executionContext;

	@Inject
	public JPACatastroRepository(JPAApi jpaApi, DatabaseExecutionContext executionContext) {
		this.jpaApi = jpaApi;
		this.executionContext = executionContext;
	}

	private <T> T wrap(Function<EntityManager, T> function) {
		return jpaApi.withTransaction(function);
	}

	/*
	 * Listar Tablas
	 */

	@Override
	public CompletionStage<Stream<Predio>> listPredio() {
		return supplyAsync(() -> wrap(em -> listPredio(em)), executionContext);
	}

	private Stream<Predio> listPredio(EntityManager em) {
		List<Predio> predios = em
				.createQuery("select p from Predio p where p.estado = true", Predio.class).getResultList();
		return predios.stream();
	}

	
	@Override
	public CompletionStage<Stream<Construccion>> listContruccion() {
		return supplyAsync(() -> wrap(em -> listContruccion(em)), executionContext);
	}

	private Stream<Construccion> listContruccion(EntityManager em) {
		List<Construccion> construccion = em
				.createQuery("select p from Construccion p where p.estado = true", Construccion.class).getResultList();
		return construccion.stream();
	}

	@Override
	public CompletionStage<Stream<Propietario>> listPropietario() {
		return supplyAsync(() -> wrap(em -> listPropietario(em)), executionContext);
	}

	private Stream<Propietario> listPropietario(EntityManager em) {
		List<Propietario> propietario = em
				.createQuery("select p from Propietario p  where p.estado = true", Propietario.class).getResultList();
		return propietario.stream();
	}

	@Override
	public CompletionStage<Stream<Terreno>> listTerreno() {
		return supplyAsync(() -> wrap(em -> listTerreno(em)), executionContext);
	}

	private Stream<Terreno> listTerreno(EntityManager em) {
		List<Terreno> terreno = em.createQuery("select p from Terreno p  where p.estado = true", Terreno.class)
				.getResultList();
		return terreno.stream();
	}

	/*
	 * Listar Parametros
	 */

	@Override
	public CompletionStage<Stream<Tipo_construccion>> listTipoConstruccion() {
		return supplyAsync(() -> wrap(em -> listTipoConstruccion(em)), executionContext);
	}

	private Stream<Tipo_construccion> listTipoConstruccion(EntityManager em) {
		List<Tipo_construccion> tipo_construccions = em
				.createQuery("select p from Tipo_construccion p where p.estado = true", Tipo_construccion.class)
				.getResultList();
		return tipo_construccions.stream();
	}

	@Override
	public CompletionStage<Stream<Tipo_documento>> listTipoDocumento() {
		return supplyAsync(() -> wrap(em -> listTipoDocumento(em)), executionContext);
	}

	private Stream<Tipo_documento> listTipoDocumento(EntityManager em) {
		List<Tipo_documento> tipo_documentos = em
				.createQuery("select p from Tipo_documento p where p.estado = true", Tipo_documento.class)
				.getResultList();
		return tipo_documentos.stream();
	}

	@Override
	public CompletionStage<Stream<Tipo_persona>> listTipoPersona() {
		return supplyAsync(() -> wrap(em -> listTipoPersona(em)), executionContext);
	}

	private Stream<Tipo_persona> listTipoPersona(EntityManager em) {
		List<Tipo_persona> tipo_personas = em
				.createQuery("select p from Tipo_persona p where p.estado = true", Tipo_persona.class).getResultList();
		return tipo_personas.stream();
	}

	@Override
	public CompletionStage<Stream<Tipo_terreno>> listTipoTerreno() {
		return supplyAsync(() -> wrap(em -> listTipoTerreno(em)), executionContext);
	}

	private Stream<Tipo_terreno> listTipoTerreno(EntityManager em) {
		List<Tipo_terreno> tipo_terrenos = em
				.createQuery("select p from Tipo_terreno p where p.estado = true", Tipo_terreno.class).getResultList();
		return tipo_terrenos.stream();
	}

	/*
	 * Crear, actualizar, eliminar Construccion
	 */

	@Override
	public CompletionStage<Stream<Construccion>> addConstruccion(Construccion construccion) {
		return supplyAsync(() -> wrap(em -> addConstruccion(em, construccion)), executionContext);

	}

	private Stream<Construccion> addConstruccion(EntityManager em, Construccion construccion) {
		em.persist(construccion);
		List<Construccion> construccionResult = new ArrayList<Construccion>();
		construccionResult.add(construccion);
		return construccionResult.stream();
	}

	@Override
	public CompletionStage<Stream<Construccion>> updateConstruccion(Construccion construccion) {
		return supplyAsync(() -> wrap(em -> updateConstruccion(em, construccion)), executionContext);
	}

	private Stream<Construccion> updateConstruccion(EntityManager em, Construccion construccion) {
		em.merge(construccion);
		List<Construccion> construccionResult = new ArrayList<Construccion>();
		construccionResult.add(construccion);
		return construccionResult.stream();
	}

	@Override
	public CompletionStage<Stream<Construccion>> deleteConstruccion(Construccion construccion) {
		return supplyAsync(() -> wrap(em -> deleteConstruccion(em, construccion)), executionContext);
	}

	private Stream<Construccion> deleteConstruccion(EntityManager em, Construccion construccion) {
		construccion.setEstado(Boolean.FALSE.booleanValue());
		em.merge(construccion);
		List<Construccion> construccionResult = new ArrayList<Construccion>();
		construccionResult.add(construccion);
		return construccionResult.stream();
	}

	/*
	 * Crear, actualizar, eliminar Propietario
	 */

	@Override
	public CompletionStage<Stream<Propietario>> createPropietario(Propietario propietario) {
		return supplyAsync(() -> wrap(em -> addPropietario(em, propietario)), executionContext);
	}

	private Stream<Propietario> addPropietario(EntityManager em, Propietario propietario) {
		em.persist(propietario);
		List<Propietario> propietarios = new ArrayList<Propietario>();
		propietarios.add(propietario);
		return propietarios.stream();
	}

	@Override
	public CompletionStage<Stream<Propietario>> updatePropietario(Propietario propietario) {
		return supplyAsync(() -> wrap(em -> updatePropietario(em, propietario)), executionContext);
	}

	private Stream<Propietario> updatePropietario(EntityManager em, Propietario propietario) {
		em.merge(propietario);
		List<Propietario> propietarios = new ArrayList<Propietario>();
		propietarios.add(propietario);
		return propietarios.stream();
	}

	@Override
	public CompletionStage<Stream<Propietario>> deletePropietario(Propietario propietario) {
		return supplyAsync(() -> wrap(em -> deletePropietario(em, propietario)), executionContext);
	}

	private Stream<Propietario> deletePropietario(EntityManager em, Propietario propietario) {
		propietario.setEstado(Boolean.FALSE.booleanValue());
		em.merge(propietario);
		List<Propietario> propietarios = new ArrayList<Propietario>();
		propietarios.add(propietario);
		return propietarios.stream();
	}

	/*
	 * Crear, actualizar, eliminar Terreno
	 */

	@Override
	public CompletionStage<Stream<Terreno>> createTerreno(Terreno terreno) {
		return supplyAsync(() -> wrap(em -> createTerreno(em, terreno)), executionContext);
	}

	private Stream<Terreno> createTerreno(EntityManager em, Terreno terreno) {
		em.persist(terreno);
		List<Terreno> terrenos = new ArrayList<Terreno>();
		terrenos.add(terreno);
		return terrenos.stream();
	}

	@Override
	public CompletionStage<Stream<Terreno>> updateTerreno(Terreno terreno) {
		return supplyAsync(() -> wrap(em -> updateTerreno(em, terreno)), executionContext);
	}

	private Stream<Terreno> updateTerreno(EntityManager em, Terreno terreno) {
		em.merge(terreno);
		List<Terreno> terrenos = new ArrayList<Terreno>();
		terrenos.add(terreno);
		return terrenos.stream();
	}

	@Override
	public CompletionStage<Stream<Terreno>> deleteTerreno(Terreno terreno) {
		return supplyAsync(() -> wrap(em -> deleteTerreno(em, terreno)), executionContext);
	}

	private Stream<Terreno> deleteTerreno(EntityManager em, Terreno terreno) {
		terreno.setEstado(Boolean.FALSE.booleanValue());
		em.merge(terreno);
		List<Terreno> terrenos = new ArrayList<Terreno>();
		terrenos.add(terreno);
		return terrenos.stream();
	}
	
	/*
	 * Crear, actualizar, eliminar Predio
	 */

	@Override
	public CompletionStage<Stream<Predio>> updatePredio(Predio predio) {
		return supplyAsync(() -> wrap(em -> updatePredio(em, predio)), executionContext);
	}

	private Stream<Predio> updatePredio(EntityManager em, Predio predio) {
		em.merge(predio);
		List<Predio> predios = new ArrayList<Predio>();
		predios.add(predio);
		return predios.stream();
	}

	@Override
	public CompletionStage<Stream<Predio>> createPredio(Predio predio) {
		return supplyAsync(() -> wrap(em -> createPredio(em, predio)), executionContext);
	}

	private Stream<Predio> createPredio(EntityManager em, Predio predio) {
		em.persist(predio);
		List<Predio> predios = new ArrayList<Predio>();
		predios.add(predio);
		return predios.stream();
	}

	@Override
	public CompletionStage<Stream<Predio>> deletePredio(Predio predio) {
		return supplyAsync(() -> wrap(em -> deletePredio(em, predio)), executionContext);
	}

	private Stream<Predio> deletePredio(EntityManager em, Predio predio) {
		predio.setEstado(Boolean.FALSE.booleanValue());
		em.merge(predio);
		List<Predio> predios= new ArrayList<Predio>();
		predios.add(predio);
		return predios.stream();
	}
	


}
