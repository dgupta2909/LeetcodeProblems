class Solution {
        public boolean isMatch(String str1,  String str2) {
        return isMatch(str1, str1.length() - 1, str2, str2.length() - 1, new int[str1.length()][str2.length()]);
    }


    public boolean isMatch(String str1, int index1, String str2, int index2, int[][] cache) {
                if (index1 < 0) {
            while (index2 >= 0) {
                if (str2.charAt(index2) == '*') {
                    index2 -= 2;
                } else {
                    return false;
                }
            }
            return true;
        }
        if (index2 < 0) {
            return false;
        }
        if (cache[index1][index2] != 0) {
            return cache[index1][index2] == 1;
        }
        boolean match = false;
        if (str2.charAt(index2) == '*') {
            match = match || isMatch(str1, index1, str2, index2 -2, cache); // 匹配0次
            if (index2 - 1 >= 0 && (str2.charAt(index2 - 1) == '.' || str2.charAt(index2 - 1) == str1.charAt(index1))) {
                match = match || isMatch(str1, index1 - 1, str2, index2 -2, cache); // 匹配1次
                match = match || isMatch(str1, index1 - 1, str2, index2, cache); // 匹配>=1次
            }
        }
        if(str2.charAt(index2) == '.' || str2.charAt(index2) == str1.charAt(index1)) {
            match = match || isMatch(str1, index1 - 1, str2, index2 - 1, cache);
        }
        cache[index1][index2] = match ? 1 : -1;
        return match;
    }


}