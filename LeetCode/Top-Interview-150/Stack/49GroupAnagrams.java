class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();

        for(String s : strs){
            int[] chars = new int[26];
            for(char c : s.toCharArray()){
                chars[c - 'a']++;
            }

            StringBuilder sb = new StringBuilder();
            for(int i : chars){
                sb.append("#").append(i);
            }

            String key = sb.toString();
            if(!map.containsKey(key)){
                map.put(key, new ArrayList<>());
            }

            map.get(key).add(s);
        }

        return new ArrayList<>(map.values());
    }
}