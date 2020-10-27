package com.google.android.gms.dynamic;

import android.content.Intent;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;
import com.google.android.gms.internal.common.zzb;
import com.google.android.gms.internal.common.zzd;
import p009e.p010a.p011a.p012a.C0681a;

public interface IFragmentWrapper extends IInterface {

    public static abstract class Stub extends com.google.android.gms.internal.common.zza implements IFragmentWrapper {

        public static class zza extends zzb implements IFragmentWrapper {
            zza(IBinder iBinder) {
                super(iBinder, "com.google.android.gms.dynamic.IFragmentWrapper");
            }

            public final Bundle getArguments() throws RemoteException {
                Parcel zza = zza(3, zza());
                Bundle bundle = (Bundle) zzd.zza(zza, Bundle.CREATOR);
                zza.recycle();
                return bundle;
            }

            public final int getId() throws RemoteException {
                Parcel zza = zza(4, zza());
                int readInt = zza.readInt();
                zza.recycle();
                return readInt;
            }

            public final boolean getRetainInstance() throws RemoteException {
                Parcel zza = zza(7, zza());
                boolean zza2 = zzd.zza(zza);
                zza.recycle();
                return zza2;
            }

            public final String getTag() throws RemoteException {
                Parcel zza = zza(8, zza());
                String readString = zza.readString();
                zza.recycle();
                return readString;
            }

            public final int getTargetRequestCode() throws RemoteException {
                Parcel zza = zza(10, zza());
                int readInt = zza.readInt();
                zza.recycle();
                return readInt;
            }

            public final boolean getUserVisibleHint() throws RemoteException {
                Parcel zza = zza(11, zza());
                boolean zza2 = zzd.zza(zza);
                zza.recycle();
                return zza2;
            }

            public final boolean isAdded() throws RemoteException {
                Parcel zza = zza(13, zza());
                boolean zza2 = zzd.zza(zza);
                zza.recycle();
                return zza2;
            }

            public final boolean isDetached() throws RemoteException {
                Parcel zza = zza(14, zza());
                boolean zza2 = zzd.zza(zza);
                zza.recycle();
                return zza2;
            }

            public final boolean isHidden() throws RemoteException {
                Parcel zza = zza(15, zza());
                boolean zza2 = zzd.zza(zza);
                zza.recycle();
                return zza2;
            }

            public final boolean isInLayout() throws RemoteException {
                Parcel zza = zza(16, zza());
                boolean zza2 = zzd.zza(zza);
                zza.recycle();
                return zza2;
            }

            public final boolean isRemoving() throws RemoteException {
                Parcel zza = zza(17, zza());
                boolean zza2 = zzd.zza(zza);
                zza.recycle();
                return zza2;
            }

            public final boolean isResumed() throws RemoteException {
                Parcel zza = zza(18, zza());
                boolean zza2 = zzd.zza(zza);
                zza.recycle();
                return zza2;
            }

            public final boolean isVisible() throws RemoteException {
                Parcel zza = zza(19, zza());
                boolean zza2 = zzd.zza(zza);
                zza.recycle();
                return zza2;
            }

            public final void setHasOptionsMenu(boolean z) throws RemoteException {
                Parcel zza = zza();
                zzd.writeBoolean(zza, z);
                zzb(21, zza);
            }

            public final void setMenuVisibility(boolean z) throws RemoteException {
                Parcel zza = zza();
                zzd.writeBoolean(zza, z);
                zzb(22, zza);
            }

            public final void setRetainInstance(boolean z) throws RemoteException {
                Parcel zza = zza();
                zzd.writeBoolean(zza, z);
                zzb(23, zza);
            }

            public final void setUserVisibleHint(boolean z) throws RemoteException {
                Parcel zza = zza();
                zzd.writeBoolean(zza, z);
                zzb(24, zza);
            }

            public final void startActivity(Intent intent) throws RemoteException {
                Parcel zza = zza();
                zzd.zza(zza, (Parcelable) intent);
                zzb(25, zza);
            }

            public final void startActivityForResult(Intent intent, int i) throws RemoteException {
                Parcel zza = zza();
                zzd.zza(zza, (Parcelable) intent);
                zza.writeInt(i);
                zzb(26, zza);
            }

            public final void zza(IObjectWrapper iObjectWrapper) throws RemoteException {
                Parcel zza = zza();
                zzd.zza(zza, (IInterface) iObjectWrapper);
                zzb(20, zza);
            }

            public final IObjectWrapper zzae() throws RemoteException {
                return C0681a.m306a(zza(2, zza()));
            }

            public final IFragmentWrapper zzaf() throws RemoteException {
                Parcel zza = zza(5, zza());
                IFragmentWrapper asInterface = Stub.asInterface(zza.readStrongBinder());
                zza.recycle();
                return asInterface;
            }

