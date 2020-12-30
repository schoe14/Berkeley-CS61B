public class OffByN implements CharacterComparator {
    private int number;

    public OffByN(int n) {
        this.number = n;
    }

    @Override
    public boolean equalChars(char x, char y) {
        return Math.abs(x - y) == this.number;
    }
}
