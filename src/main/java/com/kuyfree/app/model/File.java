package com.kuyfree.app.model;

public final class File {

	private Long id;
	private String name;
	private String end_point;
	private String type;
	private String mime_type;
	private String alt_end_point;
	private String status;

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEnd_point() {
		return end_point;
	}

	public void setEnd_point(String end_point) {
		this.end_point = end_point;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getMime_type() {
		return mime_type;
	}

	public void setMime_type(String mime_type) {
		this.mime_type = mime_type;
	}

	public String getAlt_end_point() {
		return alt_end_point;
	}

	public void setAlt_end_point(String alt_end_point) {
		this.alt_end_point = alt_end_point;
	}
}
