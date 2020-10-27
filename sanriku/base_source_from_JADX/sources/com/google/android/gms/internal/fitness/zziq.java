package com.google.android.gms.internal.fitness;

final class zziq {
    static String zzc(zzff zzff) {
        String str;
        zzip zzip = new zzip(zzff);
        StringBuilder sb = new StringBuilder(zzip.size());
        for (int i = 0; i < zzip.size(); i++) {
            int zzh = zzip.zzh(i);
            if (zzh == 34) {
                str = "\\\"";
            } else if (zzh == 39) {
                str = "\\'";
            } else if (zzh != 92) {
                switch (zzh) {
                    case 7:
                        str = "\\a";
                        break;
                    case 8:
                        str = "\\b";
                        break;
                    case 9:
                        str = "\\t";
                        break;
                    case 10:
                        str = "\\n";
                        break;
                    case 11:
                        str = "\\v";
                        break;
                    case 12:
                        str = "\\f";
                        break;
                    case 13:
                        str = "\\r";
                        break;
                    default:
                        if (zzh < 32 || zzh > 126) {
                            sb.append('\\');
                            sb.append((char) (((zzh >>> 6) & 3) + 48));
                            sb.append((char) (((zzh >>> 3) & 7) + 48));
                            zzh = (zzh & 7) + 48;
                        }
                        sb.append((char) zzh);
                        continue;
                }
            } else {
                str = "\\\\";
            }
            sb.append(str);
        }
        return sb.toString();
    }
}
