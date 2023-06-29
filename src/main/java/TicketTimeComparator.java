import java.util.Comparator;

public class TicketTimeComparator implements Comparator<Ticket> {

    @Override
    public int compare(Ticket o1, Ticket o2) {
        int timeFlight1 = o1.getTimeTo() - o1.getTimeFrom();
        int timeFlight2 = o2.getTimeTo() - o2.getTimeFrom();

        return timeFlight1 - timeFlight2;
    }

}
