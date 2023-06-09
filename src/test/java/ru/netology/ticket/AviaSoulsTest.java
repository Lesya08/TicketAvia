package ru.netology.ticket;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Comparator;

public class AviaSoulsTest {
    @Test
    public void sortTicketsTest() {
        AviaSouls manager = new AviaSouls();
        Ticket ticket1 = new Ticket("MSK", "SPB", 2_000, 7, 8);
        Ticket ticket2 = new Ticket("MSK", "KZN", 5_000, 15, 17);
        Ticket ticket3 = new Ticket("SPB", "UFA", 7_000, 20, 23);
        Ticket ticket4 = new Ticket("MSK", "KZN", 4_000, 18, 20);
        Ticket ticket5 = new Ticket("MSK", "SPB", 3_000, 10, 11);
        Ticket ticket6 = new Ticket("MSK", "AER", 8_000, 11, 15);
        Ticket ticket7 = new Ticket("MSK", "KZN", 3_000, 13, 15);
        Ticket ticket8 = new Ticket("MSK", "SPB", 2_000, 7, 8);
        Ticket ticket9 = new Ticket("MSK", "KZN", 2_000, 9, 11);
        Ticket ticket10 = new Ticket("MSK", "KZN", 2_000, 17, 19);
        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);
        manager.add(ticket6);
        manager.add(ticket7);
        manager.add(ticket8);
        manager.add(ticket9);
        manager.add(ticket10);

        Ticket[] expected = {ticket9, ticket10, ticket7, ticket4, ticket2};
        Ticket[] actual = manager.search("MSK", "KZN");

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void sortOneTicketTest() {
        AviaSouls manager = new AviaSouls();
        Ticket ticket1 = new Ticket("MSK", "SPB", 2_000, 7, 8);
        Ticket ticket2 = new Ticket("MSK", "KZN", 5_000, 15, 17);
        Ticket ticket3 = new Ticket("SPB", "UFA", 7_000, 20, 23);
        Ticket ticket4 = new Ticket("MSK", "KZN", 4_000, 18, 20);
        Ticket ticket5 = new Ticket("MSK", "SPB", 3_000, 10, 11);
        Ticket ticket6 = new Ticket("MSK", "AER", 8_000, 11, 15);
        Ticket ticket7 = new Ticket("MSK", "KZN", 3_000, 13, 15);
        Ticket ticket8 = new Ticket("MSK", "SPB", 2_000, 7, 8);
        Ticket ticket9 = new Ticket("MSK", "KZN", 2_000, 9, 11);
        Ticket ticket10 = new Ticket("MSK", "KZN", 2_000, 17, 19);
        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);
        manager.add(ticket6);
        manager.add(ticket7);
        manager.add(ticket8);
        manager.add(ticket9);
        manager.add(ticket10);

        Ticket[] expected = {ticket6};
        Ticket[] actual = manager.search("MSK", "AER");

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void sortZeroTicketTest() {
        AviaSouls manager = new AviaSouls();
        Ticket ticket1 = new Ticket("MSK", "SPB", 2_000, 7, 8);
        Ticket ticket2 = new Ticket("MSK", "KZN", 5_000, 15, 17);
        Ticket ticket3 = new Ticket("SPB", "UFA", 7_000, 20, 23);
        Ticket ticket4 = new Ticket("MSK", "KZN", 4_000, 18, 20);
        Ticket ticket5 = new Ticket("MSK", "SPB", 3_000, 10, 11);
        Ticket ticket6 = new Ticket("MSK", "AER", 8_000, 11, 15);
        Ticket ticket7 = new Ticket("MSK", "KZN", 3_000, 13, 15);
        Ticket ticket8 = new Ticket("MSK", "SPB", 2_000, 7, 8);
        Ticket ticket9 = new Ticket("MSK", "KZN", 2_000, 9, 11);
        Ticket ticket10 = new Ticket("MSK", "KZN", 2_000, 17, 19);
        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);
        manager.add(ticket6);
        manager.add(ticket7);
        manager.add(ticket8);
        manager.add(ticket9);
        manager.add(ticket10);

        Ticket[] expected = {};
        Ticket[] actual = manager.search("SPB", "KZN");

