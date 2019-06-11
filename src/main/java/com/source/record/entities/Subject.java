package com.source.record.entities;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.hibernate.validator.constraints.NotBlank;

@Entity
@Table(name = "subject_tbl")
public class Subject {
	
	private static final DateFormat DATE_FORMAT = new SimpleDateFormat("HH:mm");

	private static final DateFormat OUTPUT_FORMAT = new SimpleDateFormat("hh:mm aa");

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "subject_id")
	private Long subjectId;
	
	@Column(name = "subject_code")
	@NotBlank(message = "")
	private String subjectCode;
	
	@Column(name = "subject_description")
	@NotBlank(message = "")
	private String subjectDescription;
	
	@Column(name = "subject_unit")
	@NotBlank(message = "")
	private double unit;
	
	@Column(name = "subject_day")
	@NotBlank(message = "")
	private String scheduleDay;
	
	@Column(name = "subject_session")
	private String subjectSession;
	
	@Column(name = "subject_time_from")
	@NotBlank(message = "")
	private String scheduleTimeFrom;
	
	@Column(name = "subject_time_to")
	@NotBlank(message = "")
	private String scheduleTimeTo;
	
	@Column(name = "subject_room")
	@NotBlank(message = "")
	private String room;
	
	@Column(name = "school_year")
	@NotBlank(message = "")
	private String schoolYear;
	
	@Column(name = "semester")
	@NotBlank(message = "")
	private String semester;

	public Long getSubjectId() {
		return subjectId;
	}

	public void setSubjectId(Long subjectId) {
		this.subjectId = subjectId;
	}

	public String getSubjectCode() {
		return subjectCode;
	}

	public void setSubjectCode(String subjectCode) {
		this.subjectCode = subjectCode;
	}

	public String getSubjectDescription() {
		return subjectDescription;
	}

	public void setSubjectDescription(String subjectDescription) {
		this.subjectDescription = subjectDescription;
	}

	public double getUnit() {
		return unit;
	}

	public void setUnit(double unit) {
		this.unit = unit;
	}

	public String getScheduleDay() {
		return scheduleDay;
	}

	public void setScheduleDay(String scheduleDay) {
		this.scheduleDay = scheduleDay;
	}
	
	public String getSubjectSession() {
		return subjectSession;
	}

	public void setSubjectSession(String subjectSession) {
		this.subjectSession = subjectSession;
	}

	public String getScheduleTimeFrom() {
		return scheduleTimeFrom;
	}

	public void setScheduleTimeFrom(String scheduleTimeFrom) {
		Date date = null;
		String output = StringUtils.EMPTY;
		try {
			date = DATE_FORMAT.parse(scheduleTimeFrom);
			output = OUTPUT_FORMAT.format(date);
			this.scheduleTimeFrom = output;
		} catch (ParseException e) { }
	}

	public String getScheduleTimeTo() {
		return scheduleTimeTo;
	}

	public void setScheduleTimeTo(String scheduleTimeTo) {
		Date date = null;
		String output = StringUtils.EMPTY;
		try {
			date = DATE_FORMAT.parse(scheduleTimeTo);
			output = OUTPUT_FORMAT.format(date);
			this.scheduleTimeTo = output;
		} catch (ParseException e) { }
	}

	public String getRoom() {
		return room;
	}

	public void setRoom(String room) {
		this.room = room;
	}

	public String getSchoolYear() {
		return schoolYear;
	}

	public void setSchoolYear(String schoolYear) {
		this.schoolYear = schoolYear;
	}

	public String getSemester() {
		return semester;
	}

	public void setSemester(String semester) {
		this.semester = semester;
	}

	@Override
	public int hashCode() {
		HashCodeBuilder hashCodeBuilder = new HashCodeBuilder();
		hashCodeBuilder.append(this.getSubjectCode());
		hashCodeBuilder.append(this.getSubjectDescription());
		return hashCodeBuilder.toHashCode();
	}

	@Override
	public boolean equals(Object object) {
		if (this == object)
			return true;
		if (object == null)
			return false;
		
		if (object instanceof Subject) {
			EqualsBuilder equalsBuilder = new EqualsBuilder();
			Subject subject = (Subject) object;
			equalsBuilder.append(this.getSubjectCode(), subject.getSubjectCode());
			equalsBuilder.append(this.getSubjectDescription(), subject.getSubjectDescription());
			return equalsBuilder.isEquals();
		}
		
		return false;
	}
}
