import java.util.HashMap;

class Tester {

    public static void main(String[] args) {

        System.out.println("1111");

        HashMap<Integer, Integer> hashMap = new HashMap<>(4);
        hashMap.put(1, 1);
        hashMap.put(2, 2);
        hashMap.put(3, 3);
        hashMap.put(4, 4);
        System.out.println("works till now!!");
        hashMap.put(5, 5);
        hashMap.put(6, 6);

        System.out.println("key 6:: " + hashMap.get(6));
        System.out.println("key 1:: " + hashMap.get(1));



        int count = 10;
        count++;
        int fina = count;
        System.out.println(fina);
    }
}