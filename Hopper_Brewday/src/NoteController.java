import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;

public class NoteController {
	static long timemillis = System.currentTimeMillis();
	SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	public NoteController(NoteModel n) {
	}
	public static int insertNote(NoteModel note,Integer Rid) {
	    Connection conn = MyDBUtil.getConn();
	    int i = 0;
	    String sql = "insert into note (name,content,date,Rid) values(?,?,?,?)";
	    PreparedStatement pstmt;
	    try {
	    	pstmt = (PreparedStatement) conn.prepareStatement(sql);
	        pstmt.setString(1, note.getName());
	        pstmt.setString(2, note.getContent());
	        pstmt.setTimestamp(3, new Timestamp(timemillis));
	        pstmt.setInt(4, Rid);
	        i = pstmt.executeUpdate();
	        pstmt.close();
	        conn.close();
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    return i;
	}
	public static int updateNote(NoteModel note, Integer Nid, Integer Rid) {
	    Connection conn = MyDBUtil.getConn();
	    int i = 0;
	    String sql = "update note set Name='" + note.getName() + "', Content='" + note.getContent() + "', Date='" + new Timestamp(timemillis) + "',Rid='" + Rid + "' where Nid='" + Nid + "'";
	    PreparedStatement pstmt;
	    try {
	        pstmt = (PreparedStatement) conn.prepareStatement(sql);
	        i = pstmt.executeUpdate();
	        pstmt.close();
	        conn.close();
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    return i;
	}
	public static String[] getAllNote() {
	    Connection conn = MyDBUtil.getConn();
	    String sql = "select * from note";
	    String[] line = new String[100];
	    int i = 1;
	    PreparedStatement pstmt;
	    try {
	        pstmt = (PreparedStatement)conn.prepareStatement(sql);
	        ResultSet rs = pstmt.executeQuery();
	        int col = rs.getMetaData().getColumnCount();
	        int j = 0;
	        while (rs.next()) {
	        	String res = "";
        	    for (i = 1; i <= col; i++) {
        	    	res += rs.getString(i) + " | ";
	             }
        	    line[j++] = res;
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    return line;
	}
	public static int deleteNote(Integer Nid) {
	    Connection conn = MyDBUtil.getConn();
	    int i = 0;
	    String sql = "delete from note where Nid='" + Nid + "'";
	    PreparedStatement pstmt;
	    try {
	        pstmt = (PreparedStatement) conn.prepareStatement(sql);
	        i = pstmt.executeUpdate();
	        pstmt.close();
	        conn.close();
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    return i;
	}
}

