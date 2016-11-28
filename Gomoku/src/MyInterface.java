import java.awt.Graphics;

public interface MyInterface
{
	void paintComponent(Graphics g);
	boolean checkVictory();
	boolean getWhitesTurn();
	void setWhitesTurn(boolean whitesTurn);
	boolean roundUp(int value);
	void createBoard();
}