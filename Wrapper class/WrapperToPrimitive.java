public class WrapperToPrimitive {
    public static void main(String[] args) {
        Double dObj = 45.67; // Wrapper object

        double d = dObj.doubleValue(); // Wrapper → primitive
        int i = (int) d; // Casting

        System.out.println("Double object: " + dObj);
        System.out.println("Primitive double: " + d);
        System.out.println("Casted int: " + i);
    }
}
