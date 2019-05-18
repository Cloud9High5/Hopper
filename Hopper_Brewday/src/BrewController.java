import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.JLabel;
import javax.swing.Timer;

public class BrewController {
	private BrewModel b;
    static long timemillis = System.currentTimeMillis();
	SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	//compare equipment
	public int compareEquipment(Double volumn) {
		EquipmentModel em = new EquipmentModel(null,null);
		EquipmentController ec = new EquipmentController(em);
		String[] equipment = ec.getAllEquipment();
		String[] temp = new String[3];
		Double[] q = new Double[equipment.length];
	
		for(int count= 0;count<equipment.length&&equipment[count]!=null;count++) {
			temp = equipment[count].split("\\|");
				
			q[count] = Double.valueOf(temp[2]);
				//System.out.println(q[count]);
		}
		for(int count = 0;count<equipment.length&&equipment[count]!=null;count++) {
			
			if(q[count]>=volumn) {
					
				return 1;
				}
			
		}
			return 0;
			
		}
	public BrewController(BrewModel b) {
		this.b = b;
	}
	
	public static void setTimer(JLabel time){
		final JLabel varTime = time;
		Timer timeAction = new Timer(1000, new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				long timemillis = System.currentTimeMillis();
				SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				varTime.setText(df.format(new Date(timemillis)));
			}
		});
		timeAction.start();;
	}
	
	
	public static Double[] getIngredientAmount() {//get amount in storage
		
		    Connection conn = MyDBUtil.getConn();
		    String sql = "select * from storageingredient";
		    Double[] ingredientAmount = new Double[6];
		 
		    PreparedStatement pstmt;
		    try {
		        pstmt = (PreparedStatement)conn.prepareStatement(sql);
		        ResultSet rs = pstmt.executeQuery();
		       
		        int j = 0;
		        while (rs.next()) {
		       
	        	    ingredientAmount[j++] =rs.getDouble("Amount");
		        }
		    } catch (SQLException e) {
		        e.printStackTrace();
		    }
		    return ingredientAmount;
	}
		
	
	public int compare(Double[] NeedAmount) {//only compare the amount in storage  with only one recipe
		Double[] amount= BrewController.getIngredientAmount() ;//amount in storage
		//Double[] sub = {0.0,0.0,0.0,0.0,0.0,0.0} ;
		int check=1;
		for(int i = 0;i<6;i++){	
			if(NeedAmount[i]>amount[i]) {
				check=0;
				
			}
		}
		
		return check;
	}
	
	
	public static int insertHistory(HistoryModel history) {
	    Connection conn = MyDBUtil.getConn();
	    int i = 0;
	    String sql = "insert into history (Date,Volume,WaterQuantity,MaltQuantity,HopQuantity,YeastQuantity,SugarQuantity,AdditiveQuantity) values(?,?,?,?,?,?,?,?)";
	    PreparedStatement pstmt;
	    try {
	    	pstmt = (PreparedStatement) conn.prepareStatement(sql);
	    	pstmt.setTimestamp(1, new Timestamp(timemillis));
	    	pstmt.setDouble(2, history.getVolume());
	        pstmt.setDouble(3, history.getWaterQuantity());
	        pstmt.setDouble(4, history.getMaltQuantity());
	        pstmt.setDouble(5, history.getHopQuantity());
	        pstmt.setDouble(6, history.getYeastQuantity());
	        pstmt.setDouble(7, history.getSugarQuantity());
	        pstmt.setDouble(8, history.getAdditiveQuantity());
	        i = pstmt.executeUpdate();
	        pstmt.close();
	        conn.close();
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    return i;
	}
	
	public static String[] getAllHistory() {
	    Connection conn = MyDBUtil.getConn();
	    String sql = "select * from history";
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

	public static ArrayList<RecipeModel> getRecipe() {//get all recipe that store in database
		ArrayList<RecipeModel> recipe = new ArrayList<RecipeModel>();
		Connection conn = MyDBUtil.getConn();
	    String sql = "select * from recipe";
	    //String[] line = new String[100];
	   
	    PreparedStatement pstmt;
	    try {
	        pstmt = (PreparedStatement)conn.prepareStatement(sql);
	        ResultSet rs = pstmt.executeQuery();
	       
	        //create another array
	        rs.last();
	        int row = rs.getRow();
	        rs.beforeFirst();
			RecipeModel[] recipe2 = new RecipeModel[row];
			for(int count=0;count<row;count++) {
				
				recipe2[count] = new RecipeModel();
				
			}
			rs.beforeFirst();
	        int j = 0;
	        while (rs.next()==true && j<row) {
	        	
	        		
        	    	recipe2[j].setID(rs.getInt("Rid"));
        	    	recipe2[j].setName(rs.getString("Name"));
        	    	
        	    	//System.out.println("rs"+rs.getDouble("HopQuantity"));
        	    	
        	    	
        	    	recipe2[j].setWaterQuantity(rs.getDouble("WaterQuantity"));
        	    	recipe2[j].setMaltQuantity(rs.getDouble("MaltQuantity"));
        	    	recipe2[j].setHopQuantity(rs.getDouble("HopQuantity"));
        	    	recipe2[j].setYeastQuantity(rs.getDouble("YeastQuantity"));
        	    	recipe2[j].setSugarQuantity(rs.getDouble("SugarQuantity"));
        	    	recipe2[j].setAdditiveQuantity(rs.getDouble("AdditiveQuantity"));
        	    	
        	    	//System.out.println(recipe2[j].getHopQuantity());
        	    	recipe.add(recipe2[j]);
	            
        	    	j++;
	        }
	        
	        
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    return recipe;

		
	}
	
	public RecipeModel StringtoRecipe(String recipeString) {
		String recipeInfor[] = new String[8]; 
		recipeInfor = recipeString.split("\\|");
		RecipeModel recipe = new RecipeModel();
		
		recipe.setID(Integer.valueOf(recipeInfor[0]));
		recipe.setName(recipeInfor[1]);
		//System.out.println(recipeInfor[2]);
		recipe.setWaterQuantity(Double.valueOf(recipeInfor[2]));
		recipe.setMaltQuantity(Double.valueOf(recipeInfor[3]));
		recipe.setHopQuantity(Double.valueOf(recipeInfor[4]));
		recipe.setYeastQuantity(Double.valueOf(recipeInfor[5]));
		recipe.setSugarQuantity(Double.valueOf(recipeInfor[6]));
		recipe.setAdditiveQuantity(Double.valueOf(recipeInfor[7]));
		return recipe;
	}

	public Double[] convert( RecipeModel recipe){//convert one recipe amount
		
		Double[] NeedAmount = new Double[6];
		
		Double batchsize=b.getBatchSize();
		//batchsize is zero
		NeedAmount[0] = batchsize*recipe.getWaterQuantity();
		NeedAmount[1] = batchsize*recipe.getMaltQuantity();
		NeedAmount[2] = batchsize*recipe.getHopQuantity();
		NeedAmount[3] = batchsize*recipe.getYeastQuantity();
		NeedAmount[4] = batchsize*recipe.getSugarQuantity();
		NeedAmount[5] = batchsize*recipe.getAdditiveQuantity();
		//for(int count = 0;count<NeedAmount.length;count++) {
			//System.out.println(NeedAmount[count]);
		//}
		return NeedAmount;
	}
	
	
	public Double[] sub(RecipeModel recipe) {//subtract the recipe amount from storage amount
		Double batchsize = this.b.getBatchSize();
		Double[] amount= BrewController.getIngredientAmount() ;
		amount[0] = amount[0] -recipe.getWaterQuantity()*batchsize;
		amount[1] = amount[1] -recipe.getMaltQuantity()*batchsize;
		amount[2] = amount[2] -recipe.getHopQuantity()*batchsize;
		amount[3] = amount[3] -recipe.getYeastQuantity()*batchsize;
		amount[4] = amount[4] -recipe.getSugarQuantity()*batchsize;
		amount[5] = amount[5] -recipe.getAdditiveQuantity()*batchsize;
		
		return amount;
	}
	
	
	public static int updateAmount(Double[] NeedAmount) {//update the amount in storage
	  
		Connection conn = MyDBUtil.getConn();
	    int i = 0;
	    
	    
	    String sql = "update storageingredient set Amount= CASE Sid WHEN 1 THEN "
	    +NeedAmount[0]+" WHEN 2 THEN "+NeedAmount[1]+" WHEN 3 THEN "+NeedAmount[2]+
	    " WHEN 4 THEN "+NeedAmount[3]+" WHEN 5 THEN "+NeedAmount[4]+" WHEN 6 THEN "+
	    NeedAmount[5]+" END;"
	    /*+NeedAmount[0]+" where Sid=1;"
	    +"update storageingredient set Amount="+NeedAmount[1]+" where Sid=2;"
	    +"update storageingredient set Amount="+NeedAmount[2]+" where Sid=3;"
	    +"update storageingredient set Amount="+NeedAmount[3]+" where Sid=4;"
	    +"update storageingredient set Amount="+NeedAmount[4]+" where Sid=5;"
	    +"update storageingredient set Amount="+NeedAmount[5]+" where Sid=6;"*/;
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
	
	
	public static ArrayList<RecipeModel> getRecipeByNum(int[] num) {
		
	
			
			
		
		String nums=new String("");
		for(int count =0;count<num.length;count++) {
			
			if(num[count]>-1&&count!=num.length-1) {
				
				nums = nums+num[count]+",";
				
			}else if(num[count]>-1&&count==num.length-1) {
				
				nums =nums+num[count];
			}
			
		}
		//System.out.println(nums);
		ArrayList<RecipeModel> recipe = new ArrayList<RecipeModel>();
		Connection conn = MyDBUtil.getConn();
	    String sql = "select * from recipe where Rid in ("+nums+")";
	    PreparedStatement pstmt;
	    try {
	    	
	    	
	        pstmt = (PreparedStatement)conn.prepareStatement(sql);
	        
	        ResultSet rs = pstmt.executeQuery();
	        //create another array
	        rs.last();
	        int row = rs.getRow();
	        rs.beforeFirst();
			RecipeModel recipe2[] = new RecipeModel[row];
			for(int count = 0;count<row;count++) {
				recipe2[count]=new RecipeModel();
				
			}
			//System.out.println(row);
	        int j = 0;
	        //System.out.println(row);
	        while (rs.next()==true&&j<row) {
	        	//System.out.println(j);
        	    
        	    	recipe2[j].setID(rs.getInt("Rid"));
        	    	recipe2[j].setName(rs.getString("Name"));
        	    	recipe2[j].setWaterQuantity(rs.getDouble("WaterQuantity"));
        	    	recipe2[j].setMaltQuantity(rs.getDouble("MaltQuantity"));
        	    	recipe2[j].setHopQuantity(rs.getDouble("HopQuantity"));
        	    	recipe2[j].setYeastQuantity(rs.getDouble("YeastQuantity"));
        	    	recipe2[j].setSugarQuantity(rs.getDouble("SugarQuantity"));
        	    	recipe2[j].setAdditiveQuantity(rs.getDouble("AdditiveQuantity"));
        	    	
        	    	recipe.add(recipe2[j]);
	             
        	    	j++;
	        }
	        //for(int count = 0;count<row;count++) {
	        	//System.out.println(recipe.get(count).getID());
				
			//}
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    
	    return recipe;
		
		
	}
	
	
	public ArrayList<RecipeModel> recommand() {
		Double batchsize = b.getBatchSize();
		
		ArrayList<RecipeModel> recipe = BrewController.getRecipe();
		Double[][] RecipeAmount = new Double[recipe.size()][6];
		
		int[] recommandRecipe = new int[recipe.size()];
		
	
		for(int i=0;i<recipe.size();i++) {//get recipe percentage
			RecipeAmount[i][0] = recipe.get(i).getWaterQuantity()*batchsize;
			RecipeAmount[i][1] = recipe.get(i).getMaltQuantity()*batchsize;
			RecipeAmount[i][2] = recipe.get(i).getHopQuantity()*batchsize;
			RecipeAmount[i][3] = recipe.get(i).getYeastQuantity()*batchsize;
			RecipeAmount[i][4] = recipe.get(i).getSugarQuantity()*batchsize;
			RecipeAmount[i][5] = recipe.get(i).getAdditiveQuantity()*batchsize;
			//System.out.println(RecipeAmount[i][0] +","+RecipeAmount[i][1] +","+RecipeAmount[i][2] +",");
		}
		
		
		for(int i=0;i<recipe.size();i++) {
			//Double[] sub = new Double[6];
			if(compare(RecipeAmount[i])==1) {
					
				recommandRecipe[i]=recipe.get(i).getID();
				
			}else {
				
				recommandRecipe[i]=-1;
			}
		}
		
		
		
		
		return BrewController.getRecipeByNum(recommandRecipe);
	}
	
	
	public ArrayList<RecipeModel> missing() {
		Double batchsize=b.getBatchSize();
		ArrayList<RecipeModel> recipe = BrewController.getRecipe();
		Double[][] RecipeAmount = new Double[recipe.size()][6];
		
		int[] MissingRecipe = new int[recipe.size()];

		for(int i=0;i<recipe.size();i++) {
			RecipeAmount[i][0] = recipe.get(i).getWaterQuantity()*batchsize;
			RecipeAmount[i][1] = recipe.get(i).getMaltQuantity()*batchsize;
			RecipeAmount[i][2] = recipe.get(i).getHopQuantity()*batchsize;
			RecipeAmount[i][3] = recipe.get(i).getYeastQuantity()*batchsize;
			RecipeAmount[i][4] = recipe.get(i).getSugarQuantity()*batchsize;
			RecipeAmount[i][5] = recipe.get(i).getAdditiveQuantity()*batchsize;
			
		}
		
		
		
		for(int i=0;i<recipe.size();i++) {
			if(compare(RecipeAmount[i])!=1) {
					
				MissingRecipe[i]=recipe.get(i).getID();
			
			}else {
				
				MissingRecipe[i]=-1;
			}
		}
		
		
		return BrewController.getRecipeByNum(MissingRecipe);
		
		
	}
	
	
	public String[] getRecipeString() {
		
		ArrayList<RecipeModel> recipe =  this.b.getRecommandRecipe();
		
		if(recipe==null) {
			return null;
			
		}
		String[] recipeInString = new String[recipe.size()];
		for(int count=0;count<recipe.size();count++) {
			
			recipeInString[count] = recipe.get(count).getID()+"|"+recipe.get(count).getName()+"|"
			+recipe.get(count).getWaterQuantity()+"|"+recipe.get(count).getMaltQuantity()+"|"
			+recipe.get(count).getHopQuantity()+"|"+recipe.get(count).getYeastQuantity()+"|"+
			recipe.get(count).getSugarQuantity()+"|"+recipe.get(count).getAdditiveQuantity();
			
		}
		return recipeInString;
		
	}
	
}