        Assertions.assertArrayEquals(expected, actual);
    }


    @Test
    public void sortTicketsComparatorTest() {
        AviaSouls manager = new AviaSouls();
        Ticket ticket1 = new Ticket("MSK", "SPB", 2_000, 7, 8);
        Ticket ticket2 = new Ticket("MSK", "KZN", 5_000, 15, 19);  // 4ч
        Ticket ticket3 = new Ticket("SPB", "UFA", 7_000, 20, 23);
        Ticket ticket4 = new Ticket("MSK", "KZN", 4_000, 18, 19);  // 1ч
        Ticket ticket5 = new Ticket("MSK", "SPB", 3_000, 10, 11);
        Ticket ticket6 = new Ticket("MSK", "AER", 8_000, 11, 15);
        Ticket ticket7 = new Ticket("MSK", "KZN", 3_000, 13, 15);  // 2ч
        Ticket ticket8 = new Ticket("MSK", "SPB", 2_000, 7, 8);
        Ticket ticket9 = new Ticket("MSK", "KZN", 2_000, 8, 11);   // 3ч
        Ticket ticket10 = new Ticket("MSK", "KZN", 2_000, 17, 19); // 2ч
        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);
        manager.add(ticket6);
        manager.add(ticket7);
        manager.add(ticket8);
        manager.add(ticket9);
        manager.add(ticket10);

        Comparator<Ticket> comparator = new TicketTimeComparator();

        Ticket[] expected = {ticket4, ticket7, ticket10, ticket9, ticket2};
        Ticket[] actual = manager.searchAndSortBy("MSK", "KZN", comparator);

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void sortOneTicketComparatorTest() {
        AviaSouls manager = new AviaSouls();
        Ticket ticket1 = new Ticket("MSK", "SPB", 2_000, 7, 8);
        Ticket ticket2 = new Ticket("MSK", "KZN", 5_000, 15, 19);  // 4ч
        Ticket ticket3 = new Ticket("SPB", "UFA", 7_000, 20, 23);
        Ticket ticket4 = new Ticket("MSK", "KZN", 4_000, 18, 19);  // 1ч
        Ticket ticket5 = new Ticket("MSK", "SPB", 3_000, 10, 11);
        Ticket ticket6 = new Ticket("MSK", "AER", 8_000, 11, 15);
        Ticket ticket7 = new Ticket("MSK", "KZN", 3_000, 13, 15);  // 2ч
        Ticket ticket8 = new Ticket("MSK", "SPB", 2_000, 7, 8);
        Ticket ticket9 = new Ticket("MSK", "KZN", 2_000, 8, 11);   // 3ч
        Ticket ticket10 = new Ticket("MSK", "KZN", 2_000, 17, 19); // 2ч
        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);
        manager.add(ticket6);
        manager.add(ticket7);
        manager.add(ticket8);
        manager.add(ticket9);
        manager.add(ticket10);

        Comparator<Ticket> comparator = new TicketTimeComparator();

        Ticket[] expected = {ticket3};
        Ticket[] actual = manager.searchAndSortBy("SPB", "UFA", comparator);

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void sortZeroTicketComparatorTest() {
        AviaSouls manager = new AviaSouls();
        Ticket ticket1 = new Ticket("MSK", "SPB", 2_000, 7, 8);
        Ticket ticket2 = new Ticket("MSK", "KZN", 5_000, 15, 19);  // 4ч
        Ticket ticket3 = new Ticket("SPB", "UFA", 7_000, 20, 23);
        Ticket ticket4 = new Ticket("MSK", "KZN", 4_000, 18, 19);  // 1ч
        Ticket ticket5 = new Ticket("MSK", "SPB", 3_000, 10, 11);
        Ticket ticket6 = new Ticket("MSK", "AER", 8_000, 11, 15);
        Ticket ticket7 = new Ticket("MSK", "KZN", 3_000, 13, 15);  // 2ч
        Ticket ticket8 = new Ticket("MSK", "SPB", 2_000, 7, 8);
        Ticket ticket9 = new Ticket("MSK", "KZN", 2_000, 8, 11);   // 3ч
        Ticket ticket10 = new Ticket("MSK", "KZN", 2_000, 17, 19); // 2ч
        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);
        manager.add(ticket6);
        manager.add(ticket7);
        manager.add(ticket8);
        manager.add(ticket9);
        manager.add(ticket10);

        Comparator<Ticket> comparator = new TicketTimeComparator();

        Ticket[] expected = {};
        Ticket[] actual = manager.searchAndSortBy("AER", "KZN", comparator);

        Assertions.assertArrayEquals(expected, actual);
    }

}
