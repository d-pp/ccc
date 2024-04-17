package util;

import java.io.*;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class FileOp {
  private static final String RED = "\u001B[31m";
  private static final String RESET = "\u001B[0m";

  private final String fileName;
  private final BufferedReader in;
  private final PrintWriter out;

  public FileOp(int lvl, int part) {
    String lvlName = STR."level\{lvl}";
    fileName = STR."\{lvlName}_\{part <= 0 ? "example" : String.valueOf(part)}";
    String inPath = Paths.get(STR."\{lvlName}/\{fileName}.in").toString();
    String outPath = Paths.get(STR."\{lvlName}/out/\{fileName}.out").toString();
    try {
      in = new BufferedReader(new FileReader(inPath));
    } catch (FileNotFoundException e) {
      throw new RuntimeException(red(STR."COULDN'T OPEN FILE: \{inPath}"));
    }
    try {
      new File(outPath).getParentFile().mkdirs();
      out = new PrintWriter(outPath);
    } catch (IOException e) {
      throw new RuntimeException(red(STR."COULDN'T CREATE FILE: \{outPath}"));
    }
  }

  // ```###~~~***+++´´´ READ ```+++***~~~###´´´
  public String line() {
    try {
      return in.readLine();
    } catch (IOException e) {
      throw new RuntimeException(e);
    }
  }

  public long lineLong() {
    return Long.parseLong(line());
  }

  public List<Long> lineLongs(String delimiter) {
    List<Long> vals = new ArrayList<>();
    for (String token : line().split(delimiter)) {
      vals.add(Long.parseLong(token));
    }
    return vals;
  }

  public List<String> lines(int n) {
    List<String> lines = new ArrayList<>(n);
    for (int i = 0; i < n; i++) {
      String line = line();
      if (line == null) {
        throw new RuntimeException(red(STR."TRIED TO READ \{n} LINES IN FILE \{fileName}.in, EOF AFTER \{i} LINES"));
      }
      lines.add(line());
    }
    return lines;
  }

  public List<Long> linesLong(int n) {
    List<Long> result = new ArrayList<>(n);
    for (String line : lines(n)) {
      result.add(Long.parseLong(line));
    }
    return result;
  }

  public List<List<Long>> linesLongs(int n, String delimiter) {
    List<List<Long>> vals = new ArrayList<>();
    for (String line : lines(n)) {
      List<Long> row = new ArrayList<>();
      for (String token : line.split(delimiter)) {
        row.add(Long.parseLong(token));
      }
      vals.add(row);
    }
    return vals;
  }

  public List<String> lines() {
    List<String> lines = new ArrayList<>();
    String line = line();
    while (line != null) {
      lines.add(line);
      line = line();
    }
    return lines;
  }

  public List<Long> linesLong() {
    List<Long> result = new ArrayList<>();
    for (String line : lines()) {
      result.add(Long.parseLong(line));
    }
    return result;
  }

  public List<List<Long>> linesLongs(String delimiter) {
    List<List<Long>> vals = new ArrayList<>();
    for (String line : lines()) {
      List<Long> row = new ArrayList<>();
      for (String token : line.split(delimiter)) {
        row.add(Long.parseLong(token));
      }
      vals.add(row);
    }
    return vals;
  }

  public void closeRead() {
    try {
      in.close();
    } catch (IOException e) {
      throw new RuntimeException(red(STR."COULDN'T CLOSE FILE \{fileName}.in"));
    }
  }

  // ```###~~~***+++´´´ WRITE ```+++***~~~###´´´

  public void writeLine(String line) {
    out.println(line);
  }

  public void writeLines(List<String> lines) {
    for (String line : lines) {
      writeLine(line);
    }
  }

  public void closeWrite() {
    out.close();
  }

  // ```###~~~***+++´´´ UTIL ```+++***~~~###´´´
  private String red(String raw) {
    return STR."\{RED}\{raw}\{RESET}";
  }
}