import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

public class Overpass {
    private final String name;
    private final Channel channel;
    private final LocalDateTime start;
    private final LocalDateTime end;

    public Overpass(String name, Channel channel, LocalDateTime start, LocalDateTime end) throws NullPointerException, IllegalArgumentException {
        if (name == null || channel == null || start == null || end == null) {
            throw new NullPointerException("Arguments can not be null!");
        }
        if (!start.isBefore(end)) {
            throw new IllegalArgumentException();
        }
        this.name = name;
        this.channel = channel;
        this.start = start;
        this.end = end;
    }

    public String getName() {
        return name;
    }

    public Channel getChannel() {
        return channel;
    }

    public LocalDateTime getStart() {
        return start;
    }

    public LocalDateTime getEnd() {
        return end;
    }

    @Override
    public String toString() {
        String startString = start.format(DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm"));
        String endString = end.format(DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm"));

        return channel.toString() + " " + name + ": " + startString + " - " + endString;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj.getClass() == this.getClass()) {
            Overpass op = (Overpass) obj;
            return op.getChannel() == channel && Objects.equals(op.getName(), name) && op.getStart() == start && op.getEnd() == end;
        }
        return false;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, channel, start, end);
    }
}
