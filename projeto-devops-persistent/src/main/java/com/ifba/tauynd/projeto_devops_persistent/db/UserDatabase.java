package com.ifba.tauynd.projeto_devops_persistent.db;
import org.springframework.data.jpa.repository.JpaRepository;


import com.ifba.tauynd.projeto_devops_persistent.models.User;

public interface UserDatabase extends JpaRepository<User, Integer> {


}