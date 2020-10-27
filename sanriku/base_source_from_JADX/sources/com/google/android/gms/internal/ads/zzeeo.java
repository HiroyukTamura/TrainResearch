package com.google.android.gms.internal.ads;

import java.util.Collections;
import java.util.List;
import java.util.Map;

final class zzeeo extends zzeel<FieldDescriptorType, Object> {
    zzeeo(int i) {
        super(i, (zzeeo) null);
    }

    public final void zzbcj() {
        if (!isImmutable()) {
            for (int i = 0; i < zzbgq(); i++) {
                Map.Entry zzhj = zzhj(i);
                if (((zzebv) zzhj.getKey()).zzbel()) {
                    zzhj.setValue(Collections.unmodifiableList((List) zzhj.getValue()));
                }
            }
            for (Map.Entry entry : zzbgr()) {
                if (((zzebv) entry.getKey()).zzbel()) {
                    entry.setValue(Collections.unmodifiableList((List) entry.getValue()));
                }
            }
        }
        super.zzbcj();
    }
}
