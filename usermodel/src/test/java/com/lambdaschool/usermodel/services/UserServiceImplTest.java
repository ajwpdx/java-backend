package com.lambdaschool.usermodel.services;

import com.lambdaschool.usermodel.UserModelApplication;
import com.lambdaschool.usermodel.exceptions.ResourceNotFoundException;
import com.lambdaschool.usermodel.models.Role;
import com.lambdaschool.usermodel.models.User;
import com.lambdaschool.usermodel.models.UserRoles;
import com.lambdaschool.usermodel.repository.UserRepository;
import org.junit.After;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.*;


@RunWith(SpringRunner.class)
@SpringBootTest(classes = UserModelApplication.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class UserServiceImplTest
{


    @Autowired
    private UserService userService;

    @Before
    public void setUp() throws Exception
    {

        MockitoAnnotations.initMocks(this);

        List<User> myList = userService.findAll();
        for (User u: myList)
        {
            System.out.println(u.getUserid() + " + " + u.getUsername());
        }
    }

    @After
    public void tearDown() throws Exception
    {
    }

    @Test
    public void a_findUserById()
    {
        assertEquals("admin", userService.findUserById(3).getUsername());
    }

    @Test(expected = ResourceNotFoundException.class)
    public void aa_findUserByNOTId()
    {
        assertEquals("", userService.findUserById(456).getUsername());
    }

    @Test
    public void b_findByNameContaining()
    {
    }

    @Test
    public void c_findAll()
    {
        assertEquals(6, userService.findAll().size());
    }

    @Test
    public void d_delete()
    {
    }

    @Test
    public void e_findByName()
    {
    }

    @Test
    public void f_save()
    {
        User saveUser = new User();

        saveUser.setUsername("ajwpdx");
        saveUser.setPasswordNoEncrypt("password");

        saveUser.setUserid(22);

        saveUser = userService.save(saveUser);

        assertEquals(saveUser.getUsername(), "ajwpdx");
    }

    @Test
    public void g_update()
    {
    }

    @Test
    public void h_deleteAll()
    {
    }
}