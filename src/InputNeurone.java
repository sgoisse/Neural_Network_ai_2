import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class InputNeurone extends Neurone {

    public double getData() {
        return data;
    }

    private double data;
    private double[] deltaWeight;

    public InputNeurone(int ln, int pil) {
        super(ln, pil);
        this.data = 0.0;
        this.deltaWeight = new double[30];
        this.outputs = new double[30];
        this.weight = new double[30];
        initialiseWeight();
    }



    @Override
    protected void deltaCalculation(Network network , double expected){
    }


    @Override
    protected void deltaWeightCalculation(double alpha, Network network){
        int i = 0;
        double deltaTemp= 0.0;
        for(Object o : (network.getNetwork().get(1))){
            HiddenNeurone n = (HiddenNeurone) o;
            deltaWeight[i] = ((alpha)*(n.getDelta()*(this.data)));
            i+=1;
        }
    }


    @Override
    protected double activationComputation(Network network) {
        return data;
    }


    private void initialiseWeight() {
        for (int i = 0; i < 30; ++i) {
            this.weight[i]=( Math.random()*( super.getMAX() - super.getMIN() ) ) + super.getMIN();

        }
    }

    private double activationFunction(double x){
        return 1 / (1 + Math.exp((-1)*x));
    }


    @Override
    protected void outputsCalculation(Network network){
        for(int i = 0; i<30 ; ++i){
            outputs[i]= (this.weight[i] * this.data);
        }
    }

    @Override
    protected void setWeight() {
        double newWeight=0.0;
        for(int i = 0; i<30 ; ++i){
            newWeight = this.weight[i] + this.deltaWeight[i];
            this.weight[i]=newWeight;
        }
        //System.out.println(deltaWeight[4]);
    }

    @Override
    protected void setData(double dataIn) {
        this.data = dataIn;
    }


}

