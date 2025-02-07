package com.zipcodewilmington.streams;

import com.zipcodewilmington.streams.anthropoid.Person;
import com.zipcodewilmington.streams.anthropoid.PersonFactory;
import com.zipcodewilmington.streams.tools.RandomUtils;
import com.zipcodewilmington.streams.tools.StringUtils;

import java.util.List;
import java.util.Random;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by leon on 5/2/17.
 */
public class StreamFilter {
    private final Stream<Person> personStream;
    public final String startingCharacter;
    PersonFactory personFactory=new PersonFactory();
    Random random=new Random();
    /**
     * No arg constructor
     */ //TODO - construct person stream of 100 person objects; startingCharacter is a random capital letter
    public StreamFilter() {
                personStream= personFactory.createPersonStream(100);
                startingCharacter= RandomUtils.createCharacter('A','Z').toString();
        //this(Stream.empty(), null);
    }

    /**
     * @param people - Array of person objects
     * @param startingCharacter - character to filter by
     */ //TODO
    public StreamFilter(Person[] people, Character startingCharacter) {
        personStream=Stream.of(people);
        this.startingCharacter=startingCharacter.toString();
        //this(Stream.empty(), null);
    }

    /**
     * @param people - List of person objects
     * @param startingCharacter - character to filter by
     */ //TODO
    public StreamFilter(List<Person> people, Character startingCharacter) {
        personStream=people.stream();
        this.startingCharacter=startingCharacter.toString();
        //this(Stream.empty(), null);
    }


    /**
     * @param people - Stream of person objects
     * @param startingCharacter - character to filter by
     */ // I took care of the easy constructor (͡° ͜ʖ ͡°)
    public StreamFilter(Stream<Person> people, Character startingCharacter) {
        this.personStream = people;
        this.startingCharacter = startingCharacter.toString();
    }


    /**
     * Using multi-line lambda syntax
     * @return a list of person object whose name starts with `this.startingCharacter`.
     */ //TODO
    public List<Person> toListMultiLine() {
        Predicate<Person> startWith = person -> (Character.toString(person.getName().charAt(0))).equalsIgnoreCase(startingCharacter);
        return personStream.filter(startWith).collect(Collectors.toList());
    }


    /**
     * Using one-line lambda syntax
     * @return a list of person objects whose name starts with `this.startingCharacter`
     */ //TODO
    public List<Person> toListOneLine() {

        return personStream.filter(person -> (Character.toString(person.getName().charAt(0))).equalsIgnoreCase(startingCharacter)).collect(Collectors.toList());
    }


    /**
     * Using one-line lambda syntax
     * @return an array of person object whose name starts with `this.startingCharacter`
     */ //TODO
    public Person[] toArrayOneLine() {
        return personStream.filter(person -> (Character.toString(person.getName().charAt(0))).equalsIgnoreCase(startingCharacter)).toArray(Person[]::new);
              //  collect(Collectors.toList()).toArray();
    }


    /**
     * Using multi-line lambda syntax
     * @return an array of person object whose name starts with `this.startingCharacter`
     */ //TODO
    public Person[] toArrayMultiLine() {
        Predicate<Person> startWith = person -> (Character.toString(person.getName().charAt(0))).equalsIgnoreCase(startingCharacter);
        return personStream.filter(startWith).toArray(Person []::new);

    }

}
