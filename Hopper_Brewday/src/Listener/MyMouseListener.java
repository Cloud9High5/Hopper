package Listener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MyMouseListener extends MouseAdapter {
	
	@Override
	public void mouseClicked(MouseEvent e) {
		System.out.println("Mouse clicked");
	}
	
}