public class ZigZagConversion {
    /**
     * The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this: (you may want to display this pattern in a fixed font for better legibility)
     *
     * P   A   H   N
     * A P L S I I G
     * Y   I   R
     * And then read line by line: "PAHNAPLSIIGYIR"
     *
     * Write the code that will take a string and make this conversion given a number of rows:
     *
     * string convert(string s, int numRows);
     */
    private boolean up = true;

    public String attempt1(String s, int numRows) {
        if (numRows == 1) {
            return s;
        }
        // initialize StringBuilders
        StringBuilder[] newRows = new StringBuilder[numRows];
        for (int i = 0; i < numRows; i++)
            newRows[i] = new StringBuilder();

        // add all characters to proper SBs
        int counter = 0;
        for (int i = 0; i < s.length(); i++) {
            newRows[counter].append(s.charAt(i));
            counter = increment(counter, numRows - 1);
        }

        // construct the return value
        StringBuilder rval = new StringBuilder();
        for (int i = 0; i < numRows; i++)
            rval.append(newRows[i].toString());
        return rval.toString();
    }

    public int increment(int i, int max) {
        if (i == max)
            up = false;
        else if (i == 0)
            up = true;
        if (up)
            i++;
        else
            i--;
        return i;
    }

    public static String attempt2(String s, int numRows) {
        if (numRows == 1 || numRows >= s.length()) {
            return s;
        }
        // initialize StringBuilders
        StringBuilder[] newRows = new StringBuilder[numRows];
        for (int i = 0; i < numRows; i++)
            newRows[i] = new StringBuilder();

        // add all characters to proper SBs
        int counter = 0;
        boolean direction = false;
        for (int i = 0; i < s.length(); i++) {
            newRows[counter].append(s.charAt(i));
            if (counter==0 || counter==numRows-1)
                direction = !direction;
            counter += direction ? 1 : -1;
        }

        // construct the return value
        StringBuilder rval = new StringBuilder();
        for (int i = 0; i < numRows; i++)
            rval.append(newRows[i].toString());
        return rval.toString();
    }
}
