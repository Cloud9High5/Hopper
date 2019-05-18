
public class IngredientModel {
	private String name= new String(); 
	private Double amount ;
	private String unit= new String(); 
	private IngredientView v;
	
	//constructors
	public IngredientModel(Double amount) {
		this.amount = amount;
	}
	public String getName(){
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Double getAmount(){
		return amount;
	}
	public void setAmount(Double amount) {
		this.amount = amount;
	}
	public String getUnit(){
		return unit;
	}
	public void setUnit(String unit) {
		this.unit = unit;
	}
}
