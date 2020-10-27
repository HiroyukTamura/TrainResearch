package com.google.android.gms.fitness.data;

import com.google.android.gms.common.internal.ShowFirstParty;

@ShowFirstParty
public final class zzl {
    private static final DataType[] zzjy = {DataType.zzjq, DataType.TYPE_WORKOUT_EXERCISE, DataType.TYPE_MOVE_MINUTES, DataType.TYPE_ACTIVITY_SAMPLES, DataType.TYPE_ACTIVITY_SEGMENT, DataType.AGGREGATE_ACTIVITY_SUMMARY, HealthDataTypes.TYPE_BASAL_BODY_TEMPERATURE, HealthDataTypes.AGGREGATE_BASAL_BODY_TEMPERATURE_SUMMARY, HealthDataTypes.TYPE_BLOOD_GLUCOSE, HealthDataTypes.AGGREGATE_BLOOD_GLUCOSE_SUMMARY, HealthDataTypes.TYPE_BLOOD_PRESSURE, HealthDataTypes.AGGREGATE_BLOOD_PRESSURE_SUMMARY, DataType.TYPE_BODY_FAT_PERCENTAGE, DataType.AGGREGATE_BODY_FAT_PERCENTAGE_SUMMARY, HealthDataTypes.TYPE_BODY_TEMPERATURE, HealthDataTypes.AGGREGATE_BODY_TEMPERATURE_SUMMARY, DataType.TYPE_BASAL_METABOLIC_RATE, DataType.AGGREGATE_BASAL_METABOLIC_RATE_SUMMARY, DataType.TYPE_CALORIES_EXPENDED, HealthDataTypes.TYPE_CERVICAL_MUCUS, HealthDataTypes.TYPE_CERVICAL_POSITION, DataType.TYPE_CYCLING_PEDALING_CADENCE, DataType.TYPE_CYCLING_PEDALING_CUMULATIVE, DataType.TYPE_CYCLING_WHEEL_REVOLUTION, DataType.TYPE_CYCLING_WHEEL_RPM, DataType.TYPE_DISTANCE_CUMULATIVE, DataType.TYPE_DISTANCE_DELTA, DataType.zzjp, DataType.zzju, DataType.zzjm, DataType.zzjn, DataType.TYPE_HEART_POINTS, DataType.AGGREGATE_HEART_POINTS, DataType.TYPE_HEART_RATE_BPM, DataType.AGGREGATE_HEART_RATE_SUMMARY, DataType.TYPE_HEIGHT, DataType.AGGREGATE_HEIGHT_SUMMARY, DataType.AGGREGATE_LOCATION_BOUNDING_BOX, DataType.TYPE_LOCATION_SAMPLE, DataType.TYPE_LOCATION_TRACK, HealthDataTypes.TYPE_MENSTRUATION, DataType.TYPE_NUTRITION, DataType.TYPE_HYDRATION, DataType.AGGREGATE_NUTRITION_SUMMARY, HealthDataTypes.TYPE_OVULATION_TEST, HealthDataTypes.TYPE_OXYGEN_SATURATION, HealthDataTypes.AGGREGATE_OXYGEN_SATURATION_SUMMARY, DataType.TYPE_POWER_SAMPLE, DataType.AGGREGATE_POWER_SUMMARY, DataType.zzjr, DataType.TYPE_SPEED, DataType.AGGREGATE_SPEED_SUMMARY, DataType.TYPE_STEP_COUNT_CADENCE, DataType.zzjo, DataType.TYPE_STEP_COUNT_CUMULATIVE, DataType.TYPE_STEP_COUNT_DELTA, HealthDataTypes.TYPE_VAGINAL_SPOTTING, DataType.TYPE_WEIGHT, DataType.AGGREGATE_WEIGHT_SUMMARY, DataType.zzjs, DataType.zzjt};
    private static final DataType[] zzjz = {HealthDataTypes.TYPE_BASAL_BODY_TEMPERATURE, HealthDataTypes.AGGREGATE_BASAL_BODY_TEMPERATURE_SUMMARY, HealthDataTypes.TYPE_BLOOD_GLUCOSE, HealthDataTypes.AGGREGATE_BLOOD_GLUCOSE_SUMMARY, HealthDataTypes.TYPE_BLOOD_PRESSURE, HealthDataTypes.AGGREGATE_BLOOD_PRESSURE_SUMMARY, HealthDataTypes.TYPE_BODY_TEMPERATURE, HealthDataTypes.AGGREGATE_BODY_TEMPERATURE_SUMMARY, HealthDataTypes.TYPE_CERVICAL_MUCUS, HealthDataTypes.TYPE_CERVICAL_POSITION, HealthDataTypes.TYPE_MENSTRUATION, HealthDataTypes.TYPE_OVULATION_TEST, HealthDataTypes.TYPE_OXYGEN_SATURATION, HealthDataTypes.AGGREGATE_OXYGEN_SATURATION_SUMMARY, HealthDataTypes.TYPE_VAGINAL_SPOTTING};

