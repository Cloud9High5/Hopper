import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class RecipeController {
	private RecipeModel m;
	
	public static int insertRecipe(RecipeModel recipe) {
	    Connection conn = MyDBUtil.getConn();
	    int i = 0;
	    String sql = "insert into recipe (name,WaterQuantity,MaltQuantity,HopQuantity,YeastQuantity,SugarQuantity,AdditiveQuantity) values(?,?,?,?,?,?,?)";
	    PreparedStatement pstmt;
	    try {
	    	pstmt = (PreparedStatement) conn.prepareStatement(sql);
	        pstmt.setString(1, recipe.getName());
	        pstmt.setDouble(2, recipe.getWaterQuantity());
	        pstmt.setDouble(3, recipe.getMaltQuantity());
	        pstmt.setDouble(4, recipe.getHopQuantity());
	        pstmt.setDouble(5, recipe.getYeastQuantity());
	        pstmt.setDouble(6, recipe.getSugarQuantity());
	        pstmt.setDouble(7, recipe.getAdditiveQuantity());
	        i = pstmt.executeUpdate();
	        pstmt.close();
	        conn.close();
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    return i;
	}
	public static int updateRecipe(RecipeModel recipe, Integer Rid) {
	    Connection conn = MyDBUtil.getConn();
	    int i = 0;
	    String sql = "update recipe set Name='" + recipe.getName() + 
	    			"', WaterQuantity='" + recipe.getWaterQuantity() + 
	    			"', MaltQuantity='" + recipe.getMaltQuantity() + 
	    			"',HopQuantity='" + recipe.getHopQuantity() + 
	    			"',YeastQuantity='" + recipe.getYeastQuantity() + 
	    			"',SugarQuantity='" + recipe.getSugarQuantity() + 
	    			"',AdditiveQuantity='" + recipe.getAdditiveQuantity() + 
	    			"' where Rid='" + Rid + "'";
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
	public static String[] getAllRecipe() {
	    Connection conn = MyDBUtil.getConn();
	    String sql = "select * from recipe";
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
	public static Integer getNextRecipeId() {
	    Connection conn = MyDBUtil.getConn();
	    String sql = "select Rid from recipe order by Rid desc LIMIT 1";
	    int i = 1;
	    int Rid = 0;
    	String res = "";
	    PreparedStatement pstmt;
	    try {
	        pstmt = (PreparedStatement)conn.prepareStatement(sql);
	        ResultSet rs = pstmt.executeQuery();
	        int col = rs.getMetaData().getColumnCount();
	        while (rs.next()) {
        	    for (i = 1; i <= col; i++) {
        	    	res += rs.getString(i);
	             }
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    Rid = Integer.parseInt(res);
	    return Rid;
	}
	public static int deleteRecipe(Integer Rid) {
	    Connection conn = MyDBUtil.getConn();
	    int i = 0;
	    String sql = "delete from recipe where Rid='" + Rid + "'";
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
