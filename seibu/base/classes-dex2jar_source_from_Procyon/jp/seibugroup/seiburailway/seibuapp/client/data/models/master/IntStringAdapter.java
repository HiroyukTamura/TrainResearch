// 
// Decompiled by Procyon v0.5.36
// 

package jp.seibugroup.seiburailway.seibuapp.client.data.models.master;

import com.google.gson.stream.JsonWriter;
import java.io.IOException;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonReader;
import com.google.gson.TypeAdapter;

public class IntStringAdapter extends TypeAdapter<Integer>
{
    @Override
    public Integer read(final JsonReader jsonReader) throws IOException {
        if (jsonReader.peek().equals(JsonToken.STRING)) {
            return Integer.parseInt(jsonReader.nextString());
        }
        return null;
    }
    
    @Override
    public void write(final JsonWriter jsonWriter, final Integer n) throws IOException {
    }
}
