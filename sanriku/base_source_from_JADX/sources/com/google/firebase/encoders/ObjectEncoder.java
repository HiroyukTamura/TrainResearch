package com.google.firebase.encoders;

import androidx.annotation.NonNull;
import java.io.IOException;

public interface ObjectEncoder<T> extends Encoder<T, ObjectEncoderContext> {
    /* synthetic */ void encode(@NonNull TValue tvalue, @NonNull TContext tcontext) throws IOException;
}
