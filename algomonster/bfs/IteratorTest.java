import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.stream.Collectors;

class IteratorTest {

    public static void main(String[] args) {
        System.out.println("!!!");

        LinkedList<Integer> linkedListObj = new LinkedList<>();
        linkedListObj.add(1);
        linkedListObj.add(2);
        linkedListObj.add(3);
        linkedListObj.add(4);

        System.out.println(linkedListObj.remove(2));
        System.out.println(linkedListObj.size());
        System.out.println(linkedListObj.offerFirst(0));
        System.out.println(linkedListObj.size());
        ListIterator<Integer> listIterator = linkedListObj.listIterator();
        while (listIterator.hasNext()) {
            System.out.println("Next :: " + listIterator.next());
        }

        System.out.println(listIterator);

        IteratorTest.Something something1 = new Something();

        Iterator iterator = something1.iterator();
        System.out.println(iterator.next());
        System.out.println(iterator.next());
        System.out.println(iterator.next());
        System.out.println(iterator.next());
        System.out.println(iterator.next());

        SomeComp someComp = new SomeComp(2);
        SomeComp someComp0 = new SomeComp(0);
        SomeComp someComp2 = new SomeComp(222);
        SomeComp someComp11 = new SomeComp(11);
        SomeComp someComp3 = new SomeComp(333);

        List<IteratorTest.SomeComp> asList = Arrays.asList(someComp, someComp0, someComp11, someComp2, someComp3);

        List<IteratorTest.SomeComp> collect = asList.stream().sorted().collect(Collectors.toList());

        System.out.println("new!!!");
        collect.stream()
                .peek(abc -> System.out.println("age:: " + abc.age))
                .map(abc -> abc)
                .collect(Collectors.toList());


        System.out.println("Finding Max");
        // System.out.println(asList.stream().max(new SomeComparator()));

    
        IteratorTest.SomeComparator someComparator = new IteratorTest.SomeComparator();
        Collections.sort(asList, someComparator);
        // List<SomeComp> asdas = asList.stream().sorted(someComparator).collect(Collectors.toList());
        System.out.println(asList.get(0).age);
        // asList.stream()
        //     .peek(aaa -> System.out.println(aaa.age))
        //     .collect(Collectors.toList());


        System.out.println("Finding Maxx!!!");
        System.out.println(asList.stream().max(new SomeComparator()).get().age);
        

        List<SomeComp> finals = asList.stream().sorted(new SomeComparator()).collect(Collectors.toList());
        System.out.println("Finding Nemo!!!");
        System.out.println(finals.get(4).age);


        System.out.println(someComp2.compareTo(someComp));
        System.out.println(someComp2.compareTo(someComp3));
    }

    static class Something implements Iterable {
        List<Integer> somethingList = new ArrayList<>();

        Something() {
            this.somethingList = Arrays.asList(1, 2, 3, 4, 5);
        }

        @Override
        public Iterator iterator() {
            return somethingList.iterator();
        }

    }

    static class SomeComparator implements Comparator<SomeComp> {

        public int compare(SomeComp a, SomeComp b) {
            if(a.age > b.age) return -1;
            if(a.age < b.age) return 1;
            return 0;
        }

    }

    static class SomeComp implements Comparable<SomeComp> {
        int age;

        SomeComp(int age) {
            this.age = age;
        }

        @Override
        public int compareTo(SomeComp o) {
            if (o.age > this.age) {
                return 1;
            } else if (o.age == this.age) {
                return 0;
            }
            return -1;
        }

    }
}