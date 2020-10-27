package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.IInterface;

public abstract class zzxk extends zzgk implements zzxl {
    public zzxk() {
        super("com.google.android.gms.ads.internal.client.IVideoController");
    }

    public static zzxl zzk(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.client.IVideoController");
        return queryLocalInterface instanceof zzxl ? (zzxl) queryLocalInterface : new zzxn(iBinder);
    }

    /* JADX WARNING: type inference failed for: r2v2, types: [android.os.IInterface] */
    /* access modifiers changed from: protected */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x004d, code lost:
        r3.writeNoException();
        r3.writeFloat(r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0063, code lost:
        r3.writeNoException();
        com.google.android.gms.internal.ads.zzgj.writeBoolean(r3, r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x0079, code lost:
        r3.writeNoException();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:?, code lost:
        return true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:?, code lost:
        return true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:?, code lost:
        return true;
     */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean zza(int r1, android.os.Parcel r2, android.os.Parcel r3, int r4) throws android.os.RemoteException {
        /*
            r0 = this;
            switch(r1) {
                case 1: goto L_0x0076;
                case 2: goto L_0x0072;
                case 3: goto L_0x006a;
                case 4: goto L_0x005f;
                case 5: goto L_0x0054;
                case 6: goto L_0x0049;
                case 7: goto L_0x0044;
                case 8: goto L_0x0024;
                case 9: goto L_0x001f;
                case 10: goto L_0x001a;
                case 11: goto L_0x000f;
                case 12: goto L_0x000a;
                case 13: goto L_0x0005;
                default: goto L_0x0003;
            }
        L_0x0003:
            r1 = 0
            return r1
        L_0x0005:
            r0.stop()
            goto L_0x0079
        L_0x000a:
            boolean r1 = r0.isClickToExpandEnabled()
            goto L_0x0063
        L_0x000f:
            com.google.android.gms.internal.ads.zzxm r1 = r0.zzqg()
            r3.writeNoException()
            com.google.android.gms.internal.ads.zzgj.zza((android.os.Parcel) r3, (android.os.IInterface) r1)
            goto L_0x007c
        L_0x001a:
            boolean r1 = r0.isCustomControlsEnabled()
            goto L_0x0063
        L_0x001f:
            float r1 = r0.getAspectRatio()
            goto L_0x004d
        L_0x0024:
            android.os.IBinder r1 = r2.readStrongBinder()
            if (r1 != 0) goto L_0x002c
            r1 = 0
            goto L_0x0040
        L_0x002c:
            java.lang.String r2 = "com.google.android.gms.ads.internal.client.IVideoLifecycleCallbacks"
            android.os.IInterface r2 = r1.queryLocalInterface(r2)
            boolean r4 = r2 instanceof com.google.android.gms.internal.ads.zzxm
            if (r4 == 0) goto L_0x003a
            r1 = r2
            com.google.android.gms.internal.ads.zzxm r1 = (com.google.android.gms.internal.ads.zzxm) r1
            goto L_0x0040
        L_0x003a:
            com.google.android.gms.internal.ads.zzxo r2 = new com.google.android.gms.internal.ads.zzxo
            r2.<init>(r1)
            r1 = r2
        L_0x0040:
            r0.zza(r1)
            goto L_0x0079
        L_0x0044:
            float r1 = r0.getCurrentTime()
            goto L_0x004d
        L_0x0049:
            float r1 = r0.getDuration()
        L_0x004d:
            r3.writeNoException()
            r3.writeFloat(r1)
            goto L_0x007c
        L_0x0054:
            int r1 = r0.getPlaybackState()
            r3.writeNoException()
            r3.writeInt(r1)
            goto L_0x007c
        L_0x005f:
            boolean r1 = r0.isMuted()
        L_0x0063:
            r3.writeNoException()
            com.google.android.gms.internal.ads.zzgj.writeBoolean(r3, r1)
            goto L_0x007c
        L_0x006a:
            boolean r1 = com.google.android.gms.internal.ads.zzgj.zza(r2)
            r0.mute(r1)
            goto L_0x0079
        L_0x0072:
            r0.pause()
            goto L_0x0079
        L_0x0076:
            r0.play()
        L_0x0079:
            r3.writeNoException()
        L_0x007c:
            r1 = 1
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzxk.zza(int, android.os.Parcel, android.os.Parcel, int):boolean");
    }
}
