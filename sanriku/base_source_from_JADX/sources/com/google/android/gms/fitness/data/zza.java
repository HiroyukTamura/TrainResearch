package com.google.android.gms.fitness.data;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class zza {
    static final Map<DataType, List<DataType>> zzik;

    static {
        HashMap hashMap = new HashMap();
        zzik = hashMap;
        hashMap.put(DataType.TYPE_MOVE_MINUTES, Collections.singletonList(DataType.AGGREGATE_MOVE_MINUTES));
        zzik.put(DataType.TYPE_HEART_POINTS, Collections.singletonList(DataType.AGGREGATE_HEART_POINTS));
        zzik.put(DataType.TYPE_ACTIVITY_SEGMENT, Collections.singletonList(DataType.AGGREGATE_ACTIVITY_SUMMARY));
        zzik.put(DataType.TYPE_BASAL_METABOLIC_RATE, Collections.singletonList(DataType.AGGREGATE_BASAL_METABOLIC_RATE_SUMMARY));
        zzik.put(DataType.TYPE_BODY_FAT_PERCENTAGE, Collections.singletonList(DataType.AGGREGATE_BODY_FAT_PERCENTAGE_SUMMARY));
        zzik.put(DataType.TYPE_CALORIES_EXPENDED, Collections.singletonList(DataType.AGGREGATE_CALORIES_EXPENDED));
        zzik.put(DataType.TYPE_DISTANCE_DELTA, Collections.singletonList(DataType.AGGREGATE_DISTANCE_DELTA));
        zzik.put(DataType.zzjp, Collections.singletonList(DataType.zzju));
        zzik.put(DataType.TYPE_LOCATION_SAMPLE, Collections.singletonList(DataType.AGGREGATE_LOCATION_BOUNDING_BOX));
        zzik.put(DataType.TYPE_NUTRITION, Collections.singletonList(DataType.AGGREGATE_NUTRITION_SUMMARY));
        zzik.put(DataType.TYPE_HYDRATION, Collections.singletonList(DataType.AGGREGATE_HYDRATION));
        zzik.put(DataType.TYPE_HEART_RATE_BPM, Collections.singletonList(DataType.AGGREGATE_HEART_RATE_SUMMARY));
        zzik.put(DataType.TYPE_POWER_SAMPLE, Collections.singletonList(DataType.AGGREGATE_POWER_SUMMARY));
        zzik.put(DataType.TYPE_SPEED, Collections.singletonList(DataType.AGGREGATE_SPEED_SUMMARY));
        zzik.put(DataType.TYPE_STEP_COUNT_DELTA, Collections.singletonList(DataType.AGGREGATE_STEP_COUNT_DELTA));
        zzik.put(DataType.TYPE_WEIGHT, Collections.singletonList(DataType.AGGREGATE_WEIGHT_SUMMARY));
        zzik.put(HealthDataTypes.TYPE_BLOOD_PRESSURE, Collections.singletonList(HealthDataTypes.AGGREGATE_BLOOD_PRESSURE_SUMMARY));
        zzik.put(HealthDataTypes.TYPE_BLOOD_GLUCOSE, Collections.singletonList(HealthDataTypes.AGGREGATE_BLOOD_GLUCOSE_SUMMARY));
        zzik.put(HealthDataTypes.TYPE_OXYGEN_SATURATION, Collections.singletonList(HealthDataTypes.AGGREGATE_OXYGEN_SATURATION_SUMMARY));
        zzik.put(HealthDataTypes.TYPE_BODY_TEMPERATURE, Collections.singletonList(HealthDataTypes.AGGREGATE_BODY_TEMPERATURE_SUMMARY));
        zzik.put(HealthDataTypes.TYPE_BASAL_BODY_TEMPERATURE, Collections.singletonList(HealthDataTypes.AGGREGATE_BASAL_BODY_TEMPERATURE_SUMMARY));
        Map<DataType, List<DataType>> map = zzik;
        DataType dataType = HealthDataTypes.TYPE_CERVICAL_MUCUS;
        map.put(dataType, Collections.singletonList(dataType));
        Map<DataType, List<DataType>> map2 = zzik;
        DataType dataType2 = HealthDataTypes.TYPE_CERVICAL_POSITION;
        map2.put(dataType2, Collections.singletonList(dataType2));
        Map<DataType, List<DataType>> map3 = zzik;
        DataType dataType3 = HealthDataTypes.TYPE_MENSTRUATION;
        map3.put(dataType3, Collections.singletonList(dataType3));
        Map<DataType, List<DataType>> map4 = zzik;
        DataType dataType4 = HealthDataTypes.TYPE_OVULATION_TEST;
        map4.put(dataType4, Collections.singletonList(dataType4));
        Map<DataType, List<DataType>> map5 = zzik;
        DataType dataType5 = HealthDataTypes.TYPE_VAGINAL_SPOTTING;
        map5.put(dataType5, Collections.singletonList(dataType5));
    }
}
