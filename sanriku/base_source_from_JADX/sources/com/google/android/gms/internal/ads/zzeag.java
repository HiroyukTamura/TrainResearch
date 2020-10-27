package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzeag;
import com.google.android.gms.internal.ads.zzeaj;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import p009e.p010a.p011a.p012a.C0681a;

public abstract class zzeag<MessageType extends zzeag<MessageType, BuilderType>, BuilderType extends zzeaj<MessageType, BuilderType>> implements zzedo {
    protected int zzhsq = 0;

    protected static <T> void zza(Iterable<T> iterable, List<? super T> list) {
        zzecg.checkNotNull(iterable);
        if (iterable instanceof zzecv) {
            List<?> zzbfs = ((zzecv) iterable).zzbfs();
            zzecv zzecv = (zzecv) list;
            int size = list.size();
            for (Object next : zzbfs) {
                if (next == null) {
                    String a = C0681a.m310a(37, "Element at index ", zzecv.size() - size, " is null.");
                    int size2 = zzecv.size();
                    while (true) {
                        size2--;
                        if (size2 >= size) {
                            zzecv.remove(size2);
                        } else {
                            throw new NullPointerException(a);
                        }
                    }
                } else if (next instanceof zzeaq) {
                    zzecv.zzaj((zzeaq) next);
                } else {
                    zzecv.add((String) next);
                }
            }
        } else if (iterable instanceof zzeea) {
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

    public final byte[] toByteArray() {
        try {
            byte[] bArr = new byte[zzbex()];
            zzebk zzw = zzebk.zzw(bArr);
            zzb(zzw);
            zzw.zzbdz();
            return bArr;
        } catch (IOException e) {
            String name = getClass().getName();
            StringBuilder b = C0681a.m337b("byte array".length() + name.length() + 62, "Serializing ", name, " to a ", "byte array");
            b.append(" threw an IOException (should never happen).");
            throw new RuntimeException(b.toString(), e);
        }
    }

    public final zzeaq zzbce() {
        try {
            zzeay zzfq = zzeaq.zzfq(zzbex());
            zzb(zzfq.zzbcx());
            return zzfq.zzbcw();
        } catch (IOException e) {
            String name = getClass().getName();
            StringBuilder b = C0681a.m337b("ByteString".length() + name.length() + 62, "Serializing ", name, " to a ", "ByteString");
            b.append(" threw an IOException (should never happen).");
            throw new RuntimeException(b.toString(), e);
        }
    }

    /* access modifiers changed from: package-private */
    public int zzbcf() {
        throw new UnsupportedOperationException();
    }

    /* access modifiers changed from: package-private */
    public void zzfk(int i) {
        throw new UnsupportedOperationException();
    }
}
