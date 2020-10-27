package com.google.android.gms.common.server.response;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.server.response.FastJsonResponse;
import com.google.android.gms.common.util.Base64Utils;
import com.google.android.gms.common.util.JsonUtils;
import com.google.android.gms.common.util.MapUtils;
import com.google.android.gms.common.util.VisibleForTesting;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import p009e.p010a.p011a.p012a.C0681a;

@KeepForSdk
@SafeParcelable.Class(creator = "SafeParcelResponseCreator")
@VisibleForTesting
public class SafeParcelResponse extends FastSafeParcelableJsonResponse {
    @KeepForSdk
    public static final Parcelable.Creator<SafeParcelResponse> CREATOR = new zap();
    private final String mClassName;
    @SafeParcelable.VersionField(getter = "getVersionCode", mo11975id = 1)
    private final int zali;
    @SafeParcelable.Field(getter = "getFieldMappingDictionary", mo11969id = 3)
    private final zaj zaqn;
    @SafeParcelable.Field(getter = "getParcel", mo11969id = 2)
    private final Parcel zarp;
    private final int zarq;
    private int zarr;
    private int zars;

    @SafeParcelable.Constructor
    SafeParcelResponse(@SafeParcelable.Param(mo11972id = 1) int i, @SafeParcelable.Param(mo11972id = 2) Parcel parcel, @SafeParcelable.Param(mo11972id = 3) zaj zaj) {
        this.zali = i;
        this.zarp = (Parcel) Preconditions.checkNotNull(parcel);
        this.zarq = 2;
        this.zaqn = zaj;
        this.mClassName = zaj == null ? null : zaj.zacr();
        this.zarr = 2;
    }

    private SafeParcelResponse(SafeParcelable safeParcelable, zaj zaj, String str) {
        this.zali = 1;
        Parcel obtain = Parcel.obtain();
        this.zarp = obtain;
        safeParcelable.writeToParcel(obtain, 0);
        this.zarq = 1;
        this.zaqn = (zaj) Preconditions.checkNotNull(zaj);
        this.mClassName = (String) Preconditions.checkNotNull(str);
        this.zarr = 2;
    }

    public SafeParcelResponse(zaj zaj, String str) {
        this.zali = 1;
        this.zarp = Parcel.obtain();
        this.zarq = 0;
        this.zaqn = (zaj) Preconditions.checkNotNull(zaj);
        this.mClassName = (String) Preconditions.checkNotNull(str);
        this.zarr = 0;
    }

    @KeepForSdk
    public static <T extends FastJsonResponse & SafeParcelable> SafeParcelResponse from(T t) {
        String canonicalName = t.getClass().getCanonicalName();
        zaj zaj = new zaj(t.getClass());
        zaa(zaj, t);
        zaj.zacq();
        zaj.zacp();
        return new SafeParcelResponse((SafeParcelable) t, zaj, canonicalName);
    }

    private static void zaa(zaj zaj, FastJsonResponse fastJsonResponse) {
        Class<?> cls = fastJsonResponse.getClass();
        if (!zaj.zaa(cls)) {
            Map<String, FastJsonResponse.Field<?, ?>> fieldMappings = fastJsonResponse.getFieldMappings();
            zaj.zaa(cls, fieldMappings);
            for (String str : fieldMappings.keySet()) {
                FastJsonResponse.Field field = fieldMappings.get(str);
                Class<? extends FastJsonResponse> cls2 = field.zaql;
                if (cls2 != null) {
                    try {
                        zaa(zaj, (FastJsonResponse) cls2.newInstance());
                    } catch (InstantiationException e) {
                        String valueOf = String.valueOf(field.zaql.getCanonicalName());
                        throw new IllegalStateException(valueOf.length() != 0 ? "Could not instantiate an object of type ".concat(valueOf) : new String("Could not instantiate an object of type "), e);
                    } catch (IllegalAccessException e2) {
                        String valueOf2 = String.valueOf(field.zaql.getCanonicalName());
                        throw new IllegalStateException(valueOf2.length() != 0 ? "Could not access object of type ".concat(valueOf2) : new String("Could not access object of type "), e2);
                    }
                }
            }
        }
    }

