package matriz.application;

import matriz.formatting.Formatting;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
@Service
public class MatrizWithLambda {

    public static void matrizWithLambda() {
        Scanner scan = new Scanner(System.in);
        List<List<Integer>> listArray = new ArrayList<>();

        System.out.print("What is the size od the matriz? Ex. '2 3'");

        int l = scan.nextInt();
        int c = scan.nextInt();

        Formatting.separationLines(); //Apenas adiciona linhas de semparação

        System.out.println("Insert Numbers:");

        IntStream.range(0, l).forEach(value ->{
                System.out.printf("Insert numbers of line %d: Ex '1 2 3'",listArray.size());
                listArray.add(IntStream.range(0, c).mapToObj(integre -> scan.nextInt()).collect(Collectors.toList()));
            }
        );
        Formatting.separationLines(); //Apenas adiciona linhas de semparação
        listArray.forEach(integers ->{
                    integers.forEach(integer -> System.out.print(integer+" "));
                    System.out.println();
                }
        );

        Formatting.separationLines(); //Apenas adiciona linhas de semparação

        System.out.print("Find a specific number and see the numbers that are in its area: ");
        int find = scan.nextInt();

        AtomicInteger line = new AtomicInteger();

        listArray.forEach(value -> {
                    if(value.indexOf(find)>=0) {
                            System.out.println();
                            System.out.println("Position " +line+ "," +value.indexOf(find)+":");
                            if (value.indexOf(find) > 0)
                                System.out.printf("Left: %d%n", listArray.get(line.get()).get(value.indexOf(find) - 1));
                            if (value.indexOf(find) < listArray.get(line.get()).size()-1)
                                System.out.printf("Right: %d%n", listArray.get(line.get()).get(value.indexOf(find) + 1));
                            if (line.get() > 0)
                                System.out.printf("Up: %d%n", listArray.get(line.get() - 1).get(value.indexOf(find)));
                            if (line.get() < listArray.size()-1)
                                System.out.printf("Down: %d%n", listArray.get(line.get() + 1).get(value.indexOf(find)));
                        }
                    line.getAndIncrement();
                }
        );

        Formatting.separationLines(); //Apenas adiciona linhas de semparação

        System.out.println("Main diagonal:");

        line.set(0);
        listArray.forEach(x->{
            System.out.println(x.get(line.get()));
            line.getAndIncrement();
        });

        scan.close();
    }
}
