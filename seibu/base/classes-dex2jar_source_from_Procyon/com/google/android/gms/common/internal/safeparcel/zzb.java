// 
// Decompiled by Procyon v0.5.36
// 

package com.google.android.gms.common.internal.safeparcel;

import android.os.Bundle;
import android.os.IBinder;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.List;
import android.os.Parcelable;
import android.os.Parcelable$Creator;
import java.util.ArrayList;
import android.os.Parcel;

public final class zzb
{
    public static String[] zzA(final Parcel parcel, int zza) {
        zza = zza(parcel, zza);
        final int dataPosition = parcel.dataPosition();
        if (zza == 0) {
            return null;
        }
        final String[] stringArray = parcel.createStringArray();
        parcel.setDataPosition(zza + dataPosition);
        return stringArray;
    }
    
    public static ArrayList<Integer> zzB(final Parcel parcel, int i) {
        final int zza = zza(parcel, i);
        final int dataPosition = parcel.dataPosition();
        if (zza == 0) {
            return null;
        }
        final ArrayList<Integer> list = new ArrayList<Integer>();
        int int1;
        for (int1 = parcel.readInt(), i = 0; i < int1; ++i) {
            list.add(parcel.readInt());
        }
        parcel.setDataPosition(dataPosition + zza);
        return list;
    }
    
    public static ArrayList<String> zzC(final Parcel parcel, int zza) {
        zza = zza(parcel, zza);
        final int dataPosition = parcel.dataPosition();
        if (zza == 0) {
            return null;
        }
        final ArrayList stringArrayList = parcel.createStringArrayList();
        parcel.setDataPosition(zza + dataPosition);
        return (ArrayList<String>)stringArrayList;
    }
    
    public static Parcel zzD(final Parcel parcel, int zza) {
        zza = zza(parcel, zza);
        final int dataPosition = parcel.dataPosition();
        if (zza == 0) {
            return null;
        }
        final Parcel obtain = Parcel.obtain();
        obtain.appendFrom(parcel, dataPosition, zza);
        parcel.setDataPosition(zza + dataPosition);
        return obtain;
    }
    
    public static Parcel[] zzE(final Parcel parcel, int i) {
        final int zza = zza(parcel, i);
        final int dataPosition = parcel.dataPosition();
        if (zza == 0) {
            return null;
        }
        final int int1 = parcel.readInt();
        final Parcel[] array = new Parcel[int1];
        int int2;
        int dataPosition2;
        Parcel obtain;
        for (i = 0; i < int1; ++i) {
            int2 = parcel.readInt();
            if (int2 != 0) {
                dataPosition2 = parcel.dataPosition();
                obtain = Parcel.obtain();
                obtain.appendFrom(parcel, dataPosition2, int2);
                array[i] = obtain;
                parcel.setDataPosition(int2 + dataPosition2);
            }
            else {
                array[i] = null;
            }
        }
        parcel.setDataPosition(dataPosition + zza);
        return array;
    }
    
    public static void zzF(final Parcel parcel, final int i) {
        if (parcel.dataPosition() != i) {
            throw new zzc(new StringBuilder(37).append("Overread allowed size end=").append(i).toString(), parcel);
        }
    }
    
    public static int zza(final Parcel parcel, final int n) {
        if ((n & 0xFFFF0000) != 0xFFFF0000) {
            return n >> 16 & 0xFFFF;
        }
        return parcel.readInt();
    }
    
    public static <T extends Parcelable> T zza(final Parcel parcel, int zza, final Parcelable$Creator<T> parcelable$Creator) {
        zza = zza(parcel, zza);
        final int dataPosition = parcel.dataPosition();
        if (zza == 0) {
            return null;
        }
        final Parcelable parcelable = (Parcelable)parcelable$Creator.createFromParcel(parcel);
        parcel.setDataPosition(zza + dataPosition);
        return (T)parcelable;
    }
    
    private static void zza(final Parcel parcel, int zza, final int i) {
        zza = zza(parcel, zza);
        if (zza != i) {
            final String value = String.valueOf(Integer.toHexString(zza));
            throw new zzc(new StringBuilder(String.valueOf(value).length() + 46).append("Expected size ").append(i).append(" got ").append(zza).append(" (0x").append(value).append(")").toString(), parcel);
        }
    }
    
    private static void zza(final Parcel parcel, final int n, final int n2, final int i) {
        if (n2 != i) {
            final String value = String.valueOf(Integer.toHexString(n2));
            throw new zzc(new StringBuilder(String.valueOf(value).length() + 46).append("Expected size ").append(i).append(" got ").append(n2).append(" (0x").append(value).append(")").toString(), parcel);
        }
    }
    
