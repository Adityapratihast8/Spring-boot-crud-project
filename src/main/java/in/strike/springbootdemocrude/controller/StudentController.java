package in.strike.springbootdemocrude.controller;

import in.strike.springbootdemocrude.entity.Student;
import in.strike.springbootdemocrude.service.StudentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.ResponseEntity.*;

@RestController
@RequestMapping("/api/Students")
public class StudentController {

 //.create student
   private StudentService studentService;
    public StudentController(StudentService studentService) {

        this.studentService = studentService;
    }
    @PostMapping("/create")
    public  ResponseEntity<Student> createStudent(@RequestBody Student student){

        Student createdStudent = studentService.createStudent(student);

       //return ok(createdStudent);
        return ResponseEntity.status(201).body(createdStudent);

 }
    //read student GET /API/STUDENT/ID
    @GetMapping("/get/{id}")
    public ResponseEntity<Student> getStudent(@PathVariable Long id){
        Student studentResp = studentService.getStudent(id);
        if(studentResp == null){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
        return ResponseEntity.status(200).body(studentResp);

    }
  //GETall
  @GetMapping("/getAll")
  public ResponseEntity<List<Student>> getAllStudent() {

      List<Student> studentList = studentService.getAllStudent();

      if (studentList.isEmpty()) {
          return ResponseEntity.notFound().build();
      }

      return ResponseEntity.ok(studentList);
  }


    //update  student
    @PutMapping("/update/{id}")
    public ResponseEntity<Student> updateStudent(
            @PathVariable Long id , @RequestBody Student student) {

        Student studentResp = studentService.updateStudent(id , student);

        if (studentResp == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(studentResp);
    }


    //delete student
   @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteStudent(@PathVariable Long id) {
        Boolean isDeleted = studentService.deleteStudent(id);
        if(!isDeleted){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok("Deleted");
   }


}
