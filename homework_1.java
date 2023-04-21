import java.io.FileWriter;
import java.io.IOException;

public class homework_1 {
    public static void main(String[] args) {
        String js = "[{\"фамилия\":\"Иванов\",\"оценка\":\"5\",\"предмет\":\"Математика\"},{\"фамилия\":\"Петрова\",\"оценка\":\"4\",\"предмет\":\"Информатика\"}, {\"фамилия\":\"Краснов\",\"оценка\":\"5\",\"предмет\":\"Физика\"}]";
        String[] records = js.replace("[", "").replace("]", "").split("\\},\\{");

        StringBuilder result = new StringBuilder();

        for (String record : records) {
            String[] fields = record.replace("{", "").replace("}", "").split(",");
            String surname = fields[0].split(":")[1].replace("\"", "");
            String grade = fields[1].split(":")[1].replace("\"", "");
            String subject = fields[2].split(":")[1].replace("\"", "");
            result.append("Студент ")
                    .append(surname)
                    .append(" получил ")
                    .append(grade)
                    .append(" по предмету ")
                    .append(subject)
                    .append(".\n");
        }

        try {
            FileWriter writer = new FileWriter("result.txt");
            writer.write(result.toString());
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}