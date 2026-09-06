class Solution {
    public boolean isValidSudoku(char[][] board) {
        final int rowLen = board.length;
        final int colLen = board[0].length;
        List<Set<Character>> rowNums = new ArrayList<>();
        List<Set<Character>> colNums = new ArrayList<>();
        List<Set<Character>> boxNums = new ArrayList<>();

        for (int i = 0; i < rowLen; i++) {
            rowNums.add(new HashSet<Character>());
            colNums.add(new HashSet<Character>());
            boxNums.add(new HashSet<Character>());
        }

        for (int ri = 0; ri < rowLen; ri++) {
            for (int ci = 0; ci < colLen; ci++) {
                char ch = board[ri][ci];
                if ('1' <= ch && ch <= '9') {
                    if (!rowNums.get(ri).add(ch)) {
                        return false;
                    }

                    if (!colNums.get(ci).add(ch)) {
                        return false;
                    }

                    int boxIndex = (ri / 3 * 3) + (ci / 3);
                    if (!boxNums.get(boxIndex).add(ch)) {
                        return false;
                    }
                }
            }
        }

        return true;
    }
}
