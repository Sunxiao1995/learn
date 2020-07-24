package club.banyuan.controller;


import club.banyuan.entity.Address;
import club.banyuan.entity.User;
import club.banyuan.mapper.AddressMapper;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AddressController {
  @Autowired
  private AddressMapper addressMapper;

  @RequestMapping("/Member_Address")
  public String Member_Address(HttpSession session){
    Object obj = session.getAttribute("user");
    User user = null;
    if(obj != null){
      user = (User)obj;
    }
    try {
      Address address = addressMapper.getAddressByUserId(user);
      session.setAttribute("address",address);
    } catch (Exception throwables) {
      throwables.printStackTrace();
    }
    return "Member_Address";
  }

  @RequestMapping("saveAddress")
  public String saveAddress(Address address,Model model){

    try {
      int i = addressMapper.saveAddress(address);
      if (i>0){
        model.addAttribute("success","success");
      }
    } catch (Exception throwables) {
      throwables.printStackTrace();
    }
    return "Member_Address";
  }

}
