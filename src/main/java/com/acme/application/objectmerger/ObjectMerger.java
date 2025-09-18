package com.acme.application.objectmerger;

import java.beans.PropertyDescriptor;
import java.util.Arrays;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.BeanWrapper;
import org.springframework.beans.BeanWrapperImpl;

public class ObjectMerger {
	public static <T> T merge(T target, T source) {
        BeanUtils.copyProperties(source, target, getNonNullPropertyNames(target));
        return target;
    }
	
	private static String[] getNonNullPropertyNames(Object source) {
	    BeanWrapper beanWrapper = new BeanWrapperImpl(source);
	    return Arrays.stream(beanWrapper.getPropertyDescriptors())
	                 .filter(pd -> beanWrapper.getPropertyValue(pd.getName()) != null)
	                 .map(PropertyDescriptor::getName)
	                 .toArray(String[]::new);
	}
}
