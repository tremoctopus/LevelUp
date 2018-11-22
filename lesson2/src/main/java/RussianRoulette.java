public class RussianRoulette {

    @RandomInt(min = 1, max = 6)
    private int number;
    private double withoutAnnotation;

    public void guess(int number) {
        if (number == this.number) {
            System.out.println("You are died...");
        }
    }

    public int getNumber() {
        return number;
    }
}
