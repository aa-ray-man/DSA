import java.util.HashMap;

class Solution {
    public boolean isAnagram(String s, String t) {

        // Step 1: Length check
        if (s.length() != t.length()) return false;

        // Step 2: Frequency map
        HashMap<Character, Integer> map = new HashMap<>();

        // Step 3: Count characters in s
        for (char c : s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        // Step 4: Reduce count using t
        for (char c : t.toCharArray()) {

            // Character not found
            if (!map.containsKey(c)) return false;

            map.put(c, map.get(c) - 1);

            // Remove when count becomes zero
            if (map.get(c) == 0) {
                map.remove(c);
            }
        }

        // Step 5: Map should be empty
        return map.isEmpty();
    }
}
