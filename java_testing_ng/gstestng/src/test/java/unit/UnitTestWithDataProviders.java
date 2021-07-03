package unit;

import baseclasses.UnitTestBaseClass;
import com.nimsoc.gs.DuplicateUserException;
import com.nimsoc.gs.UserManager;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class UnitTestWithDataProviders extends UnitTestBaseClass {

  UserManager um;

  @BeforeMethod()
  public void setup() {
    // Arrange
    um = new UserManager();
  }

  @DataProvider
  protected Object[][] invalidEmailProvider() {
    return new Object[][]{
      {"john@emailcom"}
    };
  }

  @Test(dataProvider = "invalidEmailProvider", expectedExceptions = IllegalArgumentException.class)
  public void emptyUserThrowsException(String invalidEmail, String secondParam) throws DuplicateUserException {
    // Act
    boolean result = um.addUser(invalidEmail);

    // Assert
    Assert.assertTrue(result);
  }
}
