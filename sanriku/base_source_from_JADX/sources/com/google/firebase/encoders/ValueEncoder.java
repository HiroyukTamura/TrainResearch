package com.google.firebase.encoders;

import androidx.annotation.NonNull;
import java.io.IOException;

public interface ValueEncoder<T> extends Encoder<T, ValueEncoderContext> {
    /* synthetic */ void encode(@NonNull TValue tvalue, @NonNull TContext tcontext) throws IOException;
}
