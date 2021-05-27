package com.cos.blog;

abstract class ProtossUnit {
	abstract void setHp(int hp);
	abstract int getHp();
	abstract int getAttack();
	abstract String getName();
}

class Zealot extends ProtossUnit{
	
	
	public Zealot(String name) {
		this.name = name;
	}
	
	String name;
	int hp = 100;
	int attack = 10;
	@Override
	void setHp(int hp) {
		this.hp = hp;
	}
	@Override
	int getHp() {
		return hp;
	}
	@Override
	int getAttack() {
		return attack;
	}
	@Override
	String getName() {
		// TODO Auto-generated method stub
		return name;
	}
}

class Dragoon extends ProtossUnit{
	public Dragoon(String name) {
		this.name = name;
	}
	
	String name;
	int hp = 100;
	int attack = 20;
	@Override
	void setHp(int hp) {
		this.hp = hp;
	}
	@Override
	int getHp() {
		return hp;
	}
	@Override
	int getAttack() {
		return attack;
	}
	@Override
	String getName() {
		// TODO Auto-generated method stub
		return name;
	}
}

public class Test {
	
	// 질럿 -> 드라군
	static void attack(ProtossUnit p1, ProtossUnit p2) {
		p2.setHp(p2.getHp() - p1.getAttack());
		System.out.println(p2.getName()+"이 공격당했습니다.");
	}
	
	public static void main(String[] args) {
		Zealot z1 = new Zealot("질럿1"); // Zealot, ProtossUnit
		Zealot z2 = new Zealot("질럿2");
		Dragoon d1 = new Dragoon("드라군1");
		
		attack(z1, d1);
		attack(d1, z1);
		attack(z1, z2);
	}
}
