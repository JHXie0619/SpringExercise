package tw.com.hitrust.hello.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import tw.com.hitrust.hello.Service.HelloService;
import tw.com.hitrust.hello.entity.HelloEntity;

@RestController	//@RestController等於@Controller搭配@ResponseBody,建立RESTful Web Service的控制器
public class HelloController {
	
	@Autowired
	private HelloService helloService;
	
	@GetMapping("/Hello")
	public HelloEntity read(@RequestParam Integer id) {
		return helloService.read(id);
	}
	
	@PostMapping("/Hello")
	public String create(@RequestBody HelloEntity helloEntity) {
		helloService.create(helloEntity);
		return "Create Successed!";
	}
	
	@PutMapping("/Hello")
	public String update(@RequestBody HelloEntity helloEntity) {
		helloService.update(helloEntity);
		return "Update Successed!";
	}
	
	@DeleteMapping("/Hello")
	public String delete(@RequestParam Integer id) {
		helloService.delete(id);
		return "delete Successed!";
	}
	

}