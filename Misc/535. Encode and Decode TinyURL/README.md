[535. Encode and Decode TinyURL](https://leetcode.com/problems/encode-and-decode-tinyurl/)

[Leedcode Explanation](https://leetcode.com/problems/encode-and-decode-tinyurl/discuss/1973804/EASYYYYYY-explaination)

### Approach 

- Time Complexity:
1. Encode: O(N)
2. Decode: O(1)
- Space Complexity: O(1)

```java
public class Codec {
    
    private final Map<String, String> map = new HashMap<>();
    private final StringBuilder builder = new StringBuilder();
    
    // Encodes a URL to a shortened URL.
    public String encode(String longUrl) {
        char ch = (char) ((int) (Math.random() * 126) + 32);
        builder.append(ch);
        while(map.containsKey(builder.toString())) {
            ch = (char) ((int) (Math.random() * 126) + 32);
            builder.append(ch);
        }
        String shortUrl = builder.toString();
        map.put(shortUrl, longUrl);
        builder.setLength(0);
        return shortUrl;
    }

    // Decodes a shortened URL to its original URL.
    public String decode(String shortUrl) {
        return map.get(shortUrl);
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.decode(codec.encode(url));
```