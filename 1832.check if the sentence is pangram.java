class Solution {
    public boolean checkIfPangram(String sentence) {
        boolean[] seen = new boolean[26];
        int count = 0;

        for (char c : sentence.toCharArray()) {
            if (!seen[c - 'a']) {
                seen[c - 'a'] = true;
                count++;

                if (count == 26) {
                    return true;
                }
            }
        }

        return false;
    }
}
