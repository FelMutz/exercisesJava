package thread;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.LongStream;
import java.util.stream.Stream;


public class TestThreadStreams {
    public static long num = 1000000L;

    public synchronized static void testThreadStreams(){

        new Thread(sumWithFor).start(); //chama uma função estática passando o valor num por parametro
        new Thread(sumWithStreamSimple).start();
        new Thread(sumWithStreamParallel).start();
        new Thread(sumWithLongStreamSimple).start();
        new Thread(sumWithLongStreamParallel).start();

    }

    public static Runnable sumWithFor = () ->{
        long result = 0;

        long init = System.currentTimeMillis();
        for(long i = 1l; i<num; i++){
            result += i;
        }
        long end = System.currentTimeMillis();

        System.out.printf("For: Result: %d Time: %d ms%n",result, (end-init));

    };

    public static Runnable sumWithStreamSimple = () ->{
        long result =0;

        long init = System.currentTimeMillis();
        result = Stream.iterate(1l, i->i+1).limit(num).reduce(0L, Long::sum);
        long end = System.currentTimeMillis();

        System.out.printf("Stream Simple: Result: %d Time: %d ms%n",result, (end-init));
    };

    public static Runnable sumWithStreamParallel = () ->{
        long result = 0;

        long init = System.currentTimeMillis();
        List<Long> list = Stream.iterate(1l, i->i+1).limit(num).collect(Collectors.toList());
        result = list.stream().parallel().reduce(0L, Long::sum);
        long end = System.currentTimeMillis();

        System.out.printf("Stream Parallel: Result: %d Time: %d ms%n",result, (end-init));;

    };

    public static Runnable sumWithLongStreamSimple = () ->{
        long result = 0;

        long init = System.currentTimeMillis();
        result = LongStream.range(1L, num).reduce(0L, Long::sum);
        long end = System.currentTimeMillis();

        System.out.printf("LongStream Simple: Result: %d Time: %d ms%n",result, (end-init));
    };

    public static Runnable sumWithLongStreamParallel = () ->{
        long result = 0;

        long init = System.currentTimeMillis();
        result = LongStream.range(1L, num).parallel().reduce(0L, Long::sum);
        long end = System.currentTimeMillis();

        System.out.printf("LongStream Parallel: Result: %d Time: %d ms%n",result, (end-init));
    };

}
