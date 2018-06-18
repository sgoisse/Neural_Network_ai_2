import java.util.ArrayList;

public class Network {

private ArrayList<Neurone> layer;

    public ArrayList<ArrayList> getNetwork() {
        return networkMatrice;
    }

    private ArrayList<ArrayList> networkMatrice;


    public Network() {
        networkMatrice = new ArrayList<>();
        constructNetwork();
    }


    public void constructNetwork(){
        ArrayList<Neurone> temp = new ArrayList<>();
        for(int i = 0 ; i< 30; i++){
            InputNeurone inputNeurone = new InputNeurone(0,i);
            temp.add(inputNeurone);
        }

        ArrayList<Neurone> temp2 = new ArrayList<>();
        for(int i = 0 ; i< 30; i++){
            HiddenNeurone hiddenNeurone = new HiddenNeurone(1,i);
            temp2.add(hiddenNeurone);
        }
        ArrayList<Neurone> temp3 = new ArrayList<>();
            OutputNeurone outputNeurone = new OutputNeurone(2,0);
            temp3.add(outputNeurone);

        networkMatrice.add(temp);
        networkMatrice.add(temp2);
        networkMatrice.add(temp3);

    }
}
