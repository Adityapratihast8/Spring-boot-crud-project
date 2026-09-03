package in.strike.springbootdemocrude.service;

import in.strike.springbootdemocrude.entity.Student;
import in.strike.springbootdemocrude.repository.StudentRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service

public class StudentService {
    //1. End pont listen karna (/app/student post)
    //2. Business logic
    //3. Interact with database
    //4. Response back to client (postman)
    private StudentRepository studentRepository;
    public StudentService(StudentRepository studentRepository) {

        this.studentRepository = studentRepository;
    }
    //create student
    public Student createStudent(Student studentReq){
    Student studentResp =  studentRepository.save(studentReq);
    return studentResp;
    }
    //getstudent
    public Student getStudent(Long id){
        Optional<Student> studentResp = studentRepository.findById(id);
        if(studentResp.isPresent()){
            return studentResp.get();
        }
        return null;
    }
    //getall
    public List<Student> getAllStudent() {

        List<Student> studentList = studentRepository.findAll();

        return studentList;
    }
//update
public Student updateStudent(Long id , Student studentReq) {

        Optional<Student> existingStudent = studentRepository.findById(id);

       if (existingStudent.isEmpty()) {
        return null;
       }

       Student studentTosave =  existingStudent.get();
        studentTosave.setName(studentReq.getName());
        studentTosave.setAge(studentReq.getAge());
        studentTosave.setRollNo(studentReq.getRollNo());
        studentTosave.setSubject(studentReq.getSubject());
        studentTosave.setEmail(studentReq.getEmail());
        studentRepository.save(studentTosave);
        return studentTosave;

}
// delete
    public Boolean delteStudent(Long id) {
        Boolean isstudent  = studentRepository.existsById(id);
        if (!isstudent) return false ;
        studentRepository.deleteById(id);
        return true;

    }


}
