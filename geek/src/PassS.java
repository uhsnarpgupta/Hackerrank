public class PassS {
    public static void main(String[] args) {
        PassS p = new PassS();
        p.start();

        int a = 5;
        a = a >>> 1;
        System.out.println(a);
        System.out.println((String) null);

        int[] arr = new int[3];

        // Assigning long value to int type.
        arr[0] = 101;

        arr[1] = 'a';
        byte b = 10;
        arr[2] = b;

        // check
        int x = 0;
        int y = 0;
        for (int z = 0; z < 5; z++) {
            if ((++x > 2) || (++y > 2)) {
                x++;
            }
        }
        System.out.println(x + " " + y);
        try {
            aMethod();
        } catch (Exception e) /* Line 20 */ {
            System.out.print("exception ");
        }
        System.out.print("finished"); /* Line 24 */

    }

    public static void aMethod() throws Exception {
        try /* Line 5 */ {
            throw new Exception(); /* Line 7 */
        } catch (Exception e) {
            throw new Exception();
        } finally {
            /* Line 9 */
            System.out.print("finally "); /* Line 11 */
        }
    }

    void start() {
        String s1 = "slip";
        String s2 = fix(s1);
        System.out.println(s1 + " " + s2);
    }

    String fix(String s1) {
        s1 = s1 + "stream";
        System.out.print(s1 + " ");
        return "stream";
    }
}
