public class ThirdDB {
    private int firstRow;
    private String secondRow;

    public int getFirstRow() {
        return firstRow;
    }

    public void setFirstRow(int firstRow) {
        this.firstRow = firstRow;
    }

    public String getSecondRow() {
        return secondRow;
    }

    public void setSecondRow(String secondRow) {
        this.secondRow = secondRow;
    }

    @Override
    public String toString() {
        return "ThirdDB{" +
                "int=" + firstRow +
                ", string='" + secondRow + '\'' +
                '}';
    }
}
