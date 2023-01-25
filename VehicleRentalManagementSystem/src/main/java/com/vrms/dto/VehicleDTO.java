package com.vrms.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class VehicleDTO {
	
	@NotNull
	@Size(min=3, max=10, message="Please enter valid User ID.")
	private int vehicleId;
	
	@NotBlank
	@Size(min=10, message="Please enter valid Vehicle Number.")
	private String vehicleNumber;
	
	@NotBlank
	private String type;
	
	@NotBlank
	private String category;
	
	@NotBlank
	private String description;
	
	@NotBlank
	private String location;
	
	@NotBlank
	private String capacity;
	
	@NotNull
	private double chargesPerKM;
	
	@NotNull
	private double fixedCharges;
	
	@NotNull
	private DriverDTO driverDto;

	public VehicleDTO() {}

	public VehicleDTO(@NotNull @Size(min = 3, max = 10, message = "Please enter valid User ID.") int vehicleId,
			@NotBlank @Size(min = 10, message = "Please enter valid Vehicle Number.") String vehicleNumber,
			@NotBlank String type, @NotBlank String category, @NotBlank String description, @NotBlank String location,
			@NotBlank String capacity, @NotNull double chargesPerKM, @NotNull double fixedCharges, DriverDTO driverDto) {
		super();
		this.vehicleId = vehicleId;
		this.vehicleNumber = vehicleNumber;
		this.type = type;
		this.category = category;
		this.description = description;
		this.location = location;
		this.capacity = capacity;
		this.chargesPerKM = chargesPerKM;
		this.fixedCharges = fixedCharges;
		this.driverDto = driverDto;
	}

	public int getVehicleId() {
		return vehicleId;
	}

	public void setVehicleId(int vehicleId) {
		this.vehicleId = vehicleId;
	}

	public String getVehicleNumber() {
		return vehicleNumber;
	}

	public void setVehicleNumber(String vehicleNumber) {
		this.vehicleNumber = vehicleNumber;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getCapacity() {
		return capacity;
	}

	public void setCapacity(String capacity) {
		this.capacity = capacity;
	}

	public double getChargesPerKM() {
		return chargesPerKM;
	}

	public void setChargesPerKM(double chargesPerKM) {
		this.chargesPerKM = chargesPerKM;
	}

	public double getFixedCharges() {
		return fixedCharges;
	}

	public void setFixedCharges(double fixedCharges) {
		this.fixedCharges = fixedCharges;
	}

	public DriverDTO getDriverDto() {
		return driverDto;
	}

	public void setDriverDto(DriverDTO driverDto) {
		this.driverDto = driverDto;
	}

	
}
