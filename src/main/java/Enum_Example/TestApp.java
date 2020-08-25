package Enum_Example;

import java.util.EnumMap;
import java.util.EnumSet;
import java.util.Set;

public class TestApp {

    public static void main(String[] args) {

        TicketType ticketType1 = TicketType.BUG;
        System.out.println(ticketType1);
        // najprostrza wersja enuma

        // Enum rozszerza Enum, więc nie może już nic innego rozszerzać
        // ma zaimplementowane interfejsy comparable i serializable
        // nie musimy się martwić o serializację i deserializację
        // nie da się zrobić publicznego konstruktora enuma, również protected
        // domyślna widoczność konstruktora zostanie i tak zmieniona na prywatną

        // na każdą wartość zostanie utworzona jedna instancje enuma
        // w tym wypadku 3 instancje, BUG, TASK, SUGGESTION
        // każda wartość ma przypisaną wartość związaną z kolejnością w klasie enum
        // metoda ordinare() - zwraca tę wartość

        System.out.println("-------------------------");
        System.out.println(ticketType1.ordinal());  // wypisze 0
        System.out.println("-------------------------");

        // metoda value() - zwraca wszystkie wartości z enuma
        for(TicketType ticketType : TicketType.values()){
            System.out.println(ticketType.getPriority());
            // kolejność wg ukrytych wartości, zamiana miejsc w definicji zmieni kolejność wyświetlania
        }

        System.out.println("-------------------------");
        for(TicketType ticketType : TicketType.values()){
            System.out.println(ticketType.isAssigned());     // w naturalny sposób zwróci false dla wszystkich wartości
        }

        System.out.println("-------------------------");
        for(TicketType ticketType : TicketType.values()){
            ticketType.comment();
        }

        System.out.println("-------------------------");

        TicketType bug = TicketType.BUG;
        TicketType suggestion = TicketType.SUGGESTION;

        System.out.println(bug == suggestion);      // zwraca false bo wartości inne
        System.out.println(bug == bug);             // zwraca true bo wartości inne

        OtherType first = OtherType.FIRST;

        //System.out.println(bug == first);           // ide zwraca błąd kompilacji, typy nie są kompatybilne
        System.out.println("-------------------------");
        Set<TicketType> ticketTypeSet = EnumSet.of(TicketType.TASK,TicketType.BUG,TicketType.SUGGESTION);
        //specjalny zbiór w java, wyspecyfikowany do enum, implementuje metody z interfejsu set
        ticketTypeSet.forEach(System.out::println);

        System.out.println("-------------------------");
        // enum map - kolekcja dla enum, wyspecyfikowana
        // klucz enumowy    wartość dowolna                   nieco inny zapis
        EnumMap<TicketType, String> enumMap = new EnumMap<>(TicketType.class);

        enumMap.put(TicketType.BUG,"Dawid Nowak");
        enumMap.put(TicketType.TASK,"Agnieszka Kowalska");

        System.out.println(enumMap.get(TicketType.TASK));

        /* ograniczenia
                jedna instancja
                brak możliwości rozszerzania
            mozna z tego stworzyć singleton
        */
    }
}
