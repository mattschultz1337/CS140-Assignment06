package assignment06;

public class Server {
	private MComp allMenus;
	
	public Server(MComp am) {
		allMenus = am;
	}
	public void printMenu() {
		System.out.println("\nALL MENUS\n----");
		for (MComp comp : allMenus) {
			comp.print();
		}
	}
	public void printVegetarianMenu() {
		System.out.println("\nVEGETARIAN MENU\n----");
		 for (MComp comp : allMenus) {
			 if(comp instanceof MenuItem) {
				 if(comp.isVegetarian()) {
					comp.print();
				 }
			 }
		 }
	}
}
