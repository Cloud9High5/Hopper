import java.util.Date;

public class HistoryModel {
	private Date date;
	private int ID;
	private Double volume;
	private Double waterQuantity;
	private Double maltQuantity;
	private Double hopQuantity;
	private Double yeastQuantity;
	private Double sugarQuantity;
	private Double additiveQuantity;
	
	public HistoryModel(Date date,Double volume, Double waterQuantity, Double maltQuantity, Double hopQuantity, Double yeastQuantity, Double sugarQuantity, Double additiveQuantity) {
		this.date = date;
		this.volume = volume;
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
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public Double getVolume(){
		return this.volume;
	}
	public void setVolume(Double volume) {
		this.volume = volume;
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
