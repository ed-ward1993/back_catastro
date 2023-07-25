package persistence;

import java.util.concurrent.CompletionStage;
import java.util.stream.Stream;

import com.google.inject.ImplementedBy;

import model.Construccion;
import model.Predio;
import model.Propietario;
import model.Terreno;
import model.Tipo_construccion;
import model.Tipo_documento;
import model.Tipo_persona;
import model.Tipo_terreno;
import play.mvc.Result;

/**
 * This interface provides a non-blocking API for possibly blocking operations.
 */
@ImplementedBy(JPACatastroRepository.class)
public interface CatastroRepository {

   // CompletionStage<Prueba> add(Prueba person);
	
	/*
     *  Listar Tablas
     */

	CompletionStage<Stream<Predio>> listPredio();
	
    CompletionStage<Stream<Construccion>> listContruccion();
    
    CompletionStage<Stream<Propietario>> listPropietario();
    
    CompletionStage<Stream<Terreno>> listTerreno();
    
    /*
     * Listar Parametros
     */
    
	CompletionStage<Stream<Tipo_construccion>> listTipoConstruccion();

	CompletionStage<Stream<Tipo_documento>> listTipoDocumento();

	CompletionStage<Stream<Tipo_persona>> listTipoPersona();

	CompletionStage<Stream<Tipo_terreno>> listTipoTerreno();
    
    /*
     * Crear, actualizar, eliminar Construccion
     */
    
    CompletionStage<Stream<Construccion>> addConstruccion(Construccion construccion);
    
    CompletionStage<Stream<Construccion>> updateConstruccion(Construccion construccion);
    
    CompletionStage<Stream<Construccion>> deleteConstruccion(Construccion construccion);
    
    /*
     * Crear, actualizar, eliminar Propietario
     */

	CompletionStage<Stream<Propietario>> createPropietario(Propietario propietario);

	CompletionStage<Stream<Propietario>> updatePropietario(Propietario propietario);

	CompletionStage<Stream<Propietario>> deletePropietario(Propietario propietario);
	
	/*
     * Crear, actualizar, eliminar Terreno
     */

	CompletionStage<Stream<Terreno>> createTerreno(Terreno terreno);

	CompletionStage<Stream<Terreno>> updateTerreno(Terreno terreno);

	CompletionStage<Stream<Terreno>> deleteTerreno(Terreno terreno);
	
	
	/*
     * Crear, actualizar, eliminar Predio
     */


	CompletionStage<Stream<Predio>> createPredio(Predio predio);
	
	CompletionStage<Stream<Predio>> updatePredio(Predio predio);

	CompletionStage<Stream<Predio>> deletePredio(Predio predio);

	
    
    


    
    
}
