package tw.com.hitrust.hello.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.tags.form.PasswordInputTag;

import lombok.extern.slf4j.Slf4j;
import tw.com.hitrust.hello.Service.HelloService;
import tw.com.hitrust.hello.entity.HelloEntity;
import tw.com.hitrust.hello.vo.ResHeaderVO;
import tw.com.hitrust.hello.vo.ResponseVO;

@Controller
@RequestMapping("/hi")
@Slf4j
public class HiController {
	
	@Autowired
	private HelloService helloService;
	
	@RequestMapping(value="/hi",method = RequestMethod.PUT)
	@ResponseBody
	public ResponseEntity<ResponseVO<Integer>> create(@RequestBody HelloEntity helloEntity) {
		ResponseVO<Integer> respVO = new ResponseVO<>();
 		ResHeaderVO resHeader = new ResHeaderVO();
 		resHeader.setMethodName(Thread.currentThread() .getStackTrace()[1].getMethodName());
		respVO.setResHeader(resHeader);
		respVO.setResBody(helloService.create(helloEntity));
		log.info(Integer.toString(respVO.getResBody()));
		return new ResponseEntity<ResponseVO<Integer>>(respVO,HttpStatus.OK);
	}
	
	@RequestMapping(value = "/hi",method = RequestMethod.POST)
	@ResponseBody
	public String testC() {
		return "testPOST";
	}
	
	@RequestMapping(value = "/hi",method = RequestMethod.DELETE)
	@ResponseBody
	public String testD() {
		return "testDELETE";
	}
	
	@RequestMapping(value = "/hi",method = RequestMethod.GET)
	@ResponseBody
	public Integer testR() {
		return 1;
	}
	
}
