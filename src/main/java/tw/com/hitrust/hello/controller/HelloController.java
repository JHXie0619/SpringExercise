package tw.com.hitrust.hello.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;
import tw.com.hitrust.hello.Service.HelloService;
import tw.com.hitrust.hello.annotation.Hello;
import tw.com.hitrust.hello.entity.HelloEntity;
import tw.com.hitrust.hello.vo.ResHeaderVO;
import tw.com.hitrust.hello.vo.ResponseVO;

@RestController	//@RestController等於@Controller搭配@ResponseBody,建立RESTful Web Service的控制器
@Slf4j
public class HelloController {
	
	@Autowired
	private HelloService helloService;
	
	@GetMapping("/Hello")
	public ResponseEntity<ResponseVO<HelloEntity>> read(@RequestParam Integer id) {
		ResponseVO<HelloEntity> respVO = new ResponseVO<>();
 		ResHeaderVO resHeader = new ResHeaderVO();
 		resHeader.setMethodName(Thread.currentThread() .getStackTrace()[1].getMethodName());
		respVO.setResHeader(resHeader);
		respVO.setResBody(helloService.read(id));
		return new ResponseEntity<ResponseVO<HelloEntity>>(respVO,HttpStatus.OK);
	}
	
	@PostMapping("/Hello")
	public ResponseEntity<ResponseVO<Integer>> create(@RequestBody HelloEntity helloEntity) {
		ResponseVO<Integer> respVO = new ResponseVO<>();
 		ResHeaderVO resHeader = new ResHeaderVO();
 		resHeader.setMethodName(Thread.currentThread() .getStackTrace()[1].getMethodName());
		respVO.setResHeader(resHeader);
		respVO.setResBody(helloService.create(helloEntity));
		log.info(Integer.toString(respVO.getResBody()));
		return new ResponseEntity<ResponseVO<Integer>>(respVO,HttpStatus.OK);
	}
	
	@PutMapping("/Hello")
	public ResponseEntity<ResponseVO<HelloEntity>> update(@RequestBody HelloEntity helloEntity) {
		ResponseVO<HelloEntity> respVO = new ResponseVO<>();
 		ResHeaderVO resHeader = new ResHeaderVO();
 		resHeader.setMethodName(Thread.currentThread() .getStackTrace()[1].getMethodName());
		respVO.setResHeader(resHeader);
		respVO.setResBody(helloService.update(helloEntity));
		return new ResponseEntity<ResponseVO<HelloEntity>>(respVO,HttpStatus.OK);
	}
	
	@DeleteMapping("/Hello")
	@Hello
	public ResponseEntity<ResponseVO<String>> delete(@RequestParam Integer id) {
		ResponseVO<String> respVO = new ResponseVO<>();
 		ResHeaderVO resHeader = new ResHeaderVO();
 		resHeader.setMethodName(Thread.currentThread() .getStackTrace()[1].getMethodName());
		respVO.setResHeader(resHeader);
		helloService.delete(id);
		respVO.setResBody("delete Successed");
		return new ResponseEntity<ResponseVO<String>>(respVO,HttpStatus.OK);
	}
	

}