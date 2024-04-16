import util.CCC;
import util.FileOp;

public class Test {
    public static void main(String[] args) {
        int lvl = CCC.currDir("level");
        // lvl = 1;
        FileOp file = new FileOp(lvl, 0);
        new Run().run(file.lines(), file);
    }
}
