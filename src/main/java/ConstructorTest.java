import org.openjdk.jcstress.annotations.*;
import org.openjdk.jcstress.infra.results.IntResult2;

@State
public class ConstructorTest {
        private int x;
        private int y;
        private static ConstructorTest f;

        public ConstructorTest() {
            x = 4;
            y = 3;
        }

        @Actor
        public static void write() {
            f = new ConstructorTest();
        }

        @Actor
        public static void read(IntResult2 r) {
                if( f != null ) {
                    r.r1 = f.x;
                    r.r2 = f.y;
                }
        }
    }


