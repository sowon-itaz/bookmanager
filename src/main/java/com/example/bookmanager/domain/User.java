package com.example.bookmanager.domain;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor
@Data
@Entity
@Builder
public class User {
	@Id
	@GeneratedValue
	private Long id;
	@NonNull
	private String name;
	@NonNull
	private String email;
	private LocalDateTime createdAt;
	private LocalDateTime updattedAt;	
	
	
}
