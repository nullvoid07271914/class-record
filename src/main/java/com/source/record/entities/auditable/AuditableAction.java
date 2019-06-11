package com.source.record.entities.auditable;

public enum AuditableAction {

	INSERTED("INSERTED"), UPDATED("UPDATED"), DELETED("DELETED");

	private final String action;

	private AuditableAction(String action) {
		this.action = action;
	}

	public String getAction() {
		return action;
	}

	@Override
	public String toString() {
		return action;
	}
}
