package project;

import static org.junit.Assert.*;

import org.junit.Test;

public class AdminTest {

    @Test
    public void testGetUser() {
        Admin admin = new Admin("admin", "password");

        // get right user
        assertEquals("admin", admin.getUser());

        // get wrong user
        assertNotEquals("notAdmin", admin.getUser());
    }

    @Test
    public void testSetUser() {
        Admin admin = new Admin("admin", "password");

        admin.setUser("newAdmin");

        // get right user
        assertEquals("newAdmin", admin.getUser());

        // get old user
        assertNotEquals("admin", admin.getUser());
    }

    @Test
    public void testGetPassword() {
        Admin admin = new Admin("admin", "password");

        // get right password
        assertEquals("password", admin.getPassword());

        // get wrong password
        assertNotEquals("notPassword", admin.getPassword());
    }

    @Test
    public void testSetPassword() {
        Admin admin = new Admin("admin", "password");

        admin.setPassword("newPassword");

        // get right password
        assertEquals("newPassword", admin.getPassword());

        // get old password
        assertNotEquals("password", admin.getPassword());
    }

}
