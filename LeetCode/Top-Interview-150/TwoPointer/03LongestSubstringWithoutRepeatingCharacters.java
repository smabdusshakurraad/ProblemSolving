class Solution {
    public int lengthOfLongestSubstring(String s) {
        int maxLength = 0;
        int left = 0;
        HashSet<Character> window = new HashSet<>();

        for(int right=0; right<s.length(); right++){
            char currentChar = s.charAt(right);

            while(window.contains(currentChar) && left < s.length()){
                window.remove(s.charAt(left));
                left++;
            }

            window.add(currentChar);

            maxLength = Math.max(maxLength, right - left + 1);
        }

        return maxLength;
    }
}