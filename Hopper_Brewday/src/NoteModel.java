import java.util.Date;

public class NoteModel {
	private int nid;
	private String name;
	private String content;
	private Date date;
	
	public NoteModel(String name, String content, Date date) {
		this.name = name;
		this.content = content;
		this.date = date;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getId() {
		return nid;
	}
	public void setId(int id) {
		this.nid = id;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	
	
}

