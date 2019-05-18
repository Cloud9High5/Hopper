import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class IngredientController {
	private IngredientModel m;
	
	public IngredientController(IngredientModel m) {
			this.m = m;
		}
	public static int updateIngredient(IngredientModel ingredient, Integer Sid) {
	    Connection conn = MyDBUtil.getConn();
	    int i = 0;
	    String sql = "update storageingredient set Amount='" + ingredient.getAmount() + "' where Sid='" + Sid + "'";
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
	public static String[] getAllIngredient() {
	    Connection conn = MyDBUtil.getConn();
	    String sql = "select * from storageingredient";
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
}
