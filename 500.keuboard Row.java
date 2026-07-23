import java.util.*;

class Solution {
    public String[] findWords(String[] words) {
        Set<Character> row1 = new HashSet<>(Arrays.asList(
                'q','w','e','r','t','y','u','i','o','p'));
        Set<Character> row2 = new HashSet<>(Arrays.asList(
                'a','s','d','f','g','h','j','k','l'));
        Set<Character> row3 = new HashSet<>(Arrays.asList(
                'z','x','c','v','b','n','m'));

        List<String> ans = new ArrayList<>();

        for (String word : words) {
            String s = word.toLowerCase();

            Set<Character> row;
            if (row1.contains(s.charAt(0))) {
                row = row1;
            } else if (row2.contains(s.charAt(0))) {
                row = row2;
            } else {
                row = row3;
            }

            boolean valid = true;
            for (char c : s.toCharArray()) {
                if (!row.contains(c)) {
                    valid = false;
                    break;
                }
            }

            if (valid) {
                ans.add(word);
            }
        }

        return ans.toArray(new String[0]);
    }
}