    /* JADX WARNING: Can't fix incorrect switch cases order */
    @androidx.annotation.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.google.android.gms.fitness.data.DataType zzb(java.lang.String r1) {
        /*
            int r0 = r1.hashCode()
            switch(r0) {
                case -2060095039: goto L_0x02e1;
                case -2023954015: goto L_0x02d6;
                case -2001464928: goto L_0x02cb;
                case -1999891138: goto L_0x02c0;
                case -1939429191: goto L_0x02b5;
                case -1783842905: goto L_0x02ab;
                case -1757812901: goto L_0x02a0;
                case -1659958877: goto L_0x0295;
                case -1487055015: goto L_0x028b;
                case -1466904157: goto L_0x027f;
                case -1465729060: goto L_0x0273;
                case -1431431801: goto L_0x0267;
                case -1248818137: goto L_0x025b;
                case -1196687875: goto L_0x024f;
                case -1196687874: goto L_0x0243;
                case -1103712522: goto L_0x0237;
                case -1102520626: goto L_0x022b;
                case -1091068721: goto L_0x021f;
                case -922976890: goto L_0x0213;
                case -900592674: goto L_0x0207;
                case -886569606: goto L_0x01fb;
                case -777285735: goto L_0x01ef;
                case -700668164: goto L_0x01e3;
                case -661631456: goto L_0x01d7;
                case -424876584: goto L_0x01cb;
                case -362418992: goto L_0x01bf;
                case -217611775: goto L_0x01b3;
                case -185830635: goto L_0x01a7;
                case -177293656: goto L_0x019b;
                case -164586193: goto L_0x0190;
                case -98150574: goto L_0x0184;
                case -56824761: goto L_0x0178;
                case 53773386: goto L_0x016c;
                case 269180370: goto L_0x0161;
                case 295793957: goto L_0x0155;
                case 296250623: goto L_0x0149;
                case 324760871: goto L_0x013d;
                case 378060028: goto L_0x0132;
                case 529727579: goto L_0x0126;
                case 657433501: goto L_0x011a;
                case 682891187: goto L_0x010e;
                case 841663855: goto L_0x0103;
                case 877955159: goto L_0x00f7;
                case 899666941: goto L_0x00eb;
                case 936279698: goto L_0x00df;
                case 946706510: goto L_0x00d3;
                case 946938859: goto L_0x00c7;
                case 1029221057: goto L_0x00bb;
                case 1098265835: goto L_0x00af;
                case 1111714923: goto L_0x00a3;
                case 1214093899: goto L_0x0097;
                case 1404118825: goto L_0x008b;
                case 1439932546: goto L_0x007f;
                case 1483133089: goto L_0x0074;
                case 1524007137: goto L_0x0068;
                case 1532018766: goto L_0x005d;
                case 1633152752: goto L_0x0051;
                case 1921738212: goto L_0x0045;
                case 1925848149: goto L_0x0039;
                case 1975902189: goto L_0x002d;
                case 2051843553: goto L_0x0021;
                case 2053496735: goto L_0x0015;
                case 2131809416: goto L_0x0009;
                default: goto L_0x0007;
            }
        L_0x0007:
            goto L_0x02ec
        L_0x0009:
            java.lang.String r0 = "com.google.body.temperature.summary"
            boolean r1 = r1.equals(r0)
            if (r1 == 0) goto L_0x02ec
            r1 = 15
            goto L_0x02ed
        L_0x0015:
            java.lang.String r0 = "com.google.speed"
            boolean r1 = r1.equals(r0)
            if (r1 == 0) goto L_0x02ec
            r1 = 50
            goto L_0x02ed
        L_0x0021:
            java.lang.String r0 = "com.google.oxygen_saturation.summary"
            boolean r1 = r1.equals(r0)
            if (r1 == 0) goto L_0x02ec
            r1 = 46
            goto L_0x02ed
        L_0x002d:
            java.lang.String r0 = "com.google.cervical_mucus"
            boolean r1 = r1.equals(r0)
            if (r1 == 0) goto L_0x02ec
            r1 = 19
            goto L_0x02ed
        L_0x0039:
            java.lang.String r0 = "com.google.cervical_position"
            boolean r1 = r1.equals(r0)
            if (r1 == 0) goto L_0x02ec
            r1 = 20
            goto L_0x02ed
        L_0x0045:
            java.lang.String r0 = "com.google.distance.cumulative"
            boolean r1 = r1.equals(r0)
            if (r1 == 0) goto L_0x02ec
            r1 = 25
            goto L_0x02ed
        L_0x0051:
            java.lang.String r0 = "com.google.nutrition"
            boolean r1 = r1.equals(r0)
            if (r1 == 0) goto L_0x02ec
            r1 = 41
            goto L_0x02ed
        L_0x005d:
            java.lang.String r0 = "com.google.active_minutes"
            boolean r1 = r1.equals(r0)
            if (r1 == 0) goto L_0x02ec
            r1 = 1
            goto L_0x02ed
        L_0x0068:
            java.lang.String r0 = "com.google.cycling.wheel_revolution.cumulative"
            boolean r1 = r1.equals(r0)
            if (r1 == 0) goto L_0x02ec
            r1 = 23
            goto L_0x02ed
        L_0x0074:
            java.lang.String r0 = "com.google.body.temperature.basal"
            boolean r1 = r1.equals(r0)
            if (r1 == 0) goto L_0x02ec
            r1 = 6
            goto L_0x02ed
        L_0x007f:
            java.lang.String r0 = "com.google.ovulation_test"
            boolean r1 = r1.equals(r0)
            if (r1 == 0) goto L_0x02ec
            r1 = 44
            goto L_0x02ed
        L_0x008b:
            java.lang.String r0 = "com.google.oxygen_saturation"
            boolean r1 = r1.equals(r0)
            if (r1 == 0) goto L_0x02ec
            r1 = 45
            goto L_0x02ed
        L_0x0097:
            java.lang.String r0 = "com.google.vaginal_spotting"
            boolean r1 = r1.equals(r0)
            if (r1 == 0) goto L_0x02ec
            r1 = 58
            goto L_0x02ed
        L_0x00a3:
            java.lang.String r0 = "com.google.body.fat.percentage.summary"
            boolean r1 = r1.equals(r0)
            if (r1 == 0) goto L_0x02ec
            r1 = 13
            goto L_0x02ed
        L_0x00af:
            java.lang.String r0 = "com.google.floor_change"
            boolean r1 = r1.equals(r0)
            if (r1 == 0) goto L_0x02ec
            r1 = 27
            goto L_0x02ed
        L_0x00bb:
            java.lang.String r0 = "com.google.device_on_body"
            boolean r1 = r1.equals(r0)
            if (r1 == 0) goto L_0x02ec
            r1 = 61
            goto L_0x02ed
        L_0x00c7:
            java.lang.String r0 = "com.google.stride_model"
            boolean r1 = r1.equals(r0)
            if (r1 == 0) goto L_0x02ec
            r1 = 57
            goto L_0x02ed
        L_0x00d3:
            java.lang.String r0 = "com.google.hydration"
            boolean r1 = r1.equals(r0)
            if (r1 == 0) goto L_0x02ec
            r1 = 42
            goto L_0x02ed
        L_0x00df:
            java.lang.String r0 = "com.google.blood_pressure"
            boolean r1 = r1.equals(r0)
            if (r1 == 0) goto L_0x02ec
            r1 = 11
            goto L_0x02ed
        L_0x00eb:
            java.lang.String r0 = "com.google.calories.expended"
            boolean r1 = r1.equals(r0)
            if (r1 == 0) goto L_0x02ec
            r1 = 18
            goto L_0x02ed
        L_0x00f7:
            java.lang.String r0 = "com.google.speed.summary"
            boolean r1 = r1.equals(r0)
            if (r1 == 0) goto L_0x02ec
            r1 = 53
            goto L_0x02ed
        L_0x0103:
            java.lang.String r0 = "com.google.activity.summary"
            boolean r1 = r1.equals(r0)
            if (r1 == 0) goto L_0x02ec
            r1 = 5
            goto L_0x02ed
        L_0x010e:
            java.lang.String r0 = "com.google.body.fat.percentage"
            boolean r1 = r1.equals(r0)
            if (r1 == 0) goto L_0x02ec
            r1 = 8
            goto L_0x02ed
        L_0x011a:
            java.lang.String r0 = "com.google.step_count.cumulative"
            boolean r1 = r1.equals(r0)
            if (r1 == 0) goto L_0x02ec
            r1 = 55
            goto L_0x02ed
        L_0x0126:
            java.lang.String r0 = "com.google.power.sample"
            boolean r1 = r1.equals(r0)
            if (r1 == 0) goto L_0x02ec
            r1 = 47
            goto L_0x02ed
        L_0x0132:
            java.lang.String r0 = "com.google.activity.segment"
            boolean r1 = r1.equals(r0)
            if (r1 == 0) goto L_0x02ec
            r1 = 4
            goto L_0x02ed
        L_0x013d:
            java.lang.String r0 = "com.google.step_count.cadence"
            boolean r1 = r1.equals(r0)
            if (r1 == 0) goto L_0x02ec
            r1 = 54
            goto L_0x02ed
        L_0x0149:
            java.lang.String r0 = "com.google.calories.bmr.summary"
            boolean r1 = r1.equals(r0)
            if (r1 == 0) goto L_0x02ec
            r1 = 17
            goto L_0x02ed
        L_0x0155:
            java.lang.String r0 = "com.google.sensor.events"
            boolean r1 = r1.equals(r0)
            if (r1 == 0) goto L_0x02ec
            r1 = 49
            goto L_0x02ed
        L_0x0161:
            java.lang.String r0 = "com.google.activity.samples"
            boolean r1 = r1.equals(r0)
            if (r1 == 0) goto L_0x02ec
            r1 = 3
            goto L_0x02ed
        L_0x016c:
            java.lang.String r0 = "com.google.blood_pressure.summary"
            boolean r1 = r1.equals(r0)
            if (r1 == 0) goto L_0x02ec
            r1 = 12
            goto L_0x02ed
        L_0x0178:
            java.lang.String r0 = "com.google.calories.bmr"
            boolean r1 = r1.equals(r0)
            if (r1 == 0) goto L_0x02ec
            r1 = 16
            goto L_0x02ed
        L_0x0184:
            java.lang.String r0 = "com.google.heart_rate.bpm"
            boolean r1 = r1.equals(r0)
            if (r1 == 0) goto L_0x02ec
            r1 = 33
            goto L_0x02ed
        L_0x0190:
            java.lang.String r0 = "com.google.activity.exercise"
            boolean r1 = r1.equals(r0)
            if (r1 == 0) goto L_0x02ec
            r1 = 2
            goto L_0x02ed
        L_0x019b:
            java.lang.String r0 = "com.google.nutrition.summary"
            boolean r1 = r1.equals(r0)
            if (r1 == 0) goto L_0x02ec
            r1 = 43
            goto L_0x02ed
        L_0x01a7:
            java.lang.String r0 = "com.google.power.summary"
            boolean r1 = r1.equals(r0)
            if (r1 == 0) goto L_0x02ec
            r1 = 48
            goto L_0x02ed
        L_0x01b3:
            java.lang.String r0 = "com.google.blood_glucose"
            boolean r1 = r1.equals(r0)
            if (r1 == 0) goto L_0x02ec
            r1 = 9
            goto L_0x02ed
        L_0x01bf:
            java.lang.String r0 = "com.google.body.temperature"
            boolean r1 = r1.equals(r0)
            if (r1 == 0) goto L_0x02ec
            r1 = 14
            goto L_0x02ed
        L_0x01cb:
            java.lang.String r0 = "com.google.weight.summary"
            boolean r1 = r1.equals(r0)
            if (r1 == 0) goto L_0x02ec
            r1 = 60
            goto L_0x02ed
        L_0x01d7:
            java.lang.String r0 = "com.google.weight"
            boolean r1 = r1.equals(r0)
            if (r1 == 0) goto L_0x02ec
            r1 = 59
            goto L_0x02ed
        L_0x01e3:
            java.lang.String r0 = "com.google.internal.goal"
            boolean r1 = r1.equals(r0)
            if (r1 == 0) goto L_0x02ec
            r1 = 29
            goto L_0x02ed
        L_0x01ef:
            java.lang.String r0 = "com.google.heart_rate.summary"
            boolean r1 = r1.equals(r0)
            if (r1 == 0) goto L_0x02ec
            r1 = 34
            goto L_0x02ed
        L_0x01fb:
            java.lang.String r0 = "com.google.location.track"
            boolean r1 = r1.equals(r0)
            if (r1 == 0) goto L_0x02ec
            r1 = 39
            goto L_0x02ed
        L_0x0207:
            java.lang.String r0 = "com.google.cycling.pedaling.cadence"
            boolean r1 = r1.equals(r0)
            if (r1 == 0) goto L_0x02ec
            r1 = 21
            goto L_0x02ed
        L_0x0213:
            java.lang.String r0 = "com.google.cycling.pedaling.cumulative"
            boolean r1 = r1.equals(r0)
            if (r1 == 0) goto L_0x02ec
            r1 = 22
            goto L_0x02ed
        L_0x021f:
            java.lang.String r0 = "com.google.height"
            boolean r1 = r1.equals(r0)
            if (r1 == 0) goto L_0x02ec
            r1 = 35
            goto L_0x02ed
        L_0x022b:
            java.lang.String r0 = "com.google.step_count.delta"
            boolean r1 = r1.equals(r0)
            if (r1 == 0) goto L_0x02ec
            r1 = 56
            goto L_0x02ed
        L_0x0237:
            java.lang.String r0 = "com.google.heart_minutes.summary"
            boolean r1 = r1.equals(r0)
            if (r1 == 0) goto L_0x02ec
            r1 = 32
            goto L_0x02ed
        L_0x0243:
            java.lang.String r0 = "com.google.internal.session.v3"
            boolean r1 = r1.equals(r0)
            if (r1 == 0) goto L_0x02ec
            r1 = 52
            goto L_0x02ed
        L_0x024f:
            java.lang.String r0 = "com.google.internal.session.v2"
            boolean r1 = r1.equals(r0)
            if (r1 == 0) goto L_0x02ec
            r1 = 51
            goto L_0x02ed
        L_0x025b:
            java.lang.String r0 = "com.google.distance.delta"
            boolean r1 = r1.equals(r0)
            if (r1 == 0) goto L_0x02ec
            r1 = 26
            goto L_0x02ed
        L_0x0267:
            java.lang.String r0 = "com.google.height.summary"
            boolean r1 = r1.equals(r0)
            if (r1 == 0) goto L_0x02ec
            r1 = 36
            goto L_0x02ed
        L_0x0273:
            java.lang.String r0 = "com.google.internal.primary_device"
            boolean r1 = r1.equals(r0)
            if (r1 == 0) goto L_0x02ec
            r1 = 62
            goto L_0x02ed
        L_0x027f:
            java.lang.String r0 = "com.google.floor_change.summary"
            boolean r1 = r1.equals(r0)
            if (r1 == 0) goto L_0x02ec
            r1 = 28
            goto L_0x02ed
        L_0x028b:
            java.lang.String r0 = "com.google.body.temperature.basal.summary"
            boolean r1 = r1.equals(r0)
            if (r1 == 0) goto L_0x02ec
            r1 = 7
            goto L_0x02ed
        L_0x0295:
            java.lang.String r0 = "com.google.menstruation"
            boolean r1 = r1.equals(r0)
            if (r1 == 0) goto L_0x02ec
            r1 = 40
            goto L_0x02ed
        L_0x02a0:
            java.lang.String r0 = "com.google.location.sample"
            boolean r1 = r1.equals(r0)
            if (r1 == 0) goto L_0x02ec
            r1 = 38
            goto L_0x02ed
        L_0x02ab:
            java.lang.String r0 = "com.google.accelerometer"
            boolean r1 = r1.equals(r0)
            if (r1 == 0) goto L_0x02ec
            r1 = 0
            goto L_0x02ed
        L_0x02b5:
            java.lang.String r0 = "com.google.blood_glucose.summary"
            boolean r1 = r1.equals(r0)
            if (r1 == 0) goto L_0x02ec
            r1 = 10
            goto L_0x02ed
        L_0x02c0:
            java.lang.String r0 = "com.google.heart_minutes"
            boolean r1 = r1.equals(r0)
            if (r1 == 0) goto L_0x02ec
            r1 = 31
            goto L_0x02ed
        L_0x02cb:
            java.lang.String r0 = "com.google.internal.symptom"
            boolean r1 = r1.equals(r0)
            if (r1 == 0) goto L_0x02ec
            r1 = 30
            goto L_0x02ed
        L_0x02d6:
            java.lang.String r0 = "com.google.location.bounding_box"
            boolean r1 = r1.equals(r0)
            if (r1 == 0) goto L_0x02ec
            r1 = 37
            goto L_0x02ed
        L_0x02e1:
            java.lang.String r0 = "com.google.cycling.wheel_revolution.rpm"
            boolean r1 = r1.equals(r0)
            if (r1 == 0) goto L_0x02ec
            r1 = 24
            goto L_0x02ed
        L_0x02ec:
            r1 = -1
        L_0x02ed:
            switch(r1) {
                case 0: goto L_0x03ac;
                case 1: goto L_0x03a9;
                case 2: goto L_0x03a6;
                case 3: goto L_0x03a3;
                case 4: goto L_0x03a0;
                case 5: goto L_0x039d;
                case 6: goto L_0x039a;
                case 7: goto L_0x0397;
                case 8: goto L_0x0394;
                case 9: goto L_0x0391;
                case 10: goto L_0x038e;
                case 11: goto L_0x038b;
                case 12: goto L_0x0388;
                case 13: goto L_0x0385;
                case 14: goto L_0x0382;
                case 15: goto L_0x037f;
                case 16: goto L_0x037c;
                case 17: goto L_0x0379;
                case 18: goto L_0x0376;
                case 19: goto L_0x0373;
                case 20: goto L_0x0370;
                case 21: goto L_0x036d;
                case 22: goto L_0x036a;
                case 23: goto L_0x0367;
                case 24: goto L_0x0364;
                case 25: goto L_0x0361;
                case 26: goto L_0x035e;
                case 27: goto L_0x035b;
                case 28: goto L_0x0358;
                case 29: goto L_0x0355;
                case 30: goto L_0x0352;
                case 31: goto L_0x034f;
                case 32: goto L_0x034c;
                case 33: goto L_0x0349;
                case 34: goto L_0x0346;
                case 35: goto L_0x0343;
                case 36: goto L_0x0340;
                case 37: goto L_0x033d;
                case 38: goto L_0x033a;
                case 39: goto L_0x0337;
                case 40: goto L_0x0334;
                case 41: goto L_0x0331;
                case 42: goto L_0x032e;
                case 43: goto L_0x032b;
                case 44: goto L_0x0328;
                case 45: goto L_0x0325;
                case 46: goto L_0x0322;
                case 47: goto L_0x031f;
                case 48: goto L_0x031c;
                case 49: goto L_0x0319;
                case 50: goto L_0x0316;
                case 51: goto L_0x0313;
                case 52: goto L_0x0310;
                case 53: goto L_0x030d;
                case 54: goto L_0x030a;
                case 55: goto L_0x0307;
                case 56: goto L_0x0304;
                case 57: goto L_0x0301;
                case 58: goto L_0x02fe;
                case 59: goto L_0x02fb;
                case 60: goto L_0x02f8;
                case 61: goto L_0x02f5;
                case 62: goto L_0x02f2;
                default: goto L_0x02f0;
            }
        L_0x02f0:
            r1 = 0
            return r1
        L_0x02f2:
            com.google.android.gms.fitness.data.DataType r1 = com.google.android.gms.fitness.data.DataType.zzjt
            return r1
        L_0x02f5:
            com.google.android.gms.fitness.data.DataType r1 = com.google.android.gms.fitness.data.DataType.zzjs
            return r1
        L_0x02f8:
            com.google.android.gms.fitness.data.DataType r1 = com.google.android.gms.fitness.data.DataType.AGGREGATE_WEIGHT_SUMMARY
            return r1
        L_0x02fb:
            com.google.android.gms.fitness.data.DataType r1 = com.google.android.gms.fitness.data.DataType.TYPE_WEIGHT
            return r1
        L_0x02fe:
            com.google.android.gms.fitness.data.DataType r1 = com.google.android.gms.fitness.data.HealthDataTypes.TYPE_VAGINAL_SPOTTING
            return r1
        L_0x0301:
            com.google.android.gms.fitness.data.DataType r1 = com.google.android.gms.fitness.data.DataType.zzjo
            return r1
        L_0x0304:
            com.google.android.gms.fitness.data.DataType r1 = com.google.android.gms.fitness.data.DataType.TYPE_STEP_COUNT_DELTA
            return r1
        L_0x0307:
            com.google.android.gms.fitness.data.DataType r1 = com.google.android.gms.fitness.data.DataType.TYPE_STEP_COUNT_CUMULATIVE
            return r1
        L_0x030a:
            com.google.android.gms.fitness.data.DataType r1 = com.google.android.gms.fitness.data.DataType.TYPE_STEP_COUNT_CADENCE
            return r1
        L_0x030d:
            com.google.android.gms.fitness.data.DataType r1 = com.google.android.gms.fitness.data.DataType.AGGREGATE_SPEED_SUMMARY
            return r1
        L_0x0310:
            com.google.android.gms.fitness.data.DataType r1 = com.google.android.gms.fitness.data.DataType.zza.zzjl
            return r1
        L_0x0313:
            com.google.android.gms.fitness.data.DataType r1 = com.google.android.gms.fitness.data.DataType.zza.zzjk
            return r1
        L_0x0316:
            com.google.android.gms.fitness.data.DataType r1 = com.google.android.gms.fitness.data.DataType.TYPE_SPEED
            return r1
        L_0x0319:
            com.google.android.gms.fitness.data.DataType r1 = com.google.android.gms.fitness.data.DataType.zzjr
            return r1
        L_0x031c:
            com.google.android.gms.fitness.data.DataType r1 = com.google.android.gms.fitness.data.DataType.AGGREGATE_POWER_SUMMARY
            return r1
        L_0x031f:
            com.google.android.gms.fitness.data.DataType r1 = com.google.android.gms.fitness.data.DataType.TYPE_POWER_SAMPLE
            return r1
        L_0x0322:
            com.google.android.gms.fitness.data.DataType r1 = com.google.android.gms.fitness.data.HealthDataTypes.AGGREGATE_OXYGEN_SATURATION_SUMMARY
            return r1
        L_0x0325:
            com.google.android.gms.fitness.data.DataType r1 = com.google.android.gms.fitness.data.HealthDataTypes.TYPE_OXYGEN_SATURATION
            return r1
        L_0x0328:
            com.google.android.gms.fitness.data.DataType r1 = com.google.android.gms.fitness.data.HealthDataTypes.TYPE_OVULATION_TEST
            return r1
        L_0x032b:
            com.google.android.gms.fitness.data.DataType r1 = com.google.android.gms.fitness.data.DataType.AGGREGATE_NUTRITION_SUMMARY
            return r1
        L_0x032e:
            com.google.android.gms.fitness.data.DataType r1 = com.google.android.gms.fitness.data.DataType.TYPE_HYDRATION
            return r1
        L_0x0331:
            com.google.android.gms.fitness.data.DataType r1 = com.google.android.gms.fitness.data.DataType.TYPE_NUTRITION
            return r1
        L_0x0334:
            com.google.android.gms.fitness.data.DataType r1 = com.google.android.gms.fitness.data.HealthDataTypes.TYPE_MENSTRUATION
            return r1
        L_0x0337:
            com.google.android.gms.fitness.data.DataType r1 = com.google.android.gms.fitness.data.DataType.TYPE_LOCATION_TRACK
            return r1
        L_0x033a:
            com.google.android.gms.fitness.data.DataType r1 = com.google.android.gms.fitness.data.DataType.TYPE_LOCATION_SAMPLE
            return r1
        L_0x033d:
            com.google.android.gms.fitness.data.DataType r1 = com.google.android.gms.fitness.data.DataType.AGGREGATE_LOCATION_BOUNDING_BOX
            return r1
        L_0x0340:
            com.google.android.gms.fitness.data.DataType r1 = com.google.android.gms.fitness.data.DataType.AGGREGATE_HEIGHT_SUMMARY
            return r1
        L_0x0343:
            com.google.android.gms.fitness.data.DataType r1 = com.google.android.gms.fitness.data.DataType.TYPE_HEIGHT
            return r1
        L_0x0346:
            com.google.android.gms.fitness.data.DataType r1 = com.google.android.gms.fitness.data.DataType.AGGREGATE_HEART_RATE_SUMMARY
            return r1
        L_0x0349:
            com.google.android.gms.fitness.data.DataType r1 = com.google.android.gms.fitness.data.DataType.TYPE_HEART_RATE_BPM
            return r1
        L_0x034c:
            com.google.android.gms.fitness.data.DataType r1 = com.google.android.gms.fitness.data.DataType.AGGREGATE_HEART_POINTS
            return r1
        L_0x034f:
            com.google.android.gms.fitness.data.DataType r1 = com.google.android.gms.fitness.data.DataType.TYPE_HEART_POINTS
            return r1
        L_0x0352:
            com.google.android.gms.fitness.data.DataType r1 = com.google.android.gms.fitness.data.DataType.zzjn
            return r1
        L_0x0355:
            com.google.android.gms.fitness.data.DataType r1 = com.google.android.gms.fitness.data.DataType.zzjm
            return r1
        L_0x0358:
            com.google.android.gms.fitness.data.DataType r1 = com.google.android.gms.fitness.data.DataType.zzju
            return r1
        L_0x035b:
            com.google.android.gms.fitness.data.DataType r1 = com.google.android.gms.fitness.data.DataType.zzjp
            return r1
        L_0x035e:
            com.google.android.gms.fitness.data.DataType r1 = com.google.android.gms.fitness.data.DataType.TYPE_DISTANCE_DELTA
            return r1
        L_0x0361:
            com.google.android.gms.fitness.data.DataType r1 = com.google.android.gms.fitness.data.DataType.TYPE_DISTANCE_CUMULATIVE
            return r1
        L_0x0364:
            com.google.android.gms.fitness.data.DataType r1 = com.google.android.gms.fitness.data.DataType.TYPE_CYCLING_WHEEL_RPM
            return r1
        L_0x0367:
            com.google.android.gms.fitness.data.DataType r1 = com.google.android.gms.fitness.data.DataType.TYPE_CYCLING_WHEEL_REVOLUTION
            return r1
        L_0x036a:
            com.google.android.gms.fitness.data.DataType r1 = com.google.android.gms.fitness.data.DataType.TYPE_CYCLING_PEDALING_CUMULATIVE
            return r1
        L_0x036d:
            com.google.android.gms.fitness.data.DataType r1 = com.google.android.gms.fitness.data.DataType.TYPE_CYCLING_PEDALING_CADENCE
            return r1
        L_0x0370:
            com.google.android.gms.fitness.data.DataType r1 = com.google.android.gms.fitness.data.HealthDataTypes.TYPE_CERVICAL_POSITION
            return r1
        L_0x0373:
            com.google.android.gms.fitness.data.DataType r1 = com.google.android.gms.fitness.data.HealthDataTypes.TYPE_CERVICAL_MUCUS
            return r1
        L_0x0376:
            com.google.android.gms.fitness.data.DataType r1 = com.google.android.gms.fitness.data.DataType.TYPE_CALORIES_EXPENDED
            return r1
        L_0x0379:
            com.google.android.gms.fitness.data.DataType r1 = com.google.android.gms.fitness.data.DataType.AGGREGATE_BASAL_METABOLIC_RATE_SUMMARY
            return r1
        L_0x037c:
            com.google.android.gms.fitness.data.DataType r1 = com.google.android.gms.fitness.data.DataType.TYPE_BASAL_METABOLIC_RATE
            return r1
        L_0x037f:
            com.google.android.gms.fitness.data.DataType r1 = com.google.android.gms.fitness.data.HealthDataTypes.AGGREGATE_BODY_TEMPERATURE_SUMMARY
            return r1
        L_0x0382:
            com.google.android.gms.fitness.data.DataType r1 = com.google.android.gms.fitness.data.HealthDataTypes.TYPE_BODY_TEMPERATURE
            return r1
        L_0x0385:
            com.google.android.gms.fitness.data.DataType r1 = com.google.android.gms.fitness.data.DataType.AGGREGATE_BODY_FAT_PERCENTAGE_SUMMARY
            return r1
        L_0x0388:
            com.google.android.gms.fitness.data.DataType r1 = com.google.android.gms.fitness.data.HealthDataTypes.AGGREGATE_BLOOD_PRESSURE_SUMMARY
            return r1
        L_0x038b:
            com.google.android.gms.fitness.data.DataType r1 = com.google.android.gms.fitness.data.HealthDataTypes.TYPE_BLOOD_PRESSURE
            return r1
        L_0x038e:
            com.google.android.gms.fitness.data.DataType r1 = com.google.android.gms.fitness.data.HealthDataTypes.AGGREGATE_BLOOD_GLUCOSE_SUMMARY
            return r1
        L_0x0391:
            com.google.android.gms.fitness.data.DataType r1 = com.google.android.gms.fitness.data.HealthDataTypes.TYPE_BLOOD_GLUCOSE
            return r1
        L_0x0394:
            com.google.android.gms.fitness.data.DataType r1 = com.google.android.gms.fitness.data.DataType.TYPE_BODY_FAT_PERCENTAGE
            return r1
        L_0x0397:
            com.google.android.gms.fitness.data.DataType r1 = com.google.android.gms.fitness.data.HealthDataTypes.AGGREGATE_BASAL_BODY_TEMPERATURE_SUMMARY
            return r1
        L_0x039a:
            com.google.android.gms.fitness.data.DataType r1 = com.google.android.gms.fitness.data.HealthDataTypes.TYPE_BASAL_BODY_TEMPERATURE
            return r1
        L_0x039d:
            com.google.android.gms.fitness.data.DataType r1 = com.google.android.gms.fitness.data.DataType.AGGREGATE_ACTIVITY_SUMMARY
            return r1
        L_0x03a0:
            com.google.android.gms.fitness.data.DataType r1 = com.google.android.gms.fitness.data.DataType.TYPE_ACTIVITY_SEGMENT
            return r1
        L_0x03a3:
            com.google.android.gms.fitness.data.DataType r1 = com.google.android.gms.fitness.data.DataType.TYPE_ACTIVITY_SAMPLES
            return r1
        L_0x03a6:
            com.google.android.gms.fitness.data.DataType r1 = com.google.android.gms.fitness.data.DataType.TYPE_WORKOUT_EXERCISE
            return r1
        L_0x03a9:
            com.google.android.gms.fitness.data.DataType r1 = com.google.android.gms.fitness.data.DataType.TYPE_MOVE_MINUTES
            return r1
        L_0x03ac:
            com.google.android.gms.fitness.data.DataType r1 = com.google.android.gms.fitness.data.DataType.zzjq
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.fitness.data.zzl.zzb(java.lang.String):com.google.android.gms.fitness.data.DataType");
    }
}
