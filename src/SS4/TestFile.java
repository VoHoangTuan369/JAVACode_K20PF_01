package SS4;

import com.company.Employees;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

public class TestFile {
    public static void main(String[] args) {
        ArrayList<Employees> ar = new ArrayList<>();
        ar.add(new Employees("E005","Nguyen A","211"));
        ar.add(new Employees("E006","Nguyen B","212"));
        ar.add(new Employees("E007","Nguyen C","213"));
        File f = new File("employees.txt");
        try {
            FileWriter fw = new FileWriter(f);
            PrintWriter pw = new PrintWriter(fw);
            for (Employees x: ar ){
                pw.println(x.getId()+"," + x.getName()+"," + x.getSalary());
            }
            pw.close();
            fw.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
