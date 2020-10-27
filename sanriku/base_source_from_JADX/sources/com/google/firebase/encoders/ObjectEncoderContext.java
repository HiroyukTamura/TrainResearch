package com.google.firebase.encoders;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.io.IOException;

public interface ObjectEncoderContext {
    @NonNull
    ObjectEncoderContext add(@NonNull String str, double d) throws IOException;

    @NonNull
    ObjectEncoderContext add(@NonNull String str, int i) throws IOException;

    @NonNull
    ObjectEncoderContext add(@NonNull String str, long j) throws IOException;

    @NonNull
    ObjectEncoderContext add(@NonNull String str, @Nullable Object obj) throws IOException;

    @NonNull
    ObjectEncoderContext add(@NonNull String str, boolean z) throws IOException;

    @NonNull
    ObjectEncoderContext inline(@Nullable Object obj) throws IOException;

    @NonNull
    ObjectEncoderContext nested(@NonNull String str) throws IOException;
}
