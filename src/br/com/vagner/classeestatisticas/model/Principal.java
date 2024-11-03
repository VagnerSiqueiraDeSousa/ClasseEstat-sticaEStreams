package br.com.vagner.classeestatisticas.model;

import java.time.LocalDate;
import java.util.*;
import java.util.stream.Stream;

public class Principal {
    public static void main(String[] args) {

        List<Aluno> alunos = Arrays.asList(
                new Aluno("Alice", LocalDate.of(2002, 10,20)),
                new Aluno("Bob", LocalDate.of(1980, 8, 9)),
                new Aluno("Carlos", LocalDate.of(2001, 1,28)),
                new Aluno("David", LocalDate.of(2003, 5, 12)),
                new Aluno("Eva", LocalDate.of(2005, 12,3))
        );

        IntSummaryStatistics stats = alunos.stream()
                .mapToInt(Aluno::getIdade)
                .summaryStatistics();

        //Exibindo as estatística
        System.out.println("Idade média: " + stats.getAverage());
        System.out.println("Mímima idade: " + stats.getMin());
        System.out.println("Máxima idade: " + stats.getMax());
        System.out.println("Total de alunos: " + stats.getCount());

        //Streams infinitos
        //usado quando não tem um tamanho definido, para gerar um sequência de números ou valores
        Stream.iterate(0, n-> n +1)
                .limit(10)
                .forEach(System.out::println);

        //FlatMap:  No exemplo abaixo, somamos todos os números da lista usando o método reduce().
        List<List<String>> list = List.of(
                List.of("a", "b"),
                List.of("c", "d")
        );

        Stream<String> stream = list.stream()
                .flatMap(Collection::stream);

        stream.forEach(System.out::println);

        //Redução de streams
        List<Integer> numbers = List.of(1, 2, 3, 4, 5);
        Optional<Integer> result = numbers.stream().reduce(Integer::sum);
        result.ifPresent(System.out::println); //15
        //No exemplo acima, somamos todos os números da lista usando o método reduce().

    }
}
