package com.Zosh.projectmanagementsystem.repository;

import com.Zosh.projectmanagementsystem.model.Issue;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IssueRepository extends JpaRepository<Issue,Long> {
}
