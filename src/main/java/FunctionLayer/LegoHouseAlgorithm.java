package FunctionLayer;

import java.util.ArrayList;

public class LegoHouseAlgorithm {

    private ArrayList<Integer> bricks = new ArrayList();
    private Integer stor;
    private Integer medium;
    private Integer lille;
    
    
    public ArrayList<Integer> brikker(int length){
        
        bricks.clear();
            
            int bigBrick = length / 4;
            
            int rest = length % 4;
            
            int mediumBrick = rest / 2;
            
            int rest1 = rest % 2;
            
            int smallBrick = rest1 / 1;
            
            
            bricks.add(bigBrick);
            bricks.add(mediumBrick);
            bricks.add(smallBrick);
            
            return bricks;
            
    }
    
    public ArrayList<Integer> calc(int length, int width, int height){
            
            ArrayList<Integer> temp = new ArrayList();
               brikker(length);
               
               temp.add(stor = bricks.get(0));
               temp.add(medium = bricks.get(1));
               temp.add(lille = bricks.get(2));
               
               brikker(width-4);
               temp.add(stor = bricks.get(0));
               temp.add(medium = bricks.get(1));
               temp.add(lille = bricks.get(2));
                         
        return temp;
    }
}