    public static void zza(final Parcel parcel, int zza, final List list, final ClassLoader classLoader) {
        zza = zza(parcel, zza);
        final int dataPosition = parcel.dataPosition();
        if (zza == 0) {
            return;
        }
        parcel.readList(list, classLoader);
        parcel.setDataPosition(zza + dataPosition);
    }
    
    public static void zzb(final Parcel parcel, final int n) {
        parcel.setDataPosition(zza(parcel, n) + parcel.dataPosition());
    }
    
    public static <T> T[] zzb(final Parcel parcel, int zza, final Parcelable$Creator<T> parcelable$Creator) {
        zza = zza(parcel, zza);
        final int dataPosition = parcel.dataPosition();
        if (zza == 0) {
            return null;
        }
        final Object[] typedArray = parcel.createTypedArray((Parcelable$Creator)parcelable$Creator);
        parcel.setDataPosition(zza + dataPosition);
        return (T[])typedArray;
    }
    
    public static <T> ArrayList<T> zzc(final Parcel parcel, int zza, final Parcelable$Creator<T> parcelable$Creator) {
        zza = zza(parcel, zza);
        final int dataPosition = parcel.dataPosition();
        if (zza == 0) {
            return null;
        }
        final ArrayList typedArrayList = parcel.createTypedArrayList((Parcelable$Creator)parcelable$Creator);
        parcel.setDataPosition(zza + dataPosition);
        return (ArrayList<T>)typedArrayList;
    }
    
    public static boolean zzc(final Parcel parcel, final int n) {
        zza(parcel, n, 4);
        return parcel.readInt() != 0;
    }
    
    public static int zzd(final Parcel parcel) {
        final int int1 = parcel.readInt();
        final int zza = zza(parcel, int1);
        final int dataPosition = parcel.dataPosition();
        if ((0xFFFF & int1) != 0x4F45) {
            final String value = String.valueOf(Integer.toHexString(int1));
            String concat;
            if (value.length() != 0) {
                concat = "Expected object header. Got 0x".concat(value);
            }
            else {
                concat = new String("Expected object header. Got 0x");
            }
            throw new zzc(concat, parcel);
        }
        final int i = dataPosition + zza;
        if (i < dataPosition || i > parcel.dataSize()) {
            throw new zzc(new StringBuilder(54).append("Size read is invalid start=").append(dataPosition).append(" end=").append(i).toString(), parcel);
        }
        return i;
    }
    
    public static Boolean zzd(final Parcel parcel, final int n) {
        final int zza = zza(parcel, n);
        if (zza == 0) {
            return null;
        }
        zza(parcel, n, zza, 4);
        return parcel.readInt() != 0;
    }
    
    public static byte zze(final Parcel parcel, final int n) {
        zza(parcel, n, 4);
        return (byte)parcel.readInt();
    }
    
    public static short zzf(final Parcel parcel, final int n) {
        zza(parcel, n, 4);
        return (short)parcel.readInt();
    }
    
    public static int zzg(final Parcel parcel, final int n) {
        zza(parcel, n, 4);
        return parcel.readInt();
    }
    
    public static Integer zzh(final Parcel parcel, final int n) {
        final int zza = zza(parcel, n);
        if (zza == 0) {
            return null;
        }
        zza(parcel, n, zza, 4);
        return parcel.readInt();
    }
    
    public static long zzi(final Parcel parcel, final int n) {
        zza(parcel, n, 8);
        return parcel.readLong();
    }
    
    public static Long zzj(final Parcel parcel, final int n) {
        final int zza = zza(parcel, n);
        if (zza == 0) {
            return null;
        }
        zza(parcel, n, zza, 8);
        return parcel.readLong();
    }
    
    public static BigInteger zzk(final Parcel parcel, int zza) {
        zza = zza(parcel, zza);
        final int dataPosition = parcel.dataPosition();
        if (zza == 0) {
            return null;
        }
        final byte[] byteArray = parcel.createByteArray();
        parcel.setDataPosition(zza + dataPosition);
        return new BigInteger(byteArray);
    }
    
    public static float zzl(final Parcel parcel, final int n) {
        zza(parcel, n, 4);
        return parcel.readFloat();
    }
    
    public static Float zzm(final Parcel parcel, final int n) {
        final int zza = zza(parcel, n);
        if (zza == 0) {
            return null;
        }
        zza(parcel, n, zza, 4);
        return parcel.readFloat();
    }
    
