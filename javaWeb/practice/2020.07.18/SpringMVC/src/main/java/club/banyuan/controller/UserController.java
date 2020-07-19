package club.banyuan.controller;


import club.banyuan.entity.User;
import club.banyuan.service.UserService;
import java.sql.SQLException;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class UserController {

  @Autowired
  private UserService userService;


  @RequestMapping("/")
  public String index(){
    return "index";
  }
  @RequestMapping("/loginPre")
  public String loginPre(){
    return "Login";
  }

  @RequestMapping("/login")
  public String login(HttpSession session, Model model, User user) {

    User user1 = null;
    try {
      user1 = userService.login(user);
    } catch (Exception throwables) {
      throwables.printStackTrace();
    }
    if (user1 != null) {
      session.setAttribute("user", user1);
      return "index";
    }else {
      if("".equals(user.getLoginName()) || "".equals(user.getPassword())){
        model.addAttribute("error","null");
      }else {
        model.addAttribute("error","error");
      }
      return "Login";
    }
  }

  @RequestMapping("/registerPre")
  public String registerPre(){
   return "Regist";
  }

  @RequestMapping("/register")
  public String register(Model model,User user){
    int i = 0;
    try {
      i = userService.register(user);
    } catch (Exception throwables) {
      model.addAttribute("error","error");
      return "Regist";
    }

    if(i>0){
      return "Login";
    }else {
      model.addAttribute("error","error");
      return "Regist";
    }

  }

  @RequestMapping("/logout")
  public String logout(HttpSession session){
    session.invalidate();
    return "index";
  }


  @RequestMapping("Member_User")
  public String Member_User(){
    return "Member_User";
  }


}
