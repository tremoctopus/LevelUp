import java.io.IOException;
import java.util.logging.LogManager;

public class Main {

    public static void main(String[] args) throws IllegalAccessException, IOException {

        LogManager.getLogManager().readConfiguration(RandomIntAnnotationProcessor.class.getResourceAsStream("logging.properties"));

        RussianRoulette roulette = new RussianRoulette();
        RandomIntAnnotationProcessor.setField(roulette);
        System.out.println(roulette.getNumber());
        roulette.guess(4);

    }

}
