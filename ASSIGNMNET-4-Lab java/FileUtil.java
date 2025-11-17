import java.io.*;
import java.util.*;

public class FileUtil {

    public static ArrayList<Student> readStudents(String filename) throws Exception {
        ArrayList<Student> list = new ArrayList<>();
        File file = new File(filename);

        if (!file.exists()) {
            file.createNewFile();  // create empty file
            return list;
        }

        BufferedReader br = new BufferedReader(new FileReader(file));
        String line;

        while ((line = br.readLine()) != null) {
            String[] data = line.split(",");
            if (data.length == 5) {
                Integer roll = Integer.parseInt(data[0]);
                String name = data[1];
                String email = data[2];
                String course = data[3];
                Double marks = Double.parseDouble(data[4]);
                list.add(new Student(roll, name, email, course, marks));
            }
        }
        br.close();
        return list;
    }

    public static void writeStudents(String filename, ArrayList<Student> list) throws Exception {
        BufferedWriter bw = new BufferedWriter(new FileWriter(filename));

        for (Student s : list) {
            bw.write(s.getRollNo() + "," + s.getName() + "," +
                     s.getEmail() + "," + s.getCourse() + "," + s.getMarks());
            bw.newLine();
        }

        bw.close();
    }
}
