import java.util.ArrayList;

public class HiddenNeurone extends Neurone {

    public double getDelta() {
        return delta;
    }


    private double[] deltaWeight;
    private double z;


    public HiddenNeurone(int ln, int pil) {
        super(ln, pil);
        delta = 0.0;
        deltaWeight = new double[1];
        this.outputs = new double[1];
        this.weight = new double[1];
        z = 0.0;
        initialiseWeight();
    }



    private double derivativeActivationFunction(double x){
        //double out =(-1)* Math.exp(((-1)*x)/(1+Math.exp((-1)*x)));
        double out = (activationFunction(x))*(1-activationFunction(x));
        return out;
    }
    @Override
    protected void deltaCalculation(Network network , double expected){
        OutputNeurone n =(OutputNeurone) network.getNetwork().get(2).get(0);
        delta = this.weight[0] * derivativeActivationFunction(this.activation) * n.getDelta();
    }

    @Override
    protected void deltaWeightCalculation(double alpha, Network network){
        OutputNeurone n = (OutputNeurone) network.getNetwork().get(2).get(0);
        deltaWeight[0] = (alpha)*(n.getDelta() * this.z);
        this.weight[0] = this.weight[0] + deltaWeight[0];
    }

    @Override
    protected void setWeight() {
        double newWeight=0.0;
        this.weight[0]= this.weight[0] + this.deltaWeight[0];
        //System.out.println(weight[0]);

    }


    @Override
    protected void setData(double data) {

    }


    private void initialiseWeight(){

           this.weight[0] = ( Math.random()*( super.getMAX() - super.getMIN() ) ) + super.getMIN();


    }

     private double activationFunction(double x){
    return (1 / (1 + Math.exp((-1)*x)));
    }




    @Override
    protected void outputsCalculation(Network network){
        this.activation = activationComputation(network);
        z = activationFunction(this.activation);
        outputs[0] = this.z * weight[0];
    }


    @Override
    protected double activationComputation(Network network) {
        double in = 0.0;
        for(Object o : (network.getNetwork().get(0))){
            InputNeurone n = (InputNeurone) o;
            in += n.outputs[this.position_in_layer];
        }
        return in;

    }


}
