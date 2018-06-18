import jdk.nashorn.internal.objects.Global;

import java.util.ArrayList;


public abstract class Neurone {


    public double getMAX() {
        return MAX;
    }

    public double getMIN() {
        return MIN;
    }

    private double MAX = 1;
    private double MIN = -1;
    private int layer_number;
    protected int position_in_layer;

    protected double delta;
    protected double[] weight;
    public double[] outputs;
    protected double activation;

    public Neurone(int ln , int pil) {
        layer_number = ln;
        position_in_layer = pil;


}


    protected abstract void deltaCalculation(Network network , double expected);

    protected abstract void deltaWeightCalculation(double alpha , Network network);

    protected abstract double activationComputation(Network network);

    protected abstract void outputsCalculation(Network network);

    protected abstract void setWeight();

    protected abstract void setData(double data);


}
