package club.banyuan.controller;


import club.banyuan.entity.Address;
import club.banyuan.entity.User;
import club.banyuan.service.AddressService;
import club.banyuan.service.impl.AddressServiceImpl;
import java.sql.SQLException;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AddressController {
  @Autowired
  private AddressService addressService;

  @RequestMapping("/Member_Address")
  public String Member_Address(HttpSession session){
    Object obj = session.getAttribute("user");
    User user = null;
    if(obj != null){
      user = (User)obj;
    }
    try {
      Address address = addressService.getAddressByUser(user);
      session.setAttribute("address",address);
    } catch (SQLException throwables) {
      throwables.printStackTrace();
    }
    return "Member_Address";
  }

  @RequestMapping("saveAddress")
  public String saveAddress(Address address,Model model){

    try {
      int i = addressService.saveAddress(address);
      if (i>0){
        model.addAttribute("success","success");
      }
    } catch (SQLException throwables) {
      throwables.printStackTrace();
    }
    return "Member_Address";
  }

}