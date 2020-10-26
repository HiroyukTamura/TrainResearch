/*
 * Decompiled with CFR 0.139.
 * 
 * Could not load the following classes:
 *  android.os.Build
 *  android.os.Build$VERSION
 *  android.os.Bundle
 *  android.os.IBinder
 *  android.os.Parcel
 *  android.os.Parcelable
 *  android.os.Parcelable$Creator
 *  android.os.ResultReceiver
 */
package android.support.v4.media.session;

import android.os.Build;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.ResultReceiver;
import android.support.v4.media.MediaDescriptionCompat;
import android.support.v4.media.session.b;
import android.support.v4.media.session.d;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class MediaSessionCompat {
    public static void a(Bundle bundle) {
        if (bundle != null) {
            bundle.setClassLoader(MediaSessionCompat.class.getClassLoader());
        }
    }

    public static final class QueueItem
    implements Parcelable {
        public static final Parcelable.Creator<QueueItem> CREATOR = new Parcelable.Creator<QueueItem>(){

            public QueueItem a(Parcel parcel) {
                return new QueueItem(parcel);
            }

            public QueueItem[] a(int n2) {
                return new QueueItem[n2];
            }

            public /* synthetic */ Object createFromParcel(Parcel parcel) {
                return this.a(parcel);
            }

            public /* synthetic */ Object[] newArray(int n2) {
                return this.a(n2);
            }
        };
        private final MediaDescriptionCompat a;
        private final long b;
        private Object c;

        QueueItem(Parcel parcel) {
            this.a = (MediaDescriptionCompat)MediaDescriptionCompat.CREATOR.createFromParcel(parcel);
            this.b = parcel.readLong();
        }

        private QueueItem(Object object, MediaDescriptionCompat mediaDescriptionCompat, long l2) {
            if (mediaDescriptionCompat != null) {
                if (l2 != -1L) {
                    this.a = mediaDescriptionCompat;
                    this.b = l2;
                    this.c = object;
                    return;
                }
                throw new IllegalArgumentException("Id cannot be QueueItem.UNKNOWN_ID");
            }
            throw new IllegalArgumentException("Description cannot be null.");
        }

        public static QueueItem a(Object object) {
            if (object != null && Build.VERSION.SDK_INT >= 21) {
                return new QueueItem(object, MediaDescriptionCompat.a(d.a.a(object)), d.a.b(object));
            }
            return null;
        }

        public static List<QueueItem> a(List<?> object) {
            if (object != null && Build.VERSION.SDK_INT >= 21) {
                ArrayList<QueueItem> arrayList = new ArrayList<QueueItem>();
                object = object.iterator();
                while (object.hasNext()) {
                    arrayList.add(QueueItem.a(object.next()));
                }
                return arrayList;
            }
            return null;
        }

        public int describeContents() {
            return 0;
        }

        public String toString() {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("MediaSession.QueueItem {Description=");
            stringBuilder.append(this.a);
            stringBuilder.append(", Id=");
            stringBuilder.append(this.b);
            stringBuilder.append(" }");
            return stringBuilder.toString();
        }

        public void writeToParcel(Parcel parcel, int n2) {
            this.a.writeToParcel(parcel, n2);
            parcel.writeLong(this.b);
        }

    }

    public static final class ResultReceiverWrapper
    implements Parcelable {
        public static final Parcelable.Creator<ResultReceiverWrapper> CREATOR = new Parcelable.Creator<ResultReceiverWrapper>(){

            public ResultReceiverWrapper a(Parcel parcel) {
                return new ResultReceiverWrapper(parcel);
            }

            public ResultReceiverWrapper[] a(int n2) {
                return new ResultReceiverWrapper[n2];
            }

            public /* synthetic */ Object createFromParcel(Parcel parcel) {
                return this.a(parcel);
            }

            public /* synthetic */ Object[] newArray(int n2) {
                return this.a(n2);
            }
        };
        ResultReceiver a;

        ResultReceiverWrapper(Parcel parcel) {
            this.a = (ResultReceiver)ResultReceiver.CREATOR.createFromParcel(parcel);
        }

        public int describeContents() {
            return 0;
        }

        public void writeToParcel(Parcel parcel, int n2) {
            this.a.writeToParcel(parcel, n2);
        }

    }

    public static final class Token
    implements Parcelable {
        public static final Parcelable.Creator<Token> CREATOR = new Parcelable.Creator<Token>(){

            public Token a(Parcel object) {
                object = Build.VERSION.SDK_INT >= 21 ? object.readParcelable(null) : object.readStrongBinder();
                return new Token(object);
            }

            public Token[] a(int n2) {
                return new Token[n2];
            }

            public /* synthetic */ Object createFromParcel(Parcel parcel) {
                return this.a(parcel);
            }

            public /* synthetic */ Object[] newArray(int n2) {
                return this.a(n2);
            }
        };
        private final Object a;
        private b b;
        private Bundle c;

        Token(Object object) {
            this(object, null, null);
        }

        Token(Object object, b b2, Bundle bundle) {
            this.a = object;
            this.b = b2;
            this.c = bundle;
        }

        public b a() {
            return this.b;
        }

        public void a(Bundle bundle) {
            this.c = bundle;
        }

        public void a(b b2) {
            this.b = b2;
        }

        public int describeContents() {
            return 0;
        }

        public boolean equals(Object object) {
            if (this == object) {
                return true;
            }
            if (!(object instanceof Token)) {
                return false;
            }
            object = (Token)object;
            if (this.a == null) {
                return ((Token)object).a == null;
            }
            if (((Token)object).a == null) {
                return false;
            }
            return this.a.equals(((Token)object).a);
        }

        public int hashCode() {
            if (this.a == null) {
                return 0;
            }
            return this.a.hashCode();
        }

        public void writeToParcel(Parcel parcel, int n2) {
            if (Build.VERSION.SDK_INT >= 21) {
                parcel.writeParcelable((Parcelable)this.a, n2);
                return;
            }
            parcel.writeStrongBinder((IBinder)this.a);
        }

    }

}

