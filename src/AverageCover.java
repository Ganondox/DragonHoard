import java.util.LinkedList;
import java.util.List;

public class AverageCover extends EstimatedCover{

    EstimatedCover estimator;

    @Override
    double estimateCover(List<Polynomio> pit, Cave board) {
        double total = 0;
        double cur = new CurrentCover().estimateCover(pit, board);
        for(int i = 0; i < pit.size(); i++){
            Polynomio piece = pit.get(i);
            double value = cur;
            for(int j = 0; j < 4; j++){
                for(int k = 0; k < board.board.length; k++){
                    for(int l = 0; l < board.board[0].length; l++){
                        Cave test = board.copy();
                        List<Polynomio> next = new LinkedList<>(pit);
                        next.remove(i);
                        if(test.addPolynomio(piece,l,k)) {
                            double score = estimator.estimateCover(next, test);
                            if (score > value) {
                                value = score;
                            }
                        }
                    }
                }
                piece.rotate90();
            }
            total += value;
        }
        return total/pit.size();
    }
}
