import java.util.Comparator;

public class OverpassComparator implements Comparator<Overpass> {

    @Override
    public int compare(Overpass o1, Overpass o2) {
        return switch (o1.getEnd().compareTo(o2.getEnd())){
            case -1 -> -1;
            case 1 -> 1;
            default -> switch (o1.getStart().compareTo(o2.getStart())) {
                case -1 -> -1;
                case 1 -> 1;
                default -> switch (Integer.signum(o1.getName().compareTo(o2.getName()))) {
                    case -1 -> -1;
                    case 1 -> 1;
                    default -> switch (o1.getChannel().compareTo(o2.getChannel())) {
                        case -1 -> -1;
                        case 1 -> 1;
                        default -> 0;
                    };
                };
            };
        };
    }
}
