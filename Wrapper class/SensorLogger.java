public class SensorLogger {
    public static void logTemperature(double temp) {
        Double wrapperTemp = temp; // auto-boxing
        System.out.println("Stored temperature: " + wrapperTemp);
    }

    public static void readTemperature(Double tempObj) {
        double primitiveTemp = tempObj; // auto-unboxing
        System.out.println("Read temperature: " + primitiveTemp);
    }

    public static void main(String[] args) {
        logTemperature(36.6);
        readTemperature(37.2);
    }
}
