class Solution {
    public String longestCommonPrefix(String[] strs) {
        if(strs.length == 0) return "";
        String ans = strs[0];
        for(int i = 0; i < strs.length; i++) {
            int j = 0;
            for(;j < ans.length() && j < strs[i].length(); j++) {
                if(ans.charAt(j) != strs[i].charAt(j)){
                    break;
                }
            }

            ans = strs[i].substring(0, j);
            if(ans.equals(""))
                return ans;
        }
        return ans;
    }
}
