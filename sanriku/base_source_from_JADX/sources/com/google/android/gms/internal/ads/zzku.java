package com.google.android.gms.internal.ads;

import android.util.Log;
import com.google.android.gms.internal.ads.zzln;

final class zzku {
    private static final int zzawy = zzov.zzbj("nam");
    private static final int zzawz = zzov.zzbj("trk");
    private static final int zzaxa = zzov.zzbj("cmt");
    private static final int zzaxb = zzov.zzbj("day");
    private static final int zzaxc = zzov.zzbj("ART");
    private static final int zzaxd = zzov.zzbj("too");
    private static final int zzaxe = zzov.zzbj("alb");
    private static final int zzaxf = zzov.zzbj("com");
    private static final int zzaxg = zzov.zzbj("wrt");
    private static final int zzaxh = zzov.zzbj("lyr");
    private static final int zzaxi = zzov.zzbj("gen");
    private static final int zzaxj = zzov.zzbj("covr");
    private static final int zzaxk = zzov.zzbj("gnre");
    private static final int zzaxl = zzov.zzbj("grp");
    private static final int zzaxm = zzov.zzbj("disk");
    private static final int zzaxn = zzov.zzbj("trkn");
    private static final int zzaxo = zzov.zzbj("tmpo");
    private static final int zzaxp = zzov.zzbj("cpil");
    private static final int zzaxq = zzov.zzbj("aART");
    private static final int zzaxr = zzov.zzbj("sonm");
    private static final int zzaxs = zzov.zzbj("soal");
    private static final int zzaxt = zzov.zzbj("soar");
    private static final int zzaxu = zzov.zzbj("soaa");
    private static final int zzaxv = zzov.zzbj("soco");
    private static final int zzaxw = zzov.zzbj("rtng");
    private static final int zzaxx = zzov.zzbj("pgap");
    private static final int zzaxy = zzov.zzbj("sosn");
    private static final int zzaxz = zzov.zzbj("tvsh");
    private static final int zzaya = zzov.zzbj("----");
    private static final String[] zzayb = {"Blues", "Classic Rock", "Country", "Dance", "Disco", "Funk", "Grunge", "Hip-Hop", "Jazz", "Metal", "New Age", "Oldies", "Other", "Pop", "R&B", "Rap", "Reggae", "Rock", "Techno", "Industrial", "Alternative", "Ska", "Death Metal", "Pranks", "Soundtrack", "Euro-Techno", "Ambient", "Trip-Hop", "Vocal", "Jazz+Funk", "Fusion", "Trance", "Classical", "Instrumental", "Acid", "House", "Game", "Sound Clip", "Gospel", "Noise", "AlternRock", "Bass", "Soul", "Punk", "Space", "Meditative", "Instrumental Pop", "Instrumental Rock", "Ethnic", "Gothic", "Darkwave", "Techno-Industrial", "Electronic", "Pop-Folk", "Eurodance", "Dream", "Southern Rock", "Comedy", "Cult", "Gangsta", "Top 40", "Christian Rap", "Pop/Funk", "Jungle", "Native American", "Cabaret", "New Wave", "Psychadelic", "Rave", "Showtunes", "Trailer", "Lo-Fi", "Tribal", "Acid Punk", "Acid Jazz", "Polka", "Retro", "Musical", "Rock & Roll", "Hard Rock", "Folk", "Folk-Rock", "National Folk", "Swing", "Fast Fusion", "Bebob", "Latin", "Revival", "Celtic", "Bluegrass", "Avantgarde", "Gothic Rock", "Progressive Rock", "Psychedelic Rock", "Symphonic Rock", "Slow Rock", "Big Band", "Chorus", "Easy Listening", "Acoustic", "Humour", "Speech", "Chanson", "Opera", "Chamber Music", "Sonata", "Symphony", "Booty Bass", "Primus", "Porn Groove", "Satire", "Slow Jam", "Club", "Tango", "Samba", "Folklore", "Ballad", "Power Ballad", "Rhythmic Soul", "Freestyle", "Duet", "Punk Rock", "Drum Solo", "A capella", "Euro-House", "Dance Hall", "Goa", "Drum & Bass", "Club-House", "Hardcore", "Terror", "Indie", "BritPop", "Negerpunk", "Polsk Punk", "Beat", "Christian Gangsta Rap", "Heavy Metal", "Black Metal", "Crossover", "Contemporary Christian", "Christian Rock", "Merengue", "Salsa", "Thrash Metal", "Anime", "Jpop", "Synthpop"};

    private static zzlt zza(int i, String str, zzos zzos) {
        int readInt = zzos.readInt();
        if (zzos.readInt() == zzki.zzavf) {
            zzos.zzbj(8);
            return new zzlt(str, (String) null, zzos.zzbk(readInt - 16));
        }
        String valueOf = String.valueOf(zzki.zzar(i));
        Log.w("MetadataUtil", valueOf.length() != 0 ? "Failed to parse text attribute: ".concat(valueOf) : new String("Failed to parse text attribute: "));
        return null;
    }

