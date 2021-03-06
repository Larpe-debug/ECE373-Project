package ships;
import base.*;


public abstract class Ship extends Equipment {
	private boolean direction;
	public static final int GRID_HEIGHT = 10;
	public static final int GRID_WIDTH = 10;
	
	
	//default constructor
	public Ship(){
		super();
		direction = true;
	}
	
	//setters and getters
	public void setDir(boolean D){this.direction = D; return;}
	
	public boolean getDir(){return this.direction; }
	
	
	

		
	public int setShip(Coordinate frontCoordinate, GameBoard Board){	//This function will be used to place the ships in the grid.
		//Returns 0 if no error
		//Returns 1 if one or more coordinates are occupied
		//Returns 2 if one of more coordinates are off the grid
		int size = this.getSize();  //gets the size of the ship
		int i;
		int j;
		int frontCoordRow = frontCoordinate.getCoord().getLetter();
		int frontCoordColumn = frontCoordinate.getCoord().getNum();
		if(this.getDir() == false){ //if direction is horizontal 
			if ((frontCoordinate.getCoord().getNum() + size) > (GRID_WIDTH)){	//minus 1 because the grid goes from 0-9 not 1-10....Updated by C.J. as the game would not allow the ships to be set on the endge of the grid
				//One of more coordinates are off the grid
				return 2;
			}
			for(i = 0; i < size; i++){
				if (Board.getSpaces()[frontCoordRow][frontCoordColumn+i].getisOccupied() == true){
					//One or more coordinates are occupied
					return 1;
				}
			}
			for (i = 0; i < size; i++){	//iterates through the columns due to horizontal displacement.
				Board.getSpaces()[frontCoordinate.getCoord().getLetter()][frontCoordinate.getCoord().getNum()+i].setIsOccupiedBy(this);
				Board.getSpaces()[frontCoordinate.getCoord().getLetter()][frontCoordinate.getCoord().getNum()+i].setIsOccupied(true);
				this.setLocation(Board.getSpaces()[frontCoordinate.getCoord().getLetter()][frontCoordinate.getCoord().getNum()+i].getCoord());
			}

		}
		else{	//direction is vertical
			if((frontCoordinate.getCoord().getLetter()+size) > (GRID_HEIGHT)){
				// One or more coordinates are off the grid						//updated by C.J. removed the -1 because the game would not allow me to place ships that ended on the end of the grid
				return 2;	
			}
			for(i =0; i < size; i++){
				if (Board.getSpaces()[frontCoordRow+i][frontCoordColumn].getisOccupied() == true){
					//One or more coordinates are occupied
					return 1;
				}
			}
			for (j = 0; j < size; j++){		//iterates through rows
				Board.getSpaces()[frontCoordinate.getCoord().getLetter()+j][frontCoordinate.getCoord().getNum()].setIsOccupiedBy(this);
				Board.getSpaces()[frontCoordinate.getCoord().getLetter()+j][frontCoordinate.getCoord().getNum()].setIsOccupied(true);
				this.setLocation(Board.getSpaces()[frontCoordinate.getCoord().getLetter()+j][frontCoordinate.getCoord().getNum()].getCoord());
			}
		}
		return 0;
		
		
	}
		
		
		
}
	
	
	
	


