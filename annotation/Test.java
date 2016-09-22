package com.liang.annotation;

import java.lang.reflect.Field;
import java.lang.reflect.Method;




@Table("user")
public class Test {
	public static void main(String[] args) {
		
		Filter f1=new Filter();
		f1.setId(10);
		
		Filter f2=new Filter();
		f2.setUsername("lucy");
		f2.setAge(18);
		f2.setCity("sz");

		Filter f3=new Filter();
		f3.setEmail("liu@sina.com,zh@163.com,7777@qq.com");//��ѯ����Ϊ����һ�����û�
		
		String sq1=query(f1);
		String sq2=query(f2);
		String sq3=query(f3);
		System.out.println(sq1);
		System.out.println(sq2);
		System.out.println(sq3);
	}

	public static String query(Filter f){
		StringBuilder sb=new StringBuilder();
		//1����ȡclass
		Class c=f.getClass();
		//2.��ȡtable����
		Boolean bl=c.isAnnotationPresent(Table.class);
		if (!bl) {
			return null;
		}
		//������ע��
		Table tb=(Table) c.getAnnotation(Table.class);
		String tbName=tb.value();
		sb.append("select*from ").append(tbName).append(" where 1=1");
		//���������ֶ�
		Field[] fields=c.getDeclaredFields();
		for (Field field : fields) {
			Boolean cl=c.isAnnotationPresent(Table.class);
			if(!cl){
				return null;
			}
			Column column=field.getAnnotation(Column.class);
			//��ȡ�ֶ�ֵ
			String columnName=column.value();
			//��ȡ�ֶ�����
			String filedName = field.getName();
			String getMethodName="get"+filedName.substring(0,1).toUpperCase()+filedName.substring(1);
			Object fieldValue=null;

			try {
				Method getMethod=c.getMethod(getMethodName);
				fieldValue=getMethod.invoke(f);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			//sqlƴ��
			if(fieldValue==null||(fieldValue instanceof Integer &&(Integer)fieldValue==0)){
				continue;
			}
			sb.append(" and ").append(filedName);
			//���ֶν������ͽ��з���
			if(fieldValue instanceof String){
				if(((String) fieldValue).contains(",")){
					String[] values=((String) fieldValue).split(",");
					sb.append(" in(");
					for (String v : values) {
						sb.append("'").append(v).append("',");						
					}
					sb.deleteCharAt(sb.length()-1);
					sb.append(")");					
				}else{
					sb.append(" = ").append(filedName);
				}

			}else if(fieldValue instanceof Integer){
				sb.append(" = ").append(fieldValue);
			}
		
			
		}
		sb.append(";");
		return sb.toString();
	}
	

}
