import java.sql.Connection;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class EquipmentController {
	public EquipmentController(EquipmentModel n) {
	}
	public static int insertEquipment(EquipmentModel eq) {
		Connection conn = MyDBUtil.getConn();
	    int i = 0;
	    String sql = "insert into equipment (Name,Capacity) values(?,?)";
	    PreparedStatement pstmt;
	    try {
	        pstmt = (PreparedStatement) conn.prepareStatement(sql);
	        pstmt.setString(1, eq.getName());
	        pstmt.setDouble(2, eq.getCapacity());
	        i = pstmt.executeUpdate();
	        pstmt.close();
	        conn.close();
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    return i;
	}
	public static int updateEquipment(EquipmentModel equipment, Integer Eid) {
		Connection conn = MyDBUtil.getConn();
	    int i = 0;
	    String sql = "update equipment set Name='" + equipment.getName() + "', Capacity='" + equipment.getCapacity() + "' where Eid='" + Eid + "'";
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
	public static int deleteEquipment(Integer Eid) {
	    Connection conn = MyDBUtil.getConn();
	    int i = 0;
	    String sql = "delete from equipment where Eid='" + Eid + "'";
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
	public static String[] getAllEquipment() {
	    Connection conn = MyDBUtil.getConn();
	    String sql = "select * from equipment";
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
        	    	System.out.print(rs.getString(i) + " | ");
        	    	res += rs.getString(i) + " | ";
	             }
        	    line[j++] = res;
        	    System.out.println();
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    return line;
	}

}

