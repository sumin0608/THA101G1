package tw.idv.ixercise.report.entity;




public class ResultMessage {

	public boolean isSystem() {
		return isSystem;
	}
	public void setisSystem(boolean isSystem) {
		this.isSystem = isSystem;
	}
	public Integer getMemberId() {
		return memberId;
	}
	public void setMemberId(Integer memberId) {
		this.memberId = memberId;
	}

	public Object getMessage() {
		return message;
	}
	public void setMessage(Object message) {
		this.message = message;
	}
	public void setMessage(Message message) {
		this.message = message;
	}
	private boolean isSystem;
	private Integer memberId;
	private Object message;
}
