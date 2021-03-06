package com.proyect.servlets.General;

import com.proyect.modelsDAO.General.UserDAO;
import com.proyect.modelsDTO.General.SaveImage;
import com.proyect.modelsDTO.General.User;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@MultipartConfig
@WebServlet(name = "ServletProfile", value = "/ServletProfile")
public class ServletProfile extends HttpServlet {

  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    
  }

  @Override
  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    Part image = request.getPart("image-profile");
    int id = Integer.parseInt(request.getParameter("id"));

    System.out.println("id = " + id);
    User user = new UserDAO().byId(id);

    String typeUser = (user.getFlag() == 0) ? "client": "employee";
    String pathProfile = new SaveImage().saveImage(image, typeUser);

    //Save in MYSQL
    user.setAvatar(pathProfile);
    new UserDAO().saveAvatar(user);


    HttpSession session = request.getSession();
    session.setAttribute("avatarE",user.getAvatar());
  }
}
