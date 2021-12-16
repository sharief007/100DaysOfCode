# NOTES
## Move all negative elements to one side of the array

### Clock wise cyclic rotation by 1
``` java
static void rotate()
{
    int i = 0, j = arr.length - 1;
    while(i != j)
    {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
        i++;
    }
}
```
Time Complexity: O(n)
Space Complexity: O(1)

### Another Approach
1. store last element in temp variable.
2. shift all elements to right by 1 step.
3. assign temp to first element.

Time Complexity: O(n+m)
Space Complexity: O(1)


### Rotate Array by K steps (Juggling Algorithm)
![Youtube](https://www.youtube.com/watch?v=utE_1ppU5DY)

