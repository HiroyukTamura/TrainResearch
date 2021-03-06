/*
 * Decompiled with CFR 0.139.
 * 
 * Could not load the following classes:
 *  android.os.Binder
 *  android.os.Bundle
 *  android.os.IBinder
 *  android.os.IInterface
 *  android.os.Parcel
 *  android.os.Parcelable
 *  android.os.Parcelable$Creator
 *  android.text.TextUtils
 */
package android.support.v4.media.session;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import android.support.v4.media.MediaMetadataCompat;
import android.support.v4.media.session.MediaSessionCompat;
import android.support.v4.media.session.ParcelableVolumeInfo;
import android.support.v4.media.session.PlaybackStateCompat;
import android.text.TextUtils;
import java.util.ArrayList;
import java.util.List;

public interface a
extends IInterface {
    public void a();

    public void a(int var1);

    public void a(Bundle var1);

    public void a(MediaMetadataCompat var1);

    public void a(ParcelableVolumeInfo var1);

    public void a(PlaybackStateCompat var1);

    public void a(CharSequence var1);

    public void a(String var1, Bundle var2);

    public void a(List<MediaSessionCompat.QueueItem> var1);

    public void a(boolean var1);

    public void b();

    public void b(int var1);

    public void b(boolean var1);

    public static abstract class android.support.v4.media.session.a$a
    extends Binder
    implements android.support.v4.media.session.a {
        public android.support.v4.media.session.a$a() {
            this.attachInterface((IInterface)this, "android.support.v4.media.session.IMediaControllerCallback");
        }

        public static android.support.v4.media.session.a a(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterface = iBinder.queryLocalInterface("android.support.v4.media.session.IMediaControllerCallback");
            if (iInterface != null && iInterface instanceof android.support.v4.media.session.a) {
                return (android.support.v4.media.session.a)iInterface;
            }
            return new a(iBinder);
        }

        public IBinder asBinder() {
            return this;
        }

        public boolean onTransact(int n2, Parcel parcel, Parcel object, int n3) {
            if (n2 != 1598968902) {
                boolean bl2 = false;
                boolean bl3 = false;
                Object var9_7 = null;
                Object var10_8 = null;
                Object var11_9 = null;
                Object var12_10 = null;
                Object var7_11 = null;
                String string2 = null;
                switch (n2) {
                    default: {
                        return super.onTransact(n2, parcel, object, n3);
                    }
                    case 13: {
                        parcel.enforceInterface("android.support.v4.media.session.IMediaControllerCallback");
                        this.b();
                        return true;
                    }
                    case 12: {
                        parcel.enforceInterface("android.support.v4.media.session.IMediaControllerCallback");
                        this.b(parcel.readInt());
                        return true;
                    }
                    case 11: {
                        parcel.enforceInterface("android.support.v4.media.session.IMediaControllerCallback");
                        if (parcel.readInt() != 0) {
                            bl3 = true;
                        }
                        this.b(bl3);
                        return true;
                    }
                    case 10: {
                        parcel.enforceInterface("android.support.v4.media.session.IMediaControllerCallback");
                        bl3 = bl2;
                        if (parcel.readInt() != 0) {
                            bl3 = true;
                        }
                        this.a(bl3);
                        return true;
                    }
                    case 9: {
                        parcel.enforceInterface("android.support.v4.media.session.IMediaControllerCallback");
                        this.a(parcel.readInt());
                        return true;
                    }
                    case 8: {
                        parcel.enforceInterface("android.support.v4.media.session.IMediaControllerCallback");
                        object = string2;
                        if (parcel.readInt() != 0) {
                            object = (ParcelableVolumeInfo)ParcelableVolumeInfo.CREATOR.createFromParcel(parcel);
                        }
                        this.a((ParcelableVolumeInfo)object);
                        return true;
                    }
                    case 7: {
                        parcel.enforceInterface("android.support.v4.media.session.IMediaControllerCallback");
                        object = var9_7;
                        if (parcel.readInt() != 0) {
                            object = (Bundle)Bundle.CREATOR.createFromParcel(parcel);
                        }
                        this.a((Bundle)object);
                        return true;
                    }
                    case 6: {
                        parcel.enforceInterface("android.support.v4.media.session.IMediaControllerCallback");
                        object = var10_8;
                        if (parcel.readInt() != 0) {
                            object = (CharSequence)TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
                        }
                        this.a((CharSequence)object);
                        return true;
                    }
                    case 5: {
                        parcel.enforceInterface("android.support.v4.media.session.IMediaControllerCallback");
                        this.a((List)parcel.createTypedArrayList(MediaSessionCompat.QueueItem.CREATOR));
                        return true;
                    }
                    case 4: {
                        parcel.enforceInterface("android.support.v4.media.session.IMediaControllerCallback");
                        object = var11_9;
                        if (parcel.readInt() != 0) {
                            object = (MediaMetadataCompat)MediaMetadataCompat.CREATOR.createFromParcel(parcel);
                        }
                        this.a((MediaMetadataCompat)object);
                        return true;
                    }
                    case 3: {
                        parcel.enforceInterface("android.support.v4.media.session.IMediaControllerCallback");
                        object = var12_10;
                        if (parcel.readInt() != 0) {
                            object = (PlaybackStateCompat)PlaybackStateCompat.CREATOR.createFromParcel(parcel);
                        }
                        this.a((PlaybackStateCompat)object);
                        return true;
                    }
                    case 2: {
                        parcel.enforceInterface("android.support.v4.media.session.IMediaControllerCallback");
                        this.a();
                        return true;
                    }
                    case 1: 
                }
                parcel.enforceInterface("android.support.v4.media.session.IMediaControllerCallback");
                string2 = parcel.readString();
                object = var7_11;
                if (parcel.readInt() != 0) {
                    object = (Bundle)Bundle.CREATOR.createFromParcel(parcel);
                }
                this.a(string2, (Bundle)object);
                return true;
            }
            object.writeString("android.support.v4.media.session.IMediaControllerCallback");
            return true;
        }

        private static class a
        implements android.support.v4.media.session.a {
            private IBinder a;

            a(IBinder iBinder) {
                this.a = iBinder;
            }

            @Override
            public void a() {
                Parcel parcel = Parcel.obtain();
                try {
                    parcel.writeInterfaceToken("android.support.v4.media.session.IMediaControllerCallback");
                    this.a.transact(2, parcel, null, 1);
                    return;
                }
                finally {
                    parcel.recycle();
                }
            }

            @Override
            public void a(int n2) {
                Parcel parcel = Parcel.obtain();
                try {
                    parcel.writeInterfaceToken("android.support.v4.media.session.IMediaControllerCallback");
                    parcel.writeInt(n2);
                    this.a.transact(9, parcel, null, 1);
                    return;
                }
                finally {
                    parcel.recycle();
                }
            }

            @Override
            public void a(Bundle bundle) {
                Parcel parcel = Parcel.obtain();
                try {
                    parcel.writeInterfaceToken("android.support.v4.media.session.IMediaControllerCallback");
                    if (bundle != null) {
                        parcel.writeInt(1);
                        bundle.writeToParcel(parcel, 0);
                    } else {
                        parcel.writeInt(0);
                    }
                    this.a.transact(7, parcel, null, 1);
                    return;
                }
                finally {
                    parcel.recycle();
                }
            }

            @Override
            public void a(MediaMetadataCompat mediaMetadataCompat) {
                Parcel parcel = Parcel.obtain();
                try {
                    parcel.writeInterfaceToken("android.support.v4.media.session.IMediaControllerCallback");
                    if (mediaMetadataCompat != null) {
                        parcel.writeInt(1);
                        mediaMetadataCompat.writeToParcel(parcel, 0);
                    } else {
                        parcel.writeInt(0);
                    }
                    this.a.transact(4, parcel, null, 1);
                    return;
                }
                finally {
                    parcel.recycle();
                }
            }

            @Override
            public void a(ParcelableVolumeInfo parcelableVolumeInfo) {
                Parcel parcel = Parcel.obtain();
                try {
                    parcel.writeInterfaceToken("android.support.v4.media.session.IMediaControllerCallback");
                    if (parcelableVolumeInfo != null) {
                        parcel.writeInt(1);
                        parcelableVolumeInfo.writeToParcel(parcel, 0);
                    } else {
                        parcel.writeInt(0);
                    }
                    this.a.transact(8, parcel, null, 1);
                    return;
                }
                finally {
                    parcel.recycle();
                }
            }

            @Override
            public void a(PlaybackStateCompat playbackStateCompat) {
                Parcel parcel = Parcel.obtain();
                try {
                    parcel.writeInterfaceToken("android.support.v4.media.session.IMediaControllerCallback");
                    if (playbackStateCompat != null) {
                        parcel.writeInt(1);
                        playbackStateCompat.writeToParcel(parcel, 0);
                    } else {
                        parcel.writeInt(0);
                    }
                    this.a.transact(3, parcel, null, 1);
                    return;
                }
                finally {
                    parcel.recycle();
                }
            }

            @Override
            public void a(CharSequence charSequence) {
                Parcel parcel = Parcel.obtain();
                try {
                    parcel.writeInterfaceToken("android.support.v4.media.session.IMediaControllerCallback");
                    if (charSequence != null) {
                        parcel.writeInt(1);
                        TextUtils.writeToParcel((CharSequence)charSequence, (Parcel)parcel, (int)0);
                    } else {
                        parcel.writeInt(0);
                    }
                    this.a.transact(6, parcel, null, 1);
                    return;
                }
                finally {
                    parcel.recycle();
                }
            }

            @Override
            public void a(String string2, Bundle bundle) {
                Parcel parcel = Parcel.obtain();
                try {
                    parcel.writeInterfaceToken("android.support.v4.media.session.IMediaControllerCallback");
                    parcel.writeString(string2);
                    if (bundle != null) {
                        parcel.writeInt(1);
                        bundle.writeToParcel(parcel, 0);
                    } else {
                        parcel.writeInt(0);
                    }
                    this.a.transact(1, parcel, null, 1);
                    return;
                }
                finally {
                    parcel.recycle();
                }
            }

            @Override
            public void a(List<MediaSessionCompat.QueueItem> list) {
                Parcel parcel = Parcel.obtain();
                try {
                    parcel.writeInterfaceToken("android.support.v4.media.session.IMediaControllerCallback");
                    parcel.writeTypedList(list);
                    this.a.transact(5, parcel, null, 1);
                    return;
                }
                finally {
                    parcel.recycle();
                }
            }

            @Override
            public void a(boolean bl2) {
                RuntimeException runtimeException;
                super("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
                throw runtimeException;
            }

            public IBinder asBinder() {
                return this.a;
            }

            @Override
            public void b() {
                Parcel parcel = Parcel.obtain();
                try {
                    parcel.writeInterfaceToken("android.support.v4.media.session.IMediaControllerCallback");
                    this.a.transact(13, parcel, null, 1);
                    return;
                }
                finally {
                    parcel.recycle();
                }
            }

            @Override
            public void b(int n2) {
                Parcel parcel = Parcel.obtain();
                try {
                    parcel.writeInterfaceToken("android.support.v4.media.session.IMediaControllerCallback");
                    parcel.writeInt(n2);
                    this.a.transact(12, parcel, null, 1);
                    return;
                }
                finally {
                    parcel.recycle();
                }
            }

            @Override
            public void b(boolean bl2) {
                RuntimeException runtimeException;
                super("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
                throw runtimeException;
            }
        }

    }

}