    private static void zaa(StringBuilder sb, int i, Object obj) {
        switch (i) {
            case 0:
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
                sb.append(obj);
                return;
            case 7:
                sb.append("\"");
                sb.append(JsonUtils.escapeString(obj.toString()));
                sb.append("\"");
                return;
            case 8:
                sb.append("\"");
                sb.append(Base64Utils.encode((byte[]) obj));
                sb.append("\"");
                return;
            case 9:
                sb.append("\"");
                sb.append(Base64Utils.encodeUrlSafe((byte[]) obj));
                sb.append("\"");
                return;
            case 10:
                MapUtils.writeStringMapToJson(sb, (HashMap) obj);
                return;
            case 11:
                throw new IllegalArgumentException("Method does not accept concrete type.");
            default:
                throw new IllegalArgumentException(C0681a.m309a(26, "Unknown type = ", i));
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:34:0x00f9, code lost:
        r2 = com.google.android.gms.common.server.response.FastJsonResponse.zab(r4, r2);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:35:0x00fd, code lost:
        zab(r10, (com.google.android.gms.common.server.response.FastJsonResponse.Field<?, ?>) r4, r2);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:75:0x0204, code lost:
        r10.append(r2);
        r10.append("\"");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:82:0x0234, code lost:
        r10.append(r2);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void zaa(java.lang.StringBuilder r10, java.util.Map<java.lang.String, com.google.android.gms.common.server.response.FastJsonResponse.Field<?, ?>> r11, android.os.Parcel r12) {
        /*
            r9 = this;
            android.util.SparseArray r0 = new android.util.SparseArray
            r0.<init>()
            java.util.Set r11 = r11.entrySet()
            java.util.Iterator r11 = r11.iterator()
        L_0x000d:
            boolean r1 = r11.hasNext()
            if (r1 == 0) goto L_0x0027
            java.lang.Object r1 = r11.next()
            java.util.Map$Entry r1 = (java.util.Map.Entry) r1
            java.lang.Object r2 = r1.getValue()
            com.google.android.gms.common.server.response.FastJsonResponse$Field r2 = (com.google.android.gms.common.server.response.FastJsonResponse.Field) r2
            int r2 = r2.getSafeParcelableFieldId()
            r0.put(r2, r1)
            goto L_0x000d
        L_0x0027:
            r11 = 123(0x7b, float:1.72E-43)
            r10.append(r11)
            int r11 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.validateObjectHeader(r12)
            r1 = 0
            r2 = 0
        L_0x0032:
            int r3 = r12.dataPosition()
            if (r3 >= r11) goto L_0x0242
            int r3 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.readHeader(r12)
            int r4 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.getFieldId(r3)
            java.lang.Object r4 = r0.get(r4)
            java.util.Map$Entry r4 = (java.util.Map.Entry) r4
            if (r4 == 0) goto L_0x0032
            java.lang.String r5 = ","
            if (r2 == 0) goto L_0x004f
            r10.append(r5)
        L_0x004f:
            java.lang.Object r2 = r4.getKey()
            java.lang.String r2 = (java.lang.String) r2
            java.lang.Object r4 = r4.getValue()
            com.google.android.gms.common.server.response.FastJsonResponse$Field r4 = (com.google.android.gms.common.server.response.FastJsonResponse.Field) r4
            java.lang.String r6 = "\""
            r10.append(r6)
            r10.append(r2)
            java.lang.String r2 = "\":"
            r10.append(r2)
            boolean r2 = r4.zacl()
            if (r2 == 0) goto L_0x0102
            int r2 = r4.zaqh
            switch(r2) {
                case 0: goto L_0x00f1;
                case 1: goto L_0x00ec;
                case 2: goto L_0x00e3;
                case 3: goto L_0x00da;
                case 4: goto L_0x00d1;
                case 5: goto L_0x00cc;
                case 6: goto L_0x00c3;
                case 7: goto L_0x00be;
                case 8: goto L_0x00b5;
                case 9: goto L_0x00b5;
                case 10: goto L_0x008b;
                case 11: goto L_0x0083;
                default: goto L_0x0073;
            }
        L_0x0073:
            java.lang.IllegalArgumentException r10 = new java.lang.IllegalArgumentException
            int r11 = r4.zaqh
            r12 = 36
            java.lang.String r0 = "Unknown field out type = "
            java.lang.String r11 = p009e.p010a.p011a.p012a.C0681a.m309a((int) r12, (java.lang.String) r0, (int) r11)
            r10.<init>(r11)
            throw r10
        L_0x0083:
            java.lang.IllegalArgumentException r10 = new java.lang.IllegalArgumentException
            java.lang.String r11 = "Method does not accept concrete type."
            r10.<init>(r11)
            throw r10
        L_0x008b:
            android.os.Bundle r2 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.createBundle(r12, r3)
            java.util.HashMap r3 = new java.util.HashMap
            r3.<init>()
            java.util.Set r5 = r2.keySet()
            java.util.Iterator r5 = r5.iterator()
        L_0x009c:
            boolean r6 = r5.hasNext()
            if (r6 == 0) goto L_0x00b0
            java.lang.Object r6 = r5.next()
            java.lang.String r6 = (java.lang.String) r6
            java.lang.String r7 = r2.getString(r6)
            r3.put(r6, r7)
            goto L_0x009c
        L_0x00b0:
            java.lang.Object r2 = com.google.android.gms.common.server.response.FastJsonResponse.zab(r4, (java.lang.Object) r3)
            goto L_0x00fd
        L_0x00b5:
            byte[] r2 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.createByteArray(r12, r3)
            java.lang.Object r2 = com.google.android.gms.common.server.response.FastJsonResponse.zab(r4, (java.lang.Object) r2)
            goto L_0x00fd
        L_0x00be:
            java.lang.String r2 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.createString(r12, r3)
            goto L_0x00f9
        L_0x00c3:
            boolean r2 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.readBoolean(r12, r3)
            java.lang.Boolean r2 = java.lang.Boolean.valueOf(r2)
            goto L_0x00f9
        L_0x00cc:
            java.math.BigDecimal r2 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.createBigDecimal(r12, r3)
            goto L_0x00f9
        L_0x00d1:
            double r2 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.readDouble(r12, r3)
            java.lang.Double r2 = java.lang.Double.valueOf(r2)
            goto L_0x00f9
        L_0x00da:
            float r2 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.readFloat(r12, r3)
            java.lang.Float r2 = java.lang.Float.valueOf(r2)
            goto L_0x00f9
        L_0x00e3:
            long r2 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.readLong(r12, r3)
            java.lang.Long r2 = java.lang.Long.valueOf(r2)
            goto L_0x00f9
        L_0x00ec:
            java.math.BigInteger r2 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.createBigInteger(r12, r3)
            goto L_0x00f9
        L_0x00f1:
            int r2 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.readInt(r12, r3)
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)
        L_0x00f9:
            java.lang.Object r2 = com.google.android.gms.common.server.response.FastJsonResponse.zab(r4, (java.lang.Object) r2)
        L_0x00fd:
            r9.zab((java.lang.StringBuilder) r10, (com.google.android.gms.common.server.response.FastJsonResponse.Field<?, ?>) r4, (java.lang.Object) r2)
            goto L_0x023f
        L_0x0102:
            boolean r2 = r4.zaqi
            if (r2 == 0) goto L_0x0180
            java.lang.String r2 = "["
            r10.append(r2)
            int r2 = r4.zaqh
            switch(r2) {
                case 0: goto L_0x0176;
                case 1: goto L_0x016e;
                case 2: goto L_0x0166;
                case 3: goto L_0x015e;
                case 4: goto L_0x0156;
                case 5: goto L_0x014e;
                case 6: goto L_0x0146;
                case 7: goto L_0x013e;
                case 8: goto L_0x0136;
                case 9: goto L_0x0136;
                case 10: goto L_0x0136;
                case 11: goto L_0x0118;
                default: goto L_0x0110;
            }
        L_0x0110:
            java.lang.IllegalStateException r10 = new java.lang.IllegalStateException
            java.lang.String r11 = "Unknown field type out."
            r10.<init>(r11)
            throw r10
        L_0x0118:
            android.os.Parcel[] r2 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.createParcelArray(r12, r3)
            int r3 = r2.length
            r6 = 0
        L_0x011e:
            if (r6 >= r3) goto L_0x017d
            if (r6 <= 0) goto L_0x0125
            r10.append(r5)
        L_0x0125:
            r7 = r2[r6]
            r7.setDataPosition(r1)
            java.util.Map r7 = r4.zaco()
            r8 = r2[r6]
            r9.zaa((java.lang.StringBuilder) r10, (java.util.Map<java.lang.String, com.google.android.gms.common.server.response.FastJsonResponse.Field<?, ?>>) r7, (android.os.Parcel) r8)
            int r6 = r6 + 1
            goto L_0x011e
        L_0x0136:
            java.lang.UnsupportedOperationException r10 = new java.lang.UnsupportedOperationException
            java.lang.String r11 = "List of type BASE64, BASE64_URL_SAFE, or STRING_MAP is not supported"
            r10.<init>(r11)
            throw r10
        L_0x013e:
            java.lang.String[] r2 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.createStringArray(r12, r3)
            com.google.android.gms.common.util.ArrayUtils.writeStringArray(r10, r2)
            goto L_0x017d
        L_0x0146:
            boolean[] r2 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.createBooleanArray(r12, r3)
            com.google.android.gms.common.util.ArrayUtils.writeArray((java.lang.StringBuilder) r10, (boolean[]) r2)
            goto L_0x017d
        L_0x014e:
            java.math.BigDecimal[] r2 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.createBigDecimalArray(r12, r3)
            com.google.android.gms.common.util.ArrayUtils.writeArray((java.lang.StringBuilder) r10, (T[]) r2)
            goto L_0x017d
        L_0x0156:
            double[] r2 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.createDoubleArray(r12, r3)
            com.google.android.gms.common.util.ArrayUtils.writeArray((java.lang.StringBuilder) r10, (double[]) r2)
            goto L_0x017d
        L_0x015e:
            float[] r2 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.createFloatArray(r12, r3)
            com.google.android.gms.common.util.ArrayUtils.writeArray((java.lang.StringBuilder) r10, (float[]) r2)
            goto L_0x017d
        L_0x0166:
            long[] r2 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.createLongArray(r12, r3)
            com.google.android.gms.common.util.ArrayUtils.writeArray((java.lang.StringBuilder) r10, (long[]) r2)
            goto L_0x017d
        L_0x016e:
            java.math.BigInteger[] r2 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.createBigIntegerArray(r12, r3)
            com.google.android.gms.common.util.ArrayUtils.writeArray((java.lang.StringBuilder) r10, (T[]) r2)
            goto L_0x017d
        L_0x0176:
            int[] r2 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.createIntArray(r12, r3)
            com.google.android.gms.common.util.ArrayUtils.writeArray((java.lang.StringBuilder) r10, (int[]) r2)
        L_0x017d:
            java.lang.String r2 = "]"
            goto L_0x01dd
        L_0x0180:
            int r2 = r4.zaqh
            switch(r2) {
                case 0: goto L_0x0238;
                case 1: goto L_0x0230;
                case 2: goto L_0x0228;
                case 3: goto L_0x0220;
                case 4: goto L_0x0218;
                case 5: goto L_0x0213;
                case 6: goto L_0x020b;
                case 7: goto L_0x01f9;
                case 8: goto L_0x01ed;
                case 9: goto L_0x01e1;
                case 10: goto L_0x019d;
                case 11: goto L_0x018d;
                default: goto L_0x0185;
            }
        L_0x0185:
            java.lang.IllegalStateException r10 = new java.lang.IllegalStateException
            java.lang.String r11 = "Unknown field type out"
            r10.<init>(r11)
            throw r10
        L_0x018d:
            android.os.Parcel r2 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.createParcel(r12, r3)
            r2.setDataPosition(r1)
            java.util.Map r3 = r4.zaco()
            r9.zaa((java.lang.StringBuilder) r10, (java.util.Map<java.lang.String, com.google.android.gms.common.server.response.FastJsonResponse.Field<?, ?>>) r3, (android.os.Parcel) r2)
            goto L_0x023f
        L_0x019d:
            android.os.Bundle r2 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.createBundle(r12, r3)
            java.util.Set r3 = r2.keySet()
            r3.size()
            java.lang.String r4 = "{"
            r10.append(r4)
            java.util.Iterator r3 = r3.iterator()
            r4 = 1
        L_0x01b2:
            boolean r7 = r3.hasNext()
            if (r7 == 0) goto L_0x01db
            java.lang.Object r7 = r3.next()
            java.lang.String r7 = (java.lang.String) r7
            if (r4 != 0) goto L_0x01c3
            r10.append(r5)
        L_0x01c3:
            java.lang.String r4 = ":"
            p009e.p010a.p011a.p012a.C0681a.m335a((java.lang.StringBuilder) r10, (java.lang.String) r6, (java.lang.String) r7, (java.lang.String) r6, (java.lang.String) r4)
            r10.append(r6)
            java.lang.String r4 = r2.getString(r7)
            java.lang.String r4 = com.google.android.gms.common.util.JsonUtils.escapeString(r4)
            r10.append(r4)
            r10.append(r6)
            r4 = 0
            goto L_0x01b2
        L_0x01db:
            java.lang.String r2 = "}"
        L_0x01dd:
            r10.append(r2)
            goto L_0x023f
        L_0x01e1:
            byte[] r2 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.createByteArray(r12, r3)
            r10.append(r6)
            java.lang.String r2 = com.google.android.gms.common.util.Base64Utils.encodeUrlSafe(r2)
            goto L_0x0204
        L_0x01ed:
            byte[] r2 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.createByteArray(r12, r3)
            r10.append(r6)
            java.lang.String r2 = com.google.android.gms.common.util.Base64Utils.encode(r2)
            goto L_0x0204
        L_0x01f9:
            java.lang.String r2 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.createString(r12, r3)
            r10.append(r6)
            java.lang.String r2 = com.google.android.gms.common.util.JsonUtils.escapeString(r2)
        L_0x0204:
            r10.append(r2)
            r10.append(r6)
            goto L_0x023f
        L_0x020b:
            boolean r2 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.readBoolean(r12, r3)
            r10.append(r2)
            goto L_0x023f
        L_0x0213:
            java.math.BigDecimal r2 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.createBigDecimal(r12, r3)
            goto L_0x0234
        L_0x0218:
            double r2 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.readDouble(r12, r3)
            r10.append(r2)
            goto L_0x023f
        L_0x0220:
            float r2 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.readFloat(r12, r3)
            r10.append(r2)
            goto L_0x023f
        L_0x0228:
            long r2 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.readLong(r12, r3)
            r10.append(r2)
            goto L_0x023f
        L_0x0230:
            java.math.BigInteger r2 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.createBigInteger(r12, r3)
        L_0x0234:
            r10.append(r2)
            goto L_0x023f
        L_0x0238:
            int r2 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.readInt(r12, r3)
            r10.append(r2)
        L_0x023f:
            r2 = 1
            goto L_0x0032
        L_0x0242:
            int r0 = r12.dataPosition()
            if (r0 != r11) goto L_0x024e
            r11 = 125(0x7d, float:1.75E-43)
            r10.append(r11)
            return
        L_0x024e:
            com.google.android.gms.common.internal.safeparcel.SafeParcelReader$ParseException r10 = new com.google.android.gms.common.internal.safeparcel.SafeParcelReader$ParseException
            r0 = 37
            java.lang.String r1 = "Overread allowed size end="
            java.lang.String r11 = p009e.p010a.p011a.p012a.C0681a.m309a((int) r0, (java.lang.String) r1, (int) r11)
            r10.<init>(r11, r12)
            goto L_0x025d
        L_0x025c:
            throw r10
        L_0x025d:
            goto L_0x025c
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.common.server.response.SafeParcelResponse.zaa(java.lang.StringBuilder, java.util.Map, android.os.Parcel):void");
    }

    private final void zab(FastJsonResponse.Field<?, ?> field) {
        if (field.zaqk != -1) {
            Parcel parcel = this.zarp;
            if (parcel != null) {
                int i = this.zarr;
                if (i == 0) {
                    this.zars = SafeParcelWriter.beginObjectHeader(parcel);
                    this.zarr = 1;
                } else if (i == 1) {
                } else {
                    if (i != 2) {
                        throw new IllegalStateException("Unknown parse state in SafeParcelResponse.");
                    }
                    throw new IllegalStateException("Attempted to parse JSON with a SafeParcelResponse object that is already filled with data.");
                }
            } else {
                throw new IllegalStateException("Internal Parcel object is null.");
            }
        } else {
            throw new IllegalStateException("Field does not have a valid safe parcelable field id.");
        }
    }

    private final void zab(StringBuilder sb, FastJsonResponse.Field<?, ?> field, Object obj) {
        if (field.zaqg) {
            ArrayList arrayList = (ArrayList) obj;
            sb.append("[");
            int size = arrayList.size();
            for (int i = 0; i < size; i++) {
                if (i != 0) {
                    sb.append(",");
                }
                zaa(sb, field.zaqf, arrayList.get(i));
            }
            sb.append("]");
            return;
        }
        zaa(sb, field.zaqf, obj);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:3:0x0005, code lost:
        if (r0 != 1) goto L_0x001a;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final android.os.Parcel zacs() {
        /*
            r2 = this;
            int r0 = r2.zarr
            if (r0 == 0) goto L_0x0008
            r1 = 1
            if (r0 == r1) goto L_0x0010
            goto L_0x001a
        L_0x0008:
            android.os.Parcel r0 = r2.zarp
            int r0 = com.google.android.gms.common.internal.safeparcel.SafeParcelWriter.beginObjectHeader(r0)
            r2.zars = r0
        L_0x0010:
            android.os.Parcel r0 = r2.zarp
            int r1 = r2.zars
            com.google.android.gms.common.internal.safeparcel.SafeParcelWriter.finishObjectHeader(r0, r1)
            r0 = 2
            r2.zarr = r0
        L_0x001a:
            android.os.Parcel r0 = r2.zarp
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.common.server.response.SafeParcelResponse.zacs():android.os.Parcel");
    }

    public <T extends FastJsonResponse> void addConcreteTypeArrayInternal(FastJsonResponse.Field<?, ?> field, String str, ArrayList<T> arrayList) {
        zab(field);
        ArrayList arrayList2 = new ArrayList();
        arrayList.size();
        int size = arrayList.size();
        int i = 0;
        while (i < size) {
            T t = arrayList.get(i);
            i++;
            arrayList2.add(((SafeParcelResponse) ((FastJsonResponse) t)).zacs());
        }
        SafeParcelWriter.writeParcelList(this.zarp, field.getSafeParcelableFieldId(), arrayList2, true);
    }

    public <T extends FastJsonResponse> void addConcreteTypeInternal(FastJsonResponse.Field<?, ?> field, String str, T t) {
        zab(field);
        SafeParcelWriter.writeParcel(this.zarp, field.getSafeParcelableFieldId(), ((SafeParcelResponse) t).zacs(), true);
    }

    public Map<String, FastJsonResponse.Field<?, ?>> getFieldMappings() {
        zaj zaj = this.zaqn;
        if (zaj == null) {
            return null;
        }
        return zaj.zai(this.mClassName);
    }

    public Object getValueObject(String str) {
        throw new UnsupportedOperationException("Converting to JSON does not require this method.");
    }

    public boolean isPrimitiveFieldSet(String str) {
        throw new UnsupportedOperationException("Converting to JSON does not require this method.");
    }

    /* access modifiers changed from: protected */
    public void setBooleanInternal(FastJsonResponse.Field<?, ?> field, String str, boolean z) {
        zab(field);
        SafeParcelWriter.writeBoolean(this.zarp, field.getSafeParcelableFieldId(), z);
    }

    /* access modifiers changed from: protected */
    public void setDecodedBytesInternal(FastJsonResponse.Field<?, ?> field, String str, byte[] bArr) {
        zab(field);
        SafeParcelWriter.writeByteArray(this.zarp, field.getSafeParcelableFieldId(), bArr, true);
    }

    /* access modifiers changed from: protected */
    public void setIntegerInternal(FastJsonResponse.Field<?, ?> field, String str, int i) {
        zab(field);
        SafeParcelWriter.writeInt(this.zarp, field.getSafeParcelableFieldId(), i);
    }

    /* access modifiers changed from: protected */
    public void setLongInternal(FastJsonResponse.Field<?, ?> field, String str, long j) {
        zab(field);
        SafeParcelWriter.writeLong(this.zarp, field.getSafeParcelableFieldId(), j);
    }

    /* access modifiers changed from: protected */
    public void setStringInternal(FastJsonResponse.Field<?, ?> field, String str, String str2) {
        zab(field);
        SafeParcelWriter.writeString(this.zarp, field.getSafeParcelableFieldId(), str2, true);
    }

    /* access modifiers changed from: protected */
    public void setStringMapInternal(FastJsonResponse.Field<?, ?> field, String str, Map<String, String> map) {
        zab(field);
        Bundle bundle = new Bundle();
        for (String next : map.keySet()) {
            bundle.putString(next, map.get(next));
        }
        SafeParcelWriter.writeBundle(this.zarp, field.getSafeParcelableFieldId(), bundle, true);
    }

    /* access modifiers changed from: protected */
    public void setStringsInternal(FastJsonResponse.Field<?, ?> field, String str, ArrayList<String> arrayList) {
        zab(field);
        int size = arrayList.size();
        String[] strArr = new String[size];
        for (int i = 0; i < size; i++) {
            strArr[i] = arrayList.get(i);
        }
        SafeParcelWriter.writeStringArray(this.zarp, field.getSafeParcelableFieldId(), strArr, true);
    }

    public String toString() {
        Preconditions.checkNotNull(this.zaqn, "Cannot convert to JSON on client side.");
        Parcel zacs = zacs();
        zacs.setDataPosition(0);
        StringBuilder sb = new StringBuilder(100);
        zaa(sb, this.zaqn.zai(this.mClassName), zacs);
        return sb.toString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        zaj zaj;
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeInt(parcel, 1, this.zali);
        SafeParcelWriter.writeParcel(parcel, 2, zacs(), false);
        int i2 = this.zarq;
        if (i2 == 0) {
            zaj = null;
        } else if (i2 == 1 || i2 == 2) {
            zaj = this.zaqn;
        } else {
            throw new IllegalStateException(C0681a.m309a(34, "Invalid creation type: ", this.zarq));
        }
        SafeParcelWriter.writeParcelable(parcel, 3, zaj, i, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }

    /* access modifiers changed from: protected */
    public final void zaa(FastJsonResponse.Field<?, ?> field, String str, double d) {
        zab(field);
        SafeParcelWriter.writeDouble(this.zarp, field.getSafeParcelableFieldId(), d);
    }

    /* access modifiers changed from: protected */
    public final void zaa(FastJsonResponse.Field<?, ?> field, String str, float f) {
        zab(field);
        SafeParcelWriter.writeFloat(this.zarp, field.getSafeParcelableFieldId(), f);
    }

    /* access modifiers changed from: protected */
    public final void zaa(FastJsonResponse.Field<?, ?> field, String str, BigDecimal bigDecimal) {
        zab(field);
        SafeParcelWriter.writeBigDecimal(this.zarp, field.getSafeParcelableFieldId(), bigDecimal, true);
    }

    /* access modifiers changed from: protected */
    public final void zaa(FastJsonResponse.Field<?, ?> field, String str, BigInteger bigInteger) {
        zab(field);
        SafeParcelWriter.writeBigInteger(this.zarp, field.getSafeParcelableFieldId(), bigInteger, true);
    }

    /* access modifiers changed from: protected */
    public final void zaa(FastJsonResponse.Field<?, ?> field, String str, ArrayList<Integer> arrayList) {
        zab(field);
        int size = arrayList.size();
        int[] iArr = new int[size];
        for (int i = 0; i < size; i++) {
            iArr[i] = arrayList.get(i).intValue();
        }
        SafeParcelWriter.writeIntArray(this.zarp, field.getSafeParcelableFieldId(), iArr, true);
    }

    /* access modifiers changed from: protected */
    public final void zab(FastJsonResponse.Field<?, ?> field, String str, ArrayList<BigInteger> arrayList) {
        zab(field);
        int size = arrayList.size();
        BigInteger[] bigIntegerArr = new BigInteger[size];
        for (int i = 0; i < size; i++) {
            bigIntegerArr[i] = arrayList.get(i);
        }
        SafeParcelWriter.writeBigIntegerArray(this.zarp, field.getSafeParcelableFieldId(), bigIntegerArr, true);
    }

    /* access modifiers changed from: protected */
    public final void zac(FastJsonResponse.Field<?, ?> field, String str, ArrayList<Long> arrayList) {
        zab(field);
        int size = arrayList.size();
        long[] jArr = new long[size];
        for (int i = 0; i < size; i++) {
            jArr[i] = arrayList.get(i).longValue();
        }
        SafeParcelWriter.writeLongArray(this.zarp, field.getSafeParcelableFieldId(), jArr, true);
    }

    /* access modifiers changed from: protected */
    public final void zad(FastJsonResponse.Field<?, ?> field, String str, ArrayList<Float> arrayList) {
        zab(field);
        int size = arrayList.size();
        float[] fArr = new float[size];
        for (int i = 0; i < size; i++) {
            fArr[i] = arrayList.get(i).floatValue();
        }
        SafeParcelWriter.writeFloatArray(this.zarp, field.getSafeParcelableFieldId(), fArr, true);
    }

    /* access modifiers changed from: protected */
    public final void zae(FastJsonResponse.Field<?, ?> field, String str, ArrayList<Double> arrayList) {
        zab(field);
        int size = arrayList.size();
        double[] dArr = new double[size];
        for (int i = 0; i < size; i++) {
            dArr[i] = arrayList.get(i).doubleValue();
        }
        SafeParcelWriter.writeDoubleArray(this.zarp, field.getSafeParcelableFieldId(), dArr, true);
    }

    /* access modifiers changed from: protected */
    public final void zaf(FastJsonResponse.Field<?, ?> field, String str, ArrayList<BigDecimal> arrayList) {
        zab(field);
        int size = arrayList.size();
        BigDecimal[] bigDecimalArr = new BigDecimal[size];
        for (int i = 0; i < size; i++) {
            bigDecimalArr[i] = arrayList.get(i);
        }
        SafeParcelWriter.writeBigDecimalArray(this.zarp, field.getSafeParcelableFieldId(), bigDecimalArr, true);
    }

    /* access modifiers changed from: protected */
    public final void zag(FastJsonResponse.Field<?, ?> field, String str, ArrayList<Boolean> arrayList) {
        zab(field);
        int size = arrayList.size();
        boolean[] zArr = new boolean[size];
        for (int i = 0; i < size; i++) {
            zArr[i] = arrayList.get(i).booleanValue();
        }
        SafeParcelWriter.writeBooleanArray(this.zarp, field.getSafeParcelableFieldId(), zArr, true);
    }
}
