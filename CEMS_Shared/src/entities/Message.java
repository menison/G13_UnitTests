package entities;

import java.io.Serializable;

import common.Operation;
import common.Permission;

/**
 *  This class creates a "Message" entity and includes the functions 
 * "get" and "set" to the variables: permission(The permissions that will be sent to the server in the message), Operation and obj.
 *
 */
public class Message implements Serializable {

	private static final long serialVersionUID = 1L;
	private Permission permission;
	private Operation Operation;
	private Object obj;

	public Message(Operation operationType, Object obj, Permission permission) {
		this.Operation = operationType;
		this.obj = obj;
		this.permission = permission;
	}

	public Message(Operation operationType, Object obj) {
		this.Operation = operationType;
		this.obj = obj;
	}
	public Message(Operation operationType,Permission permission) {
		this.Operation=operationType;
		this.permission=permission;
	}

	public Message(Operation operationType) {
		this.Operation = operationType;
	}

	public Operation getOperationType() {
		return Operation;
	}

	public void setOperationType(Operation operationType) {
		this.Operation = operationType;
	}

	public Permission getPermission() {
		return permission;
	}

	public void setPermission(Permission permesion) {
		permission = permesion;
	}

	public Operation getOperation() {
		return Operation;
	}

	public void setOperation(Operation operation) {
		Operation = operation;
	}

	public Object getObj() {
		return obj;
	}

	public void setObj(Object obj) {
		this.obj = obj;
	}

	public String toString() {
		return "Operation " + Operation + " " + obj.toString() + " " + "permission " + permission;
	}

}
