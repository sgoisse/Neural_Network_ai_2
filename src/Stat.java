public class Stat {

    private  double goodClassificationRate ;
    private  double badClassificationRate ;

    public double getGoodClassificationRate() {
        return goodClassificationRate;
    }

    public void setGoodClassificationRate(double goodClassificationRate) {
        this.goodClassificationRate = goodClassificationRate;
    }

    public double getBadClassificationRate() {
        return badClassificationRate;
    }

    public void setBadClassificationRate(double badClassificationRate) {
        this.badClassificationRate = badClassificationRate;
    }

    public double getFalseBenin() {
        return falseBenin;
    }

    public void setFalseBenin(double falseBenin) {
        this.falseBenin = falseBenin;
    }

    public double getFalseMalin() {
        return falseMalin;
    }

    public void setFalseMalin(double falseMalin) {
        this.falseMalin = falseMalin;
    }

    private  double falseBenin;
    private  double falseMalin;


    public Stat(){
        goodClassificationRate = 0.0;
        badClassificationRate =0.0;
        falseBenin = 0.0;
        falseMalin = 0.0;

    }


    public void printStat() {
        System.out.println("good classification " +this.goodClassificationRate);
        System.out.println("Bad classification " + this.badClassificationRate);
        System.out.println("false benin " + this.falseBenin);
        System.out.println("false Malin " + this.falseMalin);
    }
}
