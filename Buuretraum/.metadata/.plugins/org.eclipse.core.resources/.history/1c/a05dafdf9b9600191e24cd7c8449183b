package Sprites;

public class FarmPlot {

    public String type;
    private PlantFeatures thePlant;

    public void plant(String plantName) {
        harvest();
        switch (plantName) { //int growrate, String name, int value, int lifespan
        case "Corn": thePlant=new Corn(1, "Corn", 10, 100);  break;
        case "Barley": thePlant=new Barley(1, "Barley", 10, 100);  break;
        }
    }

    public int harvest() {
        int totalMoney;
        if(thePlant.getHeight() == thePlant.getMaxheight()) {
            totalMoney=(thePlant.getHeight()*thePlant.getValue())*2;
        }else {
            totalMoney=thePlant.getHeight()*thePlant.getValue();
        }
        thePlant.setHeight(0);
        return totalMoney;
    }

}