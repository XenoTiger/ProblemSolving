package strings;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GroupAnagrams {

    private static List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();

        for (String s : strs) {
            int[] freq = new int[26];
            for (char c : s.toCharArray()) {
                freq[c - 'a']++;
            }

            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < freq.length; i++) {
                sb.append(freq[i]);
                sb.append('#');
            }

            String key = sb.toString();
            if (!map.containsKey(key)) {
                map.put(key, new ArrayList<>());
            }
            map.get(key).add(s);
        }
        return new ArrayList<>(map.values());
    }

    public static void main(String[] args) {
        String[] strs1 = {"eat", "tea", "tan", "ate", "nat", "bat"};
        System.out.println(groupAnagrams(strs1));
        String[] strs2 = {""};
        System.out.println(groupAnagrams(strs2));
        String[] strs3 = {"abcd", "java", "dcba", "ajav", "xyz", "epam", "pame", "aepm"};
        System.out.println(groupAnagrams(strs3));
    }
}
