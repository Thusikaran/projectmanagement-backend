package com.Zosh.projectmanagementsystem.service;

import com.Zosh.projectmanagementsystem.model.Chat;
import com.Zosh.projectmanagementsystem.model.Project;
import com.Zosh.projectmanagementsystem.model.User;
import org.springframework.stereotype.Service;

import java.util.List;

public interface ProjectService {
    Project createProject(Project project,User user)throws Exception;

    List<Project> getProjectByTeam(User user,String category,String tags)throws Exception;

    Project getProjectById(Long projectId )throws Exception;

    void deleteProject(Long projectId,Long userId)throws Exception;

    Project updateProject(Project updatedProject,Long id)throws Exception;

    void addUserToProject(Long projectId,Long userId)throws Exception;

    void removeUserFromProject(Long projectId,Long userId)throws Exception;

    Chat getChatByProjectId(Long projectId)throws Exception;

    List<Project> searchProject(String keyword,User user)throws Exception;



}
