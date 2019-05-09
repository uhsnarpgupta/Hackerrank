public class ExceptionTest {
    public static void main(String[] args) {
        int num = 1;
        System.out.println(returnMerh(num));

        String p = "b";

        switch (p){
            default:
                System.out.println("Hello");

            case "a":
                System.out.println("bye");
                break;
            case "b":
                System.out.println("tata");
            case "n":
                System.out.println("No no");
                break;
        }

    }

    static String returnMerh(int n){
        String p = null;
        try{
            int k = 10/n;
            p = "hi";
            return p;
        }
        catch (Exception ex){
            p = "Ess";
            System.exit(0);
            return p;
        }
        finally {
            p =  "Hello";
            return p;
        }
    }
}
