/*
 * @lc app=leetcode id=1763 lang=java
 *
 * [1763] Longest Nice Substring
 */

// @lc code=start
class Solution {
    int scLen;
    long[] scBits;
    int longestLen = 0;
    int longestStart = 0;

    public String longestNiceSubstring(String s) {
        // Convert the input string into a long[] array containg a bit mask for each
        // corresponding character. After this, we don't need to process characters
        // until
        // we are ready to return the result, because we will be doing all the
        // processing
        // with the array of bit masks.
        //
        // Because there are only uppercase and lowercase characters, and because of the
        // values of these characters are between 64 and 127, then a single Long can
        // hold
        // bits where each letter will have it's own bit. The bits in the lower 32 bits
        // of the Long will contain the bits for uppercase characters, The bits in the
        // higher 32 bits of the Long will contain bits for lowercase characters.
        //
        // Examples:
        // char bit mask value
        // ---------- ------------------------------------------------------
        // 'A' == 65 65-'@' == 1 --> 1L << 1 == 0x00000000_00000002
        // 'a' == 97 97-'@' == 33 --> 1L << 33 == 0x00000002_00000000
        // 'Y' == 89 89-'@' == 25 --> 1L << 25 == 0x00000000_02000000
        // 'y' == 121 121-'@' == 57 --> 1L << 57 == 0x02000000_00000000
        // 'z' == 122 122-'@' == 58 --> 1L << 26 == 0x04000000_00000000
        //
        // If passed string s is "YazaAay", then OR of the entire string is
        // 0x00000000_02000000 Y
        // 0x00000002_00000000 a
        // 0x04000000_00000000 z
        // 0x00000002_00000000 a
        // 0x00000000_00000002 A
        // 0x00000002_00000000 a
        // OR 0x02000000_00000000 y
        // ------------------------
        // 0x06000002_02000002
        //
        // From the above OR'ed result of 0x06000002_02000002, we then XOR the lower
        // 32 bits with the higher 32 bits as:
        //
        // 0x00000002 lower 32 bits
        // XOR 0x06000002 higher 32 bits
        // ---------------
        // 0x04000000 (Shows that 'Z' or 'z' are unmatched uppercase/lowercase)
        //
        // Copying the above XOR result to both the lower 32 bits and higher 32 bits of
        // a
        // Long will result in a Long value of:
        //
        // 0x04000000_04000000
        //
        // We can then use the above value to scan through the string, which has already
        // been
        // converted to an array of Long bit masks, where each character is represented
        // by it's
        // bit mask. For a character in the string, if that character's bit mask is
        // AND'ed with
        // the above value, and the result of the AND is non-zero, then that character
        // does NOT
        // have matching uppercase and lowercase within the string. If all of the AND's
        // result
        // in a zero value, then the string (or substring) is "nice" and all characters
        // have
        // matching uppercase and lowercase.
        //
        int scLen = s.length();
        scBits = new long[scLen];
        for (int i = 0; i < scLen; i++)
            scBits[i] = 1L << (s.charAt(i) - '@');

        // Scan the entire passed String s. This will recurse as needed.
        checkRange(0, scLen);

        return (longestLen == 0) ? "" : s.substring(longestStart, longestStart + longestLen);
    }

    // To check if a substring contains only letters that have both uppercase and
    // lowercase letters, we will only have to OR together the bit masks for each
    // character in the substring, into a Long which is a composite of all bit masks
    // from the substring. Then we XOR the top 32 bits of this composite value, with
    // the bottom 32 bits of this composite value. If this XOR'ed result is zero,
    // then the substring contains only characters with matching uppercase and
    // lowercase.
    // if the XOR'ed result is non-zero, then the XOR'ed result contains the bit
    // mask of
    // all unmatched characters. We can then make another pass through this
    // substring
    // while using the XOR'ed result to locate unmatched characters. We then recurse
    // on
    // the sub-substrings between the unmatched characters.
    //
    private void checkRange(int startIdx, int endIdx) {
        // Get a bitmask for all characters in this section of the string that DO NOT
        // have
        // matching uppercase and lowercase characters.
        long unmatchedChars = 0;
        for (int i = startIdx; i < endIdx; i++)
            unmatchedChars |= scBits[i];
        unmatchedChars = (unmatchedChars ^ (unmatchedChars >>> 32)) & 0xFFFFFFFFL;
        unmatchedChars |= (unmatchedChars << 32);

        // If ALL characters in this section of the string have both uppercase and
        // lowercase,
        // then this is the new longest "nice" substring.
        if (unmatchedChars == 0) {
            longestLen = endIdx - startIdx;
            longestStart = startIdx;
        }

        // Else break the string into substrings between unmatched uppercase/lowercase
        // characters,
        // and recurse to check these substrings.
        else {
            int substrStart = startIdx;
            for (int i = startIdx; i < endIdx; i++) {
                if ((scBits[i] & unmatchedChars) != 0) {
                    if (i - substrStart > longestLen)
                        checkRange(substrStart, i);
                    substrStart = i + 1;
                }
            }
            if (endIdx - substrStart > longestLen)
                checkRange(substrStart, endIdx);
        }
    }
}
// @lc code=end

