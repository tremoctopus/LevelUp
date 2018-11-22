public class Main {

    public static void main(String[] args) throws IllegalAccessException {
        RussianRoulette roulette = new RussianRoulette();
        RandomIntAnnotationProcessor.setField(roulette);
        System.out.println(roulette.getNumber());
        roulette.guess(4);
    }

}
