package templates.cheatsheet;

import java.util.Comparator;

public class SomeComparator implements Comparator<Integer> {

    @Override
    public int compare(Integer o1, Integer o2) {
        if (o1 < o2 || o1.equals(o2)) return 1;
        else return 0;
    }
}
