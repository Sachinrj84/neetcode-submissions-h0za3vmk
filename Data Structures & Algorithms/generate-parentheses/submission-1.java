class Solution {
    List<String> res;

    public List<String> generateParenthesis(int n) {
        res = new ArrayList<>();
        backtrack("", 0, 0, n);
        return res;
    }

    public void backtrack(String s, int openN, int closedN, int n) {
        if (openN == closedN && closedN == n) {
            res.add(s);
            return;
        }

        if (openN < n) {
            backtrack(s + "(", openN + 1, closedN, n);
        }

        if (closedN < openN) {
            backtrack(s + ")", openN, closedN + 1, n);
        }
    }
}