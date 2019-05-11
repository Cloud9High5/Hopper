package Listener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MyActionListener implements ActionListener {
// This actionPerformed method is called every time the user
// clicks on the button; e is the event object created by Swing.
@Override
public void actionPerformed(ActionEvent e) {
	System.out.println("Button clicked!");
}
}