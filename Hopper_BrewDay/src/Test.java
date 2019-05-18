
public class Test {

	public static void main(String[] args){
		javax.swing.SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
			HomeModel m = new HomeModel();
			// The controller knows about the model (to increase the counter
			// of the model); the model does not know about the controller.
			HomeController c1 = new HomeController(m);
			// The view knows about the controller (which implements the
			// meaning of the button) and about the model (because the view
			// needs to display the value of the counter of the model).
			HomeView v1 = new HomeView(m , c1);
			// The model knows about the view, because the model needs to
			// notify the view to update itself every time the counter of
			// the model has changed.
			m.getView(v1);
			}
			});
	}	
}
