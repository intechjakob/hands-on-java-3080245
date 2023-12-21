package bank;

import javax.security.auth.login.LoginException;

public class Authenticator {

  public static Customer login(String username, String password) throws LoginException {
    Customer customer = DataSource.getCustomer(username);
    if (customer == null) {
      throw new LoginException("Invalid username");
    }
    if (password.equals(customer.getPassword())) {
      customer.setAuthenticated(true);
      return customer;
    } else {
      throw new LoginException("Invalid password");
    }
  }

  public static void Logout(Customer customer) {
    customer.setAuthenticated(false);
  }

}
