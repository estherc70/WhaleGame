public class RoundingHelper {

    public RoundingHelper() {
    }

    public int RoundNumber(double input) {
        int roundedNumber;
        roundedNumber = (int) Math.rint(input);
        return roundedNumber;
    }
}
