public interface RecordActions {
    void addStudent();
    void showStudent() throws StudentNotFoundException;
    void saveAll();   // optional: simulate save
}
