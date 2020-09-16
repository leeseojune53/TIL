public class Theater {
    private Seat[][] seats;

    private int rowCount, colCount;

    public Theater(int rowCount, int colCount) {
        if (rowCount > 26) {
            rowCount = 26; // number of alphabets
        }
        seats = new Seat[rowCount][colCount];
        for (int i = 0; i < rowCount; i++) {
            for (int j = 0; j < colCount; j++) {
                seats[i][j] = new Seat();
            }
        }

        this.rowCount = rowCount;
        this.colCount = colCount;
    }

    public boolean reserve(String name, char rowChar, int col, int numSeat) {
        int row = getRowIndex(rowChar);
        col--;
        for(int i=col;i<col+numSeat;i++){
            if(!(i<9 || (i<9&&seats[row][i].isOccupied()))){
                return false;
            }
        }
        for(int i=col;i<col+numSeat;i++){
            seats[row][i].reserve(name);
        }
        return true;
    }

    public int cancel(String name) {
        int count = 0;
        for(int r = 0; r<rowCount;r++){
            for(int c = 0; c<colCount; c++){
                if(seats[r][c].isOccupied()&&seats[r][c].match(name)){
                    count++;
                    seats[r][c].cancel();
                }
            }
        }
        return count;
    }

    public int cancel(char rowChar, int col, int numSeat) {
        int row = getRowIndex(rowChar);
        col--;
        int count = 0;

        for(int c = col; c<col+numSeat;c++){
            if(seats[row][c].isOccupied()){
                count++;
                seats[row][c].cancel();
            }
        }
        return count;
    }


    public int getNumberOfReservedSeat() {
        int count = 0;
        for(int r = 0; r < rowCount;r++){
            for(int c = 0; c<colCount;c++){
                if(seats[r][c].isOccupied()){
                    count++;
                }
            }
        }
        return count;
    }

    public void printSeatMatrix() {
        System.out.print("  ");
        for (int i = 1; i <= 9; i++) {
            System.out.print("  " + i);
        }
        System.out.println();

        for (int i = 0; i < rowCount; i++) {
            System.out.print((char) ('A' + i) + ": ");
            for (int j = 0; j < colCount; j++) {
                Seat s = seats[i][j];
                if (s.isOccupied()) {
                    System.out.print("[O]");
                } else {
                    System.out.print("[ ]");
                }
            }
            System.out.println();
        }
    }

    private int getRowIndex(char uppercaseChar) {
        return uppercaseChar - 'A';
    }
}