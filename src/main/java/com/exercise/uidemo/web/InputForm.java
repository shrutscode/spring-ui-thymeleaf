package com.exercise.uidemo.web;

import javax.validation.constraints.NotEmpty;

@DateRangeConstraint.List({ 
	@DateRangeConstraint(
      date1 = "startDate", 
      date2 = "endDate",
      message = "{error.invaliddaterange}"
    )
})
public class InputForm {
	
	@NotEmpty(message="Start Date cannot be blank")
	private String startDate;	
	
	@NotEmpty(message="End Date cannot be blank")
	private String endDate;

	public String getStartDate() {
		return startDate;
	}

	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

	public String getEndDate() {
		return endDate;
	}

	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}

}
