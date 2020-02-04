package lambdas.func_interface;


import lambdas.model.User;

public interface UserFieldValidator {
    /**
     * Validates a field
     * @return null if the field is valid, a String containing the error if it is not
     */
    String validate(User user);

}
