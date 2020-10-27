package com.google.android.gms.fitness.data;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Nullable;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.ShowFirstParty;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

@SafeParcelable.Class(creator = "FieldCreator")
@SafeParcelable.Reserved({1000})
public final class Field extends AbstractSafeParcelable {
    public static final Parcelable.Creator<Field> CREATOR = new zzq();
    public static final Field FIELD_ACCURACY = zze("accuracy");
    public static final Field FIELD_ACTIVITY = zzc("activity");
    @Deprecated
    public static final Field FIELD_ACTIVITY_CONFIDENCE = zzg("activity_confidence");
    public static final Field FIELD_ALTITUDE = zzf("altitude");
    public static final Field FIELD_AVERAGE = zze("average");
    public static final Field FIELD_BPM = zze("bpm");
    public static final Field FIELD_CALORIES = zze(NUTRIENT_CALORIES);
    public static final Field FIELD_CIRCUMFERENCE = zze("circumference");
    public static final Field FIELD_CONFIDENCE = zze("confidence");
    public static final Field FIELD_DISTANCE = zze("distance");
    public static final Field FIELD_DURATION = zzc("duration");
    public static final Field FIELD_EXERCISE = new Field("exercise", 3);
    public static final Field FIELD_FOOD_ITEM = new Field("food_item", 3, true);
    public static final Field FIELD_HEIGHT = zze("height");
    public static final Field FIELD_HIGH_LATITUDE = zze("high_latitude");
    public static final Field FIELD_HIGH_LONGITUDE = zze("high_longitude");
    public static final Field FIELD_INTENSITY = zze("intensity");
    public static final Field FIELD_LATITUDE = zze("latitude");
    public static final Field FIELD_LONGITUDE = zze("longitude");
    public static final Field FIELD_LOW_LATITUDE = zze("low_latitude");
    public static final Field FIELD_LOW_LONGITUDE = zze("low_longitude");
    public static final Field FIELD_MAX = zze("max");
    public static final Field FIELD_MEAL_TYPE = zzd("meal_type");
    public static final Field FIELD_MIN = zze("min");
    public static final Field FIELD_NUM_SEGMENTS = zzc("num_segments");
    public static final Field FIELD_NUTRIENTS = zzg("nutrients");
    public static final Field FIELD_OCCURRENCES = zzc("occurrences");
    public static final Field FIELD_PERCENTAGE = zze("percentage");
    public static final Field FIELD_REPETITIONS = zzd("repetitions");
    public static final Field FIELD_RESISTANCE = zzf("resistance");
    public static final Field FIELD_RESISTANCE_TYPE = zzd("resistance_type");
    public static final Field FIELD_REVOLUTIONS = zzc("revolutions");
    public static final Field FIELD_RPM = zze("rpm");
    public static final Field FIELD_SPEED = zze("speed");
    public static final Field FIELD_STEPS = zzc("steps");
    public static final Field FIELD_STEP_LENGTH = zze("step_length");
    public static final Field FIELD_VOLUME = zze("volume");
    public static final Field FIELD_WATTS = zze("watts");
    public static final Field FIELD_WEIGHT = zze("weight");
    public static final int FORMAT_FLOAT = 2;
    public static final int FORMAT_INT32 = 1;
    public static final int FORMAT_MAP = 4;
    public static final int FORMAT_STRING = 3;
    public static final int MEAL_TYPE_BREAKFAST = 1;
    public static final int MEAL_TYPE_DINNER = 3;
    public static final int MEAL_TYPE_LUNCH = 2;
    public static final int MEAL_TYPE_SNACK = 4;
    public static final int MEAL_TYPE_UNKNOWN = 0;
    public static final String NUTRIENT_CALCIUM = "calcium";
    public static final String NUTRIENT_CALORIES = "calories";
    public static final String NUTRIENT_CHOLESTEROL = "cholesterol";
    public static final String NUTRIENT_DIETARY_FIBER = "dietary_fiber";
    public static final String NUTRIENT_IRON = "iron";
    public static final String NUTRIENT_MONOUNSATURATED_FAT = "fat.monounsaturated";
    public static final String NUTRIENT_POLYUNSATURATED_FAT = "fat.polyunsaturated";
    public static final String NUTRIENT_POTASSIUM = "potassium";
    public static final String NUTRIENT_PROTEIN = "protein";
    public static final String NUTRIENT_SATURATED_FAT = "fat.saturated";
    public static final String NUTRIENT_SODIUM = "sodium";
    public static final String NUTRIENT_SUGAR = "sugar";
    public static final String NUTRIENT_TOTAL_CARBS = "carbs.total";
    public static final String NUTRIENT_TOTAL_FAT = "fat.total";
    public static final String NUTRIENT_TRANS_FAT = "fat.trans";
    public static final String NUTRIENT_UNSATURATED_FAT = "fat.unsaturated";
    public static final String NUTRIENT_VITAMIN_A = "vitamin_a";
    public static final String NUTRIENT_VITAMIN_C = "vitamin_c";
    public static final int RESISTANCE_TYPE_BARBELL = 1;
    public static final int RESISTANCE_TYPE_BODY = 6;
    public static final int RESISTANCE_TYPE_CABLE = 2;
    public static final int RESISTANCE_TYPE_DUMBBELL = 3;
    public static final int RESISTANCE_TYPE_KETTLEBELL = 4;
    public static final int RESISTANCE_TYPE_MACHINE = 5;
    public static final int RESISTANCE_TYPE_UNKNOWN = 0;
    @ShowFirstParty
    public static final Field zzkh = zzd("duration");
    @ShowFirstParty
    public static final Field zzki = zzg("activity_duration.ascending");
    @ShowFirstParty
    public static final Field zzkj = zzg("activity_duration.descending");
    @ShowFirstParty
    public static final Field zzkk = zzh("google.android.fitness.GoalV2");
    @ShowFirstParty
    public static final Field zzkl = zzh("symptom");
    @ShowFirstParty
    public static final Field zzkm = zzh("google.android.fitness.StrideModel");
    @ShowFirstParty
    public static final Field zzkn = zzh("google.android.fitness.Device");
    @ShowFirstParty
    public static final Field zzko = zze("elevation.change");
    @ShowFirstParty
    public static final Field zzkp = zzg("elevation.gain");
    @ShowFirstParty
    public static final Field zzkq = zzg("elevation.loss");
    @ShowFirstParty
    public static final Field zzkr = zze("floors");
    @ShowFirstParty
    public static final Field zzks = zzg("floor.gain");
    @ShowFirstParty
    public static final Field zzkt = zzg("floor.loss");
    @ShowFirstParty
    public static final Field zzku = zzc("sensor_type");
    @ShowFirstParty
    private static final Field zzkv = zzc("sensor_types");
    @ShowFirstParty
    public static final Field zzkw = new Field("timestamps", 5);
    @ShowFirstParty
    private static final Field zzkx = zzc("sample_period");
    @ShowFirstParty
    private static final Field zzky = zzc("num_samples");
    @ShowFirstParty
    private static final Field zzkz = zzc("num_dimensions");
    @ShowFirstParty
    public static final Field zzla = new Field("sensor_values", 6);
    @ShowFirstParty
    public static final Field zzlb = zze("probability");
    @SafeParcelable.Field(getter = "getFormat", mo11969id = 2)
    private final int format;
    @SafeParcelable.Field(getter = "getName", mo11969id = 1)
    private final String name;
    @SafeParcelable.Field(getter = "isOptional", mo11969id = 3)
    private final Boolean zzlc;

