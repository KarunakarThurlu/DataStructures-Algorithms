package designpatterns;

import java.time.LocalDate;

class Customer {

    private Integer id;
    private String firstName;
    private String lastName;
    private String email;
    private String phoneNumber;
    private LocalDate dob;
    private String gender;

    /**
     * Private constructor.
     * Object can only be created through Builder.
     */
    private Customer(Builder builder) {
        this.id = builder.id;
        this.firstName = builder.firstName;
        this.lastName = builder.lastName;
        this.email = builder.email;
        this.phoneNumber = builder.phoneNumber;
        this.dob = builder.dob;
        this.gender = builder.gender;
    }

    /**
     * Static Nested Builder Class
     */
    public static class Builder {

        private Integer id;
        private String firstName;
        private String lastName;
        private String email;
        private String phoneNumber;
        private LocalDate dob;
        private String gender;

        public Builder id(Integer id) {
            this.id = id;
            return this;
        }

        public Builder firstName(String firstName) {
            this.firstName = firstName;
            return this;
        }

        public Builder lastName(String lastName) {
            this.lastName = lastName;
            return this;
        }

        public Builder email(String email) {
            this.email = email;
            return this;
        }

        public Builder phoneNumber(String phoneNumber) {
            this.phoneNumber = phoneNumber;
            return this;
        }

        public Builder dob(LocalDate dob) {
            this.dob = dob;
            return this;
        }

        public Builder gender(String gender) {
            this.gender = gender;
            return this;
        }

        /**
         * Creates the final Customer object.
         */
        public Customer build() {

            // Example validation
            if (firstName == null || firstName.isBlank()) {
                throw new IllegalArgumentException("First Name is required.");
            }

            if (email == null || email.isBlank()) {
                throw new IllegalArgumentException("Email is required.");
            }

            return new Customer(this);
        }
    }

    @Override
    public String toString() {
    	 return String.format("""
    	            {
    	                id=%d,
    	                firstName='%s',
    	                lastName='%s',
    	                email='%s',
    	                phoneNumber='%s',
    	                dob=%s,
    	                gender='%s'
    	            }
    	            """,
    	            id,
    	            firstName,
    	            lastName,
    	            email,
    	            phoneNumber,
    	            dob,
    	            gender);
    }
}

/**
 * Builder Pattern
 *
 * Intent:
 * Separate the construction of a complex object from its representation,
 * allowing the same construction process to create different representations.
 */
public class BuilderPattern {
	public static void main(String[] args) {
		Customer c = new Customer.Builder().id(2)
				                 .firstName("foo").email("foo@gmail.com").build();
		System.out.println(c);
	}
}
