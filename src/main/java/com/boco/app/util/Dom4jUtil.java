package com.boco.app.util;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;

public class Dom4jUtil {
	/**
	 * 使用dom4j解析xml格式的数据
	 */
	public static  String jxXML(String result){
		System.out.println(result);
		String json="";
		int num=1;
		Document doc=null;
		Map<String, Object> map=new HashMap<String, Object>();
			try {
				doc=DocumentHelper.parseText(result);
			} catch (DocumentException e) {
				e.printStackTrace();
			}
			//获取到response节点
			Element response_info=doc.getRootElement();
			map=getElement(response_info,map);
			Set<String> keySet=map.keySet();
			for (Iterator<String> it=keySet.iterator();it.hasNext(); ) {
				String key=it.next();
				Object value=map.get(key);
				if (num==1) {
					json=json+"\""+key+"\":\""+value+"\"";			
				} else {
					json=json+","+"\""+key+"\":\""+value+"\"";
				}
				num++;
			}
			json="{"+json+"}";
			System.out.println(json);
			return json;
	}
	
	/**
	 * 遍历节点
	 */
	public  static Map<String, Object> getElement(Element element,Map<String, Object> map){
		//遍历element下子节点
		for (Iterator ie = element.elementIterator(); ie.hasNext();) {
			Element element_son = (Element) ie.next();
			String elementName=element_son.getName();
			System.out.println("节点名称："+elementName);
			map=getElementAttribute(element_son,map);
			getElement(element_son,map);
		}
		return map;
	}
	
	
	/**
	 * 遍历节点的属性
	 */
	public static Map<String, Object> getElementAttribute(Element element,Map<String,Object> map){
		for (Iterator isona = element.attributeIterator(); isona.hasNext();) {
			Attribute attribute = (Attribute) isona.next();
			String attributeName=attribute.getName();
			Object attributeValue=attribute.getValue();
			System.out.println("属性名称："+attributeName+"，属性值："+attributeValue);
			map.put(attributeName, attributeValue);		 
		}
		return map;
	}
}
