package org.jpatterns.ee;

import junit.framework.Assert;

import org.junit.Test;

public class DaoTest {

	private static final String LAST_NAME = "lastName";
	private static final String FIRST_NAME = "firstName";
	private static final String MODIFIED_FIRST_NAME = "firstNameModified";
	private static final String MODIFIED_LAST_NAME = "modifiedLastName";

	class BusinessObject {

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
			ValueObject valueObject = dao.getData();
			valueObject.setFirstName(MODIFIED_FIRST_NAME);
			valueObject.setLastName(MODIFIED_LAST_NAME);
			dao.setData(valueObject);
			return valueObject;
		}

	}

	class DataAccessObject {

		private DataSource ds = new DataSource();

		public ValueObject getData() {
			FullName data = ds.getData();
			return new ValueObject(data.getFirstName(), data.getLastName());
		}

		public void setData(ValueObject valueObject) {
			ds.setData(valueObject);

		}

	}

	class DataSource {

		public FullName getData() {
			return new FullName(FIRST_NAME, LAST_NAME);
		}

		public void setData(ValueObject valueObject) {
			// It would normally persist to the database
		}

	}

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

		public void setFirstName(String firstName) {
			this.firstName = firstName;
		}

		public String getLastName() {
			return lastName;
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
			result = prime * result
					+ ((lastName == null) ? 0 : lastName.hashCode());
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

		ValueObject expected = new ValueObject(FIRST_NAME, LAST_NAME);

		BusinessObject businessObject = new BusinessObject();
		ValueObject valueObject = businessObject.findThatValueObject();
		Assert.assertNotNull(valueObject);
		Assert.assertEquals(expected, valueObject);
	}

	@Test
	public void testUpdateValueObject() {

		ValueObject expected = new ValueObject(MODIFIED_FIRST_NAME,
				MODIFIED_LAST_NAME);

		BusinessObject businessObject = new BusinessObject();
		ValueObject valueObject = businessObject.updateThatValueObject();
		Assert.assertNotNull(valueObject);
		Assert.assertEquals(expected, valueObject);

	}

}
