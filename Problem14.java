import java.math.BigInteger; 

class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<BigInteger, List<String>> map = new HashMap<>();
        for (String str : strs) {
            BigInteger value = primeValue(str);
            if(!map.containsKey(value)) {
                map.put(value, new ArrayList<>());
            }
            map.get(value).add(str);
        }
        return new ArrayList<>(map.values());
    }

    private static BigInteger primeValue(String str) {
        int[] primeNumbers = new int[]{2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97, 101,103};
        BigInteger result = BigInteger.ONE; 
        for(int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            result = result.multiply(BigInteger.valueOf(primeNumbers[ch-'a']));
        }
        return result;
    }
}