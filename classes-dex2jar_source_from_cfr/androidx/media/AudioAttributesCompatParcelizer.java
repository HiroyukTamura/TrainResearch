/*
 * Decompiled with CFR 0.139.
 */
package androidx.media;

import androidx.media.AudioAttributesCompat;
import androidx.media.a;
import androidx.versionedparcelable.c;

public final class AudioAttributesCompatParcelizer {
    public static AudioAttributesCompat read(androidx.versionedparcelable.a a2) {
        AudioAttributesCompat audioAttributesCompat = new AudioAttributesCompat();
        audioAttributesCompat.a = a2.b(audioAttributesCompat.a, 1);
        return audioAttributesCompat;
    }

    public static void write(AudioAttributesCompat audioAttributesCompat, androidx.versionedparcelable.a a2) {
        a2.a(false, false);
        a2.a(audioAttributesCompat.a, 1);
    }
}

