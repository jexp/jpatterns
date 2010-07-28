package org.jpatterns.gof.templatemethod;

import java.io.*;
import java.sql.*;

public class TemplateMethodTest {
  @TemplateMethodPattern(role = TemplateMethodRole.ABSTRACT_CLASS)
  private static abstract class CloseHelper {
    @TemplateMethodPattern(role = TemplateMethodRole.TEMPLATE_METHOD)
    public final Object run(Object[] params) throws Exception {
      setUp(params);
      Exception ex = null;
      try {
        return doExecute(params);
      } catch (Exception ex1) {
        ex = ex1;
      } finally {
        try {
          tearDown(params);
        } catch (Exception ex1) {
          if (ex == null) {
            ex = ex1;
          }
        }
      }
      throw ex;
    }
    @TemplateMethodPattern(role = TemplateMethodRole.PRIMITIVE_METHOD)
    protected abstract void setUp(Object[] params) throws Exception;
    @TemplateMethodPattern(role = TemplateMethodRole.PRIMITIVE_METHOD)
    protected abstract Object doExecute(Object[] params) throws Exception;
    @TemplateMethodPattern(role = TemplateMethodRole.PRIMITIVE_METHOD)
    protected abstract void tearDown(Object[] params) throws Exception;
  }

  @TemplateMethodPattern(role = TemplateMethodRole.CONCRETE_CLASS)
  private static class DBHelper extends CloseHelper {
    private final Connection con;
    private Statement st;

    public DBHelper(Connection con) {
      this.con = con;
    }

    protected void setUp(Object[] params) throws SQLException {
      st = con.createStatement();
    }

    protected Integer doExecute(Object[] params) throws SQLException {
      return st.executeUpdate((String) params[0]);
    }

    protected void tearDown(Object[] params) throws SQLException {
      st.close();
    }
  }

  @TemplateMethodPattern
  private static class FileHelper extends CloseHelper {
    private final String filename;
    private BufferedReader reader;
    public FileHelper(String filename) {
      this.filename = filename;
    }
    protected void setUp(Object[] params) throws FileNotFoundException {
      reader = new BufferedReader(new InputStreamReader(
          new FileInputStream(filename)
      ));
    }
    protected Integer doExecute(Object[] params) throws IOException {
      String s;
      int lines = 0;
      while ((s = reader.readLine()) != null) {
        lines++;
        System.out.printf("%05d: %s%n", lines, s);
      }
      return lines;
    }
    protected void tearDown(Object[] params) throws IOException {
      reader.close();
    }
  }
}
