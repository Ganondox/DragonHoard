import java.util.List;

public class CurrentCover extends EstimatedCover{


    @Override
    double estimateCover(List<Polynomio> pit, Cave board) {
        return board.area() - board.space();
    }
}
