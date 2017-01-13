package auxiliar;

import java.util.List;

import com.google.gson.Gson;

import model.Flat;

public class FlatToJson {
	
	public static String flatObjectToJson(Flat flat){

		Gson gson = new Gson();
		String json = gson.toJson(flat);
		return json;

	}
	
	public static String flatListToJson(List<Flat> flat){

		Gson gson = new Gson();
		String json = gson.toJson(flat);
		return json;

	}	

}
