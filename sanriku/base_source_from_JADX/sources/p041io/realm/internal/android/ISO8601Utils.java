package p041io.realm.internal.android;

import java.util.TimeZone;
import p009e.p010a.p011a.p012a.C0681a;

/* renamed from: io.realm.internal.android.ISO8601Utils */
public class ISO8601Utils {
    private static final TimeZone TIMEZONE_UTC;
    private static final TimeZone TIMEZONE_Z;
    private static final String UTC_ID = "UTC";

    static {
        TimeZone timeZone = TimeZone.getTimeZone(UTC_ID);
        TIMEZONE_UTC = timeZone;
        TIMEZONE_Z = timeZone;
    }

    private static boolean checkOffset(String str, int i, char c) {
        return i < str.length() && str.charAt(i) == c;
    }

    private static int indexOfNonDigit(String str, int i) {
        while (i < str.length()) {
            char charAt = str.charAt(i);
            if (charAt < '0' || charAt > '9') {
                return i;
            }
            i++;
        }
        return str.length();
    }

    /* JADX WARNING: Removed duplicated region for block: B:48:0x00d3 A[Catch:{ IllegalArgumentException | IndexOutOfBoundsException | NumberFormatException -> 0x01be }] */
    /* JADX WARNING: Removed duplicated region for block: B:75:0x01b6 A[Catch:{ IllegalArgumentException | IndexOutOfBoundsException | NumberFormatException -> 0x01be }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.util.Date parse(java.lang.String r18, java.text.ParsePosition r19) throws java.text.ParseException {
        /*
            r1 = r18
            r2 = r19
            java.lang.String r3 = "'"
            int r0 = r19.getIndex()     // Catch:{ IndexOutOfBoundsException -> 0x01c2, NumberFormatException -> 0x01c0, IllegalArgumentException -> 0x01be }
            int r4 = r0 + 4
            int r0 = parseInt(r1, r0, r4)     // Catch:{ IndexOutOfBoundsException -> 0x01c2, NumberFormatException -> 0x01c0, IllegalArgumentException -> 0x01be }
            r5 = 45
            boolean r6 = checkOffset(r1, r4, r5)     // Catch:{ IndexOutOfBoundsException -> 0x01c2, NumberFormatException -> 0x01c0, IllegalArgumentException -> 0x01be }
            if (r6 == 0) goto L_0x001a
            int r4 = r4 + 1
        L_0x001a:
            int r6 = r4 + 2
            int r4 = parseInt(r1, r4, r6)     // Catch:{ IndexOutOfBoundsException -> 0x01c2, NumberFormatException -> 0x01c0, IllegalArgumentException -> 0x01be }
            boolean r7 = checkOffset(r1, r6, r5)     // Catch:{ IndexOutOfBoundsException -> 0x01c2, NumberFormatException -> 0x01c0, IllegalArgumentException -> 0x01be }
            if (r7 == 0) goto L_0x0028
            int r6 = r6 + 1
        L_0x0028:
            int r7 = r6 + 2
            int r6 = parseInt(r1, r6, r7)     // Catch:{ IndexOutOfBoundsException -> 0x01c2, NumberFormatException -> 0x01c0, IllegalArgumentException -> 0x01be }
            r8 = 84
            boolean r8 = checkOffset(r1, r7, r8)     // Catch:{ IndexOutOfBoundsException -> 0x01c2, NumberFormatException -> 0x01c0, IllegalArgumentException -> 0x01be }
            r9 = 1
            if (r8 != 0) goto L_0x004b
            int r10 = r18.length()     // Catch:{ IndexOutOfBoundsException -> 0x01c2, NumberFormatException -> 0x01c0, IllegalArgumentException -> 0x01be }
            if (r10 > r7) goto L_0x004b
            java.util.GregorianCalendar r5 = new java.util.GregorianCalendar     // Catch:{ IndexOutOfBoundsException -> 0x01c2, NumberFormatException -> 0x01c0, IllegalArgumentException -> 0x01be }
            int r4 = r4 - r9
            r5.<init>(r0, r4, r6)     // Catch:{ IndexOutOfBoundsException -> 0x01c2, NumberFormatException -> 0x01c0, IllegalArgumentException -> 0x01be }
            r2.setIndex(r7)     // Catch:{ IndexOutOfBoundsException -> 0x01c2, NumberFormatException -> 0x01c0, IllegalArgumentException -> 0x01be }
            java.util.Date r0 = r5.getTime()     // Catch:{ IndexOutOfBoundsException -> 0x01c2, NumberFormatException -> 0x01c0, IllegalArgumentException -> 0x01be }
            return r0
        L_0x004b:
            r10 = 43
            r11 = 90
            r12 = 2
            if (r8 == 0) goto L_0x00c2
            int r7 = r7 + 1
            int r8 = r7 + 2
            int r7 = parseInt(r1, r7, r8)     // Catch:{ IndexOutOfBoundsException -> 0x01c2, NumberFormatException -> 0x01c0, IllegalArgumentException -> 0x01be }
            r13 = 58
            boolean r14 = checkOffset(r1, r8, r13)     // Catch:{ IndexOutOfBoundsException -> 0x01c2, NumberFormatException -> 0x01c0, IllegalArgumentException -> 0x01be }
            if (r14 == 0) goto L_0x0064
            int r8 = r8 + 1
        L_0x0064:
            int r14 = r8 + 2
            int r8 = parseInt(r1, r8, r14)     // Catch:{ IndexOutOfBoundsException -> 0x01c2, NumberFormatException -> 0x01c0, IllegalArgumentException -> 0x01be }
            boolean r13 = checkOffset(r1, r14, r13)     // Catch:{ IndexOutOfBoundsException -> 0x01c2, NumberFormatException -> 0x01c0, IllegalArgumentException -> 0x01be }
            if (r13 == 0) goto L_0x0072
            int r14 = r14 + 1
        L_0x0072:
            int r13 = r18.length()     // Catch:{ IndexOutOfBoundsException -> 0x01c2, NumberFormatException -> 0x01c0, IllegalArgumentException -> 0x01be }
            if (r13 <= r14) goto L_0x00bf
            char r13 = r1.charAt(r14)     // Catch:{ IndexOutOfBoundsException -> 0x01c2, NumberFormatException -> 0x01c0, IllegalArgumentException -> 0x01be }
            if (r13 == r11) goto L_0x00bf
            if (r13 == r10) goto L_0x00bf
            if (r13 == r5) goto L_0x00bf
            int r5 = r14 + 2
            int r13 = parseInt(r1, r14, r5)     // Catch:{ IndexOutOfBoundsException -> 0x01c2, NumberFormatException -> 0x01c0, IllegalArgumentException -> 0x01be }
            r14 = 59
            if (r13 <= r14) goto L_0x0092
            r14 = 63
            if (r13 >= r14) goto L_0x0092
            r13 = 59
        L_0x0092:
            r14 = 46
            boolean r14 = checkOffset(r1, r5, r14)     // Catch:{ IndexOutOfBoundsException -> 0x01c2, NumberFormatException -> 0x01c0, IllegalArgumentException -> 0x01be }
            if (r14 == 0) goto L_0x00bb
            int r5 = r5 + 1
            int r14 = r5 + 1
            int r14 = indexOfNonDigit(r1, r14)     // Catch:{ IndexOutOfBoundsException -> 0x01c2, NumberFormatException -> 0x01c0, IllegalArgumentException -> 0x01be }
            int r15 = r5 + 3
            int r15 = java.lang.Math.min(r14, r15)     // Catch:{ IndexOutOfBoundsException -> 0x01c2, NumberFormatException -> 0x01c0, IllegalArgumentException -> 0x01be }
            int r16 = parseInt(r1, r5, r15)     // Catch:{ IndexOutOfBoundsException -> 0x01c2, NumberFormatException -> 0x01c0, IllegalArgumentException -> 0x01be }
            int r15 = r15 - r5
            if (r15 == r9) goto L_0x00b5
            if (r15 == r12) goto L_0x00b2
            goto L_0x00b7
        L_0x00b2:
            int r16 = r16 * 10
            goto L_0x00b7
        L_0x00b5:
            int r16 = r16 * 100
        L_0x00b7:
            r5 = r14
            r12 = r16
            goto L_0x00cd
        L_0x00bb:
            r16 = 0
            r12 = 0
            goto L_0x00cd
        L_0x00bf:
            r5 = r7
            r7 = r14
            goto L_0x00c4
        L_0x00c2:
            r5 = 0
            r8 = 0
        L_0x00c4:
            r16 = 0
            r13 = 0
            r12 = 0
            r17 = r7
            r7 = r5
            r5 = r17
        L_0x00cd:
            int r14 = r18.length()     // Catch:{ IndexOutOfBoundsException -> 0x01c2, NumberFormatException -> 0x01c0, IllegalArgumentException -> 0x01be }
            if (r14 <= r5) goto L_0x01b6
            char r14 = r1.charAt(r5)     // Catch:{ IndexOutOfBoundsException -> 0x01c2, NumberFormatException -> 0x01c0, IllegalArgumentException -> 0x01be }
            if (r14 != r11) goto L_0x00de
            java.util.TimeZone r10 = TIMEZONE_Z     // Catch:{ IndexOutOfBoundsException -> 0x01c2, NumberFormatException -> 0x01c0, IllegalArgumentException -> 0x01be }
            int r5 = r5 + r9
            goto L_0x0184
        L_0x00de:
            if (r14 == r10) goto L_0x00ff
            r9 = 45
            if (r14 != r9) goto L_0x00e5
            goto L_0x00ff
        L_0x00e5:
            java.lang.IndexOutOfBoundsException r0 = new java.lang.IndexOutOfBoundsException     // Catch:{ IndexOutOfBoundsException -> 0x01c2, NumberFormatException -> 0x01c0, IllegalArgumentException -> 0x01be }
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ IndexOutOfBoundsException -> 0x01c2, NumberFormatException -> 0x01c0, IllegalArgumentException -> 0x01be }
            r4.<init>()     // Catch:{ IndexOutOfBoundsException -> 0x01c2, NumberFormatException -> 0x01c0, IllegalArgumentException -> 0x01be }
            java.lang.String r5 = "Invalid time zone indicator '"
            r4.append(r5)     // Catch:{ IndexOutOfBoundsException -> 0x01c2, NumberFormatException -> 0x01c0, IllegalArgumentException -> 0x01be }
            r4.append(r14)     // Catch:{ IndexOutOfBoundsException -> 0x01c2, NumberFormatException -> 0x01c0, IllegalArgumentException -> 0x01be }
            r4.append(r3)     // Catch:{ IndexOutOfBoundsException -> 0x01c2, NumberFormatException -> 0x01c0, IllegalArgumentException -> 0x01be }
            java.lang.String r4 = r4.toString()     // Catch:{ IndexOutOfBoundsException -> 0x01c2, NumberFormatException -> 0x01c0, IllegalArgumentException -> 0x01be }
            r0.<init>(r4)     // Catch:{ IndexOutOfBoundsException -> 0x01c2, NumberFormatException -> 0x01c0, IllegalArgumentException -> 0x01be }
            throw r0     // Catch:{ IndexOutOfBoundsException -> 0x01c2, NumberFormatException -> 0x01c0, IllegalArgumentException -> 0x01be }
        L_0x00ff:
            java.lang.String r9 = r1.substring(r5)     // Catch:{ IndexOutOfBoundsException -> 0x01c2, NumberFormatException -> 0x01c0, IllegalArgumentException -> 0x01be }
            int r10 = r9.length()     // Catch:{ IndexOutOfBoundsException -> 0x01c2, NumberFormatException -> 0x01c0, IllegalArgumentException -> 0x01be }
            int r5 = r5 + r10
            int r10 = r9.length()     // Catch:{ IndexOutOfBoundsException -> 0x01c2, NumberFormatException -> 0x01c0, IllegalArgumentException -> 0x01be }
            r11 = 3
            if (r10 != r11) goto L_0x0120
            java.lang.StringBuilder r10 = new java.lang.StringBuilder     // Catch:{ IndexOutOfBoundsException -> 0x01c2, NumberFormatException -> 0x01c0, IllegalArgumentException -> 0x01be }
            r10.<init>()     // Catch:{ IndexOutOfBoundsException -> 0x01c2, NumberFormatException -> 0x01c0, IllegalArgumentException -> 0x01be }
            r10.append(r9)     // Catch:{ IndexOutOfBoundsException -> 0x01c2, NumberFormatException -> 0x01c0, IllegalArgumentException -> 0x01be }
            java.lang.String r9 = "00"
            r10.append(r9)     // Catch:{ IndexOutOfBoundsException -> 0x01c2, NumberFormatException -> 0x01c0, IllegalArgumentException -> 0x01be }
            java.lang.String r9 = r10.toString()     // Catch:{ IndexOutOfBoundsException -> 0x01c2, NumberFormatException -> 0x01c0, IllegalArgumentException -> 0x01be }
        L_0x0120:
            java.lang.String r10 = "+0000"
            boolean r10 = r10.equals(r9)     // Catch:{ IndexOutOfBoundsException -> 0x01c2, NumberFormatException -> 0x01c0, IllegalArgumentException -> 0x01be }
            if (r10 != 0) goto L_0x0182
            java.lang.String r10 = "+00:00"
            boolean r10 = r10.equals(r9)     // Catch:{ IndexOutOfBoundsException -> 0x01c2, NumberFormatException -> 0x01c0, IllegalArgumentException -> 0x01be }
            if (r10 == 0) goto L_0x0131
            goto L_0x0182
        L_0x0131:
            java.lang.StringBuilder r10 = new java.lang.StringBuilder     // Catch:{ IndexOutOfBoundsException -> 0x01c2, NumberFormatException -> 0x01c0, IllegalArgumentException -> 0x01be }
            r10.<init>()     // Catch:{ IndexOutOfBoundsException -> 0x01c2, NumberFormatException -> 0x01c0, IllegalArgumentException -> 0x01be }
            java.lang.String r11 = "GMT"
            r10.append(r11)     // Catch:{ IndexOutOfBoundsException -> 0x01c2, NumberFormatException -> 0x01c0, IllegalArgumentException -> 0x01be }
            r10.append(r9)     // Catch:{ IndexOutOfBoundsException -> 0x01c2, NumberFormatException -> 0x01c0, IllegalArgumentException -> 0x01be }
            java.lang.String r9 = r10.toString()     // Catch:{ IndexOutOfBoundsException -> 0x01c2, NumberFormatException -> 0x01c0, IllegalArgumentException -> 0x01be }
            java.util.TimeZone r10 = java.util.TimeZone.getTimeZone(r9)     // Catch:{ IndexOutOfBoundsException -> 0x01c2, NumberFormatException -> 0x01c0, IllegalArgumentException -> 0x01be }
            java.lang.String r11 = r10.getID()     // Catch:{ IndexOutOfBoundsException -> 0x01c2, NumberFormatException -> 0x01c0, IllegalArgumentException -> 0x01be }
            boolean r14 = r11.equals(r9)     // Catch:{ IndexOutOfBoundsException -> 0x01c2, NumberFormatException -> 0x01c0, IllegalArgumentException -> 0x01be }
            if (r14 != 0) goto L_0x0184
            java.lang.String r14 = ":"
            java.lang.String r15 = ""
            java.lang.String r11 = r11.replace(r14, r15)     // Catch:{ IndexOutOfBoundsException -> 0x01c2, NumberFormatException -> 0x01c0, IllegalArgumentException -> 0x01be }
            boolean r11 = r11.equals(r9)     // Catch:{ IndexOutOfBoundsException -> 0x01c2, NumberFormatException -> 0x01c0, IllegalArgumentException -> 0x01be }
            if (r11 == 0) goto L_0x015f
            goto L_0x0184
        L_0x015f:
            java.lang.IndexOutOfBoundsException r0 = new java.lang.IndexOutOfBoundsException     // Catch:{ IndexOutOfBoundsException -> 0x01c2, NumberFormatException -> 0x01c0, IllegalArgumentException -> 0x01be }
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ IndexOutOfBoundsException -> 0x01c2, NumberFormatException -> 0x01c0, IllegalArgumentException -> 0x01be }
            r4.<init>()     // Catch:{ IndexOutOfBoundsException -> 0x01c2, NumberFormatException -> 0x01c0, IllegalArgumentException -> 0x01be }
            java.lang.String r5 = "Mismatching time zone indicator: "
            r4.append(r5)     // Catch:{ IndexOutOfBoundsException -> 0x01c2, NumberFormatException -> 0x01c0, IllegalArgumentException -> 0x01be }
            r4.append(r9)     // Catch:{ IndexOutOfBoundsException -> 0x01c2, NumberFormatException -> 0x01c0, IllegalArgumentException -> 0x01be }
            java.lang.String r5 = " given, resolves to "
            r4.append(r5)     // Catch:{ IndexOutOfBoundsException -> 0x01c2, NumberFormatException -> 0x01c0, IllegalArgumentException -> 0x01be }
            java.lang.String r5 = r10.getID()     // Catch:{ IndexOutOfBoundsException -> 0x01c2, NumberFormatException -> 0x01c0, IllegalArgumentException -> 0x01be }
            r4.append(r5)     // Catch:{ IndexOutOfBoundsException -> 0x01c2, NumberFormatException -> 0x01c0, IllegalArgumentException -> 0x01be }
            java.lang.String r4 = r4.toString()     // Catch:{ IndexOutOfBoundsException -> 0x01c2, NumberFormatException -> 0x01c0, IllegalArgumentException -> 0x01be }
            r0.<init>(r4)     // Catch:{ IndexOutOfBoundsException -> 0x01c2, NumberFormatException -> 0x01c0, IllegalArgumentException -> 0x01be }
            throw r0     // Catch:{ IndexOutOfBoundsException -> 0x01c2, NumberFormatException -> 0x01c0, IllegalArgumentException -> 0x01be }
        L_0x0182:
            java.util.TimeZone r10 = TIMEZONE_Z     // Catch:{ IndexOutOfBoundsException -> 0x01c2, NumberFormatException -> 0x01c0, IllegalArgumentException -> 0x01be }
        L_0x0184:
            java.util.GregorianCalendar r9 = new java.util.GregorianCalendar     // Catch:{ IndexOutOfBoundsException -> 0x01c2, NumberFormatException -> 0x01c0, IllegalArgumentException -> 0x01be }
            r9.<init>(r10)     // Catch:{ IndexOutOfBoundsException -> 0x01c2, NumberFormatException -> 0x01c0, IllegalArgumentException -> 0x01be }
            r10 = 0
            r9.setLenient(r10)     // Catch:{ IndexOutOfBoundsException -> 0x01c2, NumberFormatException -> 0x01c0, IllegalArgumentException -> 0x01be }
            r10 = 1
            r9.set(r10, r0)     // Catch:{ IndexOutOfBoundsException -> 0x01c2, NumberFormatException -> 0x01c0, IllegalArgumentException -> 0x01be }
            int r4 = r4 - r10
            r0 = 2
            r9.set(r0, r4)     // Catch:{ IndexOutOfBoundsException -> 0x01c2, NumberFormatException -> 0x01c0, IllegalArgumentException -> 0x01be }
            r0 = 5
            r9.set(r0, r6)     // Catch:{ IndexOutOfBoundsException -> 0x01c2, NumberFormatException -> 0x01c0, IllegalArgumentException -> 0x01be }
            r0 = 11
            r9.set(r0, r7)     // Catch:{ IndexOutOfBoundsException -> 0x01c2, NumberFormatException -> 0x01c0, IllegalArgumentException -> 0x01be }
            r0 = 12
            r9.set(r0, r8)     // Catch:{ IndexOutOfBoundsException -> 0x01c2, NumberFormatException -> 0x01c0, IllegalArgumentException -> 0x01be }
            r0 = 13
            r9.set(r0, r13)     // Catch:{ IndexOutOfBoundsException -> 0x01c2, NumberFormatException -> 0x01c0, IllegalArgumentException -> 0x01be }
            r0 = 14
            r9.set(r0, r12)     // Catch:{ IndexOutOfBoundsException -> 0x01c2, NumberFormatException -> 0x01c0, IllegalArgumentException -> 0x01be }
            r2.setIndex(r5)     // Catch:{ IndexOutOfBoundsException -> 0x01c2, NumberFormatException -> 0x01c0, IllegalArgumentException -> 0x01be }
            java.util.Date r0 = r9.getTime()     // Catch:{ IndexOutOfBoundsException -> 0x01c2, NumberFormatException -> 0x01c0, IllegalArgumentException -> 0x01be }
            return r0
        L_0x01b6:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException     // Catch:{ IndexOutOfBoundsException -> 0x01c2, NumberFormatException -> 0x01c0, IllegalArgumentException -> 0x01be }
            java.lang.String r4 = "No time zone indicator"
            r0.<init>(r4)     // Catch:{ IndexOutOfBoundsException -> 0x01c2, NumberFormatException -> 0x01c0, IllegalArgumentException -> 0x01be }
            throw r0     // Catch:{ IndexOutOfBoundsException -> 0x01c2, NumberFormatException -> 0x01c0, IllegalArgumentException -> 0x01be }
        L_0x01be:
            r0 = move-exception
            goto L_0x01c3
        L_0x01c0:
            r0 = move-exception
            goto L_0x01c3
        L_0x01c2:
            r0 = move-exception
        L_0x01c3:
            if (r1 != 0) goto L_0x01c7
            r1 = 0
            goto L_0x01db
        L_0x01c7:
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            r5 = 34
            r4.append(r5)
            r4.append(r1)
            r4.append(r3)
            java.lang.String r1 = r4.toString()
        L_0x01db:
            java.lang.String r3 = r0.getMessage()
            if (r3 == 0) goto L_0x01e7
            boolean r4 = r3.isEmpty()
            if (r4 == 0) goto L_0x0201
        L_0x01e7:
            java.lang.String r3 = "("
            java.lang.StringBuilder r3 = p009e.p010a.p011a.p012a.C0681a.m330a((java.lang.String) r3)
            java.lang.Class r4 = r0.getClass()
            java.lang.String r4 = r4.getName()
            r3.append(r4)
            java.lang.String r4 = ")"
            r3.append(r4)
            java.lang.String r3 = r3.toString()
        L_0x0201:
            java.text.ParseException r4 = new java.text.ParseException
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            java.lang.String r6 = "Failed to parse date ["
            r5.append(r6)
            r5.append(r1)
            java.lang.String r1 = "]: "
            r5.append(r1)
            r5.append(r3)
            java.lang.String r1 = r5.toString()
            int r2 = r19.getIndex()
            r4.<init>(r1, r2)
            r4.initCause(r0)
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: p041io.realm.internal.android.ISO8601Utils.parse(java.lang.String, java.text.ParsePosition):java.util.Date");
    }

    private static int parseInt(String str, int i, int i2) throws NumberFormatException {
        int i3;
        int i4;
        if (i < 0 || i2 > str.length() || i > i2) {
            throw new NumberFormatException(str);
        }
        if (i < i2) {
            i4 = i + 1;
            int digit = Character.digit(str.charAt(i), 10);
            if (digit >= 0) {
                i3 = -digit;
            } else {
                StringBuilder a = C0681a.m330a("Invalid number: ");
                a.append(str.substring(i, i2));
                throw new NumberFormatException(a.toString());
            }
        } else {
            i3 = 0;
            i4 = i;
        }
        while (i4 < i2) {
            int i5 = i4 + 1;
            int digit2 = Character.digit(str.charAt(i4), 10);
            if (digit2 >= 0) {
                i3 = (i3 * 10) - digit2;
                i4 = i5;
            } else {
                StringBuilder a2 = C0681a.m330a("Invalid number: ");
                a2.append(str.substring(i, i2));
                throw new NumberFormatException(a2.toString());
            }
        }
        return -i3;
    }
}
