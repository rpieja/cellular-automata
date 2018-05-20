package pl.rpieja.automata;

import processing.core.PApplet;

import java.util.Arrays;
import java.util.Scanner;


public class Automaton extends PApplet {

    private Scanner in = new Scanner(System.in);

    private int rule;
    private int [][] matrix;
    private String binaryRule;


    private final int windowSizeX = 800;
    private final int windowSizeY = 800;
    private final int bgFill = 255/2;

    @Override
    public void setup() {
        size(windowSizeX, windowSizeY);
        background(bgFill);
        smooth();
    }

    @Override
    public void draw() {
        System.out.printf("Choose rule: ");
        rule=in.nextInt();
        matrix=setupMatrix();
        calcMatrixRule(rule);
        fill(0, 0, 0);
        rect(0, 0, windowSizeX, windowSizeY);
        for (int i = 0; i < matrix.length; ++i) {
            for (int j = 0; j < matrix[i].length; ++j) {
                if (matrix[i][j] == 1) {
                    fill(200, 0, 0);
                    rect(j * 10, i * 10, 10, 10);
                }
            }
        }


    }

    private int[][] setupMatrix () {
        int[][] mat = new int[windowSizeX/10][windowSizeY/10];
        for(int [] row : mat)
            Arrays.fill(row, 0);

        if (mat[0].length % 2 == 0) {
            mat[0][mat[0].length / 2 - 1] = 1;
        } else {
            mat[0][mat[0].length / 2] = 1;
        }
        return mat;
    }


    private void calcMatrixRule(int rule) {
        binaryRule = String.format("%8s", Integer.toBinaryString(rule)).replace(" ", "0");
        println(binaryRule);
        for (int i = 1; i < matrix.length; ++i) {
            for (int j = 0; j < matrix[i].length; ++j) {
                if (j == 0) {
                    matrix[i][j] = calcValue(matrix[i - 1][matrix[i - 1].length - 1], matrix[i - 1][j], matrix[i - 1][j + 1]) - 48;
                } else if (j == matrix[i].length - 1) {
                    matrix[i][j] = calcValue(matrix[i - 1][j - 1], matrix[i - 1][j], matrix[i - 1][0]) - 48;
                } else {
                    matrix[i][j] = calcValue(matrix[i - 1][j - 1], matrix[i - 1][j], matrix[i - 1][j + 1]) - 48;
                }
            }
        }
    }

    public char calcValue(int position1, int position2, int position3) {
        if (position1 == 1 && position2 == 1 && position3 == 1) return binaryRule.charAt(0);
        else if (position1 == 1 && position2 == 1) return binaryRule.charAt(1);
        else if (position1 == 1 && position3 == 1) return binaryRule.charAt(2);
        else if (position1 == 1) return binaryRule.charAt(3);
        else if (position2 == 1 && position3 == 1) return binaryRule.charAt(4);
        else if (position2 == 1) return binaryRule.charAt(5);
        else if (position3 == 1) return binaryRule.charAt(6);
        else return binaryRule.charAt(7);
    }

    public static void main(String[] args) {
        PApplet.main("pl.rpieja.automata.Automaton");
    }
}
