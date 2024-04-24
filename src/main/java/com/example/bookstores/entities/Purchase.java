package com.example.bookstores.entities;

import java.time.LocalDate;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.Column;

public class Purchase {
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Column(name = "dataUmowy")
	private LocalDate purchasedate;
}
