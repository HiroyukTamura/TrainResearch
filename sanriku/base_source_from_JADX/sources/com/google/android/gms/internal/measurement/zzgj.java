package com.google.android.gms.internal.measurement;

import com.google.android.gms.internal.measurement.zzgi;
import com.google.android.gms.internal.measurement.zzgj;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import p009e.p010a.p011a.p012a.C0681a;

public abstract class zzgj<MessageType extends zzgj<MessageType, BuilderType>, BuilderType extends zzgi<MessageType, BuilderType>> implements zzjj {
    protected int zza = 0;

    protected static <T> void zza(Iterable<T> iterable, List<? super T> list) {
        zzie.zza(iterable);
        if (iterable instanceof zziu) {
            List<?> zzd = ((zziu) iterable).zzd();
            zziu zziu = (zziu) list;
            int size = list.size();
            for (Object next : zzd) {
                if (next == null) {
                    String a = C0681a.m310a(37, "Element at index ", zziu.size() - size, " is null.");
                    int size2 = zziu.size();
                    while (true) {
                        size2--;
                        if (size2 >= size) {
                            zziu.remove(size2);
                        } else {
                            throw new NullPointerException(a);
                        }
                    }
                } else if (next instanceof zzgt) {
                    zziu.zza((zzgt) next);
                } else {
                    zziu.add((String) next);
                }
            }
        } else if (iterable instanceof zzjv) {
            list.addAll((Collection) iterable);
        } else {
            if ((list instanceof ArrayList) && (iterable instanceof Collection)) {
                ((ArrayList) list).ensureCapacity(((Collection) iterable).size() + list.size());
            }
            int size3 = list.size();
            for (T next2 : iterable) {
                if (next2 == null) {
                    String a2 = C0681a.m310a(37, "Element at index ", list.size() - size3, " is null.");
                    int size4 = list.size();
                    while (true) {
                        size4--;
                        if (size4 >= size3) {
                            list.remove(size4);
                        } else {
                            throw new NullPointerException(a2);
                        }
                    }
                } else {
                    list.add(next2);
                }
            }
        }
    }

    public final zzgt zzbh() {
        try {
            zzhb zzc = zzgt.zzc(zzbm());
            zza(zzc.zzb());
            return zzc.zza();
        } catch (IOException e) {
            String name = getClass().getName();
            StringBuilder b = C0681a.m337b("ByteString".length() + name.length() + 62, "Serializing ", name, " to a ", "ByteString");
            b.append(" threw an IOException (should never happen).");
            throw new RuntimeException(b.toString(), e);
        }
    }

    public final byte[] zzbi() {
        try {
            byte[] bArr = new byte[zzbm()];
            zzhi zza2 = zzhi.zza(bArr);
            zza(zza2);
            zza2.zzb();
            return bArr;
        } catch (IOException e) {
            String name = getClass().getName();
            StringBuilder b = C0681a.m337b("byte array".length() + name.length() + 62, "Serializing ", name, " to a ", "byte array");
            b.append(" threw an IOException (should never happen).");
            throw new RuntimeException(b.toString(), e);
        }
    }

    /* access modifiers changed from: package-private */
    public int zzbj() {
        throw new UnsupportedOperationException();
    }

    /* access modifiers changed from: package-private */
    public void zzc(int i) {
        throw new UnsupportedOperationException();
    }
}
