import java.util.ArrayList;

public class OutputNeurone extends Neurone {

    public double outputFinale;

    public double getDelta() {
        return delta;
    }

    @Override
    protected void deltaCalculation(Network network , double expected){
        delta = (((expected) - this.outputFinale) * (derivativeActivationFunction(this.activation)));
        //System.out.println(activation);
        //System.out.println(this.outputFinale);

    }

    private double errorTotalCalculation(Network network, double expected) {
        double temp = 0.0;
        OutputNeurone o = (OutputNeurone) network.getNetwork().get(2).get(0);
        temp += Math.pow((expected- o.outputFinale),2);
        return (0.5 *temp);
    }

    @Override
    protected void deltaWeightCalculation(double alpha, Network network) {

    }

    private double derivativeActivationFunction(double x){
        //double out = (-1)*Math.exp((-x)/(1+Math.exp(-x)));
        double out = (activationFunction(x))*(1-activationFunction(x));
        return out;
    }


    public double getOutputFinale() {
        return outputFinale;
    }



    public OutputNeurone(int ln, int pil) {
        super(ln, pil);


    }



    @Override
    protected void setData(double data) {

    }

    private double activationFunction(double x){
            return 1 / (1 + Math.exp((-1)*x));
        }





    @Override
    protected void outputsCalculation(Network network){
        this.activation = activationComputation(network);
        this.outputFinale = activationFunction(activation);
    }

    @Override
    protected void setWeight() {

    }

    @Override
    protected double activationComputation(Network network) {
        double in = 0.0;
        for(Object o : (network.getNetwork().get(1))){
            Neurone n = (Neurone) o;
            in += n.outputs[this.position_in_layer];
        }
        return in;

    }

}
