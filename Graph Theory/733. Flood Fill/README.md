[733. Flood Fill](https://leetcode.com/problems/flood-fill/)

An image is represented by an m x n integer grid image where image[i][j] represents the pixel value of the image.

You are also given three integers sr, sc, and newColor. You should perform a flood fill on the image starting from the pixel image[sr][sc].

To perform a flood fill, consider the starting pixel, plus any pixels connected 4-directionally to the starting pixel of the same color as the starting pixel, plus any pixels connected 4-directionally to those pixels (also with the same color), and so on. Replace the color of all of the aforementioned pixels with newColor.

Return the modified image after performing the flood fill.

![Example](https://assets.leetcode.com/uploads/2021/06/01/flood1-grid.jpg)


### Approach - 1 (Use DFS)

1. Check whether the new color and current color (color at given index) are same or not. If they are same then no need to apply DFS.
2. Apply DFS on 4 directions.

- Time Complexity: O(N)
- Space Complexity: O(N) (Auxiliary space)

```java
class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        int color = image[sr][sc];
        if(color != newColor) {
            paintImage(image, color, sr, sc, newColor);
        }
        return image;
    }
    
    private void paintImage(int[][] image, int color, int sr, int sc, int newColor) {
        
        if(outOfBounds(image, sr,sc)) return;
        
        if(image[sr][sc] == color) {
            image[sr][sc] = newColor;
            
            paintImage(image, color, sr+1, sc, newColor); //down
            paintImage(image, color, sr-1, sc, newColor); //up
            paintImage(image, color, sr, sc+1, newColor); //right
            paintImage(image, color, sr, sc-1, newColor); //left
        }
    }
    
    private boolean outOfBounds(int[][] image, int r, int c) {
        int len = image.length, width = image[0].length;
        
        if(r<0 || r>= len || c<0 || c>= width) return true;
        return false;        
    }
    
}
```