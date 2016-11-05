public class FinalField {

        final int x;
        int y;
        static FinalField f;

        public FinalField() {
            x = 3;
            y = 4;
        }

        static void writer() {
            f = new FinalField();
        }

        static void reader() {
            if (f != null) {
                int i = f.x;  // guaranteed to see 3
                int j = f.y;  // could see 0
            }
        }

}
