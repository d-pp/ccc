import util.CCC;
import util.FileOp;

import java.util.List;

public class Run {
    public static void main(String[] args) {
        int lvl = CCC.currDir("level");
        // lvl = 1;
        for (int i = 0; i <= 5; i++) {
            FileOp file = new FileOp(lvl, i);
            new Run().run(file.lines(), file);
        }
    }
    
    public void run(List<String> lines, FileOp file) {
    
    }
}
