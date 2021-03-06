package boardObjects;//Created by ingridjohansen on 06/02/2019.

import inf112.skeleton.app.Position;

public class Void implements IBoardObject {

    private Position position;

    public Void(int x, int y){
    this.position = new Position(x, y);
    }

    @Override
    public int getX() {
        return this.position.getX();
    }

    @Override
    public int getY() {
        return this.position.getY();
    }

    public Position getPosition() {
        return this.position;
    }

}
