import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import java.sql.ResultSet;
import java.util.Date;

public class BrewModel {
	private Double batchSize = new Double(0.0);
	private Date date ;
	private Date time;
	
	private NoteModel note;
	private RecipeModel recipe;
	private ArrayList<RecipeModel> recommandrecipeList;
	//private storageIngredient ingredient;
	
	public BrewModel(Double batchSize, RecipeModel recipe) {
		if(batchSize == null) {
			
			this.batchSize=0.0;
			this.date=new Date(System.currentTimeMillis());
			this.recipe=recipe;
			
		}
		else if(batchSize>0) {
			this.batchSize=batchSize;
			this.date=new Date(System.currentTimeMillis());
			this.recipe=recipe;
		}
	}
	
	public Double getBatchSize() {
		return this.batchSize;
	}
	public void setBatchSize(Double double1) {
		this.batchSize = double1;
	}
	public void setRecommandRecipe(ArrayList<RecipeModel> recipeList) {
		this.recommandrecipeList = recipeList;
		
	}
	public ArrayList<RecipeModel> getRecommandRecipe() {
		return this.recommandrecipeList;
		
	}
	public void setRecipe(RecipeModel recipe) {
		this.recipe = recipe;
		
	}
	public RecipeModel getRecipe() {
		return this.recipe;
		
	}
	
}

