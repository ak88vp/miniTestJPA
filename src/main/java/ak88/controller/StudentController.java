package ak88.controller;

import ak88.model.Classzz;
import ak88.model.Student;
import ak88.service.ClasszzService;
import ak88.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.Optional;

@Controller
public class StudentController {
    @Autowired
    ClasszzService classzzService;
    @Autowired
    StudentService studentService;
    @ModelAttribute("class")
    public Iterable<Classzz> classzzes() {
        return classzzService.findAll();
    }
    @GetMapping("")
    public String showList(@PageableDefault(value = 3,sort = "score")Pageable pageable, Model model,String key){
        Page<Student> students;
        if(key==null){
            students =studentService.findAll(pageable);
        }else {
            students=studentService.findByNameContaining(key,pageable);
        }
        model.addAttribute("students",students);
        model.addAttribute("key",key);
        return "/index";
    }
    @GetMapping("edit/{id}")
    public String showEdit(Model model, @PathVariable Long id){
        Optional<Student> student=studentService.findById(id);
        model.addAttribute("student",student.get());
        return "/edit";
    }@PostMapping("edit/{id}")
    public String edit(Long idClasszz, Student student, MultipartFile image){
        String fileName=image.getOriginalFilename();
        try {
            FileCopyUtils.copy(image.getBytes(),new File("D:\\Student\\"+fileName));
        } catch (IOException e) {
            e.printStackTrace();
        }
        Optional<Classzz> classzz = classzzService.findById(idClasszz);
        student.setClasszz(classzz.get());
        student.setImg(fileName);
        studentService.save(student);
        return "redirect:/";

    }
}
