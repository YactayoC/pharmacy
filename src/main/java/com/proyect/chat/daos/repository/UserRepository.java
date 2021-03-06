package com.proyect.chat.daos.repository;

import com.proyect.chat.model.speaker.Speaker;

import java.util.List;

public interface UserRepository {
  //create and update (id==null) ? CREATE : UPDATE;
  void save(Speaker speaker);

  //READ
  List<Speaker> list();

  //GET BY _ID
  Speaker list(String _id);

  //there is no DELETE
}
