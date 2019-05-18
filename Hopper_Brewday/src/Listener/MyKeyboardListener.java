package Listener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class MyKeyboardListener extends KeyAdapter {
	@Override
	public void keyTyped(KeyEvent e) {
		System.out.println("key typed: " + e.getKeyChar());
	}
}
