import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Comparator;

public class AviaSoulsTest {

    @Test

    // правильность сортировки
    public void testSortTickets() {

        AviaSouls manager = new AviaSouls();
        Ticket ticket1 = new Ticket("MSK", "SPB", 500, 5, 8);
        Ticket ticket2 = new Ticket("MSK", "SPB", 100, 10, 23);
        Ticket ticket3 = new Ticket("MSK", "SPB", 500, 11, 16);
        Ticket ticket4 = new Ticket("LA", "NY", 2000, 3, 14);
        Ticket ticket5 = new Ticket("NVGRD", "SPB", 500, 5, 8);
        Ticket ticket6 = new Ticket("LND", "MSK", 800, 10, 23);
        Ticket ticket7 = new Ticket("LA", "NY", 700, 13, 16);
        Ticket ticket8 = new Ticket("NVGRD", "LND", 300, 12, 23);


        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);
        manager.add(ticket6);
        manager.add(ticket7);
        manager.add(ticket8);

        Ticket[] expected = {ticket2, ticket1, ticket3};
        Ticket[] actual = manager.search("MSK", "SPB");

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test

    // отсутствие ответа при поиске
    public void testSortWithNoAnswer() {

        AviaSouls manager = new AviaSouls();
        Ticket ticket1 = new Ticket("MSK", "SPB", 500, 5, 8);
        Ticket ticket2 = new Ticket("MSK", "SPB", 100, 10, 23);
        Ticket ticket3 = new Ticket("MSK", "SPB", 500, 11, 16);
        Ticket ticket4 = new Ticket("LA", "NY", 2000, 3, 14);
        Ticket ticket5 = new Ticket("NVGRD", "SPB", 500, 5, 8);
        Ticket ticket6 = new Ticket("LND", "MSK", 800, 10, 23);
        Ticket ticket7 = new Ticket("LA", "NY", 700, 13, 16);
        Ticket ticket8 = new Ticket("NVGRD", "LND", 300, 12, 23);


        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);
        manager.add(ticket6);
        manager.add(ticket7);
        manager.add(ticket8);

        Ticket[] expected = {};
        Ticket[] actual = manager.search("MSK", "LA");

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test

    // один найденный ответ
    public void testSortWithOneAnswer() {

        AviaSouls manager = new AviaSouls();
        Ticket ticket1 = new Ticket("MSK", "SPB", 500, 5, 8);
        Ticket ticket2 = new Ticket("MSK", "SPB", 100, 10, 23);
        Ticket ticket3 = new Ticket("MSK", "SPB", 500, 11, 16);
        Ticket ticket4 = new Ticket("LA", "NY", 2000, 21, 4);
        Ticket ticket5 = new Ticket("NVGRD", "SPB", 500, 5, 8);
        Ticket ticket6 = new Ticket("LND", "MSK", 800, 10, 23);
        Ticket ticket7 = new Ticket("LA", "NY", 700, 13, 16);
        Ticket ticket8 = new Ticket("NVGRD", "LND", 300, 22, 4);


        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);
        manager.add(ticket6);
        manager.add(ticket7);
        manager.add(ticket8);

        Ticket[] expected = {ticket6};
        Ticket[] actual = manager.search("LND", "MSK");

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test

    public void testComparator() {

        AviaSouls manager = new AviaSouls();
        Ticket ticket1 = new Ticket("MSK", "SPB", 500, 5, 8); //3 часа в воздухе
        Ticket ticket2 = new Ticket("MSK", "SPB", 100, 10, 23); //13
        Ticket ticket3 = new Ticket("MSK", "SPB", 500, 11, 16); //5
        Ticket ticket4 = new Ticket("LA", "NY", 2000, 3, 14);
        Ticket ticket5 = new Ticket("NVGRD", "SPB", 500, 5, 8);
        Ticket ticket6 = new Ticket("LND", "MSK", 800, 10, 23);
        Ticket ticket7 = new Ticket("LA", "NY", 700, 13, 16);
        Ticket ticket8 = new Ticket("NVGRD", "LND", 300, 12, 23);


        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);
        manager.add(ticket6);
        manager.add(ticket7);
        manager.add(ticket8);

        Comparator<Ticket> comparator = new TicketTimeComparator();

        Ticket[] expected = {ticket1, ticket3, ticket2};
        Ticket[] actual = manager.searchWithComparator("MSK", "SPB", comparator);

        Assertions.assertArrayEquals(expected, actual);
    }

}
