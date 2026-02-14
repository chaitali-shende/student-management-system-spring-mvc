package com.nit.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.nit.entity.Student;
import com.nit.service.IStudentService;

@Controller
//@RequestMapping("/student")
public class StudentController {
	
	@Autowired
	private IStudentService service;
	
	@GetMapping("/")
	public String showHomePage() {
		return "welcome" ;
	}
	
//	@GetMapping("/stud_list")
//	public String showStudentList(Map<String, Object> map) {
//		Iterable<Student> stud= service.getAllStudents();
//		map.put("stud_list", stud);
//		return "student_list" ;
//	}
	
	@GetMapping("/stud_list")
	public String showStudentList(
	        @PageableDefault(page = 0, size = 3, sort = "id") Pageable pageable,
	        Map<String, Object> map) {

	    Page<Student> page = service.getStudentDataByPage(pageable);

		map.put("studData", page);
	    	
	    return "student_list";
	}

	
    @GetMapping("/add")
    public String showAddForm(Map<String, Object> map, @ModelAttribute("stud") Student student) {
        map.put("student", new Student());
        return "add-student";
    }

    @PostMapping("/save")
    public String saveStudent(@ModelAttribute Student student) {
    	service.addStudent(student);
        return "redirect:/stud_list";
    }

    @GetMapping("/edit")
    public String showEditForm(@RequestParam Long num, Map<String,Object> map) {
        Student student = service.getStudentById(num);
        map.put("student", student);
        return "edit-student";
    }

    @PostMapping("/update")
    public String updateStudent(RedirectAttributes attr,
                                @ModelAttribute("student") Student student) {
        String msg = service.updateStudent(student);
        attr.addFlashAttribute("resultMsg", msg);
        return "redirect:/stud_list";
    }

    @GetMapping("/delete")
    public String deleteStudent(RedirectAttributes attrs,@RequestParam Long num) {
    	String msg= service.deleteStudent(num);
    	attrs.addFlashAttribute("resultMsg", msg);
        return "redirect:/stud_list";
    }
  
//    @GetMapping("/report")
//    public String showStudentReport(@PageableDefault(page=0,size=3,sort="course",direction = Sort.Direction.ASC) Pageable pageable,
//    		Map<String, Object> map) {
//    	System.out.println("StudentController.showStudentReport()");
//    	//Use service
//    	Page<Student> page = service.getStudentDataByPage(pageable);
//    	
//    	//put result in model attribute
//    	map.put("studData", page);
//    	
//    	//return lvn
//    	return "student_report";
//    }
}
