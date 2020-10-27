package p041io.realm;

import android.annotation.TargetApi;
import android.util.JsonReader;
import android.util.JsonToken;
import java.io.IOException;
import java.util.Date;
import java.util.Locale;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import p041io.realm.internal.OsList;
import p041io.realm.internal.android.JsonUtils;

/* renamed from: io.realm.ProxyUtils */
class ProxyUtils {
    ProxyUtils() {
    }

    @TargetApi(11)
    static <E> RealmList<E> createRealmListWithJsonStream(Class<E> cls, JsonReader jsonReader) throws IOException {
        if (jsonReader.peek() == null) {
            jsonReader.skipValue();
            return null;
        }
        jsonReader.beginArray();
        RealmList<E> realmList = new RealmList<>();
        if (cls == Boolean.class) {
            while (jsonReader.hasNext()) {
                if (jsonReader.peek() == JsonToken.NULL) {
                    jsonReader.skipValue();
                    realmList.add(null);
                } else {
                    realmList.add(Boolean.valueOf(jsonReader.nextBoolean()));
                }
            }
        } else if (cls == Float.class) {
            while (jsonReader.hasNext()) {
                if (jsonReader.peek() == JsonToken.NULL) {
                    jsonReader.skipValue();
                    realmList.add(null);
                } else {
                    realmList.add(Float.valueOf((float) jsonReader.nextDouble()));
                }
            }
        } else if (cls == Double.class) {
            while (jsonReader.hasNext()) {
                if (jsonReader.peek() == JsonToken.NULL) {
                    jsonReader.skipValue();
                    realmList.add(null);
                } else {
                    realmList.add(Double.valueOf(jsonReader.nextDouble()));
                }
            }
        } else if (cls == String.class) {
            while (jsonReader.hasNext()) {
                if (jsonReader.peek() == JsonToken.NULL) {
                    jsonReader.skipValue();
                    realmList.add(null);
                } else {
                    realmList.add(jsonReader.nextString());
                }
            }
        } else if (cls == byte[].class) {
            while (jsonReader.hasNext()) {
                if (jsonReader.peek() == JsonToken.NULL) {
                    jsonReader.skipValue();
                    realmList.add(null);
                } else {
                    realmList.add(JsonUtils.stringToBytes(jsonReader.nextString()));
                }
            }
        } else if (cls == Date.class) {
            while (jsonReader.hasNext()) {
                JsonToken peek = jsonReader.peek();
                if (peek == JsonToken.NULL) {
                    jsonReader.skipValue();
                    realmList.add(null);
                } else {
                    realmList.add(peek == JsonToken.NUMBER ? new Date(jsonReader.nextLong()) : JsonUtils.stringToDate(jsonReader.nextString()));
                }
            }
        } else if (cls == Long.class) {
            while (jsonReader.hasNext()) {
                if (jsonReader.peek() == JsonToken.NULL) {
                    jsonReader.skipValue();
                    realmList.add(null);
                } else {
                    realmList.add(Long.valueOf(jsonReader.nextLong()));
                }
            }
        } else if (cls == Integer.class) {
            while (jsonReader.hasNext()) {
                if (jsonReader.peek() == JsonToken.NULL) {
                    jsonReader.skipValue();
                    realmList.add(null);
                } else {
                    realmList.add(Integer.valueOf((int) jsonReader.nextLong()));
                }
            }
        } else if (cls == Short.class) {
            while (jsonReader.hasNext()) {
                if (jsonReader.peek() == JsonToken.NULL) {
                    jsonReader.skipValue();
                    realmList.add(null);
                } else {
                    realmList.add(Short.valueOf((short) ((int) jsonReader.nextLong())));
                }
            }
        } else if (cls == Byte.class) {
            while (jsonReader.hasNext()) {
                if (jsonReader.peek() == JsonToken.NULL) {
                    jsonReader.skipValue();
                    realmList.add(null);
                } else {
                    realmList.add(Byte.valueOf((byte) ((int) jsonReader.nextLong())));
                }
            }
        } else {
            throwWrongElementType(cls);
        }
        jsonReader.endArray();
        return realmList;
    }

    static <E> void setRealmListWithJsonObject(RealmList<E> realmList, JSONObject jSONObject, String str) throws JSONException {
        if (jSONObject.has(str)) {
            OsList osList = realmList.getOsList();
            if (jSONObject.isNull(str)) {
                osList.removeAll();
                return;
            }
            JSONArray jSONArray = jSONObject.getJSONArray(str);
            osList.removeAll();
            int length = jSONArray.length();
            Class<E> cls = realmList.clazz;
            int i = 0;
            if (cls == Boolean.class) {
                while (i < length) {
                    if (jSONArray.isNull(i)) {
                        osList.addNull();
                    } else {
                        osList.addBoolean(jSONArray.getBoolean(i));
                    }
                    i++;
                }
            } else if (cls == Float.class) {
                while (i < length) {
                    if (jSONArray.isNull(i)) {
                        osList.addNull();
                    } else {
                        osList.addFloat((float) jSONArray.getDouble(i));
                    }
                    i++;
                }
            } else if (cls == Double.class) {
                while (i < length) {
                    if (jSONArray.isNull(i)) {
                        osList.addNull();
                    } else {
                        osList.addDouble(jSONArray.getDouble(i));
                    }
                    i++;
                }
            } else if (cls == String.class) {
                while (i < length) {
                    if (jSONArray.isNull(i)) {
                        osList.addNull();
                    } else {
                        osList.addString(jSONArray.getString(i));
                    }
                    i++;
                }
            } else if (cls == byte[].class) {
                while (i < length) {
                    if (jSONArray.isNull(i)) {
                        osList.addNull();
                    } else {
                        osList.addBinary(JsonUtils.stringToBytes(jSONArray.getString(i)));
                    }
                    i++;
                }
            } else if (cls == Date.class) {
                while (i < length) {
                    if (jSONArray.isNull(i)) {
                        osList.addNull();
                    } else {
                        Object obj = jSONArray.get(i);
                        osList.addDate(obj instanceof String ? JsonUtils.stringToDate((String) obj) : new Date(jSONArray.getLong(i)));
                    }
                    i++;
                }
            } else if (cls == Long.class || cls == Integer.class || cls == Short.class || cls == Byte.class) {
                while (i < length) {
                    if (jSONArray.isNull(i)) {
                        osList.addNull();
                    } else {
                        osList.addLong(jSONArray.getLong(i));
                    }
                    i++;
                }
            } else {
                throwWrongElementType(cls);
            }
        }
    }

    private static void throwWrongElementType(Class cls) {
        throw new IllegalArgumentException(String.format(Locale.ENGLISH, "Element type '%s' is not handled.", new Object[]{cls}));
    }
}
