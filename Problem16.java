class Solution {
    public boolean wordPattern(String pattern, String s) {
        String[] stringArr = s.split(" ");
        int n = stringArr.length;
        int k = pattern.length();

        if (n != k) return false;

        HashMap<Character, String> pMap = new HashMap<>();
        HashMap<String, Character> sMap = new HashMap<>();

        for (int i = 0; i < n; i++) {
            char a = pattern.charAt(i);

            if (!pMap.containsKey(a)) {
                pMap.put(a, stringArr[i]);
            } else {
                if (!pMap.get(a).equals(stringArr[i])) return false;
            }

            if (!sMap.containsKey(stringArr[i])) {
                sMap.put(stringArr[i], a);
            } else {
                if (!sMap.get(stringArr[i]).equals(a)) return false;
            }
        }

        return true;
    }
}