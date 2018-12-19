package toCompare;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.LongStream;
import java.util.stream.Stream;
@Service
public class SimpleParallel {
    public static void simpleParallel(){

        long num = 1000000L; //maximo que a Stream parallel consegue rodar nesta maquina
        //long num = 10000000000L;


        sumWithFor(num); //chama uma função estática passando o valor num por parametro
        sumWithStreamSimple(num);
        sumWithStreamParallel(num);
        sumWithLongStreamSimple(num);
        sumWithLongStreamParallel(num);

    }

    public static void sumWithFor(long num){
        long result = 0;

        long init = System.currentTimeMillis();
        for(long i = 1l; i<num; i++){
            result += i;
        }
        long end = System.currentTimeMillis();

        System.out.println("For:");
        System.out.println("Result: "+result);
        System.out.println("Time: "+ (end-init) +"ms");
        System.out.println();
    }

    public static void  sumWithStreamSimple(long num){
        long result =0;

        long init = System.currentTimeMillis();
        result = Stream.iterate(1l, i->i+1).limit(num).reduce(0L, Long::sum);
        long end = System.currentTimeMillis();

        System.out.println("Stream Simple:");
        System.out.println("Result: "+result);
        System.out.println("Time: "+ (end-init) +"ms");
        System.out.println();
    }

    public static void  sumWithStreamParallel(long num){
        long result = 0;

        long init = System.currentTimeMillis();
        List<Long> list = Stream.iterate(1l, i->i+1).limit(num).collect(Collectors.toList());
        result = list.stream().parallel().reduce(0L, Long::sum);
        long end = System.currentTimeMillis();

        System.out.println("Stream Parallel:");
        System.out.println("Result: "+result);
        System.out.println("Time: "+ (end-init) +"ms");
        System.out.println();
    }

    public static void  sumWithLongStreamSimple(long num){
        long result = 0;

        long init = System.currentTimeMillis();
        result = LongStream.range(1L, num).reduce(0L, Long::sum);
        long end = System.currentTimeMillis();

        System.out.println("LongStream Simple:");
        System.out.println("Result: "+result);
        System.out.println("Time: "+ (end-init) +"ms");
        System.out.println();
    }

    public static void  sumWithLongStreamParallel(long num){
        long result = 0;

        long init = System.currentTimeMillis();
        result = LongStream.range(1L, num).parallel().reduce(0L, Long::sum);
        long end = System.currentTimeMillis();

        System.out.println("LongStream Parallel:");
        System.out.println("Result: "+result);
        System.out.println("Time: "+ (end-init) +"ms");
        System.out.println();
    }
}
