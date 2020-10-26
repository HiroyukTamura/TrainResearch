/*
 * Decompiled with CFR 0.139.
 * 
 * Could not load the following classes:
 *  android.annotation.TargetApi
 *  android.os.Bundle
 *  android.os.Parcel
 *  android.os.Parcelable
 *  android.os.Parcelable$Creator
 */
package com.mixpanel.android.b;

import android.annotation.TargetApi;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.mixpanel.android.b.j;
import com.mixpanel.android.c.f;
import java.util.concurrent.locks.ReentrantLock;

@TargetApi(value=16)
public class aa
implements Parcelable {
    public static final Parcelable.Creator<aa> CREATOR = new Parcelable.Creator<aa>(){

        public aa a(Parcel parcel) {
            Bundle bundle = new Bundle(aa.class.getClassLoader());
            bundle.readFromParcel(parcel);
            return new aa(bundle);
        }

        public aa[] a(int n2) {
            return new aa[n2];
        }

        public /* synthetic */ Object createFromParcel(Parcel parcel) {
            return this.a(parcel);
        }

        public /* synthetic */ Object[] newArray(int n2) {
            return this.a(n2);
        }
    };
    private static final ReentrantLock d = new ReentrantLock();
    private static long e = -1L;
    private static aa f = null;
    private static int g = 0;
    private static int h = -1;
    private final String a;
    private final String b;
    private final a c;

    private aa(Bundle bundle) {
        this.a = bundle.getString("com.mixpanel.android.mpmetrics.UpdateDisplayState.DISTINCT_ID_BUNDLE_KEY");
        this.b = bundle.getString("com.mixpanel.android.mpmetrics.UpdateDisplayState.TOKEN_BUNDLE_KEY");
        this.c = (a)bundle.getParcelable("com.mixpanel.android.mpmetrics.UpdateDisplayState.DISPLAYSTATE_BUNDLE_KEY");
    }

    aa(a a2, String string2, String string3) {
        this.a = string2;
        this.b = string3;
        this.c = a2;
    }

    static int a(a a2, String string2, String string3) {
        if (d.isHeldByCurrentThread()) {
            if (!aa.b()) {
                e = System.currentTimeMillis();
                f = new aa(a2, string2, string3);
                return ++g;
            }
            f.a("MixpanelAPI.UpDisplSt", "Already showing (or cooking) a Mixpanel update, declining to show another.");
            return -1;
        }
        throw new AssertionError();
    }

    static ReentrantLock a() {
        return d;
    }

    public static void a(int n2) {
        d.lock();
        try {
            if (n2 == h) {
                h = -1;
                f = null;
            }
            return;
        }
        finally {
            d.unlock();
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static aa b(int n2) {
        int n3;
        d.lock();
        if (h > 0 && (n3 = h) != n2) {
            return null;
        }
        if (f == null) {
            return null;
        }
        e = System.currentTimeMillis();
        h = n2;
        return f;
    }

    static boolean b() {
        if (d.isHeldByCurrentThread()) {
            long l2 = System.currentTimeMillis();
            long l3 = e;
            if (g > 0 && l2 - l3 > 43200000L) {
                f.c("MixpanelAPI.UpDisplSt", "UpdateDisplayState set long, long ago, without showing. Update state will be cleared.");
                f = null;
            }
            return f != null;
        }
        throw new AssertionError();
    }

    public a c() {
        return this.c;
    }

    public String d() {
        return this.b;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int n2) {
        Bundle bundle = new Bundle();
        bundle.putString("com.mixpanel.android.mpmetrics.UpdateDisplayState.DISTINCT_ID_BUNDLE_KEY", this.a);
        bundle.putString("com.mixpanel.android.mpmetrics.UpdateDisplayState.TOKEN_BUNDLE_KEY", this.b);
        bundle.putParcelable("com.mixpanel.android.mpmetrics.UpdateDisplayState.DISPLAYSTATE_BUNDLE_KEY", (Parcelable)this.c);
        parcel.writeBundle(bundle);
    }

    public static abstract class com.mixpanel.android.b.aa$a
    implements Parcelable {
        public static final Parcelable.Creator<com.mixpanel.android.b.aa$a> CREATOR = new Parcelable.Creator<com.mixpanel.android.b.aa$a>(){

            public com.mixpanel.android.b.aa$a a(Parcel object) {
                Object object2 = new Bundle(com.mixpanel.android.b.aa$a.class.getClassLoader());
                object2.readFromParcel(object);
                object = object2.getString("com.mixpanel.android.mpmetrics.UpdateDisplayState.DisplayState.STATE_TYPE_KEY");
                object2 = object2.getBundle("com.mixpanel.android.mpmetrics.UpdateDisplayState.DisplayState.STATE_IMPL_KEY");
                if ("InAppNotificationState".equals(object)) {
                    return new a((Bundle)object2);
                }
                object2 = new StringBuilder();
                ((StringBuilder)object2).append("Unrecognized display state type ");
                ((StringBuilder)object2).append((String)object);
                throw new RuntimeException(((StringBuilder)object2).toString());
            }

            public com.mixpanel.android.b.aa$a[] a(int n2) {
                return new com.mixpanel.android.b.aa$a[n2];
            }

            public /* synthetic */ Object createFromParcel(Parcel parcel) {
                return this.a(parcel);
            }

            public /* synthetic */ Object[] newArray(int n2) {
                return this.a(n2);
            }
        };

        private com.mixpanel.android.b.aa$a() {
        }

        public static final class a
        extends com.mixpanel.android.b.aa$a {
            public static final Parcelable.Creator<a> CREATOR = new Parcelable.Creator<a>(){

                public a a(Parcel parcel) {
                    Bundle bundle = new Bundle(a.class.getClassLoader());
                    bundle.readFromParcel(parcel);
                    return new a(bundle);
                }

                public a[] a(int n2) {
                    return new a[n2];
                }

                public /* synthetic */ Object createFromParcel(Parcel parcel) {
                    return this.a(parcel);
                }

                public /* synthetic */ Object[] newArray(int n2) {
                    return this.a(n2);
                }
            };
            private static String c = "com.com.mixpanel.android.mpmetrics.UpdateDisplayState.InAppNotificationState.INAPP_KEY";
            private static String d = "com.com.mixpanel.android.mpmetrics.UpdateDisplayState.InAppNotificationState.HIGHLIGHT_KEY";
            private final j a;
            private final int b;

            private a(Bundle bundle) {
                super();
                this.a = (j)bundle.getParcelable(c);
                this.b = bundle.getInt(d);
            }

            public a(j j2, int n2) {
                super();
                this.a = j2;
                this.b = n2;
            }

            public j a() {
                return this.a;
            }

            public int describeContents() {
                return 0;
            }

            public void writeToParcel(Parcel parcel, int n2) {
                Bundle bundle = new Bundle();
                bundle.putParcelable(c, (Parcelable)this.a);
                bundle.putInt(d, this.b);
                parcel.writeBundle(bundle);
            }

        }

    }

}

