package basics.io;

import java.io.*;

/**
 * Created by rajani.maski on 7/10/17.
 */
public class DataStreamExamples {

    static final String dataFile = "invoicedata";

    static final double[] prices = { 19.99, 9.99, 15.99, 3.99, 4.99 };
    static final int[] units = { 12, 8, 13, 29, 50 };
    static final String[] descs = {
            "Java T-shirt",
            "Java Mug",
            "Duke Juggling Dolls",
            "Java Pin",
            "Java Key Chain"
    };
    public static void main(String[] args) throws IOException{

        DataOutputStream outputStream =
                new DataOutputStream(
                        new BufferedOutputStream(new FileOutputStream(dataFile)));

        for (int i = 0; i <prices.length ; i++) {

            outputStream.writeDouble(prices[i]);
            outputStream.writeInt(units[i]);
            outputStream.writeUTF(descs[i]);
        }
    }


    void readDataStream() throws IOException{
        DataInputStream inputStream = new DataInputStream(
                new BufferedInputStream(
                        new FileInputStream("")));

        try{

            while(true){
                double price = inputStream.readDouble();
                int unit = inputStream.readInt();
            }

        }catch (EOFException eof){

        }
    }



}
