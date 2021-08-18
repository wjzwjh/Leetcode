class Solution {
    public int[] maxSlidingWindow(int[] arr, int k) {
        int n = arr.length, j = 0;
        int[] ans = new int[n - k + 1];
        TreeMap<Integer, Integer> bst = new TreeMap<>();
        for (int i = 0; i < n; i++) {
            bst.put(arr[i], bst.getOrDefault(arr[i], 0) + 1);
            if (i + 1 >= k) {
                ans[j++] = bst.lastKey(); // return max element in BST
                removeElement(bst, arr[i+1-k]);
            }
        }
        return ans;
    }
    void removeElement(TreeMap<Integer, Integer> bst, int x) {
        bst.put(x, bst.getOrDefault(x, 0) - 1);
        if (bst.get(x) == 0) bst.remove(x);
    }
}