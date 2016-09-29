package entity;

public class Note {
	private int id;
	
	private String noteName;
	
	private String noteBody;
	
	public Note(int id, String noteName, String noteBody) {
		this.id = id;
		this.noteName = noteName;
		this.noteBody = noteBody;
	}

	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}

	public String getNoteName() {
		return noteName;
	}

	public void setNoteName(String noteName) {
		this.noteName = noteName;
	}

	public String getNoteBody() {
		return noteBody;
	}

	public void setNoteBody(String noteBody) {
		this.noteBody = noteBody;
	}

	@Override
	public String toString() {
		return "Note [id=" + id + ", noteName=" + noteName + ", noteBody=" + noteBody + "]";
	}
}
