import java.math.BigDecimal;

public class RussianRoulette {

    @RandomInt(min = 1, max = 6)
    private int number;

    private double withoutAnnotation;

    @RandomInt(min = 1, max = 6)
    private float floatField;

    @RandomInt(min = 1, max = 6)
    private String stringField;

    @RandomInt(min = 1, max = 6)
    private BigDecimal bigDecimalField;

    @RandomInt(min = 1, max = 6)
    private Integer integerField;

    public void guess(int number) {
        if (number == this.number) {
            System.out.println("You are died...");
        }else{
            System.out.println("You're alive!");
        }
    }

    public int getNumber() {
        return number;
    }

    public double getWithoutAnnotation() {
        return withoutAnnotation;
    }

    public float getFloatField() {
        return floatField;
    }

    public String getStringField() {
        return stringField;
    }

    public BigDecimal getBigDecimalField() {
        return bigDecimalField;
    }

    public Integer getIntegerField() {
        return integerField;
    }
}
