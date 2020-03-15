public class Mark {
    private double mark;
    private boolean adjusted = false;

    public Mark(double mark) {
        if (mark >= 5.0){
            this.mark = mark;
            adjusted = true;
        } else {
            this.mark = mark;
        }
    }

    public Mark(double mark, boolean adjusted) {
        this.mark = mark;
        this.adjusted = adjusted;
    }

    public double getMark() {
        return mark;
    }

    public boolean isAdjusted() {
        return adjusted;
    }

    public void adjust() {
        adjusted = true;
    }

    @Override
    public String toString() {
        return String.valueOf(mark) + " " + isAdjusted();
    }
}
