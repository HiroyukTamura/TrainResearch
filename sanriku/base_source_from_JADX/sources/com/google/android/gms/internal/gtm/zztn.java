package com.google.android.gms.internal.gtm;

final class zztn {
    static String zzd(zzps zzps) {
        String str;
        zzto zzto = new zzto(zzps);
        StringBuilder sb = new StringBuilder(zzto.size());
        for (int i = 0; i < zzto.size(); i++) {
            int zzak = zzto.zzak(i);
            if (zzak == 34) {
                str = "\\\"";
            } else if (zzak == 39) {
                str = "\\'";
            } else if (zzak != 92) {
                switch (zzak) {
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
                        if (zzak < 32 || zzak > 126) {
                            sb.append('\\');
                            sb.append((char) (((zzak >>> 6) & 3) + 48));
                            sb.append((char) (((zzak >>> 3) & 7) + 48));
                            zzak = (zzak & 7) + 48;
                        }
                        sb.append((char) zzak);
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
