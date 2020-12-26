package demo.streams;

import org.apache.commons.lang3.RandomStringUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamsTest {
    public static void main(String[] args) {
        String[] nameZhArray = new String[]{"张三1", "张三2", "张三丰1", "李四1", "李鬼1", "王五1"};
        Map<Integer, Set<String>> collect = Stream.of(nameZhArray).sorted().collect(Collectors.groupingBy(String::length, Collectors.toSet()));
        for (Map.Entry<Integer, Set<String>> entry : collect.entrySet()) {
            System.out.println(entry.getKey() + ": " + String.join(", ", entry.getValue()));
        }


        /*collect.forEach((integer, strings) -> {
            strings.forEach(System.out::println);
        });*/



        /*
        Stream.of(nameZhArray).findFirst().ifPresent(System.out::println);
        Stream.of(nameZhArray).findAny().ifPresent(System.out::println);*/

        /**/
        /*System.out.println(String.join(", ", nameZhArray));

        System.out.println(Stream.of(nameZhArray).collect(Collectors.joining(", ", "Hello ", ", Welcome!")));

        Map<String, Integer> integerMap = Stream.of(nameZhArray).collect(Collectors.toMap(Function.identity(), String::length));
        integerMap.forEach((s, integer) -> System.out.println(s + "=" + integer));*/

        //IntStream range = IntStream.range(0, 10);
        //int[] ints = range.toArray();
        //LongSummaryStatistics longSummaryStatistics = range.asLongStream().summaryStatistics();
        //System.out.println(longSummaryStatistics.getAverage());
        /*IntSummaryStatistics statistics = Stream.of(nameZhArray).collect(Collectors.summarizingInt(String::length));
        System.out.println(statistics.getAverage());
        System.out.println(statistics.getSum());
        System.out.println(statistics.getMin());
        System.out.println(statistics.getMax());
        System.out.println(statistics.getCount());*/
        /*List<Integer> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            list.add(RandomUtils.nextInt(0, 10));
        }
        System.out.println(list);
        list.stream().sorted().map(s -> s + ", ").forEach(System.out::print);
        System.out.println();
        list.stream().distinct().sorted(Comparator.reverseOrder()).map(s -> s + ", ").forEach(System.out::print);

        System.out.println();
        System.out.println(list.stream().count());

        System.out.println(list.stream().max(Comparator.naturalOrder()).orElse(null));
        System.out.println(list.stream().min(Comparator.naturalOrder()).orElse(null));*/

        /*
        List<String> collect = Arrays.stream(nameZhArray).filter(s -> s.contains("李")).collect(Collectors.toList());
        System.out.println(collect);
        System.out.println(StringUtils.join(nameZhArray, ','));*/

        /*boolean anyMatch = Stream.of(nameZhArray).anyMatch(s -> s.contains("张"));//true
        System.out.println(anyMatch);

        boolean allMatch = Stream.of(nameZhArray).allMatch(s -> s.contains("张"));//false
        System.out.println(allMatch);

        boolean noneMatch = Stream.of(nameZhArray).noneMatch(s -> s.contains("张"));//false
        System.out.println(noneMatch);

        anyMatch = Stream.of(nameZhArray).anyMatch(s -> s.contains("蒋"));//false
        System.out.println(anyMatch);

        allMatch = Stream.of(nameZhArray).allMatch(s -> s.contains("1"));//true
        System.out.println(allMatch);

        noneMatch = Stream.of(nameZhArray).noneMatch(s -> s.contains("蒋"));//true
        System.out.println(noneMatch);*/

        //for循环迭代+if过滤
        /*List<String> filter1 = new ArrayList<>();
        for (String s : nameZhArray) {
            if (s.contains("张")) {
                filter1.add(s);
            }
        }
        filter1.forEach(System.out::println);

        //stream filter过滤
        List<String> filter2 = Arrays.stream(nameZhArray).filter(s -> s.contains("李")).collect(Collectors.toList());
        filter2.forEach(System.out::println);

        Arrays.stream(nameZhArray).map(s -> s.concat(RandomStringUtils.randomNumeric(4))).forEach(System.out::println);
        Arrays.stream(nameZhArray).forEach(System.out::println);*/

        /*List<User> userList = Arrays.stream(nameZhArray).map(StreamsTest::findByName).collect(Collectors.toList());
        userList.forEach(System.out::println);*/

        /*Stream<String> stream1 = Stream.of("Alex", "Rose", "Tim");

        List<String> nameEnList = new ArrayList<>();
        nameEnList.add("Alex");
        nameEnList.add("Rose");
        nameEnList.add("Tim");

        System.out.println(nameEnList.stream().distinct().count());
        nameEnList.forEach(System.out::println);*/

        /*List<List<String>> top = new ArrayList<>();
        top.add(randomList(RandomUtils.nextInt(2, 5)));
        top.add(randomList(RandomUtils.nextInt(2, 5)));

        System.out.println(top.toString());

        List<String> flat = top.stream().flatMap(Collection::stream).collect(Collectors.toList());
        flat.forEach(System.out::println);*/

        /*List<Integer> integers = Arrays.asList(1, 2, 3);
        Integer reduced = integers.stream().reduce(23, (a, b) -> a / b);//3
        System.out.println(reduced);*/

        /*List<String> strings = Arrays.asList("a", "b", "c");
        String reduce = strings.stream().reduce("Hello ", String::concat);
        System.out.println(reduce);*/

    }

    private static List<String> randomList(int size) {
        List<String> s = new ArrayList<>(size);
        for (int i = 0; i < size; i++) {
            s.add(RandomStringUtils.randomAlphanumeric(2));
        }
        return s;
    }

    /*private static User findByName(String name) {
        User u = new User();
        u.setName(name);
        return u;
    }*/
}
