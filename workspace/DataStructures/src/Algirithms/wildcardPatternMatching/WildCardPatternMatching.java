package Algirithms.wildcardPatternMatching;

/**
 * 
 *		Given a text and a wildcard pattern, implement wildcard pattern
 *      matching algorithm that finds if wildcard pattern is matched with
 *      text. The matching should cover the entire text (not partial text).<br>
 *      
 *      The wildcard pattern can include the characters ‘?’ and ‘*’ ‘?’ –
 *      matches any single character ‘*’ – Matches any sequence of characters
 *      (including the empty sequence)<br>
 * 
 *  <pre>For example, 
 *      Text = "baaabab",
 *      Pattern = “*****ba*****ab", output : true
 *      Pattern = "baaa?ab", output : true
 *      Pattern = "ba*a?", output : true
 *      Pattern = "a*ab", output : false</pre>
 *
 */
public class WildCardPatternMatching {
	private static boolean isMatchingString(String sourceStr, String pattern) {
		boolean isMatch = false;
		if (sourceStr != null && sourceStr.length() != 0 && pattern != null && pattern.length() != 0) {
			int sourceStrIdx = 0, patternIdx = 0;
			boolean flag = true;
			while (sourceStrIdx < sourceStr.length()) {
				if (pattern.charAt(patternIdx) == '*') {
					while (pattern.charAt(patternIdx) == '*' || pattern.charAt(patternIdx) == '?'
							&& patternIdx < pattern.length()) {
						patternIdx++;
					}
					char patternToken = pattern.charAt(patternIdx);
					while (sourceStr.charAt(sourceStrIdx) != patternToken && sourceStrIdx < sourceStr.length()) {
						sourceStrIdx++;
					}
				} else if (pattern.charAt(patternIdx) == '?') {
					patternIdx++;
					sourceStrIdx++;
				} else {
					if (sourceStr.charAt(sourceStrIdx) != pattern.charAt(patternIdx)) {
						flag = false;
						break;
					}
					sourceStrIdx++;
					patternIdx++;
				}
			}
			isMatch = flag;
		}
		return isMatch;
	}
	
	public static void main(String...strings) {
		System.out.println(match("bacabab", "*cb"));
	}
	
    public static boolean match(String string, String pattern) {
        if(string == null || pattern == null) {
            return false;
        }
        int sLength = string.length();
        int pLength = pattern.length();
        if(sLength == 0 || pLength == 0) {
            return false;
        }
       
        int sIndex = 0, pIndex = 0, sCount = -1, pCount = -1;
        while(sIndex < sLength) {
            if(sIndex == sLength || pIndex == pLength) {
                break;
            } else if(string.charAt(sIndex) == pattern.charAt(pIndex) || pattern.charAt(pIndex) == '?') {
                sIndex++; pIndex++;
            } else if(pattern.charAt(pIndex) == '*') {
                sCount = sIndex;
                pCount = pIndex;
                pIndex++;
            } else if(pCount != -1) {
                pIndex = pCount + 1;
                sIndex = sCount + 1;
                sCount++;
            } else {
                return false;
            }
        }
        while (pIndex < pLength && pattern.charAt(pIndex) == '*') {
            pIndex++;
        }
       
        return pIndex == pLength;
    }
}
