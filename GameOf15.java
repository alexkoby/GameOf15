/**
 * Game of 15 Compatible with dimensions less than 11 and greater than 1
 * 
 * @author Alexander Koby
 * @version 15.7.2017
 *
 */
public class GameOf15 {

    Integer[][] board;
    int size;
    int emptyRowNum;
    int emptyColNum;

    /**
     * Constructs the game of 15
     * 
     * @param size
     *            is the dimensions of the board
     */
    public GameOf15(int size) {
        if (size > 1) {
            this.size = size;
            board = new Integer[size][size];
            setup();
        } 
        else {
            System.out.println("Invalid dimensions");
        }
    }

    /**
     * Fills up the array in starting position with numbers from n^2-1 to 0
     */
    public void setup() {
        int squares = size * size - 1; // how many non-empty squares there will
                                       // be
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                board[i][j] = new Integer(squares--);
            }
        }
        emptyRowNum = size - 1;
        emptyColNum = size - 1;
    }

    /**
     * Swaps x with the zero if its legal
     * 
     * @param x
     *            is the number you're hoping to swap with '0'
     * @return returns whether or not the swap is legal
     */
    public boolean swap(Integer x) {
        if (getNum(emptyRowNum + 1, emptyColNum) == x) {
            System.out.println("1");
            board[emptyRowNum][emptyColNum] = x;
            board[emptyRowNum + 1][emptyColNum] = 0;
            emptyRowNum++;
            return true;
        } 
        else if (getNum(emptyRowNum - 1, emptyColNum) == x) {
            System.out.println("2");
            board[emptyRowNum][emptyColNum] = x;
            board[emptyRowNum - 1][emptyColNum] = 0;
            emptyRowNum--;
            return true;
        } 
        else if (getNum(emptyRowNum, emptyColNum + 1) == x) {
            System.out.println("3");
            board[emptyRowNum][emptyColNum] = x;
            board[emptyRowNum][emptyColNum + 1] = 0;
            emptyColNum++;
            return true;
        } 
        else if (getNum(emptyRowNum, emptyColNum - 1) == x) {
            System.out.println("4");
            board[emptyRowNum][emptyColNum] = x;
            board[emptyRowNum][emptyColNum - 1] = 0;
            emptyColNum--;
            return true;
        } 
        else {
            return false;
        }
    }

    /**
     * 
     * @param row
     *            is the row you want the number from
     * @param col
     *            is the column you want the number from
     * @return return 0 if the spot doesn't exist, else it return the number in
     *         that spot
     */
    public int getNum(int row, int col) {
        if (row < 0 || col < 0) {
            return new Integer(0);
        } 
        else if (row >= size || col >= size) {
            return new Integer(0);
        } 
        else {
            return board[row][col];
        }
    }

    /**
     * displays the current game board adds spaces to single digit numbers if
     * some numbers have >1 digits
     */
    public void displayBoard() {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (size > 3 && size < 11) {
                    if (board[i][j] < 10) {
                        System.out.print("| " + board[i][j]);
                    } 
                    else {
                        System.out.print("|" + board[i][j]);
                    }
                }
            }
            System.out.println("|");
        }
    }

    /**
     * Determines whether the user is in winning position and the game is won or
     * not
     * 
     * @return true if gamae is won, false if not in winning position
     */
    public boolean win() {
        for (int i = 0; i < size - 1; i++) {
            for (int j = 0; j < size; j++) {
                if (inFinalPosition(i, j) == false) {
                    return false;
                }
            }
        }
        for (int j = 0; j < size - 1; j++) {
            if (inFinalPosition(size - 1, j)) {
                return false;
            }
        }
        return true;
    }

    public boolean inFinalPosition(int row, int col) {
        return size * row + col + 1 == getNum(row, col);
    }
}