    @ShowFirstParty
    public static class zza {
        public static final Field zzld = Field.zze("x");
        public static final Field zzle = Field.zze("y");
        public static final Field zzlf = Field.zze("z");
        public static final Field zzlg = Field.zzi("debug_session");
        public static final Field zzlh = Field.zzi("google.android.fitness.SessionV2");
        public static final Field zzli = Field.zzh("google.android.fitness.DataPointSession");
    }

    @ShowFirstParty
    private Field(String str, int i) {
        this(str, i, (Boolean) null);
    }

    @ShowFirstParty
    @SafeParcelable.Constructor
    Field(@SafeParcelable.Param(mo11972id = 1) String str, @SafeParcelable.Param(mo11972id = 2) int i, @SafeParcelable.Param(mo11972id = 3) @Nullable Boolean bool) {
        this.name = (String) Preconditions.checkNotNull(str);
        this.format = i;
        this.zzlc = bool;
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    @com.google.android.gms.common.internal.ShowFirstParty
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.google.android.gms.fitness.data.Field zza(java.lang.String r2, int r3) {
        /*
            int r0 = r2.hashCode()
            switch(r0) {
                case -2131707655: goto L_0x0485;
                case -2083865430: goto L_0x047a;
                case -2006370880: goto L_0x046f;
                case -1992012396: goto L_0x0464;
                case -1859447186: goto L_0x045a;
                case -1743016407: goto L_0x044f;
                case -1655966961: goto L_0x0445;
                case -1595712862: goto L_0x043a;
                case -1579612127: goto L_0x042f;
                case -1579449403: goto L_0x0424;
                case -1569430471: goto L_0x0418;
                case -1531570079: goto L_0x040c;
                case -1440707631: goto L_0x0400;
                case -1439978388: goto L_0x03f4;
                case -1352492506: goto L_0x03e8;
                case -1290561483: goto L_0x03dc;
                case -1271636505: goto L_0x03d0;
                case -1248595573: goto L_0x03c4;
                case -1221029593: goto L_0x03b8;
                case -1220952307: goto L_0x03ac;
                case -1129337776: goto L_0x03a0;
                case -1110756780: goto L_0x0394;
                case -921832806: goto L_0x0388;
                case -918978307: goto L_0x037c;
                case -810883302: goto L_0x0370;
                case -803244749: goto L_0x0364;
                case -791592328: goto L_0x0358;
                case -631448035: goto L_0x034d;
                case -626344110: goto L_0x0341;
                case -619868540: goto L_0x0335;
                case -511934137: goto L_0x0329;
                case -494782871: goto L_0x031d;
                case -452643911: goto L_0x0311;
                case -437053898: goto L_0x0305;
                case -277306353: goto L_0x02f9;
                case -266093204: goto L_0x02ed;
                case -228366862: goto L_0x02e1;
                case -168965370: goto L_0x02d5;
                case -126538880: goto L_0x02c9;
                case -28590302: goto L_0x02bd;
                case 120: goto L_0x02b1;
                case 121: goto L_0x02a5;
                case 122: goto L_0x0299;
                case 97759: goto L_0x028d;
                case 107876: goto L_0x0281;
                case 108114: goto L_0x0275;
                case 113135: goto L_0x0269;
                case 66639641: goto L_0x025d;
                case 109641799: goto L_0x0251;
                case 109761319: goto L_0x0245;
                case 112903913: goto L_0x0239;
                case 120904628: goto L_0x022d;
                case 137365935: goto L_0x0221;
                case 198162679: goto L_0x0215;
                case 220648413: goto L_0x0209;
                case 248891292: goto L_0x01fd;
                case 286612066: goto L_0x01f2;
                case 288459765: goto L_0x01e6;
                case 306600408: goto L_0x01da;
                case 320627489: goto L_0x01ce;
                case 419669488: goto L_0x01c2;
                case 455965230: goto L_0x01b7;
                case 475560024: goto L_0x01ab;
                case 475560262: goto L_0x019f;
                case 499324979: goto L_0x0193;
                case 514168969: goto L_0x0187;
                case 581888402: goto L_0x017b;
                case 623947695: goto L_0x016f;
                case 738210934: goto L_0x0163;
                case 784486594: goto L_0x0157;
                case 811264586: goto L_0x014b;
                case 815736413: goto L_0x013f;
                case 829251210: goto L_0x0133;
                case 833248065: goto L_0x0127;
                case 883161687: goto L_0x011b;
                case 984367650: goto L_0x010f;
                case 998412730: goto L_0x0104;
                case 1136011766: goto L_0x00f8;
                case 1276952063: goto L_0x00ec;
                case 1284575222: goto L_0x00e0;
                case 1284575460: goto L_0x00d4;
                case 1403812644: goto L_0x00c8;
                case 1403812882: goto L_0x00bc;
                case 1527920799: goto L_0x00b0;
                case 1708915229: goto L_0x00a4;
                case 1857734768: goto L_0x0098;
                case 1857897492: goto L_0x008c;
                case 1863800889: goto L_0x0080;
                case 1880897007: goto L_0x0074;
                case 1892583496: goto L_0x0068;
                case 1958191058: goto L_0x005c;
                case 1958191296: goto L_0x0050;
                case 1983072038: goto L_0x0044;
                case 2020153105: goto L_0x0038;
                case 2036550306: goto L_0x002d;
                case 2056323544: goto L_0x0021;
                case 2072582505: goto L_0x0015;
                case 2078370221: goto L_0x0009;
                default: goto L_0x0007;
            }
        L_0x0007:
            goto L_0x048f
        L_0x0009:
            java.lang.String r0 = "supplemental_oxygen_flow_rate"
            boolean r0 = r2.equals(r0)
            if (r0 == 0) goto L_0x048f
            r0 = 71
            goto L_0x0490
        L_0x0015:
            java.lang.String r0 = "cervical_firmness"
            boolean r0 = r2.equals(r0)
            if (r0 == 0) goto L_0x048f
            r0 = 24
            goto L_0x0490
        L_0x0021:
            java.lang.String r0 = "exercise"
            boolean r0 = r2.equals(r0)
            if (r0 == 0) goto L_0x048f
            r0 = 36
            goto L_0x0490
        L_0x002d:
            java.lang.String r0 = "altitude"
            boolean r0 = r2.equals(r0)
            if (r0 == 0) goto L_0x048f
            r0 = 5
            goto L_0x0490
        L_0x0038:
            java.lang.String r0 = "blood_pressure_systolic_average"
            boolean r0 = r2.equals(r0)
            if (r0 == 0) goto L_0x048f
            r0 = 15
            goto L_0x0490
        L_0x0044:
            java.lang.String r0 = "body_position"
            boolean r0 = r2.equals(r0)
            if (r0 == 0) goto L_0x048f
            r0 = 18
            goto L_0x0490
        L_0x0050:
            java.lang.String r0 = "supplemental_oxygen_flow_rate_min"
            boolean r0 = r2.equals(r0)
            if (r0 == 0) goto L_0x048f
            r0 = 74
            goto L_0x0490
        L_0x005c:
            java.lang.String r0 = "supplemental_oxygen_flow_rate_max"
            boolean r0 = r2.equals(r0)
            if (r0 == 0) goto L_0x048f
            r0 = 73
            goto L_0x0490
        L_0x0068:
            java.lang.String r0 = "menstrual_flow"
            boolean r0 = r2.equals(r0)
            if (r0 == 0) goto L_0x048f
            r0 = 51
            goto L_0x0490
        L_0x0074:
            java.lang.String r0 = "oxygen_therapy_administration_mode"
            boolean r0 = r2.equals(r0)
            if (r0 == 0) goto L_0x048f
            r0 = 65
            goto L_0x0490
        L_0x0080:
            java.lang.String r0 = "resistance"
            boolean r0 = r2.equals(r0)
            if (r0 == 0) goto L_0x048f
            r0 = 78
            goto L_0x0490
        L_0x008c:
            java.lang.String r0 = "elevation.loss"
            boolean r0 = r2.equals(r0)
            if (r0 == 0) goto L_0x048f
            r0 = 35
            goto L_0x0490
        L_0x0098:
            java.lang.String r0 = "elevation.gain"
            boolean r0 = r2.equals(r0)
            if (r0 == 0) goto L_0x048f
            r0 = 34
            goto L_0x0490
        L_0x00a4:
            java.lang.String r0 = "timestamps"
            boolean r0 = r2.equals(r0)
            if (r0 == 0) goto L_0x048f
            r0 = 66
            goto L_0x0490
        L_0x00b0:
            java.lang.String r0 = "sensor_type"
            boolean r0 = r2.equals(r0)
            if (r0 == 0) goto L_0x048f
            r0 = 68
            goto L_0x0490
        L_0x00bc:
            java.lang.String r0 = "blood_pressure_diastolic_min"
            boolean r0 = r2.equals(r0)
            if (r0 == 0) goto L_0x048f
            r0 = 12
            goto L_0x0490
        L_0x00c8:
            java.lang.String r0 = "blood_pressure_diastolic_max"
            boolean r0 = r2.equals(r0)
            if (r0 == 0) goto L_0x048f
            r0 = 11
            goto L_0x0490
        L_0x00d4:
            java.lang.String r0 = "oxygen_saturation_min"
            boolean r0 = r2.equals(r0)
            if (r0 == 0) goto L_0x048f
            r0 = 63
            goto L_0x0490
        L_0x00e0:
            java.lang.String r0 = "oxygen_saturation_max"
            boolean r0 = r2.equals(r0)
            if (r0 == 0) goto L_0x048f
            r0 = 61
            goto L_0x0490
        L_0x00ec:
            java.lang.String r0 = "blood_pressure_diastolic"
            boolean r0 = r2.equals(r0)
            if (r0 == 0) goto L_0x048f
            r0 = 9
            goto L_0x0490
        L_0x00f8:
            java.lang.String r0 = "sample_period"
            boolean r0 = r2.equals(r0)
            if (r0 == 0) goto L_0x048f
            r0 = 67
            goto L_0x0490
        L_0x0104:
            java.lang.String r0 = "activity_confidence"
            boolean r0 = r2.equals(r0)
            if (r0 == 0) goto L_0x048f
            r0 = 2
            goto L_0x0490
        L_0x010f:
            java.lang.String r0 = "repetitions"
            boolean r0 = r2.equals(r0)
            if (r0 == 0) goto L_0x048f
            r0 = 77
            goto L_0x0490
        L_0x011b:
            java.lang.String r0 = "body_temperature"
            boolean r0 = r2.equals(r0)
            if (r0 == 0) goto L_0x048f
            r0 = 19
            goto L_0x0490
        L_0x0127:
            java.lang.String r0 = "temporal_relation_to_meal"
            boolean r0 = r2.equals(r0)
            if (r0 == 0) goto L_0x048f
            r0 = 87
            goto L_0x0490
        L_0x0133:
            java.lang.String r0 = "confidence"
            boolean r0 = r2.equals(r0)
            if (r0 == 0) goto L_0x048f
            r0 = 29
            goto L_0x0490
        L_0x013f:
            java.lang.String r0 = "oxygen_saturation_system"
            boolean r0 = r2.equals(r0)
            if (r0 == 0) goto L_0x048f
            r0 = 64
            goto L_0x0490
        L_0x014b:
            java.lang.String r0 = "revolutions"
            boolean r0 = r2.equals(r0)
            if (r0 == 0) goto L_0x048f
            r0 = 80
            goto L_0x0490
        L_0x0157:
            java.lang.String r0 = "occurrences"
            boolean r0 = r2.equals(r0)
            if (r0 == 0) goto L_0x048f
            r0 = 57
            goto L_0x0490
        L_0x0163:
            java.lang.String r0 = "google.android.fitness.StrideModel"
            boolean r0 = r2.equals(r0)
            if (r0 == 0) goto L_0x048f
            r0 = 86
            goto L_0x0490
        L_0x016f:
            java.lang.String r0 = "oxygen_saturation_average"
            boolean r0 = r2.equals(r0)
            if (r0 == 0) goto L_0x048f
            r0 = 60
            goto L_0x0490
        L_0x017b:
            java.lang.String r0 = "cervical_mucus_amount"
            boolean r0 = r2.equals(r0)
            if (r0 == 0) goto L_0x048f
            r0 = 25
            goto L_0x0490
        L_0x0187:
            java.lang.String r0 = "google.android.fitness.GoalV2"
            boolean r0 = r2.equals(r0)
            if (r0 == 0) goto L_0x048f
            r0 = 85
            goto L_0x0490
        L_0x0193:
            java.lang.String r0 = "intensity"
            boolean r0 = r2.equals(r0)
            if (r0 == 0) goto L_0x048f
            r0 = 42
            goto L_0x0490
        L_0x019f:
            java.lang.String r0 = "blood_pressure_systolic_min"
            boolean r0 = r2.equals(r0)
            if (r0 == 0) goto L_0x048f
            r0 = 17
            goto L_0x0490
        L_0x01ab:
            java.lang.String r0 = "blood_pressure_systolic_max"
            boolean r0 = r2.equals(r0)
            if (r0 == 0) goto L_0x048f
            r0 = 16
            goto L_0x0490
        L_0x01b7:
            java.lang.String r0 = "activity_duration.ascending"
            boolean r0 = r2.equals(r0)
            if (r0 == 0) goto L_0x048f
            r0 = 3
            goto L_0x0490
        L_0x01c2:
            java.lang.String r0 = "google.android.fitness.Device"
            boolean r0 = r2.equals(r0)
            if (r0 == 0) goto L_0x048f
            r0 = 30
            goto L_0x0490
        L_0x01ce:
            java.lang.String r0 = "cervical_mucus_texture"
            boolean r0 = r2.equals(r0)
            if (r0 == 0) goto L_0x048f
            r0 = 26
            goto L_0x0490
        L_0x01da:
            java.lang.String r0 = "google.android.fitness.SessionV2"
            boolean r0 = r2.equals(r0)
            if (r0 == 0) goto L_0x048f
            r0 = 96
            goto L_0x0490
        L_0x01e6:
            java.lang.String r0 = "distance"
            boolean r0 = r2.equals(r0)
            if (r0 == 0) goto L_0x048f
            r0 = 31
            goto L_0x0490
        L_0x01f2:
            java.lang.String r0 = "activity_duration.descending"
            boolean r0 = r2.equals(r0)
            if (r0 == 0) goto L_0x048f
            r0 = 4
            goto L_0x0490
        L_0x01fd:
            java.lang.String r0 = "blood_glucose_specimen_source"
            boolean r0 = r2.equals(r0)
            if (r0 == 0) goto L_0x048f
            r0 = 8
            goto L_0x0490
        L_0x0209:
            java.lang.String r0 = "blood_pressure_diastolic_average"
            boolean r0 = r2.equals(r0)
            if (r0 == 0) goto L_0x048f
            r0 = 10
            goto L_0x0490
        L_0x0215:
            java.lang.String r0 = "low_latitude"
            boolean r0 = r2.equals(r0)
            if (r0 == 0) goto L_0x048f
            r0 = 47
            goto L_0x0490
        L_0x0221:
            java.lang.String r0 = "longitude"
            boolean r0 = r2.equals(r0)
            if (r0 == 0) goto L_0x048f
            r0 = 46
            goto L_0x0490
        L_0x022d:
            java.lang.String r0 = "sensor_types"
            boolean r0 = r2.equals(r0)
            if (r0 == 0) goto L_0x048f
            r0 = 69
            goto L_0x0490
        L_0x0239:
            java.lang.String r0 = "watts"
            boolean r0 = r2.equals(r0)
            if (r0 == 0) goto L_0x048f
            r0 = 90
            goto L_0x0490
        L_0x0245:
            java.lang.String r0 = "steps"
            boolean r0 = r2.equals(r0)
            if (r0 == 0) goto L_0x048f
            r0 = 83
            goto L_0x0490
        L_0x0251:
            java.lang.String r0 = "speed"
            boolean r0 = r2.equals(r0)
            if (r0 == 0) goto L_0x048f
            r0 = 82
            goto L_0x0490
        L_0x025d:
            java.lang.String r0 = "temporal_relation_to_sleep"
            boolean r0 = r2.equals(r0)
            if (r0 == 0) goto L_0x048f
            r0 = 88
            goto L_0x0490
        L_0x0269:
            java.lang.String r0 = "rpm"
            boolean r0 = r2.equals(r0)
            if (r0 == 0) goto L_0x048f
            r0 = 81
            goto L_0x0490
        L_0x0275:
            java.lang.String r0 = "min"
            boolean r0 = r2.equals(r0)
            if (r0 == 0) goto L_0x048f
            r0 = 52
            goto L_0x0490
        L_0x0281:
            java.lang.String r0 = "max"
            boolean r0 = r2.equals(r0)
            if (r0 == 0) goto L_0x048f
            r0 = 49
            goto L_0x0490
        L_0x028d:
            java.lang.String r0 = "bpm"
            boolean r0 = r2.equals(r0)
            if (r0 == 0) goto L_0x048f
            r0 = 21
            goto L_0x0490
        L_0x0299:
            java.lang.String r0 = "z"
            boolean r0 = r2.equals(r0)
            if (r0 == 0) goto L_0x048f
            r0 = 94
            goto L_0x0490
        L_0x02a5:
            java.lang.String r0 = "y"
            boolean r0 = r2.equals(r0)
            if (r0 == 0) goto L_0x048f
            r0 = 93
            goto L_0x0490
        L_0x02b1:
            java.lang.String r0 = "x"
            boolean r0 = r2.equals(r0)
            if (r0 == 0) goto L_0x048f
            r0 = 92
            goto L_0x0490
        L_0x02bd:
            java.lang.String r0 = "ovulation_test_result"
            boolean r0 = r2.equals(r0)
            if (r0 == 0) goto L_0x048f
            r0 = 58
            goto L_0x0490
        L_0x02c9:
            java.lang.String r0 = "resistance_type"
            boolean r0 = r2.equals(r0)
            if (r0 == 0) goto L_0x048f
            r0 = 79
            goto L_0x0490
        L_0x02d5:
            java.lang.String r0 = "calories"
            boolean r0 = r2.equals(r0)
            if (r0 == 0) goto L_0x048f
            r0 = 22
            goto L_0x0490
        L_0x02e1:
            java.lang.String r0 = "oxygen_saturation_measurement_method"
            boolean r0 = r2.equals(r0)
            if (r0 == 0) goto L_0x048f
            r0 = 62
            goto L_0x0490
        L_0x02ed:
            java.lang.String r0 = "nutrients"
            boolean r0 = r2.equals(r0)
            if (r0 == 0) goto L_0x048f
            r0 = 56
            goto L_0x0490
        L_0x02f9:
            java.lang.String r0 = "circumference"
            boolean r0 = r2.equals(r0)
            if (r0 == 0) goto L_0x048f
            r0 = 28
            goto L_0x0490
        L_0x0305:
            java.lang.String r0 = "meal_type"
            boolean r0 = r2.equals(r0)
            if (r0 == 0) goto L_0x048f
            r0 = 50
            goto L_0x0490
        L_0x0311:
            java.lang.String r0 = "step_length"
            boolean r0 = r2.equals(r0)
            if (r0 == 0) goto L_0x048f
            r0 = 84
            goto L_0x0490
        L_0x031d:
            java.lang.String r0 = "high_latitude"
            boolean r0 = r2.equals(r0)
            if (r0 == 0) goto L_0x048f
            r0 = 43
            goto L_0x0490
        L_0x0329:
            java.lang.String r0 = "sensor_values"
            boolean r0 = r2.equals(r0)
            if (r0 == 0) goto L_0x048f
            r0 = 70
            goto L_0x0490
        L_0x0335:
            java.lang.String r0 = "low_longitude"
            boolean r0 = r2.equals(r0)
            if (r0 == 0) goto L_0x048f
            r0 = 48
            goto L_0x0490
        L_0x0341:
            java.lang.String r0 = "high_longitude"
            boolean r0 = r2.equals(r0)
            if (r0 == 0) goto L_0x048f
            r0 = 44
            goto L_0x0490
        L_0x034d:
            java.lang.String r0 = "average"
            boolean r0 = r2.equals(r0)
            if (r0 == 0) goto L_0x048f
            r0 = 6
            goto L_0x0490
        L_0x0358:
            java.lang.String r0 = "weight"
            boolean r0 = r2.equals(r0)
            if (r0 == 0) goto L_0x048f
            r0 = 91
            goto L_0x0490
        L_0x0364:
            java.lang.String r0 = "blood_pressure_systolic"
            boolean r0 = r2.equals(r0)
            if (r0 == 0) goto L_0x048f
            r0 = 14
            goto L_0x0490
        L_0x0370:
            java.lang.String r0 = "volume"
            boolean r0 = r2.equals(r0)
            if (r0 == 0) goto L_0x048f
            r0 = 89
            goto L_0x0490
        L_0x037c:
            java.lang.String r0 = "cervical_position"
            boolean r0 = r2.equals(r0)
            if (r0 == 0) goto L_0x048f
            r0 = 27
            goto L_0x0490
        L_0x0388:
            java.lang.String r0 = "percentage"
            boolean r0 = r2.equals(r0)
            if (r0 == 0) goto L_0x048f
            r0 = 76
            goto L_0x0490
        L_0x0394:
            java.lang.String r0 = "food_item"
            boolean r0 = r2.equals(r0)
            if (r0 == 0) goto L_0x048f
            r0 = 40
            goto L_0x0490
        L_0x03a0:
            java.lang.String r0 = "num_samples"
            boolean r0 = r2.equals(r0)
            if (r0 == 0) goto L_0x048f
            r0 = 54
            goto L_0x0490
        L_0x03ac:
            java.lang.String r0 = "blood_pressure_measurement_location"
            boolean r0 = r2.equals(r0)
            if (r0 == 0) goto L_0x048f
            r0 = 13
            goto L_0x0490
        L_0x03b8:
            java.lang.String r0 = "height"
            boolean r0 = r2.equals(r0)
            if (r0 == 0) goto L_0x048f
            r0 = 41
            goto L_0x0490
        L_0x03c4:
            java.lang.String r0 = "supplemental_oxygen_flow_rate_average"
            boolean r0 = r2.equals(r0)
            if (r0 == 0) goto L_0x048f
            r0 = 72
            goto L_0x0490
        L_0x03d0:
            java.lang.String r0 = "floors"
            boolean r0 = r2.equals(r0)
            if (r0 == 0) goto L_0x048f
            r0 = 39
            goto L_0x0490
        L_0x03dc:
            java.lang.String r0 = "probability"
            boolean r0 = r2.equals(r0)
            if (r0 == 0) goto L_0x048f
            r0 = 97
            goto L_0x0490
        L_0x03e8:
            java.lang.String r0 = "num_dimensions"
            boolean r0 = r2.equals(r0)
            if (r0 == 0) goto L_0x048f
            r0 = 53
            goto L_0x0490
        L_0x03f4:
            java.lang.String r0 = "latitude"
            boolean r0 = r2.equals(r0)
            if (r0 == 0) goto L_0x048f
            r0 = 45
            goto L_0x0490
        L_0x0400:
            java.lang.String r0 = "oxygen_saturation"
            boolean r0 = r2.equals(r0)
            if (r0 == 0) goto L_0x048f
            r0 = 59
            goto L_0x0490
        L_0x040c:
            java.lang.String r0 = "elevation.change"
            boolean r0 = r2.equals(r0)
            if (r0 == 0) goto L_0x048f
            r0 = 33
            goto L_0x0490
        L_0x0418:
            java.lang.String r0 = "num_segments"
            boolean r0 = r2.equals(r0)
            if (r0 == 0) goto L_0x048f
            r0 = 55
            goto L_0x0490
        L_0x0424:
            java.lang.String r0 = "floor.loss"
            boolean r0 = r2.equals(r0)
            if (r0 == 0) goto L_0x048f
            r0 = 38
            goto L_0x0490
        L_0x042f:
            java.lang.String r0 = "floor.gain"
            boolean r0 = r2.equals(r0)
            if (r0 == 0) goto L_0x048f
            r0 = 37
            goto L_0x0490
        L_0x043a:
            java.lang.String r0 = "cervical_dilation"
            boolean r0 = r2.equals(r0)
            if (r0 == 0) goto L_0x048f
            r0 = 23
            goto L_0x0490
        L_0x0445:
            java.lang.String r0 = "activity"
            boolean r0 = r2.equals(r0)
            if (r0 == 0) goto L_0x048f
            r0 = 1
            goto L_0x0490
        L_0x044f:
            java.lang.String r0 = "symptom"
            boolean r0 = r2.equals(r0)
            if (r0 == 0) goto L_0x048f
            r0 = 75
            goto L_0x0490
        L_0x045a:
            java.lang.String r0 = "blood_glucose_level"
            boolean r0 = r2.equals(r0)
            if (r0 == 0) goto L_0x048f
            r0 = 7
            goto L_0x0490
        L_0x0464:
            java.lang.String r0 = "duration"
            boolean r0 = r2.equals(r0)
            if (r0 == 0) goto L_0x048f
            r0 = 32
            goto L_0x0490
        L_0x046f:
            java.lang.String r0 = "body_temperature_measurement_location"
            boolean r0 = r2.equals(r0)
            if (r0 == 0) goto L_0x048f
            r0 = 20
            goto L_0x0490
        L_0x047a:
            java.lang.String r0 = "debug_session"
            boolean r0 = r2.equals(r0)
            if (r0 == 0) goto L_0x048f
            r0 = 95
            goto L_0x0490
        L_0x0485:
            java.lang.String r0 = "accuracy"
            boolean r0 = r2.equals(r0)
            if (r0 == 0) goto L_0x048f
            r0 = 0
            goto L_0x0490
        L_0x048f:
            r0 = -1
        L_0x0490:
            switch(r0) {
                case 0: goto L_0x05bd;
                case 1: goto L_0x05ba;
                case 2: goto L_0x05b7;
                case 3: goto L_0x05b4;
                case 4: goto L_0x05b1;
                case 5: goto L_0x05ae;
                case 6: goto L_0x05ab;
                case 7: goto L_0x05a8;
                case 8: goto L_0x05a5;
                case 9: goto L_0x05a2;
                case 10: goto L_0x059f;
                case 11: goto L_0x059c;
                case 12: goto L_0x0599;
                case 13: goto L_0x0596;
                case 14: goto L_0x0593;
                case 15: goto L_0x0590;
                case 16: goto L_0x058d;
                case 17: goto L_0x058a;
                case 18: goto L_0x0587;
                case 19: goto L_0x0584;
                case 20: goto L_0x0581;
                case 21: goto L_0x057e;
                case 22: goto L_0x057b;
                case 23: goto L_0x0578;
                case 24: goto L_0x0575;
                case 25: goto L_0x0572;
                case 26: goto L_0x056f;
                case 27: goto L_0x056c;
                case 28: goto L_0x0569;
                case 29: goto L_0x0566;
                case 30: goto L_0x0563;
                case 31: goto L_0x0560;
                case 32: goto L_0x055d;
                case 33: goto L_0x055a;
                case 34: goto L_0x0557;
                case 35: goto L_0x0554;
                case 36: goto L_0x0551;
                case 37: goto L_0x054e;
                case 38: goto L_0x054b;
                case 39: goto L_0x0548;
                case 40: goto L_0x0545;
                case 41: goto L_0x0542;
                case 42: goto L_0x053f;
                case 43: goto L_0x053c;
                case 44: goto L_0x0539;
                case 45: goto L_0x0536;
                case 46: goto L_0x0533;
                case 47: goto L_0x0530;
                case 48: goto L_0x052d;
                case 49: goto L_0x052a;
                case 50: goto L_0x0527;
                case 51: goto L_0x0524;
                case 52: goto L_0x0521;
                case 53: goto L_0x051e;
                case 54: goto L_0x051b;
                case 55: goto L_0x0518;
                case 56: goto L_0x0515;
                case 57: goto L_0x0512;
                case 58: goto L_0x050f;
                case 59: goto L_0x050c;
                case 60: goto L_0x0509;
                case 61: goto L_0x0506;
                case 62: goto L_0x0503;
                case 63: goto L_0x0500;
                case 64: goto L_0x04fd;
                case 65: goto L_0x04fa;
                case 66: goto L_0x04f7;
                case 67: goto L_0x04f4;
                case 68: goto L_0x04f1;
                case 69: goto L_0x04ee;
                case 70: goto L_0x04eb;
                case 71: goto L_0x04e8;
                case 72: goto L_0x04e5;
                case 73: goto L_0x04e2;
                case 74: goto L_0x04df;
                case 75: goto L_0x04dc;
                case 76: goto L_0x04d9;
                case 77: goto L_0x04d6;
                case 78: goto L_0x04d3;
                case 79: goto L_0x04d0;
                case 80: goto L_0x04cd;
                case 81: goto L_0x04ca;
                case 82: goto L_0x04c7;
                case 83: goto L_0x04c4;
                case 84: goto L_0x04c1;
                case 85: goto L_0x04be;
                case 86: goto L_0x04bb;
                case 87: goto L_0x04b8;
                case 88: goto L_0x04b5;
                case 89: goto L_0x04b2;
                case 90: goto L_0x04af;
                case 91: goto L_0x04ac;
                case 92: goto L_0x04a9;
                case 93: goto L_0x04a6;
                case 94: goto L_0x04a3;
                case 95: goto L_0x04a0;
                case 96: goto L_0x049d;
                case 97: goto L_0x049a;
                default: goto L_0x0493;
            }
        L_0x0493:
            com.google.android.gms.fitness.data.Field r0 = new com.google.android.gms.fitness.data.Field
            r1 = 0
            r0.<init>(r2, r3, r1)
            return r0
        L_0x049a:
            com.google.android.gms.fitness.data.Field r2 = zzlb
            return r2
        L_0x049d:
            com.google.android.gms.fitness.data.Field r2 = com.google.android.gms.fitness.data.Field.zza.zzlh
            return r2
        L_0x04a0:
            com.google.android.gms.fitness.data.Field r2 = com.google.android.gms.fitness.data.Field.zza.zzlg
            return r2
        L_0x04a3:
            com.google.android.gms.fitness.data.Field r2 = com.google.android.gms.fitness.data.Field.zza.zzlf
            return r2
        L_0x04a6:
            com.google.android.gms.fitness.data.Field r2 = com.google.android.gms.fitness.data.Field.zza.zzle
            return r2
        L_0x04a9:
            com.google.android.gms.fitness.data.Field r2 = com.google.android.gms.fitness.data.Field.zza.zzld
            return r2
        L_0x04ac:
            com.google.android.gms.fitness.data.Field r2 = FIELD_WEIGHT
            return r2
        L_0x04af:
            com.google.android.gms.fitness.data.Field r2 = FIELD_WATTS
            return r2
        L_0x04b2:
            com.google.android.gms.fitness.data.Field r2 = FIELD_VOLUME
            return r2
        L_0x04b5:
            com.google.android.gms.fitness.data.Field r2 = com.google.android.gms.fitness.data.HealthFields.FIELD_TEMPORAL_RELATION_TO_SLEEP
            return r2
        L_0x04b8:
            com.google.android.gms.fitness.data.Field r2 = com.google.android.gms.fitness.data.HealthFields.FIELD_TEMPORAL_RELATION_TO_MEAL
            return r2
        L_0x04bb:
            com.google.android.gms.fitness.data.Field r2 = zzkm
            return r2
        L_0x04be:
            com.google.android.gms.fitness.data.Field r2 = zzkk
            return r2
        L_0x04c1:
            com.google.android.gms.fitness.data.Field r2 = FIELD_STEP_LENGTH
            return r2
        L_0x04c4:
            com.google.android.gms.fitness.data.Field r2 = FIELD_STEPS
            return r2
        L_0x04c7:
            com.google.android.gms.fitness.data.Field r2 = FIELD_SPEED
            return r2
        L_0x04ca:
            com.google.android.gms.fitness.data.Field r2 = FIELD_RPM
            return r2
        L_0x04cd:
            com.google.android.gms.fitness.data.Field r2 = FIELD_REVOLUTIONS
            return r2
        L_0x04d0:
            com.google.android.gms.fitness.data.Field r2 = FIELD_RESISTANCE_TYPE
            return r2
        L_0x04d3:
            com.google.android.gms.fitness.data.Field r2 = FIELD_RESISTANCE
            return r2
        L_0x04d6:
            com.google.android.gms.fitness.data.Field r2 = FIELD_REPETITIONS
            return r2
        L_0x04d9:
            com.google.android.gms.fitness.data.Field r2 = FIELD_PERCENTAGE
            return r2
        L_0x04dc:
            com.google.android.gms.fitness.data.Field r2 = zzkl
            return r2
        L_0x04df:
            com.google.android.gms.fitness.data.Field r2 = com.google.android.gms.fitness.data.HealthFields.FIELD_SUPPLEMENTAL_OXYGEN_FLOW_RATE_MIN
            return r2
        L_0x04e2:
            com.google.android.gms.fitness.data.Field r2 = com.google.android.gms.fitness.data.HealthFields.FIELD_SUPPLEMENTAL_OXYGEN_FLOW_RATE_MAX
            return r2
        L_0x04e5:
            com.google.android.gms.fitness.data.Field r2 = com.google.android.gms.fitness.data.HealthFields.FIELD_SUPPLEMENTAL_OXYGEN_FLOW_RATE_AVERAGE
            return r2
        L_0x04e8:
            com.google.android.gms.fitness.data.Field r2 = com.google.android.gms.fitness.data.HealthFields.FIELD_SUPPLEMENTAL_OXYGEN_FLOW_RATE
            return r2
        L_0x04eb:
            com.google.android.gms.fitness.data.Field r2 = zzla
            return r2
        L_0x04ee:
            com.google.android.gms.fitness.data.Field r2 = zzkv
            return r2
        L_0x04f1:
            com.google.android.gms.fitness.data.Field r2 = zzku
            return r2
        L_0x04f4:
            com.google.android.gms.fitness.data.Field r2 = zzkx
            return r2
        L_0x04f7:
            com.google.android.gms.fitness.data.Field r2 = zzkw
            return r2
        L_0x04fa:
            com.google.android.gms.fitness.data.Field r2 = com.google.android.gms.fitness.data.HealthFields.FIELD_OXYGEN_THERAPY_ADMINISTRATION_MODE
            return r2
        L_0x04fd:
            com.google.android.gms.fitness.data.Field r2 = com.google.android.gms.fitness.data.HealthFields.FIELD_OXYGEN_SATURATION_SYSTEM
            return r2
        L_0x0500:
            com.google.android.gms.fitness.data.Field r2 = com.google.android.gms.fitness.data.HealthFields.FIELD_OXYGEN_SATURATION_MIN
            return r2
        L_0x0503:
            com.google.android.gms.fitness.data.Field r2 = com.google.android.gms.fitness.data.HealthFields.FIELD_OXYGEN_SATURATION_MEASUREMENT_METHOD
            return r2
        L_0x0506:
            com.google.android.gms.fitness.data.Field r2 = com.google.android.gms.fitness.data.HealthFields.FIELD_OXYGEN_SATURATION_MAX
            return r2
        L_0x0509:
            com.google.android.gms.fitness.data.Field r2 = com.google.android.gms.fitness.data.HealthFields.FIELD_OXYGEN_SATURATION_AVERAGE
            return r2
        L_0x050c:
            com.google.android.gms.fitness.data.Field r2 = com.google.android.gms.fitness.data.HealthFields.FIELD_OXYGEN_SATURATION
            return r2
        L_0x050f:
            com.google.android.gms.fitness.data.Field r2 = com.google.android.gms.fitness.data.HealthFields.FIELD_OVULATION_TEST_RESULT
            return r2
        L_0x0512:
            com.google.android.gms.fitness.data.Field r2 = FIELD_OCCURRENCES
            return r2
        L_0x0515:
            com.google.android.gms.fitness.data.Field r2 = FIELD_NUTRIENTS
            return r2
        L_0x0518:
            com.google.android.gms.fitness.data.Field r2 = FIELD_NUM_SEGMENTS
            return r2
        L_0x051b:
            com.google.android.gms.fitness.data.Field r2 = zzky
            return r2
        L_0x051e:
            com.google.android.gms.fitness.data.Field r2 = zzkz
            return r2
        L_0x0521:
            com.google.android.gms.fitness.data.Field r2 = FIELD_MIN
            return r2
        L_0x0524:
            com.google.android.gms.fitness.data.Field r2 = com.google.android.gms.fitness.data.HealthFields.FIELD_MENSTRUAL_FLOW
            return r2
        L_0x0527:
            com.google.android.gms.fitness.data.Field r2 = FIELD_MEAL_TYPE
            return r2
        L_0x052a:
            com.google.android.gms.fitness.data.Field r2 = FIELD_MAX
            return r2
        L_0x052d:
            com.google.android.gms.fitness.data.Field r2 = FIELD_LOW_LONGITUDE
            return r2
        L_0x0530:
            com.google.android.gms.fitness.data.Field r2 = FIELD_LOW_LATITUDE
            return r2
        L_0x0533:
            com.google.android.gms.fitness.data.Field r2 = FIELD_LONGITUDE
            return r2
        L_0x0536:
            com.google.android.gms.fitness.data.Field r2 = FIELD_LATITUDE
            return r2
        L_0x0539:
            com.google.android.gms.fitness.data.Field r2 = FIELD_HIGH_LONGITUDE
            return r2
        L_0x053c:
            com.google.android.gms.fitness.data.Field r2 = FIELD_HIGH_LATITUDE
            return r2
        L_0x053f:
            com.google.android.gms.fitness.data.Field r2 = FIELD_INTENSITY
            return r2
        L_0x0542:
            com.google.android.gms.fitness.data.Field r2 = FIELD_HEIGHT
            return r2
        L_0x0545:
            com.google.android.gms.fitness.data.Field r2 = FIELD_FOOD_ITEM
            return r2
        L_0x0548:
            com.google.android.gms.fitness.data.Field r2 = zzkr
            return r2
        L_0x054b:
            com.google.android.gms.fitness.data.Field r2 = zzkt
            return r2
        L_0x054e:
            com.google.android.gms.fitness.data.Field r2 = zzks
            return r2
        L_0x0551:
            com.google.android.gms.fitness.data.Field r2 = FIELD_EXERCISE
            return r2
        L_0x0554:
            com.google.android.gms.fitness.data.Field r2 = zzkq
            return r2
        L_0x0557:
            com.google.android.gms.fitness.data.Field r2 = zzkp
            return r2
        L_0x055a:
            com.google.android.gms.fitness.data.Field r2 = zzko
            return r2
        L_0x055d:
            com.google.android.gms.fitness.data.Field r2 = FIELD_DURATION
            return r2
        L_0x0560:
            com.google.android.gms.fitness.data.Field r2 = FIELD_DISTANCE
            return r2
        L_0x0563:
            com.google.android.gms.fitness.data.Field r2 = zzkn
            return r2
        L_0x0566:
            com.google.android.gms.fitness.data.Field r2 = FIELD_CONFIDENCE
            return r2
        L_0x0569:
            com.google.android.gms.fitness.data.Field r2 = FIELD_CIRCUMFERENCE
            return r2
        L_0x056c:
            com.google.android.gms.fitness.data.Field r2 = com.google.android.gms.fitness.data.HealthFields.FIELD_CERVICAL_POSITION
            return r2
        L_0x056f:
            com.google.android.gms.fitness.data.Field r2 = com.google.android.gms.fitness.data.HealthFields.FIELD_CERVICAL_MUCUS_TEXTURE
            return r2
        L_0x0572:
            com.google.android.gms.fitness.data.Field r2 = com.google.android.gms.fitness.data.HealthFields.FIELD_CERVICAL_MUCUS_AMOUNT
            return r2
        L_0x0575:
            com.google.android.gms.fitness.data.Field r2 = com.google.android.gms.fitness.data.HealthFields.FIELD_CERVICAL_FIRMNESS
            return r2
        L_0x0578:
            com.google.android.gms.fitness.data.Field r2 = com.google.android.gms.fitness.data.HealthFields.FIELD_CERVICAL_DILATION
            return r2
        L_0x057b:
            com.google.android.gms.fitness.data.Field r2 = FIELD_CALORIES
            return r2
        L_0x057e:
            com.google.android.gms.fitness.data.Field r2 = FIELD_BPM
            return r2
        L_0x0581:
            com.google.android.gms.fitness.data.Field r2 = com.google.android.gms.fitness.data.HealthFields.FIELD_BODY_TEMPERATURE_MEASUREMENT_LOCATION
            return r2
        L_0x0584:
            com.google.android.gms.fitness.data.Field r2 = com.google.android.gms.fitness.data.HealthFields.FIELD_BODY_TEMPERATURE
            return r2
        L_0x0587:
            com.google.android.gms.fitness.data.Field r2 = com.google.android.gms.fitness.data.HealthFields.FIELD_BODY_POSITION
            return r2
        L_0x058a:
            com.google.android.gms.fitness.data.Field r2 = com.google.android.gms.fitness.data.HealthFields.FIELD_BLOOD_PRESSURE_SYSTOLIC_MIN
            return r2
        L_0x058d:
            com.google.android.gms.fitness.data.Field r2 = com.google.android.gms.fitness.data.HealthFields.FIELD_BLOOD_PRESSURE_SYSTOLIC_MAX
            return r2
        L_0x0590:
            com.google.android.gms.fitness.data.Field r2 = com.google.android.gms.fitness.data.HealthFields.FIELD_BLOOD_PRESSURE_SYSTOLIC_AVERAGE
            return r2
        L_0x0593:
            com.google.android.gms.fitness.data.Field r2 = com.google.android.gms.fitness.data.HealthFields.FIELD_BLOOD_PRESSURE_SYSTOLIC
            return r2
        L_0x0596:
            com.google.android.gms.fitness.data.Field r2 = com.google.android.gms.fitness.data.HealthFields.FIELD_BLOOD_PRESSURE_MEASUREMENT_LOCATION
            return r2
        L_0x0599:
            com.google.android.gms.fitness.data.Field r2 = com.google.android.gms.fitness.data.HealthFields.FIELD_BLOOD_PRESSURE_DIASTOLIC_MIN
            return r2
        L_0x059c:
            com.google.android.gms.fitness.data.Field r2 = com.google.android.gms.fitness.data.HealthFields.FIELD_BLOOD_PRESSURE_DIASTOLIC_MAX
            return r2
        L_0x059f:
            com.google.android.gms.fitness.data.Field r2 = com.google.android.gms.fitness.data.HealthFields.FIELD_BLOOD_PRESSURE_DIASTOLIC_AVERAGE
            return r2
        L_0x05a2:
            com.google.android.gms.fitness.data.Field r2 = com.google.android.gms.fitness.data.HealthFields.FIELD_BLOOD_PRESSURE_DIASTOLIC
            return r2
        L_0x05a5:
            com.google.android.gms.fitness.data.Field r2 = com.google.android.gms.fitness.data.HealthFields.FIELD_BLOOD_GLUCOSE_SPECIMEN_SOURCE
            return r2
        L_0x05a8:
            com.google.android.gms.fitness.data.Field r2 = com.google.android.gms.fitness.data.HealthFields.FIELD_BLOOD_GLUCOSE_LEVEL
            return r2
        L_0x05ab:
            com.google.android.gms.fitness.data.Field r2 = FIELD_AVERAGE
            return r2
        L_0x05ae:
            com.google.android.gms.fitness.data.Field r2 = FIELD_ALTITUDE
            return r2
        L_0x05b1:
            com.google.android.gms.fitness.data.Field r2 = zzkj
            return r2
        L_0x05b4:
            com.google.android.gms.fitness.data.Field r2 = zzki
            return r2
        L_0x05b7:
            com.google.android.gms.fitness.data.Field r2 = FIELD_ACTIVITY_CONFIDENCE
            return r2
        L_0x05ba:
            com.google.android.gms.fitness.data.Field r2 = FIELD_ACTIVITY
            return r2
        L_0x05bd:
            com.google.android.gms.fitness.data.Field r2 = FIELD_ACCURACY
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.fitness.data.Field.zza(java.lang.String, int):com.google.android.gms.fitness.data.Field");
    }

    @ShowFirstParty
    private static Field zzc(String str) {
        return new Field(str, 1);
    }

    @ShowFirstParty
    public static Field zzd(String str) {
        return new Field(str, 1, true);
    }

    @ShowFirstParty
    public static Field zze(String str) {
        return new Field(str, 2);
    }

    @ShowFirstParty
    private static Field zzf(String str) {
        return new Field(str, 2, true);
    }

    @ShowFirstParty
    private static Field zzg(String str) {
        return new Field(str, 4);
    }

    @ShowFirstParty
    public static Field zzh(String str) {
        return new Field(str, 7);
    }

    @ShowFirstParty
    public static Field zzi(String str) {
        return new Field(str, 7, true);
    }

    public final boolean equals(@Nullable Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof Field)) {
            return false;
        }
        Field field = (Field) obj;
        return this.name.equals(field.name) && this.format == field.format;
    }

    public final int getFormat() {
        return this.format;
    }

    public final String getName() {
        return this.name;
    }

    public final int hashCode() {
        return this.name.hashCode();
    }

    @Nullable
    public final Boolean isOptional() {
        return this.zzlc;
    }

    public final String toString() {
        Object[] objArr = new Object[2];
        objArr[0] = this.name;
        objArr[1] = this.format == 1 ? "i" : "f";
        return String.format("%s(%s)", objArr);
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeString(parcel, 1, getName(), false);
        SafeParcelWriter.writeInt(parcel, 2, getFormat());
        SafeParcelWriter.writeBooleanObject(parcel, 3, isOptional(), false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
