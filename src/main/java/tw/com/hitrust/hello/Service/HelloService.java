package tw.com.hitrust.hello.Service;

import tw.com.hitrust.hello.entity.HelloEntity;

public interface HelloService{
	public HelloEntity read(Integer id);
	public Integer create(HelloEntity helloEntity);
	public HelloEntity update(HelloEntity	helloEntity);
	public void delete(Integer id);
		
}