    public static double zzn(final Parcel parcel, final int n) {
        zza(parcel, n, 8);
        return parcel.readDouble();
    }
    
    public static Double zzo(final Parcel parcel, final int n) {
        final int zza = zza(parcel, n);
        if (zza == 0) {
            return null;
        }
        zza(parcel, n, zza, 8);
        return parcel.readDouble();
    }
    
    public static BigDecimal zzp(final Parcel parcel, int zza) {
        zza = zza(parcel, zza);
        final int dataPosition = parcel.dataPosition();
        if (zza == 0) {
            return null;
        }
        final byte[] byteArray = parcel.createByteArray();
        final int int1 = parcel.readInt();
        parcel.setDataPosition(zza + dataPosition);
        return new BigDecimal(new BigInteger(byteArray), int1);
    }
    
    public static String zzq(final Parcel parcel, int zza) {
        zza = zza(parcel, zza);
        final int dataPosition = parcel.dataPosition();
        if (zza == 0) {
            return null;
        }
        final String string = parcel.readString();
        parcel.setDataPosition(zza + dataPosition);
        return string;
    }
    
    public static IBinder zzr(final Parcel parcel, int zza) {
        zza = zza(parcel, zza);
        final int dataPosition = parcel.dataPosition();
        if (zza == 0) {
            return null;
        }
        final IBinder strongBinder = parcel.readStrongBinder();
        parcel.setDataPosition(zza + dataPosition);
        return strongBinder;
    }
    
    public static Bundle zzs(final Parcel parcel, int zza) {
        zza = zza(parcel, zza);
        final int dataPosition = parcel.dataPosition();
        if (zza == 0) {
            return null;
        }
        final Bundle bundle = parcel.readBundle();
        parcel.setDataPosition(zza + dataPosition);
        return bundle;
    }
    
    public static byte[] zzt(final Parcel parcel, int zza) {
        zza = zza(parcel, zza);
        final int dataPosition = parcel.dataPosition();
        if (zza == 0) {
            return null;
        }
        final byte[] byteArray = parcel.createByteArray();
        parcel.setDataPosition(zza + dataPosition);
        return byteArray;
    }
    
    public static byte[][] zzu(final Parcel parcel, int i) {
        final int zza = zza(parcel, i);
        final int dataPosition = parcel.dataPosition();
        if (zza == 0) {
            return null;
        }
        final int int1 = parcel.readInt();
        final byte[][] array = new byte[int1][];
        for (i = 0; i < int1; ++i) {
            array[i] = parcel.createByteArray();
        }
        parcel.setDataPosition(dataPosition + zza);
        return array;
    }
    
    public static boolean[] zzv(final Parcel parcel, int zza) {
        zza = zza(parcel, zza);
        final int dataPosition = parcel.dataPosition();
        if (zza == 0) {
            return null;
        }
        final boolean[] booleanArray = parcel.createBooleanArray();
        parcel.setDataPosition(zza + dataPosition);
        return booleanArray;
    }
    
    public static int[] zzw(final Parcel parcel, int zza) {
        zza = zza(parcel, zza);
        final int dataPosition = parcel.dataPosition();
        if (zza == 0) {
            return null;
        }
        final int[] intArray = parcel.createIntArray();
        parcel.setDataPosition(zza + dataPosition);
        return intArray;
    }
    
    public static long[] zzx(final Parcel parcel, int zza) {
        zza = zza(parcel, zza);
        final int dataPosition = parcel.dataPosition();
        if (zza == 0) {
            return null;
        }
        final long[] longArray = parcel.createLongArray();
        parcel.setDataPosition(zza + dataPosition);
        return longArray;
    }
    
    public static float[] zzy(final Parcel parcel, int zza) {
        zza = zza(parcel, zza);
        final int dataPosition = parcel.dataPosition();
        if (zza == 0) {
            return null;
        }
        final float[] floatArray = parcel.createFloatArray();
        parcel.setDataPosition(zza + dataPosition);
        return floatArray;
    }
    
    public static BigDecimal[] zzz(final Parcel parcel, int i) {
        final int zza = zza(parcel, i);
        final int dataPosition = parcel.dataPosition();
        if (zza == 0) {
            return null;
        }
        final int int1 = parcel.readInt();
        final BigDecimal[] array = new BigDecimal[int1];
        for (i = 0; i < int1; ++i) {
            array[i] = new BigDecimal(new BigInteger(parcel.createByteArray()), parcel.readInt());
        }
        parcel.setDataPosition(dataPosition + zza);
        return array;
    }
}
