package controllers;

import java.util.concurrent.CompletionStage;
import java.util.stream.Collectors;

import javax.inject.Inject;

import com.fasterxml.jackson.databind.JsonNode;

import model.Construccion;
import model.Predio;
import model.Propietario;
import model.Terreno;
import persistence.CatastroRepository;
import play.libs.Json;
import play.libs.concurrent.HttpExecutionContext;
import play.mvc.Controller;
import play.mvc.Http;
import play.mvc.Result;
import utils.Util;

public class CatastroController extends Controller {
	private HttpExecutionContext ec;
	private CatastroRepository catastroRepository;

	private final String OK = "OK";
	private final String FAIL = "FAIL";

	@Inject
	public CatastroController(HttpExecutionContext ec, CatastroRepository catastroRepository) {
		this.ec = ec;
		this.catastroRepository = catastroRepository;
	}

	public Result index() {
		return ok(views.html.index.render());
	}

	/*
	 * TODO: Listar Tablas
	 */
	
	public CompletionStage<Result> listPredio() {

		return catastroRepository.listPredio().thenApplyAsync(
				construccionStream -> ok(Json.toJson(construccionStream.collect(Collectors.toList()))), ec.current());
	}

	public CompletionStage<Result> listConstruccion() {

		return catastroRepository.listContruccion().thenApplyAsync(
				construccionStream -> ok(Json.toJson(construccionStream.collect(Collectors.toList()))), ec.current());
	}

	public CompletionStage<Result> listPropietario() {

		return catastroRepository.listPropietario().thenApplyAsync(
				propietarioStream -> ok(Json.toJson(propietarioStream.collect(Collectors.toList()))), ec.current());
	}

	public CompletionStage<Result> listTerreno() {

		return catastroRepository.listTerreno().thenApplyAsync(
				terrenoStream -> ok(Json.toJson(terrenoStream.collect(Collectors.toList()))), ec.current());
	}

	/*
	 * Listar Parametros
	 */

	public CompletionStage<Result> listTipoConstruccion() {

		return catastroRepository.listTipoConstruccion().thenApplyAsync(
				terrenoStream -> ok(Json.toJson(terrenoStream.collect(Collectors.toList()))), ec.current());
	}

	public CompletionStage<Result> listTipoDocumento() {

		return catastroRepository.listTipoDocumento().thenApplyAsync(
				terrenoStream -> ok(Json.toJson(terrenoStream.collect(Collectors.toList()))), ec.current());
	}

	public CompletionStage<Result> listTipoPersona() {

		return catastroRepository.listTipoPersona().thenApplyAsync(
				terrenoStream -> ok(Json.toJson(terrenoStream.collect(Collectors.toList()))), ec.current());
	}

	public CompletionStage<Result> listTipoTerreno() {

		return catastroRepository.listTipoTerreno().thenApplyAsync(
				terrenoStream -> ok(Json.toJson(terrenoStream.collect(Collectors.toList()))), ec.current());
	}

	/*
	 *  Crear, actualizar, eliminar Construccion
	 */

	public CompletionStage<Result> createConstruccion(Http.Request request) {
		JsonNode json = request.body().asJson();

		return catastroRepository.addConstruccion(Json.fromJson(json, Construccion.class))
				.thenApplyAsync(construccionStream -> ok(Util.createResponse(OK, true)), ec.current());
	}

	public CompletionStage<Result> updateConstruccion(Http.Request request) {
		JsonNode json = request.body().asJson();

		return catastroRepository.updateConstruccion(Json.fromJson(json, Construccion.class))
				.thenApplyAsync(construccionStream -> ok(Util.createResponse(OK, true)), ec.current());
	}

	public CompletionStage<Result> deleteConstruccion(Http.Request request) {
		JsonNode json = request.body().asJson();

		return catastroRepository.deleteConstruccion(Json.fromJson(json, Construccion.class))
				.thenApplyAsync(construccionStream -> ok(Util.createResponse(OK, true)), ec.current());
	}
	
	/*
	 *  Crear, actualizar, eliminar Propietario
	 */

	public CompletionStage<Result> createPropietario(Http.Request request) {
		JsonNode json = request.body().asJson();

		return catastroRepository.createPropietario(Json.fromJson(json, Propietario.class))
				.thenApplyAsync(construccionStream -> ok(Util.createResponse(OK, true)), ec.current());
	}

	public CompletionStage<Result> updatePropietario(Http.Request request) {
		JsonNode json = request.body().asJson();

		return catastroRepository.updatePropietario(Json.fromJson(json, Propietario.class))
				.thenApplyAsync(construccionStream -> ok(Util.createResponse(OK, true)), ec.current());
	}

	public CompletionStage<Result> deletePropietario(Http.Request request) {
		JsonNode json = request.body().asJson();

		return catastroRepository.deletePropietario(Json.fromJson(json, Propietario.class))
				.thenApplyAsync(construccionStream -> ok(Util.createResponse(OK, true)), ec.current());
	}
	
	/*
	 *  Crear, actualizar, eliminar Terreno
	 */

	public CompletionStage<Result> createTerreno(Http.Request request) {
		JsonNode json = request.body().asJson();

		return catastroRepository.createTerreno(Json.fromJson(json, Terreno.class))
				.thenApplyAsync(construccionStream -> ok(Util.createResponse(OK, true)), ec.current());
	}

	public CompletionStage<Result> updateTerreno(Http.Request request) {
		JsonNode json = request.body().asJson();

		return catastroRepository.updateTerreno(Json.fromJson(json, Terreno.class))
				.thenApplyAsync(construccionStream -> ok(Util.createResponse(OK, true)), ec.current());
	}

	public CompletionStage<Result> deleteTerreno(Http.Request request) {
		JsonNode json = request.body().asJson();

		return catastroRepository.deleteTerreno(Json.fromJson(json, Terreno.class))
				.thenApplyAsync(construccionStream -> ok(Util.createResponse(OK, true)), ec.current());
	}
	
	/*
	 *  Crear, actualizar, eliminar Predio
	 */

	public CompletionStage<Result> createPredio(Http.Request request) {
		JsonNode json = request.body().asJson();

		return catastroRepository.createPredio(Json.fromJson(json, Predio.class))
				.thenApplyAsync(construccionStream -> ok(Util.createResponse(OK, true)), ec.current());
	}

	public CompletionStage<Result> updatePredio(Http.Request request) {
		JsonNode json = request.body().asJson();

		return catastroRepository.updatePredio(Json.fromJson(json, Predio.class))
				.thenApplyAsync(construccionStream -> ok(Util.createResponse(OK, true)), ec.current());
	}
	
	public CompletionStage<Result> deletePredio(Http.Request request) {
		JsonNode json = request.body().asJson();

		return catastroRepository.deletePredio(Json.fromJson(json, Predio.class))
				.thenApplyAsync(construccionStream -> ok(Util.createResponse(OK, true)), ec.current());
	}

}
