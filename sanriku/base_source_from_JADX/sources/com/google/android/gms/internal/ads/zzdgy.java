package com.google.android.gms.internal.ads;

import android.util.JsonReader;
import com.google.android.gms.common.util.IOUtils;
import com.google.android.gms.measurement.api.AppMeasurementSdk;
import java.io.Closeable;
import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import org.json.JSONException;

public final class zzdgy {
    public final List<zzdgo> zzguo;
    public final zzdgq zzgup;
    public final List<zzdgx> zzguq;

    private zzdgy(JsonReader jsonReader) throws IllegalStateException, IOException, JSONException, NumberFormatException, AssertionError {
        List<zzdgo> list;
        List<zzdgo> list2;
        ArrayList arrayList;
        List<zzdgo> emptyList = Collections.emptyList();
        ArrayList arrayList2 = new ArrayList();
        jsonReader.beginObject();
        zzdgq zzdgq = null;
        List<zzdgo> list3 = emptyList;
        while (jsonReader.hasNext()) {
            String nextName = jsonReader.nextName();
            if ("responses".equals(nextName)) {
                jsonReader.beginArray();
                jsonReader.beginObject();
                List<zzdgo> list4 = list3;
                while (jsonReader.hasNext()) {
                    String nextName2 = jsonReader.nextName();
                    if ("ad_configs".equals(nextName2)) {
                        ArrayList arrayList3 = new ArrayList();
                        jsonReader.beginArray();
                        while (jsonReader.hasNext()) {
                            arrayList3.add(new zzdgo(jsonReader));
                        }
                        jsonReader.endArray();
                        arrayList = arrayList3;
                    } else if (nextName2.equals("common")) {
                        zzdgq = new zzdgq(jsonReader);
                        arrayList = list4;
                    } else {
                        jsonReader.skipValue();
                        arrayList = list4;
                    }
                    list4 = arrayList;
                }
                jsonReader.endObject();
                list2 = list4;
            } else if (nextName.equals("actions")) {
                jsonReader.beginArray();
                while (jsonReader.hasNext()) {
                    jsonReader.beginObject();
                    String str = null;
                    Map<String, String> map = null;
                    while (jsonReader.hasNext()) {
                        String nextName3 = jsonReader.nextName();
                        if (AppMeasurementSdk.ConditionalUserProperty.NAME.equals(nextName3)) {
                            str = jsonReader.nextString();
                        } else if ("info".equals(nextName3)) {
                            map = zzayu.zzb(jsonReader);
                        } else {
                            jsonReader.skipValue();
                        }
                    }
                    if (str != null) {
                        arrayList2.add(new zzdgx(str, map));
                    }
                    jsonReader.endObject();
                }
                list2 = list3;
            } else {
                list = list3;
                list3 = list;
            }
            jsonReader.endArray();
            list = list2;
            list3 = list;
        }
        this.zzguq = arrayList2;
        this.zzguo = list3;
        this.zzgup = zzdgq == null ? new zzdgq(new JsonReader(new StringReader("{}"))) : zzdgq;
    }

    public static zzdgy zza(Reader reader) throws zzdgp {
        try {
            zzdgy zzdgy = new zzdgy(new JsonReader(reader));
            IOUtils.closeQuietly((Closeable) reader);
            return zzdgy;
        } catch (IOException | AssertionError | IllegalStateException | NumberFormatException | JSONException e) {
            throw new zzdgp("unable to parse ServerResponse", e);
        } catch (Throwable th) {
            IOUtils.closeQuietly((Closeable) reader);
            throw th;
        }
    }
}
