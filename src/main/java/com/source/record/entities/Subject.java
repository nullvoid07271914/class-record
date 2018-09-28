package com.source.record.entities;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

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
	private String subjectCode;
	
	@Column(name = "subject_description")
	private String subjectDescription;
	
	@Column(name = "subject_unit")
	private Double unit;
	
	@Column(name = "subject_day")
	private String scheduleDay;
	
	@Column(name = "subject_time_from")
	private String scheduleTimeFrom;
	
	@Column(name = "subject_time_to")
	private String scheduleTimeTo;
	
	@Column(name = "subject_room")
	private String room;

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

	public Double getUnit() {
		return unit;
	}

	public void setUnit(Double unit) {
		this.unit = unit;
	}

	public String getScheduleDay() {
		return scheduleDay;
	}

	public void setScheduleDay(String scheduleDay) {
		this.scheduleDay = scheduleDay;
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

	@Override
	public int hashCode() {
		HashCodeBuilder hashCodeBuilder = new HashCodeBuilder();
		hashCodeBuilder.append(this.getSubjectId());
		hashCodeBuilder.append(this.getSubjectCode());
		
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
			equalsBuilder.append(this.getSubjectId(), subject.getSubjectId());
			equalsBuilder.append(this.getSubjectCode(), subject.getSubjectCode());
			return equalsBuilder.isEquals();
		} else return false;
	}

	@Override
	public String toString() {
		return "Subject [subjectId=" + subjectId + ", subjectCode=" + subjectCode + ", subjectDescription="
				+ subjectDescription + ", unit=" + unit + ", scheduleDay=" + scheduleDay + ", scheduleTimeFrom="
				+ scheduleTimeFrom + ", scheduleTimeTo=" + scheduleTimeTo + ", room=" + room + "]";
	}
}
