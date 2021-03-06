/*
 * Decompiled with CFR 0.139.
 * 
 * Could not load the following classes:
 *  android.graphics.Bitmap
 *  android.net.Uri
 *  android.os.Build
 *  android.os.Build$VERSION
 *  android.os.Bundle
 *  android.os.Parcel
 *  android.os.Parcelable
 *  android.os.Parcelable$Creator
 *  android.text.TextUtils
 */
package android.support.v4.media;

import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.support.v4.media.a;
import android.support.v4.media.b;
import android.support.v4.media.session.MediaSessionCompat;
import android.text.TextUtils;

public final class MediaDescriptionCompat
implements Parcelable {
    public static final Parcelable.Creator<MediaDescriptionCompat> CREATOR = new Parcelable.Creator<MediaDescriptionCompat>(){

        public MediaDescriptionCompat a(Parcel parcel) {
            if (Build.VERSION.SDK_INT < 21) {
                return new MediaDescriptionCompat(parcel);
            }
            return MediaDescriptionCompat.a(android.support.v4.media.a.a(parcel));
        }

        public MediaDescriptionCompat[] a(int n2) {
            return new MediaDescriptionCompat[n2];
        }

        public /* synthetic */ Object createFromParcel(Parcel parcel) {
            return this.a(parcel);
        }

        public /* synthetic */ Object[] newArray(int n2) {
            return this.a(n2);
        }
    };
    private final String a;
    private final CharSequence b;
    private final CharSequence c;
    private final CharSequence d;
    private final Bitmap e;
    private final Uri f;
    private final Bundle g;
    private final Uri h;
    private Object i;

    MediaDescriptionCompat(Parcel parcel) {
        this.a = parcel.readString();
        this.b = (CharSequence)TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
        this.c = (CharSequence)TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
        this.d = (CharSequence)TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
        ClassLoader classLoader = this.getClass().getClassLoader();
        this.e = (Bitmap)parcel.readParcelable(classLoader);
        this.f = (Uri)parcel.readParcelable(classLoader);
        this.g = parcel.readBundle(classLoader);
        this.h = (Uri)parcel.readParcelable(classLoader);
    }

    MediaDescriptionCompat(String string2, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, Bitmap bitmap, Uri uri, Bundle bundle, Uri uri2) {
        this.a = string2;
        this.b = charSequence;
        this.c = charSequence2;
        this.d = charSequence3;
        this.e = bitmap;
        this.f = uri;
        this.g = bundle;
        this.h = uri2;
    }

    public static MediaDescriptionCompat a(Object object) {
        Object object2;
        block8 : {
            a a2;
            Bundle bundle;
            block10 : {
                Bundle bundle2;
                block9 : {
                    bundle2 = null;
                    bundle = null;
                    object2 = bundle2;
                    if (object == null) break block8;
                    object2 = bundle2;
                    if (Build.VERSION.SDK_INT < 21) break block8;
                    a2 = new a();
                    a2.a(android.support.v4.media.a.a(object));
                    a2.a(android.support.v4.media.a.b(object));
                    a2.b(android.support.v4.media.a.c(object));
                    a2.c(android.support.v4.media.a.d(object));
                    a2.a(android.support.v4.media.a.e(object));
                    a2.a(android.support.v4.media.a.f(object));
                    bundle2 = android.support.v4.media.a.g(object);
                    if (bundle2 != null) {
                        MediaSessionCompat.a(bundle2);
                        object2 = (Uri)bundle2.getParcelable("android.support.v4.media.description.MEDIA_URI");
                    } else {
                        object2 = null;
                    }
                    if (object2 == null) break block9;
                    if (bundle2.containsKey("android.support.v4.media.description.NULL_BUNDLE_FLAG") && bundle2.size() == 2) break block10;
                    bundle2.remove("android.support.v4.media.description.MEDIA_URI");
                    bundle2.remove("android.support.v4.media.description.NULL_BUNDLE_FLAG");
                }
                bundle = bundle2;
            }
            a2.a(bundle);
            if (object2 != null) {
                a2.b((Uri)object2);
            } else if (Build.VERSION.SDK_INT >= 23) {
                a2.b(b.a(object));
            }
            object2 = a2.a();
            object2.i = object;
        }
        return object2;
    }

    public Object a() {
        if (this.i == null && Build.VERSION.SDK_INT >= 21) {
            Bundle bundle;
            Object object = a.a.a();
            a.a.a(object, this.a);
            a.a.a(object, this.b);
            a.a.b(object, this.c);
            a.a.c(object, this.d);
            a.a.a(object, this.e);
            a.a.a(object, this.f);
            Bundle bundle2 = bundle = this.g;
            if (Build.VERSION.SDK_INT < 23) {
                bundle2 = bundle;
                if (this.h != null) {
                    bundle2 = bundle;
                    if (bundle == null) {
                        bundle2 = new Bundle();
                        bundle2.putBoolean("android.support.v4.media.description.NULL_BUNDLE_FLAG", true);
                    }
                    bundle2.putParcelable("android.support.v4.media.description.MEDIA_URI", (Parcelable)this.h);
                }
            }
            a.a.a(object, bundle2);
            if (Build.VERSION.SDK_INT >= 23) {
                b.a.a(object, this.h);
            }
            this.i = a.a.a(object);
            return this.i;
        }
        return this.i;
    }

    public int describeContents() {
        return 0;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append((Object)this.b);
        stringBuilder.append(", ");
        stringBuilder.append((Object)this.c);
        stringBuilder.append(", ");
        stringBuilder.append((Object)this.d);
        return stringBuilder.toString();
    }

    public void writeToParcel(Parcel parcel, int n2) {
        if (Build.VERSION.SDK_INT < 21) {
            parcel.writeString(this.a);
            TextUtils.writeToParcel((CharSequence)this.b, (Parcel)parcel, (int)n2);
            TextUtils.writeToParcel((CharSequence)this.c, (Parcel)parcel, (int)n2);
            TextUtils.writeToParcel((CharSequence)this.d, (Parcel)parcel, (int)n2);
            parcel.writeParcelable((Parcelable)this.e, n2);
            parcel.writeParcelable((Parcelable)this.f, n2);
            parcel.writeBundle(this.g);
            parcel.writeParcelable((Parcelable)this.h, n2);
            return;
        }
        android.support.v4.media.a.a(this.a(), parcel, n2);
    }

    public static final class a {
        private String a;
        private CharSequence b;
        private CharSequence c;
        private CharSequence d;
        private Bitmap e;
        private Uri f;
        private Bundle g;
        private Uri h;

        public a a(Bitmap bitmap) {
            this.e = bitmap;
            return this;
        }

        public a a(Uri uri) {
            this.f = uri;
            return this;
        }

        public a a(Bundle bundle) {
            this.g = bundle;
            return this;
        }

        public a a(CharSequence charSequence) {
            this.b = charSequence;
            return this;
        }

        public a a(String string2) {
            this.a = string2;
            return this;
        }

        public MediaDescriptionCompat a() {
            return new MediaDescriptionCompat(this.a, this.b, this.c, this.d, this.e, this.f, this.g, this.h);
        }

        public a b(Uri uri) {
            this.h = uri;
            return this;
        }

        public a b(CharSequence charSequence) {
            this.c = charSequence;
            return this;
        }

        public a c(CharSequence charSequence) {
            this.d = charSequence;
            return this;
        }
    }

}

