package com.canseverayberk.leetcode.easy.array;

/*
https://leetcode.com/problems/find-winner-on-a-tic-tac-toe-game/
 */
public class TicTacToe {

    public static void main(String[] args) {
        int[][] moves = new int[][]{{0, 0}, {2, 0}, {1, 1}, {2, 1}, {2, 2}};
        String tictactoe = tictactoe(moves);
    }

    public static String tictactoe(int[][] moves) {
        String[][] board = new String[3][3];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                board[i][j] = "";
            }
        }
        for (int i = 0; i < moves.length; i++) {
            int[] move = moves[i];
            if (i % 2 == 0) {
                board[move[0]][move[1]] = "X";
            } else {
                board[move[0]][move[1]] = "O";
            }
        }

        return check(board, moves);

    }

    private static String check(String[][] board, int[][] moves) {
        for (int i = 0; i < 3; i++) {
            String row = "";
            String column = "";
            for (int j = 0; j < 3; j++) {
                row = row.concat(board[i][j]);
                column = column.concat(board[j][i]);
                if (row.equals("XXX") || column.equals("XXX"))
                    return "A";
                else if (row.equals("OOO") || column.equals("OOO"))
                    return "B";
            }
        }
        String diagonal1 = board[0][0].concat(board[1][1]).concat(board[2][2]);
        String diagonal2 = board[0][2].concat(board[1][1]).concat(board[2][0]);
        if (diagonal1.equals("XXX") || diagonal2.equals("XXX"))
            return "A";
        else if (diagonal1.equals("OOO") || diagonal2.equals("OOO"))
            return "B";
        return moves.length == 9 ? "Draw" : "Pending";
    }

}
