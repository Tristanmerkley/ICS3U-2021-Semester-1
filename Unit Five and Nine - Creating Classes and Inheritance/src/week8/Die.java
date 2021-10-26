package week8;

public class Die {
    // attributes - defines the state of the Object

    // The attributes SHOULD be private
    // private -> visible(accessable) in this class
    private int numSides;
    private int topSide;

    //constructor
    // has the same name as the class
    // you should create at least 1
    // they are used to obtain (construct an instance of this class)
    // in this case it will give a Die
    // Purpose is to initialise the state (attributes)
    public Die() {
        /* constructor initialises the attributes */
        numSides = 6;
        roll();
    }

    public Die(int numSides){
        /* the word this refers to the Object that we are working with */
        // the object the called this
        this.numSides = numSides;
        roll();
    }

    public void roll(){
        topSide = (int)(Math.random() * numSides) + 1;
    }

    public int getTopSide(){
        return this.topSide;
    }
}