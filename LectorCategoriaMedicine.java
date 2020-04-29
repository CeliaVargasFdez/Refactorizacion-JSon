package salud.isa.gsonMedDB;

import java.io.IOException;

import com.google.gson.stream.JsonReader;

public class LectorCategoriaMedicine extends ElementodeCadenadeMando{
	
	private static final String MEDICINES_TAGNAME = "medicines";
	private static final String NAME_FIELD_TAGNAME = "name";

	public LectorCategoriaMedicine (ElementodeCadenadeMando s) {
		super(s);
	}
	
	public StringBuffer read (String name, JsonReader reader) throws IOException{
		if (name.equals(MEDICINES_TAGNAME)) {
			return readMedicines(reader);
		}
		else {
			if (sig != null) {
				return super.read(name, reader);
			}
			else {
				reader.skipValue();
				System.err.println("Category " + name + " not processed.");
				return new StringBuffer("");	
			}
		}
	}
	
	public StringBuffer readMedicines(JsonReader reader) throws IOException {
		StringBuffer medicineData = new StringBuffer();
		reader.beginArray();
		while (reader.hasNext()) {
			reader.beginObject();
			medicineData.append(readMedicinesEntry(reader)).append("\n");
			reader.endObject();
		}
		medicineData.append("\n");
		reader.endArray();
		return medicineData;
	}
	
	public String readMedicinesEntry(JsonReader reader) throws IOException{
		String medName = null;
		while (reader.hasNext()) {
			String name = reader.nextName();
			if (name.equals(NAME_FIELD_TAGNAME)) {
				medName = reader.nextString();
			} else {
				reader.skipValue();
			}
		}

		return medName;
	}
	
	
}