            public final IObjectWrapper zzag() throws RemoteException {
                return C0681a.m306a(zza(6, zza()));
            }

            public final IFragmentWrapper zzah() throws RemoteException {
                Parcel zza = zza(9, zza());
                IFragmentWrapper asInterface = Stub.asInterface(zza.readStrongBinder());
                zza.recycle();
                return asInterface;
            }

            public final IObjectWrapper zzai() throws RemoteException {
                return C0681a.m306a(zza(12, zza()));
            }

            public final void zzb(IObjectWrapper iObjectWrapper) throws RemoteException {
                Parcel zza = zza();
                zzd.zza(zza, (IInterface) iObjectWrapper);
                zzb(27, zza);
            }
        }

        public Stub() {
            super("com.google.android.gms.dynamic.IFragmentWrapper");
        }

        public static IFragmentWrapper asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.dynamic.IFragmentWrapper");
            return queryLocalInterface instanceof IFragmentWrapper ? (IFragmentWrapper) queryLocalInterface : new zza(iBinder);
        }

        /* access modifiers changed from: protected */
        /* JADX WARNING: Code restructure failed: missing block: B:10:0x0058, code lost:
            r3.writeNoException();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:24:0x00a3, code lost:
            r3.writeNoException();
            com.google.android.gms.internal.common.zzd.writeBoolean(r3, r1);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:28:0x00b8, code lost:
            r3.writeNoException();
            r3.writeInt(r1);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:31:0x00ce, code lost:
            r3.writeNoException();
            com.google.android.gms.internal.common.zzd.zza(r3, r1);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:32:?, code lost:
            return true;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:33:?, code lost:
            return true;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:35:?, code lost:
            return true;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:36:?, code lost:
            return true;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final boolean zza(int r1, android.os.Parcel r2, android.os.Parcel r3, int r4) throws android.os.RemoteException {
            /*
                r0 = this;
                switch(r1) {
                    case 2: goto L_0x00ca;
                    case 3: goto L_0x00bf;
                    case 4: goto L_0x00b4;
                    case 5: goto L_0x00af;
                    case 6: goto L_0x00aa;
                    case 7: goto L_0x009f;
                    case 8: goto L_0x0094;
                    case 9: goto L_0x008f;
                    case 10: goto L_0x008a;
                    case 11: goto L_0x0085;
                    case 12: goto L_0x0080;
                    case 13: goto L_0x007b;
                    case 14: goto L_0x0076;
                    case 15: goto L_0x0071;
                    case 16: goto L_0x006c;
                    case 17: goto L_0x0067;
                    case 18: goto L_0x0062;
                    case 19: goto L_0x005d;
                    case 20: goto L_0x004d;
                    case 21: goto L_0x0045;
                    case 22: goto L_0x003d;
                    case 23: goto L_0x0035;
                    case 24: goto L_0x002d;
                    case 25: goto L_0x0021;
                    case 26: goto L_0x0011;
                    case 27: goto L_0x0005;
                    default: goto L_0x0003;
                }
            L_0x0003:
                r1 = 0
                return r1
            L_0x0005:
                android.os.IBinder r1 = r2.readStrongBinder()
                com.google.android.gms.dynamic.IObjectWrapper r1 = com.google.android.gms.dynamic.IObjectWrapper.Stub.asInterface(r1)
                r0.zzb(r1)
                goto L_0x0058
            L_0x0011:
                android.os.Parcelable$Creator r1 = android.content.Intent.CREATOR
                android.os.Parcelable r1 = com.google.android.gms.internal.common.zzd.zza((android.os.Parcel) r2, r1)
                android.content.Intent r1 = (android.content.Intent) r1
                int r2 = r2.readInt()
                r0.startActivityForResult(r1, r2)
                goto L_0x0058
            L_0x0021:
                android.os.Parcelable$Creator r1 = android.content.Intent.CREATOR
                android.os.Parcelable r1 = com.google.android.gms.internal.common.zzd.zza((android.os.Parcel) r2, r1)
                android.content.Intent r1 = (android.content.Intent) r1
                r0.startActivity(r1)
                goto L_0x0058
            L_0x002d:
                boolean r1 = com.google.android.gms.internal.common.zzd.zza(r2)
                r0.setUserVisibleHint(r1)
                goto L_0x0058
            L_0x0035:
                boolean r1 = com.google.android.gms.internal.common.zzd.zza(r2)
                r0.setRetainInstance(r1)
                goto L_0x0058
            L_0x003d:
                boolean r1 = com.google.android.gms.internal.common.zzd.zza(r2)
                r0.setMenuVisibility(r1)
                goto L_0x0058
            L_0x0045:
                boolean r1 = com.google.android.gms.internal.common.zzd.zza(r2)
                r0.setHasOptionsMenu(r1)
                goto L_0x0058
            L_0x004d:
                android.os.IBinder r1 = r2.readStrongBinder()
                com.google.android.gms.dynamic.IObjectWrapper r1 = com.google.android.gms.dynamic.IObjectWrapper.Stub.asInterface(r1)
                r0.zza(r1)
            L_0x0058:
                r3.writeNoException()
                goto L_0x00d4
            L_0x005d:
                boolean r1 = r0.isVisible()
                goto L_0x00a3
            L_0x0062:
                boolean r1 = r0.isResumed()
                goto L_0x00a3
            L_0x0067:
                boolean r1 = r0.isRemoving()
                goto L_0x00a3
            L_0x006c:
                boolean r1 = r0.isInLayout()
                goto L_0x00a3
            L_0x0071:
                boolean r1 = r0.isHidden()
                goto L_0x00a3
            L_0x0076:
                boolean r1 = r0.isDetached()
                goto L_0x00a3
            L_0x007b:
                boolean r1 = r0.isAdded()
                goto L_0x00a3
            L_0x0080:
                com.google.android.gms.dynamic.IObjectWrapper r1 = r0.zzai()
                goto L_0x00ce
            L_0x0085:
                boolean r1 = r0.getUserVisibleHint()
                goto L_0x00a3
            L_0x008a:
                int r1 = r0.getTargetRequestCode()
                goto L_0x00b8
            L_0x008f:
                com.google.android.gms.dynamic.IFragmentWrapper r1 = r0.zzah()
                goto L_0x00ce
            L_0x0094:
                java.lang.String r1 = r0.getTag()
                r3.writeNoException()
                r3.writeString(r1)
                goto L_0x00d4
            L_0x009f:
                boolean r1 = r0.getRetainInstance()
            L_0x00a3:
                r3.writeNoException()
                com.google.android.gms.internal.common.zzd.writeBoolean(r3, r1)
                goto L_0x00d4
            L_0x00aa:
                com.google.android.gms.dynamic.IObjectWrapper r1 = r0.zzag()
                goto L_0x00ce
            L_0x00af:
                com.google.android.gms.dynamic.IFragmentWrapper r1 = r0.zzaf()
                goto L_0x00ce
            L_0x00b4:
                int r1 = r0.getId()
            L_0x00b8:
                r3.writeNoException()
                r3.writeInt(r1)
                goto L_0x00d4
            L_0x00bf:
                android.os.Bundle r1 = r0.getArguments()
                r3.writeNoException()
                com.google.android.gms.internal.common.zzd.zzb(r3, r1)
                goto L_0x00d4
            L_0x00ca:
                com.google.android.gms.dynamic.IObjectWrapper r1 = r0.zzae()
            L_0x00ce:
                r3.writeNoException()
                com.google.android.gms.internal.common.zzd.zza((android.os.Parcel) r3, (android.os.IInterface) r1)
            L_0x00d4:
                r1 = 1
                return r1
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.dynamic.IFragmentWrapper.Stub.zza(int, android.os.Parcel, android.os.Parcel, int):boolean");
        }
    }

    Bundle getArguments() throws RemoteException;

    int getId() throws RemoteException;

    boolean getRetainInstance() throws RemoteException;

    String getTag() throws RemoteException;

    int getTargetRequestCode() throws RemoteException;

    boolean getUserVisibleHint() throws RemoteException;

    boolean isAdded() throws RemoteException;

    boolean isDetached() throws RemoteException;

    boolean isHidden() throws RemoteException;

    boolean isInLayout() throws RemoteException;

    boolean isRemoving() throws RemoteException;

    boolean isResumed() throws RemoteException;

    boolean isVisible() throws RemoteException;

    void setHasOptionsMenu(boolean z) throws RemoteException;

    void setMenuVisibility(boolean z) throws RemoteException;

    void setRetainInstance(boolean z) throws RemoteException;

    void setUserVisibleHint(boolean z) throws RemoteException;

    void startActivity(Intent intent) throws RemoteException;

    void startActivityForResult(Intent intent, int i) throws RemoteException;

    void zza(IObjectWrapper iObjectWrapper) throws RemoteException;

    IObjectWrapper zzae() throws RemoteException;

    IFragmentWrapper zzaf() throws RemoteException;

    IObjectWrapper zzag() throws RemoteException;

    IFragmentWrapper zzah() throws RemoteException;

    IObjectWrapper zzai() throws RemoteException;

    void zzb(IObjectWrapper iObjectWrapper) throws RemoteException;
}
