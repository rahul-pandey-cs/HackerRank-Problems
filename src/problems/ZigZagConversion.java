package problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ZigZagConversion {

    public String convert(String s, int numRows) {
        int s_len = s.length(), count =0;
        int numColumns =  calRows(s_len , numRows);
        System.out.println("Rows: " + numRows + " Column: "+ numColumns);
        char[][] finalOutput   = new char[numRows][numColumns];
        List diagonalRow = new ArrayList<> ();
        for(int i=1; i < numColumns-1; i+=(numRows)-2+1){
            int k = 0;
            while(k < numRows-2) {
                diagonalRow.add(k+i);
                k++;
            }
        }

        System.out.println("Diagonal Row: " + diagonalRow + "Length: "+ s_len + ", Rows: " + numRows + " Column: "+ numColumns);
        boolean flag=true;
        for(int i=0; i< numRows ; i++){
            for(int j=0; ( j< numColumns ) && ( count < s_len ); j++){
                if(diagonalRow.contains(j) && flag) {
                    int k = numRows - 2;
                    while(k!=0 && count < s_len) {
                        finalOutput[k--][j++] = s.charAt(count++);
                        System.out.println("Added diagonal k, j " + (k+1) + "," + (j-1));
                    }
                }
                else {
                    finalOutput[i][j] = s.charAt(count++);
                    System.out.println("Added i, j " + (i) + "," + (j));
                }
            }
            flag=false;
        }

        for (char[] row : finalOutput) {
            System.out.println(Arrays.toString(row));
        }

        return print2DArray(finalOutput,numRows,numColumns );
    }

    public String print2DArray(char[][] input, int row, int column){
        String zigZagString = new String();
        for(int i = 0; i < row ; i++){
            for(int j = 0; j < column; j++){
                zigZagString += input[i][j];
            }
        }
        return zigZagString;
    }

    public int calRows(int s_len , int numRows) {
        int countLen = s_len;
        int col = 0;
        while(countLen>0){
            col++;
            System.out.println(" Column: "+ col + "countLen: " + countLen);
            if(countLen>=numRows)
                countLen-=numRows;
            else{
                countLen=0;
                return col;
            }
            int diagonalCount = numRows-2;
            while(diagonalCount!=0){
                col++;
                System.out.println(" ColumnD: "+ col + "countLen: " + countLen);
                countLen--;
                diagonalCount--;
            }
        }
        return col;
    }
}