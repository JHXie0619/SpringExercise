package tw.com.hitrust.hello.Service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;
import tw.com.hitrust.hello.Repository.HelloRepository;
import tw.com.hitrust.hello.entity.HelloEntity;

@Service
@Slf4j	//自動生成log 
public class HelloServiceImpl implements HelloService{
	
	@Autowired	//啟動時自動建立該介面實作類別的實體
	private HelloRepository helloRepository;
	
	@Override
	public Integer create(HelloEntity helloEntity) {
		log.info(helloEntity.toString());	//顯示log
		return helloRepository.save(helloEntity).getId();
		
	}

	@Override
	public void delete(Integer id) {
		// TODO Auto-generated method stub
		helloRepository.deleteById(id);
	}

	@Override
	public HelloEntity read(Integer id) {
		// TODO Auto-generated method stub
		HelloEntity entity = new HelloEntity();
		entity.setEmpName("NoThisEmp");
		entity.setEmpNumber("0000");
		return helloRepository.findById(id).orElse(entity);	//透過Id查詢資料，該Id無資料回傳orElse內的entity
	}

	@Override
	public HelloEntity update(HelloEntity helloEntity) {
		// TODO Auto-generated method stub
		HelloEntity readEntity = helloRepository.findById(helloEntity.getId()).get();
		readEntity.setEmpName(helloEntity.getEmpName());
		readEntity.setEmpNumber(helloEntity.getEmpNumber());
		helloRepository.save(readEntity);
		return  readEntity;
		 
	}
}
