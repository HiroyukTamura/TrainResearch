package com.google.android.gms.internal.gtm;

import java.util.Collections;
import java.util.List;
import java.util.Map;

final class zztd extends zztc<FieldDescriptorType, Object> {
    zztd(int i) {
        super(i, (zztd) null);
    }

    public final void zzmi() {
        if (!isImmutable()) {
            for (int i = 0; i < zzra(); i++) {
                Map.Entry zzbv = zzbv(i);
                if (((zzqv) zzbv.getKey()).zzoz()) {
                    zzbv.setValue(Collections.unmodifiableList((List) zzbv.getValue()));
                }
            }
            for (Map.Entry entry : zzrb()) {
                if (((zzqv) entry.getKey()).zzoz()) {
                    entry.setValue(Collections.unmodifiableList((List) entry.getValue()));
                }
            }
        }
        super.zzmi();
    }
}
