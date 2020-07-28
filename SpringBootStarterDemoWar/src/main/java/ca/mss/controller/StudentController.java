package ca.mss.controller;

import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import ca.mss.beans.Student;
import ca.mss.beans.StudentRegistration;
import ca.mss.beans.StudentRegistrationReply;

@Controller
public class StudentController {

	@RequestMapping(method = RequestMethod.GET, value = "/student/allstudent")
	@ResponseBody
	public List<Student> getAllStudents() {
		return StudentRegistration.getInstance().getStudentRecords();
	}

	@RequestMapping(method = RequestMethod.POST, value = "/register/student")
	@ResponseBody
	public StudentRegistrationReply registerStudent(@RequestBody Student student) {
		System.out.println("In registerStudent");
		StudentRegistrationReply stdregreply = new StudentRegistrationReply();
		StudentRegistration.getInstance().add(student);
		// We are setting the below value just to reply a message back to the
		// caller
		stdregreply.setName(student.getName());
		stdregreply.setAge(student.getAge());
		stdregreply.setRegistrationNumber(student.getRegistrationNumber());
		stdregreply.setRegistrationStatus("Successful");
		return stdregreply;
	}

	@RequestMapping(method = RequestMethod.PUT, value = "/update/student")
	@ResponseBody
	public String updateStudentRecord(@RequestBody Student stdn) {
		System.out.println("In updateStudentRecord");
		return StudentRegistration.getInstance().upDateStudent(stdn);
	}

	@RequestMapping(method = RequestMethod.DELETE, value = "/delete/student/{regdNum}")
	@ResponseBody
	public String deleteStudentRecord(@PathVariable("regdNum") String regdNum) {
		System.out.println("In deleteStudentRecord");
		return StudentRegistration.getInstance().deleteStudent(regdNum);
	}
}