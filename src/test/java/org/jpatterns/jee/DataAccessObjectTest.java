package org.jpatterns.jee;

import junit.framework.Assert;
import org.junit.Test;

public class DataAccessObjectTest {

  private static final String LAST_NAME = "lastName";
  private static final String FIRST_NAME = "firstName";
  private static final String MODIFIED_FIRST_NAME = "firstNameModified";
  private static final String MODIFIED_LAST_NAME = "modifiedLastName";

  @DataAccessObjectPattern.BusinessObject
  class BusinessObject {

    @DataAccessObjectPattern.Dao(comment = "Mock dao to simulate connection to the database")
    private final DataAccessObject dao = new DataAccessObject();

    public ValueObject findThatValueObject() {
      return dao.getData();
    }

    /**
     * Updates the {@link ValueObject} and returns the updated version
     *
     * @return The updated value object
     */
    public ValueObject updateThatValueObject() {
      @DataAccessObjectPattern.ValueObject
      ValueObject valueObject = dao.getData();

      valueObject.setFirstName(MODIFIED_FIRST_NAME);
      valueObject.setLastName(MODIFIED_LAST_NAME);
      dao.setData(valueObject);
      return valueObject;
    }

  }

  @DataAccessObjectPattern.Dao
  class DataAccessObject {

    @DataAccessObjectPattern.DataSource(comment = "This is the DataSource which will connect to the database")
    private DataSource ds = new DataSource();

    public ValueObject getData() {
      FullName fullName = ds.getData();
      return new ValueObject(fullName.getFirstName(), fullName.getLastName());
    }

    public void setData(@DataAccessObjectPattern.ValueObject ValueObject valueObject) {
      ds.setData(valueObject);

    }

  }

  @DataAccessObjectPattern.DataSource
  class DataSource {

    public FullName getData() {
      return new FullName(FIRST_NAME, LAST_NAME);
    }

    public void setData(@DataAccessObjectPattern.ValueObject ValueObject valueObject) {
      // It would normally persist to the database
    }

  }

  @DataAccessObjectPattern.ValueObject
  class ValueObject {

    private String firstName;

    private String lastName;

    public ValueObject(String firstName, String lastName) {
      this.firstName = firstName;
      this.lastName = lastName;
    }

    public String getFirstName() {
      return firstName;
    }

    public String getLastName() {
      return lastName;
    }

    public void setLastName(String modifiedLastName) {
      lastName = modifiedLastName;

    }

    public void setFirstName(String modifiedFirstName) {
      firstName = modifiedFirstName;

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
      ValueObject other = (ValueObject) obj;

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

  class FullName {
    private final String firstName;

    private final String lastName;

    public FullName(String firstName, String lastName) {
      this.firstName = firstName;
      this.lastName = lastName;
    }

    public String getFirstName() {
      return firstName;
    }

    public String getLastName() {
      return lastName;
    }
  }

  @Test
  public void testCreateValueObject() {

    @DataAccessObjectPattern.ValueObject
    ValueObject expected = new ValueObject(FIRST_NAME, LAST_NAME);

    @DataAccessObjectPattern.BusinessObject(comment = "This represents the client")
    BusinessObject businessObject = new BusinessObject();

    @DataAccessObjectPattern.ValueObject
    ValueObject valueObject = businessObject.findThatValueObject();

    Assert.assertNotNull(valueObject);
    Assert.assertEquals(expected, valueObject);
  }

  @Test
  public void testUpdateValueObject() {

    @DataAccessObjectPattern.ValueObject(comment = "This represents our expectation")
    ValueObject expected = new ValueObject(MODIFIED_FIRST_NAME,
        MODIFIED_LAST_NAME);

    @DataAccessObjectPattern.BusinessObject(comment = "This represents the client")
    BusinessObject businessObject = new BusinessObject();
    ValueObject valueObject = businessObject.updateThatValueObject();
    Assert.assertNotNull(valueObject);
    Assert.assertEquals(expected, valueObject);

  }

}
