public class Main {
    public static void main(String[] args) {
        System.out.println();

        boolean authorization = Data.success("java_skypro_go", " 08976543_9", "D_1hWiKjjP_9");
        if (authorization) {
            System.out.println("Доступ разрешен!");
        } else {
            System.out.println("Доступ запрещен!");
        }
    }
}