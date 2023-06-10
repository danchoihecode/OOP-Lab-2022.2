package hust.soict.globalict.aims.media;

public abstract class Media {

	private int id;
	private String title;
	private String category;
	private float cost;
	private static int nbOfItem = 0;

	public Media(String title, String category, float cost) {
		nbOfItem++;
		this.title = title;
		this.category = category;
		this.cost = cost;
		this.id = nbOfItem;
	}

	public Media(String title) {
		nbOfItem++;
		this.title = title;
		this.id = nbOfItem;
	}

	public int getId() {
		return id;
	}

	public String getTitle() {
		return title;
	}

	public String getCategory() {
		return category;
	}

	public float getCost() {
		return cost;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public boolean isMatch(String title) {
		String[] words = title.toLowerCase().split("\\s+");
		for (String word : words) {
			if (this.getTitle().toLowerCase().contains(word)) {
				return true;
			}
		}
		return false;
	}

}
