[438. Find all anagrams in a string](https://leetcode.com/problems/find-all-anagrams-in-a-string/)

### Approach -1
Use Sliding window technique

```java
class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        int n = s.length(), m = p.length();
        List<Integer> list = new ArrayList<>();
        
        if(n<m) return list;
        
        int[] freq = new int[26];
        int[] temp = new int[26];
        
        for(int i=0;i<m;i++) {
            freq[p.charAt(i) - 'a']++;
            temp[s.charAt(i) - 'a']++;
        }
        for(int i=m;i<n;i++) {
            if(Arrays.equals(freq,temp)) {
                list.add(i-m);
            }
            temp[s.charAt(i-m) - 'a']--;
            temp[s.charAt(i) - 'a']++;
        }
        if(Arrays.equals(freq,temp)) {
            list.add(n-m);
        }
        return list;
    }
    
}
```