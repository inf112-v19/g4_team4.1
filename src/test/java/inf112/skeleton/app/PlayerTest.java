package inf112.skeleton.app;

import org.junit.Before;

/* Test for player */


public class PlayerTest {
    private MapGUI map;
    private static Wall wallsOnTheMap;



    //Method used to set up a map that can be used in all test
    @Before

    //can be smart to creat map here so that i don't need it to do so in every test
    public static Map setupMapBefore() {
        Map map = new Map(10, 20);
        return map;
    }

/*


    @Test

    //TODO check if flags been visited
    public void playerCollectsFlags(){
        Player robot = new Player(10, 1);


       //one flag

      //  assertEquals(2, flagsWhichHasBeenVisited.getFlagsVisited());

    }



   //TODO check if an KeyBoardEvent is a legal input
   @Test (expected = IllegalArgumentException.class)

   public void illegalKeyBoardCode(){

   }



    @Test

    //TODO check if legal inputs are okay

    public void playerMovement(){
        //creating map
        Map map = new Map(10, 20);

        //Creating robot and  a player
        Robot robot = new Robot(5,5, Directions.UP);
        Player testRobot = new Player(5, robot );
        testRobot

        assertTrue();


    }




    @Test

   //Todo check if player goes through walls

    public void robotDoesNotGoThroughWallsDown(){
       Player testRobot = new Player(0, 5, 5, Directions.DOWN);
      (testRobot.noticeWalls(Directions.DOWN))

      }

       if(IBoardObject  = instanceOf Wall){
       assertFalse(testRobot.canGO = true);
       assertTrue(testRobot.canGO = false);


    }

    @Test

    //TODO make the method and then make the test

    public void givingCardsCorrectly(){

    }

    @Test

    //TODO make the method and then make the test

    public void  testMemoryCapacityForThisPlayer(){

    }




} */
