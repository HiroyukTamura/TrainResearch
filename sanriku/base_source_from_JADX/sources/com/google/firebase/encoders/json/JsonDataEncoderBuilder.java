package com.google.firebase.encoders.json;

import androidx.annotation.NonNull;
import com.google.firebase.encoders.DataEncoder;
import com.google.firebase.encoders.EncodingException;
import com.google.firebase.encoders.ObjectEncoder;
import com.google.firebase.encoders.ObjectEncoderContext;
import com.google.firebase.encoders.ValueEncoder;
import com.google.firebase.encoders.ValueEncoderContext;
import com.google.firebase.encoders.config.Configurator;
import com.google.firebase.encoders.config.EncoderConfig;
import java.io.IOException;
import java.io.StringWriter;
import java.io.Writer;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.TimeZone;
import p009e.p010a.p011a.p012a.C0681a;

public final class JsonDataEncoderBuilder implements EncoderConfig<JsonDataEncoderBuilder> {
    private static final ValueEncoder<Boolean> BOOLEAN_ENCODER = JsonDataEncoderBuilder$$Lambda$5.lambdaFactory$();
    private static final ObjectEncoder<Object> DEFAULT_FALLBACK_ENCODER = JsonDataEncoderBuilder$$Lambda$1.lambdaFactory$();
    private static final ValueEncoder<String> STRING_ENCODER = JsonDataEncoderBuilder$$Lambda$4.lambdaFactory$();
    private static final TimestampEncoder TIMESTAMP_ENCODER = new TimestampEncoder();
    /* access modifiers changed from: private */
    public ObjectEncoder<Object> fallbackEncoder = DEFAULT_FALLBACK_ENCODER;
    /* access modifiers changed from: private */
    public boolean ignoreNullValues = false;
    /* access modifiers changed from: private */
    public final Map<Class<?>, ObjectEncoder<?>> objectEncoders = new HashMap();
    /* access modifiers changed from: private */
    public final Map<Class<?>, ValueEncoder<?>> valueEncoders = new HashMap();

    private static final class TimestampEncoder implements ValueEncoder<Date> {
        private static final DateFormat rfc339;

        static {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'", Locale.US);
            rfc339 = simpleDateFormat;
            simpleDateFormat.setTimeZone(TimeZone.getTimeZone("UTC"));
        }

        private TimestampEncoder() {
        }

        public void encode(@NonNull Date date, @NonNull ValueEncoderContext valueEncoderContext) throws IOException {
            valueEncoderContext.add(rfc339.format(date));
        }
    }

    public JsonDataEncoderBuilder() {
        registerEncoder(String.class, (ValueEncoder) STRING_ENCODER);
        registerEncoder(Boolean.class, (ValueEncoder) BOOLEAN_ENCODER);
        registerEncoder(Date.class, (ValueEncoder) TIMESTAMP_ENCODER);
    }

    static /* synthetic */ void lambda$static$0(Object obj, ObjectEncoderContext objectEncoderContext) throws IOException {
        StringBuilder a = C0681a.m330a("Couldn't find encoder for type ");
        a.append(obj.getClass().getCanonicalName());
        throw new EncodingException(a.toString());
    }

    @NonNull
    public DataEncoder build() {
        return new DataEncoder() {
            public String encode(@NonNull Object obj) {
                StringWriter stringWriter = new StringWriter();
                try {
                    encode(obj, stringWriter);
                } catch (IOException unused) {
                }
                return stringWriter.toString();
            }

            public void encode(@NonNull Object obj, @NonNull Writer writer) throws IOException {
                JsonValueObjectEncoderContext jsonValueObjectEncoderContext = new JsonValueObjectEncoderContext(writer, JsonDataEncoderBuilder.this.objectEncoders, JsonDataEncoderBuilder.this.valueEncoders, JsonDataEncoderBuilder.this.fallbackEncoder, JsonDataEncoderBuilder.this.ignoreNullValues);
                jsonValueObjectEncoderContext.add(obj, false);
                jsonValueObjectEncoderContext.close();
            }
        };
    }

    @NonNull
    public JsonDataEncoderBuilder configureWith(@NonNull Configurator configurator) {
        configurator.configure(this);
        return this;
    }

    @NonNull
    public JsonDataEncoderBuilder ignoreNullValues(boolean z) {
        this.ignoreNullValues = z;
        return this;
    }

    @NonNull
    public <T> JsonDataEncoderBuilder registerEncoder(@NonNull Class<T> cls, @NonNull ObjectEncoder<? super T> objectEncoder) {
        this.objectEncoders.put(cls, objectEncoder);
        this.valueEncoders.remove(cls);
        return this;
    }

    @NonNull
    public <T> JsonDataEncoderBuilder registerEncoder(@NonNull Class<T> cls, @NonNull ValueEncoder<? super T> valueEncoder) {
        this.valueEncoders.put(cls, valueEncoder);
        this.objectEncoders.remove(cls);
        return this;
    }

    @NonNull
    public JsonDataEncoderBuilder registerFallbackEncoder(@NonNull ObjectEncoder<Object> objectEncoder) {
        this.fallbackEncoder = objectEncoder;
        return this;
    }
}
