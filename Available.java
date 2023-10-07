import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

class Available {
    private List<Position> availablePosition;

    public Available() {
        availablePosition = new ArrayList<Position>();
    }

    public String toText() {
        return availablePosition.stream().map(position -> position.toText()).collect(Collectors.joining(" "));
    }

    public void addAvailable(Position position) {
        availablePosition.add(position);
    }

    public boolean havePosition(Position position) {
        for (Position innerPosition : availablePosition) {
            if (innerPosition.row == position.row && innerPosition.column == position.column) {
                return true;
            }
        }
        return false;
    }

}
