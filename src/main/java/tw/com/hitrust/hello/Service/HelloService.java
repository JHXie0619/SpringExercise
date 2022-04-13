package tw.com.hitrust.hello.Service;

import tw.com.hitrust.hello.entity.HelloEntity;

public interface HelloService{
	public HelloEntity read(Integer id);
	public void create(HelloEntity helloEntity);
	public void update(HelloEntity	helloEntity);
	public void delete(Integer id);
		
}
