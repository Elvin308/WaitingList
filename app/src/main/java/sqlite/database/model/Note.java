package sqlite.database.model;

public class Note {

    public static final String TABLE_NAME = "students";

    public static final String COLUMN_ID = "id";
    public static final String COLUMN_NAME = "name";
    public static final String COLUMN_STUDENT_ID = "studentID";
    public static final String COLUMN_PRIORITY_NUM ="priority";
    public static final String COLUMN_COURSE_NUM ="course";
    public static final String COLUMN_TIMESTAMP = "timestamp";
    public static final String COLUMN_NOTE = "note";

    private int id;
    private String student_id;
    private String name;
    private int priority_num;
    private String course_num;
    private String timestamp;
    private String note;


    // Create table SQL query
    public static final String CREATE_TABLE =
            "CREATE TABLE " + TABLE_NAME + "("
                    + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
                    + COLUMN_NAME + " TEXT,"
                    + COLUMN_STUDENT_ID + " TEXT,"
                    + COLUMN_PRIORITY_NUM +" INTEGER,"
                    + COLUMN_COURSE_NUM +" TEXT,"
                    + COLUMN_NOTE +" TEXT,"
                    + COLUMN_TIMESTAMP + " DATETIME DEFAULT CURRENT_TIMESTAMP"
                    + ")";

    public Note() {
    }

    public Note(int id, String name, String student_id, int priority_num, String course_num, String note, String timestamp) {
        this.id = id;
        this.name=name;
        this.student_id=student_id;
        this.priority_num=priority_num;
        this.course_num=course_num;
        this.note=note;
        this.timestamp = timestamp;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    public int getPriority_num() {
        return priority_num;
    }

    public void setPriority_num(int priority_num) {
        this.priority_num = priority_num;
    }

    public String getCourse_num() {
        return course_num;
    }

    public void setCourse_num(String course_num) {
        this.course_num = course_num;
    }

    public String getStudent_Id() {
        return student_id;
    }

    public void setStudent_Id(String student_id) {
        this.student_id = student_id;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }
}
