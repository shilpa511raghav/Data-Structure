import java.util.HashSet;

public class ValidSudoku {
    public static void main(String[] args) {
        String[][] board = {
                {"5","3",".",".","7",".",".",".","."},
                {"6",".",".","1","9","5",".",".","."},
                {".","9","8",".",".",".",".","6","."},
                {"8",".",".",".","6",".",".",".","3"},
                {"4",".",".","8",".","3",".",".","1"},
                {"7",".",".",".","2",".",".",".","6"},
                {".","6",".",".",".",".","2","8","."},
                {".",".",".","4","1","9",".",".","5"},
                {".",".",".",".","8",".",".","7","9"}
        };

        boolean b = validSudoku(board);
        System.out.println(b);

    }

    public static boolean validSudoku(String[][] board) {
        HashSet<String> seenSet = new HashSet<>();
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                String each = board[i][j];
                if (each != ".") {
                    if (!seenSet.add(each + "in row" + i) ||
                            !seenSet.add(each + "in column" + j) ||
                            !seenSet.add(each + "in block " + i / 3 + "-" +j/3)) {
                        return false;
                    }
                }

            }
        }
        return true;
    }
}