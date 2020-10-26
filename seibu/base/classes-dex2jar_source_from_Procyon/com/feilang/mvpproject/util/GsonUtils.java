// 
// Decompiled by Procyon v0.5.36
// 

package com.feilang.mvpproject.util;

import java.util.TreeMap;
import com.google.gson.JsonPrimitive;
import com.google.gson.JsonElement;
import com.google.gson.JsonSerializationContext;
import java.lang.reflect.Type;
import com.google.gson.JsonSerializer;
import com.google.gson.GsonBuilder;
import com.google.gson.Gson;
import java.io.IOException;
import java.io.Reader;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import android.content.Context;

public class GsonUtils
{
    public static String getJson(final String s, final Context context) {
        final StringBuilder sb = new StringBuilder();
        try {
            final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(context.getAssets().open(s)));
            while (true) {
                final String line = bufferedReader.readLine();
                if (line == null) {
                    break;
                }
                sb.append(line);
            }
        }
        catch (IOException ex) {
            ex.printStackTrace();
        }
        return sb.toString();
    }
    
    public static String toOrderedJson(final Object o) {
        final Gson gson = new Gson();
        return new GsonBuilder().registerTypeAdapter(Double.class, new JsonSerializer<Double>() {
            @Override
            public JsonElement serialize(final Double n, final Type type, final JsonSerializationContext jsonSerializationContext) {
                if (n == n.longValue()) {
                    return new JsonPrimitive(n.longValue());
                }
                return new JsonPrimitive(n);
            }
        }).create().toJson(gson.fromJson(gson.toJson(o), (Class<TreeMap<?, ?>>)TreeMap.class));
    }
}
