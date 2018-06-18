import java.util.ArrayList;

public abstract class Classification {



    public static void launcheForwardPropagation(Network network, ArrayList generalisationSet){
        Stat stat = new Stat();
        for(int i = 0; i< generalisationSet.size();++i){
            ArrayList data = selectData(generalisationSet , i);
            forwardPropagation(network, data , stat);
        }
        stat.printStat();
    }


    public static ArrayList selectData(ArrayList generalisationSet , int i) {
        ArrayList data = (ArrayList) generalisationSet.get(i);
        ArrayList dataTemp = new ArrayList( data.subList(2,data.size()));
        return data;
    }

    public static double ECalculation(ArrayList dataTemp ,  double mean) {
        double E = 0.0;
        for( Object a : dataTemp){
            double b = (Double) a;
            E += Math.pow((mean - b),2);
        }
        return E;
    }

    public static double meanCalculation(ArrayList dataTemp) {
        double mean = 0.0;
        for( Object a : dataTemp){
            double b = (Double) a;
            mean += b;
        }
        mean = (mean)/(dataTemp.size());
        return mean;
    }


    public static void forwardPropagation(Network network, ArrayList data, Stat stat){
        setEntryData(network,data);
        for(int i = 0 ; i<3; ++i) {
            for (Object o : network.getNetwork().get(i)) {
                Neurone n = (Neurone) o;
                n.outputsCalculation(network);
            }
        }
        classification(network, data , stat);
    }

    private static void classification(Network network, ArrayList data, Stat stat) {
        OutputNeurone o = (OutputNeurone) network.getNetwork().get(2).get(0);
        double probability = o.outputFinale;
        System.out.println(probability);
        if(probability > 0.5){
            System.out.println("Malin");
            if(data.get(1).equals("M")){
                System.out.println("good classification");
                stat.setGoodClassificationRate(stat.getGoodClassificationRate()+1);
            } else if(data.get(1).equals("B")){
                System.out.println("bad classification");
                stat.setBadClassificationRate(stat.getBadClassificationRate()+1);
                stat.setFalseMalin(stat.getFalseMalin()+1);
            } else {
                System.out.println("error label reading");
            }
        } else if(probability <= 0.5){
            System.out.println("Benin");
            if(data.get(1).equals("B")){
                System.out.println("good classification");
                stat.setGoodClassificationRate(stat.getGoodClassificationRate()+1);
            } else if(data.get(1).equals("M")){
                System.out.println("bad classification");
                stat.setBadClassificationRate(stat.getBadClassificationRate()+1);
                stat.setFalseBenin(stat.getFalseBenin()+1);
            } else {
                System.out.println("error label reading");
            }
        } else {
            System.out.println("error reading proba");
        }
    }

    private static void setEntryData(Network network ,ArrayList data) {
        for(int i = 0; i<30; ++i){
            InputNeurone neurone = (InputNeurone) network.getNetwork().get(0).get(i);
            neurone.setData((Double) data.get(i+2));
        }

    }


}
