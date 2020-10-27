package retrofit2.converter.gson;

import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.nio.charset.Charset;
import p040i.C0976G;
import p040i.C1746B;
import p042j.C2068f;
import retrofit2.Converter;

final class GsonRequestBodyConverter<T> implements Converter<T, C0976G> {
    private static final C1746B MEDIA_TYPE = C1746B.m2454a("application/json; charset=UTF-8");
    private static final Charset UTF_8 = Charset.forName("UTF-8");
    private final TypeAdapter<T> adapter;
    private final Gson gson;

    GsonRequestBodyConverter(Gson gson2, TypeAdapter<T> typeAdapter) {
        this.gson = gson2;
        this.adapter = typeAdapter;
    }

    public C0976G convert(T t) throws IOException {
        C2068f fVar = new C2068f();
        JsonWriter newJsonWriter = this.gson.newJsonWriter(new OutputStreamWriter(fVar.mo29166i(), UTF_8));
        this.adapter.write(newJsonWriter, t);
        newJsonWriter.close();
        return C0976G.create(MEDIA_TYPE, fVar.mo29169j());
    }
}
