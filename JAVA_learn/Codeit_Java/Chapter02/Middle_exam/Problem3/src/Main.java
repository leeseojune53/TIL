public class Main {
    public static void main(String[] args) {
        ShapePrinter printer = new ShapePrinter();

        // 테스트
        printer.printTriangle(3);
        System.out.println("----------");
                printer.printTriangle(5);
        System.out.println("----------");
                printer.printTriangle(10);
    }
}