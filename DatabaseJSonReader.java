package salud.isa.gsonMedDB;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import com.google.gson.stream.JsonReader;

/**
 * Created by jmalvarez on 11/5/16.
 * http://developer.android.com/intl/es/training/basics/network-ops/xml.html
 */
public class DatabaseJSonReader {
	ElementodeCadenadeMando cadenademando;
	
	public DatabaseJSonReader(ElementodeCadenadeMando cm) {
		cadenademando = cm;
	}
	
	public String parse(String jsonFileName) throws IOException {

		InputStream usersIS = new FileInputStream(new File(jsonFileName));
		JsonReader reader = new JsonReader(new InputStreamReader(usersIS, "UTF-8"));

		reader.beginObject();
		StringBuffer readData = new StringBuffer();
		while (reader.hasNext()) {
			String name = reader.nextName();
			
			readData.append(cadenademando.read(name, reader)).append("\n");
			
		}

		reader.endObject();
		reader.close();
		usersIS.close();

		return new String(readData);
	}

//	// Parses the contents of a medicine list.
//	private StringBuffer readMedicines(JsonReader reader) throws IOException {
//		StringBuffer medicineData = new StringBuffer();
//		reader.beginArray();
//		while (reader.hasNext()) {
//			reader.beginObject();
//			medicineData.append(readMedicineEntry(reader)).append("\n");
//			reader.endObject();
//		}
//		medicineData.append("\n");
//		reader.endArray();
//		return medicineData;
//	}
//	
	
//
//	// Parses the contents of a medicine.
//	private String readMedicineEntry(JsonReader reader) throws IOException {
//		// reader.require(XmlPullParser.START_TAG, ns, SINGLE_ELEMENT_TAGNAME);
//		String medName = null;
//		while (reader.hasNext()) {
//			String name = reader.nextName();
//			if (name.equals(NAME_FIELD_TAGNAME)) {
//				medName = reader.nextString();
//			} else {
//				reader.skipValue();
//			}
//		}
//
//		return medName;
//	}

	// Parses the contents of a medicine list.
//	private StringBuffer readRescueMedicinePresentations(JsonReader reader) throws IOException {
//		StringBuffer rescueMedicinePresentationData = new StringBuffer();
//		reader.beginArray();
//		while (reader.hasNext()) {
//			reader.beginObject();
//			rescueMedicinePresentationData.append(readRescueMedicinePresentationEntry(reader)).append("\n");
//			reader.endObject();
//		}
//		rescueMedicinePresentationData.append("\n");
//		reader.endArray();
//		return rescueMedicinePresentationData;
//	}
//
//	// Parses the contents of a rescue medicine presentation entry
//	private String readRescueMedicinePresentationEntry(JsonReader reader) throws IOException {
//		String medRef = null;
//		String aiRef = null;
//		String inhRef = null;
//		String dose = null;
//		while (reader.hasNext()) {
//			String name = reader.nextName();
//			if (name.equals(MEDREF_FIELD_TAGNAME)) {
//				medRef = reader.nextString();
//			} else if (name.equals(ACTINGREF_FIELD_TAGNAME)) {
//				aiRef = reader.nextString();
//			} else if (name.equals(INHREF_FIELD_TAGNAME)) {
//				StringBuffer res = new StringBuffer();
//				reader.beginArray();
//				while (reader.hasNext()) {
//					res.append(reader.nextString()).append(",");
//				}
//				reader.endArray();
//				res.deleteCharAt(res.length() - 1);
//				inhRef = new String(res);
//			} else if (name.equals(DOSE_FIELD_TAGNAME)) {
//				StringBuffer res = new StringBuffer();
//				reader.beginArray();
//				while (reader.hasNext()) {
//					res.append(reader.nextString()).append(",");
//				}
//				reader.endArray();
//				res.deleteCharAt(res.length() - 1);
//				dose = new String(res);
//			} else {
//				reader.skipValue();
//			}
//
//		}
//		return medRef + FIELD_SEPARATOR + aiRef + FIELD_SEPARATOR + inhRef + FIELD_SEPARATOR + dose;
//	}

}
