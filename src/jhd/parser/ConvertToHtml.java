package jhd.parser;

import java.util.Vector;

import jhd.util.ColorTemplate;
import jhd.util.ColorTemplates;
import jhd.util.FileList;

public class ConvertToHtml {

  private String[] list;
  private String templateName;
  private Vector fileList;

  public ConvertToHtml(String[] s) {
    this.list = s;
    this.templateName = "kawa";
    fileList = new Vector();

    if (s.length <= 0) {
      System.out.println("Error:");
      System.out.println("Syntax: Main [template name] <list of files>");
      System.exit(1);
    }
  }

  public void convertToHtml() {
    check();
    ParserApp p = new ParserApp(templateName);
    System.out.println("Converting Files....");
    System.out.println(fileList.size());
    for (int i = 0; i < fileList.size(); i++) {
      String s = fileList.get(i).toString();
      p.convert(s);
    }
  }

  private void check() {
    String s = list[0];
    int start = -1;

    ColorTemplate t = ColorTemplates.get(s);

    if (t != null) {
      templateName = s;
      start = 1;
    }
    else {
      start = 0;

    }
    FileList l = new FileList();

    for (int i = start; i < list.length; i++) {
      Vector v = l.getFileList(list[i]);
      System.out.println(v);
      fileList.addAll(v);
    }
  }
}
