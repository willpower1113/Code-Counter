package impl;

import java.util.ArrayList;
import java.util.List;

import manager.ICounter;

/**
 * 测试用计数器
 * @author Administrator
 *
 */
public class TestCounter implements ICounter {

	List<Long> mValues;

	public TestCounter() {
		// TODO Auto-generated constructor stub
		this.mValues = new ArrayList<>();
	}

	@Override
	public void counter(long num) {
		// TODO Auto-generated method stub
		mValues.add(num);
	}

	@Override
	public long getValue() {
		// TODO Auto-generated method stub
		long value = 0;
		for (Long long1 : mValues) {
			value += long1;
		}
		return value;
	}

}
