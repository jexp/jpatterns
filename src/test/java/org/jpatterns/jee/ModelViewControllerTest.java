package org.jpatterns.jee;

import junit.framework.Assert;
import org.junit.Test;

import java.io.*;
import java.util.*;

public class ModelViewControllerTest {

  private static final int HTTP_REQUEST_OK = 200;

  @ModelViewController.View
  class View {

    private final Controller controller = new Controller();

    // This method is usually hidden from the user and part of the framework
    // machinery
    public int processUserRequest(String firstName, String lastName)
        throws IOException {

      HttpServletRequest request = new HttpServletRequest();
      request.setRequestParameter("firstName", firstName);
      request.setRequestParameter("lastName", lastName);

      HttpServletResponse response = new HttpServletResponse();

      controller.processRequest(request, response);

      return HTTP_REQUEST_OK;

    }

  }

  @ModelViewController.Controller
  class Controller {

    private final Model model = new Model();

    public void processRequest(HttpServletRequest request,
                               HttpServletResponse response) throws IOException {

      PersonVO person = new PersonVO();
      person.setFirstName((String) request.getParameter("firstName"));
      person.setLastName((String) request.getParameter("lastName"));

      model.storePerson(person);

    }

  }

  @ModelViewController.Model
  class Model {

    public void storePerson(PersonVO personVo) {
      // Store person to database...
    }

  }

  class PersonVO implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    private String firstName;

    private String lastName;

    public String getFirstName() {
      return firstName;
    }

    public String getLastName() {
      return lastName;
    }

    public void setFirstName(String firstName) {
      this.firstName = firstName;

    }

    public void setLastName(String lastName) {
      this.lastName = lastName;

    }

    @Override
    public int hashCode() {
      final int prime = 31;
      int result = 1;
      result = prime * result
          + ((firstName == null) ? 0 : firstName.hashCode());
      result = prime * result + ((lastName == null) ? 0 : lastName.hashCode());
      return result;
    }

    @Override
    public boolean equals(Object obj) {
      if (this == obj) {
        return true;
      }
      if (obj == null) {
        return false;
      }
      if (getClass() != obj.getClass()) {
        return false;
      }
      PersonVO other = (PersonVO) obj;
      if (firstName == null) {
        if (other.firstName != null) {
          return false;
        }
      } else if (!firstName.equals(other.firstName)) {
        return false;
      }
      if (lastName == null) {
        if (other.lastName != null) {
          return false;
        }
      } else if (!lastName.equals(other.lastName)) {
        return false;
      }
      return true;
    }

  }

  class HttpServletRequest {

    private final Map<String, Object> requestParameters = new HashMap<String, Object>();

    public void setRequestParameter(String key, Object value) {

      requestParameters.put(key, value);

    }

    public Object getParameter(String key) {
      return requestParameters.get(key);
    }

    // Whatever...

  }

  class HttpServletResponse {
    // Whatever...
  }

  @Test
  public void testMvc() throws Exception {

    View view = new View();
    String firstName = "firstName";
    String lastName = "lastName";
    int responseCode = view.processUserRequest(firstName, lastName);
    Assert.assertTrue(HTTP_REQUEST_OK == responseCode);

  }

}
