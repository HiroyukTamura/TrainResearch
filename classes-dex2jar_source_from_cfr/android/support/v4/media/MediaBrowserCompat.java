/*
 * Decompiled with CFR 0.139.
 * 
 * Could not load the following classes:
 *  android.os.Bundle
 *  android.os.Parcel
 *  android.os.Parcelable
 *  android.os.Parcelable$Creator
 *  android.util.Log
 */
package android.support.v4.media;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.support.v4.media.MediaDescriptionCompat;
import android.support.v4.media.session.MediaSessionCompat;
import android.util.Log;
import java.util.ArrayList;
import java.util.List;

public final class MediaBrowserCompat {
    static final boolean a = Log.isLoggable((String)"MediaBrowserCompat", (int)3);

    private static class CustomActionResultReceiver
    extends android.support.v4.a.b {
        private final String d;
        private final Bundle e;
        private final a f;

        @Override
        protected void a(int n2, Bundle bundle) {
            if (this.f == null) {
                return;
            }
            MediaSessionCompat.a(bundle);
            switch (n2) {
                default: {
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append("Unknown result code: ");
                    stringBuilder.append(n2);
                    stringBuilder.append(" (extras=");
                    stringBuilder.append((Object)this.e);
                    stringBuilder.append(", resultData=");
                    stringBuilder.append((Object)bundle);
                    stringBuilder.append(")");
                    Log.w((String)"MediaBrowserCompat", (String)stringBuilder.toString());
                    return;
                }
                case 1: {
                    this.f.a(this.d, this.e, bundle);
                    return;
                }
                case 0: {
                    this.f.b(this.d, this.e, bundle);
                    return;
                }
                case -1: 
            }
            this.f.c(this.d, this.e, bundle);
        }
    }

    private static class ItemReceiver
    extends android.support.v4.a.b {
        private final String d;
        private final b e;

        @Override
        protected void a(int n2, Bundle bundle) {
            MediaSessionCompat.a(bundle);
            if (n2 == 0 && bundle != null && bundle.containsKey("media_item")) {
                if ((bundle = bundle.getParcelable("media_item")) != null && !(bundle instanceof MediaItem)) {
                    this.e.a(this.d);
                    return;
                }
                this.e.a((MediaItem)bundle);
                return;
            }
            this.e.a(this.d);
        }
    }

    public static class MediaItem
    implements Parcelable {
        public static final Parcelable.Creator<MediaItem> CREATOR = new Parcelable.Creator<MediaItem>(){

            public MediaItem a(Parcel parcel) {
                return new MediaItem(parcel);
            }

            public MediaItem[] a(int n2) {
                return new MediaItem[n2];
            }

            public /* synthetic */ Object createFromParcel(Parcel parcel) {
                return this.a(parcel);
            }

            public /* synthetic */ Object[] newArray(int n2) {
                return this.a(n2);
            }
        };
        private final int a;
        private final MediaDescriptionCompat b;

        MediaItem(Parcel parcel) {
            this.a = parcel.readInt();
            this.b = (MediaDescriptionCompat)MediaDescriptionCompat.CREATOR.createFromParcel(parcel);
        }

        public int describeContents() {
            return 0;
        }

        public String toString() {
            StringBuilder stringBuilder = new StringBuilder("MediaItem{");
            stringBuilder.append("mFlags=");
            stringBuilder.append(this.a);
            stringBuilder.append(", mDescription=");
            stringBuilder.append(this.b);
            stringBuilder.append('}');
            return stringBuilder.toString();
        }

        public void writeToParcel(Parcel parcel, int n2) {
            parcel.writeInt(this.a);
            this.b.writeToParcel(parcel, n2);
        }

    }

    private static class SearchResultReceiver
    extends android.support.v4.a.b {
        private final String d;
        private final Bundle e;
        private final c f;

        @Override
        protected void a(int n2, Bundle object) {
            MediaSessionCompat.a(object);
            if (n2 == 0 && object != null && object.containsKey("search_results")) {
                Parcelable[] arrparcelable = object.getParcelableArray("search_results");
                object = null;
                if (arrparcelable != null) {
                    ArrayList<MediaItem> arrayList = new ArrayList<MediaItem>();
                    int n3 = arrparcelable.length;
                    n2 = 0;
                    do {
                        object = arrayList;
                        if (n2 >= n3) break;
                        arrayList.add((MediaItem)arrparcelable[n2]);
                        ++n2;
                    } while (true);
                }
                this.f.a(this.d, this.e, (List<MediaItem>)object);
                return;
            }
            this.f.a(this.d, this.e);
        }
    }

    public static abstract class a {
        public void a(String string2, Bundle bundle, Bundle bundle2) {
        }

        public void b(String string2, Bundle bundle, Bundle bundle2) {
        }

        public void c(String string2, Bundle bundle, Bundle bundle2) {
        }
    }

    public static abstract class b {
        public void a(MediaItem mediaItem) {
        }

        public void a(String string2) {
        }
    }

    public static abstract class c {
        public void a(String string2, Bundle bundle) {
        }

        public void a(String string2, Bundle bundle, List<MediaItem> list) {
        }
    }

}

