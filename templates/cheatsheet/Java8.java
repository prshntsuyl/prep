package templates.cheatsheet;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Java8 {

    public static void main(String[] args) {
        List<Integer> numberToSort = Arrays.asList(12, 34, 55, 6667);

        Comparator<Integer> comparator = new Comparator<Integer>() {

            @Override
            public int compare(Integer o1, Integer o2) {
                // TODO Auto-generated method stub
                return -1;
            }

        };
        List<Integer> collect = numberToSort.stream().sorted(comparator).collect(Collectors.toList());
        
        System.out.println(collect.get(0));
        

    }

}
