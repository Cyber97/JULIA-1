package com.erp.controller.users;

import com.erp.common.Encoder;
import com.erp.entity.users.Users;
import com.erp.service.users.UserService;
import javazoom.upload.MultipartFormDataRequest;
import javazoom.upload.UploadBean;
import javazoom.upload.UploadException;
import javazoom.upload.UploadFile;
import net.sf.oval.ConstraintViolation;
import net.sf.oval.Validator;
import org.apache.catalina.realm.GenericPrincipal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.List;

@Controller
@RequestMapping(value = "uc")
public class UserController {

    @Autowired
    UserService userService;

    private MultipartFormDataRequest mrequest;

    @RequestMapping(value = "/b.do")
    public void login(HttpServletRequest request, HttpServletResponse response, @ModelAttribute Users users) throws Exception {
        request.login(request.getParameter("username"),Encoder.getSHA(request.getParameter("password")));
        GenericPrincipal principal = (GenericPrincipal) request.getUserPrincipal();

        if (principal.getRoles()[0].equals("admin")) {

            System.out.println("admin");
        }
        else if (principal.getRoles()[0].equals("users")) {
            System.out.println("users");
        }
        else {

            System.out.println("hoooooo");
        }

    }

    @RequestMapping(value = "/registerUser.do")
    public String registerUser(HttpServletRequest request, HttpServletResponse response, @ModelAttribute Users users ) throws UploadException, IOException {
        mrequest = new MultipartFormDataRequest(request);
        /*OVAL VALIDATOR */
        Validator validator = new Validator();
        List<ConstraintViolation> violationList = validator.validate(users);
        /*because enctype="multipart/form-data" used MultipartFormDataRequest*/
        if (    violationList.size() > 0
                && mrequest.getParameter("password").getBytes("ISO-8859-1") == null && mrequest.getParameter("password").getBytes("ISO-8859-1").equals("")
                && mrequest.getParameter("email").getBytes("ISO-8859-1") == null && mrequest.getParameter("email").getBytes("ISO-8859-1").equals("")
                && mrequest.getFiles() == null && mrequest.getFiles().equals(""))
        {
            return null;
        } else {
            byte[] text = mrequest.getParameter("email").getBytes("ISO-8859-1");
            String  value = new String(text, "UTF-8");
            List<Users> usersList = userService.findEmail(value);
            if (value.equals("") || value == null || usersList.size()>0){
                return "error";
            } else {
                users.setEmail(value);
            }

            text = mrequest.getParameter("password").getBytes("ISO-8859-1");
            value = new String(text, "UTF-8");
            if (value.equals("") || value == null){
                return "error";
            } else {
                try {
                    users.setPassword(Encoder.getSHA(value));
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

            UploadBean upb = new UploadBean();
            upb.setFolderstore("C:/Users/Cyber/Desktop/pic");
            upb.store(mrequest);
            Hashtable files1 = mrequest.getFiles();
            Enumeration e = files1.elements();
            if (files1.size() == 0 ){
                return "error";
            } else {
                while (e.hasMoreElements()) {
                    if ((files1 != null) || (!files1.isEmpty())) {
                        UploadFile file = (UploadFile) e.nextElement();
                        file.getFileName();
                        if (file.getFileName() == null || file.getFileName().equals(""))
                        {
                            return "error";
                        } else {
                            users.setImage(file.getFileName());
                        }
                    }

                }
            }
            //goods.setImage(goods.getImage());
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
            String date = simpleDateFormat.format(new Date());
            users.setDate(date);
            userService.create(users);
            return null;
        }
    }

    @RequestMapping(value = "/registerUserAdmin.do")
    public String registerUserAdmin(HttpServletRequest request, HttpServletResponse response, @ModelAttribute Users users ) throws Exception {

        /*OVAL VALIDATOR */
        Validator validator = new Validator();
        List<ConstraintViolation> violationList = validator.validate(users);
        /*because enctype="multipart/form-data" used MultipartFormDataRequest*/

        List<Users> usersList = userService.findEmail(users.getEmail());
        if (violationList.size() > 0 || usersList.size() > 0) {
            return null;
        } else {
            users.setPassword(Encoder.getSHA(users.getPassword()));
        }
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
        String date = simpleDateFormat.format(new Date());
        users.setDate(date);
        users.setImage("default picture name!");
        userService.create(users);
        return "redirect:/uc/selectUsers.do";
    }

    @RequestMapping(value = "/selectUsers.do")
    public String selectUsers(HttpServletRequest request, HttpServletResponse response, @ModelAttribute Users users)
    {
        request.setAttribute("Users", userService.getAll(Users.class));
        return "admin/users/viewUsers";
    }

    @RequestMapping(value = "findUser.do")
    public String finUser(HttpServletRequest request, @ModelAttribute Users users)
    {
        users = (Users) userService.find(Users.class, Long.valueOf(request.getParameter("id")));
        request.setAttribute("User", users);
        return "admin/users/viewUser";
    }

    @RequestMapping(value = "updateUser.do")
    public String updateUser(HttpServletRequest request,HttpServletResponse response, @ModelAttribute Users users)
    {
        userService.update(users);
        users = (Users) userService.find(Users.class, users.getId());
        return "redirect:/uc/findUser.do?id="+users.getId();
    }

    @RequestMapping(value = "findUserByEmail.do")
    public String findUserByEmail (HttpServletRequest request, @ModelAttribute Users users)
    {
        users = userService.searchEmail(request.getParameter("searchEmail"));
        boolean b = users.getEmail().isEmpty();
        request.setAttribute("User", users);
        return "admin/users/viewUser";
    }
    @RequestMapping(value = "usersReportByDate.do")
    public String usersReportByDate(HttpServletRequest request, @ModelAttribute Users users)
    {
        List<Users> usersList = userService.searchUserByDate(
                request.getParameter("startDate"),
                request.getParameter("endDate")
        );
        request.setAttribute("Users", usersList);
        return "admin/users/viewUsers";
    }
}
