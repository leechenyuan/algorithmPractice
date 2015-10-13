/**
 * * Created by lee chenyuan on 2015/10/11.
 */
public class TestGenericInterface {
    class CompareItem implements Comparable<TestGenericInterface>{
        @Override
        public int compareTo(TestGenericInterface o) {
            return 0;
        }
    }
}
