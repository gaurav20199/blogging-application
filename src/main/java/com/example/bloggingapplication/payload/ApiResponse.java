package com.example.bloggingapplication.payload;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class ApiResponse {

	private String message;
	private boolean success;
}