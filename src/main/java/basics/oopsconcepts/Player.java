package basics.oopsconcepts;

/**
 * Created by rajani.maski on 7/10/17.
 */
 interface Player {

    String PLAYER = "NOT ASSIGNED";
     int run();

}


class StandardPlayer implements Player{

    public int run(){
        return 1;
    }
}