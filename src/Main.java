import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Main {

    public static void main(String[] args) {
        File src = new File ("E://Games//src");
        File res = new File ("E://Games//res");
        File savegames = new File ("E://Games//savegames");
        File temp = new File ("E://Games//temp");
        File main = new File ("E://Games//src//main");
        File test = new File ("E://Games//src//test");
        File mainJava = new File (main, "Main.java");
        File utilsJava = new File (main, "Utils.java");
        File drawables = new File ("E://Games//res//drawables");
        File vectors = new File ("E://Games//res//vectors");
        File icons = new File ("E://Games//res//icons");
        File tempTxt = new File (temp, "temp.txt");
        StringBuilder log = new StringBuilder();
        File[] dirList = {src, res, savegames, temp, main, test, drawables, vectors, icons};
        File[] filesList = {mainJava, utilsJava,tempTxt};
        for (var dir : dirList) {
            if (dir.mkdir()) {
                log.append("Каталог ").append(dir).append(" создан\n");
            }
        }
        for (var file : filesList) {
            try {
                if (file.createNewFile()) {
                    log.append("Файл ").append(file).append(" создан\n");
                }
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
        }
        try (FileWriter writer = new FileWriter(tempTxt)) {
            writer.write(String.valueOf(log));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
