package Duke;

import Duke.Task.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Storage {

    private static String storageFilePath;

    public Storage(String filePath) {
        storageFilePath = filePath;
    }

    public void saveData(TaskList taskList) {
        File output = new File(storageFilePath);
        createFile(output);
        try {
            FileWriter fw = new FileWriter(output);
            for (Task t : taskList.getTaskList()) {
                fw.write(t.toString() + "\n");
            }
            fw.close();
        } catch (IOException e) {
            Ui.printSaveDataErrorMessage(e);
        }
    }

    public void importData(Parser parser) throws FileNotFoundException {
        try {
            File input = new File(storageFilePath);
            Scanner s = new Scanner(input);

            while (s.hasNext()) {
                parser.extractCommandFromStorage(s.nextLine());
            }
            Ui.printImportDataSuccessMessage();
        } catch (FileNotFoundException e) {
            Ui.printNoImportDataMessage();
        }
    }

    private static void createFile(File output) {
        try {
            if (output.exists()) {
                Ui.printFileOverwriteMessage();
                return;
            }
            if (!output.getParentFile().exists()) {
                output.getParentFile().mkdirs();
            }
            output.createNewFile();
            Ui.printFileCreatedMessage();
        } catch (IOException e) {
            Ui.printFileCreateErrorMessage(e);
        }
    }

}