    private static zzlu zza(int i, String str, zzos zzos, boolean z, boolean z2) {
        int zze = zze(zzos);
        if (z2) {
            zze = Math.min(1, zze);
        }
        if (zze >= 0) {
            return z ? new zzlt(str, (String) null, Integer.toString(zze)) : new zzlp("und", str, Integer.toString(zze));
        }
        String valueOf = String.valueOf(zzki.zzar(i));
        Log.w("MetadataUtil", valueOf.length() != 0 ? "Failed to parse uint8 attribute: ".concat(valueOf) : new String("Failed to parse uint8 attribute: "));
        return null;
    }

    private static zzlt zzb(int i, String str, zzos zzos) {
        int readInt = zzos.readInt();
        if (zzos.readInt() == zzki.zzavf && readInt >= 22) {
            zzos.zzbj(10);
            int readUnsignedShort = zzos.readUnsignedShort();
            if (readUnsignedShort > 0) {
                StringBuilder sb = new StringBuilder(11);
                sb.append(readUnsignedShort);
                String sb2 = sb.toString();
                int readUnsignedShort2 = zzos.readUnsignedShort();
                if (readUnsignedShort2 > 0) {
                    String valueOf = String.valueOf(sb2);
                    StringBuilder sb3 = new StringBuilder(valueOf.length() + 12);
                    sb3.append(valueOf);
                    sb3.append("/");
                    sb3.append(readUnsignedShort2);
                    sb2 = sb3.toString();
                }
                return new zzlt(str, (String) null, sb2);
            }
        }
        String valueOf2 = String.valueOf(zzki.zzar(i));
        Log.w("MetadataUtil", valueOf2.length() != 0 ? "Failed to parse index/count attribute: ".concat(valueOf2) : new String("Failed to parse index/count attribute: "));
        return null;
    }

