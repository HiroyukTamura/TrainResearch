package com.google.firebase.crashlytics.internal.common;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.firebase.crashlytics.internal.Logger;
import java.util.Collections;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class UserMetadata {
    static final int MAX_ATTRIBUTES = 64;
    static final int MAX_ATTRIBUTE_SIZE = 1024;
    private final ConcurrentHashMap<String, String> attributes = new ConcurrentHashMap<>();
    private String userId = null;

    private static String sanitizeAttribute(String str) {
        if (str == null) {
            return str;
        }
        String trim = str.trim();
        return trim.length() > 1024 ? trim.substring(0, 1024) : trim;
    }

    @NonNull
    public Map<String, String> getCustomKeys() {
        return Collections.unmodifiableMap(this.attributes);
    }

    @Nullable
    public String getUserId() {
        return this.userId;
    }

    public void setCustomKey(String str, String str2) {
        if (str != null) {
            String sanitizeAttribute = sanitizeAttribute(str);
            if (this.attributes.size() < 64 || this.attributes.containsKey(sanitizeAttribute)) {
                this.attributes.put(sanitizeAttribute, str2 == null ? "" : sanitizeAttribute(str2));
            } else {
                Logger.getLogger().mo25712d("Exceeded maximum number of custom attributes (64)");
            }
        } else {
            throw new IllegalArgumentException("Custom attribute key must not be null.");
        }
    }

    public void setUserId(String str) {
        this.userId = sanitizeAttribute(str);
    }
}
