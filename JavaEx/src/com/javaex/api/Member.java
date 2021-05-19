package com.javaex.api;

public class Member implements Comparable {
	String name;
	
	public Member(String name) {
		this.name=name;
	}


	@Override
	public String toString() {
		return "Member [name="+name+"]";
	}
	
	//두 객체의 대소 비교 로직
	@Override
	public int compareTo(Object o) {
		// -1,0,1
		//두 대상이 같으면:0
		//앞의 것이 작으면:-1
		//앞의 것이 큰 경우:1
		//파라미터 o가 Member인지 확인
		if(o instanceof Member) {
			Member other=(Member)o;
			return name.compareTo(other.name);
			//두 객체의 필드 name의 선후 관계를 비교
		}
		return 0;
	}
}