    public static zzln.zza zzd(zzos zzos) {
        String str;
        int readInt = zzos.readInt() + zzos.getPosition();
        int readInt2 = zzos.readInt();
        int i = readInt2 >>> 24;
        zzlu zzlu = null;
        if (i == 169 || i == 65533) {
            int i2 = 16777215 & readInt2;
            if (i2 == zzaxa) {
                int readInt3 = zzos.readInt();
                if (zzos.readInt() == zzki.zzavf) {
                    zzos.zzbj(8);
                    String zzbk = zzos.zzbk(readInt3 - 16);
                    zzlu = new zzlp("und", zzbk, zzbk);
                } else {
                    String valueOf = String.valueOf(zzki.zzar(readInt2));
                    Log.w("MetadataUtil", valueOf.length() != 0 ? "Failed to parse comment attribute: ".concat(valueOf) : new String("Failed to parse comment attribute: "));
                }
                zzos.zzbi(readInt);
                return zzlu;
            }
            if (i2 != zzawy) {
                if (i2 != zzawz) {
                    if (i2 != zzaxf) {
                        if (i2 != zzaxg) {
                            if (i2 == zzaxb) {
                                zzlt zza = zza(readInt2, "TDRC", zzos);
                                zzos.zzbi(readInt);
                                return zza;
                            } else if (i2 == zzaxc) {
                                zzlt zza2 = zza(readInt2, "TPE1", zzos);
                                zzos.zzbi(readInt);
                                return zza2;
                            } else if (i2 == zzaxd) {
                                zzlt zza3 = zza(readInt2, "TSSE", zzos);
                                zzos.zzbi(readInt);
                                return zza3;
                            } else if (i2 == zzaxe) {
                                zzlt zza4 = zza(readInt2, "TALB", zzos);
                                zzos.zzbi(readInt);
                                return zza4;
                            } else if (i2 == zzaxh) {
                                zzlt zza5 = zza(readInt2, "USLT", zzos);
                                zzos.zzbi(readInt);
                                return zza5;
                            } else if (i2 == zzaxi) {
                                zzlt zza6 = zza(readInt2, "TCON", zzos);
                                zzos.zzbi(readInt);
                                return zza6;
                            } else if (i2 == zzaxl) {
                                zzlt zza7 = zza(readInt2, "TIT1", zzos);
                                zzos.zzbi(readInt);
                                return zza7;
                            }
                        }
                    }
                    zzlt zza8 = zza(readInt2, "TCOM", zzos);
                    zzos.zzbi(readInt);
                    return zza8;
                }
            }
            zzlt zza9 = zza(readInt2, "TIT2", zzos);
            zzos.zzbi(readInt);
            return zza9;
        }
        try {
            if (readInt2 == zzaxk) {
                int zze = zze(zzos);
                String str2 = (zze <= 0 || zze > zzayb.length) ? null : zzayb[zze - 1];
                if (str2 != null) {
                    zzlu = new zzlt("TCON", (String) null, str2);
                } else {
                    Log.w("MetadataUtil", "Failed to parse standard genre code");
                }
                return zzlu;
            } else if (readInt2 == zzaxm) {
                zzlt zzb = zzb(readInt2, "TPOS", zzos);
                zzos.zzbi(readInt);
                return zzb;
            } else if (readInt2 == zzaxn) {
                zzlt zzb2 = zzb(readInt2, "TRCK", zzos);
                zzos.zzbi(readInt);
                return zzb2;
            } else if (readInt2 == zzaxo) {
                zzlu zza10 = zza(readInt2, "TBPM", zzos, true, false);
                zzos.zzbi(readInt);
                return zza10;
            } else if (readInt2 == zzaxp) {
                zzlu zza11 = zza(readInt2, "TCMP", zzos, true, true);
                zzos.zzbi(readInt);
                return zza11;
            } else if (readInt2 == zzaxj) {
                int readInt4 = zzos.readInt();
                if (zzos.readInt() == zzki.zzavf) {
                    int zzaq = zzki.zzaq(zzos.readInt());
                    String str3 = zzaq == 13 ? "image/jpeg" : zzaq == 14 ? "image/png" : null;
                    if (str3 == null) {
                        StringBuilder sb = new StringBuilder(41);
                        sb.append("Unrecognized cover art flags: ");
                        sb.append(zzaq);
                        str = sb.toString();
                    } else {
                        zzos.zzbj(4);
                        int i3 = readInt4 - 16;
                        byte[] bArr = new byte[i3];
                        zzos.zze(bArr, 0, i3);
                        zzlu = new zzlo(str3, (String) null, 3, bArr);
                        zzos.zzbi(readInt);
                        return zzlu;
                    }
                } else {
                    str = "Failed to parse cover art attribute";
                }
                Log.w("MetadataUtil", str);
                zzos.zzbi(readInt);
                return zzlu;
            } else if (readInt2 == zzaxq) {
                zzlt zza12 = zza(readInt2, "TPE2", zzos);
                zzos.zzbi(readInt);
                return zza12;
            } else if (readInt2 == zzaxr) {
                zzlt zza13 = zza(readInt2, "TSOT", zzos);
                zzos.zzbi(readInt);
                return zza13;
            } else if (readInt2 == zzaxs) {
                zzlt zza14 = zza(readInt2, "TSO2", zzos);
                zzos.zzbi(readInt);
                return zza14;
            } else if (readInt2 == zzaxt) {
                zzlt zza15 = zza(readInt2, "TSOA", zzos);
                zzos.zzbi(readInt);
                return zza15;
            } else if (readInt2 == zzaxu) {
                zzlt zza16 = zza(readInt2, "TSOP", zzos);
                zzos.zzbi(readInt);
                return zza16;
            } else if (readInt2 == zzaxv) {
                zzlt zza17 = zza(readInt2, "TSOC", zzos);
                zzos.zzbi(readInt);
                return zza17;
            } else if (readInt2 == zzaxw) {
                zzlu zza18 = zza(readInt2, "ITUNESADVISORY", zzos, false, false);
                zzos.zzbi(readInt);
                return zza18;
            } else if (readInt2 == zzaxx) {
                zzlu zza19 = zza(readInt2, "ITUNESGAPLESS", zzos, false, true);
                zzos.zzbi(readInt);
                return zza19;
            } else if (readInt2 == zzaxy) {
                zzlt zza20 = zza(readInt2, "TVSHOWSORT", zzos);
                zzos.zzbi(readInt);
                return zza20;
            } else if (readInt2 == zzaxz) {
                zzlt zza21 = zza(readInt2, "TVSHOW", zzos);
                zzos.zzbi(readInt);
                return zza21;
            } else if (readInt2 == zzaya) {
                String str4 = null;
                String str5 = null;
                int i4 = -1;
                int i5 = -1;
                while (zzos.getPosition() < readInt) {
                    int position = zzos.getPosition();
                    int readInt5 = zzos.readInt();
                    int readInt6 = zzos.readInt();
                    zzos.zzbj(4);
                    if (readInt6 == zzki.zzavd) {
                        str4 = zzos.zzbk(readInt5 - 12);
                    } else if (readInt6 == zzki.zzave) {
                        str5 = zzos.zzbk(readInt5 - 12);
                    } else {
                        if (readInt6 == zzki.zzavf) {
                            i4 = position;
                            i5 = readInt5;
                        }
                        zzos.zzbj(readInt5 - 12);
                    }
                }
                if ("com.apple.iTunes".equals(str4) && "iTunSMPB".equals(str5)) {
                    if (i4 != -1) {
                        zzos.zzbi(i4);
                        zzos.zzbj(16);
                        zzlu = new zzlp("und", str5, zzos.zzbk(i5 - 16));
                    }
                }
                zzos.zzbi(readInt);
                return zzlu;
            }
        } finally {
            zzos.zzbi(readInt);
        }
        String valueOf2 = String.valueOf(zzki.zzar(readInt2));
        Log.d("MetadataUtil", valueOf2.length() != 0 ? "Skipped unknown metadata entry: ".concat(valueOf2) : new String("Skipped unknown metadata entry: "));
        zzos.zzbi(readInt);
        return null;
    }

    private static int zze(zzos zzos) {
        zzos.zzbj(4);
        if (zzos.readInt() == zzki.zzavf) {
            zzos.zzbj(8);
            return zzos.readUnsignedByte();
        }
        Log.w("MetadataUtil", "Failed to parse uint8 attribute value");
        return -1;
    }
}
