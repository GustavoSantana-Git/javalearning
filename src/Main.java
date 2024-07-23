import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class Main {
    public static void main(String[] args) {
        String s = "Testing the string manipulation";
        String[] split = s.split(" ");
        List<String> listStr = Arrays.asList(split);
        List<Integer> list = Arrays.asList(1,2,3,4,5,6);



        // reduce using sum on the first 2 numbers

        Optional<Integer> reduce = list.stream()
                .reduce((n1,n2) -> n1 + n2);
        System.out.println(reduce.get());
        //reduce using multiplication

        Optional<Integer> multiplication = list.stream()
                .reduce((n1,n2) -> n1 * n2);
        System.out.println(multiplication.get());

        //reduce - concat
        Optional<String> concatenate = listStr.stream()
                .reduce((s1,s2) -> s1.concat(s2));
        System.out.println(concatenate.get());

        //identity sum
        Integer reduce1 = list.stream()
                .reduce(0,(n1,n2) -> n1 + n2);
        System.out.println(reduce1);
        //reduce using multiplication

        //identity multiplication
        Integer multiplication1 = list.stream()
                .reduce(1,(n1,n2) -> n1 * n2);
        System.out.println(multiplication1);

        //reduce - map + combiner
        Optional<String> reduce2 = list.stream()
                .map(n1 -> n1.toString()).reduce((n1,n2) -> n1.concat(n2));
        System.out.println(reduce2);

        //reduce - same as above but oneline performance
        String reduce3 = list.stream().reduce("", (n1,n2) -> n1.toString().concat(n2.toString()),(n1,n2) -> n1.concat(n2));
        System.out.println(reduce3);


    }

}