class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        if (strs == null || strs.length == 0) return new ArrayList<>();
        Map<String, List<String>> map = new HashMap<>();
        
        for (String s : strs) {
            // Array to store the frequency of 26 lowercase letters
            char[] count = new char[26]; 
            
            for (char c : s.toCharArray()) {
                count[c - 'a']++; 
            }
            
            // Convert the frequency array into a String to use as a hash map key
            String key = new String(count);
            
            map.putIfAbsent(key, new ArrayList<>());
            map.get(key).add(s);
        }
        
        return new ArrayList<>(map.values());
    }
}