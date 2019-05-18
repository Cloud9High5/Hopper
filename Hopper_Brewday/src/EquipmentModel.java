
public class EquipmentModel {
	private Double capacity;
	private String name;
	private int Eid;
	// construct object
	public EquipmentModel(String name, Double capacity) {
		this.capacity = capacity;
		this.name = name;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Double getCapacity() {
		return capacity;
	}
	public void setCapacity(Double capacity) {
		this.capacity=capacity;
	}
	public int getEid() {
		return Eid;
	}
	public void setEid(int Eid) {
		this.Eid = Eid;
	}
}

