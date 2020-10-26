/*
 * Decompiled with CFR 0.139.
 * 
 * Could not load the following classes:
 *  android.os.Build
 *  android.os.Build$VERSION
 *  android.os.Bundle
 *  android.os.Parcel
 *  android.os.Parcelable
 *  android.os.Parcelable$Creator
 *  android.text.TextUtils
 */
package android.support.v4.media.session;

import android.os.Build;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.support.v4.media.session.MediaSessionCompat;
import android.support.v4.media.session.e;
import android.support.v4.media.session.f;
import android.text.TextUtils;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

public final class PlaybackStateCompat
implements Parcelable {
    public static final Parcelable.Creator<PlaybackStateCompat> CREATOR = new Parcelable.Creator<PlaybackStateCompat>(){

        public PlaybackStateCompat a(Parcel parcel) {
            return new PlaybackStateCompat(parcel);
        }

        public PlaybackStateCompat[] a(int n2) {
            return new PlaybackStateCompat[n2];
        }

        public /* synthetic */ Object createFromParcel(Parcel parcel) {
            return this.a(parcel);
        }

        public /* synthetic */ Object[] newArray(int n2) {
            return this.a(n2);
        }
    };
    final int a;
    final long b;
    final long c;
    final float d;
    final long e;
    final int f;
    final CharSequence g;
    final long h;
    List<CustomAction> i;
    final long j;
    final Bundle k;
    private Object l;

    PlaybackStateCompat(int n2, long l2, long l3, float f2, long l4, int n3, CharSequence charSequence, long l5, List<CustomAction> list, long l6, Bundle bundle) {
        this.a = n2;
        this.b = l2;
        this.c = l3;
        this.d = f2;
        this.e = l4;
        this.f = n3;
        this.g = charSequence;
        this.h = l5;
        this.i = new ArrayList<CustomAction>(list);
        this.j = l6;
        this.k = bundle;
    }

    PlaybackStateCompat(Parcel parcel) {
        this.a = parcel.readInt();
        this.b = parcel.readLong();
        this.d = parcel.readFloat();
        this.h = parcel.readLong();
        this.c = parcel.readLong();
        this.e = parcel.readLong();
        this.g = (CharSequence)TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
        this.i = parcel.createTypedArrayList(CustomAction.CREATOR);
        this.j = parcel.readLong();
        this.k = parcel.readBundle(MediaSessionCompat.class.getClassLoader());
        this.f = parcel.readInt();
    }

    public static PlaybackStateCompat a(Object object) {
        List<Object> list = null;
        Bundle bundle = null;
        Object object2 = list;
        if (object != null) {
            object2 = list;
            if (Build.VERSION.SDK_INT >= 21) {
                list = e.h(object);
                if (list != null) {
                    object2 = new ArrayList<Object>(list.size());
                    list = list.iterator();
                    while (list.hasNext()) {
                        object2.add((Object)CustomAction.a(list.next()));
                    }
                } else {
                    object2 = null;
                }
                if (Build.VERSION.SDK_INT >= 22) {
                    bundle = f.a(object);
                }
                object2 = new PlaybackStateCompat(e.a(object), e.b(object), e.c(object), e.d(object), e.e(object), 0, e.f(object), e.g(object), (List<CustomAction>)object2, e.i(object), bundle);
                ((PlaybackStateCompat)object2).l = object;
            }
        }
        return object2;
    }

    public int describeContents() {
        return 0;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("PlaybackState {");
        stringBuilder.append("state=");
        stringBuilder.append(this.a);
        stringBuilder.append(", position=");
        stringBuilder.append(this.b);
        stringBuilder.append(", buffered position=");
        stringBuilder.append(this.c);
        stringBuilder.append(", speed=");
        stringBuilder.append(this.d);
        stringBuilder.append(", updated=");
        stringBuilder.append(this.h);
        stringBuilder.append(", actions=");
        stringBuilder.append(this.e);
        stringBuilder.append(", error code=");
        stringBuilder.append(this.f);
        stringBuilder.append(", error message=");
        stringBuilder.append(this.g);
        stringBuilder.append(", custom actions=");
        stringBuilder.append(this.i);
        stringBuilder.append(", active item id=");
        stringBuilder.append(this.j);
        stringBuilder.append("}");
        return stringBuilder.toString();
    }

    public void writeToParcel(Parcel parcel, int n2) {
        parcel.writeInt(this.a);
        parcel.writeLong(this.b);
        parcel.writeFloat(this.d);
        parcel.writeLong(this.h);
        parcel.writeLong(this.c);
        parcel.writeLong(this.e);
        TextUtils.writeToParcel((CharSequence)this.g, (Parcel)parcel, (int)n2);
        parcel.writeTypedList(this.i);
        parcel.writeLong(this.j);
        parcel.writeBundle(this.k);
        parcel.writeInt(this.f);
    }

    public static final class CustomAction
    implements Parcelable {
        public static final Parcelable.Creator<CustomAction> CREATOR = new Parcelable.Creator<CustomAction>(){

            public CustomAction a(Parcel parcel) {
                return new CustomAction(parcel);
            }

            public CustomAction[] a(int n2) {
                return new CustomAction[n2];
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
        private final int c;
        private final Bundle d;
        private Object e;

        CustomAction(Parcel parcel) {
            this.a = parcel.readString();
            this.b = (CharSequence)TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
            this.c = parcel.readInt();
            this.d = parcel.readBundle(MediaSessionCompat.class.getClassLoader());
        }

        CustomAction(String string2, CharSequence charSequence, int n2, Bundle bundle) {
            this.a = string2;
            this.b = charSequence;
            this.c = n2;
            this.d = bundle;
        }

        public static CustomAction a(Object object) {
            if (object != null && Build.VERSION.SDK_INT >= 21) {
                CustomAction customAction = new CustomAction(e.a.a(object), e.a.b(object), e.a.c(object), e.a.d(object));
                customAction.e = object;
                return customAction;
            }
            return null;
        }

        public int describeContents() {
            return 0;
        }

        public String toString() {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Action:mName='");
            stringBuilder.append((Object)this.b);
            stringBuilder.append(", mIcon=");
            stringBuilder.append(this.c);
            stringBuilder.append(", mExtras=");
            stringBuilder.append((Object)this.d);
            return stringBuilder.toString();
        }

        public void writeToParcel(Parcel parcel, int n2) {
            parcel.writeString(this.a);
            TextUtils.writeToParcel((CharSequence)this.b, (Parcel)parcel, (int)n2);
            parcel.writeInt(this.c);
            parcel.writeBundle(this.d);
        }

    }

}

