package com.google.gson.internal.bind;

import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.TypeAdapterFactory;
import com.google.gson.internal.LinkedTreeMap;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;
import java.util.ArrayList;

public final class ObjectTypeAdapter extends TypeAdapter<Object> {
    public static final TypeAdapterFactory FACTORY = new TypeAdapterFactory() {
        public <T> TypeAdapter<T> create(Gson gson, TypeToken<T> typeToken) {
            if (typeToken.getRawType() == Object.class) {
                return new ObjectTypeAdapter(gson);
            }
            return null;
        }
    };
    private final Gson gson;

    /* renamed from: com.google.gson.internal.bind.ObjectTypeAdapter$2 */
    static /* synthetic */ class C13962 {
        static final /* synthetic */ int[] $SwitchMap$com$google$gson$stream$JsonToken;

        /* JADX WARNING: Can't wrap try/catch for region: R(14:0|1|2|3|4|5|7|8|9|11|12|13|14|(3:15|16|18)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:13:0x0026 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:15:0x002d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x000f */
        static {
            /*
                com.google.gson.stream.JsonToken[] r0 = com.google.gson.stream.JsonToken.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                $SwitchMap$com$google$gson$stream$JsonToken = r0
                com.google.gson.stream.JsonToken r1 = com.google.gson.stream.JsonToken.BEGIN_ARRAY     // Catch:{ NoSuchFieldError -> 0x000f }
                r1 = 0
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x000f }
            L_0x000f:
                int[] r0 = $SwitchMap$com$google$gson$stream$JsonToken     // Catch:{ NoSuchFieldError -> 0x0016 }
                com.google.gson.stream.JsonToken r1 = com.google.gson.stream.JsonToken.BEGIN_OBJECT     // Catch:{ NoSuchFieldError -> 0x0016 }
                r1 = 2
                r0[r1] = r1     // Catch:{ NoSuchFieldError -> 0x0016 }
            L_0x0016:
                r0 = 5
                int[] r1 = $SwitchMap$com$google$gson$stream$JsonToken     // Catch:{ NoSuchFieldError -> 0x001e }
                com.google.gson.stream.JsonToken r2 = com.google.gson.stream.JsonToken.STRING     // Catch:{ NoSuchFieldError -> 0x001e }
                r2 = 3
                r1[r0] = r2     // Catch:{ NoSuchFieldError -> 0x001e }
            L_0x001e:
                r1 = 6
                int[] r2 = $SwitchMap$com$google$gson$stream$JsonToken     // Catch:{ NoSuchFieldError -> 0x0026 }
                com.google.gson.stream.JsonToken r3 = com.google.gson.stream.JsonToken.NUMBER     // Catch:{ NoSuchFieldError -> 0x0026 }
                r3 = 4
                r2[r1] = r3     // Catch:{ NoSuchFieldError -> 0x0026 }
            L_0x0026:
                int[] r2 = $SwitchMap$com$google$gson$stream$JsonToken     // Catch:{ NoSuchFieldError -> 0x002d }
                com.google.gson.stream.JsonToken r3 = com.google.gson.stream.JsonToken.BOOLEAN     // Catch:{ NoSuchFieldError -> 0x002d }
                r3 = 7
                r2[r3] = r0     // Catch:{ NoSuchFieldError -> 0x002d }
            L_0x002d:
                int[] r0 = $SwitchMap$com$google$gson$stream$JsonToken     // Catch:{ NoSuchFieldError -> 0x0035 }
                com.google.gson.stream.JsonToken r2 = com.google.gson.stream.JsonToken.NULL     // Catch:{ NoSuchFieldError -> 0x0035 }
                r2 = 8
                r0[r2] = r1     // Catch:{ NoSuchFieldError -> 0x0035 }
            L_0x0035:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.gson.internal.bind.ObjectTypeAdapter.C13962.<clinit>():void");
        }
    }

    ObjectTypeAdapter(Gson gson2) {
        this.gson = gson2;
    }

    public Object read(JsonReader jsonReader) throws IOException {
        int ordinal = jsonReader.peek().ordinal();
        if (ordinal == 0) {
            ArrayList arrayList = new ArrayList();
            jsonReader.beginArray();
            while (jsonReader.hasNext()) {
                arrayList.add(read(jsonReader));
            }
            jsonReader.endArray();
            return arrayList;
        } else if (ordinal == 2) {
            LinkedTreeMap linkedTreeMap = new LinkedTreeMap();
            jsonReader.beginObject();
            while (jsonReader.hasNext()) {
                linkedTreeMap.put(jsonReader.nextName(), read(jsonReader));
            }
            jsonReader.endObject();
            return linkedTreeMap;
        } else if (ordinal == 5) {
            return jsonReader.nextString();
        } else {
            if (ordinal == 6) {
                return Double.valueOf(jsonReader.nextDouble());
            }
            if (ordinal == 7) {
                return Boolean.valueOf(jsonReader.nextBoolean());
            }
            if (ordinal == 8) {
                jsonReader.nextNull();
                return null;
            }
            throw new IllegalStateException();
        }
    }

    public void write(JsonWriter jsonWriter, Object obj) throws IOException {
        if (obj == null) {
            jsonWriter.nullValue();
            return;
        }
        TypeAdapter<?> adapter = this.gson.getAdapter(obj.getClass());
        if (adapter instanceof ObjectTypeAdapter) {
            jsonWriter.beginObject();
            jsonWriter.endObject();
            return;
        }
        adapter.write(jsonWriter, obj);
    }
}
