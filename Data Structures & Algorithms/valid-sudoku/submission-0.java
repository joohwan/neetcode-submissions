class Solution {
    public boolean isValidSudoku(char[][] board) {
        final int rowLen = board.length;
        final int colLen = board[0].length;
        Set<Character> nums = new HashSet<>();

        // row
        for (int ri = 0; ri < rowLen; ri++) {
            for (int ci = 0; ci < colLen; ci++) {
                char c = board[ri][ci];
                if ('1' <= c && c <= '9') {
                    if (!nums.add(c)) {
                        return false;
                    }
                }
            }
            nums.clear();
        }
        
        // column
        for (int ci = 0; ci < colLen; ci++) {
            for (int ri = 0; ri < rowLen; ri++) {
                char c = board[ri][ci];
                if ('1' <= c && c <= '9') {
                    if (!nums.add(c)) {
                        return false;
                    }
                }
            }
            nums.clear();
        }

        // sub squares
        for (int rowStart = 0; rowStart <= 6; rowStart += 3) {
            for (int colStart = 0; colStart <= 6; colStart += 3) {
                for (int ri = rowStart; ri < rowStart+3; ri++) {
                    for (int ci = colStart; ci < colStart+3; ci++) {
                        char c = board[ri][ci];
                        if ('1' <= c && c <= '9') {
                            if (!nums.add(c)) {
                                return false;
                            }
                        }
                    }
                }
                nums.clear();
            }
        }

        return true;
    }
}
