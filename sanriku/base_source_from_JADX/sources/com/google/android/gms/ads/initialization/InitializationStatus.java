package com.google.android.gms.ads.initialization;

import java.util.Map;

public interface InitializationStatus {
    Map<String, AdapterStatus> getAdapterStatusMap();
}
