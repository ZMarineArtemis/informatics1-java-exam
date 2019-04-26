import java.util.Map;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Hashtable;
import java.util.List;

class BattleShips {

    public static char fireShot(char[][] grid, Position shot) {
       if(shot.getX() > grid.length || shot.getY() > grid.length) {
    	   System.out.println('(' + shot.getX() + ',' + shot.getY() + ')' +':' + ' ' + "Out Of Bounds");
    	   return ' '; 
       }
       char result = grid[shot.getX()][shot.getY()];
       char X =  '#';
       if(result == X) {
    	   System.out.println('(' + shot.getX() + ',' + shot.getY() + ')' +':' + ' ' + "Miss");
    	   return X; 
       }else{
    	   System.out.println('(' + shot.getX() + ',' + shot.getY() + ')' +':' + ' ' + "Hit "+ result);   
           return result;
       }
    }

    public static Map<Character, Integer> findShips(char[][] grid) {
       Hashtable<Character, Integer> result = new Hashtable<Character, Integer>();
       char cha;
       int counter;
       for(int i =65; i<=90; i++) {
    	   counter = 0;
    	   for(int j =0; j<grid.length; j++) {
    		   for(int k =0; k<grid.length;k++) {
    			   cha = grid[j][k];
    			   if(cha == (char)i) {
    				   counter ++;
    			   }
    		   }
    	   }
        result.put((char)i, counter);
       }
        return result;
    }

    public static List<Character> fireShots(char[][] grid, List<Position> shots) {
    	ArrayList<Character> cha = new ArrayList<Character>();
    	char result;
    	for(int i=0; i< shots.size();i++) {
        result = BattleShips.fireShot(grid, shots.get(i));
        cha.add(result);
    	}
    	Collections.sort(cha);
    	int tmp;
    	int[] number = new int[cha.size()];
    	for(int i =65; i <=90;i++) {
    		tmp =0;
    	for(int k : cha) {
    	for(int j=0; j<cha.size();j++) {
    		if(cha.get(j) == (char)i) {
    			tmp++;
    		}
    	    }
    	number[k] = tmp;
    	}
    	}
    	 List<Character> output = new ArrayList<Character>();
        for(int f = 0; f < number.length && f< BattleShips.findShips(grid).size(); f++) {
        	if(number[f] == BattleShips.findShips(grid).get(f)) {
        		int tep = 65 + f;
        		output.get(tep);
        	}
        }
        
        return output;
    }

    public static void main(String[] args) {
        if (args.length < 1) {
            System.out.println("Please execute this program by"
                    + " providing the path to a game file,"
                    + " e.g. java BattleShips ./game01.txt");
            System.exit(1);
        }

        char[][] grid = BattleShipsUtils.parseGrid(args[0]);

        System.out.println("Playing with grid: ");
        BattleShipsUtils.printGrid(grid);

        Position centreShot = new Position(grid.length / 2,
                                           grid.length / 2);
        System.out.println("\nFiring Shot at centre " +
                            centreShot.toString() + " ...");
        fireShot(grid, centreShot);

        System.out.println("\nGenerating shots ...");
        List<Position> shots = BattleShipsUtils.generateShots(grid.length,
                                    grid.length * 2);
        System.out.println("Shots: " + shots);

        System.out.println("\nFinding Ships ...");
        Map<Character, Integer> ships = findShips(grid);
    	if(ships != null) {
           for (Character ship : ships.keySet())
             System.out.println(ship + " has size " + ships.get(ship));
    	}

        System.out.println("\nFiring shots ...");
    	if(shots != null) {
            List<Character> destroyedShips = fireShots(grid, shots);
    	    if (destroyedShips != null && !destroyedShips.isEmpty()) {
    	        System.out.println("Destroyed ships: ");
    	        for(char ship : destroyedShips)
    	            System.out.println(ship);
    	    }
    	}
    }
}