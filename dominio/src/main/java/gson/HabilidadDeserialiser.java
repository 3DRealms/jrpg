package gson;

import java.lang.reflect.Type;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;

import habilidad.FactoriaHabilidades;
import habilidad.Habilidad;


public class HabilidadDeserialiser implements JsonDeserializer<Habilidad>{

	@Override
	public Habilidad deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
		String nombre = json.getAsJsonObject().get("nombre").getAsString();
		String efecto = json.getAsJsonObject().get("efecto").getAsString();
		String desc = json.getAsJsonObject().get("descripcion").getAsString();
		int costo = json.getAsJsonObject().get("costo").getAsInt();
		int nivel = json.getAsJsonObject().get("nivel").getAsInt();
		int cantEfecto = json.getAsJsonObject().get("cantEfecto").getAsInt();
		int vel = json.getAsJsonObject().get("velocidad").getAsInt();
		Habilidad hab = FactoriaHabilidades.getHabilidad(nombre,efecto,desc,costo,nivel,cantEfecto,vel);
		return hab;
	}
}
