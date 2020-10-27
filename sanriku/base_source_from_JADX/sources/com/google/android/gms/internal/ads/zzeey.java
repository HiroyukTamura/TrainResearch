package com.google.android.gms.internal.ads;

final class zzeey {
    static String zzam(zzeaq zzeaq) {
        String str;
        zzeex zzeex = new zzeex(zzeaq);
        StringBuilder sb = new StringBuilder(zzeex.size());
        for (int i = 0; i < zzeex.size(); i++) {
            int zzfo = zzeex.zzfo(i);
            if (zzfo == 34) {
                str = "\\\"";
            } else if (zzfo == 39) {
                str = "\\'";
            } else if (zzfo != 92) {
                switch (zzfo) {
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
                        if (zzfo < 32 || zzfo > 126) {
                            sb.append('\\');
                            sb.append((char) (((zzfo >>> 6) & 3) + 48));
                            sb.append((char) (((zzfo >>> 3) & 7) + 48));
                            zzfo = (zzfo & 7) + 48;
                        }
                        sb.append((char) zzfo);
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
