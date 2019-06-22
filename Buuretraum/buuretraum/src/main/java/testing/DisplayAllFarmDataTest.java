package testing;

import java.util.ArrayList;

import buuretraum.GLOBAL_VARIABLES;
import database.LoadDataSQL;

public class DisplayAllFarmDataTest {

	LoadDataSQL ld;

	public DisplayAllFarmDataTest() {
		// TODO Auto-generated constructor stub
	}

	void loadfarms() {
		ld = new LoadDataSQL();

		String data = ld.loadFarm(GLOBAL_VARIABLES.getInstance().farm);

		// Split into Plots
		String[] stepone = data.split("#");

		ArrayList<String[]> plots = new ArrayList<String[]>();
		if (data.equals("")) {
			return;
		} else {
			// Create Arrays containing plot information and add it to array list
			/**
			 * 0:idPlantPlot 1:Farm_idFarm 2:Plant_idPlant
			 */
			for (String string : stepone) {
				String[] holder = string.split(";");

				String entryToAdd = "";
				for (String strings : holder) {
					entryToAdd += strings;
					entryToAdd += ";";

				}
				entryToAdd += getPlantInfo(holder[2]);
				System.out.println(entryToAdd);
				plots.add(holder);
			}

			// Add Plant Information
		}

	}

	private String getPlantInfo(String plantID) {

		ld = new LoadDataSQL();
		String plantInfo = ld.loadPlant(plantID);

		return plantInfo;

	}
}
