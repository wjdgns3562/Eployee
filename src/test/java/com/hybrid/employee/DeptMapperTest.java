package com.hybrid.employee;

import java.util.List;
import java.util.function.Consumer;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.context.support.GenericXmlApplicationContext;

import com.hybrid.mapper.DeptMapper;
import com.hybrid.model.Dept;


public class DeptMapperTest {
	static Log log = LogFactory.getLog(DeptMapperTest.class);
	public static void main(String[] args) {
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext("spring/beans_oracle.xml");
		
		DeptMapper deptMapper = ctx.getBean(DeptMapper.class);
		
		List<Dept> list = deptMapper.selectAll();
		
		list.forEach(new Consumer<Dept>() {
			@Override
			public void accept(Dept t) {
				String msg = t.getDeptno()+" "
						   + t.getDname()+" "
						   + t.getLoc();
				log.info(msg);				
			}
		});
		
		Dept dept = deptMapper.selectByDeptno(20);
		
		String msg = dept.getDeptno()+" "
				   + dept.getDname()+" "
				   + dept.getLoc();
		log.info(msg);

	}

}
