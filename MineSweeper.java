import java.util.HashMap;
import java.util.Map;

class MineSweeper {

    public static Map<String, Position> findMines(char[][] grid) {
        Map<String,Position> map = new HashMap<String,Position>();   
    	for(int i =0; i < grid.length; i++) {
        	   for(int j =0; j < grid.length; j++) {
        		   if(grid[i][j] != '0');
        		   Position place = new Position(i, j);
        		   map.put(String.format("position object with coordinates x = %d and y = %d", i, j), place);
        	   }
           }
        return map;
    }

    public static boolean isIsolated(char[][] grid, Position minePos) {
           int X = minePos.getX();
           int Y = minePos.getY();
           Position above = new Position(X,Y - 1);
           Position below = new Position(X,Y + 1);
           Position left = new Position(X - 1,Y);
           Position right = new Position(X + 1, Y);
          if(grid[above.getX()][above.getY()] != '0' && grid[below.getX()][below.getY()] != '0' && grid[left.getX()][left.getY()] != '0' && grid[right.getX()][right.getY()] != '0' ) {
        	  return false;
          }else {
        	  return true;
          }
    } 

    public static int disarmMines(char[][] grid, Map<String, Position> armedMines) {
        // Implement me!
        return 0;
    }

    public static void main(String[] args) {
        if (args.length < 1) {
            System.out.println("Please execute this program by"
                    + " providing the path to a game file,"
                    + " e.g. java MineSweeper ./game01.txt");
            System.exit(1);
        }

        char[][] grid = MineSweeperUtils.parseGrid(args[0]);
        System.out.println("Playing with grid: ");
        MineSweeperUtils.printGrid(grid);

        System.out.println("Searching mines ...");
        Map<String, Position> mines = findMines(grid);
        if(mines != null) {
            if(mines.isEmpty()) System.out.println("No mines found.");
            else System.out.println("Mines found at: " + mines.keySet());
        }

        System.out.println("\nDisarming mines ...");
        int disarmed = disarmMines(grid, mines);
        System.out.println(disarmed + " mines disarmed!");
        MineSweeperUtils.printGrid(grid, mines);
    }
}