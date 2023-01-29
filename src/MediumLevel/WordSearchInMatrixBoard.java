package MediumLevel;

public class WordSearchInMatrixBoard {
    public static void main(String[] args) {
        //wordSearch(new char[][]{{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}},"ABCCED" );
        wordSearch(new char[][]{{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}},"SEE" );
    }


    //two loops : one for row and one for column for traversing in a 2D array and check if first character of the word is matching with board element means word present
    // if first character of word matched then also do recursive calls along with it to find the other characters of that word present in matrix or not .
    public static boolean wordSearch(char[][] board, String word) {
        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board[0].length; col++) {
                if (word.charAt(0) == board[row][col] && wordExists(board, row, col, word, 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    //Recursive calls: do four calls in all direction of a character as next character can be present in any direction
    // Base cases or edge cases to break a single call : should not be out of bounds in all direction, if find all words and if character at each position of a word matches or not
    // if everything matches and not out of bounds and next character of a word found then copy current character of a word in temporary variable and
    // then replace current character by * to  avoid visiting the character again while moving in all direction from a character
    // if no next character found then while backtracking, copy original character from temp to same place in board

    public static boolean wordExists(char[][] board, int i, int j, String word, int pos) {
        if (pos == word.length()) return true; // if we reach end of the word then return true
        if (i < 0 || j < 0 || i >= board.length || j >= board[0].length) return false; // boundary condition , should not be out of boundary
        if (word.charAt(pos) != board[i][j]) return false; // for current position character from a word
        char temp = board[i][j];
        board[i][j] = '*';
        if (wordExists(board, i + 1, j, word, pos + 1) ||
                wordExists(board, i - 1, j, word, pos + 1) ||
                wordExists(board, i, j + 1, word, pos + 1) ||
                wordExists(board, i, j - 1, word, pos + 1)) {
            return true;
        }
        //
        board[i][j] = temp;// backtrack
        return false;
    }
}

