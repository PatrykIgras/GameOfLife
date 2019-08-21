package enums;

public enum CellStatus {
    C0("-"),
    C1("#");


    private String cellStat;
    CellStatus(String cellStat) {
        this.cellStat = cellStat;
    }

    public String getCellStat() {
        return cellStat;
    }
}
