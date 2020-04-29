package salud.isa.gsonMedDB;

import java.io.FileNotFoundException;
import java.io.IOException;

public class GsonDatabaseClient {
	
	public GsonDatabaseClient(){
	}

	public static void main(String[] args) {
		try {
			LectorCategoriaRescueMedicinePresentation lcresmedpre = 
					new LectorCategoriaRescueMedicinePresentation(null);
			LectorCategoriaMedicine lcmed = new LectorCategoriaMedicine(lcresmedpre);
			DatabaseJSonReader dbjp = new DatabaseJSonReader(lcmed);

			try {
				System.out.println(dbjp.parse("./datos.json"));
			} finally {
			}
		} catch (FileNotFoundException e){
			e.printStackTrace();
		} catch (IOException e){
			e.printStackTrace();
		}
	}
}
