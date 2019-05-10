
public class HomeModel {
	private HomeView homeview;
	public HomeModel() {
		
	}

	public HomeView getView(HomeView view) {
		return view;
	}
	public void setView(HomeView view) {
		this.homeview = view;
	}
}
