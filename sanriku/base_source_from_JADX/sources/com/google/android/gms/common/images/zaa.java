package com.google.android.gms.common.images;

import android.net.Uri;
import com.google.android.gms.common.internal.Objects;

final class zaa {
    public final Uri uri;

    public zaa(Uri uri2) {
        this.uri = uri2;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof zaa)) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        return Objects.equal(((zaa) obj).uri, this.uri);
    }

    public final int hashCode() {
        return Objects.hashCode(this.uri);
    }
}
