package com.google.android.gms.internal.measurement;

import android.os.IBinder;
import android.os.IInterface;

public abstract class zzu extends zzc implements zzv {
    public zzu() {
        super("com.google.android.gms.measurement.api.internal.IAppMeasurementDynamiteService");
    }

    public static zzv asInterface(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.measurement.api.internal.IAppMeasurementDynamiteService");
        return queryLocalInterface instanceof zzv ? (zzv) queryLocalInterface : new zzx(iBinder);
    }

    /* JADX WARNING: type inference failed for: r3v0 */
    /* JADX WARNING: type inference failed for: r3v9, types: [com.google.android.gms.internal.measurement.zzw] */
    /* JADX WARNING: type inference failed for: r3v14, types: [com.google.android.gms.internal.measurement.zzw] */
    /* JADX WARNING: type inference failed for: r3v20, types: [com.google.android.gms.internal.measurement.zzw] */
    /* JADX WARNING: type inference failed for: r3v26, types: [com.google.android.gms.internal.measurement.zzw] */
    /* JADX WARNING: type inference failed for: r3v30, types: [com.google.android.gms.internal.measurement.zzw] */
    /* JADX WARNING: type inference failed for: r3v34, types: [com.google.android.gms.internal.measurement.zzac] */
    /* JADX WARNING: type inference failed for: r3v38, types: [com.google.android.gms.internal.measurement.zzw] */
    /* JADX WARNING: type inference failed for: r3v42, types: [com.google.android.gms.internal.measurement.zzw] */
    /* JADX WARNING: type inference failed for: r3v46, types: [com.google.android.gms.internal.measurement.zzw] */
    /* JADX WARNING: type inference failed for: r3v50, types: [com.google.android.gms.internal.measurement.zzw] */
    /* JADX WARNING: type inference failed for: r3v55, types: [com.google.android.gms.internal.measurement.zzw] */
    /* JADX WARNING: type inference failed for: r3v60, types: [com.google.android.gms.internal.measurement.zzw] */
    /* JADX WARNING: type inference failed for: r3v67, types: [com.google.android.gms.internal.measurement.zzab] */
    /* JADX WARNING: type inference failed for: r3v71, types: [com.google.android.gms.internal.measurement.zzab] */
    /* JADX WARNING: type inference failed for: r3v75, types: [com.google.android.gms.internal.measurement.zzab] */
    /* JADX WARNING: type inference failed for: r3v79, types: [com.google.android.gms.internal.measurement.zzw] */
    /* JADX WARNING: type inference failed for: r3v84, types: [com.google.android.gms.internal.measurement.zzw] */
    /* JADX WARNING: type inference failed for: r3v88 */
    /* JADX WARNING: type inference failed for: r3v89 */
    /* JADX WARNING: type inference failed for: r3v90 */
    /* JADX WARNING: type inference failed for: r3v91 */
    /* JADX WARNING: type inference failed for: r3v92 */
    /* JADX WARNING: type inference failed for: r3v93 */
    /* JADX WARNING: type inference failed for: r3v94 */
    /* JADX WARNING: type inference failed for: r3v95 */
    /* JADX WARNING: type inference failed for: r3v96 */
    /* JADX WARNING: type inference failed for: r3v97 */
    /* JADX WARNING: type inference failed for: r3v98 */
    /* JADX WARNING: type inference failed for: r3v99 */
    /* JADX WARNING: type inference failed for: r3v100 */
    /* JADX WARNING: type inference failed for: r3v101 */
    /* JADX WARNING: type inference failed for: r3v102 */
    /* JADX WARNING: type inference failed for: r3v103 */
    /* JADX WARNING: type inference failed for: r3v104 */
    /* JADX WARNING: type inference failed for: r3v105 */
    /* JADX WARNING: type inference failed for: r3v106 */
    /* JADX WARNING: type inference failed for: r3v107 */
    /* JADX WARNING: type inference failed for: r3v108 */
    /* JADX WARNING: type inference failed for: r3v109 */
    /* JADX WARNING: type inference failed for: r3v110 */
    /* JADX WARNING: type inference failed for: r3v111 */
    /* JADX WARNING: type inference failed for: r3v112 */
    /* JADX WARNING: type inference failed for: r3v113 */
    /* JADX WARNING: type inference failed for: r3v114 */
    /* JADX WARNING: type inference failed for: r3v115 */
    /* JADX WARNING: type inference failed for: r3v116 */
    /* JADX WARNING: type inference failed for: r3v117 */
    /* JADX WARNING: type inference failed for: r3v118 */
    /* JADX WARNING: type inference failed for: r3v119 */
    /* JADX WARNING: type inference failed for: r3v120 */
    /* JADX WARNING: type inference failed for: r3v121 */
    /* access modifiers changed from: protected */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean zza(int r11, android.os.Parcel r12, android.os.Parcel r13, int r14) throws android.os.RemoteException {
        /*
            r10 = this;
            java.lang.String r1 = "com.google.android.gms.measurement.api.internal.IEventHandlerProxy"
            java.lang.String r2 = "com.google.android.gms.measurement.api.internal.IBundleReceiver"
            r3 = 0
            switch(r11) {
                case 1: goto L_0x03e4;
                case 2: goto L_0x03c3;
                case 3: goto L_0x038d;
                case 4: goto L_0x036f;
                case 5: goto L_0x0346;
                case 6: goto L_0x0325;
                case 7: goto L_0x0318;
                case 8: goto L_0x0307;
                case 9: goto L_0x02f2;
                case 10: goto L_0x02cd;
                case 11: goto L_0x02c0;
                case 12: goto L_0x02b7;
                case 13: goto L_0x02ae;
                case 14: goto L_0x02a5;
                case 15: goto L_0x028b;
                case 16: goto L_0x026e;
                case 17: goto L_0x0251;
                case 18: goto L_0x0232;
                case 19: goto L_0x0215;
                case 20: goto L_0x01f8;
                case 21: goto L_0x01db;
                case 22: goto L_0x01be;
                case 23: goto L_0x01b1;
                case 24: goto L_0x01a4;
                case 25: goto L_0x0193;
                case 26: goto L_0x0182;
                case 27: goto L_0x0169;
                case 28: goto L_0x0158;
                case 29: goto L_0x0147;
                case 30: goto L_0x0136;
                case 31: goto L_0x010d;
                case 32: goto L_0x00e4;
                case 33: goto L_0x00be;
                case 34: goto L_0x00a1;
                case 35: goto L_0x0084;
                case 36: goto L_0x0067;
                case 37: goto L_0x005e;
                case 38: goto L_0x003d;
                case 39: goto L_0x0034;
                case 40: goto L_0x0017;
                case 41: goto L_0x0008;
                case 42: goto L_0x000a;
                default: goto L_0x0008;
            }
        L_0x0008:
            r0 = 0
            return r0
        L_0x000a:
            android.os.Parcelable$Creator r1 = android.os.Bundle.CREATOR
            android.os.Parcelable r0 = com.google.android.gms.internal.measurement.zzb.zza((android.os.Parcel) r12, r1)
            android.os.Bundle r0 = (android.os.Bundle) r0
            r10.setDefaultEventParameters(r0)
            goto L_0x03fb
        L_0x0017:
            android.os.IBinder r0 = r12.readStrongBinder()
            if (r0 != 0) goto L_0x001e
            goto L_0x002f
        L_0x001e:
            android.os.IInterface r1 = r0.queryLocalInterface(r2)
            boolean r2 = r1 instanceof com.google.android.gms.internal.measurement.zzw
            if (r2 == 0) goto L_0x002a
            r3 = r1
            com.google.android.gms.internal.measurement.zzw r3 = (com.google.android.gms.internal.measurement.zzw) r3
            goto L_0x002f
        L_0x002a:
            com.google.android.gms.internal.measurement.zzy r3 = new com.google.android.gms.internal.measurement.zzy
            r3.<init>(r0)
        L_0x002f:
            r10.isDataCollectionEnabled(r3)
            goto L_0x03fb
        L_0x0034:
            boolean r0 = com.google.android.gms.internal.measurement.zzb.zza(r12)
            r10.setDataCollectionEnabled(r0)
            goto L_0x03fb
        L_0x003d:
            android.os.IBinder r1 = r12.readStrongBinder()
            if (r1 != 0) goto L_0x0044
            goto L_0x0055
        L_0x0044:
            android.os.IInterface r2 = r1.queryLocalInterface(r2)
            boolean r3 = r2 instanceof com.google.android.gms.internal.measurement.zzw
            if (r3 == 0) goto L_0x0050
            r3 = r2
            com.google.android.gms.internal.measurement.zzw r3 = (com.google.android.gms.internal.measurement.zzw) r3
            goto L_0x0055
        L_0x0050:
            com.google.android.gms.internal.measurement.zzy r3 = new com.google.android.gms.internal.measurement.zzy
            r3.<init>(r1)
        L_0x0055:
            int r0 = r12.readInt()
            r10.getTestFlag(r3, r0)
            goto L_0x03fb
        L_0x005e:
            java.util.HashMap r0 = com.google.android.gms.internal.measurement.zzb.zzb(r12)
            r10.initForTests(r0)
            goto L_0x03fb
        L_0x0067:
            android.os.IBinder r0 = r12.readStrongBinder()
            if (r0 != 0) goto L_0x006e
            goto L_0x007f
        L_0x006e:
            android.os.IInterface r1 = r0.queryLocalInterface(r1)
            boolean r2 = r1 instanceof com.google.android.gms.internal.measurement.zzab
            if (r2 == 0) goto L_0x007a
            r3 = r1
            com.google.android.gms.internal.measurement.zzab r3 = (com.google.android.gms.internal.measurement.zzab) r3
            goto L_0x007f
        L_0x007a:
            com.google.android.gms.internal.measurement.zzad r3 = new com.google.android.gms.internal.measurement.zzad
            r3.<init>(r0)
        L_0x007f:
            r10.unregisterOnMeasurementEventListener(r3)
            goto L_0x03fb
        L_0x0084:
            android.os.IBinder r0 = r12.readStrongBinder()
            if (r0 != 0) goto L_0x008b
            goto L_0x009c
        L_0x008b:
            android.os.IInterface r1 = r0.queryLocalInterface(r1)
            boolean r2 = r1 instanceof com.google.android.gms.internal.measurement.zzab
            if (r2 == 0) goto L_0x0097
            r3 = r1
            com.google.android.gms.internal.measurement.zzab r3 = (com.google.android.gms.internal.measurement.zzab) r3
            goto L_0x009c
        L_0x0097:
            com.google.android.gms.internal.measurement.zzad r3 = new com.google.android.gms.internal.measurement.zzad
            r3.<init>(r0)
        L_0x009c:
            r10.registerOnMeasurementEventListener(r3)
            goto L_0x03fb
        L_0x00a1:
            android.os.IBinder r0 = r12.readStrongBinder()
            if (r0 != 0) goto L_0x00a8
            goto L_0x00b9
        L_0x00a8:
            android.os.IInterface r1 = r0.queryLocalInterface(r1)
            boolean r2 = r1 instanceof com.google.android.gms.internal.measurement.zzab
            if (r2 == 0) goto L_0x00b4
            r3 = r1
            com.google.android.gms.internal.measurement.zzab r3 = (com.google.android.gms.internal.measurement.zzab) r3
            goto L_0x00b9
        L_0x00b4:
            com.google.android.gms.internal.measurement.zzad r3 = new com.google.android.gms.internal.measurement.zzad
            r3.<init>(r0)
        L_0x00b9:
            r10.setEventInterceptor(r3)
            goto L_0x03fb
        L_0x00be:
            int r1 = r12.readInt()
            java.lang.String r2 = r12.readString()
            android.os.IBinder r3 = r12.readStrongBinder()
            com.google.android.gms.dynamic.IObjectWrapper r3 = com.google.android.gms.dynamic.IObjectWrapper.Stub.asInterface(r3)
            android.os.IBinder r4 = r12.readStrongBinder()
            com.google.android.gms.dynamic.IObjectWrapper r4 = com.google.android.gms.dynamic.IObjectWrapper.Stub.asInterface(r4)
            android.os.IBinder r0 = r12.readStrongBinder()
            com.google.android.gms.dynamic.IObjectWrapper r5 = com.google.android.gms.dynamic.IObjectWrapper.Stub.asInterface(r0)
            r0 = r10
            r0.logHealthData(r1, r2, r3, r4, r5)
            goto L_0x03fb
        L_0x00e4:
            android.os.Parcelable$Creator r1 = android.os.Bundle.CREATOR
            android.os.Parcelable r1 = com.google.android.gms.internal.measurement.zzb.zza((android.os.Parcel) r12, r1)
            android.os.Bundle r1 = (android.os.Bundle) r1
            android.os.IBinder r4 = r12.readStrongBinder()
            if (r4 != 0) goto L_0x00f3
            goto L_0x0104
        L_0x00f3:
            android.os.IInterface r2 = r4.queryLocalInterface(r2)
            boolean r3 = r2 instanceof com.google.android.gms.internal.measurement.zzw
            if (r3 == 0) goto L_0x00ff
            r3 = r2
            com.google.android.gms.internal.measurement.zzw r3 = (com.google.android.gms.internal.measurement.zzw) r3
            goto L_0x0104
        L_0x00ff:
            com.google.android.gms.internal.measurement.zzy r3 = new com.google.android.gms.internal.measurement.zzy
            r3.<init>(r4)
        L_0x0104:
            long r4 = r12.readLong()
            r10.performAction(r1, r3, r4)
            goto L_0x03fb
        L_0x010d:
            android.os.IBinder r1 = r12.readStrongBinder()
            com.google.android.gms.dynamic.IObjectWrapper r1 = com.google.android.gms.dynamic.IObjectWrapper.Stub.asInterface(r1)
            android.os.IBinder r4 = r12.readStrongBinder()
            if (r4 != 0) goto L_0x011c
            goto L_0x012d
        L_0x011c:
            android.os.IInterface r2 = r4.queryLocalInterface(r2)
            boolean r3 = r2 instanceof com.google.android.gms.internal.measurement.zzw
            if (r3 == 0) goto L_0x0128
            r3 = r2
            com.google.android.gms.internal.measurement.zzw r3 = (com.google.android.gms.internal.measurement.zzw) r3
            goto L_0x012d
        L_0x0128:
            com.google.android.gms.internal.measurement.zzy r3 = new com.google.android.gms.internal.measurement.zzy
            r3.<init>(r4)
        L_0x012d:
            long r4 = r12.readLong()
            r10.onActivitySaveInstanceState(r1, r3, r4)
            goto L_0x03fb
        L_0x0136:
            android.os.IBinder r1 = r12.readStrongBinder()
            com.google.android.gms.dynamic.IObjectWrapper r1 = com.google.android.gms.dynamic.IObjectWrapper.Stub.asInterface(r1)
            long r2 = r12.readLong()
            r10.onActivityResumed(r1, r2)
            goto L_0x03fb
        L_0x0147:
            android.os.IBinder r1 = r12.readStrongBinder()
            com.google.android.gms.dynamic.IObjectWrapper r1 = com.google.android.gms.dynamic.IObjectWrapper.Stub.asInterface(r1)
            long r2 = r12.readLong()
            r10.onActivityPaused(r1, r2)
            goto L_0x03fb
        L_0x0158:
            android.os.IBinder r1 = r12.readStrongBinder()
            com.google.android.gms.dynamic.IObjectWrapper r1 = com.google.android.gms.dynamic.IObjectWrapper.Stub.asInterface(r1)
            long r2 = r12.readLong()
            r10.onActivityDestroyed(r1, r2)
            goto L_0x03fb
        L_0x0169:
            android.os.IBinder r1 = r12.readStrongBinder()
            com.google.android.gms.dynamic.IObjectWrapper r1 = com.google.android.gms.dynamic.IObjectWrapper.Stub.asInterface(r1)
            android.os.Parcelable$Creator r2 = android.os.Bundle.CREATOR
            android.os.Parcelable r2 = com.google.android.gms.internal.measurement.zzb.zza((android.os.Parcel) r12, r2)
            android.os.Bundle r2 = (android.os.Bundle) r2
            long r3 = r12.readLong()
            r10.onActivityCreated(r1, r2, r3)
            goto L_0x03fb
        L_0x0182:
            android.os.IBinder r1 = r12.readStrongBinder()
            com.google.android.gms.dynamic.IObjectWrapper r1 = com.google.android.gms.dynamic.IObjectWrapper.Stub.asInterface(r1)
            long r2 = r12.readLong()
            r10.onActivityStopped(r1, r2)
            goto L_0x03fb
        L_0x0193:
            android.os.IBinder r1 = r12.readStrongBinder()
            com.google.android.gms.dynamic.IObjectWrapper r1 = com.google.android.gms.dynamic.IObjectWrapper.Stub.asInterface(r1)
            long r2 = r12.readLong()
            r10.onActivityStarted(r1, r2)
            goto L_0x03fb
        L_0x01a4:
            java.lang.String r1 = r12.readString()
            long r2 = r12.readLong()
            r10.endAdUnitExposure(r1, r2)
            goto L_0x03fb
        L_0x01b1:
            java.lang.String r1 = r12.readString()
            long r2 = r12.readLong()
            r10.beginAdUnitExposure(r1, r2)
            goto L_0x03fb
        L_0x01be:
            android.os.IBinder r0 = r12.readStrongBinder()
            if (r0 != 0) goto L_0x01c5
            goto L_0x01d6
        L_0x01c5:
            android.os.IInterface r1 = r0.queryLocalInterface(r2)
            boolean r2 = r1 instanceof com.google.android.gms.internal.measurement.zzw
            if (r2 == 0) goto L_0x01d1
            r3 = r1
            com.google.android.gms.internal.measurement.zzw r3 = (com.google.android.gms.internal.measurement.zzw) r3
            goto L_0x01d6
        L_0x01d1:
            com.google.android.gms.internal.measurement.zzy r3 = new com.google.android.gms.internal.measurement.zzy
            r3.<init>(r0)
        L_0x01d6:
            r10.generateEventId(r3)
            goto L_0x03fb
        L_0x01db:
            android.os.IBinder r0 = r12.readStrongBinder()
            if (r0 != 0) goto L_0x01e2
            goto L_0x01f3
        L_0x01e2:
            android.os.IInterface r1 = r0.queryLocalInterface(r2)
            boolean r2 = r1 instanceof com.google.android.gms.internal.measurement.zzw
            if (r2 == 0) goto L_0x01ee
            r3 = r1
            com.google.android.gms.internal.measurement.zzw r3 = (com.google.android.gms.internal.measurement.zzw) r3
            goto L_0x01f3
        L_0x01ee:
            com.google.android.gms.internal.measurement.zzy r3 = new com.google.android.gms.internal.measurement.zzy
            r3.<init>(r0)
        L_0x01f3:
            r10.getGmpAppId(r3)
            goto L_0x03fb
        L_0x01f8:
            android.os.IBinder r0 = r12.readStrongBinder()
            if (r0 != 0) goto L_0x01ff
            goto L_0x0210
        L_0x01ff:
            android.os.IInterface r1 = r0.queryLocalInterface(r2)
            boolean r2 = r1 instanceof com.google.android.gms.internal.measurement.zzw
            if (r2 == 0) goto L_0x020b
            r3 = r1
            com.google.android.gms.internal.measurement.zzw r3 = (com.google.android.gms.internal.measurement.zzw) r3
            goto L_0x0210
        L_0x020b:
            com.google.android.gms.internal.measurement.zzy r3 = new com.google.android.gms.internal.measurement.zzy
            r3.<init>(r0)
        L_0x0210:
            r10.getAppInstanceId(r3)
            goto L_0x03fb
        L_0x0215:
            android.os.IBinder r0 = r12.readStrongBinder()
            if (r0 != 0) goto L_0x021c
            goto L_0x022d
        L_0x021c:
            android.os.IInterface r1 = r0.queryLocalInterface(r2)
            boolean r2 = r1 instanceof com.google.android.gms.internal.measurement.zzw
            if (r2 == 0) goto L_0x0228
            r3 = r1
            com.google.android.gms.internal.measurement.zzw r3 = (com.google.android.gms.internal.measurement.zzw) r3
            goto L_0x022d
        L_0x0228:
            com.google.android.gms.internal.measurement.zzy r3 = new com.google.android.gms.internal.measurement.zzy
            r3.<init>(r0)
        L_0x022d:
            r10.getCachedAppInstanceId(r3)
            goto L_0x03fb
        L_0x0232:
            android.os.IBinder r0 = r12.readStrongBinder()
            if (r0 != 0) goto L_0x0239
            goto L_0x024c
        L_0x0239:
            java.lang.String r1 = "com.google.android.gms.measurement.api.internal.IStringProvider"
            android.os.IInterface r1 = r0.queryLocalInterface(r1)
            boolean r2 = r1 instanceof com.google.android.gms.internal.measurement.zzac
            if (r2 == 0) goto L_0x0247
            r3 = r1
            com.google.android.gms.internal.measurement.zzac r3 = (com.google.android.gms.internal.measurement.zzac) r3
            goto L_0x024c
        L_0x0247:
            com.google.android.gms.internal.measurement.zzaf r3 = new com.google.android.gms.internal.measurement.zzaf
            r3.<init>(r0)
        L_0x024c:
            r10.setInstanceIdProvider(r3)
            goto L_0x03fb
        L_0x0251:
            android.os.IBinder r0 = r12.readStrongBinder()
            if (r0 != 0) goto L_0x0258
            goto L_0x0269
        L_0x0258:
            android.os.IInterface r1 = r0.queryLocalInterface(r2)
            boolean r2 = r1 instanceof com.google.android.gms.internal.measurement.zzw
            if (r2 == 0) goto L_0x0264
            r3 = r1
            com.google.android.gms.internal.measurement.zzw r3 = (com.google.android.gms.internal.measurement.zzw) r3
            goto L_0x0269
        L_0x0264:
            com.google.android.gms.internal.measurement.zzy r3 = new com.google.android.gms.internal.measurement.zzy
            r3.<init>(r0)
        L_0x0269:
            r10.getCurrentScreenClass(r3)
            goto L_0x03fb
        L_0x026e:
            android.os.IBinder r0 = r12.readStrongBinder()
            if (r0 != 0) goto L_0x0275
            goto L_0x0286
        L_0x0275:
            android.os.IInterface r1 = r0.queryLocalInterface(r2)
            boolean r2 = r1 instanceof com.google.android.gms.internal.measurement.zzw
            if (r2 == 0) goto L_0x0281
            r3 = r1
            com.google.android.gms.internal.measurement.zzw r3 = (com.google.android.gms.internal.measurement.zzw) r3
            goto L_0x0286
        L_0x0281:
            com.google.android.gms.internal.measurement.zzy r3 = new com.google.android.gms.internal.measurement.zzy
            r3.<init>(r0)
        L_0x0286:
            r10.getCurrentScreenName(r3)
            goto L_0x03fb
        L_0x028b:
            android.os.IBinder r1 = r12.readStrongBinder()
            com.google.android.gms.dynamic.IObjectWrapper r1 = com.google.android.gms.dynamic.IObjectWrapper.Stub.asInterface(r1)
            java.lang.String r2 = r12.readString()
            java.lang.String r3 = r12.readString()
            long r4 = r12.readLong()
            r0 = r10
            r0.setCurrentScreen(r1, r2, r3, r4)
            goto L_0x03fb
        L_0x02a5:
            long r0 = r12.readLong()
            r10.setSessionTimeoutDuration(r0)
            goto L_0x03fb
        L_0x02ae:
            long r0 = r12.readLong()
            r10.setMinimumSessionDuration(r0)
            goto L_0x03fb
        L_0x02b7:
            long r0 = r12.readLong()
            r10.resetAnalyticsData(r0)
            goto L_0x03fb
        L_0x02c0:
            boolean r1 = com.google.android.gms.internal.measurement.zzb.zza(r12)
            long r2 = r12.readLong()
            r10.setMeasurementEnabled(r1, r2)
            goto L_0x03fb
        L_0x02cd:
            java.lang.String r1 = r12.readString()
            java.lang.String r4 = r12.readString()
            android.os.IBinder r0 = r12.readStrongBinder()
            if (r0 != 0) goto L_0x02dc
            goto L_0x02ed
        L_0x02dc:
            android.os.IInterface r2 = r0.queryLocalInterface(r2)
            boolean r3 = r2 instanceof com.google.android.gms.internal.measurement.zzw
            if (r3 == 0) goto L_0x02e8
            r3 = r2
            com.google.android.gms.internal.measurement.zzw r3 = (com.google.android.gms.internal.measurement.zzw) r3
            goto L_0x02ed
        L_0x02e8:
            com.google.android.gms.internal.measurement.zzy r3 = new com.google.android.gms.internal.measurement.zzy
            r3.<init>(r0)
        L_0x02ed:
            r10.getConditionalUserProperties(r1, r4, r3)
            goto L_0x03fb
        L_0x02f2:
            java.lang.String r1 = r12.readString()
            java.lang.String r2 = r12.readString()
            android.os.Parcelable$Creator r3 = android.os.Bundle.CREATOR
            android.os.Parcelable r0 = com.google.android.gms.internal.measurement.zzb.zza((android.os.Parcel) r12, r3)
            android.os.Bundle r0 = (android.os.Bundle) r0
            r10.clearConditionalUserProperty(r1, r2, r0)
            goto L_0x03fb
        L_0x0307:
            android.os.Parcelable$Creator r1 = android.os.Bundle.CREATOR
            android.os.Parcelable r1 = com.google.android.gms.internal.measurement.zzb.zza((android.os.Parcel) r12, r1)
            android.os.Bundle r1 = (android.os.Bundle) r1
            long r2 = r12.readLong()
            r10.setConditionalUserProperty(r1, r2)
            goto L_0x03fb
        L_0x0318:
            java.lang.String r1 = r12.readString()
            long r2 = r12.readLong()
            r10.setUserId(r1, r2)
            goto L_0x03fb
        L_0x0325:
            java.lang.String r1 = r12.readString()
            android.os.IBinder r0 = r12.readStrongBinder()
            if (r0 != 0) goto L_0x0330
            goto L_0x0341
        L_0x0330:
            android.os.IInterface r2 = r0.queryLocalInterface(r2)
            boolean r3 = r2 instanceof com.google.android.gms.internal.measurement.zzw
            if (r3 == 0) goto L_0x033c
            r3 = r2
            com.google.android.gms.internal.measurement.zzw r3 = (com.google.android.gms.internal.measurement.zzw) r3
            goto L_0x0341
        L_0x033c:
            com.google.android.gms.internal.measurement.zzy r3 = new com.google.android.gms.internal.measurement.zzy
            r3.<init>(r0)
        L_0x0341:
            r10.getMaxUserProperties(r1, r3)
            goto L_0x03fb
        L_0x0346:
            java.lang.String r1 = r12.readString()
            java.lang.String r4 = r12.readString()
            boolean r5 = com.google.android.gms.internal.measurement.zzb.zza(r12)
            android.os.IBinder r0 = r12.readStrongBinder()
            if (r0 != 0) goto L_0x0359
            goto L_0x036a
        L_0x0359:
            android.os.IInterface r2 = r0.queryLocalInterface(r2)
            boolean r3 = r2 instanceof com.google.android.gms.internal.measurement.zzw
            if (r3 == 0) goto L_0x0365
            r3 = r2
            com.google.android.gms.internal.measurement.zzw r3 = (com.google.android.gms.internal.measurement.zzw) r3
            goto L_0x036a
        L_0x0365:
            com.google.android.gms.internal.measurement.zzy r3 = new com.google.android.gms.internal.measurement.zzy
            r3.<init>(r0)
        L_0x036a:
            r10.getUserProperties(r1, r4, r5, r3)
            goto L_0x03fb
        L_0x036f:
            java.lang.String r1 = r12.readString()
            java.lang.String r2 = r12.readString()
            android.os.IBinder r3 = r12.readStrongBinder()
            com.google.android.gms.dynamic.IObjectWrapper r3 = com.google.android.gms.dynamic.IObjectWrapper.Stub.asInterface(r3)
            boolean r4 = com.google.android.gms.internal.measurement.zzb.zza(r12)
            long r5 = r12.readLong()
            r0 = r10
            r0.setUserProperty(r1, r2, r3, r4, r5)
            goto L_0x03fb
        L_0x038d:
            java.lang.String r1 = r12.readString()
            java.lang.String r4 = r12.readString()
            android.os.Parcelable$Creator r5 = android.os.Bundle.CREATOR
            android.os.Parcelable r5 = com.google.android.gms.internal.measurement.zzb.zza((android.os.Parcel) r12, r5)
            android.os.Bundle r5 = (android.os.Bundle) r5
            android.os.IBinder r6 = r12.readStrongBinder()
            if (r6 != 0) goto L_0x03a5
            r6 = r3
            goto L_0x03b6
        L_0x03a5:
            android.os.IInterface r2 = r6.queryLocalInterface(r2)
            boolean r3 = r2 instanceof com.google.android.gms.internal.measurement.zzw
            if (r3 == 0) goto L_0x03b0
            com.google.android.gms.internal.measurement.zzw r2 = (com.google.android.gms.internal.measurement.zzw) r2
            goto L_0x03b5
        L_0x03b0:
            com.google.android.gms.internal.measurement.zzy r2 = new com.google.android.gms.internal.measurement.zzy
            r2.<init>(r6)
        L_0x03b5:
            r6 = r2
        L_0x03b6:
            long r8 = r12.readLong()
            r0 = r10
            r2 = r4
            r3 = r5
            r4 = r6
            r5 = r8
            r0.logEventAndBundle(r1, r2, r3, r4, r5)
            goto L_0x03fb
        L_0x03c3:
            java.lang.String r1 = r12.readString()
            java.lang.String r2 = r12.readString()
            android.os.Parcelable$Creator r3 = android.os.Bundle.CREATOR
            android.os.Parcelable r3 = com.google.android.gms.internal.measurement.zzb.zza((android.os.Parcel) r12, r3)
            android.os.Bundle r3 = (android.os.Bundle) r3
            boolean r4 = com.google.android.gms.internal.measurement.zzb.zza(r12)
            boolean r5 = com.google.android.gms.internal.measurement.zzb.zza(r12)
            long r6 = r12.readLong()
            r0 = r10
            r0.logEvent(r1, r2, r3, r4, r5, r6)
            goto L_0x03fb
        L_0x03e4:
            android.os.IBinder r1 = r12.readStrongBinder()
            com.google.android.gms.dynamic.IObjectWrapper r1 = com.google.android.gms.dynamic.IObjectWrapper.Stub.asInterface(r1)
            android.os.Parcelable$Creator<com.google.android.gms.internal.measurement.zzae> r2 = com.google.android.gms.internal.measurement.zzae.CREATOR
            android.os.Parcelable r2 = com.google.android.gms.internal.measurement.zzb.zza((android.os.Parcel) r12, r2)
            com.google.android.gms.internal.measurement.zzae r2 = (com.google.android.gms.internal.measurement.zzae) r2
            long r3 = r12.readLong()
            r10.initialize(r1, r2, r3)
        L_0x03fb:
            r13.writeNoException()
            r0 = 1
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.zzu.zza(int, android.os.Parcel, android.os.Parcel, int):boolean");
    }
}
