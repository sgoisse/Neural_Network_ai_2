import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {





    public static void main(String[] args) throws IOException {
        Network network = new Network();
        Utils utils = new Utils();
        int trainingSetSize = ((utils.getValues().size())*4)/5;
        ArrayList<ArrayList> trainingSet = new ArrayList(utils.getValues().subList(0, trainingSetSize));
        ArrayList generalisationSet = new ArrayList(utils.getValues().subList(trainingSetSize,utils.getValues().size()));
        while (true) {
            String userChoice = userTyping();
            if (userChoice.equals("training")) {
                Training.train(network, trainingSet);
            }else if (userChoice.equals("classify")) {
                Classification.launcheForwardPropagation(network, generalisationSet);
            } else {
                System.out.println("Wrong entry try again");
            }

        }
    }

    private static String userTyping() {
        System.out.println("type training to train the model or classify to test the classification: ");
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        return str;
    }


}
