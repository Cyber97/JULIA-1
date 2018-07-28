package com.erp.controller.box;

import com.erp.entity.box.Box;
import com.erp.service.box.BoxService;
import net.sf.oval.ConstraintViolation;
import net.sf.oval.Validator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@Controller
@RequestMapping(value = "bc")
public class BoxController {
    @Autowired
    BoxService boxService;

    @RequestMapping(value = "/insertBox.do")
    public String insertBox(HttpServletRequest request, HttpServletResponse response , @ModelAttribute Box box)
    {
        /*OVAL VALIDATOR */
        Validator validator = new Validator();
        List<ConstraintViolation> violationList = validator.validate(box);

        if (violationList.size()>0)
        {
            System.out.println(violationList.get(0).getMessage());
            return "nok";
        }else
        {
            boxService.create(box);
            return "redirect:/bc/selectBox.do";
        }
    }
    /* select for admin roles*/
    @RequestMapping(value = "/selectBoxAdmin.do")
    public String selectBoxAdmin(HttpServletRequest request, HttpServletResponse response , @ModelAttribute Box box)
    {
        request.setAttribute("Boxes", boxService.getAll(Box.class));
        return "admin/box/viewBoxes";
    }

    /* select for user roles*/
    @RequestMapping(value = "/selectBox.do")
    public String selectBox(HttpServletRequest request, HttpServletResponse response , @ModelAttribute Box box)
    {
        request.setAttribute("Boxes", boxService.getAll(Box.class));
        return "users/box/viewBoxes";
    }

    /* find for admin roles*/
    @RequestMapping(value = "/findBoxAdmin.do")
    public String findBoxAdmin(HttpServletRequest request, HttpServletResponse response , @ModelAttribute Box box)
    {
        box = (Box) boxService.find(Box.class, Long.valueOf(request.getParameter("id")));
        request.setAttribute("Box", box);
        return "admin/box/viewBox";
    }

    /* find for user roles*/
    @RequestMapping(value = "/findBox.do")
    public String findBoxUser(HttpServletRequest request, HttpServletResponse response , @ModelAttribute Box box)
    {
        box = (Box) boxService.find(Box.class, Long.valueOf(request.getParameter("id")));
        request.setAttribute("Box", box);
        return "users/box/viewBox";
    }

    @RequestMapping(value = "/updateBox.do")
    public String updateBox(HttpServletRequest request, HttpServletResponse response , @ModelAttribute Box box)
    {
        boxService.update(box);
        box = (Box) boxService.find(Box.class, box.getId());
        return "redirect:/bc/findBoxAdmin.do?id="+box.getId();
    }

    @RequestMapping(value = "/removeBox.do")
    public String removeBox(HttpServletRequest request, HttpServletResponse response , @ModelAttribute Box box)
    {
        box.setId(Long.parseLong(request.getParameter("id")));
        boxService.remove(box);
        return "redirect:/bc/selectBox.do";
    }
}
