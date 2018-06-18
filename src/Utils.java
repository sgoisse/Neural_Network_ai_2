import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Utils {



    public ArrayList<ArrayList> values;

    public Utils() throws IOException {
        values = new ArrayList<>();
        readFile();
    }


    public ArrayList<ArrayList> getValues() {
        //System.out.println(values.get(i).size());
        return values;
    }





    public void readFile() throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("/home/goisse/Documents/Neural_Network_ai_2/src/data.data"));
        String line;
        ArrayList data = new ArrayList();
        while ((line = br.readLine()) != null) {
            String[] test = line.split(",");
            //System.out.println(test);
            data.add(test);
                    }
        br.close();
        System.out.println("close");
        parseData(data);
    }


    private void parseData(ArrayList<String[]> data) {
        for (int j = 0; j < data.size()-1; ++j) {
            ArrayList temp = new ArrayList();
            String[] tempString = data.get(j);
            //System.out.println(Arrays.toString(tempString));
                for(int k = 0; k<2; ++k){
                    temp.add(tempString[k]);
                }
                for (int k = 2; k<tempString.length; ++k){
                    temp.add(Double.parseDouble(tempString[k]));
                }

        values.add(temp);
        }
    }

}
