import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.JPanel;


public class Board extends JPanel
	{
		private boolean whitesTurn = false;
		private ArrayList<Point> points;
		private int[][] pieceLocs = new int [10][10];
		private int playersRow;
		private int playersCol;
		
		public Board()
		{
			createBoard();
			
		}//end constructor
		
		public void createBoard()
		{
			points = new ArrayList<Point>();
			addMouseListener(new MouseAdapter() {
				@Override
				public void mousePressed(MouseEvent e)
				{
					
					points.add(new Point(e.getX(), e.getY()));
					setPlayersRow((points.get(points.size()-1) ).x);
					setPlayersCol((points.get(points.size()-1) ).y);
					repaint();
				}
				
				
			});
			
		}
		public void addPiece(int row, int col)
		{
			points.add(new Point(row, col));
			repaint();
			
		}
		
		 @Override
		 public void paintComponent(Graphics g)
		 {
			 setWhitesTurn(false);
			 super.paintComponent(g);
			 for(int i = 0; i< 9; i++){
					for(int j = 0; j<9; j++){
						//i is the column. j is the row. start in column 1 and fill in 9 rows, etc. [x,y, width, height]
						g.drawRect((i)*40, (j)*40, 40, 40);
					}
			 }
			 Graphics2D g2 = (Graphics2D) g;
			 for (Point point : points) 
			 { 
				 //hold decimal values for the x and y (round up or round down)
				 int x = (int) ( ( (double)(point.x)/40 - (point.x)/40 ) *100 );
				 int y = (int) ( ( (double)(point.y)/40 - (point.y)/40 ) *100 );
				 int xRow = 0;
				 int yRow = 0;
				 int xPlacer = 0;
				 int yPlacer = 0;

				 if(roundUp(x))
				 {
					 xRow = ( (point.x / 40)+1) * 40;
					 xPlacer = xRow;
					 xRow = xRow -10;
				
				 }
				 else if(roundUp(x) == false)
				 {
					 xRow = ((point.x /40) * 40);
					 xPlacer = xRow;
					 xRow = xRow - 10;

				 }
				 
				 if(roundUp(y))
				 {
					 yRow = ((point.y / 40)+1) * 40;
					 yPlacer = yRow;
					 yRow = yRow -10;
				
				 }
				 else if(roundUp(y) == false)
				 {
					yRow = ( (point.y /40) * 40);
					yPlacer = yRow; 
					yRow = yRow -10;
				
				 }
				 
				 if(getWhitesTurn() == true){
					 g2.setColor(Color.red);
					 g2.fillOval(xRow, yRow, 20, 20);
					 //setWhitesTurn(false);
					 pieceLocs[xPlacer/40][yPlacer/40] = 1;
				 }else if(getWhitesTurn() == false){
					 g2.setColor(Color.black);
					 g2.fillOval(xRow, yRow, 20, 20);
					 //setWhitesTurn(true);
					 pieceLocs[xPlacer/40][yPlacer/40] = 2;
				 }
				 checkVictory();
				 if(getWhitesTurn() == true){
					 setWhitesTurn(false);
				 }
				 else{
					 setWhitesTurn(true);
				 }
			 }

		  }//end paint Component.
		 
		 private boolean checkVictory(){
			 //Vertical Check
			 for(int i = 0; i < 4; i++){
				 for(int n = 0; n < 10; n++){
					if(pieceLocs[i][n] != 0 && pieceLocs[i][n] == pieceLocs[i+1][n] && pieceLocs[i][n] == pieceLocs[i+2][n] && pieceLocs[i][n] == pieceLocs[i+3][n] && pieceLocs[i][n] == pieceLocs[i+4][n]){
						System.out.println("WON1");
						return true;
					}
				 }
			 }
			 
			 //Horizontal check
			 for(int d = 0; d < 10; d++){
				 for(int e = 0; e < 4; e++){
					 if(pieceLocs[d][e] != 0 && pieceLocs[d][e] == pieceLocs[d][e+1] && pieceLocs[d][e] == pieceLocs[d][e+2] && pieceLocs[d][e] == pieceLocs[d][e+3] && pieceLocs[d][e] == pieceLocs[d][e+4]){
						 System.out.println("WON2");
						 return true;
					 }
				 }
			 }
			 
			 //Down Right check
			 for(int d = 0; d < 4; d++){
				 for(int e = 0; e < 4; e++){
					 if(pieceLocs[d][e] != 0 && pieceLocs[d][e] == pieceLocs[d+1][e+1] && pieceLocs[d][e] == pieceLocs[d+2][e+2] && pieceLocs[d][e] == pieceLocs[d+3][e+3] && pieceLocs[d][e] == pieceLocs[d+4][e+4]){
						 System.out.println("WON3");
						 return true;
					 }
				 }
			 }
			 
			 //Down Left check
			 for(int d = 0; d < 4; d++){
				 for(int e = 9; e > 3; e--){
					 if(pieceLocs[d][e] != 0 && pieceLocs[d][e] == pieceLocs[d+1][e-1] && pieceLocs[d][e] == pieceLocs[d+2][e-2] && pieceLocs[d][e] == pieceLocs[d+3][e-3] && pieceLocs[d][e] == pieceLocs[d+4][e-4]){
						 System.out.println("WON4");
						 return true;
					 }
				 }
			 }
			 
			 return false;
		 }
		 
		 private boolean getWhitesTurn()
		 {
			 return whitesTurn;
			 
		 }
		 public void setWhitesTurn(boolean whitesTurn)
		 {
			 this.whitesTurn = whitesTurn;
			 
		 }
		 
		 public boolean roundUp(int value)
		 {
			 if(value >=50)
			 {
				 return true;
			 }
			 return false;
			 
		 }//end roundUp
		 
		 public int getPlayersRow()
		 {
			 return playersRow;
			 
		 }
		 public void setPlayersRow(int x)
		 {
			 playersRow = x;
			 
		 }
		 public int getPlayersCol()
		 {
			 return playersCol;
			 
		 }
		 
		 public void setPlayersCol(int y)
		 {
			 playersCol = y;
			 
		 }
		
	}//end board class.