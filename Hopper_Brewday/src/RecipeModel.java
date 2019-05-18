
public class RecipeModel {
	private String name;
	private int ID ;
	private Double waterQuantity;
	private Double maltQuantity;
	private Double hopQuantity;
	private Double yeastQuantity;
	private Double sugarQuantity;
	private Double additiveQuantity;
	public RecipeModel() {
		this.ID = 0;
		this.name = "empty";
		this.waterQuantity=0.0;
		this.maltQuantity=0.0;
		this.hopQuantity=0.0;
		this.yeastQuantity=0.0;
		this.sugarQuantity=0.0;
		this.additiveQuantity=0.0;
	}
	public RecipeModel(String name, Double waterQuantity, Double maltQuantity, Double hopQuantity, Double yeastQuantity, Double sugarQuantity, Double additiveQuantity) {
		this.name = name;
		this.waterQuantity = waterQuantity;
		this.maltQuantity = waterQuantity;
		this.hopQuantity = hopQuantity;
		this.yeastQuantity = yeastQuantity;
		this.sugarQuantity = sugarQuantity;
		this.additiveQuantity = additiveQuantity;
	}
	public int getID(){
		return this.ID;
	}
	public void setID(int ID) {
		this.ID = ID;
	}
	public String getName(){
		return this.name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Double getWaterQuantity(){
		return this.waterQuantity;
	}
	public void setWaterQuantity(Double waterQuantity) {
		this.waterQuantity = waterQuantity;
	}
	public Double getMaltQuantity(){
		return this.maltQuantity;
	}
	public void setMaltQuantity(Double maltQuantity) {
		this.maltQuantity = maltQuantity;
	}
	public Double getHopQuantity(){
		return this.hopQuantity;
	}
	public void setHopQuantity(Double hopQuantity){
		this.hopQuantity = hopQuantity;
	}
	public Double getYeastQuantity(){
		return this.yeastQuantity;
	}
	public void setYeastQuantity(Double yeastQuantity) {
		this.yeastQuantity = yeastQuantity;
	}
	public Double getSugarQuantity(){
		return this.sugarQuantity;
	}
	public void setSugarQuantity(Double sugarQuantity) {
		this.sugarQuantity = sugarQuantity;
	}
	public Double getAdditiveQuantity(){
		return this.additiveQuantity;
	}
	public void setAdditiveQuantity(Double additiveQuantity) {
		this.additiveQuantity = additiveQuantity;
	}
}
