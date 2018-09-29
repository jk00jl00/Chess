package pieces;

import chessBase.Board;
import chessHelp.Move;

import java.util.ArrayList;

/**
 * Created by isjo16 on 2018-09-28.
 */
public class King extends Piece{
    public King(int x, int y, boolean player) {
        super(x, y, player);
        this.disp = (player) ?  "\u2654" : "\u265A";
    }

    @Override
    public void checkMoves(Board board) {
        moves = new ArrayList<>();

        for(int dy = -1; dy < 2 ; dy++){
            if(((y == 0 && dy < 0)||(y == 7 && dy > 0)))
                continue;
            for(int dx = -1; dx < 2; dx++ ){
                if(((x == 0 && dx < 0)||(x == 7 && dx > 0)))
                    continue;
                if(dy == 0 && dx == 0) continue;
                if (board.getPieces()[(y + dy) * 8 + x +dx] == null ) {
                    boolean checkMove = false;
                    for(Piece p: board.getPieces()){
                        if(p == null || p.isPlayer() == this.isPlayer()) continue;
                        for(Move m: p.getMoves()){
                            if(m.getX() == x + dx && m.getY() == y + dy)
                              checkMove = true;
                        }
                    }
                    if(!checkMove)
                        moves.add(new Move(x + dx, y + dy, true, false, false));
                    else
                        moves.add(new Move(x + dx, y + dy, false, false, false));
                } else if (board.getPieces()[(y + dy) * 8 + dx + x] instanceof King && (board.getPieces()[(y + dy) * 8 + dx + x].isPlayer() != this.isPlayer())) {
                    boolean checkMove = false;
                    for(Piece p: board.getPieces()){
                        if(p == null || p.isPlayer() == this.isPlayer()) continue;
                        for(Move m: p.getMoves()){
                            if(m.getX() == x + dx && m.getY() == y + dy)
                                checkMove = true;
                        }
                    }
                    if(!checkMove)
                        moves.add(new Move(x + dx, y + dy, true, (board.getPieces()[(y + dy) * 8 + dx + x].isPlayer() != this.isPlayer()),
                                (board.getPieces()[(y + dy) * 8 + dx + x].isPlayer() != this.isPlayer())));
                    else
                        moves.add(new Move(x + dx, y + dy, false, (board.getPieces()[(y + dy) * 8 + dx + x].isPlayer() != this.isPlayer()),
                                (board.getPieces()[(y + dy) * 8 + dx + x].isPlayer() != this.isPlayer())));

                } else if (board.getPieces()[(y + dy) * 8 + dx + x] instanceof Piece && (board.getPieces()[(y + dy) * 8 + dx + x].isPlayer() != this.isPlayer())) {
                    boolean checkMove = false;
                    for(Piece p: board.getPieces()){
                        if(p == null || p.isPlayer() == this.isPlayer()) continue;
                        for(Move m: p.getMoves()){
                            if(m.getX() == x + dx && m.getY() == y + dy)
                                checkMove = true;
                        }
                    }
                    if(!checkMove)
                        moves.add(new Move(x + dx, y + dy, true, (board.getPieces()[(y + dy) * 8 + dx + x].isPlayer() != this.isPlayer()), false));
                    else
                        moves.add(new Move(x + dx, y + dy, false, (board.getPieces()[(y + dy) * 8 + dx + x].isPlayer() != this.isPlayer()), false));

                }
            }
        }
    }
}
