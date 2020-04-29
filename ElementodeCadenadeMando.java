package salud.isa.gsonMedDB;

import java.io.IOException;

import com.google.gson.stream.JsonReader;

public abstract class ElementodeCadenadeMando {
	protected ElementodeCadenadeMando sig;
	
	public ElementodeCadenadeMando(ElementodeCadenadeMando s) {
		sig = s;
	}
	
	public StringBuffer read(String name,JsonReader reader) throws IOException{
		return sig.read(name, reader);
	}
}
