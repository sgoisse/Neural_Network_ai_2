import java.util.ArrayList;

public class Training {




    public static void train(Network network, ArrayList trainingData){
        Stat stat = new Stat();
        double alpha = 1;
        double expected;
        int iteration = trainingData.size();
        for(int i =0 ; i<iteration ; ++i) {
            ArrayList data = Classification.selectData(trainingData , i);
            Classification.forwardPropagation(network , data, stat);
            expected = labelConverter(data);
            backwardPropagation(alpha , network , expected);
            alpha = alpha - (0.01 *alpha);
        }

    }



    private static double erreurCalculation() {
        return 0.0;
    }

    private static double MSE( double target, double result){
        double temp = 0.5 * Math.pow((target - result),2);
        return temp;

    }


    public static void forwardPropagation(Network network , ArrayList data){
        setEntryData(network,data);
        for(int i = 0 ; i<3 ; ++i){
            for(int j = 0 ; j < network.getNetwork().get(i).size(); ++j){
                Neurone n = (Neurone) network.getNetwork().get(i).get(j);
                n.outputsCalculation(network);
            }
        }
        int i = 0;
        for(Object n : network.getNetwork().get(2)){
            OutputNeurone neu = (OutputNeurone) n;
            //System.out.printf("res %d%n ", i);
           // System.out.println(neu.getOutputFinale());
            i+=1;
        }

    }



    public static void backwardPropagation(double alpha, Network network , double expected){
        for(int i = 2 ; i>=0 ; --i){
            for(Object o : (network.getNetwork().get(i))){
                Neurone n = (Neurone) o;
                n.deltaCalculation(network, expected);
            }
        }
        for(int i = 2 ; i>=0 ; --i){
            for(Object o : (network.getNetwork().get(i))){
                Neurone n = (Neurone) o;
                n.deltaWeightCalculation(alpha,network);
            }
        }
    }


    private static void setEntryData(Network network ,ArrayList data) {
        for(int i = 0; i<30; ++i){
            InputNeurone neurone = (InputNeurone) network.getNetwork().get(0).get(i);
            //System.out.println(data.size());
            neurone.setData((Double) data.get(i+2));
            System.out.println(neurone.getData());

        }

    }




    private static double labelConverter(ArrayList patient) {
        String label = (String) patient.get(1);
        //System.out.println(label);
        double expected = 0.0 ;

        if(label.equals("B")){
            expected = 0.0;
        }
        else if(label.equals("M")){
            expected = 1.0;
        }
        else {
            System.out.println("problem label conversion");
        }
        return expected;
    }



}
